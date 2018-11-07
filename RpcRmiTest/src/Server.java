import java.rmi.server.UnicastRemoteObject;
import java.rmi.Naming;
import java.rmi.RemoteException;

import org.jgroups.*;
import org.jgroups.blocks.*;
import org.jgroups.util.*;

public class Server
extends UnicastRemoteObject
implements ServerInterface {

    //RMI
    private static final String SERVICE_NAME = "Server";

    //JGroups
    private static final String CLUSTER_NAME = "RAND_CLUSTER";
    private static final int TIMEOUT = 1000;
    private JChannel channel;
    private RpcDispatcher dispatcher;
    private RequestOptions requestOptions;

    public Server() throws RemoteException {
        super();
        setupRMI();
        setupCluster();
    }

    private void setupRMI() {
        //Bind to the RMI Registry
        try {
            Naming.rebind("rmi://localhost/"+SERVICE_NAME, this);
        } catch(Exception e) {
            System.out.println("[SERVER] Failed to bind");
        }
    }

    private void setupCluster() {
        //Join / Create the JGroups cluster
        try {
            this.channel = new JChannel();
            this.requestOptions = new RequestOptions(ResponseMode.GET_ALL, TIMEOUT);
            this.dispatcher = new RpcDispatcher(this.channel, this);
            this.channel.connect(CLUSTER_NAME);
        } catch(Exception e) {
            System.out.println("[SERVER] Failed to connect to cluster");
        }
    }

    public String getRandom(int min, int max) throws RemoteException {
        try {
            RspList responses = this.dispatcher.callRemoteMethods(  null,
                                                                    "generateRandom",
                                                                    new Object[]{min, max},
                                                                    new Class[]{int.class, int.class},
                                                                    this.requestOptions );
            int value = 0;
            for(Object response : responses.getResults() )
                value += (int)response;

            return Float.toString(value/responses.size());
        } catch(Exception e) {
            System.out.println("[SERVER] Failed to get responses");
        }
        return null;
    }

    public static void main(String args[]) {
        try {
            Server s = new Server();
        } catch(Exception e) {
            System.out.println("[SERVER] FAile to init server");
        }
    }

}
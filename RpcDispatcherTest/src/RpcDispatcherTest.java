import org.jgroups.*;
import org.jgroups.blocks.*;
import org.jgroups.util.*;
import java.util.Random;

public class RpcDispatcherTest {

    private static final String CLUSTER_NAME = "RPC_TESTGROUP";
    private static final int TIMEOUT = 5000;

    private JChannel channel;
    private RpcDispatcher dispatcher;
    private RequestOptions requestOptions;
    private RspList responseList;

    public static int print(int number) throws Exception {
        return ((new Random()).nextInt(100) * number);
    }

    public void start() throws Exception {
        
        //Setup and connect to the channel
        //Also create an RPC Dipatcher linked to the channel
        this.channel = new JChannel();
        this.requestOptions = new RequestOptions(ResponseMode.GET_ALL, TIMEOUT);
        this.dispatcher = new RpcDispatcher(this.channel, this);
        this.channel.connect(CLUSTER_NAME);

        //Call the method 'print' on all Cluster Members
        //Responses are collected in a list (RspList)
        this.responseList = this.dispatcher.callRemoteMethods(null, 
                                                            "print", 
                                                            new Object[]{10}, 
                                                            new Class[]{int.class}, 
                                                            this.requestOptions);
        
        //Print all responses
        System.out.println("Responses: " + this.responseList);

        //Close channel and stop the dispatcher
        this.channel.close();
        this.dispatcher.stop();
    }
    
    public static void main(String args[]) throws Exception {
        new RpcDispatcherTest().start();
    }

}
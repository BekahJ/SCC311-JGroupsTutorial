import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Client {

    //RMI
    private static final String SERVICE_NAME = "Server";

    public static void main(String args[]) throws Exception {
        ServerInterface server = (ServerInterface)Naming.lookup("rmi://localhost/" + SERVICE_NAME);

        System.out.println("[CLIENT] Response: " + server.getRandom(10, 100));
    }

}
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface
extends Remote {

    public String getRandom(int min, int max) throws RemoteException;

}
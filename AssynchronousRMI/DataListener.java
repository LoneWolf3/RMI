
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DataListener extends Remote {
    public void dataAdded(String attraction) throws RemoteException;
}
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


public interface Data extends Remote {
    public void addData(String name) throws RemoteException;
    public List<String> showData() throws RemoteException;
    public void addDataListener(DataListener listener) throws RemoteException;
}
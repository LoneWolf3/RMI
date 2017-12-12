import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GetDate extends Remote {
	public String getDate() throws RemoteException;
}

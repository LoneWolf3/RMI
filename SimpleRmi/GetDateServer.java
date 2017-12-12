import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class GetDateServer extends UnicastRemoteObject implements GetDate {

	protected GetDateServer() throws RemoteException {
		super();
	}

	public String getDate() {
		return new Date().toString();
	}
}

package counterApi;

import java.rmi.*;

public interface Api extends Remote {

	public Data incrementCounter(Data value) throws RemoteException;
	public Data dicriMentCounter(Data value) throws RemoteException;

}
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class GetDateServerMain {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		GetDateServer ms = new GetDateServer();
	
		Naming.rebind("rmi://localhost:1099/GetDate", ms);
		System.out.println("Object registered succesfully");
	}
}

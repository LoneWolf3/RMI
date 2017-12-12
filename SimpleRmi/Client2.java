import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class Client2 {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

		Remote r = Naming.lookup("rmi://localhost:1099/GetDate");
		String s = null;
		if (r instanceof GetDate) {
			GetDate h = (GetDate) r;
			System.out.println(h.getDate());
		}

	}
}

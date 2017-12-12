import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class CallbackClient extends UnicastRemoteObject implements DataListener {

	protected CallbackClient() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void dataAdded(String data) throws RemoteException {
		System.out.println("Data Added:" + data);
	}

	public static void main(String args[]) {
		try {
			DataListener client = new CallbackClient();
			System.out.println("Exporting the client");
			String serverURL = "rmi://127.0.0.1:1099/ServerRMI";
			Data server = (Data) Naming.lookup(serverURL);
			server.addDataListener(client);
			String s;
			while (true) {
				System.out.println("Enter new Data:");
				Scanner sc = new Scanner(System.in);
				s = sc.next();
				if (s != null) {
					server.addData(s);
				}
			}

		} catch (Exception e) {
			System.out.println("Exception occured " + "while adding attraction: " + "\n"
					+ e.getMessage());
		}
	}

}

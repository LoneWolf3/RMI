import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;



public class GetDateClientMain {
	public static void main(String[] args) throws RemoteException,
			java.net.MalformedURLException, java.rmi.NotBoundException {

		Runnable runA = new Runnable() {
			public void run() {
				Remote r = null;
				try {
					r = Naming.lookup("rmi://localhost:1099/GetDate");
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String s = null;
				if (r instanceof GetDate) {
					GetDate h = (GetDate) r;
					try {
						System.out.println(h.getDate());
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};

		Thread threadA = new Thread(runA, "threadA");
		threadA.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException x) {
		}

		Runnable runB = new Runnable() {
			public void run() {
				Remote r = null;
				try {
					r = Naming.lookup("rmi://localhost:1099/GetDate");
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String s = null;
				if (r instanceof GetDate) {
					GetDate h = (GetDate) r;
					try {
						System.out.println(h.getDate());
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};

		Thread threadB = new Thread(runB, "threadB");
		threadB.start();
	}

}

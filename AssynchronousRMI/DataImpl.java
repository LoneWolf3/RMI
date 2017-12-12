import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class DataImpl extends UnicastRemoteObject implements Data {

	private static final long serialVersionUID = 1L;
	private List<String> attractions = new ArrayList<String>();
	private DataListener listener;

	protected DataImpl() throws RemoteException {
		super();
	}

	private void verifyAttraction(String name) {
		Runnable t = new VerifyThread(name);
		new Thread(t).start();
		System.out.println("Verify Thread started");
	}

	private class VerifyThread implements Runnable {

		private String name;

		VerifyThread(String name) {
			this.name = name;
		}

		public void run() {
			try {
				Thread.sleep(2000);
				System.out.println("Finished verifying");
				attractions.add(name);
				if (listener != null)
					listener.dataAdded(name);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (RemoteException e) {
				e.printStackTrace();
			}

		}

	}

	public void addData(String name) throws RemoteException {
		if (name != null) {
			verifyAttraction(name);
		}
	}

	public List<String> showData() throws RemoteException {
		List<String> a = new ArrayList<String>();
		a.addAll(attractions);
		return attractions;
	}

	public void addDataListener(DataListener listener) throws RemoteException {
		this.listener = listener;

	}

}
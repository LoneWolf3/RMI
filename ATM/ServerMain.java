

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ServerMain  {
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		Collection nameBalancePairs = getNameBalancePairs(args);
		Iterator i = nameBalancePairs.iterator();
		while (i.hasNext()) {
			NameBalancePair nextNameBalancePair = (NameBalancePair) i.next();
			launchServer(nextNameBalancePair);
		}
	}

	private static void launchServer(NameBalancePair serverDescription) {
		try {
			Account_Impl newAccount = new Account_Impl(serverDescription.balance);
			Naming.rebind("rmi://localhost:1099/Sachin", newAccount);
			System.out.println("Account " + serverDescription.name
					+ " successfully launched.");
		} catch (Error e) {
		} catch (RemoteException e) {
			System.out.println(e);
		} catch (MalformedURLException e) {
			System.out.println(e);
		}
	}

	private static Collection getNameBalancePairs(String[] args) {
		int i;
		ArrayList returnValue = new ArrayList();
		
			NameBalancePair nextNameBalancePair = new NameBalancePair();
			nextNameBalancePair.name = "Sachin";
			Integer cents = new Integer(100);
			nextNameBalancePair.balance = new Money(cents);
			returnValue.add(nextNameBalancePair);
		
		return returnValue;
	}

	private static class NameBalancePair {
		String name;
		Money balance;
	}
}
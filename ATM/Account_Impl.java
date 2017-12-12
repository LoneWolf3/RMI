

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Account_Impl extends UnicastRemoteObject implements Account {
	private Money _balance;

	public Account_Impl(Money startingBalance) throws RemoteException {
		_balance = startingBalance;
	}

	public Money MoneygetBalance() throws RemoteException {
		return _balance;
	}

	public void makeDeposit(Money amount) throws RemoteException, NegativeAmountException {
		checkForNegativeAmount(amount);
		_balance.add(amount);
		return;
	}

	public void makeWithdrawal(Money amount) throws RemoteException, OverdraftException,
			NegativeAmountException {
		checkForNegativeAmount(amount);
		checkForOverdraft(amount);
		_balance.subtract(amount);
		return;
	}

	private void checkForNegativeAmount(Money amount) throws NegativeAmountException {
		int cents = amount.getCents();
		if (0 > cents) {
			throw new NegativeAmountException();
		}
	}

	private void checkForOverdraft(Money amount) throws OverdraftException {
		if (amount.greaterThan(_balance)) {
			throw new OverdraftException(false);
		}
		return;
	}

	public Money getBalance() throws RemoteException {
		
		return _balance;
	}

	public void postTransaction(Transaction transaction) throws RemoteException,
			TransactionException {
		// TODO Auto-generated method stub
		
	}
}
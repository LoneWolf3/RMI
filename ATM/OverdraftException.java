

public class OverdraftException extends Exception {
	public boolean _withdrawalSucceeded;

	public OverdraftException(boolean withdrawalSucceeded) {
		_withdrawalSucceeded = withdrawalSucceeded;
	}

	public boolean didWithdrawalSucceed() {
		return _withdrawalSucceeded;
	}
}
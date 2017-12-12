


public class Money extends ValueObject {
	private int _cents;

	public Money(Integer cents) {
		this(cents.intValue());
	}

	public Money(int cents) {
		super(cents + " cents.");
		_cents = cents;
	}

	public int getCents() {
		return _cents;
	}

	public void add(Money otherMoney) {
		_cents += otherMoney.getCents();
	}

	public void subtract(Money otherMoney) {
		_cents -= otherMoney.getCents();
	}

	public boolean greaterThan(Money otherMoney) {
		if (_cents > otherMoney.getCents()) {
			return true;
		}
		return false;
	}

	public boolean equals(Object object) {
		if (object instanceof Money) {
			return (_cents == getCents());
		}
		return false;
	}
}
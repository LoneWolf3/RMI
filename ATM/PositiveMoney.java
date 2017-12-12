

public class PositiveMoney extends Money {

	public PositiveMoney(int cents) throws Exception {
		super(cents);

		if ((cents < 0)) {
			throw new Exception("Bad Value for Money");
		}
		return;
	}

}
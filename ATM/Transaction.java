

import java.io.Serializable;

public class Transaction implements Serializable {
	public Money amount;
	public int typeOfTransaction;
	public String whenMade;
}
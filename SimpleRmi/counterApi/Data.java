package counterApi;

import java.io.*;

public class Data {
	//private static final long serialVersionUID = 1L;
	private int value;

	public Data(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
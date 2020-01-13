package square;

public enum CompValues {
	COMPPRICEMIN(400), COMPPRICEMAX(2500), SESSPRICEMIN(100), SESSPRICEMASK(2500), UPPRICEMIN(100),
	UPPRICEMAX(1000), UPLEVELMIN(0), UPLEVELMAX(4), FIELD1LIMIT(2), FIELD2LIMIT(3), FIELD3LIMIT(3), FIELD4LIMIT(2);

	private final int value;

	private CompValues(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
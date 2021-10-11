package ejercicio01;

public class Cornucopia {

	// que ellos apliquen en singleton
	private long consumed = 0;
	private static Cornucopia cornucopia = new Cornucopia();
	private boolean enable = true;


	private Cornucopia() {
		super();
	}
	public long getConsumed() {
		return consumed;
	}
	public boolean isEnable() {
		return enable;
	}
	
	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public static Cornucopia getInstance() {
		return cornucopia;
	}

	public int provide(int amount) {
		if (enable) {
			consumed += amount;
			return amount;
		}
		return 0;
	}

}

public class PetroleumType {
	public static final int DIESEL = 1;
	public static final int GASOLINE = 2;
	private double gasolinePrice=5.23;
	private double dieselPrice=4.02;

	/* no_arg constructor */
	public PetroleumType() {
	}

	/* Return gasolinePrice */
	public double getGasolinePrice() {
		return gasolinePrice;
	}

	/* Set a new gasolinePrice */
	public void setGasolinePrice(double gasolinePrice) {
		this.gasolinePrice = gasolinePrice;
	}

	/* Return dieselPrice */
	public double getDieselPrice() {
		return dieselPrice;
	}

	/* Set a new dieselPrice */
	public void setDieselPrice(double dieselPrice) {
		this.dieselPrice = dieselPrice;
	}
}
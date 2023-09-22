public class Minivan extends Vehicles {

	private int NumberOfSeats;
	private boolean AirConditionON;
	private boolean hasAutoDoors;

	/* constructor */
	public Minivan() {
		super();
	}


	/* Return NumberOfSeats */
	public int getNumberOfSeats() {
		return NumberOfSeats;
	}

	/* Set a new NumberOfSeats */
	public void setNumberOfSeats(int numberOfSeats) {
		NumberOfSeats = numberOfSeats;
	}

	/*
	 * Return AirConditionON. Since AirConditionON is boolean, the get method is
	 * named isAirConditionON()
	 */
	public boolean isAirConditionON() {
		return AirConditionON;
	}

	/* Set a new AirConditionON */
	public void setAirConditionON(boolean airConditionON) {
		AirConditionON = airConditionON;
	}

	/*
	 * Return hasAutoDoors. Since hasAutoDoorsis boolean, the get method is named
	 * isHasAutoDoors()
	 */
	public boolean isHasAutoDoors() {
		return hasAutoDoors;
	}

	/* Set a new HasAutoDoors */
	public void setHasAutoDoors(boolean hasAutoDoors) {
		this.hasAutoDoors = hasAutoDoors;
	}

	/*
	 * Class MiniVan must implement the inherited abstract method Vehicles.
	 * setAirConditionOFF() and setAirConditionON()
	 */
	/* @Override method. */
	@Override
	public void setAirConditionON() {
		this.AirConditionON = true;
	}

	@Override
	public void setAirConditionOFF() {
		this.AirConditionON = false;
	}

	/*
	 * costFor100km:override method that Calculating cost for running 100Kms with
	 * the engine type and the petroleum type passed by as parameter It will be
	 * different according to fuel and air-condition's status.
	 */
	@Override
	public double costFor100km(PetroleumType type) {
		/*
		 * if air-condition of the MiniVan is ON Fuel consumption of the MiniVan
		 * increased by 20%. The MiniVan uses engine of both gasoline and diesel. But
		 * the fuel consumption is same for both gasoline and diesel. we calculate cost
		 * for running 100Kms with Diesel engine
		 */
		if (AirConditionON) {
			costFor100km = (100 / (this.fuel_consumption * 1.2)) * type.getDieselPrice();
		} else { /* when air-condition is OFF we do not multiply by 1.2 */
			costFor100km = (100 / this.fuel_consumption) * type.getDieselPrice();
		}
		return costFor100km;
	}
	/*
	 * Class MiniVan must implement the inherited abstract method
	 * Comparable<Vehicles>.compareTo(Vehicles)
	 */

	@Override
	public int compareTo(Vehicles v) {
		return Double.compare(this.getCostFor100km(), v.getCostFor100km());
	}

	/* toString method displaying all the information */
	@Override
	public String toString() {
		return super.toString() + " , NumberOfSeats=" + NumberOfSeats + ", AirConditionON=" + AirConditionON
				+ ", hasAutoDoors=" + hasAutoDoors ;
	}
}
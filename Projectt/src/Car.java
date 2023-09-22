public class Car extends Vehicles {
	private int NumberOfSeats;
	private boolean AirConditionON = false;

	/* constructor */
	public Car() {
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
	public boolean getisAirConditionON() {
		return AirConditionON;
	}

	/* Set a new AirConditionON */
	public void setAirConditionON(boolean airConditionON) {
		this.AirConditionON = airConditionON;
	}

	/*
	 * Class Car must implement the inherited abstract method Vehicles.
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
		 * if air-condition of the car is ON Fuel consumption of the Car increased by
		 * 10% The Car uses only gasoline engine. we calculate cost for running 100Kms
		 * with Gasoline engine
		 */
		if (AirConditionON) {
			costFor100km = (100 / (this.fuel_consumption * 1.1)) * type.getGasolinePrice();
		} else { /* when air-condition is OFF we do not multiply by 1.1 */
			costFor100km = (100 / this.fuel_consumption) * type.getGasolinePrice();
		}
		return costFor100km;
	}

	/*
	 * Class Car must implement the inherited abstract method
	 * Comparable<Vehicles>.compareTo(Vehicles)
	 */

	@Override
	public int compareTo(Vehicles v) {
		return Double.compare(this.getCostFor100km(), v.getCostFor100km());
	}

	/* toString method displaying all the information */
	@Override
	public String toString() {
		return super.toString() + " , NumberOfSeats=" + NumberOfSeats + ", AirConditionON=" + AirConditionON ;
	}
}

public abstract class Vehicles implements Cloneable, Comparable<Vehicles> {
	/* data fields */
	protected String modelName;
	protected String modelNo;
	protected String brand;
	protected String engineType;
	protected double tunkSize;
	protected double fuel_consumption;
	double costFor100km;
	public Owner owner; // declare Owner of the vehicle (as object)

	/* Return modelName */
	public String getModelName() {
		return modelName;
	}

	/* Set a new modelName */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	/* Return modelNo */
	public String getModelNo() {
		return modelNo;
	}

	/* Set a new modelNo */
	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	/* Return brand */
	public String getBrand() {
		return brand;
	}

	/* Set a new brand */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/* Return engineType */
	public String getEngineType() {
		return engineType;
	}

	/* Set a new engineType */
	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	/* Return tunkSize */
	public double getTunkSize() {
		return tunkSize;
	}

	/* Set a new tunkSize */
	public void setTunkSize(double tunkSize) {
		this.tunkSize = tunkSize;
	}

	/* Return fuel_consumption */
	public double getFuel_consumption() {
		return fuel_consumption;
	}

	/* Set a new fuel_consumption */
	public void setFuel_consumption(double fuel_consumption) {
		this.fuel_consumption = fuel_consumption;
	}

	/* Return the cost For 100km */
	public double getCostFor100km() {
		return costFor100km;
	}

	/* Set a new costFor100km */
	public void setCostFor100km(double costFor100km) {
		this.costFor100km = costFor100km;
	}

	/* Return the owner */
	public Owner getOwner() {
		return owner;
	}

	/* Set a new owner */
	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	/*
	 * costFor100km: abstract method that Calculating cost for running 100Kms with
	 * the engine type and the petroleum type passed by as parameter It will be
	 * different according to fuel and air-condition's status.
	 */
	public abstract double costFor100km(PetroleumType type);

	/*
	 * MovableDistance: method that Getting information of movable distance of a
	 * vehicle when the tank of the vehicle is filled fully. fuel_consumption =
	 * MovableDistance / tunkSize so MovableDistance = fuel_consumption * tunkSize
	 */
	public double MovableDistance() {
		return tunkSize * fuel_consumption;
	}

	/*
	 * abstract method
	 */
	public abstract void setAirConditionON();

	/*
	 * abstract method
	 */
	public abstract void setAirConditionOFF();

	/*
	 * Override the protected clone method defined in the Object class. Clone an
	 * instance of Vehicle object, without cloning the owner of this Vehicle (we set
	 * the owner to null for cloned object)
	 */
	

	@Override
	public Object clone() {
		Vehicles v;
		try {
			v = (Vehicles) super.clone();
			v.owner = (Owner) this.owner;

		} catch (CloneNotSupportedException ex) {
			return null;
		}
		return v;
	}

	/*
	 * toString() method should be implemented in appropriate way in all Vehicle sub
	 * classes displaying all the information including the costFor100Km.
	 */
	@Override
	public String toString() {
		return this.getClass()+ "[modelName=" + modelName + ", modelNo=" + modelNo + ", brand=" + brand + ", engineType="
				+ engineType + ", tunkSize=" + tunkSize + ", fuel_consumption=" + fuel_consumption + ", costFor100km="
				+ costFor100km + " NIS " + ", owner=" + owner + ", MovableDistance=" + MovableDistance() ;
	}
}
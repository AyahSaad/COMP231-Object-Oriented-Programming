import java.util.GregorianCalendar;

public class Owner implements Cloneable {
	String Name;
	String RegisterionNo;
	String Address;
	String Tel;
	java.util.GregorianCalendar DateOfRegistration;

	/* constructor */
	public Owner(String Name) {
		this.Name = Name;
	}

	/* constructor */
	public Owner(String name, String registerionNo, String address, String tel, GregorianCalendar dateOfRegistration) {
		super();
		Name = name;
		RegisterionNo = registerionNo;
		Address = address;
		Tel = tel;
		DateOfRegistration = dateOfRegistration;
	}

	/* Return Name */
	public String getName() {
		return Name;
	}

	/* Set a new Name */
	public void setName(String name) {
		Name = name;
	}

	/* Return RegisterionNo */
	public String getRegisterionNo() {
		return RegisterionNo;
	}

	/* Set a new RegisterionNo */
	public void setRegisterionNo(String registerionNo) {
		RegisterionNo = registerionNo;
	}

	/* Return Address */
	public String getAddress() {
		return Address;
	}

	/* Set a new Address */
	public void setAddress(String address) {
		Address = address;
	}

	/* Return Tel */
	public String getTel() {
		return Tel;
	}

	/* Set a new Tel */
	public void setTel(String tel) {
		Tel = tel;
	}

	/* Return DateOfRegistration */
	public java.util.GregorianCalendar getDateOfRegistration() {
		return DateOfRegistration;
	}

	/* Set a new DateOfRegistration */
	public void setDateOfRegistration(java.util.GregorianCalendar dateOfRegistration) {
		DateOfRegistration = dateOfRegistration;
	}

	/* toString method displaying all the information */
	@Override
	public String toString() {
		return " [Name=" + Name + ", RegisterionNo=" + RegisterionNo + ", Address=" + Address + ", Tel=" + Tel
				+"]";
	}
}
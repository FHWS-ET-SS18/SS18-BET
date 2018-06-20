package clubadmin;

public class PassiveMember extends AMember implements Member{

	public PassiveMember(String name, int age) {
		super(name, age);
	
	}

	@Override
	public double getAnnualFee() {
		if (myClub != null) return myClub.getAnnualFee();
		return -1.0;
	}
	

}

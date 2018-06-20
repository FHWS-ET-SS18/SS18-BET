package clubadmin;


public class ActiveMember extends AMember implements Member{
	
	public ActiveMember(String name, int age){
		super(name, age);
		
	}
	
	@Override
	public double getAnnualFee(){
		return 0.5*myClub.getAnnualFee();
		
	}

}

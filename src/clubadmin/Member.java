package clubadmin;

public interface Member extends Comparable<Member>{

	public String getName();
	public String getMyClubName();
	public MemberAdministrator getMyClub();
	public int getAge();
	public boolean setMyClub(MemberAdministrator club);
	public double getAnnualFee();
	public String getKey();
	
}

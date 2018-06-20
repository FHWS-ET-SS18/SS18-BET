package clubadmin;

import java.util.List;

public interface MemberAdministrator {
	
	public String getClubName();
	public String getClubType();
	public String getFoundationYear();
	public boolean addMember(Member m);
	public Member removeMember(String name, int age) throws Exception;
	public boolean isMember(Member m);
	public Member getMember(String name, int age) throws NotFoundException;
	public int getMemberCount();
	public List<Member> getMemberList();
	public double getAnnualFee();
	public double getTotalFeeIncome();
	public void printMembers();
	
	
}

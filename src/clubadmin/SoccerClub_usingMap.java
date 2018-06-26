package clubadmin;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SoccerClub_usingMap implements MemberAdministrator{
	
	private String clubName;
	private String clubType;
	private String foundationYear;

	private Map<String,Member> memberMap = new HashMap<>();
	
	
	
	
	public SoccerClub_usingMap(String clubName, String clubType, String foundationYear) {
		super();
		this.clubName = clubName;
		this.clubType = clubType;
		this.foundationYear = foundationYear;
	}
	

	public String getClubName(){
		return clubName;
	}

	public String getClubType() {
		return clubType;
	}

	public String getFoundationYear() {
		return foundationYear;
	}
	
	public boolean addMember(Member m){
		if (m==null) return false;
		if (isMember(m)) return false;
		//Rückwärtsreferenz  bei Member eintragen
		m.setMyClub(this);
		
		Member result= memberMap.put(m.getKey(), m);
		return true;
		/*
		 * if(result == null) return true;
		 * return false;
		 * 
		 */
		
	}
	
	
	
	public boolean isMember(Member m){
		return memberMap.containsKey(m.getKey());
	}
	
	public Member removeMember1(String name, int age){
		Member m = new ActiveMember(name,age);
		//String key = name + "_" + age;
		Member result = memberMap.remove(m.getKey());
		result.setMyClub(null);
		return result;	
		//return memberList.remove(m);
		
	}
	public Member removeMember(String name, int age) throws Exception{
		Member m = new ActiveMember(name,age);
		Iterator<Member> mIterator = memberMap.values().iterator();
		
		//for (Member n: memberMap.values())
		while (mIterator.hasNext()){
			Member n = mIterator.next();
			if (m.equals(n)) {
				mIterator.remove();
				n.setMyClub(null);
				return n;
			}
		}
		throw new Exception ("Nicht vorhanden: " + m.getKey());
		
		
		
	}
	
	public Member getMember(String name, int age) throws NotFoundException{
		Member m = new ActiveMember(name,age);
		m = memberMap.get(m.getKey());
		if (m==null) throw new NotFoundException("Das Mitglied: " + name + "; Alter : " + age + " konte nicht gefunden werden");
		return m;
	}

	public List<Member> getMemberList(){
		List<Member> mList =  new LinkedList<> (memberMap.values());
		Collections.sort(mList, new MemberComparator());
		return mList;
			
	}
	
	public double getAnnualFee(){
		return 100.00;
	}
	
	public double getTotalFeeIncome(){
		double income=0.0;
		//ArrayList<Member> mList = new ArrayList<>(memberMap.values());

		for (Member m: getMemberList()){
			income = income + m.getAnnualFee();
		}
		return income;
	}
	
	public int getMemberCount(){
		return memberMap.size();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SoccerClub_usingMap other = (SoccerClub_usingMap) obj;
		if (clubName == null) {
			if (other.clubName != null)
				return false;
		} else if (!clubName.equals(other.clubName))
			return false;
		if (clubType == null) {
			if (other.clubType != null)
				return false;
		} else if (!clubType.equals(other.clubType))
			return false;
		if (foundationYear == null) {
			if (other.foundationYear != null)
				return false;
		} else if (!foundationYear.equals(other.foundationYear))
			return false;
		return true;
	}
	
	public void printMembers(){
		Iterator<Member> mIterator =  memberMap.values().iterator();
		while (mIterator.hasNext()){
			Member m = mIterator.next();
			System.out.println(m.toString());
		}
		/*
		for (Member m: memberMap.values()){
			System.out.println(m.toString());
		}
		*/
	}
	


	


	
	
}


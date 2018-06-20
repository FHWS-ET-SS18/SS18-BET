package clubadmin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SoccerClub implements MemberAdministrator{
	
	private String clubName;
	private String clubType;
	private String foundationYear;

	private List<Member> memberList = new ArrayList<>();
	
	
	
	
	public SoccerClub(String clubName, String clubType, String foundationYear) {
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
		
		return memberList.add(m);
		
		
	}
	
	public boolean isMember1(Member m){
		for (int i=0; i<memberList.size();i++){
			if (memberList.get(i).equals(m)) return true;
		}
		return false;
	}
	
	public boolean isMember(Member m){
		return memberList.contains(m);
	}
	
	public Member removeMember(String name, int age) throws Exception{
		Member m = new ActiveMember (name,age);
		try{
			int index = memberList.indexOf(m);
			m =  memberList.remove(index);
			m.setMyClub(null);
			return m;
		}catch(Exception ex){
			throw new Exception ("Nicht gefunden: " + m.getKey() + ex.getMessage());
		}
		
		//int index = memberList.indexOf(m);
		// 1. Varianteif (index==-1) return null;
		//if (index==-1) throw new Exception ("Nicht gefunden: " + m.getKey());
		
		
		
		//return memberList.remove(m);
		
	}
	
	public Member getMember(String name, int age)  throws NotFoundException{
		Member m = new ActiveMember (name,age);
		int index = memberList.indexOf(m);
		try{
			return memberList.get(index);
		} catch (Exception ex){
			throw new NotFoundException("Das Mitglied: " + name + "; Alter : " + age + " konte nicht gefunden werden");
		}
		
		
	}

	public List<Member> getMemberList(){
		// Diese Lösung ist insofern etwas unschön,	als dass die clone-Methode geerbt und 
		// leider nicht generisch (parametrierbar) ist. Deshalb ist der Cast notwendig.
		/*
		ArrayList<Member> myList= (ArrayList<Member>) memberList;
		return (List<Member>) myList.clone();
		*/
		
		//einfacher ginge es hiermit, unter ummgehung der clone-Methode
		List<Member> listClone = new ArrayList<>(memberList);
		Collections.sort(listClone);
		return listClone;
		
	}
	
	public double getAnnualFee(){
		return 75.00;
	}
	
	public double getTotalFeeIncome(){
		double income=0.0;
		for (int i=0; i<memberList.size(); i++){
			income = income + memberList.get(i).getAnnualFee();
		}
		return income;
	}
	
	public int getMemberCount(){
		return memberList.size();
	}


	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SoccerClub other = (SoccerClub) obj;
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
		Iterator<Member> mIterator =  memberList.iterator();
		while (mIterator.hasNext()){
			Member m = mIterator.next();
			System.out.println(m.toString());
		}
		
	}

	


	
	
}

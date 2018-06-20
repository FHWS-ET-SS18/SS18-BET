package clubadmin;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class SoccerClub_usingSortedSet implements MemberAdministrator {

	private String clubName;
	private String clubType;
	private String foundationYear;

	//private SortedSet<Member> memberSet = new TreeSet<>();
	private SortedSet<Member> memberSet = new TreeSet<>(new MemberComparator());
	
	
	public SoccerClub_usingSortedSet(String clubName, String clubType, String foundationYear) {
		super();
		this.clubName = clubName;
		this.clubType = clubType;
		this.foundationYear = foundationYear;
	}

	public String getClubName() {
		return clubName;
	}

	public String getClubType() {
		return clubType;
	}

	public String getFoundationYear() {
		return foundationYear;
	}

	public boolean addMember(Member m) {
		if (m == null)
			return false;
		// Rückwärtsreferenz bei Member eintragen
		m.setMyClub(this);

		// Member bei MemberAdmin eintragen
		return memberSet.add(m);

	}

	public boolean isMember(Member m) {
		return memberSet.contains(m);
	}

	public Member removeMember(String name, int age) throws Exception {
		Member m = this.getMember(name, age);
		if (m == null)
			throw new Exception("Nicht gefunden: " + m.getKey());
		memberSet.remove(m);
		m.setMyClub(null);
		return m;

	}

	public Member getMember(String name, int age) throws NotFoundException {
		Member compMember = new ActiveMember(name, age);
		SortedSet<Member> tailSet = memberSet.tailSet(compMember);
		// so lautet die korrekte Parametrierung von mComp
		// alle Objekte sind erlaubt, die vom Typ Member sind  oder eine  Spezialisierung 
		// davon darstelen
		Comparator<? super Member> memberComparator = memberSet.comparator();
		if (memberComparator==null){
			if (tailSet.first().compareTo(compMember) ==0) return tailSet.first();
			else throw new NotFoundException(compMember.getKey());
		}
		else {
			if (memberComparator.compare(compMember,tailSet.first()) ==0) return tailSet.first();
			else throw new NotFoundException(compMember.getKey());
		}
}

	public List<Member> getMemberList() {
		//return new LinkedList<Member>(memberSet);
		 LinkedList<Member> list = new LinkedList<>();
		 list.addAll(memberSet);
		 return list;

	}

	public double getAnnualFee() {
		return 75.00;
	}

	public double getTotalFeeIncome() {
		double income = 0.0;
		// ArrayList<Member> mList = new ArrayList<>(memberMap.values());
		List<Member> mList = this.getMemberList();
		for (int i = 0; i < mList.size(); i++) {
			income = income + mList.get(i).getAnnualFee();
		}
		return income;
	}

	public int getMemberCount() {
		return memberSet.size();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SoccerClub_usingSortedSet other = (SoccerClub_usingSortedSet) obj;
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
		Iterator<Member> mIterator =  memberSet.iterator();
		while (mIterator.hasNext()){
			Member m = mIterator.next();
			System.out.println(m.toString());
		}
		/*
		for (Member m: memberSet){
			System.out.println(m.toString());
		}
		*/
	}

}

package clubadmin;

import java.util.Comparator;

public class MemberComparator implements Comparator<Member>{
	public int compare (Member m1, Member m2){
		// damit die Test laufen habe ich nachträglich auch noch das Alter
		// als Sortierkriterium aufgenommen. 
		//return -m1.getName().compareTo(m2.getName());
		
		int res1 = m1.getName().compareTo( m2.getName());
		if (res1!=0) return res1;
		
		return m1.getAge()- m2.getAge();
	}
	
	
	
}

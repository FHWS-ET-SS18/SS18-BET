package clubadmin;

public abstract class AMember implements Member, Comparable<Member>{
	private String name;
	private int age;
	protected MemberAdministrator myClub;
	
	

	public AMember(String name, int age){
		this.name = name;
		this.age = age;
		
	}
	
	@Override
	public String getKey(){
		return name + " _ " + age;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getMyClubName() {
		if (myClub != null) return myClub.getClubName();
		
		return null;
	}

	@Override
	public MemberAdministrator getMyClub() {
		return myClub;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public boolean setMyClub(MemberAdministrator club){
		if (club==null){
			this.myClub = null;
			return true;
		}
		if (myClub != null) return false;
		this.myClub = club;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass().getInterfaces()[0] != obj.getClass().getInterfaces()[0])
			return false;
		Member other = (Member) obj;
		if (age != other.getAge())
			return false;
		if (name == null) {
			if (other.getName() != null)
				return false;
		} else if (!name.equals(other.getName()))
			return false;
		return true;
	}
	
	public abstract double getAnnualFee();
	
	
	public int compareTo(Member m){
		//this < m   --> -1
		// m < this  --> +1
		// --> 0
		int res1 = this.getName().compareTo( m.getName());
		if (res1!=0) return res1;
		
		return this.getAge()- m.getAge();
		
		/*
		if (this.getAge()< m.getAge()) return -1;
		else if (this.getAge()>m.getAge()) return +1;
		else return 0;
		*/
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int ecompareTo(Member m){
		// komplette Implementierung incl. Namens-Vergleich 
		int iNameComp = this.getName().compareTo(m.getName());
		if ( iNameComp != 0) return iNameComp; // die Namen waren nicht gleich!
		if (this.getAge() < m.getAge()) return -1;
		if (this.getAge() > m.getAge()) return +1;
		return 0;
	}
		
	
	
	
}

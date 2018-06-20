package clubadmin;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ClubAdminTest {

	private ActiveMember trainer, trainerClone, keeper, forward1, forward2, defender;
	private PassiveMember hooligan1, hooligan2,fanOnly, fanOnly1;
	private MemberAdministrator fcLiverpool, fcBayern;
	private boolean testMapImpl=false, testSetImpl=false;
	// Zum test des RemoteClones

	@Before
	public void setup() {
		trainer = new ActiveMember("Jürgen Klopp", 51);
		trainerClone = new ActiveMember("Jürgen Klopp", 51);
		keeper = new ActiveMember("Loris Karius", 25);
		forward1 = new ActiveMember("Roberto Firmino", 27);
		defender = new ActiveMember("Virgil van Dijk", 27);
		forward2 = new ActiveMember("Mohamed Salah", 26);
		
		hooligan1 = new PassiveMember("Tom Destroyer", 25);
		hooligan2 = new PassiveMember("Kevin Bengalo", 21);
		
		fanOnly = new PassiveMember("Rudi Kawuttke", 47);
		
		//Git-test
		
		if (testSetImpl) fcLiverpool = new SoccerClub_usingSortedSet("FC Liverpool", "Soccer", "1892");
		else if (testMapImpl) fcLiverpool = new SoccerClub_usingMap("FC Liverpool", "Soccer", "1892");
		else fcLiverpool = new SoccerClub("FC Liverpool", "Soccer", "1892");
		fcLiverpool.addMember(trainer);
		fcLiverpool.addMember(keeper);
		fcLiverpool.addMember(forward1);
		fcLiverpool.addMember(defender);
		fcLiverpool.addMember(forward2);
		

		fcBayern = new SoccerClub_usingSortedSet("FC Bayern", "Soccer", "1900");
	}

	@Test
	public void testMember() {
		assertEquals(trainer.getName(), "Jürgen Klopp");
		assertEquals(trainer.getAge(), 51);
		trainer.setMyClub(fcLiverpool);
		assertEquals(trainer.getMyClubName(), "FC Liverpool");
		assertEquals(trainer.getMyClub(), fcLiverpool);
		assertEquals(trainer.getAnnualFee(), fcLiverpool.getAnnualFee() * 0.5, 1.E-10);
		assertFalse(trainer.setMyClub(fcBayern));
		assertTrue(trainer.setMyClub(null));
		assertTrue(trainer.setMyClub(fcBayern));
		assertTrue(trainer.equals(trainer));
		assertFalse(trainer.equals(keeper));
		assertTrue(trainer.equals(trainerClone));
	}

	@Test
	public void testMemberAdmin_Getter() {
		// Getter-test
		assertEquals("FC Liverpool", fcLiverpool.getClubName());
		assertEquals(fcLiverpool.getAnnualFee(), 75.0, 1.E-10);
		assertEquals("Soccer", fcLiverpool.getClubType());
		assertEquals(fcLiverpool.getFoundationYear(), "1892");
	}

	@Test
	public void testMemberAdmin_add_remove() {
		// getMember, getMemberCount
		try {
			assertEquals(keeper, fcLiverpool.getMember("Loris Karius", 25));
		} catch (NotFoundException ex) {
			fail("Schould not throw an Exception of Type :" + ex.toString());
		}

		// Dieser Test wird nur grün, wenn zwischen Mitgliedern
		// unterschiedlichen Alters
		// differenziert werden kann
		try {
			fcLiverpool.getMember("Loris Karius", 26);
			fail("Schould throw a NotFoundException");
		} catch (NotFoundException ex) {

		}
		assertEquals(fcLiverpool.getMemberCount(), 5);
		// addMember, removeMember, getmemberCount
		assertFalse(fcLiverpool.addMember(trainer));
		assertFalse(fcLiverpool.addMember(trainerClone));
		assertEquals(trainer.getMyClubName(), "FC Liverpool");

		try {
			assertEquals(fcLiverpool.removeMember("Jürgen Klopp", 51), trainer);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			fail("J. Klopp ist Mitglied gewesen");
		}
		try {
			fcLiverpool.removeMember("Jürgen Klopp", 51);
			fail("J. Klopp ist kein Mitglied mehr gewesen");
		} catch (Exception ex) {

		}
		assertEquals(fcLiverpool.getMemberCount(), 4);
		assertNull(trainer.getMyClubName());
		assertEquals(fcLiverpool.getMemberCount(), 4);
		assertTrue(fcLiverpool.addMember(trainerClone));
		assertFalse(fcLiverpool.addMember(trainerClone));
		assertEquals(fcLiverpool.getMemberCount(), 5);

		assertTrue(fcLiverpool.isMember(trainer));
		assertFalse(fcLiverpool.isMember(hooligan1));
	}

	@Test
	public void testIncomeCalculations() {
		double totalFeeIncome = 0;
		for (Member m : fcLiverpool.getMemberList()) {
			totalFeeIncome = totalFeeIncome + m.getAnnualFee();
		}
		assertEquals(fcLiverpool.getTotalFeeIncome(), totalFeeIncome, 1.E-10);

		fcLiverpool.addMember(hooligan1);

		totalFeeIncome = 0;
		for (Member m : fcLiverpool.getMemberList()) {
			totalFeeIncome = totalFeeIncome + m.getAnnualFee();
		}
		assertEquals(fcLiverpool.getTotalFeeIncome(), totalFeeIncome, 1.E-10);

	}

	@Test
	public void testSortedMemberList() {
		List<Member> mList = fcLiverpool.getMemberList();
		assertEquals(mList.get(0), trainer);
		assertEquals(mList.get(mList.size() - 1), defender);

	}

	@Test
	public void printMemberTest() {
		fcLiverpool.printMembers();
	}

}

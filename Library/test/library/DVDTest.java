package library;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DVDTest {
	static final String DVD_TITLE = "DVD1";
	static final int DVD_ID = 1;
	static final boolean DVD_ISCHECKEDOUT = false;
	static final String DVD_DIRECTOR = "Drector1";
	static final int DVD_DURATION= 100;
	DVD dvd;
	@Test
	void DVDCreation_success() {
		dvd = new DVD(DVD_TITLE, DVD_ID, DVD_ISCHECKEDOUT, DVD_DIRECTOR, DVD_DURATION);
		assertEquals(dvd.displayInfo(),"The DVD " + DVD_ID + " whith title " + DVD_TITLE + ", with director " + DVD_DIRECTOR + " and duration: "
				+ DVD_DURATION + "min, has a status of been cheaked out: " + DVD_ISCHECKEDOUT + ".");
	}

}

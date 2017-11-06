package test.java.app.mitarbeiter;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import main.java.app.mitarbeiter.Mitarbeiter;

class MitarbeiterTest {

	@Test
	void test() {
		Mitarbeiter m1 = new Mitarbeiter("Peter","Zwiener",LocalDate.now());
		Mitarbeiter m2 = new Mitarbeiter("Matthias", "Singer", LocalDate.now());
		assertTrue(m1.compareTo(m2) > 0);
	}

}

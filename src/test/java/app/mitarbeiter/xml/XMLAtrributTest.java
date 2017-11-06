package test.java.app.mitarbeiter.xml;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.app.mitarbeiter.xml.XMLAttribut;

class XMLAtrributTest {

	@Test
	void test() {
		XMLAttribut xmlA = new XMLAttribut("vorname", "Matthias");
		assertEquals("vorname", xmlA.getName());
		assertEquals("Matthias", xmlA.getValue());
	}

}

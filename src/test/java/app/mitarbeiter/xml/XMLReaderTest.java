package test.java.app.mitarbeiter.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.java.app.mitarbeiter.xml.XMLReader;

class XMLReaderTest {

	@Test
	void test() {
		String s = "<counter>3</counter>\r\n" + 
				"<mitarbeiter>\r\n" + 
				"<id>1</id>\r\n" + 
				"<vorname>Matthias</vorname>\r\n" + 
				"<nachname>Singer</nachname>\r\n" + 
				"<geburtsdatum>1991-09-16</geburtsdatum>\r\n" + 
				"</mitarbeiter>\r\n" + 
				"<mitarbeiter>\r\n" + 
				"<id>2</id>\r\n" + 
				"<vorname>Tobias</vorname>\r\n" + 
				"<nachname>Baumann</nachname>\r\n" + 
				"<geburtsdatum>1998-07-19</geburtsdatum>\r\n" + 
				"</mitarbeiter>\r\n" + 
				"<mitarbeiter>\r\n" + 
				"<id>3</id>\r\n" + 
				"<vorname>Maxi</vorname>\r\n" + 
				"<nachname>May</nachname>\r\n" + 
				"<geburtsdatum>1998-05-26</geburtsdatum>\r\n" + 
				"</mitarbeiter>\r\n";
		List<String> l = Arrays.asList(s.split("\r\n"));
		assertEquals("Matthias", XMLReader.getMitarbeiter(l, 1).getAttribute().get(0).getValue());
		assertEquals("Singer", XMLReader.getMitarbeiter(l, 1).getAttribute().get(1).getValue());
		assertEquals(LocalDate.of(1991, 9, 16), LocalDate.parse(XMLReader.getMitarbeiter(l, 1).getAttribute().get(2).getValue()));
	}

}

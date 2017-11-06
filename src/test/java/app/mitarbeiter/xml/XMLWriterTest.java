package test.java.app.mitarbeiter.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.java.app.mitarbeiter.Mitarbeiter;
import main.java.app.mitarbeiter.xml.XMLWriter;

class XMLWriterTest {

	@Test
	void test() {
		List<String> lStart = new ArrayList<>();
		lStart.add("<counter>0</counter>");
		XMLWriter.write(lStart, new Mitarbeiter("Tobias", "Baumann", LocalDate.of(1998, 7, 19)));
		assertEquals("<mitarbeiter>",lStart.get(1));
		assertEquals("<vorname>Tobias</vorname>",lStart.get(3));
	}

}

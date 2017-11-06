package main.java.app.mitarbeiter.xml;

import java.time.LocalDate;
import java.util.List;

import main.java.app.mitarbeiter.Mitarbeiter;

public class XMLReader {

	public static Mitarbeiter getMitarbeiter(List<String> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals("<id>" + id + "</id>")) {
				String s1 = list.get(i + 1);
				String vorname = s1.substring(s1.indexOf('>') + 1, s1.lastIndexOf('<'));
				String s2 = list.get(i + 2);
				String nachname = s2.substring(s2.indexOf('>') + 1, s2.lastIndexOf('<'));
				String s3 = list.get(i+3);
				String gbString = s3.substring(s3.indexOf('>') + 1, s3.lastIndexOf('<'));
				LocalDate geburtsdatum = LocalDate.parse(gbString);
				Mitarbeiter m = new Mitarbeiter(vorname, nachname, geburtsdatum);
				m.setId(id);
				return m;
			}
		}
		throw new AssertionError("ID nicht gefunden");
	}

}

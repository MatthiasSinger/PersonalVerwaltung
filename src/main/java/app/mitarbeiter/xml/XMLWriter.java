package main.java.app.mitarbeiter.xml;

import java.util.List;

import main.java.app.mitarbeiter.Mitarbeiter;

public class XMLWriter {
	public static void write(List<String> mitarbeiterDB, Mitarbeiter m) {
		mitarbeiterDB.remove(0);
		mitarbeiterDB.add(0, "<counter>" + m.getId() + "</counter>");
		mitarbeiterDB.add("<mitarbeiter>");
		mitarbeiterDB.add("<id>" + m.getId() + "</id>");
		for (XMLAttribut att : m.getAttribute()) {
			mitarbeiterDB.add("<" + att.getName() + ">" + att.getValue() + "</" + att.getName() + ">");
		}
		mitarbeiterDB.add("</mitarbeiter>");
	}
}

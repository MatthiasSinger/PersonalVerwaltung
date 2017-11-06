package main.java.app.mitarbeiter;

import java.io.IOException;
import java.util.ArrayList;

import main.java.app.MainController;

public class MitarbeiterVerwaltung {
	public static ArrayList<Mitarbeiter> mitarbeiter;
	public static MainController mc;

	public static void setMC(MainController mainc) {
		mc = mainc;
	}

	public static void einlesenMitarbeiter() {
		DBZugriff.readDB();
		mitarbeiter = new ArrayList<>();
		for (int i = 1; i <= DBZugriff.getCount(); i++) {
			mitarbeiter.add(DBZugriff.getMitarbeiter(i));
		}
		mc.addToList(mitarbeiter);
	}

	public static void hinzufuegen(Mitarbeiter m) {
		m.setId(mitarbeiter.size() + 1);
		mitarbeiter.add(m);
		DBZugriff.neuerMitarbeiter(m);
		einlesenMitarbeiter();
	}

	public static void entfernen(Mitarbeiter m) {
		mitarbeiter.remove(m);
		try {
			DBZugriff.deleteMitarbeiter(m.getId());
			einlesenMitarbeiter();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void updateMitarbeiter(Mitarbeiter alt, Mitarbeiter neu) {
		entfernen(alt);
		hinzufuegen(neu);
	}
}

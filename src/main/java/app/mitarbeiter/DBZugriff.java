package main.java.app.mitarbeiter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import main.java.app.mitarbeiter.xml.XMLReader;
import main.java.app.mitarbeiter.xml.XMLWriter;

class DBZugriff {
	private static List<String> mitarbeiterDB;
	private static final Path path = Paths.get("src/main/resources/MitarbeiterDB.xml");

	public static int getCount() {
		return Integer.parseInt(mitarbeiterDB.get(0).replaceAll("[\\D]", ""));
	}

	private static void decCounter() {
		int a = getCount();
		mitarbeiterDB.remove(0);
		mitarbeiterDB.add(0, "<counter>" + (a - 1) + "</counter>");
	}

	private static void listToXML() throws IOException {
		Files.write(path, mitarbeiterDB);
	}

	public static void readDB() {
		List<String> list;
		try {
			list = Files.lines(path).collect(Collectors.toList());
			mitarbeiterDB = list;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void neuerMitarbeiter(Mitarbeiter m) {
		XMLWriter.write(mitarbeiterDB, m);
		try {
			listToXML();
		} catch (IOException e) {
			e.printStackTrace();
		}
		readDB();
	}

	public static Mitarbeiter getMitarbeiter(int id) {
		return XMLReader.getMitarbeiter(mitarbeiterDB, id);
	}

	public static void deleteMitarbeiter(int id) throws IOException {
		boolean flag = false;
		for (int i = 0; i < mitarbeiterDB.size(); i++) {
			if (flag && mitarbeiterDB.get(i).contains("<id>")) {
				int oldId = Integer.parseInt(mitarbeiterDB.get(i).replaceAll("[\\D]", ""));
				mitarbeiterDB.remove(i);
				mitarbeiterDB.add(i, "<id>" + (oldId - 1) + "</id>");
			} else if (mitarbeiterDB.get(i).equals("<id>" + id + "</id>")) {
				int k = i - 1;
				do {
					mitarbeiterDB.remove(k);
				} while (!mitarbeiterDB.get(k).equals("</mitarbeiter>"));
				mitarbeiterDB.remove(k);
				flag = true;
				i = k;
			}
		}
		if (!flag)
			throw new AssertionError("ID nicht gefunden!");
		decCounter();
		listToXML();
	}
}

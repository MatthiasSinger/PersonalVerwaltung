package main.java.app.mitarbeiter;

import java.time.LocalDate;
import java.util.ArrayList;

import main.java.app.mitarbeiter.xml.XMLAttribut;

public class Mitarbeiter implements Comparable<Mitarbeiter> {
	private final ArrayList<XMLAttribut> attribute = new ArrayList<XMLAttribut>();
	private int id;

	public Mitarbeiter(String vorname, String nachname, LocalDate geburtsdatum) {
		attribute.add(new XMLAttribut("vorname", vorname));
		attribute.add(new XMLAttribut("nachname", nachname));
		try
		{
		attribute.add(new XMLAttribut("geburtsdatum",geburtsdatum.toString()));
		} catch (NullPointerException e)
		{
			System.err.println("Kein Geburtstag angegeben!");
		}
		
	}

	public ArrayList<XMLAttribut> getAttribute() {
		return attribute;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public String toString() {
		return (this.attribute.get(1).getValue() + ", " + this.attribute.get(0).getValue());
	}

	@Override
	public int compareTo(Mitarbeiter o) {
		return this.attribute.get(1).getValue().compareTo(o.attribute.get(1).getValue());
	}
}

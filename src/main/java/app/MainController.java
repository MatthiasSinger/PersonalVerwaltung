package main.java.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import main.java.app.mitarbeiter.Mitarbeiter;
import main.java.app.mitarbeiter.MitarbeiterVerwaltung;

public class MainController {
	@FXML
	private ListView<Mitarbeiter> lvMitarbeiter;
	@FXML
	private TextField tfVorname;
	@FXML
	private TextField tfNachname;
	@FXML
	private DatePicker dpGeburtsdatum;

	@FXML
	private void initialize() {
		MitarbeiterVerwaltung.setMC(this);
		lvMitarbeiter.getSelectionModel().selectedItemProperty().addListener(cl ->
		{
			try
			{
			tfVorname.setText(lvMitarbeiter.getSelectionModel().getSelectedItem().getAttribute().get(0).getValue());
			tfNachname.setText(lvMitarbeiter.getSelectionModel().getSelectedItem().getAttribute().get(1).getValue());
			dpGeburtsdatum.setValue(LocalDate.parse(lvMitarbeiter.getSelectionModel().getSelectedItem().getAttribute().get(2).getValue()));
			}
			catch (NullPointerException e)
			{
				//TODO bessere Behandlung von NPE
			}
		});
	}

	@FXML
	private void add(ActionEvent e) {
		lvMitarbeiter.getSelectionModel().clearSelection();
		tfVorname.setText("");
		tfNachname.setText("");
		dpGeburtsdatum.setValue(null);
	}

	@FXML
	private void delete(ActionEvent e) {
		Mitarbeiter m = lvMitarbeiter.getSelectionModel().getSelectedItem();
		if (m != null) {
			MitarbeiterVerwaltung.entfernen(m);
		}
	}

	@FXML
	private void save(ActionEvent e) {
		String vorname = tfVorname.getText();
		String nachname = tfNachname.getText();
		LocalDate geburtsdatum = dpGeburtsdatum.getValue();
		Mitarbeiter neu = new Mitarbeiter(vorname, nachname, geburtsdatum);

		if (lvMitarbeiter.getSelectionModel().getSelectedItem() == null) {
			MitarbeiterVerwaltung.hinzufuegen(neu);
			int i = lvMitarbeiter.getItems().indexOf(neu);
			lvMitarbeiter.getSelectionModel().select(i);
			lvMitarbeiter.getFocusModel().focus(i);
			lvMitarbeiter.scrollTo(i);
			
		} else {
			Mitarbeiter alt = lvMitarbeiter.getSelectionModel().getSelectedItem();
			MitarbeiterVerwaltung.updateMitarbeiter(alt, neu);
		}
	}

	public void addToList(ArrayList<Mitarbeiter> list) {
		Collections.sort(list);
		lvMitarbeiter.getItems().clear();
		lvMitarbeiter.getItems().addAll(list);
	}
}

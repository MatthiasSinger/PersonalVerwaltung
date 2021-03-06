package main.java.app;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import main.java.app.mitarbeiter.MitarbeiterVerwaltung;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		//TODO Programmstart einlesen
		try {
			HBox root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Personalbogen Verwaltung");
			primaryStage.show();
			MitarbeiterVerwaltung.einlesenMitarbeiter();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
package de.bbq.popout.minibrowser;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.IOException;

public class FavoritensaveController implements Initializable {

    @FXML
    private Label urlLabel;
    @FXML
    private TextField urlsavefield;
    @FXML
    private Button saveBut;
    @FXML
    private Button backbut;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Aktion für "Speichern" Button
        saveBut.setOnAction(e -> saveFavorite());
        
        // Aktion für "Zurück" Button
        backbut.setOnAction(e -> {
            try {
                App.setRoot("primary"); // Zurück zur Hauptseite
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    // Favoriten speichern
    private void saveFavorite() {
        String name = urlsavefield.getText(); // Den Namen aus dem Textfeld holen
        String url = urlsavefield.getText(); // Die URL von der WebView holen

        // Favoriten speichern - Hier musst du die Logik für das Speichern einfügen
    }
}

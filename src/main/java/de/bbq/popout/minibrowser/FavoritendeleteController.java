package de.bbq.popout.minibrowser;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.io.IOException;

public class FavoritendeleteController implements Initializable {

    @FXML
    private TextArea linkfield;
    @FXML
    private Button deletebut;
    @FXML
    private Button backbut;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Aktion für "Zurück" Button
        backbut.setOnAction(e -> {
            try {
                App.setRoot("primary"); // Zurück zur Hauptseite
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        // Aktion für "Löschen" Button
        deletebut.setOnAction(e -> deleteFavorite());
    }

    // Favoriten löschen
    private void deleteFavorite() {
        // Hier kannst du die Logik für das Löschen von Favoriten einfügen
    }
}

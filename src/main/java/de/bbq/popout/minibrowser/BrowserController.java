package de.bbq.popout.minibrowser;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class BrowserController implements Initializable {

    @FXML
    private Pane Plainpane;
    @FXML
    private Menu oeffnenbut;
    @FXML
    private MenuItem favbut;
    @FXML
    private Menu optionbut;
    @FXML
    private MenuItem addbut;
    @FXML
    private MenuItem delbut;
    @FXML
    private TextField urlLeiste;
    @FXML
    private WebView webView;
    @FXML
    private Menu menubar;

    private Map<String, String> favorites = new HashMap<>(); // Für Favoriten
    private String currentUrl = "";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Lade eine Startseite (z.B. Google) zu Beginn
        webView.getEngine().load("https://www.google.com");

        // Setze die Aktionen der Menüpunkte
        favbut.setOnAction(e -> openFavorites()); 
        addbut.setOnAction(e -> addFavorite());
        delbut.setOnAction(e -> deleteFavorite());
        
        // Wenn der Benutzer eine URL in das Textfeld eingibt und Enter drückt
        urlLeiste.setOnAction(e -> loadPage(urlLeiste.getText()));
    }

    // Seite laden
    private void loadPage(String url) {
        currentUrl = url;
        webView.getEngine().load(url);
    }

    // Öffnen der Favoriten-Seite
    private void openFavorites() {
        try {
            App.setRoot("favoritendelete"); // Zeige die Favoriten Löschen/Anzeigen-Seite
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Favoriten hinzufügen
    private void addFavorite() {
        String name = urlLeiste.getText(); // Wir verwenden die URL als Namen
        String url = currentUrl; // Die aktuell geladene URL

        if (!favorites.containsKey(name)) { // Verhindere doppelte Favoriten
            favorites.put(name, url);
        }
    }

    // Favoriten löschen
    private void deleteFavorite() {
        // Hier musst du die Favoriten anzeigen und löschen
        try {
            App.setRoot("favoritendelete");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Favoriten zurückgeben (um sie in der Favoriten-Löschen-Seite zu nutzen)
    public Map<String, String> getFavorites() {
        return favorites;
    }

    // Setze die URL des Favoriten
    public void setFavoriteUrl(String url) {
        loadPage(url);
    }
}

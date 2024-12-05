package de.bbq.popout.minibrowser;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage primaryStage; // Hier speichern wir den Stage

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage; // Speichern des Stage
        scene = new Scene(loadFXML("primary"), 405, 325);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static Stage getPrimaryStage() {
        return primaryStage; // Diese Methode gibt den Stage zurück
    }

    public static void main(String[] args) {
        launch();
    }
}

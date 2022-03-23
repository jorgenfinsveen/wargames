package idatx2001.jorgfi.wargamesApp;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Launches the application and the graphical user interface
 * @author jorgfi
 */
public class GUI extends Application {

    /**
     * Initializes the application
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Opens a windowtab and fills it with content from the index.fxml file.
     * Will try to load the file and print the stacktrace to terminal if it 
     * should fail to load.
     */
    @Override
    public void start(Stage stage) {
        Pane root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("index.fxml"));
            Scene scene = new Scene(root);

            stage.setTitle("Wargames");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("FEILMELDING - STACKTRACE:");
            System.out.println("");
            e.printStackTrace();
        }
    }

    /**
     * Shuts down the program
     */
    @Override
    public void stop() {
        System.exit(0);
    }
}

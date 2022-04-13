package idatx2001.jorgfi.wargamesApp.ui;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class WargamesApp extends Application {

    
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    try {
      
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CreateArmiesPage.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root, 1440, 800);
        stage.setScene(scene);
        stage.show();
    } catch (Exception e) {
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("FEILMELDING - STACKTRACE:");
        System.out.println("");
        e.printStackTrace();
    }
  }

  @Override
    public void stop() {
        System.exit(0);
    }

}


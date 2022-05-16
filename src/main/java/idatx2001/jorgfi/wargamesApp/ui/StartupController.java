package idatx2001.jorgfi.wargamesApp.ui;


import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class StartupController {

    Scene armyConfiguratorScene;
    
    public void startApplication(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(this.armyConfiguratorScene);
        primaryStage.centerOnScreen();
        primaryStage.setResizable(true);
        primaryStage.setMinHeight(620);
        primaryStage.setMinWidth(900);
        primaryStage.setResizable(false);
        
        primaryStage.show();
    }

    public void showHelp(ActionEvent actionEvent) {

    }

    public void exitApplication(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You are about to exit Wargemes");
        alert.setContentText("Are you sure you want to exit?");

        if(alert.showAndWait().get() == ButtonType.OK) {
            Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
            stage.close();
        }
    }

    public void setArmyConfiguratorScene(Scene scene) {
        this.armyConfiguratorScene = scene;
        System.out.println("SCENEN ER BLITT SATT");
      }
    
}

package idatx2001.jorgfi.wargamesApp.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class ArmyConfiguratorController {


    // The scene to return to
    private Scene unitConficuratorScene1;
    private Scene unitConficuratorScene2;

    @FXML
    TableView<String> army1Table;

    

    
    /**
     * Sets the main scene
     * @param mainScene scene to be set
     */
    public void setUnitConficuratorScene(Scene scene1, Scene scene2) {
        this.unitConficuratorScene1 = scene1;
        this.unitConficuratorScene2 = scene2;
      }
    

   


    public void showUnitConfig1(ActionEvent actionEvent) {
      Stage stage1 = new Stage();
      Stage primaryStage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
      
      stage1.setScene(this.unitConficuratorScene1);
      stage1.centerOnScreen();
      stage1.setResizable(false);
      stage1.initModality(Modality.APPLICATION_MODAL);
      stage1.setMinHeight(400);
      stage1.setMinWidth(300);
      stage1.setResizable(false);
      stage1.setFullScreen(false);
      
      stage1.show();
    }

    public void showUnitConfig2(ActionEvent actionEvent) {
      Stage stage2 = new Stage();
      Stage primaryStage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
      
      stage2.setScene(this.unitConficuratorScene2);
      stage2.centerOnScreen();
      stage2.setResizable(false);
      stage2.initModality(Modality.APPLICATION_MODAL);
      stage2.setMinHeight(400);
      stage2.setMinWidth(300);
      stage2.setResizable(false);
      stage2.setFullScreen(false);
      
      
      stage2.show();
    }


    /** 
    public void addTournamentToTournamentList(Tournament tournament) {
      tournamentList.getItems().add(tournament);
  }
  */

  public void addUnitsToTable1() {
    army1Table.getItems().add("0");
  }


  // TODO: Gjør at de nye enhetene blir lagt til i tabellen

  // TODO: UnitConfiguratorController trenger tilgang på metoden ovenfor













    /**
   * Import contacts from a .CSV-file chosen by the user.
   *
   * @param actionEvent the actionevent triggering this call
   */

  /** 
  public void importFromCSV(ActionEvent actionEvent) {
    FileChooser fileChooser = new FileChooser();

    // Set extension filter for .csv-file
    FileChooser.ExtensionFilter extFilter =
        new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
    fileChooser.getExtensionFilters().add(extFilter);

    // Show save open dialog
    File file = fileChooser.showOpenDialog(null);
    if (file != null) {
      try {
        AddressBookFileHandler.importFromCsv(this.addressBook, file);
        this.updateObservableList(this.addressBook);
      } catch (IOException ioe) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("File Import Error");
        alert.setHeaderText("Error during CSV-import.");
        alert.setContentText("Details: " + ioe.getMessage());
        alert.showAndWait();
      }
    }
  } */
}

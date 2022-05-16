package idatx2001.jorgfi.wargamesApp.ui;

import idatx2001.jorgfi.wargamesApp.model.Army;
import idatx2001.jorgfi.wargamesApp.model.Battle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;




public class MainWindow extends Application {
    
  // The business logic to communicate with
  private Army army1;
  private Army army2;
  private Battle battle;

  // The primary stage
  private Stage primaryStage;

  // The different scenes making up the application
  private Scene mainScene;
  private Scene armyConfiguratorScene;
  private Scene unitConficuratorScene1;
  private Scene unitConficuratorScene2;
  private Scene terrainScene;
  private Scene unitScene1;
  private Scene unitScene2;


    @Override
    public void start(Stage primaryStage) throws Exception {
      
        try {
            this.primaryStage = primaryStage;

            // Buisiness logic to work with
                //this.army1 = new Army(null);
                //this.army2 = new Army(null);
                //this.battle = new Battle(army1, army2);


            // Getter and loader for startup page
            FXMLLoader mainPaneLoader = new FXMLLoader(getClass().getResource("startup_page.fxml"));
            Parent mainPane = mainPaneLoader.load();
            this.mainScene = new Scene(mainPane, 600, 400);
            


            // Getter and loader for army configurator page
            FXMLLoader armyConfiguratorPageLoader = new FXMLLoader(getClass().getResource("army_configurator.fxml"));
            Parent armyConfiguratorPane = armyConfiguratorPageLoader.load();
            this.armyConfiguratorScene = new Scene(armyConfiguratorPane);
            


            // Getter and loader for unit configurator page 1
            FXMLLoader unitConfiguratorPageLoader1 = new FXMLLoader(getClass().getResource("unit_configurator1.fxml"));
            Parent unitConfiguratorPane1 = unitConfiguratorPageLoader1.load();
            this.unitConficuratorScene1 = new Scene(unitConfiguratorPane1);

            // Getter and loader for unit configurator page 2
            FXMLLoader unitConfiguratorPageLoader2 = new FXMLLoader(getClass().getResource("unit_configurator2.fxml"));
            Parent unitConfiguratorPane2 = unitConfiguratorPageLoader2.load();
            this.unitConficuratorScene2 = new Scene(unitConfiguratorPane2);



            // Controllers
            StartupController startupController = mainPaneLoader.getController();
            ArmyConfiguratorController armyConfiguratorController = armyConfiguratorPageLoader.getController();




            // Distributing scenes
            startupController.setArmyConfiguratorScene(this.armyConfiguratorScene);
            armyConfiguratorController.setUnitConficuratorScene(this.unitConficuratorScene1, this.unitConficuratorScene2);



            
            /** 
            // Getting loader and a pane for the Wind Sensor scene
            FXMLLoader armyConfiguratorPageLoader = new FXMLLoader(getClass().getResource("army_configurator.fxml"));
            Parent armyConfiguratorPane = armyConfiguratorPageLoader.load();
            this.armyConfiguratorScene = new Scene(armyConfiguratorPane);
            ArmyConfiguratorController armyConfiguratorController = armyConfiguratorPageLoader.getController();
            
            // Inject/set the main scene to return to from the wind sensor scene
            armyConfiguratorController.setMainScene(this.mainScene);
            armyConfiguratorController.setPrimaryStage(this.primaryStage);
            */

            

            primaryStage.setTitle("WarGames");
            primaryStage.setResizable(false);
            primaryStage.setScene(this.mainScene);
            primaryStage.show();
            
        } catch (Exception e) {
            System.out.println("\n\nFEILMELDING\n");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
      }
}

package idatx2001.jorgfi.wargamesApp.ui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;




public class UnitConfiguratorController1 {

    @FXML
    ChoiceBox<String> choiceBox;
    @FXML
    TextField inputUnitName;
    @FXML
    TextField inputUnitHealth;
    @FXML
    TextField inputUnitArmor;
    @FXML
    TextField inputUnitAttack;
    @FXML
    TextField inputUnitAmount;


    public void initialize() {

        choiceBox.setItems(FXCollections.observableArrayList(
            "Commander", "Cavalry", 
            "Infantry", "Ranger",
            "Giant", "Dark wizard",
            "White wizard" ));
        

        // Makes sure that only numbers can be entered in the textfields
        inputUnitHealth.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, 
                String newValue) {
                if (!newValue.matches("\\d*")) {
                    inputUnitHealth.setText(newValue.replaceAll("[^\\d]", ""));
                }

                if (inputUnitHealth.getText().equals("0")) {
                    inputUnitHealth.setText(newValue.replace("0", ""));
                    }
            }
        });
        inputUnitArmor.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, 
                String newValue) {
                if (!newValue.matches("\\d*")) {
                    inputUnitArmor.setText(newValue.replaceAll("[^\\d]", ""));
                }

                if (inputUnitArmor.getText().equals("0")) {
                    inputUnitArmor.setText(newValue.replace("0", ""));
                    }
            }
        });
        inputUnitAttack.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, 
                String newValue) {
                if (!newValue.matches("\\d*")) {
                    inputUnitAttack.setText(newValue.replaceAll("[^\\d]", ""));
                }

                if (inputUnitAttack.getText().equals("0")) {
                    inputUnitAttack.setText(newValue.replace("0", ""));
                    }
            }
        });
        inputUnitAmount.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, 
                String newValue) {
                if (!newValue.matches("\\d*")) {
                    inputUnitAmount.setText(newValue.replaceAll("[^\\d]", ""));
                }
                
                if (inputUnitAmount.getText().equals("0")) {
                    inputUnitAmount.setText(newValue.replace("0", ""));
                    }
            }
        }); 
    }
    
    public void returnToArmyConfigurator(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.close();
    }

    
}

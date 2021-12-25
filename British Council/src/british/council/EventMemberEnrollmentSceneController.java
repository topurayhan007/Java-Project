/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package british.council;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author topur
 */
public class EventMemberEnrollmentSceneController implements Initializable {

    @FXML
    private TextField fullNameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private DatePicker birthdayDatePickerField;
    @FXML
    private Button registerButton;
    @FXML
    private CheckBox termsCheckBox;
    @FXML
    private TextField nidNumberField;
    @FXML
    private RadioButton genderMale;
    @FXML
    private RadioButton genderFemale;
    @FXML
    private RadioButton genderOther;
    @FXML
    private Label errorLabelTextField;
    @FXML
    private Button backButton;
    
    private ToggleGroup tg;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tg = new ToggleGroup();
        genderMale.setToggleGroup(tg);
        genderFemale.setToggleGroup(tg);
        genderOther.setToggleGroup(tg);
              
        genderMale.setSelected(true);
    }    

    @FXML
    private void registerButtonHandle(ActionEvent event) {
    }

    @FXML
    private void backButtonHandle(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Event Planner Dashboard.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(SignUpEmployeeSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
}

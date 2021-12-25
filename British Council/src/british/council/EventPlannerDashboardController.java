/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package british.council;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author topur
 */
public class EventPlannerDashboardController implements Initializable {

    @FXML
    private Button homeButton;
    @FXML
    private Button profileButton;
    @FXML
    private Button enrollMemberButton;
    @FXML
    private Button eventButton;
    @FXML
    private Button viewAndEditFileButton;
    @FXML
    private Button logoutButton;
    @FXML
    private AnchorPane welcomeAnchorPane;
    @FXML
    private AnchorPane profileButtonAnchorPane;
    @FXML
    private Button viewProfileButton;
    @FXML
    private Button accountSettingButton;
    @FXML
    private Button backButton;
    @FXML
    private AnchorPane enrollMemberAnchorPane;
    @FXML
    private Button backButton1;
    @FXML
    private AnchorPane eventButtonAnchorPane;
    @FXML
    private AnchorPane profileInfoAnchorPane;
    @FXML
    private TextField fullNameField;
    @FXML
    private TextField genderField;
    @FXML
    private DatePicker birthdayDatePickerField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextField nidNumberField;
    @FXML
    private Button saveButton;
    @FXML
    private Button editProfileButton;
    @FXML
    private Label errorLabelSaveButton;
    @FXML
    private AnchorPane AccountSettingAnchorPane;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField emailField;
    @FXML
    private Button saveAccountButton;
    @FXML
    private Button editAccountButton;
    @FXML
    private Label errorLabelSaveAccountButton;
    @FXML
    private TextField passwordField;
    @FXML
    private MenuItem singleFileChooserMenuItem;
    @FXML
    private TextArea editTextArea;
    @FXML
    private Label fileContentLabel;
    @FXML
    private CheckBox editFileContentCheckBox;
    @FXML
    private Button saveEtittedTextButton;
    @FXML
    private BorderPane fileChooserBorderPane;
    
    ArrayList<String> fileTypeList;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        (welcomeAnchorPane).setVisible(true);
        
        
    }    

    @FXML
    private void homeButtonHAndle(ActionEvent event) {
        
        (profileButtonAnchorPane).setVisible(false);
        (profileInfoAnchorPane).setVisible(false);
        (AccountSettingAnchorPane).setVisible(false);
        (fileChooserBorderPane).setVisible(false);
        (enrollMemberAnchorPane).setVisible(false);
        (eventButtonAnchorPane).setVisible(false);   
        (welcomeAnchorPane).setVisible(true);
    }

    @FXML
    private void profileButtonHandle(ActionEvent event) {
        (profileButtonAnchorPane).setVisible(true);
        (profileInfoAnchorPane).setVisible(false);
        (AccountSettingAnchorPane).setVisible(false);
        (fileChooserBorderPane).setVisible(false);
        (enrollMemberAnchorPane).setVisible(false);
        (eventButtonAnchorPane).setVisible(false);   
        (welcomeAnchorPane).setVisible(false);
    }

    @FXML
    private void enrollMemberButtonHandle(ActionEvent event) {
        (profileButtonAnchorPane).setVisible(false);
        (profileInfoAnchorPane).setVisible(false);
        (AccountSettingAnchorPane).setVisible(false);
        (fileChooserBorderPane).setVisible(false);
        (enrollMemberAnchorPane).setVisible(true);
        (eventButtonAnchorPane).setVisible(false);   
        (welcomeAnchorPane).setVisible(false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Event Member Enrollment Scene.fxml"));
        Parent root = null;
        try {
            root = (Parent) fxmlLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(AdministratorDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root));  
        stage.show();
    }

    @FXML
    private void eventButtonHandle(ActionEvent event) {
        (profileButtonAnchorPane).setVisible(false);
        (profileInfoAnchorPane).setVisible(false);
        (AccountSettingAnchorPane).setVisible(false);
        (fileChooserBorderPane).setVisible(false);
        (enrollMemberAnchorPane).setVisible(false);
        (eventButtonAnchorPane).setVisible(true);   
        (welcomeAnchorPane).setVisible(false);
    }

    @FXML
    private void viewAndEditFileHandle(ActionEvent event) {
        (profileButtonAnchorPane).setVisible(false);
        (profileInfoAnchorPane).setVisible(false);
        (AccountSettingAnchorPane).setVisible(false);
        (fileChooserBorderPane).setVisible(true);
        (enrollMemberAnchorPane).setVisible(false);
        (eventButtonAnchorPane).setVisible(false);   
        (welcomeAnchorPane).setVisible(false);
        
        fileTypeList = new ArrayList<String>();
        fileTypeList.add("*.txt");
        fileTypeList.add("*.doc");
        fileTypeList.add("*.docx");
        fileTypeList.add("*.TXT");
        fileTypeList.add("*.DOC");
        fileTypeList.add("*.DOCX");
        
        editTextArea.setEditable(false);
    }

    @FXML
    private void logoutButtonHandle(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Log In Scene.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(EventPlannerDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void viewProfileButtonHandle(ActionEvent event) {
        (profileButtonAnchorPane).setVisible(false);
        (profileInfoAnchorPane).setVisible(true);
        (AccountSettingAnchorPane).setVisible(false);
        (fileChooserBorderPane).setVisible(false);
        (enrollMemberAnchorPane).setVisible(false);
        (eventButtonAnchorPane).setVisible(false);   
        (welcomeAnchorPane).setVisible(false);
    }

    @FXML
    private void accountSettingButtonHandle(ActionEvent event) {
        (profileButtonAnchorPane).setVisible(false);
        (profileInfoAnchorPane).setVisible(false);
        (AccountSettingAnchorPane).setVisible(true);
        (fileChooserBorderPane).setVisible(false);
        (enrollMemberAnchorPane).setVisible(false);
        (eventButtonAnchorPane).setVisible(false);   
        (welcomeAnchorPane).setVisible(false);
    }

    @FXML
    private void backButtonHandle(ActionEvent event) {
        (profileButtonAnchorPane).setVisible(false);
        (profileInfoAnchorPane).setVisible(false);
        (AccountSettingAnchorPane).setVisible(false);
        (fileChooserBorderPane).setVisible(false);
        (enrollMemberAnchorPane).setVisible(false);
        (eventButtonAnchorPane).setVisible(false);   
        (welcomeAnchorPane).setVisible(true);
        
        editTextArea.setEditable(false);
        editTextArea.setText("");
        fileContentLabel.setText("");
        
    }


    @FXML
    private void saveButtonHandle(ActionEvent event) {
        errorLabelSaveButton.setText("Saved Successfully!");
    }

    @FXML
    private void editProfileButtonHandle(ActionEvent event) {
        (saveButton).setVisible(true);
    }

    @FXML
    private void saveAccountButtonHandle(ActionEvent event) {
        errorLabelSaveAccountButton.setText("Saved Successfully!");
    }

    @FXML
    private void editAccountButtonHandle(ActionEvent event) {
        (saveAccountButton).setVisible(true);
    }

    @FXML
    private void singleFileChooserMenuItemOnClick(ActionEvent event) {
        fileContentLabel.setText(EventPlanner.openAFile(fileTypeList));
    }

    @FXML
    private void editFileContentCheckBoxOnClick(ActionEvent event) {
        editTextArea.setEditable(true);
        editTextArea.setText(fileContentLabel.getText());
    }

    @FXML
    private void saveEtittedTextButtonOnClick(ActionEvent event) {
        String str = editTextArea.getText();
        editTextArea.setText(EventPlanner.saveAfile(fileTypeList, str));
        
    }
    
}

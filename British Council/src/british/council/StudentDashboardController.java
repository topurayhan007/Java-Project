/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package british.council;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author topur
 */
public class StudentDashboardController implements Initializable {

    @FXML
    private Button homeButton;
    @FXML
    private Button profileButton;
    @FXML
    private Button registerButton;
    @FXML
    private Button resultButton;
    @FXML
    private Button logoutButton;
    @FXML
    private AnchorPane welcomeAnchorPane;
    @FXML
    private AnchorPane profileButtonAnchorPane;
    @FXML
    private AnchorPane registerButtonAnchorPane;
    @FXML
    private AnchorPane resultButtonAnchorPane;
    @FXML
    private Button backButton;
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
    private TextField passwordField;
    @FXML
    private Button viewProfileButton;
    @FXML
    private Button accountSettingButton;
    @FXML
    private Button enrollForACourseButton;
    @FXML
    private Button registerForAnExam;
    @FXML
    private Button IGCSEbutton;
    @FXML
    private Button IELTSbutton;
    @FXML
    private Button IALbutton;
    @FXML
    private Label errorLabelSaveButton;
    @FXML
    private Label errorLabelSaveAccountButton;
    @FXML
    private AnchorPane igcseResultAnchorPane;
    @FXML
    private TableView<Exam> tableView;
    @FXML
    private TableColumn<Exam, String> subjectColumn;
    @FXML
    private TableColumn<Exam, Float> markColumn;
    @FXML
    private TableColumn<Exam, String> gradeColumn;
    
    @FXML
    private Button resultBackButton;
    
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        (welcomeAnchorPane).setVisible(true);
        
        
    }    

    @FXML
    private void homeButtonHAndle(ActionEvent event) {
        (registerButtonAnchorPane).setVisible(false);
        (resultButtonAnchorPane).setVisible(false);
        (profileButtonAnchorPane).setVisible(false);
        (profileInfoAnchorPane).setVisible(false);
        (AccountSettingAnchorPane).setVisible(false);
        (igcseResultAnchorPane).setVisible(false);
        (welcomeAnchorPane).setVisible(true);
    }

    @FXML
    private void profileButtonHandle(ActionEvent event) {
        (welcomeAnchorPane).setVisible(false);
        (registerButtonAnchorPane).setVisible(false);
        (resultButtonAnchorPane).setVisible(false);
        (profileInfoAnchorPane).setVisible(false);
        (AccountSettingAnchorPane).setVisible(false);
        (igcseResultAnchorPane).setVisible(false);
        (profileButtonAnchorPane).setVisible(true);
    }

    @FXML
    private void registerButtonHandle(ActionEvent event) {
        (welcomeAnchorPane).setVisible(false);
        (resultButtonAnchorPane).setVisible(false);
        (profileButtonAnchorPane).setVisible(false);
        (profileInfoAnchorPane).setVisible(false);
        (AccountSettingAnchorPane).setVisible(false);
        (igcseResultAnchorPane).setVisible(false);
        (registerButtonAnchorPane).setVisible(true);
    }

    @FXML
    private void resultButtonHandle(ActionEvent event) {
        (welcomeAnchorPane).setVisible(false);
        (profileButtonAnchorPane).setVisible(false);
        (registerButtonAnchorPane).setVisible(false);
        (profileInfoAnchorPane).setVisible(false);
        (AccountSettingAnchorPane).setVisible(false);
        (igcseResultAnchorPane).setVisible(false);
        (resultButtonAnchorPane).setVisible(true);
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
    private void backButtonHandle(ActionEvent event) {
        (registerButtonAnchorPane).setVisible(false);
        (resultButtonAnchorPane).setVisible(false);
        (profileButtonAnchorPane).setVisible(false);
        (profileInfoAnchorPane).setVisible(false);
        (AccountSettingAnchorPane).setVisible(false);
        (igcseResultAnchorPane).setVisible(false);
        (welcomeAnchorPane).setVisible(true);
        
        
    }

    

    @FXML
    private void editProfileButtonHandle(ActionEvent event) {
        (saveButton).setVisible(true);
    }
    
    @FXML
    private void saveButtonHandle(ActionEvent event) {
        
        
        errorLabelSaveButton.setText("Saved Successfully!");
    }
    
    @FXML
    private void editAccountButtonHandle(ActionEvent event) {
        (saveAccountButton).setVisible(true);
    }
    
    @FXML
    private void saveAccountButtonHandle(ActionEvent event) {
        
        
        errorLabelSaveAccountButton.setText("Saved Successfully!");
    }

    

    @FXML
    private void viewProfileButtonHandle(ActionEvent event) {
        (registerButtonAnchorPane).setVisible(false);
        (resultButtonAnchorPane).setVisible(false);
        (profileButtonAnchorPane).setVisible(false);
        (welcomeAnchorPane).setVisible(false);
        (igcseResultAnchorPane).setVisible(false);
        (profileInfoAnchorPane).setVisible(true);
        (AccountSettingAnchorPane).setVisible(false);
    }

    @FXML
    private void accountSettingButtonHandle(ActionEvent event) {
        (registerButtonAnchorPane).setVisible(false);
        (resultButtonAnchorPane).setVisible(false);
        (profileButtonAnchorPane).setVisible(false);
        (welcomeAnchorPane).setVisible(false);
        (profileInfoAnchorPane).setVisible(false);
        (igcseResultAnchorPane).setVisible(false);
        (AccountSettingAnchorPane).setVisible(true);
    }

    @FXML
    private void enrollForACourseButtonHAndle(ActionEvent event) {
        
    }

    @FXML
    private void registerForAnExamHandle(ActionEvent event) {
        
    }

    @FXML
    private void IGCSEbuttonHandle(ActionEvent event) {
        (registerButtonAnchorPane).setVisible(false);
        (resultButtonAnchorPane).setVisible(false);
        (profileButtonAnchorPane).setVisible(false);
        (welcomeAnchorPane).setVisible(false);
        (profileInfoAnchorPane).setVisible(false);
        (AccountSettingAnchorPane).setVisible(false);
        (igcseResultAnchorPane).setVisible(true);
        
        
        subjectColumn.setCellValueFactory(new PropertyValueFactory<>("subject"));
        markColumn.setCellValueFactory(new PropertyValueFactory<>("mark"));
        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
        ObservableList <Exam> exam = FXCollections.observableArrayList();
        exam = Student.checkResult("topurayhan");
        //tableView.setItems(exam);
        tableView.setItems(getMarks());
        
        //Allow first and last name to be edittable
        tableView.setEditable(true);
        
        
        //allow the table to select multiple rows at once
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        
    }
    public ObservableList<Exam> getMarks(){
        ObservableList<Exam> people = FXCollections.observableArrayList();
        people.add(new Exam("Accounting", 94, "A*"));
        people.add(new Exam("Physics", 85, "A"));
        people.add(new Exam("Chemistry", 75, "B"));
        
        return people;
    }
    
   
    @FXML
    private void IELTSbuttonHandle(ActionEvent event) {
        
    }

    @FXML
    private void IALbuttonHandle(ActionEvent event) {
    
    }

    @FXML
    private void resultBackButtonHandle(ActionEvent event) {
        (registerButtonAnchorPane).setVisible(false);
        
        (profileButtonAnchorPane).setVisible(false);
        (profileInfoAnchorPane).setVisible(false);
        (AccountSettingAnchorPane).setVisible(false);
        (igcseResultAnchorPane).setVisible(false);
        (welcomeAnchorPane).setVisible(false);
        (resultButtonAnchorPane).setVisible(true);
    }
    
}

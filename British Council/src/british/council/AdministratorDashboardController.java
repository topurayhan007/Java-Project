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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author topur
 */
public class AdministratorDashboardController implements Initializable {

    @FXML
    private Button homeButton;
    @FXML
    private Button profileButton;
    @FXML
    private Button enrollEmployeeButton;
    @FXML
    private Button updatePolicyButton;
    @FXML
    private Button updateSalaryButton;
    @FXML
    private Button reportButton;
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
    private AnchorPane enrollEmployeeAnchorPane;
    @FXML
    private Button backButton1;
    @FXML
    private AnchorPane updatePolicyButtonAnchorPane;
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
    private AnchorPane reportAnchorPane;
    @FXML
    private Button generateReportButton;
    @FXML
    private ComboBox<String> userTypeComboBox;
    @FXML
    private PieChart pieChart;
    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private Label chartLabel;
    @FXML
    private AnchorPane updateSalaryButtonAnchorPane;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        (welcomeAnchorPane).setVisible(true);
        showCheckBox();
    }    

    @FXML
    private void homeButtonHAndle(ActionEvent event) {
        (updateSalaryButtonAnchorPane).setVisible(false);
        (updatePolicyButtonAnchorPane).setVisible(false);
        (profileButtonAnchorPane).setVisible(false);
        (profileInfoAnchorPane).setVisible(false);
        (AccountSettingAnchorPane).setVisible(false);
        (enrollEmployeeAnchorPane).setVisible(false);
        (reportAnchorPane).setVisible(false);
        (welcomeAnchorPane).setVisible(true);
    }

    @FXML
    private void profileButtonHandle(ActionEvent event) {
        (updateSalaryButtonAnchorPane).setVisible(false);
        (updatePolicyButtonAnchorPane).setVisible(false);
        (profileButtonAnchorPane).setVisible(true);
        (profileInfoAnchorPane).setVisible(false);
        (enrollEmployeeAnchorPane).setVisible(false);
        (AccountSettingAnchorPane).setVisible(false);
        (reportAnchorPane).setVisible(false);
        (welcomeAnchorPane).setVisible(false);
    }

    @FXML
    private void enrollEmployeeButtonHandle(ActionEvent event) {
        (updateSalaryButtonAnchorPane).setVisible(false);
        (updatePolicyButtonAnchorPane).setVisible(false);
        (profileButtonAnchorPane).setVisible(false);
        (profileInfoAnchorPane).setVisible(false);
        (AccountSettingAnchorPane).setVisible(false);
        (reportAnchorPane).setVisible(false);
        (enrollEmployeeAnchorPane).setVisible(true);
        (welcomeAnchorPane).setVisible(false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Sign Up Employee Scene.fxml"));
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
    private void updatePolicyButtonHandle(ActionEvent event) {
        (updateSalaryButtonAnchorPane).setVisible(false);
        (updatePolicyButtonAnchorPane).setVisible(true);
        (profileButtonAnchorPane).setVisible(false);
        (profileInfoAnchorPane).setVisible(false);
        (AccountSettingAnchorPane).setVisible(false);
        (reportAnchorPane).setVisible(false);
        (enrollEmployeeAnchorPane).setVisible(false);
        (welcomeAnchorPane).setVisible(false);
    }

    @FXML
    private void updateSalaryButtonHandle(ActionEvent event) {
        (updateSalaryButtonAnchorPane).setVisible(true);
        (updatePolicyButtonAnchorPane).setVisible(false);
        (profileButtonAnchorPane).setVisible(false);
        (profileInfoAnchorPane).setVisible(false);
        (AccountSettingAnchorPane).setVisible(false);
        (reportAnchorPane).setVisible(false);
        (enrollEmployeeAnchorPane).setVisible(false);
        (welcomeAnchorPane).setVisible(false);
    }

    @FXML
    private void reportButtonHandle(ActionEvent event) {
        
        (updateSalaryButtonAnchorPane).setVisible(false);
        (updatePolicyButtonAnchorPane).setVisible(false);
        (profileButtonAnchorPane).setVisible(false);
        (profileInfoAnchorPane).setVisible(false);
        (AccountSettingAnchorPane).setVisible(false);
        (reportAnchorPane).setVisible(true);
        (enrollEmployeeAnchorPane).setVisible(false);
        (welcomeAnchorPane).setVisible(false);
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
        (updateSalaryButtonAnchorPane).setVisible(false);
        (updatePolicyButtonAnchorPane).setVisible(false);
        (profileButtonAnchorPane).setVisible(false);
        (profileInfoAnchorPane).setVisible(true);
        (AccountSettingAnchorPane).setVisible(false);
        (reportAnchorPane).setVisible(false);
        (enrollEmployeeAnchorPane).setVisible(false);
        (welcomeAnchorPane).setVisible(false);
    }

    @FXML
    private void accountSettingButtonHandle(ActionEvent event) {
        (updateSalaryButtonAnchorPane).setVisible(false);
        (updatePolicyButtonAnchorPane).setVisible(false);
        (profileButtonAnchorPane).setVisible(false);
        (profileInfoAnchorPane).setVisible(false);
        (AccountSettingAnchorPane).setVisible(true);
        (reportAnchorPane).setVisible(false);
        (enrollEmployeeAnchorPane).setVisible(false);
        (welcomeAnchorPane).setVisible(false);
    }

    @FXML
    private void backButtonHandle(ActionEvent event) {
        (updateSalaryButtonAnchorPane).setVisible(false);
        (updatePolicyButtonAnchorPane).setVisible(false);
        (profileButtonAnchorPane).setVisible(false);
        (profileInfoAnchorPane).setVisible(false);
        (AccountSettingAnchorPane).setVisible(false);
        (reportAnchorPane).setVisible(false);
        (enrollEmployeeAnchorPane).setVisible(false);
        (welcomeAnchorPane).setVisible(true);
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
    private void generateReportButtonHandle(ActionEvent event) {
    if(userTypeComboBox.getValue().equals("Librarian")){    
        ObservableList<Librarian> te = FXCollections.observableArrayList();
        te = Administrator.generateLibrarianReport();
        
        Series<String, Number> series = new XYChart.Series<String, Number>();
        
        for(Librarian t: te){
            System.out.println(t.salary);
            int x = t.salary;
            String s = t.username;
            series.getData().add(new XYChart.Data<String,Number>(s,x));
            
        }
        series.getData().add(new XYChart.Data<>("Martin",15000));
        series.getData().add(new XYChart.Data<>("Robert",45612));
        series.getData().add(new XYChart.Data<>("Taylor",95000));
        series.getData().add(new XYChart.Data<>("Bruce",66000));
        series.setName("Monthly Pay");
        
        barChart.setTitle("Salary of Librarian");
        barChart.getData().add(series);
    }
    else if(userTypeComboBox.getValue().equals("Student")){
        ObservableList<Student> te = FXCollections.observableArrayList();
        te = Administrator.generateStudentReport();
        int male = 0; int female = 0;
        for(Student t: te){
            if(t.gender.equals("Male")){
                ++male;
            }
            else if(t.gender.equals("Female")){
                ++female;
            }
        }
        float total = male+female;
        float m = (male/total)*100;
        float f = (female/total)*100;
        
        ObservableList <Data> list = FXCollections.observableArrayList(
            new PieChart.Data("Male",90),
            new PieChart.Data("Female",10)   
        );
        
        pieChart.setData(list);
        
        for(PieChart.Data data: pieChart.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    chartLabel.setText(String.valueOf(data.getPieValue()));
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }
            );
        }
    }
        
        
        
    }

    @FXML
    private void userTypeComboBoxOnClick(ActionEvent event) {
        switch (userTypeComboBox.getValue()) {
                case "Student":
                    pieChart.setVisible(true);
                    barChart.setVisible(false);
                    break;
                case "Teacher":
                    
                    break;
                case "Librarian":
                    barChart.setVisible(true);
                    pieChart.setVisible(false);
                    break;
                case "Event Planner":
                    
                    break;
                case "Administrator":
                    
                    break;
                default:
                    break;
            }
    }
    private void showCheckBox() {
        ObservableList list = FXCollections.observableArrayList();
        list.removeAll(list);
        list.add("Student");
        list.add("Teacher");
        list.add("Librarian");
        list.add("Event Planner");
        list.add("Administrator");
        userTypeComboBox.getItems().addAll(list);
        
        userTypeComboBox.setValue("Librarian");
    }
}

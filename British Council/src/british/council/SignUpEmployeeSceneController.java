/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package british.council;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import static java.lang.Integer.parseInt;
import java.net.URL;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author topur
 */
public class SignUpEmployeeSceneController implements Initializable {

    @FXML private TextField fullNameField;
    @FXML private TextField emailField;
    @FXML private TextField phoneNumberField;
    @FXML private DatePicker birthdayDatePickerField;
    @FXML private PasswordField confirmPasswordField;
    @FXML private Button registerButton;
    @FXML private ChoiceBox<String> userTypeSignUpChoiceBox;
    @FXML private CheckBox termsCheckBox;
    @FXML private RadioButton genderMale;
    @FXML private RadioButton genderFemale;
    @FXML private RadioButton genderOther;
    @FXML private Label errorLabelTextField;
    @FXML
    private Button backButton;
    
     private ToggleGroup tg;
    @FXML
    private PasswordField InitialPasswordField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField nidNumberField;
    @FXML
    private TextField salaryTextField;
    
    private int id = 0;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showCheckBox();
        tg = new ToggleGroup();
        genderMale.setToggleGroup(tg);
        genderFemale.setToggleGroup(tg);
        genderOther.setToggleGroup(tg);
              
        genderMale.setSelected(true);
    }    

    @FXML
    private void registerButtonOnClick(ActionEvent event) {
        String database = ""; 
        String gender = null; 
        if(genderMale.isSelected()) gender="Male";
        else if(genderFemale.isSelected()) gender="Female";
        else if (genderOther.isSelected()) gender="Other";
        if(!(InitialPasswordField.getText().equals(confirmPasswordField.getText())) || fullNameField.getText().equals("") || usernameField.getText().equals("") 
                || emailField.getText().equals("") || InitialPasswordField.getText().equals("") || confirmPasswordField.getText().equals("") 
                || phoneNumberField.getText().equals("") || nidNumberField.getText().equals("") || birthdayDatePickerField == null
                || !(termsCheckBox.isSelected()) || salaryTextField.getText().equals("")){
                    errorLabelTextField.setText("Fields are Empty! OR Passwords don't match!");
        }
     else{
        switch (userTypeSignUpChoiceBox.getValue()) {
                case "Teacher":
                    
                    database = "src\\Database\\Teacher.bin";
                    break;
                case "Librarian":
                    
                    database = "src\\Database\\Librarian.bin";
                    break;
                case "Event Planner":
                    
                    database = "src\\Database\\Event Planner.bin";
                    break;
                case "Administrator":
                    
                    database = "src\\Database\\Administrator.bin";
                    break;
                default:
                    break;
        }
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File(database);
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            switch (userTypeSignUpChoiceBox.getValue()) {
                case "Teacher":
                    Teacher t = null;
                    t = new Teacher(
                        fullNameField.getText(),
                        usernameField.getText(),
                        emailField.getText(),
                        InitialPasswordField.getText(),
                        "Teacher",
                        phoneNumberField.getText(),
                        gender,
                        nidNumberField.getText(),
                        ++id, 
                        birthdayDatePickerField.getValue(),
                        parseInt(salaryTextField.getText())
                    );
                    oos.writeObject(t);
                    break;
                case "Librarian":
                    Librarian l = null;
                    l = new Librarian(
                        fullNameField.getText(),
                        usernameField.getText(),
                        emailField.getText(),
                        InitialPasswordField.getText(),
                        "Librarian",
                        phoneNumberField.getText(),
                        gender,
                        nidNumberField.getText(),
                        ++id, 
                        birthdayDatePickerField.getValue(),
                        parseInt(salaryTextField.getText())
                    );
                    oos.writeObject(l);
                    break;
                case "Event Planner":
                    EventPlanner e = null;
                    e = new EventPlanner(
                        fullNameField.getText(),
                        usernameField.getText(),
                        emailField.getText(),
                        InitialPasswordField.getText(),
                        "Event Planner",
                        phoneNumberField.getText(),
                        gender,
                        nidNumberField.getText(),
                        ++id, 
                        birthdayDatePickerField.getValue(),
                        parseInt(salaryTextField.getText())
                    );
                    oos.writeObject(e);
                    break;
                case "Administrator":
                     Administrator a = null;
                     a = new Administrator(
                        fullNameField.getText(),
                        usernameField.getText(),
                        emailField.getText(),
                        InitialPasswordField.getText(),
                        "Administrator",
                        phoneNumberField.getText(),
                        gender,
                        nidNumberField.getText(),
                        ++id, 
                        birthdayDatePickerField.getValue(),
                        parseInt(salaryTextField.getText())
                    );
                     oos.writeObject(a);
                    break;
                default:
                    break;
            }
            
            

        } catch (IOException ex) {
            Logger.getLogger(StudentSignUpSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(StudentSignUpSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
        appendStudLoginInfo(id, usernameField.getText(), confirmPasswordField.getText(),userTypeSignUpChoiceBox.getValue());
     }
    }
    
    public void appendStudLoginInfo(int id, String username, String password, String user){
        File f = null;
        FileWriter fw = null;
        try {
            int x = 1234567;
            float ff = 3.5f;
            String str = "Hello World";
            FileWriter fw2 = new FileWriter("test.txt");
            fw2.write("x=" + x + ",f=" + ff + ",str=" + str);
            fw2.close();

            f = new File("src\\Database\\"+user+" Database.txt");
            //fw = new FileWriter(f);
            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);
           
            fw.write(
            	id +", "
                +username+", "	
                +password+"\n"	
            );           
  
        } catch (IOException ex) {
            Logger.getLogger(StudentSignUpSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(fw != null) fw.close();
                errorLabelTextField.setText("Successfully Registered!");
            } catch (IOException ex) {
                Logger.getLogger(StudentSignUpSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        
    

    private void showCheckBox() {
        ObservableList list = FXCollections.observableArrayList();
        list.removeAll(list);
        list.add("Teacher");
        list.add("Librarian");
        list.add("Event Planner");
        list.add("Administrator");
        userTypeSignUpChoiceBox.getItems().addAll(list);
        userTypeSignUpChoiceBox.setValue("Librarian");
    }

    @FXML
    private void backButtonHandle(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Administrator Dashboard.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(SignUpEmployeeSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}

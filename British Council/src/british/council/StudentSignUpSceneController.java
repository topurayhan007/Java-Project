/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package british.council;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
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
public class StudentSignUpSceneController implements Initializable {

    @FXML private TextField fullNameField;
    @FXML private TextField emailField;
    @FXML private TextField phoneNumberField;
    @FXML private DatePicker birthdayDatePickerField;
    @FXML private Button registerButton;
    @FXML private CheckBox termsCheckBox;
    private ChoiceBox<String> userTypeSignUpChoiceBox;
    @FXML
    private RadioButton genderMale;
    @FXML
    private RadioButton genderFemale;
    @FXML
    private RadioButton genderOther;
    @FXML
    private TextField nidNumberField;
    @FXML
    private Label errorLabelTextField;
    @FXML
    private PasswordField InitialPasswordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private TextField usernameField;
    @FXML
    private Button logInButton;

    private ToggleGroup tg;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
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
    private void logInButtonHandle(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Log In Scene.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    private int id = 0;
    @FXML
    private void registerButtonHandle(ActionEvent event) {
        
        String gender = null;
        if(genderMale.isSelected()) gender="Male";
        else if(genderFemale.isSelected()) gender="Female";
        else if (genderOther.isSelected()) gender="Other";
        if(!(InitialPasswordField.getText().equals(confirmPasswordField.getText())) || fullNameField.getText().equals("") || usernameField.getText().equals("") 
                || emailField.getText().equals("") || InitialPasswordField.getText().equals("") || confirmPasswordField.getText().equals("") 
                || phoneNumberField.getText().equals("") || nidNumberField.getText().equals("") || birthdayDatePickerField == null
                || !(termsCheckBox.isSelected())){
                    errorLabelTextField.setText("Fields are Empty! OR Passwords don't match!");
        }
     else{
        
        
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("src\\Database\\Student.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            
            Student s = null;
                s = new Student(
                        fullNameField.getText(),
                        usernameField.getText(),
                        emailField.getText(),
                        InitialPasswordField.getText(),
                        "Student",
                        phoneNumberField.getText(),
                        gender,
                        nidNumberField.getText(),
                        ++id, 
                        birthdayDatePickerField.getValue()
                );
            oos.writeObject(s);

        } catch (IOException ex) {
            Logger.getLogger(StudentSignUpSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(StudentSignUpSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
        appendStudLoginInfo(id, usernameField.getText(), confirmPasswordField.getText());
     }
    }
    
    public void appendStudLoginInfo(int id, String username, String password){
        File f = null;
        FileWriter fw = null;
        try {
            int x = 1234567;
            float ff = 3.5f;
            String str = "Hello World";
            FileWriter fw2 = new FileWriter("test.txt");
            fw2.write("x=" + x + ",f=" + ff + ",str=" + str);
            fw2.close();

            f = new File("src\\Database\\Student Database.txt");
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
}
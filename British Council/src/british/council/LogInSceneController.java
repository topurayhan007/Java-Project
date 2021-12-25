/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package british.council;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * FXML Controller class
 *
 * @author topur
 */
public class LogInSceneController implements Initializable {
    public Scanner in;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Text forgotPassword;
    @FXML
    private Text incorrectLogInCredentials;
    @FXML
    private Button logInButton;
    @FXML
    private Text signUp;
    @FXML
    private ChoiceBox<String> userTypeChoiceBox;
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showCheckBox();
    }    

    @FXML
    private void forgotPasswordButtonAction(MouseEvent event) {
        
    }

    @FXML
    private void logInButtonAction(MouseEvent event) {
        String database = ""; String user = null;
        if(usernameField.getText().equals("") || passwordField.getText().equals("") || userTypeChoiceBox.getSelectionModel​().isEmpty()){
            incorrectLogInCredentials.setText("Username or Password Field is Empty! OR no selection in Choice Box!");
        }
        else{
            switch (userTypeChoiceBox.getValue()) {
                case "Student":
                    database = "src\\Database\\Student Database.txt";
                    break;
                case "Teacher":
                    database = "src\\Database\\Teacher Database.txt";
                    break;
                case "Librarian":
                    database = "src\\Database\\Librarian Database.txt";
                    break;
                case "Event Planner":
                    database = "src\\Database\\Event Planner Database.txt";
                    break;
                case "Administrator":
                    database = "src\\Database\\Administrator Database.txt";
                    break;
                default:
                    break;
            }
            verifyLogin(usernameField.getText(), passwordField.getText(), database);
        }    
        if(incorrectLogInCredentials.getText().equals("FOUND")){
                switch (userTypeChoiceBox.getValue()) {
                    case "Student":
                        user = "Student Dashboard.fxml";
                        break;
                    case "Teacher":
                        user = "Teacher Dashboard.fxml";
                        break;
                    case "Librarian":
                        user = "Librarian Dashboard.fxml";
                        break;
                    case "Event Planner":
                        user = "Event Planner Dashboard.fxml";
                        break;
                    case "Administrator":
                        user = "Administrator Dashboard.fxml";
                        break;
                    default:
                        break;
                }
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource(user));
                } catch (IOException ex) {
                    Logger.getLogger(LogInSceneController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
                
            }
    }
    
    
    
    @FXML
    private void signUpButtonAction(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Student Sign Up Scene.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    private void showCheckBox() {
        ObservableList list = FXCollections.observableArrayList();
        list.removeAll(list);
        list.add("Student");
        list.add("Teacher");
        list.add("Librarian");
        list.add("Event Planner");
        list.add("Administrator");
        userTypeChoiceBox.getItems().addAll(list);
        
        userTypeChoiceBox.setValue("Student");
    }
    public void verifyLogin(String username, String password, String database){
        boolean isFound = false;
        String tempId = "";
        String tempUsername= "";
        String tempPassword= "";
        
        try{
            in = new Scanner(new File(database));
            in.useDelimiter("[,\\n]");
            
            while(in.hasNext() && !isFound){
                tempId = in.next();
                tempUsername = in.next();
                tempPassword = in.next();
                
                if(tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim())){
                    isFound = true;
                }
            }
            in.close();
            if(isFound == true){
                incorrectLogInCredentials.setText("FOUND");
            }
            else{
                incorrectLogInCredentials.setText("Incorrect Username or Password! OR Incorrect selection in Choice Box!");
            } 
            
        }
        catch(FileNotFoundException ex){
            incorrectLogInCredentials.setText("Database File Not Found!");
        }
    }
    
    public void setProfile(String user){
        
    }
}

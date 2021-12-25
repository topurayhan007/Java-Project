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
public class LibrarianDashboardController implements Initializable {

    @FXML
    private Button homeButton;
    @FXML
    private Button profileButton;
    @FXML
    private Button enrollMemberButton;
    @FXML
    private Button booksButton;
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
    private AnchorPane booksButtonAnchorPane;
    @FXML
    private TableView<Book> tableview;
    @FXML
    private TableColumn<Book, String> bookNameColumn;
    @FXML
    private TableColumn<Book, String> authorNameColumn;
    @FXML
    private TableColumn<Book, String> statusColumn;
    @FXML
    private TextField bookNameTextField;
    @FXML
    private TextField bookAuthorTextField;
    @FXML
    private TextField bookStatusTextField;
    @FXML
    private Button addBookButton;
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
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        (welcomeAnchorPane).setVisible(true);
    }    

    @FXML
    private void homeButtonHAndle(ActionEvent event) {
        
        (booksButtonAnchorPane).setVisible(false);
        (profileButtonAnchorPane).setVisible(false);
        (profileInfoAnchorPane).setVisible(false);
        (AccountSettingAnchorPane).setVisible(false);
        (enrollMemberAnchorPane).setVisible(false);
        (welcomeAnchorPane).setVisible(true);
    }

    @FXML
    private void profileButtonHandle(ActionEvent event) {
        (booksButtonAnchorPane).setVisible(false);
        (profileButtonAnchorPane).setVisible(true);
        (profileInfoAnchorPane).setVisible(false);
        (AccountSettingAnchorPane).setVisible(false);
        (enrollMemberAnchorPane).setVisible(false);
        (welcomeAnchorPane).setVisible(false);
    }

    @FXML
    private void enrollMemberButtonHandle(ActionEvent event) {
        (booksButtonAnchorPane).setVisible(false);
        (profileButtonAnchorPane).setVisible(false);
        (profileInfoAnchorPane).setVisible(false);
        (AccountSettingAnchorPane).setVisible(false);
        (enrollMemberAnchorPane).setVisible(true);
        (welcomeAnchorPane).setVisible(false);
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Library Member Enrollment Scene.fxml"));
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
    private void booksButtonHandle(ActionEvent event) {
        (booksButtonAnchorPane).setVisible(true);
        (profileButtonAnchorPane).setVisible(false);
        (profileInfoAnchorPane).setVisible(false);
        (AccountSettingAnchorPane).setVisible(false);
        (enrollMemberAnchorPane).setVisible(false);
        (welcomeAnchorPane).setVisible(false);
        
        bookNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        authorNameColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        
        ObservableList<Book> book = FXCollections.observableArrayList();
        
        book = Librarian.viewAllBooks();
        tableview.setItems(book);    
        
        //Allow first and last name to be edittable
        tableview.setEditable(true);
        bookNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        authorNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        statusColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        //allow the table to select multiple rows at once
        tableview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //tableview.getColumns().addAll(subjectColumn, gradeColumn);
    }
    
    
    @FXML
    private void logoutButtonHandle(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Log In Scene.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(LibrarianDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void viewProfileButtonHandle(ActionEvent event) {
        (booksButtonAnchorPane).setVisible(false);
        (profileButtonAnchorPane).setVisible(false);
        (profileInfoAnchorPane).setVisible(true);
        (AccountSettingAnchorPane).setVisible(false);
        (enrollMemberAnchorPane).setVisible(false);
        (welcomeAnchorPane).setVisible(false);
    }

    @FXML
    private void accountSettingButtonHandle(ActionEvent event) {
        (booksButtonAnchorPane).setVisible(false);
        (profileButtonAnchorPane).setVisible(false);
        (profileInfoAnchorPane).setVisible(false);
        (AccountSettingAnchorPane).setVisible(true);
        (enrollMemberAnchorPane).setVisible(false);
        (welcomeAnchorPane).setVisible(false);
    }

    @FXML
    private void backButtonHandle(ActionEvent event) {
        (booksButtonAnchorPane).setVisible(false);
        (profileButtonAnchorPane).setVisible(false);
        (profileInfoAnchorPane).setVisible(false);
        (AccountSettingAnchorPane).setVisible(false);
        (enrollMemberAnchorPane).setVisible(false);
        (welcomeAnchorPane).setVisible(true);
    }

    @FXML
    private void addBookButtonHandle(ActionEvent event) {
        Librarian.addANewBook(bookNameTextField.getText(),bookAuthorTextField.getText(),bookStatusTextField.getText());
        
        Book newBook = new Book(bookNameTextField.getText(),
                                    bookAuthorTextField.getText(),
                                    bookStatusTextField.getText()
                                );
        tableview.getItems().add(newBook);
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
    
}

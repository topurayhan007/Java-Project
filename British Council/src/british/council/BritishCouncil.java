/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package british.council;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author topur
 */
public class BritishCouncil extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Log In Scene.fxml"));
        Scene scene = new Scene(root);
        Image icon = new Image("/icons/BritishCouncil_Logo_Indigo_RGB.png");
        stage.getIcons().add(icon);
        
        stage.setTitle("BRITISH COUNCIL");
        stage.setScene(scene);
        stage.show();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Student> student = new ArrayList<>();
       
        launch(args);
    }
    
}

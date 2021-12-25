/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package british.council;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import static java.lang.Float.parseFloat;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author topur
 */
public class Student extends User implements Serializable{
public static Scanner sc;    
    public Student(String name, String username, String email, String password, String userType, String phoneNumber, String gender, String nidNo, int id, LocalDate birthday) {
        super(name, username, email, password, userType, phoneNumber, gender, nidNo, id, birthday);
    }
    
    public void registerForExam(){
        
    }
    public static void enrollForCourse(){
        
    }
    public static ObservableList<Exam> checkResult(String username){
        ObservableList<Exam> exm = FXCollections.observableArrayList();
        File f = null;
        
        String s = ""; String m = ""; String g= "";
        try {
            f = new File("src\\Examination Database\\"+username+".txt");
            sc = new Scanner(f);
            sc.useDelimiter("[,\\n]");
            if(f.exists()){
                while(sc.hasNextLine()){
                    s = sc.next();
                    m = sc.next();
                    g = sc.next();
                    System.out.println(s+parseFloat(m)+" "+g);
                    exm.add(new Exam(s, parseFloat(m), g));
                    //System.out.println(exm);
                }  
            }
            else 
                System.out.println("oops! file does not exist...");
            
        } 
        catch (Exception ex) {
            Logger.getLogger(StudentDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
            sc.close();
        }        
        return exm; 

        /*ObservableList<Exam> exm = FXCollections.observableArrayList();
      
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src\\Examination Database\\"+username+".bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Exam exam;
            try{
                
                while(true){
                    System.out.println("Printing objects.");
                    exam = (Exam)ois.readObject();
                    System.out.println(exam.toString());
                    exm.add(exam);
                    
                }
            }//end of nested try
            catch(Exception e){
                //
            }//nested catch     
                       
        } catch (IOException ex) { } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }           
    
        return exm; 
*/
    }
}
    

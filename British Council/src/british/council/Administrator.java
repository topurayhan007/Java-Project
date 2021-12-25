/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package british.council;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author topur
 */
public class Administrator extends User implements Serializable{
    private int salary;

    public Administrator(String name, String username, String email, String password, String userType, String phoneNumber, String gender, String nidNo, int id, LocalDate birthday,int salary) {
        super(name, username, email, password, userType, phoneNumber, gender, nidNo, id, birthday);
        this.salary = salary;
    }

    
    

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    public void updatePolicy(){
        
    }
    public void updateEmployeeSalary(){
        
    }
    public void addNewEmployee(){
        
    }
    public static ObservableList<Student> generateStudentReport(){
        ObservableList<Student> t = FXCollections.observableArrayList();
        //Series<String, Number> series = new XYChart.Series<String, Number>();
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src\\Database\\Student.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Student emp;
            try{
                
                while(true){
                    System.out.println("Printing objects.");
                    emp = (Student)ois.readObject();
                    System.out.println(emp.toString());
                    t.add(emp);
                    
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
    
        return t;
    
    }
    public static ObservableList<Librarian> generateLibrarianReport(){
        ObservableList<Librarian> t = FXCollections.observableArrayList();
        //Series<String, Number> series = new XYChart.Series<String, Number>();
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src\\Database\\Librarian.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Librarian emp;
            try{
                
                while(true){
                    System.out.println("Printing objects.");
                    emp = (Librarian)ois.readObject();
                    System.out.println(emp.toString());
                    t.add(emp);
                    
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
    
        return t;
    }
    
}

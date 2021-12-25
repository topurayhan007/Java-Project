/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package british.council;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author topur
 */
public class Librarian extends User implements Serializable{
    int salary;

    public Librarian(String name, String username, String email, String password, String userType, String phoneNumber, String gender, String nidNo, int id, LocalDate birthday,int salary) {
        super(name, username, email, password, userType, phoneNumber, gender, nidNo, id, birthday);
        this.salary = salary;
    }

    
    

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    
    public static ObservableList<Book> viewAllBooks(){
        ObservableList<Book> b = FXCollections.observableArrayList();
      
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src\\Database\\Books.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Book book;
            try{
                
                while(true){
                    System.out.println("Printing objects.");
                    book = (Book)ois.readObject();
                    System.out.println(book.toString());
                    b.add(book);
                    
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
    
        return b;  
    }
    
    public static void addANewBook(String bookName, String authorName, String status){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("src\\Database\\Books.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            
            Book book = null;
                book = new Book(
                        bookName,
                        authorName,
                        status
                );
            oos.writeObject(book);

        } catch (IOException ex) {
            Logger.getLogger(StudentSignUpSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(StudentSignUpSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static void enrollMember(){
        
    }
    public static void issueBook(){
        
    }
}
    
    


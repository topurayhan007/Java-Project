/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package british.council;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.StringProperty;
import javafx.stage.FileChooser;

/**
 *
 * @author topur
 */
public class EventPlanner extends User implements Serializable{
    private int salary;

    public EventPlanner(String name, String username, String email, String password, String userType, String phoneNumber, String gender, String nidNo, int id, LocalDate birthday,int salary) {
        super(name, username, email, password, userType, phoneNumber, gender, nidNo, id, birthday);
        this.salary = salary;
    }
    
    
    
    public void participateInEvent(){
        
    }
    public void enrollMember(){
        
    }
    public static String openAFile(ArrayList<String> fileTypeList){
        String send="";
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files", fileTypeList));
        //File f2 = fc.showSaveDialog(null);
        File f = fc.showOpenDialog(null);
        if(f != null){
            try {
                Scanner sc = new Scanner(f);
                String str="";
                while(sc.hasNextLine()){
                    str+=sc.nextLine()+"\n";
                }
                send = str;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(EventPlannerDashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return send;
    }
    public static String saveAfile(ArrayList<String> fileTypeList, String save){
        String send ="";
        File f = null;
        FileWriter fw = null;
        try {
            int x = 1234567;
            float ff = 3.5f;
            String str = "Hello World";
            FileWriter fw2 = new FileWriter("test.txt");
            fw2.write("x=" + x + ",f=" + ff + ",str=" + str);
            fw2.close();
            
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files", fileTypeList));
            f = fc.showSaveDialog(null);
            //fw = new FileWriter(f);
            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);
           
            fw.write(
            	save
            );           
  
        } catch (IOException ex) {
            Logger.getLogger(StudentSignUpSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(fw != null) fw.close();
                send = "Successfully Saved!";
            } catch (IOException ex) {
                Logger.getLogger(EventPlannerDashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Edited Content will be written in: "+f.getAbsolutePath());
        return send;
    }
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package british.council;

import java.io.Serializable;
import java.time.LocalDate;
import javafx.beans.property.StringProperty;

/**
 *
 * @author topur
 */
public class Teacher extends User implements Serializable{
    int salary;

    public Teacher(String name, String username, String email, String password, String userType, String phoneNumber, String gender, String nidNo, int id, LocalDate birthday,int salary) {
        super(name, username, email, password, userType, phoneNumber, gender, nidNo, id, birthday);
        this.salary = salary;
    }

    
    

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    
    public void enrollForTrainingProgram(){
        
    }
    public void gradeStudent(){
        
    }
    public void checkScheduleWork(){
        
    }
}

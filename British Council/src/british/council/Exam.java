/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package british.council;

import java.io.Serializable;
import static java.lang.Double.parseDouble;
import static java.lang.Float.parseFloat;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author topur
 */

public class Exam implements Serializable{
    private String subject;
    private float mark;
    private String grade;

    public Exam(String subject, float mark, String grade) {
        this.subject = subject;
        this.mark = mark;
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    
}
/*public class Exam implements Serializable{
    private SimpleStringProperty subject; 
    private SimpleFloatProperty mark;
    private SimpleStringProperty grade;

    public Exam(String subject, float mark, String grade) {
        this.subject = new SimpleStringProperty(subject);
        this.mark = new SimpleFloatProperty(mark);
        this.grade = new SimpleStringProperty(grade);
    }
    /*
    public StringProperty subjectProperty() {
        return this.subject;
    }

    public FloatProperty markProperty() {
        return this.mark;
    }

    public StringProperty gradeProperty() {
        return this.grade;
    }

    public String getSubject() {
        return subject.get();
    }

    public void setSubject(String subject) {
        this.subject= new SimpleStringProperty(subject);
    }

    public float getMark() {
        return mark.get();
    }

    public void setMark(float mark) {
        this.mark= new SimpleFloatProperty(mark);
    }

    public String getGrade() {
        return grade.get();
    }

    public void setGrade(String grade) {
        this.grade= new SimpleStringProperty(grade);
    }

    

   
}
*/
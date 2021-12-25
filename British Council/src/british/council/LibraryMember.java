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
public class LibraryMember implements Serializable{
    private StringProperty name, email, password, phoneNumber, gender, nidNo;
    private int id;
    private LocalDate birthday;

    public LibraryMember(StringProperty name, StringProperty email, StringProperty password, StringProperty phoneNumber, StringProperty gender, StringProperty nidNo, int id, LocalDate birthday) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.nidNo = nidNo;
        this.id = id;
        this.birthday = birthday;
    }

    public StringProperty getName() {
        return name;
    }

    public void setName(StringProperty name) {
        this.name = name;
    }

    public StringProperty getEmail() {
        return email;
    }

    public void setEmail(StringProperty email) {
        this.email = email;
    }

    public StringProperty getPassword() {
        return password;
    }

    public void setPassword(StringProperty password) {
        this.password = password;
    }

    public StringProperty getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(StringProperty phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public StringProperty getGender() {
        return gender;
    }

    public void setGender(StringProperty gender) {
        this.gender = gender;
    }

    public StringProperty getNidNo() {
        return nidNo;
    }

    public void setNidNo(StringProperty nidNo) {
        this.nidNo = nidNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}

package com.example.infiniteOS;

import jakarta.persistence.*;
import org.apache.catalina.User;

import java.io.Serializable;

@Entity
@Table(name = "users")
public class Users implements Serializable {
    int id;
    String username;
    String password;
    int userrole;

    public Users(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserrole() {
        return userrole;
    }

    public void setUserrole(int userrole) {
        this.userrole = userrole;
    }
}

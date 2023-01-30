package com.example.infiniteOS;

import jakarta.persistence.*;

@Entity
@Table(name = "userrole")
public class Userrole {
    int id;
    String userrole;

    public Userrole() {
    }

    public Userrole(int id, String userrole) {
        this.id = id;
        this.userrole = userrole;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }
}

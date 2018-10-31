package com.example.demo.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "person")
    private Set<Pet> pets;

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

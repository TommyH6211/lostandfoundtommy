//Item is a basis for object-oriented programming
//Blocks below are all actions performed on the lost and found item

package com.tommy.lostandfoundtommy.model;

//Jakarta persistence is a JPA API that links Java classes to databases
//Entity, Id, and GeneratedValue give a primary key and counting system to the database
import jakarta.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String lastFound;
    private String status;

    public Item() {
    }

    public Item(String title, String description, String lastFound, String status) {
        this.title = title;
        this.description = description;
        this.lastFound = lastFound;
        this.status = status;
    }

    //Getters and setters, one reads and the other changes stuff, respectively
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLastFound() {
        return lastFound;
    }

    public void setLastFound(String location) {
        this.lastFound = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
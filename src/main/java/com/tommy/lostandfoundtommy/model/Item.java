package com.tommy.lostandfoundtommy.model;

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
package com.child_wellness_tracker.model;

import java.sql.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "meal")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer meal_id;

    @Column(name = "date_time")
    private Timestamp dateTime;

    private String name;
    private String note;

    protected Meal() { }

    public Meal(Timestamp dateTime, String name, String note) {

        this.dateTime = dateTime;
        this.name = name;
        this.note = note;

    }

    public Integer getId() {
        
        return this.meal_id;

    }

    public Timestamp getDate() {
        
        return this.dateTime;

    }

    public void setDate(Timestamp dateTime) {

        this.dateTime = dateTime;

    }

    public String getName() {
        
        return this.name;

    }

    public void setName(String name) {
        
        this.name = name;

    }

    public String getNote() {
        
        return this.note;

    }

    public void setNote(String note) {
        
        this.note = note;

    }
    
}

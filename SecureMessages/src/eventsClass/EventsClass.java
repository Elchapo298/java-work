/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eventsClass;

import java.time.LocalDate;

/**
 *
 * @author Wandi Mtshali
 */
public class EventsClass {
    
    private String eventName, category,location;
    private LocalDate date;

    public EventsClass(String eventName, String category, String location, LocalDate date) {
        this.eventName = eventName;
        this.category = category;
        this.location = location;
        this.date = date;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return  eventName +" | "+ date+" | "+ category+" | "+ location; 
    }
    
    
}

package org.example.springboottutorial;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// To save a Java object to a database, must use the @Entity annotation (when dealing with jakarta).

// @Entity indicates that Customer class is JPA entity that should translate into corresponding table in database.
// IntelliJ IDEA designates it with data icon in the gutter.
@Entity // Must have a Key to be entity (in this case it's id).
public class Customer {
    // Values:
    @Id //The @Id annotation indicates that the id field is the object's ID. IntelliJ IDEA designates it with The ID icon in the gutter.
    @GeneratedValue(strategy = GenerationType.AUTO) // @GeneratedValue tells JPA that the ID should be generated automatically (like a UUID).
    private Integer id; // The key.

    private String firstName;
    private String lastName;

    // SETTERS:
    public void setId(Integer id) { this.id = id; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    // GETTERS:
    public Integer getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }

}

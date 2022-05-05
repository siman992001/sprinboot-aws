package com.test.springboot.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="employee")
public class Employee implements Serializable {
    @Id
    @Column(name="emp_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="emp_seq")
    @SequenceGenerator(name="emp_seq", allocationSize=1)
    private Long Id;

    public void setId(Long id) {
        Id = id;
    }

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="address")
    private String address;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="email_address")
    private String email;

    public Employee(){}

    public Long getId() {
        return Id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

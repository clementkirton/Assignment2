/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author cleme
 */
@Component
public class Student {
  
  @Autowired
  @Value("clement")
  private String name;
  
  @Autowired
  @Value("Kirton")
  private String lastname;
  
  @Autowired
  @Value("02-02-1993")
  private String dob;
  
  @Autowired
  private List<Address> Adresses;
  
  @Autowired
  private List<Grade> Grades;

    public Student() {
    }
    
    public Student(String name, String lastname, String dob, List<Address> Adresses, List<Grade> Grades) {
        this.name = name;
        this.lastname = lastname;
        this.dob = dob;
        this.Adresses = Adresses;
        this.Grades = Grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public List<Address> getAdresses() {
        return Adresses;
    }

    public void setAdresses(List<Address> Adresses) {
        this.Adresses = Adresses;
    }

    public List<Grade> getGrades() {
        return Grades;
    }

    public void setGrades(List<Grade> Grades) {
        this.Grades = Grades;
    }
    
@Override
	public String toString() {
		return "name = "+ name +"\nlastname = " + lastname + "\nDateOfBirth = " + dob +"\nAddress = " + Adresses + "\nGrades = " + Grades ;
	}

    
}

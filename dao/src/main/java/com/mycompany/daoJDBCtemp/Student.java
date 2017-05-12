/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.daoJDBCtemp;

/**
 *
 * @author cleme
 */
public class Student 
{
    private int ID;
    private String Name;
    private String Lastname;
    private String DOB;

    public Student() {
    }

    public Student(String Name, String Lastname, String DOB) {
        this.Name = Name;
        this.Lastname = Lastname;
        this.DOB = DOB;
    }
    
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }
    
    @Override
    public String toString()
    {
        return "\nID = "+ID + " Name = "+getName() +" Lastname = "+ getLastname() + " DateOfBirth = " + getDOB();
    }
}

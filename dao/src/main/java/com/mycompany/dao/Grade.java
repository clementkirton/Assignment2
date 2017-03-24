/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author cleme
 */

@Component
public class Grade {
    
    @Autowired
    @Value("Programing")
    private String Subject;
    @Autowired
    @Value("A")
    private String Letter;

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    public String getLetter() {
        return Letter;
    }

    public void setLetter(String Letter) {
        this.Letter = Letter;
    }
    
    @Override
	public String toString() {
            return"Subject = "+ Subject +" Grade = "+Letter;
        
        }
}

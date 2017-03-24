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
public class Address {
    
    @Autowired
    @Value("Yellow St.")
    private String Street;
    
    @Autowired
    @Value("Houston")
    String City;
    
    @Autowired
    @Value("23345")
    String Zip;

    public Address() {
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getZip() {
        return Zip;
    }

    public void setZip(String Zip) {
        this.Zip = Zip;
    }
    
    @Override
	public String toString() {
            return"Street = "+ Street +" City = "+City + " Zip = " + Zip;
        
        }
    
}

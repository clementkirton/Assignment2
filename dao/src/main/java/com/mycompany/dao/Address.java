/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

/**
 *
 * @author cleme
 */
public class Address {
    
    String Street;
    String City;
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

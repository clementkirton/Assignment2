/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author cleme
 */
public class StudentManager {
    
    public static void main(String[] args) {
        
        
        ApplicationContext context = new FileSystemXmlApplicationContext("SpringXMLConfigDao.xml");
        Student student = (Student) context.getBean("Student");
        System.out.print(student);
    }
    
}

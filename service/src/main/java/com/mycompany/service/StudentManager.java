/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.dao.Student;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author cleme
 */
public class StudentManager {
    
    public static void main(String[] args) throws BeansException {
        
        
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringXMLConfigService.xml");
        Student student = (Student) context.getBean("student");
        System.out.print(student);
    }
    
}

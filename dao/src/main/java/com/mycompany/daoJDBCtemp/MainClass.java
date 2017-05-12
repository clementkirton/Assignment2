/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.daoJDBCtemp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.mycompany.daoJDBCtemp.Student;
import com.mycompany.daoJDBCtemp.JdbcStudentDAO;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author cleme
 */
public class MainClass 
{
    
    
    public static void main(String[] args) 
    {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringXMLConfigDao.xml");
        Student student = (Student) context.getBean("studentnew");  
        
        menu();
 
        
        
    }

    private static void MenuCreate()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringXMLConfigDao.xml");
        Student student = (Student) context.getBean("studentnew");  
        
        String sName = JOptionPane.showInputDialog(null,"Type in your name please");
        String sLast = JOptionPane.showInputDialog(null,"Type in your Lastname please");
        String sDob = JOptionPane.showInputDialog(null,"Type in your DateOfBirth please");
        
        
        student.setName(sName);
        student.setLastname(sLast);
        student.setDOB(sDob);
        JdbcStudentDAO dao = (JdbcStudentDAO) context.getBean("jdbcStudentDAO");
        dao.create(student);
    }

    private static void MenuList() 
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringXMLConfigDao.xml");
        Student student = (Student) context.getBean("studentnew");  
        JdbcStudentDAO dao = (JdbcStudentDAO) context.getBean("jdbcStudentDAO");
        
         String Name = JOptionPane.showInputDialog(null,"Type in your name please");
        List students = dao.getStudentId(Name);
        if(students.isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Nothing Found");
            System.out.println("Nothing Found");
        }
        else
        {
            JOptionPane.showMessageDialog(null,students);
            System.out.println(students);
        }
    }

    private static void menu() 
    {
         String menu = JOptionPane.showInputDialog(null,"What do you want to do?\n1) Create\n2) List\n q) Exit");
        
        switch(menu)
        {
            case "1" : MenuCreate();
           break;
            case "2"  : MenuList();
           break;
            case "q" : System.exit(1);
           break;
            default : menu();
           break;
        }
        menu();
    }
}

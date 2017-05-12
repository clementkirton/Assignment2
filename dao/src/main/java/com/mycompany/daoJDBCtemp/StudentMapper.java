/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.daoJDBCtemp;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author cleme
 */
public class StudentMapper implements RowMapper<Student>
{
    public Student mapRow(ResultSet rs,int rowNum)throws SQLException
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringXMLConfigDAO.xml");
        Student student = (Student) context.getBean("studentnew");
        
        student.setID(rs.getInt("ID"));
        student.setName(rs.getString("NAME"));
        student.setLastname(rs.getString("LASTNAME"));
        student.setDOB(rs.getString("DATEOFBIRTH"));
        
        return student;
    }
}

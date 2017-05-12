/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.daoJDBCtemp;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author cleme
 */
public class JdbcStudentDAO 
{
    
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
      
    public void setDataSource(DataSource dataSource)
    {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);  
    }
    
    public void create(Student student)
    {
        String sql = "INSERT INTO STUDENT " + "(NAME, LASTNAME, DATEOFBIRTH) VALUES (?,?,?)";    
        jdbcTemplate.update(sql,new Object[] {student.getName(),student.getLastname(),student.getDOB()});
        
    }
    
    public void update(String Name, int id)
    {
        String sql = "UPDATE STUDENT SET NAME = ? WHERE ID = ?";
        jdbcTemplate.update(sql,Name,id);
       // jdbcTemplate.update("UPDATE STUDENT SET NAME ='"+Name+"' WHERE ID ="+id);
        
    }
    
    public List<Student> getStudentId(String name)
    {
        String sql = "SELECT * FROM STUDENT WHERE NAME = '"+name+"'";
        List<Student> students = jdbcTemplate.query(sql, new StudentMapper());
        return students;
    }    
    
    public void Delete(int ID)
    {
        String sql = "DELETE FROM STUDENT WHERE ID = ?";
        jdbcTemplate.update(sql,ID);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest;

import com.mycompany.daoJDBCtemp.JdbcStudentDAO;
import com.mycompany.daoJDBCtemp.Student;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cleme
 */



@RestController
public class GreetingController {
    
   
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping(value = "/Students/{name}", method = GET)
    public List<Student> test(@PathVariable("name") String name) {

        ApplicationContext context = new ClassPathXmlApplicationContext("SpringXMLConfigDao.xml");
        JdbcStudentDAO dao = (JdbcStudentDAO) context.getBean("jdbcStudentDAO");
        
        return dao.getStudentId(name);
        
    }
    
    @RequestMapping(value = "/Add/{name}/{lastname}/{dob}", method = GET)
    public void CreateNew(@PathVariable("name")String name,@PathVariable("lastname")String lastname,@PathVariable("dob")String dob)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringXMLConfigDao.xml");
        JdbcStudentDAO dao = (JdbcStudentDAO) context.getBean("jdbcStudentDAO");
        
        Student s = new Student(name,lastname,dob);
        
        dao.create(s);
                
    }
    
    @RequestMapping(value = "/delete/{id}", method = GET)
    public void delete(@PathVariable("id")int id)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringXMLConfigDao.xml");
        JdbcStudentDAO dao = (JdbcStudentDAO) context.getBean("jdbcStudentDAO");
        
       dao.Delete(id);
                
    }
    
     @RequestMapping(value = "/editname/{id}/{newName}", method = GET)
    public void EditName(@PathVariable("id")int id,@PathVariable("newName") String NewName)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringXMLConfigDao.xml");
        JdbcStudentDAO dao = (JdbcStudentDAO) context.getBean("jdbcStudentDAO");
        
       dao.update(NewName, id);
                
    }
    
    

}
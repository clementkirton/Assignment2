/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

//import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author cleme
 */
public class StudentJDBC
{
    private static String dbURL = "jdbc:derby://localhost:1527/Mine;user=clement;password=password";
    private static String tableName = "STUDENT";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;
    
    public static void main(String[] args)
    {
        createConnection();
        insertStudent("LaVals", "Berkeley","1999/02/01");
        ShowAllStudents();
        shutdown();
    }

    private static void createConnection() {
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL); 
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
}

    private static void insertStudent(String name, String lastname, String dob) {
    try
        {
            stmt = conn.createStatement();
            stmt.execute("insert into " + tableName +"(NAME,LASTNAME,DATEOFBIRTH)"+
                    " values ('" + name + "','" + lastname + "','" + dob +"')");
            stmt.close();
        }
    
    catch (SQLException sqlExcept)
        {
            System.out.println(sqlExcept);
            sqlExcept.printStackTrace();
        }
    
    }

    private static void ShowAllStudents() 
    {
        try
        {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + tableName);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)
            {
                //print Column Names
                System.out.print(rsmd.getColumnLabel(i)+"\t\t");  
            }

            System.out.println("\n-------------------------------------------------");

            while(results.next())
            {
                int id = results.getInt(1);
                String restName = results.getString(2);
                String restLastname = results.getString(3);
                String restDob = results.getString(4);
                System.out.println(id + "\t\t" + restName + "\t\t" + restLastname + "\t\t" + restDob);
            }
            results.close();
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
  }
private static void shutdown()
    {
        try
        {
            if (stmt != null)
            {
                stmt.close();
            }
            if (conn != null)
            {
                DriverManager.getConnection(dbURL + ";shutdown=true");
                conn.close();
            }           
        }
        catch (SQLException sqlExcept)
        {
            
        }

    }

}

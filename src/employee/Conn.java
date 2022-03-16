/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee;
import java.sql.*;

/**
 *
 * @author Storyteller
 */
public class Conn {
    public Connection c;
    public Statement s;
    
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///employee_management_system", "root", "");
            s = c.createStatement();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
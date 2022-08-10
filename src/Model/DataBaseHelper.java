/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author sonys
 */
public class DataBaseHelper {
    protected Connection connection;
    ResultSet resultSet;
    Statement statement;
    
    public DataBaseHelper() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://Localhost:3306/db_ahongcell", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
    public ResultSet getmodel(String a) throws SQLException{
        statement= connection.createStatement();
        resultSet=statement.executeQuery("SELECT * FROM "+a);
        
        return resultSet;
    
    }
    
    

}

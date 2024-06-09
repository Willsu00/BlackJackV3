/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjackv3;

/**
 *
 * @author willi
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
    
    private static final String USER_NAME = "pdc";
    private static final String PASSWORD = "pdc";
    private static final String URL = "jdbc:derby://localhost:1527/BlackJack_AccountDetails";
    
    Connection conn;
    
    public DBManager(){
        establishConnection();
    }
    
    public Connection getConnection(){
        System.out.println("Connection Successfull");
        return conn;
        
    }
    
    public void establishConnection(){
        try{
            System.out.println("Establishing Connections...");
            conn = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
        }
        catch(SQLException ex){
            throw new RuntimeException("establishConnection error: "+ex);
        }
    }
    
    public void closeConnections(){
        if (conn!=null){
            try{
                System.out.println("Closing Connections...");
                conn.close();
            }
            catch(SQLException ex){
                System.out.println("Close Connection Error: "+ ex);
            }
        }
    }
    
    public ResultSet queryDB(String sql){
        Connection connection =  this.conn;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        }
        catch(SQLException ex){
            System.out.println("queryDB error: "+ ex);
        }
        return resultSet;
    }
    
    public void updateDB(String sql){
        Connection connection =  this.conn;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        }
        catch(SQLException ex){
            System.out.println("updateDB error: "+ ex);
        }
    }
    
}

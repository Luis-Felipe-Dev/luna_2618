/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Luis-Felipe-Dev
 */
public class ConnectionPool {
    private final String DB = "luna";
    //private final String URL = "jdbc:sqlserver://localhost;databaseName=" + DB;
    private final String URL="jdbc:mysql://localhost:3306/"+DB+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String USER = "root";
    private final String PASS = "123456";
    
    private static ConnectionPool dataSource;
    private BasicDataSource basicDataSource = null;
    
    //constructor
    private ConnectionPool()
    {
        basicDataSource = new BasicDataSource(); //instancio la clase basic
        //basicDataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); //DRIVER Para base de datos MySQL
        basicDataSource.setUsername(USER);
        basicDataSource.setPassword(PASS);
        basicDataSource.setUrl(URL);
        
        //pool de conexiones
        basicDataSource.setMinIdle(5);
        basicDataSource.setMaxIdle(20);
        basicDataSource.setMaxTotal(50);
        basicDataSource.setMaxWaitMillis(-1);
    }
    
    public static ConnectionPool getInstance()
    {
        if(dataSource == null)
        {
            dataSource = new ConnectionPool();
            return dataSource;
        }
        else
        {
            return dataSource;
        }
    }
    
    public Connection getConnection() throws SQLException
    {
        return basicDataSource.getConnection();
    }
    
    public void closeConnection(Connection connection) throws SQLException
    {
        connection.close();
    }

}

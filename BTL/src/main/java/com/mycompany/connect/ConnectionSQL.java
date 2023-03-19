/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tienanh03
 */
public class ConnectionSQL {
    private Connection con;
    public ConnectionSQL() throws ClassNotFoundException, SQLException {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost;encrypt=true;database=BTL;"
                        +"encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2"; 
            String user="sa";
            String password="12345678";
            con= DriverManager.getConnection(connectionUrl,user, password);
    }
    public Connection connect(){
        return con;
    }
    public void close() throws SQLException{
        con.close();
    }
   
}

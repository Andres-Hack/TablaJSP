/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author andres
 */
public abstract class DBOperaciones {
    public static Connection IniciarSesion() throws SQLException {
        Connection cn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");         
            String url = "jdbc:mysql://localhost:3306/dbinventario";
            String user = "root";           
            String password = "sistema123";          
            cn= DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            cn=null;
            System.out.println("Error no se puede cargar el driver:" + e.getMessage());
        } catch (SQLException e) {
            cn=null;
            System.out.println("Error no se establecer la conexion:" + e.getMessage());
        }
        return cn;
    }
}

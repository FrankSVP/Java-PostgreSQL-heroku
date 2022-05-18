/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaremoto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author blood
 */
public class CConexion {
    Connection conexion;
      
    public Connection ConexionBD() {
       
        try {
            // We register the PostgreSQL driver
            // Registramos el driver de PostgresSQL
            try { 
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
            }
            conexion = null;
            // Database connect
            // Conectamos con la base de datos
          conexion = DriverManager.getConnection(
                    "jdbc:postgresql://ec2-3-231-82-226.compute-1.amazonaws.com/dakfetmpvspcdk",
                    "xybpjjikhsfdnk", "762dde3a61b3b9c6be9e6d1a2d9fcf3b547883f5f41de93c06f0c05ac749e34c");
 
            boolean valid = conexion.isValid(50000);
            System.out.println(valid ? "TEST OK" : "TEST FAIL");
             
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
             
        }
          return conexion;
    } 
    
    public void cerrarConexion() throws SQLException{
    conexion.close();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaremoto;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author blood
 */
public class CAlumnos {
    
           public void MostrarAlumno(JTable tablatotaltatipoauto) throws SQLException
    {
      
        CConexion conexion = new CConexion();
        
           
     DefaultTableModel modelo = new DefaultTableModel();
     
       TableRowSorter<TableModel>OrdenaTabla = new TableRowSorter<TableModel>(modelo);
       tablatotaltatipoauto.setRowSorter(OrdenaTabla);
               
        String sql="";
        
       
       
     modelo.addColumn("Codigo");
     modelo.addColumn("Nombres");
     modelo.addColumn("Apellidos");
    
     
     tablatotaltatipoauto.setModel(modelo);
     
    
     
     sql = "select * from alumnos;";
    
    
    String [] datos= new String [3];
    Statement st;
    
       try {
            st = conexion.ConexionBD().createStatement(); 
            
            ResultSet rs =  st.executeQuery(sql);
           
           while (rs.next())
           {
              
               datos[0]= rs.getString(1);
               datos[1]= rs.getString(2);
               datos[2]= rs.getString(3);
             
                
               modelo.addRow(datos);
               
               
           }
           
           tablatotaltatipoauto.setModel(modelo);
           
          
           
       } 
       catch (SQLException ex) 
       {
           System.out.print("Error: " +ex.toString());
       }
       conexion.cerrarConexion();
       
       
    }
           
     public void AgregarAlumno( JTextField nombres, JTextField apellidos) throws SQLException
    {
       CConexion conexion = new CConexion();
 
       
        
     String consulta =("insert into alumnos(nombres,apellidos) values (?,?);");
    
               try {
              
         CallableStatement cs = conexion.ConexionBD().prepareCall(consulta);
         cs.setString(1, nombres.getText());
         cs.setString(2, apellidos.getText());
     
         
      
         cs.execute();
     
         
         JOptionPane.showMessageDialog(null, "Insertó correctamente el Alumno, VERIFIQUE");
                                                  
               } 
               catch (SQLException ex) 
               {
                   JOptionPane.showMessageDialog(null, "No se guardó correctamente los datos" + ex.toString());
                  
               }
               conexion.cerrarConexion();
    
    }
           
           
           
           
}

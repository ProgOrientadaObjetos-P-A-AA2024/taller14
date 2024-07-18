/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete01;

import java.sql.Statement;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Locale;

public class Enlace {
    /** 
     * Connect to a sample database 
     * @return 
    */
    private Connection conn;
       
    public void establecerConexion() {  

        try {  
            // db parameters  
            String url = "jdbc:sqlite:bd/base_ejemplo.db";  
            // create a connection to the database  
            conn = DriverManager.getConnection(url);  
            // System.out.println(conn.isClosed());
            // System.out.println("Connection to SQLite has been established.");  
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }   
        
    } 
    
    public Connection obtenerConexion(){
        return conn;
    }
    
    public void insertarCiudad(Producto producto) {  
  
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format(Locale.US, "INSERT INTO Producto"
                    + " (nombre, valor, iva, porcentaje_iva, valor_final) "
                    + "values ('%s', %.2f, %.2f, %.2f, %.2f)", 
                    producto.obtenerNombre(), 
                    producto.obtenerValor(),
                    producto.obtenerIva(),
                    producto.obtenerPorcentajeIva(),
                    producto.obtenerValorFinal()
            );
            System.out.println(data);
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception: insertarCiudad");
             System.out.println(e.getMessage());  
             
        }  
    }
    
    public ArrayList<Producto> obtenerData() {  
        ArrayList<Producto> lista = new ArrayList<>();
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from Producto;";
            
            ResultSet rs = statement.executeQuery(data);
            while(rs.next()){
                // 
                Producto producto = new Producto(
                        rs.getString("nombre"),
                        rs.getDouble("valor"),
                        rs.getDouble("iva"),
                        rs.getDouble("porcentaje_iva"),
                        rs.getDouble("valor_final")
                );
                lista.add(producto);
            }
            
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception: insertarCiudad");
             System.out.println(e.getMessage());  
             
        }  
        return lista;
    }
    
     
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.DAO;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *Aqui hacemos la conexion de la base datas
 * @author Alejandro
 */
public class Conexion {
     Connection conectar=null;
    
public Connection getconexion() {
    try{
        
        Class.forName("com.mysql.jdbc.Driver");
        conectar= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ahorcadodb","root","7531594682");
        //conectar= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ahorcadodb","root","mysql");
       // System.out.println("conexion exitosa");
    }   catch (SQLException ex) {
            System.out.println("Error de conexión sql");
            JOptionPane.showMessageDialog(null, "Error de conexión sql"+ ex.getMessage());
        }catch(ClassNotFoundException ex){
            System.out.println("Error de conexión clas");
            JOptionPane.showMessageDialog(null, "Error de conexión class"+ ex.getMessage());
        }
        return conectar;
}
}

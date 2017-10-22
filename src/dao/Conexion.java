/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;

/**
 *
 * @author Manuel
 */
public class Conexion {
    protected static Connection conexion=null;
    
    public static Connection getConnection(){
        
        try{
            if(conexion == null){
                    
            //JDBC Driver y base de datos URL
            String JDBC_DRIVER = "com.mysql.jdbc.Driver";
            String DB_URL = "jdbc:mysql://localhost:3306/projectadmin?useSSL=false";

            //Credenciales de la base de datos
            String USER = "root";
            String PASS = "";
                conexion = DriverManager.getConnection(DB_URL, USER, PASS);
                Class.forName(JDBC_DRIVER);
            }
        }catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
        return  conexion;
    }
    
    public void cerrar() throws SQLException{
        if(conexion!= null){
            if(!conexion.isClosed()){
                conexion.close();
            }
        }
    }
}

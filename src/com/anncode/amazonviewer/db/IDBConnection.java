package com.anncode.amazonviewer.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.anncode.amazonviewer.db.DataBase.*;

public interface IDBConnection {
    default Connection conexionDB(){
        Connection conexion = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/amazonviewer","root","");
            if (conexion != null){
                System.out.println("Se estableció la conexión :)");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            return conexion;
        }
    }
}

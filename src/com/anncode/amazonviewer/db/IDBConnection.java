package com.anncode.amazonviewer.db;

import java.sql.Connection;
import java.sql.DriverManager;
import static com.anncode.amazonviewer.db.DataBase.*;

public interface IDBConnection {
    default Connection conexionDB(){
        Connection conexion = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(URL+DBNAME, USER, PASS);
            if (conexion != null){
                System.out.println("Se estableció la conexión :)");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            return conexion;
        }
    }
}

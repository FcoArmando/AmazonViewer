package com.anncode.amazonviewer.dao;

import com.anncode.amazonviewer.db.IDBConnection;
import com.anncode.amazonviewer.model.Movie;
import com.mysql.cj.protocol.Resultset;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import static com.anncode.amazonviewer.db.DataBase.*;

public interface MovieDao extends IDBConnection {



    default Movie setMovieViewed(Movie movie){

        try {
            Connection conexion = conexionDB();
            Statement statement = conexion.createStatement();
            String query = "INSERT INTO " + TVIEWED + " ("+ TVIEWED_MATERIAL + ", " + TVIEWED_ELEMENT +", " + TVIEWED_USER +") " +
                    "VALUES(" + TMATERIAL_ID[0] + ", " + movie.getId()+ ", " + TUSER_ID + ")" ;
            if (statement.executeUpdate(query) > 0){
                System.out.println("Se marcó en visto");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return movie;
    }

    default ArrayList<Movie> read (){
        ArrayList<Movie> movies = new ArrayList();
        try {
            Connection conexion = conexionDB();
            String query = "SELECT * FROM " + TMOVIE;
            PreparedStatement preparedStatement = conexion.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                Movie movie = new Movie(rs.getString(TMOVIE_TITLE),rs.getString(TMOVIE_GENRE), rs.getString(TMOVIE_CREATOR),
                        Integer.valueOf(rs.getString(TMOVIE_DURATION)),Short.valueOf(rs.getString(TMOVIE_YEAR)));

                movie.setId(Integer.valueOf(rs.getString(TMOVIE_ID)));
                movie.setViewed(getMovieViewed(preparedStatement,
                        conexion,
                        Integer.valueOf(rs.getString(TMOVIE_ID))));
                movies.add(movie);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return movies;
    }

    

    public default boolean getMovieViewed(PreparedStatement preparedStatement, Connection conexion, int idMovie){
        boolean viewed = false;
        String query = "SELECT * FROM " + TVIEWED +
                " WHERE " + TVIEWED_MATERIAL + " = ? " + " AND " + TVIEWED_ELEMENT + " = ?" + " AND " + TVIEWED_USER + " = ?";
        ResultSet rs = null;

        try {
            preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setInt(1, TMATERIAL_ID[0]);
            preparedStatement.setInt(2, idMovie);
            preparedStatement.setInt(3, TUSER_ID);


            rs = preparedStatement.executeQuery();

            viewed = rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return viewed;
    }

}

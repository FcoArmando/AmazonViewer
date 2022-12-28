package com.anncode.amazonviewer.dao;

import com.anncode.amazonviewer.db.IDBConnection;
import com.anncode.amazonviewer.model.Movie;
import com.mysql.cj.protocol.Resultset;

import javax.xml.transform.Result;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import static com.anncode.amazonviewer.db.DataBase.*;

public interface MovieDao extends IDBConnection {

    default Movie setMovieViewed(Movie movie){
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
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return movies;
    }

    public default boolean getMovieViewed(){
        return false;
    }

}

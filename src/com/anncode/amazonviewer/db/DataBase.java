package com.anncode.amazonviewer.db;

public class DataBase {
    //constantes para generar la conexión con la base de datos
    public static final String URL = "jdbc:mysql://localhost:3306/";
    public static final String DBNAME = "amazonviewer";
    public static final String USER = "amazonviewer";
    public static final String PASS = "aleister";

    //constantes de la tabla 'movie'
    public static final String TMOVIE = "movie";
    public static final String TMOVIE_ID = "id";
    public static final String TMOVIE_TITLE = "title";
    public static final String TMOVIE_GENRE = "genre";
    public static final String TMOVIE_CREATOR = "creator";
    public static final String TMOVIE_DURATION = "duration";
    public static final String TMOVIE_YEAR = "year";

    //Constantes de la tabla 'material'
    public static final String TMATERIAL = "material";
    public static final String TMATERIAL_ID = "id";
    public static final String TMATERIAL_NAME = "name";

    //constantes de la tabla 'user'
    public static final String TUSER = "user";
    public static final String TUSER_ID = "id";
    public static final String TUSER_NAME = "name";

    //Constantes de la tabla 'viewed'
    public static final String TVIEWED = "viewed";
    public static final String TVIEWED_ID = "id";
    public static final String TVIEWED_MATERIAL = "id_material";
    public static final String TVIEWED_ELEMENT = "id_element";
    public static final String TVIEWED_USER = "id_user";

}

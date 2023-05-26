package com.edu.uniminuto.eds.config;

import java.util.Vector;

public class Constants {

    public final static String JDBC_DRIVER = "org.h2.Driver";
    public final static String DB_URL = "jdbc:h2:~/test";
    public final static String USER = "sa";
    public final static String PASS = "";

    public static String[] COLUMN_NAMES = {"Id", "Apellido", "Nombre", "Cargo"};

    public static Vector<String> POSITIONS = new Vector<>();
    public static Vector<String> POSITIONS_ONLY = new Vector<>();

    static {
        POSITIONS.add("TODOS");
        POSITIONS.add("Administrador");
        POSITIONS.add("Cajero");
        POSITIONS.add("Vendedor");

        POSITIONS_ONLY.add("Administrador");
        POSITIONS_ONLY.add("Cajero");
        POSITIONS_ONLY.add("Vendedor");
    }

    private Constants() {

    }
}

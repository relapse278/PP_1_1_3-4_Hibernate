package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public final class Util {
    // реализуйте настройку соеденения с БД
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

//    // testing the program with another DB
//    private static final String DB_URL = "jdbc:mysql://localhost:3306/kata_preproject_1";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    private static Util instance;

    private Util() {

    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER).getDeclaredConstructor().newInstance();
            System.out.println("Connection OK!");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch(Exception ex) {
            System.out.println("Connection ERROR!");
            ex.printStackTrace();
        }

        return connection;
    }

    public static Util getInstance() {
        Util localInstance = instance;
        if (null == localInstance) {
            synchronized (Util.class) {
                localInstance = instance;
                if (null == localInstance) {
                    instance = localInstance = new Util();
                }
            }
        }
        return localInstance;
    }
}
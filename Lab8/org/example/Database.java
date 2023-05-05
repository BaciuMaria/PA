package org.example;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";
    private static ComboPooledDataSource cpds = null;

    private Database() {}

    public static Connection getConnection() throws SQLException {
        if (cpds == null) {
            createConnection();
        }
        return cpds.getConnection();
    }

    private static void createConnection(){
            cpds = new ComboPooledDataSource();
            try {
                cpds.setDriverClass("org.postgresql.Driver");
            }catch (PropertyVetoException e) {
                System.err.println(e);
            }
                cpds.setJdbcUrl(URL);
                cpds.setUser(USER);
                cpds.setPassword(PASSWORD);
                cpds.setMaxStatements( 180 );
    }

    public static void closeConnection() {
        if (cpds != null) {
            cpds.close();
        }
    }
}
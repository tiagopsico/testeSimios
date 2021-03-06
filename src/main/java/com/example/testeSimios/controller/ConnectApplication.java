package com.example.testeSimios.controller;

//import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

import java.sql.*;
import java.util.*;
import java.util.logging.Logger;

public class ConnectApplication {
    private static final Logger log;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
        log =Logger.getLogger(ConnectApplication.class.getName());
    }

    public static void main(String[] args) throws Exception {
        log.info("Loading application properties");
        Properties properties = new Properties();
        properties.load(ConnectApplication.class.getClassLoader().getResourceAsStream("application.properties"));

        log.info("Connecting to the database");
        //Connection connection = DriverManager.getConnection(properties.getProperty("spring.datasource.url"), properties);
        //String url ="jdbc:mysql://%s:%s/%s[?verifyServerCertificate=true&useSSL=true&requireSSL=true]",{your_host},{your_port},{your_database}"; myDbConn = DriverManager.getConnection(url, {username@servername}, {your_password}";
        //String url = "jdbc:mysql://testesimios.mysql.database.azure.com:3306/testesimios?serverTimezone=UTC"; 
        String url = "jdbc:mysql://34.151.236.69:3306/testesimios?serverTimezone=UTC";
        //p738320695384-dojrtm@gcp-sa-cloud-sql.iam.gserviceaccount.com
        Connection connection = DriverManager.getConnection( url, "meuadmin@testesimios", "admin123!");
        log.info("Database connection test: " + connection.getCatalog());
/*
        log.info("Create database schema");
        Scanner scanner = new Scanner(ConnectApplication.class.getClassLoader().getResourceAsStream("schema.sql"));
        Statement statement = connection.createStatement();
        while (scanner.hasNextLine()) {
            statement.execute(scanner.nextLine());
        }
/*
        /*
        Todo todo = new Todo(1L, "configuration", "congratulations, you have set up JDBC correctly!", true);
        insertData(todo, connection);
        todo = readData(connection);
        todo.setDetails("congratulations, you have updated data!");
        updateData(todo, connection);
        deleteData(todo, connection);
        */

        log.info("Closing database connection");
        connection.close();
        //AbandonedConnectionCleanupThread.uncheckedShutdown();
    }

	
}



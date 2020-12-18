package com.ss.week2.jdbcakbar.service;

import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class ConnectionService {
    private final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/utopia?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
    private final String USER_NAME = "user";
    private final String PASS = "pass";

    private Connection conn;

    public ConnectionService() {
        conn = null;
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(URL, USER_NAME, PASS);
            conn.setAutoCommit(false);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }

    @PreDestroy
    public void destroy() throws SQLException {
        if(!conn.isClosed()) conn.close();
    }
}

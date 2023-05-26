package com.edu.uniminuto.eds.model;

import com.edu.uniminuto.eds.config.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserCRUD {

    static {
        try {
            Class.forName(Constants.JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public UserCRUD() throws SQLException {
        try (Connection conn = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS)) {
            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS MARKET_USER " + "( " + "USER_ID INTEGER AUTO_INCREMENT NOT NULL, " + "LAST_NAME VARCHAR(255), " + "FIRST_NAME VARCHAR(255), " + "POSITION VARCHAR(255), " + "PRIMARY KEY (USER_ID)" + ") ");
            }
        }
        fullScan();
    }

    public void fullScan() throws SQLException {
        try (Connection conn = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS)) {
            try (Statement stmt = conn.createStatement()) {
                try (ResultSet rs = stmt.executeQuery("SELECT USER_ID, LAST_NAME, FIRST_NAME, POSITION FROM MARKET_USER")) {
                    while (rs.next()) {
                        System.out.println(String.format("id: %s, First: %s, Last: %s, Position: %s", rs.getInt("USER_ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"), rs.getString("POSITION")));
                    }
                }
            }
        }
    }

    public void createNewUser(User user) throws SQLException {
        try (Connection conn = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS)) {
            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate(String.format("INSERT INTO MARKET_USER (LAST_NAME, FIRST_NAME, POSITION) VALUES ('%s','%s','%s') ", user.getSurName(), user.getFirstName(), user.getPosition()));
            }
        }
    }

    public Object[][] findAll() throws SQLException {
        List<List<String>> tableData = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS)) {
            try (Statement stmt = conn.createStatement()) {
                try (ResultSet rs = stmt.executeQuery("SELECT USER_ID, LAST_NAME, FIRST_NAME, POSITION FROM MARKET_USER")) {
                    resultSetFlow(tableData, rs);
                }
            }
        }
        return loadTableData(tableData);
    }

    private Object[][] loadTableData(List<List<String>> tableData) {
        Object[][] data = new Object[tableData.size()][4];
        for (int i = 0; i < tableData.size(); i++) {
            data[i] = tableData.get(i).toArray();
        }
        return data;
    }

    public Object[][] findByPosition(String position) throws SQLException {
        List<List<String>> tableData = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS)) {
            try (Statement stmt = conn.createStatement()) {
                try (ResultSet rs = stmt.executeQuery("SELECT USER_ID, LAST_NAME, FIRST_NAME, POSITION FROM MARKET_USER WHERE POSITION = '" + position + "'")) {
                    resultSetFlow(tableData, rs);
                }
            }
        }
        return loadTableData(tableData);
    }

    private void resultSetFlow(List<List<String>> tableData, ResultSet rs) throws SQLException {
        while (rs.next()) {
            List<String> row = new ArrayList<>();
            row.add(Integer.toString(rs.getInt("USER_ID")));
            row.add(rs.getString("FIRST_NAME"));
            row.add(rs.getString("LAST_NAME"));
            row.add(rs.getString("POSITION"));
            tableData.add(row);
        }
    }
}

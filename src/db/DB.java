package db;

import db.exceptions.DbException;

import java.sql.*;
import java.util.Properties;

public class DB {
    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Properties props = DbProperties.load();
                String url = props.getProperty("dburl");

                conn = DriverManager.getConnection(url, props);
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }

        return conn;
    }

    public static void closeConnection() {
        if (conn == null)
            return;

        try {
            conn.close();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void closeStatement(Statement stmt) {
        try {
            stmt.close();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void closeResultSet(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
}

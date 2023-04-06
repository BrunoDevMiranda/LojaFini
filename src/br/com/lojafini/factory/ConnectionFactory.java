package br.com.lojafini.factory;

import java.sql.*;

public class ConnectionFactory {

    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost/lojafini?useTimeZone=true&serverTimezone=UTC";
    private static String user = "root";
    private static String password = "643499br";

    public static Connection getConnection() throws DbException {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new DbException(e.getMessage());
        }
        return conn;
    }

    public static void closeConnection(Connection conn) throws DbException {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closePreparedStatement(PreparedStatement ps) throws DbException {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) throws DbException {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}

package com.mayi.dao;

import java.sql.*;
/*
 *ConnectDAO deprecated USE HIBERNATE for sql queries
 */
public abstract class ConnectDAO {
    private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private final String user = "tanjim";
    private final String pass = "password";
    private final Driver driver = new oracle.jdbc.driver.OracleDriver();

    protected Connection conn = null;
    protected PreparedStatement ps = null;
    protected ResultSet rs = null;

    public Connection getConn() throws SQLException {
        Connection connection = DriverManager.getConnection(url,user,pass);
        return connection;
    }

//    public void dispose() {
//        try {
//            if(!rs.equals(null)) {
//                if(!rs.isClosed()) rs.close();
//            }
//            if(ps.equals(null)) {
//                if(!rs.isClosed()) ps.close();
//            }
//            if(!conn.equals(null)) {
//                if(!conn.isClosed()) conn.close();
//            }
//        }
//        catch(Exception e) {
//            e.printStackTrace();
//        }
//    }
}

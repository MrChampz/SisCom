package com.upco.siscom.dal;

import java.sql.*;

public class ConnectionModule {
    
    public static Connection connector() {
        String url = "jdbc:mysql://remotemysql.com:3306/95DF766qmi";
        String user = "95DF766qmi";
        String passwd = "4SMk4PC7EW";

        try {
            return DriverManager.getConnection(url, user, passwd);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}

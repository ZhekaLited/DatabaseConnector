package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("awd");
        //Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/counrywork", "root", "root")) {
            var p = connection.prepareStatement("select * from employees");
            var rs = p.executeQuery();

            while (rs.next()) {
                String last_name = rs.getString("Last_Name");
                System.out.println(last_name);
            }
        }

    }
}

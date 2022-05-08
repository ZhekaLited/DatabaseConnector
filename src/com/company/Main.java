package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/counrywork", "root", "root")) {
            Statement statement = connection.createStatement();


         /*   int rows = statement.executeUpdate("DELETE FROM `counrywork`.`employees` WHERE (`EMPLOYEE_ID` = '7');");
            System.out.printf("%d row(s) deleted", rows); //Для удаление из базы данных инфы
        }
/*

             //int rows = statement.executeUpdate("INSERT INTO `counrywork`.`employees` (`FIRST_NAME`, `LAST_NAME`) VALUES ('Дима', 'Павлов');");
          //  System.out.printf("Added %d rows",rows); //Это для ее изменение из базы




          /*  var p = connection.prepareStatement("select employees.Last_name , Departments.DEPARTMENT_NAME FROM EMPLOYEES JOIN DEPARTMENTS ON EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID");
            var rs = p.executeQuery();

            while (rs.next()) {
                String last_name = rs.getString("Last_Name");
                String DEPARTMENT = rs.getString("DEPARTMENT_NAME");
                System.out.println(last_name + " -- " + DEPARTMENT);    //Это для вывода инфы из базы
            }
        }
*/
        }
    }
}

То есть пока в resultSet есть доступные строки, будет выполняться цикл while, который будет переходить к следующей строке в наборе.

После перехода к строке мы можем получить ее содержимое. Для этого у ResultSet определен ряд методов. Некоторые из них:

getBoolean() возвращает значение boolean

getDate() возвращает значение Date

getDouble() возвращает значение double

getInt() возвращает значение int

getFloat() возвращает значение float

getLong() возвращает значение long

getNString() возвращает значение String

getString() возвращает значение String

В зависимости от того, данные какого тип хранятся в том или ином столбце, мы можем использовать тот или иной метод. Каждый из этих методов имеет две версии:

Ссылка для установки драйвера для базы : https://metanit.com/java/database/2.1.php
Ссылка для подключение баззы данных : https://metanit.com/java/database/2.2.php

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

  Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/counrywork", "root", "root")) {
            Statement statement = connection.createStatement();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Input product name: ");
            String name = scanner.nextLine();

            System.out.print("Input product price: ");
            String price = scanner.nextLine();

            String sql = "INSERT INTO Employees (First_Name,Last_Name) Values (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, price);
            Все методы, которые поставляют значения вместо знаков подстановки, в качестве первого параметра принимают порядковый номер знака подстановки 
            (нумерация начинается с 1), а в качестве второго параметра - собственно значение, которое вставляется вместо знака подстановки.
                
            Например, первый знак подстановки ? в выражении sql представляет значение для столбца ProductName, который хранит строку.
            Поэтому для связи значения с первым знаком подстановки применяется метод preparedStatement.setString(1, name).

            Второй знак подстановки должен передавать значение для столбца Price, который хранит целые числа. 
            Поэтому для вставик значения используется метод preparedStatement.setString(2, price)
                
            Кроме setString и setInt PreparedStatement имеет еще ряд подобных методов, которые работают подобным образом. Некоторые из них:

setBigDecimal

setBoolean

setDate

setDouble

setFloat

setLong

setNull

setTime

            int rows = preparedStatement.executeUpdate();

            System.out.printf("%d rows added", rows);
        } // Это вставление данных с консоли при помощью Scanner

Для выполнения запроса PreparedStatement имеет три метода:

boolean execute(): выполняет любую SQL-команду

ResultSet executeQuery(): выполняет команду SELECT, которая возвращает данные в виде ResultSet

int executeUpdate(): выполняет такие SQL-команды, как INSERT, UPDATE, DELETE, CREATE и возвращает количество измененных строк

При этом в отличие от методов Statement эти методы не принимают SQL-выражение.
    
    
    
Подобным образом мы можем выполнять и другие выражения. Например, получим товары, у которых цена меньше 50000:

int maxPrice = 50000;
PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Products WHERE Price < ?");
preparedStatement.setInt(1, maxPrice);
ResultSet resultSet = preparedStatement.executeQuery();
while(resultSet.next()){
                                     
    int id = resultSet.getInt("Id");
    String name = resultSet.getString("ProductName");
    int price = resultSet.getInt("Price");
                     
    System.out.printf("%d. %s - %d \n", id, name, price);


package org.example;

import org.example.util.DBConnect;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)   {
        DBConnect dbConnect = new DBConnect();
        try{
            Connection connection = dbConnect.openConnectToDB();
//            String sql = "select * from product where name like " + "'Jeans'";
            String sql = "select * from product where name like ?" ;
//            Statement statement = connection.createStatement();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "Jeans");
//            ResultSet resultSet =  statement.executeQuery(sql);
            ResultSet resultSet =  preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.print(resultSet.getInt("id") + " ");
                System.out.print(resultSet.getString("name") + " ");
                System.out.print(resultSet.getInt("price") + " ");
                System.out.print(resultSet.getInt("status") + "\n");
            }
            connection.close();
        }catch (SQLException e){
            System.out.println("Err");
        }

    }
}
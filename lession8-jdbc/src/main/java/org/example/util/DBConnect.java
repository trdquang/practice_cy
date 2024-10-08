package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    public Connection openConnectToDB() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/cy_prac1"; // Thay "tên_cơ_sở_dữ_liệu" bằng tên cơ sở dữ liệu của bạn
        String userName = "root";
        String password = "1234";

        Connection connection = null;
        try  {
            // Tạo kết nối
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Kết nối thành công!");
        } catch (SQLException e) {
//            System.out.println("Kết nối thất bại!");
//            e.printStackTrace();
            throw new IllegalStateException("Nopppp", e);
        }
        return connection;
    }

    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

}

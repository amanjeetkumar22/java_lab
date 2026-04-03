package JDBC;
import java.sql.*;

public class First {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cse16", "root", "845306aman@");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            System.out.println("Roll Number: 24051155");
            System.out.println("Database Output:");

            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) + " " +
                                rs.getString(2) + " " +
                                rs.getInt(3)
                );
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
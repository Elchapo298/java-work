/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javadbtestone;

import java.sql.*;

/**
 *
 * @author Wandi Mtshali
 */
public class JavaDBTestOne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/testOne");

        Statement statement = con.createStatement();

        String sql = "INSERT INTO testOne (ID, CAR, PRICE) VALUES (?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, 2);
        ps.setString(2, "VW");
        ps.setInt(3, 2500000);

        ps.executeUpdate();

        ResultSet rs = statement.executeQuery("SELECT * FROM testOne");
        while (rs.next()) {
            int id = rs.getInt("ID");
            String car = rs.getString("CAR");
            int price = rs.getInt("PRICE");

            System.out.println(id + " | " + car + " | " + price);

        }

    }

}

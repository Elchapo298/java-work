
import java.sql.*;
import java.util.Scanner;

public class MovieLibraryApp {

    public static void main(String[] args) {

        String dbURL = "jdbc:derby://localhost:1527/MovieLibrary"; //Modify according to your system

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        // Initialize Scanner for user input
        Scanner scanner = new Scanner(System.in);

        try {

            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/MovieLibrary");
            // Connect to the database (1)

            stmt = conn.createStatement();
            // Create a Statement object (1)

            rs = stmt.executeQuery("SELECT * FROM MOVIES query");
            // Execute the SELECT * FROM MOVIES query (1)

            // Display menu
            System.out.println("Menu:");
            System.out.println("1. Check Stock by Director");
            System.out.println("2. Calculate Average Rating");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Call the checkStockByDirector function
                    checkStockByDirector(rs, scanner);
                    break;
                case 2:
                    // Call the calculateAverageRating function
                    calculateAverageRating(rs);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    break;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // Close resources (1) 
            try {
                rs.close();
                stmt.close();
                conn.close();

            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        scanner.close();
    }

// Implement the checkStockByDirector function here (8)
    public static void checkStockByDirector(ResultSet rs, Scanner scanner) {

        System.out.println("Enter directores name ");
        String directorName = scanner.nextLine();

        try {

            int total = 0;

            while (rs.next()) {
                String directorGet = rs.getString("director");
                if (directorGet.equalsIgnoreCase(directorName)) {

                    total += rs.getInt("stock");

                }

            }
            System.out.println("Total stock for director " + directorName + ": " + total);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

// Implement the calculateAverageRating function here (5)
    public static void calculateAverageRating(ResultSet rs) {

        try {
            double totalRating = 0.0;
            int count = 0;
            while (rs.next()) {
                totalRating += rs.getDouble("rating");
                count++;

            }
            if (count > 0) {

                double avarageRating = totalRating / count;
                System.out.printf("Avarage rating of all movies : %2f%n", avarageRating);

            } else {

                System.out.println("No movies found. ");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

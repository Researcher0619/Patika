import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        // Database connection
        Connection connection = null;

        try {
            // Connect to the database
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dvdrental", "postgres", "postgres");
            System.out.println("Connected to the database successfully!");

            // Create a SQL statement
            Statement statement = connection.createStatement();

            // Execute a SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM actor LIMIT 10;");

            // Print the results
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("actor_id"));
                System.out.println("First Name: " + resultSet.getString("first_name"));
                System.out.println("Last Name: " + resultSet.getString("last_name"));
                System.out.println("##############################################");
            }

        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        } finally {
            // Close the connection
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Connection closed successfully.");
                } catch (SQLException e) {
                    System.err.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }
}

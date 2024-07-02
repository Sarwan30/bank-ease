package bankmanagementsystem;
import java.sql.*;

public class Conn {
    /*  DataBase Connectivity Using JDBC

        There are 5 Steps for JDBC Connectivity

        1. Register The Driver.
        2. Create Connection.
        3. Create Statement.
        4. Execute Query.
        5. Close Connection.
     */
    Connection c;
    Statement s;

    public Conn(){
        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Create connection
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "Sarwan@123");

            // Step 3: Create statement
            s = c.createStatement();

            System.out.println("Connected to database!");
        } catch (Exception e) {
            System.out.println("Connection error: " + e);
        }
    }

    public static void main(String[] args) {
        // Test your connection
        Conn conn = new Conn();
    }
}

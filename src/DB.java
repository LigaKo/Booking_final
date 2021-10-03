import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {
    public Connection connection = null;
    public PreparedStatement preStatement = null;
    public ResultSet result = null;
    private final static String CONNECTION_URL = "jdbc:mysql://localhost/final_project";

    public DB() {
        try {
            connection = DriverManager.getConnection(CONNECTION_URL, "root", "Parole123");
        } catch (SQLException e) {
            System.out.println("[!] Cannot connect to the Database:  " + e.getMessage());
        }
    }
}

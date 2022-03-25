package Module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author sangv
 */
public class DB_Handler {

    private static String DB_HostName = "jdbc:mysql://localhost:3306/jdbc_oop_test";
    private static String DB_User = "jdbc_tester";
    private static String DB_Pass = "1";

    private static final String createTableQuery = """
                                                   create table NPC_Lastname (
                                                     id  int(3) primary key,
                                                     name varchar(20),
                                                     email varchar(20),
                                                     country varchar(20),
                                                     password varchar(20)
                                                    );""";
    
    public static final String insertQuery = """
                                             
                                             """;

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_HostName, DB_User, DB_Pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            } else {
                System.err.println("Unexpected ERR");
            }
        }
    }

    public void createTable() throws SQLException {

        System.out.println(createTableQuery);
        try ( Connection conn = getConnection();  Statement statement = conn.createStatement();) {

            statement.execute(createTableQuery);
        } catch (SQLException e) {

            printSQLException(e);
        }

    }
    
    
}

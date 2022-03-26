package Module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author Quang Sang <quangsang.red@gmail.com>
 */
public class DB_Handler {

    private static String DB_HostName = "jdbc:mysql://localhost:3306/jdbc_oop_test";
    private static String DB_User = "jdbc_tester";
    private static String DB_Pass = "1";

    private static final String createTableQuery = """
                                                   create table NPC_Lastname (
                                                     id int(3) primary key,
                                                     gender int(1),
                                                     name varchar(20),
                                                     tc varchar(20),
                                                     en varchar(20)
                                                    );""";

    public static final String insertQuery = "INSERT INTO NPC_Lastname"
            + " (id, gender, name, tc, en) VALUES "
            + " (?, ?, ?, ?, ?)";
    
    public static final String selectQuery = "select id,gender,name";
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

    public static void createTable(){

        System.out.println(createTableQuery);
        try ( Connection conn = getConnection();  Statement statement = conn.createStatement();) {

            statement.execute(createTableQuery);
        } catch (SQLException e) {

            printSQLException(e);
        }

    }

    public static void pushData(int id, int gender, String name, String tc, String en){
        System.out.println(insertQuery);
        try ( Connection conn = getConnection();  PreparedStatement presta = conn.prepareStatement(insertQuery)) {
            presta.setInt(1, id);
            presta.setInt(2, gender);
            presta.setString(3, name);
            presta.setString(4, tc);
            presta.setString(5, en);

            System.out.println(presta);
            presta.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

}

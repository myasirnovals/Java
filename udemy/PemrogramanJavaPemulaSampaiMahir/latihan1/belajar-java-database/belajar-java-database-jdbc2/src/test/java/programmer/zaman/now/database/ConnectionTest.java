package programmer.zaman.now.database;

import com.mysql.cj.jdbc.Driver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
    @BeforeAll
    static void beforeAll() {
        try {
            Driver mysqlDriver = new Driver();
            DriverManager.registerDriver(mysqlDriver);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Test
    void testConnection() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/belajar_pzn_belajar_java_databases_latihan1?serverTimezone=Asia/Jakarta";
        String username = "root";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            System.out.println("Success");
        } catch (SQLException exception) {
            Assertions.fail(exception);
        }
    }

    @Test
    void testConnectionClose() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/belajar_pzn_belajar_java_databases_latihan1?serverTimezone=Asia/Jakarta";
        String username = "root";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            System.out.println("Success");

            connection.close();
        } catch (SQLException exception) {
            Assertions.fail(exception);
        }
    }

    @Test
    void testConnectionAutoClose() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/belajar_pzn_belajar_java_databases_latihan1?serverTimezone=Asia/Jakarta";
        String username = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Success");
        } catch (SQLException exception) {
            Assertions.fail(exception);
        }
    }
}

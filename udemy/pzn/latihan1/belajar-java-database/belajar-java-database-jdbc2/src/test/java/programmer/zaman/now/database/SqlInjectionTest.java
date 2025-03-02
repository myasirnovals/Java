package programmer.zaman.now.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlInjectionTest {
    @Test
    void testSqlInjection() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String username = "admin'; #'";
        String password = "salah";

        String sql = "SELECT * FROM admin WHERE username = '" + username + "' AND password = '" + password + "'";
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            // success
            System.out.println("Login success : " + resultSet.getString("username"));
        } else {
            // fail
            System.out.println("Login fail");
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}

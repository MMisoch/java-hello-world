package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return ConnectToPostgres();
    }

    public String ConnectToPostgres()
    {
        String host = System.getenv("DATABASE_HOST");
        String port = System.getenv("DATABASE_PORT");
        String database = System.getenv("DATABASE");
        String user = System.getenv("DATABASE_USER");
        String password = System.getenv("DATABASE_PASSWORD");
        //Format jdbc:postgresql://host:port/database
        String jdbcUrl = "jdbc:postgresql://" + host + ":" + port + "/" + database;
        String showOnWebpage = jdbcUrl;
        /* try (Connection connection = DriverManager.getConnection(jdbcUrl, user, password)) {
            showOnWebpage += "Java JDBC PostgreSQL Example\n";
 

            showOnWebpage += "Connected to PostgreSQL database!\n";

            Statement createTableStatement = connection.createStatement();
            createTableStatement.executeQuery("CREATE TABLE IF NOT EXISTS testTable(id SERIAL NOT NULL PRIMARY KEY,word varchar(225) NOT NULL)");

            Statement insertStatement = connection.createStatement();
            insertStatement.executeQuery("INSERT INTO testTable (word) VALUES (hello world);");

            Statement selectStatement = connection.createStatement();
            ResultSet resultSet = selectStatement.executeQuery("SELECT * FROM testTable");
            while (resultSet.next()) {
                showOnWebpage += resultSet.getString("word") + "\n";
            }
 
        } catch (SQLException e) {
            showOnWebpage = "Connection failure";
        } */

        return showOnWebpage;
    } 

}

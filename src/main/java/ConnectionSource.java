import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSource {

    // JDBC driver name and database URL
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    //  Database credentials
    private static final String USER = "postgres";
    private static final String PASS = "1";

    private static final ConnectionSource instance = new ConnectionSource();

    public static ConnectionSource instance() {
        return instance;
    }

    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

}

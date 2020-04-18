package jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtils {
	
    private static Connection dbConnection = null;
    private static Statement statement = null;
    
    public static Connection getConnection()
    {
        if (dbConnection != null)
        {
            return dbConnection;
        }
        else
        {
            try
            {
                InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("db.properties");

                Properties properties = new Properties();

                properties.load(inputStream);

                String dbDriver = properties.getProperty("dbDriver");
                String connectionUrl = properties.getProperty("connectionUrl");
                String userName = properties.getProperty("userName");
                String password = properties.getProperty("password");

                Class.forName(dbDriver).newInstance();
                dbConnection = DriverManager.getConnection(connectionUrl, userName, password);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return dbConnection;
        }
    }
    
    public static void ExecuteSQLStatement(String sql_stmt)
    {
        try {
            statement = getConnection().createStatement();

            statement.executeUpdate(sql_stmt);
        } catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }
    }
    
    public static ResultSet ExecuteGetStatement(String sql_stmt) {
    	ResultSet result = null;
    	try {
            statement = getConnection().createStatement();

            result = statement.executeQuery(sql_stmt);
        } catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }
    	 return result;
    }
    
}

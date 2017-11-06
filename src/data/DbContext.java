package data;


import java.sql.*;

public class DbContext {

    //jdbc driver name and database
    static final String JDBC_Driver = "";
    static final String DB_Server= "jdbc:sqlserver://localhost\\sqldev:1433;databaseName=sample;user=sa;password=P@ssw0rd";

    //database credentials
    static final String user = "sa";
    static final String password = "P@ssw0rd";

    //connection related variables
    Connection connection = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;

    private static DbContext instance = null;
    private DbContext(){}

    public static DbContext getInstance(){
        if(instance == null){
            instance = new DbContext();
        }
        return instance;
    }

    public PreparedStatement getPreparedStatement(String query) throws SQLException {
        preparedStatement = instance.connection.prepareStatement(query);

        return preparedStatement;
    }

    private void createConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz?autoReconnect=true&useSSL=false", "root", "P@ssw0rd");
        statement = connection.createStatement();
    }

    private void closeConnection() throws SQLException {
        if(connection != null){
            connection.close();
        }
    }

    public ResultSet executeQuery(String query) throws SQLException, ClassNotFoundException {
      try {
          createConnection();
          return statement.executeQuery(query);
      }
      finally {
        //closeConnection();
      }

    }

    public int executeUpdate(String query) throws SQLException, ClassNotFoundException {
        try{
            createConnection();
            return statement.executeUpdate(query);
        }
        finally {
            closeConnection();
        }
    }

    public int executeUpdate() throws SQLException, ClassNotFoundException {
        try{
            createConnection();
            return preparedStatement.executeUpdate();
        }
        finally {
            closeConnection();
        }
    }
}

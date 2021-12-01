package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private final String serverName = "MAYTINH-VMMN6QE";
    private final String dbName = "NNLTTT";
    private final String portNumber = "1433";
    private final String instance="";//MSSQLSERVER LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
    private final String userID = "sa";
    private final String password = "sa";
    
    public Connection getConnection()throws Exception {
        String url = "jdbc:sqlserver://"+serverName+":"+portNumber + "\\" + instance +";databaseName="+dbName;
        if(instance == null || instance.trim().isEmpty())
            url = "jdbc:sqlserver://"+serverName+":"+portNumber +";databaseName="+dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }   
 
    public static void main(String[] args) {
		try {
			System.out.println(new DBConnect().getConnection());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

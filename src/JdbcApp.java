
import java.sql.*;
public class JdbcApp {
	  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	  static final String DB_URL = "jdbc:mysql://localhost/Testdb?autoReconnect=true&useSSL=false";

	  //  Database credentials
	  static final String USER = "root";
	  static final String PASS = "";
	  public static void main(String[] args) {
	  Connection conn = null;
	  Statement stmt=null;
	  String inqry1="insert into Testdb.EMPLOYE values(1,'aisiri','aisiri.cs@gmail.com',123456987,'shivamogga','active')";
	  String inqry2="insert into Testdb.EMPLOYE values(2,'sahana','sahana.cs@gmail.com',123456789,'thumkur','inactive')";
	  String inqry3="insert into Testdb.EMPLOYE values(3,'abc','abc.cs@gmail.com',123456789,'karanataka','inactive')";
	  String inqry4="insert into Testdb.EMPLOYE values(4,'def','def.cs@gmail.com',965874321,'goa','active')";
	  String upqry="update Testdb.EMPLOYE set user_status='active' where id=2";
	  String delqry="Delete from Testdb.EMPLOYE where user_status='inactive'";
	  try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Drive class is loaded and register");
		 conn = DriverManager.getConnection(DB_URL,USER,PASS);
		 System.out.println("connection is established");
		 stmt=conn.createStatement();
		 stmt.addBatch(inqry1);
		 stmt.addBatch(inqry2);
		 stmt.addBatch(inqry3);
		 stmt.addBatch(inqry4);
		 stmt.addBatch(upqry);
		 stmt.addBatch(delqry);
		 stmt.executeBatch();
		
		
	      } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  finally
	  {
		  if(stmt!=null)
		  {
			  try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		  if(conn!=null)
		  {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		  }
	  }
	  
	}

}

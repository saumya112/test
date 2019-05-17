import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementGetExample {

	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		

			connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/sqltest1", "root", "root");
		
		
		
			statement = connection.createStatement();
		
		
		String inputQuery = "select * from user1";
		

			ResultSet resultset =statement.executeQuery(inputQuery);
			if(resultset != null) {
				
				while(resultset.next()) {
					
					int id=resultset.getInt(1);
					String email=resultset.getString(2);
					String username=resultset.getString(3);
					String password =resultset.getString(4);
					int salary = resultset.getInt(5);
					String department = resultset.getString(6);
					
					System.out.println(id+","+email+","+username+","+password+","+salary+","+department);
					
					
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		}catch (SQLException e) {
			e.printStackTrace();
	}finally {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	}

}

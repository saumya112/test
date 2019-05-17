import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementExample2 {

	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		

			connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/sqltest1", "root", "root");
		
		
		
			statement = connection.createStatement();
		
		
		String inputQuery = ("UPDATE user1 SET username ='Pratyoosh',salary=12000 WHERE id=3;");
		

			int numberOfRecAffected =statement.executeUpdate(inputQuery);
			System.out.println("numberOfRecAffected:"+numberOfRecAffected);
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



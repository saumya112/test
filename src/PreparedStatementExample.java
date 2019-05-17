import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class PreparedStatementExample {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		

			connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/sqltest1", "root", "root");
		
		
			String inputQuery ="insert into user1(username,password) values(?,?)";
			preparedstatement = connection.prepareStatement(inputQuery);
			preparedstatement.setString(1, "testu");
			preparedstatement.setString(2, "testp");
		
		
		
		

			int numberOfRecAffected =preparedstatement.executeUpdate(inputQuery);
			System.out.println("numberOfRecAffected:"+numberOfRecAffected);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
   	   }finally {
		try {
			connection.close();
		}catch (SQLException e) {
		e.printStackTrace();
		}
		}

	}
}	

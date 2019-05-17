package cum.rs.fer.main;

import com.rs.fer.service.FERService;

import com.rs.fer.service.FERServiceImpl;

public class LoginMain {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();

		String UserName = "user";
		String Password = "password";
		boolean isValidUser = ferService.login(UserName, Password);

		if (isValidUser) {
			System.out.println("User Login is successfully");
		} else {
			System.out.println("User Login is Failed");

		}

	}
}

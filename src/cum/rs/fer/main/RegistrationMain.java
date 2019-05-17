package cum.rs.fer.main;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class RegistrationMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();

		User user = new User();

		user.setFirstname("first");
		user.setMiddlename("middle");
		user.setLastname("last");
		user.setMobilenumber("12354");
		user.setEmail("email");
		user.setUserName("user");
		user.setPassword("password");

		boolean isValidUser = ferService.registration(user);

		if (isValidUser) {
			System.out.println("Registered successfully");
		} else {
			System.out.println("Registration Failed");
		}

	}
}

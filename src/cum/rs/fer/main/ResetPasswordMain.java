package cum.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class ResetPasswordMain {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();

		int id = 6;
		String oldpassword = "raja";
		String newpassword = "testp";

		boolean isValiduser = ferService.resetPassword(id, oldpassword, newpassword);

		if (isValiduser) {
			System.out.println("Reset Password successfully");
		} else {
			System.out.println("Reset Password Failed");
		}
	}
}

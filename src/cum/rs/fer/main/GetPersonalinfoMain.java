package cum.rs.fer.main;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetPersonalinfoMain {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();
		int userid = 9;
		User information = ferService.getPersonalInfo(userid);

		if (information != null) {
			System.out.println("Fetch Success");
		} else
			System.out.println("Fetch Failed");

	}
}

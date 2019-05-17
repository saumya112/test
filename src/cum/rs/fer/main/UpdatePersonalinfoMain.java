package cum.rs.fer.main;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class UpdatePersonalinfoMain {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();
		User user = new User();
		user.setFirstname("Sachin");
		user.setMiddlename("Ramesh");
		user.setLastname("Tendulkar");
		user.setMobilenumber("8796555");
		user.setEmail("sachin@gmail");
		user.setId(1);

		Address address = new Address();
		address.setAdressLane1("aayyppa");
		address.setAdressLane2("h no.111");
		address.setStreet("raod44");
		address.setCity("hydrabad");
		address.setState("ts");
		address.setZipCode("215666");

		user.setAddress(address);
		boolean UpdatePersonal = ferService.updatePersonalInfo(user);
		if (UpdatePersonal) {
			System.out.println("Update success");

		} else
			System.out.println("Update Failed");

	}
}

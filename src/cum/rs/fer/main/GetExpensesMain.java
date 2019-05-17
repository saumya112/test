package cum.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetExpensesMain {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();
		int userid = 7;
		Expense expenses = ferService.getExpense(userid);

		if (expenses != null) {
			System.out.println("Get Expenses successfully");
		} else {
			System.out.println("Get Expenses Failed");
		}
	}
}

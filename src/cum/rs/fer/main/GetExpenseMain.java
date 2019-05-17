package cum.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetExpenseMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();
		int expenseid = 5;
		Expense expenses = ferService.getExpense(expenseid);

		if (expenses != null) {
			System.out.println("Get Expense successfully");
		} else {
			System.out.println("Get Expense Failed");
		}
	}

}

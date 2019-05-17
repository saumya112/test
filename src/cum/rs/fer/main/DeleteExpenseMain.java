package cum.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class DeleteExpenseMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();

		int expenseid = 3;

		boolean isValidexpense = ferService.deleteExpense(expenseid);

		if (isValidexpense) {
			System.out.println("Delete Expense successfully");
		} else {
			System.out.println("delete Expense Failed");
		}

	}

}

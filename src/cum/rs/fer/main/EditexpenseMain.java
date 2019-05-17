package cum.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class EditexpenseMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();

		Expense expense = new Expense();

		expense.setExpenseid(5);
		expense.setExpensetype("ball");
		expense.setDate("4/4/19");
		expense.setPrice("100");
		expense.setNoofitems("1");
		expense.setTotal("100");
		expense.setBywhom("Raina");
		expense.setUserid("6");

		boolean isValidexpense = ferService.editExpense(expense);

		if (isValidexpense) {
			System.out.println("EditExpense successfully");
		} else {
			System.out.println("EditExpense Failed");
		}
	}
}

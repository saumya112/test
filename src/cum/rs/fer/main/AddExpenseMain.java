package cum.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class AddExpenseMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();

		Expense expense = new Expense();

		expense.setExpensetype("bat");
		expense.setDate("3/4/19");
		expense.setPrice("800");
		expense.setNoofitems("1");
		expense.setTotal("800");
		expense.setBywhom("Rohit");
		expense.setUserid("9");

		boolean isValidexpense = ferService.addExpense(expense);

		if (isValidexpense) {
			System.out.println("AddExpense successfully");
		} else {
			System.out.println("AddExpense Failed");
		}

	}

}

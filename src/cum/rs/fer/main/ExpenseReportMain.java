package cum.rs.fer.main;



import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;



public class ExpenseReportMain {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();
		
		int userid=2;
		String expensetype="books";
		String fromdat="01/04/19";
		String todate="05/04/19";
		
		List<Expense> expense = ferService.getExpenseReport(userid,expensetype,fromdat,todate);
		
		if (expense !=null) {
			System.out.println("ExpenseReport successfully");
		} else {
			System.out.println("ExpenseReport Failed");
		}
		
	}
}

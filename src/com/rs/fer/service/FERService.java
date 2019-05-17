package com.rs.fer.service;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;

public interface FERService {

	boolean registration(User user);

	boolean login(String UserName, String Password);

	boolean addExpense(Expense expense);

	boolean editExpense(Expense expense);

	boolean deleteExpense(int expenseid);

	boolean resetPassword(int id, String oldpassword, String newpassword);

	List<Expense> getExpenseReport(int userid, String expensetype, String fromdate, String todate);

	List<Expense> getExpenses(int userid);

	Expense getExpense(int expenseid);

	User getPersonalInfo(int userid);

	boolean updatePersonalInfo(User user);

}

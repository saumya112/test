package com.rs.fer.service;

import java.util.List;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;

import junit.framework.TestCase;

public class FERServiceImplTest extends TestCase {

	FERService ferservice = new FERServiceImpl();

	// Login
	/*
	 * public void testLogin() { String UserName = "admin"; String Password =
	 * "admin";
	 * 
	 * boolean isValid = ferservice.login(UserName, Password);
	 * 
	 * assertEquals(true, isValid); }
	 */

	/*
	 * public void testLoginInvalidUsername() { String UserName = "admin4"; String
	 * Password = "admin";
	 * 
	 * boolean isValid = ferservice.login(UserName, Password);
	 * 
	 * assertEquals(false, isValid); }
	 */

	/*
	 * public void testLoginWithInvalidPassword() { String UserName = "admin";
	 * String Password = "admin3";
	 * 
	 * boolean isValid = ferservice.login(UserName, Password);
	 * 
	 * assertEquals(false, isValid); }
	 */

	/*
	 * public void testLoginBothInvali() { String UserName = "admin5"; String
	 * Password = "admin5";
	 * 
	 * boolean isValid = ferservice.login(UserName, Password);
	 * 
	 * assertEquals(false, isValid); }
	 */

	// Registration
	/*
	 * public void testregistrationSuccess() {
	 * 
	 * User user = new User(); user.setFirstName("first");
	 * user.setMiddleName("middle"); user.setLastName("last");
	 * user.setMobileNumber("12354"); user.setEmail("email");
	 * user.setUserName("user"); user.setPassword("password");
	 * 
	 * boolean isValidUser = ferservice.registration(user);
	 * 
	 * assertEquals(true, isValidUser); }
	 */

	/*
	 * public void testregistrationFailure() {
	 * 
	 * User user = new User(); user.setFirstName("first");
	 * user.setMiddleName("middle"); user.setLastName("last");
	 * user.setMobileNumber("12354"); user.setEmail("email");
	 * user.setUserName("user1213232uvbouhytoghiputvoubil;yipbu");
	 * user.setPassword("password");
	 * 
	 * boolean isValidUser = ferservice.registration(user);
	 * 
	 * assertEquals(true, isValidUser); }
	 */

//AddExpense

	/*
	 * public void addExpenseSuccess() { Expense expense = new Expense();
	 * 
	 * expense.setExpensetype("books"); expense.setDate("02/04/19");
	 * expense.setPrice("400"); expense.setNoofitems("2"); expense.setTotal("800");
	 * expense.setBywhom("virat"); expense.setUserid("2");
	 * 
	 * boolean isValidaddexpense = ferservice.addExpense(expense);
	 * assertEquals(true, isValidaddexpense); }
	 */
	
	/*
	 * public void addExpenseFailuer() { Expense expense = new Expense();
	 * 
	 * expense.setExpensetype("booksssssss"); expense.setDate("02/04/19");
	 * expense.setPrice("400"); expense.setNoofitems("2"); expense.setTotal("800");
	 * expense.setBywhom("viratdsdff"); expense.setUserid("2dadas");
	 * 
	 * boolean isValidaddexpense = ferservice.addExpense(expense);
	 * assertEquals(false, isValidaddexpense); }
	 */
	
	//EditExpense
	
	/*
	 * public void editExpenseSuccess() { Expense expense = new Expense();
	 * 
	 * expense.setExpenseid(2); expense.setExpensetype("ball");
	 * expense.setDate("4/4/19"); expense.setPrice("100");
	 * expense.setNoofitems("1"); expense.setTotal("100");
	 * expense.setBywhom("Raina"); expense.setUserid("7");
	 * 
	 * boolean isValideditexpense = ferservice.editExpense(expense);
	 * assertEquals(true, isValideditexpense); }
	 */
	
	/*
	 * public void editExpenseFailuer() { Expense expense = new Expense();
	 * 
	 * expense.setExpenseid(40); expense.setExpensetype("ball");
	 * expense.setDate("4/4/19"); expense.setPrice("100");
	 * expense.setNoofitems("1"); expense.setTotal("100");
	 * expense.setBywhom("Raina"); expense.setUserid("7");
	 * 
	 * boolean isValideditexpense = ferservice.editExpense(expense);
	 * assertEquals(false, isValideditexpense); }
	 */
	
	//DeleteExpense
	/*
	 * public void deleteExpenseSuccess() {
	 * 
	 * int expenseid = 3;
	 * 
	 * boolean isValiddeleteexpense = ferservice.deleteExpense(expenseid);
	 * assertEquals(true, isValiddeleteexpense); }
	 */
	
	/*
	 * public void deleteExpenseFail() {
	 * 
	 * int expenseid = 30;
	 * 
	 * boolean isValiddeleteexpense = ferservice.deleteExpense(expenseid);
	 * assertEquals(false, isValiddeleteexpense); }
	 */

//ResetPassword

	public void testresetPasswordSuccess() {
		int id = 6;
		String oldpassword = "raja";
		String newpassword = "testp";

		boolean isValiduserresetpassword = ferservice.resetPassword(id, oldpassword, newpassword);
		assertEquals(true, isValiduserresetpassword);
	}

	public void testresetPasswordFail() {
		int id = 6;
		String oldpassword = "raja12354444";
		String newpassword = "testp";

		boolean isValiduserresetpassword = ferservice.resetPassword(id, oldpassword, newpassword);
		assertEquals(false, isValiduserresetpassword);
	}

	// GetExpense

	public void testgetExpenseSuccess() {
		int expenseid = 5;
		Expense getExpense = ferservice.getExpense(expenseid);
		assertNotNull(getExpense);
	}

	public void testgetExpenseFail() {
		int expenseid = 500;
		Expense getExpense = ferservice.getExpense(expenseid);
		assertNull(getExpense);
	}

	// GetExpenses

	public void testgetExpensesSuccess() {
		int userid = 7;
		Expense getexpenses = ferservice.getExpense(userid);

		assertNotNull(getexpenses);
	}

	public void testgetExpensesFail() {
		int userid = 70;
		Expense getexpenses = ferservice.getExpense(userid);

		assertNull(getexpenses);
	}

	// GetExpenseReport

	public void testgetExpenseReportSuccess() {

		int userid = 2;
		String expensetype = "books";
		String fromdat = "01/04/19";
		String todate = "05/04/19";

		List<Expense> getexpensereport = ferservice.getExpenseReport(userid, expensetype, fromdat, todate);

		assertNotNull(getexpensereport);
	}

	public void testgetExpenseReportFail() {

		int userid = 200;
		String expensetype = "books";
		String fromdat = "01/04/19";
		String todate = "05/04/19";

		List<Expense> getexpensereport = ferservice.getExpenseReport(userid, expensetype, fromdat, todate);

		assertNull(getexpensereport);
	}

//GetPersonalInfo

	public void testgetPersonalInfoSuccess(int userId) {

		int userid = 9;
		User getpersonalinfo = ferservice.getPersonalInfo(userid);

		assertNotNull(getpersonalinfo);
	}

	public void testgetPersonalInfoFail(int userId) {

		int userid = 90;
		User getpersonalinfo = ferservice.getPersonalInfo(userid);

		assertNull(getpersonalinfo);

	}

//UpdatePersonalInfo

	public void testupdatePersonalInfoSuccess() {
		
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
		boolean UpdatePersonalInfo = ferservice.updatePersonalInfo(user);
		
		assertEquals(true, UpdatePersonalInfo);

	}
	
public void testupdatePersonalInfoFail() {
		
		User user = new User();
		user.setFirstname("Sachin");
		user.setMiddlename("Ramesh");
		user.setLastname("Tendulkarcbjkbc");
		user.setMobilenumber("8796555bckjbc");
		user.setEmail("sachin@gmail");
		user.setId(1);

		Address address = new Address();
		address.setAdressLane1("aayyppacjscj");
		address.setAdressLane2("h no.111");
		address.setStreet("raod44");
		address.setCity("hydrabadcjshchc");
		address.setState("ts");
		address.setZipCode("215666bcksjbcjsc");

		user.setAddress(address);
		boolean UpdatePersonalInfo = ferservice.updatePersonalInfo(user);
		
		assertEquals(false, UpdatePersonalInfo);

	}
}

package com.rs.fer.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;

import cum.rs.fer.util.DBUtil;

public class FERServiceImpl implements FERService {
	// Registration
	@Override
	public boolean registration(User user) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		int recordsRegistered = 0;

		try {
			connection = DBUtil.getConnection();

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");

			String inputQuery = "insert into user(FirstName,MiddleName,LastName,MobileNumber,Email,UserName,Password) values(?,?,?,?,?,?,?)";
			preparedstatement = connection.prepareStatement(inputQuery);
			preparedstatement.setString(1, user.getFirstname());
			preparedstatement.setString(2, user.getMiddlename());
			preparedstatement.setString(3, user.getLastname());
			preparedstatement.setString(4, user.getMobilenumber());
			preparedstatement.setString(5, user.getEmail());
			preparedstatement.setString(6, user.getUserName());
			preparedstatement.setString(7, user.getPassword());

			recordsRegistered = preparedstatement.executeUpdate();
			System.out.println("no of records inserted" + recordsRegistered);
			if (recordsRegistered > 0) {
				System.out.println("Registered successfully");
			} else {
				System.out.println("Registration Failed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);

		}
		return recordsRegistered > 0;
	}

	// Login
	@Override
	public boolean login(String UserName, String Password) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		boolean isValidUser = true;

		try {
			connection = DBUtil.getConnection();

			String inputQuery = "SELECT * FROM user WHERE UserName=? AND Password=?";
			preparedstatement = connection.prepareStatement(inputQuery);
			preparedstatement.setString(1, UserName);
			preparedstatement.setString(2, Password);

			ResultSet resultSet = preparedstatement.executeQuery();

			while (resultSet.next()) {
				return isValidUser;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return false;
	}

	// Add Expense
	@Override
	public boolean addExpense(Expense expense) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		int expensesAdded = 0;
		try {

			connection = DBUtil.getConnection();
			String inputQuery = "INSERT INTO expense(expensetype,date,price,Noofitems,total,bywhom,Userid)values(?,?,?,?,?,?,?)";

			preparedstatement = connection.prepareStatement(inputQuery);
			preparedstatement.setString(1, "saf");
			preparedstatement.setString(2, " ");
			preparedstatement.setString(3, "500");
			preparedstatement.setString(4, "2");
			preparedstatement.setString(5, "1000");
			preparedstatement.setString(6, "sdf");
			preparedstatement.setString(7, "aaa");

			expensesAdded = preparedstatement.executeUpdate();
			System.out.println("Expenses added" + expensesAdded);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return expensesAdded > 0;
	}

//Edit Expense
	@Override
	public boolean editExpense(Expense expense) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		int expensesEdited = 0;

		try {
			connection = DBUtil.getConnection();

			String inputQuery = "update expense set expensetype=?,date=?,price=?,Noofitems=?,total=?,bywhom=? where expenseid=?";

			preparedstatement = connection.prepareStatement(inputQuery);
			preparedstatement.setString(1, expense.getExpensetype());
			preparedstatement.setString(2, expense.getDate());
			preparedstatement.setString(3, expense.getPrice());
			preparedstatement.setString(4, expense.getNoofitems());
			preparedstatement.setString(5, expense.getTotal());
			preparedstatement.setString(6, expense.getBywhom());
			preparedstatement.setInt(7,expense.getExpenseid());

			expensesEdited = preparedstatement.executeUpdate();
			System.out.println("Expense Edited:" + expensesEdited);

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBUtil.closeConnection(connection);
		}

		return expensesEdited > 0;
	}

	// Delete Expense
	@Override
	public boolean deleteExpense(int expenseid) {

		Connection connection = null;
		PreparedStatement preparedstatement = null;
		int expenseDeleted = 0;

		try {
			connection = DBUtil.getConnection();

			String inputQuery = "delete from expense where id=?";
			preparedstatement = connection.prepareStatement(inputQuery);
			preparedstatement.setInt(1, expenseid);

			expenseDeleted = preparedstatement.executeUpdate();
			System.out.println("Expense Deleted" + expenseDeleted);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return expenseDeleted > 0;
	}

	// Reset password

	@Override
	public boolean resetPassword(int id, String newpassword, String oldpassword) {

		Connection connection = null;
		PreparedStatement preparedstatement = null;
		int resetPassword = 0;

		try {
			connection = DBUtil.getConnection();

			String inputQuery = "update user set password=? where id=? and password=? ";
			preparedstatement = connection.prepareStatement(inputQuery);
			preparedstatement.setString(1, oldpassword);
			preparedstatement.setInt(2, id);
			preparedstatement.setString(3, newpassword);

			resetPassword = preparedstatement.executeUpdate();
			System.out.println("Updated Record is " + resetPassword);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return resetPassword > 0;
	}

	// GetExpenses
	@Override
	public List<Expense> getExpenses(int userid) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		List<Expense> expenses = new ArrayList<Expense>();

		try {
			connection = DBUtil.getConnection();

			String inputQuery = "select * from expense where userid=?";
			preparedstatement = connection.prepareStatement(inputQuery);
			preparedstatement.setInt(1, userid);

			ResultSet resultSet = preparedstatement.executeQuery();
			System.out.println("Expense Report is Inserted" + resultSet);

			Expense expense = null;
			while (resultSet.next()) {
				expense = new Expense();
				expense.setExpensetype(resultSet.getString("expensetype"));
				expense.setExpensetype(resultSet.getString("date"));
				expense.setExpensetype(resultSet.getString("price"));
				expense.setExpensetype(resultSet.getString("Noofitems"));
				expense.setExpensetype(resultSet.getString("total"));
				expense.setExpensetype(resultSet.getString("bywhom"));
				expense.setExpensetype(resultSet.getString("userid"));

				expenses.add(expense);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return expenses;

	}

	// GetExpenseReport
	@Override
	public List<Expense> getExpenseReport(int userid, String expensetype, String fromdate, String todate) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		List<Expense> expenseReport = new ArrayList<Expense>();

		try {
			connection = DBUtil.getConnection();

			String inputQuery = "select * from expense where userid=? and expensetype=? and date between ? and ?";
			preparedstatement = connection.prepareStatement(inputQuery);

			preparedstatement.setInt(1, userid);
			preparedstatement.setString(2, expensetype);
			preparedstatement.setString(3, fromdate);
			preparedstatement.setString(4, todate);

			ResultSet resultSet = preparedstatement.executeQuery();
			System.out.println("Record inserted " + resultSet);

			while (resultSet.next()) {

				Expense expense = new Expense();
				expense.setExpenseid(resultSet.getInt("id"));
				expense.setExpensetype(resultSet.getString("expensetype"));
				expense.setDate(resultSet.getString("date"));
				expense.setExpensetype(resultSet.getString("Noofitems"));
				expense.setExpensetype(resultSet.getString("price"));
				expense.setExpensetype(resultSet.getString("bywhom"));
				expense.setExpensetype(resultSet.getString("Userid"));

				expenseReport.add(expense);
				System.out.println(resultSet.getInt("id") + " ," + resultSet.getString("expensetype") + " ,"
						+ resultSet.getString("date") + " ," + resultSet.getString("Noofitems") + " ,"
						+ resultSet.getString("price") + " ," + resultSet.getString("bywhom") + " ,"
						+ resultSet.getString("Userid"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return expenseReport;
	}

	// GetExpense
	@Override
	public Expense getExpense(int id) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		Expense expense = null;

		try {
			connection = DBUtil.getConnection();

			String inputQuery = "select * from expense where id=?";
			preparedstatement = connection.prepareStatement(inputQuery);
			preparedstatement.setInt(1, id);

			ResultSet resultSet = preparedstatement.executeQuery();
			System.out.println("Expense Report is Inserted" + resultSet);

			while (resultSet.next()) {
				expense = new Expense();
				expense.setExpensetype(resultSet.getString("id"));
				expense.setExpensetype(resultSet.getString("expensetype"));
				expense.setExpensetype(resultSet.getString("date"));
				expense.setExpensetype(resultSet.getString("price"));
				expense.setExpensetype(resultSet.getString("Noofitems"));
				expense.setExpensetype(resultSet.getString("total"));
				expense.setExpensetype(resultSet.getString("bywhom"));
				expense.setExpensetype(resultSet.getString("Userid"));

				System.out.println("id:" + resultSet.getString("id") + " ," + "expensetype:"
						+ resultSet.getString("expensetype") + " ," + "date:" + resultSet.getString("date") + " ,"
						+ "price:" + resultSet.getString("price") + " ," + "Noofitems:" + resultSet.getString("Noofitems")
						+ " ," + "total:" + resultSet.getString("total") + " ," + "bywhom:"
						+ resultSet.getString("bywhom")+" ,"+"Userid:"+resultSet.getString("Userid"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return expense;
	}

	// GetPersonalInfo
	@Override
	public User getPersonalInfo(int userId) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		User user = new User();

		try {
			connection = DBUtil.getConnection();

			String inputQuery = "select u.*,a.* from user2 u left join address2 a on u.id=a.userid";
			preparedstatement = connection.prepareStatement(inputQuery);
			preparedstatement.setInt(1, userId);

			ResultSet resultSet = preparedstatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					user.setId(resultSet.getInt("id"));
					user.setFirstname(resultSet.getString("firstname"));
					user.setMiddlename(resultSet.getString("middlename"));
					user.setLastname(resultSet.getString("lastname"));
					user.setMobilenumber(resultSet.getString("MobileNumber"));
					user.setEmail(resultSet.getString("email"));
					user.setUserName(resultSet.getString("username"));
					user.setPassword(resultSet.getString("password"));

					Address address = new Address();

					address.setId(resultSet.getInt(5));
					address.setAdressLane1(resultSet.getString("AdressLane1"));
					address.setAdressLane2(resultSet.getString("AdressLane2"));
					address.setStreet(resultSet.getString("Street"));
					address.setCity(resultSet.getString("City"));
					address.setState(resultSet.getString("State"));
					address.setZipCode(resultSet.getString("ZipCode"));

					user.setAddress(address);

					System.out.println(user.getId() + " ," + user.getFirstname() + " ," + user.getMiddlename() + " ,"
							+ user.getLastname() + " ," + user.getMobilenumber() + " ," + user.getEmail() + " ,"
							+ user.getUserName() + " ," + user.getPassword() + " ," + address.getAdressLane1() + " ,"
							+ address.getAdressLane2() + " ," + address.getStreet() + " ," + address.getStreet() + " ,"
							+ address.getCity() + " ," + address.getState() + " ," + address.getZipCode());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBUtil.closeConnection(connection);
		}

		return user;

	}

	// UpdatePersonalInfoMain
	@Override
	public boolean updatePersonalInfo(User user) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {
			connection = DBUtil.getConnection();

			
			String inputQuery = "update user set FirstName=?,MiddleName=?,LastName=?,MobileNumber=?,Email=? where id=?";

			preparedstatement = connection.prepareStatement(inputQuery);
			preparedstatement.setString(1, "mahendra");
			preparedstatement.setString(2, "singh");
			preparedstatement.setString(3, "dhoni");
			preparedstatement.setString(4, "8566215");
			preparedstatement.setString(5, "msd@gmail");
			preparedstatement.setString(6, "1");

			int UpdatePersonal = preparedstatement.executeUpdate();
			System.out.println("Expense Edited:" + UpdatePersonal);

			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return false;
	}

}

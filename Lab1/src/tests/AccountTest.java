package tests;

import java.util.Date;

import model.Account;
import utils.TestUtils;

public class AccountTest {

	public static void testConstructor() {
		// Automated-testing

		// 1 - Setup

		String test_account_number = "01234567";
		String test_username_of_account_holder = "mikesmith";
		String test_account_type = "Standard"; // Standard or Saving
		Date test_account_opening_date = new Date();

		// 2 - Exercise, run the object under test (constructor)

		Account testAccount = new Account(test_account_number, test_username_of_account_holder, test_account_type,
				test_account_opening_date);

		// 3 - Verify (Assert)

		// Account Number
		if (testAccount.getAccount_number() == test_account_number) {
			System.out
					.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getAccount_number-Passed" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getAccount_number-FAILED" + TestUtils.TEXT_COLOR_RESET);
		}
		// User name
		if (testAccount.getUsername_of_account_holder() == test_username_of_account_holder) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getUsername_of_account_holder-Passed"
					+ TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(
					TestUtils.TEXT_COLOR_RED + "TC2-getUsername_of_account_holder-FAILED" + TestUtils.TEXT_COLOR_RESET);
		}

		// Account Type
		if (testAccount.getAccount_type() == test_account_type) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC3-getAccount_type-Passed" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC3-getAccount_type-FAILED" + TestUtils.TEXT_COLOR_RESET);
		}

		// Account Opening date
		if (testAccount.getAccount_opening_date() == test_account_opening_date) {
			System.out.println(
					TestUtils.TEXT_COLOR_GREEN + "TC4-getAccount_opening_date-Passed" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(
					TestUtils.TEXT_COLOR_RED + "TC4-getAccount_opening_date-FAILED" + TestUtils.TEXT_COLOR_RESET);
		}

		// Using Asserts

		assert testAccount.getAccount_number() == test_account_number;
		assert testAccount.getUsername_of_account_holder() == test_username_of_account_holder;
		assert testAccount.getAccount_type() == test_account_type;
		assert testAccount.getAccount_opening_date() == test_account_opening_date;

		System.out.println("All Java assertions in the test suite passed (none failed).");
	}

	public static void testSetters() {

		// 1 - Setup, create instances
		Account account = new Account(null, null, null, null);

		// 2 - Set values
		String testAccountNumber = new String();
		String testUsername = new String();
		String testAccountType = new String();
		Date testAccountOpeningDate = new Date();

		account.setAccount_number(testAccountNumber);
		account.setUsername_of_account_holder(testUsername);
		account.setAccount_type(testAccountType);
		account.setAccount_opening_date(testAccountOpeningDate);

		// 3 - Verify values (assert)

		// Account Number
		if (account.getAccount_number() == testAccountNumber) {
			System.out
					.println(TestUtils.TEXT_COLOR_GREEN + "TC5-setAccount_number-Passed" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC5-setAccount_number-FAILED" + TestUtils.TEXT_COLOR_RESET);
		}
		// User name
		if (account.getUsername_of_account_holder() == testUsername) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC6-setUsername_of_account_holder-Passed"
					+ TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(
					TestUtils.TEXT_COLOR_RED + "TC6-setUsername_of_account_holder-FAILED" + TestUtils.TEXT_COLOR_RESET);
		}

		// Account Type
		if (account.getAccount_type() == testAccountType) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC7-setAccount_type-Passed" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC7-setAccount_type-FAILED" + TestUtils.TEXT_COLOR_RESET);
		}

		// Account Opening date
		if (account.getAccount_opening_date() == testAccountOpeningDate) {
			System.out.println(
					TestUtils.TEXT_COLOR_GREEN + "TC8-setAccount_opening_date-Passed" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(
					TestUtils.TEXT_COLOR_RED + "TC8-setAccount_opening_date-FAILED" + TestUtils.TEXT_COLOR_RESET);
		}

		assert account.getAccount_number() == testAccountNumber;
		assert account.getUsername_of_account_holder() == testUsername;
		assert account.getAccount_type() == testAccountType;
		assert account.getAccount_opening_date() == testAccountOpeningDate;

		System.out.println("All Java assertions in the test suite passed (none failed).");
	}

	public static void main(String[] args) {
		System.out.println("Starting the assertions of the test methods: testAccountConstructor and testAccountSetter");
		testConstructor();
		testSetters();

	}

}

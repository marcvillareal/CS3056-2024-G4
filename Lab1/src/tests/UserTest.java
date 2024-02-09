package tests;

import model.User;
import utils.TestUtils;

public class UserTest {

	public static void testUserConstructor() {
		/*
		 * OLD; Manual-testing shown below
		 * 
		 * User testUser = new User("mike", "my_passwd", "Mike", "Smith",
		 * "07771234567"); System.out.println(testUser);
		 */

		// Automated-testing

		// 1 - Setup

		String test_username = "mike";
		String test_password = "my_passwd";
		String test_first_name = "Mike";
		String test_last_name = "Smith";
		String test_mobile_number = "07771234567";

		// 2 - Exercise, run the object under test (constructor)

		User testUser = new User(test_username, test_password, test_first_name, test_last_name, test_mobile_number);

		// 3 - Verify (Assert)
		System.out.println("Starting the assertions of the test method: testUserConstructor");

		// User name
		if (testUser.getUsername() == test_username) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getUsername-Passed" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getUsername-FAILED" + TestUtils.TEXT_COLOR_RESET);
		}
		// Password
		if (testUser.getPassword() == test_password) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getPassword-Passed" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC2-getPassword-FAILED" + TestUtils.TEXT_COLOR_RESET);
		}

		// First Name
		if (testUser.getFirst_name() == test_first_name) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC3-getFirst_name-Passed" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC3-getFirst_name-FAILED" + TestUtils.TEXT_COLOR_RESET);
		}

		// Last Name
		if (testUser.getLast_name() == test_last_name) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC4-getLast_name-Passed" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC4-getLast_name-FAILED" + TestUtils.TEXT_COLOR_RESET);
		}

		// Mobile Number
		if (testUser.getMobile_number() == test_mobile_number) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC5-getMobile_number-Passed" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC5-getMobile_number-FAILED" + TestUtils.TEXT_COLOR_RESET);
		}

		// Using Asserts

		assert testUser.getUsername() == test_username;
		assert testUser.getPassword() == test_password;
		assert testUser.getFirst_name() == test_first_name;
		assert testUser.getLast_name() == test_last_name;
		assert testUser.getMobile_number() == test_mobile_number;

//		assert 1==2;

		System.out.println("All Java assertions in the test suite passed (none failed).");
	}

	public static void main(String[] args) {
		testUserConstructor();
	}
}

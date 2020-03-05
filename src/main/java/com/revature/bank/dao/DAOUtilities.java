package com.revature.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.revature.bank.dao.implementations.AccountDAOImpl;
import com.revature.bank.dao.implementations.AccountOwnershipDAOImpl;
import com.revature.bank.dao.implementations.AccountRequestDAOImpl;
import com.revature.bank.dao.implementations.AccountRequestUsersDAOImpl;
import com.revature.bank.dao.implementations.AccountTransactionDAOImpl;
import com.revature.bank.dao.implementations.AccountTransactionStatusDAOImpl;
import com.revature.bank.dao.implementations.AccountTypeDAOImpl;
import com.revature.bank.dao.implementations.AddressDAOImpl;
import com.revature.bank.dao.implementations.AssociatedPeopleDAOImpl;
import com.revature.bank.dao.implementations.CityDAOImpl;
import com.revature.bank.dao.implementations.EmailDAOImpl;
import com.revature.bank.dao.implementations.PermissionRankDAOImpl;
import com.revature.bank.dao.implementations.PersonDAOImpl;
import com.revature.bank.dao.implementations.PersonStandingDAOImpl;
import com.revature.bank.dao.implementations.PhoneNumberDAOImpl;
import com.revature.bank.services.helpers.LoggerSingleton;

public class DAOUtilities {
	private static final String CONNECTION_USERNAME = "Admin";
	private static final String CONNECTION_PASSWORD = System.getenv("REV_BANK");
//	private static final String URL = "jdbc:oracle:thin://bank.cqvzp3eturwf.us-east-2.rds.amazonaws.com:1521/ORCL";
	private static final String URL = "jdbc:oracle:thin:@bank.cqvzp3eturwf.us-east-2.rds.amazonaws.com:1521/orcl";
	
	private static AccountDAOImpl accountDAOImpl;
	private static AccountOwnershipDAOImpl accountOwnershipDAOImpl;
	private static AccountRequestDAOImpl accountRequestDAOImpl;
	private static AccountRequestUsersDAOImpl accountRequestUsersDAOImpl;
	private static AccountTransactionDAOImpl accountTransactionDAOImpl;
	private static AccountTransactionStatusDAOImpl accountTransactionStatusDAOImpl;
	private static AccountTypeDAOImpl accountTypeDAOImpl;
	private static AddressDAOImpl addressDAOImpl;
	private static AssociatedPeopleDAOImpl associatedPeopleDAOImpl;
	private static CityDAOImpl cityDAOImpl;
	private static EmailDAOImpl emailDAOImpl;
	private static PermissionRankDAOImpl permissionRankDAOImpl;
	private static PersonDAOImpl personDAOImpl;
	private static PersonStandingDAOImpl personStandingDAOImpl;
	private static PhoneNumberDAOImpl phoneNumberDAOImpl;
	private static Connection connection;

	//SECTION: variables
	//SECTION: constructors
	//SECTION: getters & setters
	//SECTION: methods
	
	public static synchronized AccountDAOImpl getAccountDao() {
		if(accountDAOImpl == null) {
			accountDAOImpl = new AccountDAOImpl();
		}
		return accountDAOImpl;
	}
	public static synchronized AccountOwnershipDAOImpl getAccountOwnershipDao() {
		if(accountOwnershipDAOImpl == null) {
			accountOwnershipDAOImpl = new AccountOwnershipDAOImpl();
		}
		return accountOwnershipDAOImpl;
	}
	public static synchronized AccountRequestDAOImpl getAccountRequestDao() {
		if(accountRequestDAOImpl == null) {
			accountRequestDAOImpl = new AccountRequestDAOImpl();
		}
		return accountRequestDAOImpl;
	}
	public static synchronized AccountRequestUsersDAOImpl getAccountRequestUsersDao() {
		if(accountRequestUsersDAOImpl == null) {
			accountRequestUsersDAOImpl = new AccountRequestUsersDAOImpl();
		}
		return accountRequestUsersDAOImpl;
	}
	public static synchronized AccountTransactionDAOImpl getAccountTransactionDao() {
		if(accountTransactionDAOImpl == null) {
			accountTransactionDAOImpl = new AccountTransactionDAOImpl();
		}
		return accountTransactionDAOImpl;
	}
	public static synchronized AccountTransactionStatusDAOImpl getAccountTransactionStatusDao() {
		if(accountTransactionStatusDAOImpl == null) {
			accountTransactionStatusDAOImpl = new AccountTransactionStatusDAOImpl();
		}
		return accountTransactionStatusDAOImpl;
	}
	public static synchronized AccountTypeDAOImpl getAccountTypeDao() {
		if (accountTypeDAOImpl == null){
			accountTypeDAOImpl = new AccountTypeDAOImpl();
		}
		return accountTypeDAOImpl;
	}
	public static synchronized AddressDAOImpl getAddressDao() {
		if (addressDAOImpl == null) {
			addressDAOImpl = new AddressDAOImpl();
		}
		return addressDAOImpl;
	}
	public static synchronized AssociatedPeopleDAOImpl getAssociatedPeopleDao() {
		if (associatedPeopleDAOImpl == null) {
			associatedPeopleDAOImpl = new AssociatedPeopleDAOImpl();
		}
		return associatedPeopleDAOImpl;
	}
	public static synchronized CityDAOImpl getCityDao() {
		if (cityDAOImpl == null) {
			cityDAOImpl = new CityDAOImpl();
		}
		return cityDAOImpl;
	}
	public static synchronized EmailDAOImpl getEmailDao() {
		if (emailDAOImpl == null) {
			emailDAOImpl = new EmailDAOImpl();
		}
		return emailDAOImpl;
	}
	public static synchronized PermissionRankDAOImpl getPermissionRankDao() {
		if (permissionRankDAOImpl == null) {
			permissionRankDAOImpl = new PermissionRankDAOImpl();
		}
		return permissionRankDAOImpl;
	}
	public static synchronized PersonDAOImpl getPersonDao() {
		if (personDAOImpl == null) {
			personDAOImpl = new PersonDAOImpl();
		}
		return personDAOImpl;
	}
	public static synchronized PersonStandingDAOImpl getPersonStandingDao() {
		if (personStandingDAOImpl == null) {
			personStandingDAOImpl = new PersonStandingDAOImpl();
		}
		return personStandingDAOImpl;
	}
	public static synchronized PhoneNumberDAOImpl getPhoneNumberDao() {
		if (phoneNumberDAOImpl == null) {
			phoneNumberDAOImpl = new PhoneNumberDAOImpl();
		}
		return phoneNumberDAOImpl;
	}
	public static synchronized Connection getConnection() throws SQLException {
		try {
			if(CONNECTION_PASSWORD == null) {
				throw new RuntimeException("System env password 'REV_BANK' is not set, "
						+ "connecting without password is not possible.");
			}
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//This above statement uses Reflection to confirm that a class with this fully qualified name
			//is available
			try {
				connection = DriverManager.getConnection(URL,CONNECTION_USERNAME,CONNECTION_PASSWORD);
			}catch(SQLException e) {
				LoggerSingleton.getLogger().warn("Failed to get connection", e);
			}
		}catch(ClassNotFoundException e) {
			LoggerSingleton.getLogger().warn("Oracle db driver not found",e);
		}catch(RuntimeException e) {
			LoggerSingleton.getLogger().warn("Connection Failed", e);
		}
		if (connection.isClosed()){
			System.out.println("getting new connection...");
			connection = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
		}
		return connection;
	}
	//SECTION: hash && equals
	//SECTION: toString

}

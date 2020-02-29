package com.revature.bank.dao.implementations;

import java.util.List;

import com.revature.bank.dao.interfaces.EmailDAO;
import com.revature.bank.model.Email;

public class EmailDAOImpl implements EmailDAO {

	//SECTION: methods
	@Override
	public List<Email> listEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Email getEmail(int emailId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateEmail(Email emailToUpdate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveEmail(Email emailToSave) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEmail(Email emailToDelete) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEmail(int emailId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getHighestId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
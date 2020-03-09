package com.revature.bank.services.handlers;

import java.util.List;

import com.revature.bank.dao.implementations.PermissionRankDAOImpl;
import com.revature.bank.dao.interfaces.PermissionRankDAO;
import com.revature.bank.model.PermissionRank;
import com.revature.bank.model.Person;

public class PermissionRankHandler {
	private PermissionRankDAO repository = null;
	public PermissionRankHandler() {
		super();
		this.repository = new PermissionRankDAOImpl();
	}
	public PermissionRankHandler(PermissionRankDAO repository) {
		super();
		this.repository = repository;
	}
	public PermissionRank create(PermissionRank rankToCreate) {
		return repository.create(rankToCreate);
	}
	public boolean assign(Person person, PermissionRank rank) {
		return repository.assign(person, rank);
	}
	public List<PermissionRank> list() {
		return repository.list();
	}
	public List<PermissionRank> list(Person person){
		return repository.list(person);
	}
	public List<String> listString(Person person){
		return repository.listLabels(person);
	}
	public PermissionRank get(int rankId) {
		return repository.get(rankId);
	}
	public PermissionRank update(PermissionRank rankToUpdate) {
		return repository.update(rankToUpdate);
	}
	public boolean delete(PermissionRank rankToDelete) {
		return repository.delete(rankToDelete);
	}
	public boolean remove(Person person, PermissionRank rank) {
		return repository.remove(person, rank);
	}
	public boolean delete(int rankId) {
		return repository.delete(rankId);
	}
	public int getHighestId() {
		return repository.getHighestId();
	}
}

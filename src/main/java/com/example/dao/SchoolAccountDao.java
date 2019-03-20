package com.example.dao;

import org.springframework.stereotype.Repository;

import com.example.model.SchoolAccount;
import com.example.dao.GenericDAO;

@Repository
public class SchoolAccountDao extends GenericDAO<SchoolAccount, String> {
	public void addSchoolData(String name, String pw) {
		SchoolAccount sa = new SchoolAccount();
		sa.setName(name);
		sa.setPassword(pw);
		sa.setUid("123");
		getSession().saveOrUpdate(sa);
	}
}

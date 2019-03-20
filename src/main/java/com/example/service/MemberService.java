package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.MemberDao;
import com.example.model.MemberAccount;

@Service
public class MemberService {
	@Autowired
	MemberDao memberDao;

	public void addMember(MemberAccount memberAccount) {

		memberDao.addMember(memberAccount);

	}

}

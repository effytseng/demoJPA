package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.MemberAccount;

@RestController
public class MemberApiController {

	@Autowired
	MemberAccount memberAccount;

	@RequestMapping("/memberApi/memberTest")
	public MemberAccount memberTest() {
		MemberAccount memberAccount = new MemberAccount();
		memberAccount.setAddress("台北市");
		memberAccount.setCellphone("0933333333");
		memberAccount.setEmail("test@gmail.com");
		memberAccount.setId(1);
		memberAccount.setPassword("123456789");
		return memberAccount;
	}
}

package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.MemberAccount;
import com.example.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberAccount memberAccoun; //為什麼要加這個??
	
	@Autowired
	MemberService memberService;

	@GetMapping("/member")
	public String member() {
		//第一種寫法，直接加入
		MemberAccount memberAccoun = new MemberAccount();
		memberAccoun.setPassword("12345678");
		memberAccoun.setEmail("test@gmail.com");
		memberAccoun.setCellphone("0912345789");
		memberAccoun.setAddress("台北市");
		memberService.addMember(memberAccoun);

		return "addMemberPage";
	}
}

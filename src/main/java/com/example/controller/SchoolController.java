package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dao.SchoolAccountDao;

@Controller
public class SchoolController {
	@Autowired
	SchoolAccountDao SchoolAccountDao;

	@PostMapping("/addSchoolData")
	public void addSchoolData(HttpServletRequest request) {
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		System.out.println(name+pw);
		
		SchoolAccountDao.addSchoolData(name, pw);
	}
}

package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class HelloController {
	@GetMapping("/")
	public String hello() {
		return "HELLO! SPRING BOOT!";
	}

//	@GetMapping("/books")
//	public String book() {
//		return "Books";
//	}

	@GetMapping("/books")
	public Object getBookData(@RequestParam int page, @RequestParam int size) {
		Map<String, Object> book = new HashMap<>();
		book.put("name", "vue");
		book.put("author", "effy");
		book.put("ISBN", 123456789);
		Map<String, Object> book2 = new HashMap<>();
		book2.put("name", "nuxt");
		book2.put("author", "east");
		book2.put("ISBN", 123456789);
		List<Map<String, Object>> contents = new ArrayList<>();
		contents.add(book);
		contents.add(book2);

		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("page", page);
		pageMap.put("size", size);
		pageMap.put("contents", contents);

		return pageMap;
	}

	@GetMapping("/books/{id}")
	public Object getId(@PathVariable long id) {
		System.out.print(id);
		Map<String, Object> book = new HashMap<>();
		book.put("name", "vue");
		book.put("pages", id);

		return book;
	}

}

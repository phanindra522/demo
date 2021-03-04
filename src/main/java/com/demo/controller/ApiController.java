package com.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.ApiService;

@RestController
@RequestMapping(value = "api")
public class ApiController {

	@Autowired
	private ApiService apiService;
	
	@GetMapping(path = "food")
	public @ResponseBody Map<String, Object> food(@RequestParam Map<String, Object> params ) {
		System.out.println("Food Calling"+ params.toString());
		return apiService.food(params);
	}
	
	@GetMapping(path = "teams")
	public @ResponseBody Map<String, Object> teams(@RequestParam Map<String, Object> params) {
		System.out.println("Teams Calling");
		return apiService.food(params);
	}
}

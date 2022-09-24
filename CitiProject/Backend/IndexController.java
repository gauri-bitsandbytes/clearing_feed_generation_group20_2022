package com.citi.project.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.citi.project.dao.cfgDao;
import com.citi.project.dto.Transaction;


@org.springframework.stereotype.Controller
public class IndexController {
	
	@Autowired
	cfgDao cfgDaoObject;
	
	@GetMapping("/")
	public String login() throws NumberFormatException, IOException, ParseException {
		cfgDaoObject.read();
		return "login";
	}

	@RequestMapping("/index")
	public String indexPage() throws NumberFormatException, IOException, ParseException {
		return "index";
	}
	
	@GetMapping("/file")
	public String filePage() {		
		return "file";
	}

	@GetMapping("/success")
	public String getSuccessRecords(Model model) throws NumberFormatException, IOException, ParseException{
		List<Transaction> data=new ArrayList<>(cfgDaoObject.tSuccess);
		model.addAttribute("data",data); 
		List<Transaction> dataf=new ArrayList<>(cfgDaoObject.tFailure);
		model.addAttribute("dataf",dataf); 
		return "success";
	}
	
}

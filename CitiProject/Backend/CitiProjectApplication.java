package com.citi.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.citi.project.dao.cfgDao;

@SpringBootApplication
public class CitiProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitiProjectApplication.class, args);
		cfgDao cfgDaoObject = new cfgDao();
		try {
			cfgDaoObject.read();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

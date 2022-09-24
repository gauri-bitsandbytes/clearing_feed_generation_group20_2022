package com.citi.project.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.citi.project.dao.cfgDao;


public class cfgService {
	
	@Autowired
	cfgDao cfgDaoObject;
	
		
	public boolean checkTransactionID(String transactionID){
		if(transactionID.length()==12 && transactionID.matches("[a-zA-Z0-9]+"))
			return true;
		else
			return false;
	}

	public boolean checkValueDate(String valueDate){
		String formatString = "ddMMyyyy";	    
	    try {
	        SimpleDateFormat format = new SimpleDateFormat(formatString);
	        format.setLenient(false);
	        format.parse(valueDate);
	    } catch (ParseException | IllegalArgumentException e) {
	        return false;
	    }
	    return true;
	}
	public boolean checkPayerName(String payerName){
		if(payerName.length()<=35 && payerName.matches("[a-zA-Z0-9]+"))
			return true;
		else
			return false;
	}

	public boolean checkPayerAccount(String payerAmount){
		if(payerAmount.length()==12 && payerAmount.matches("[a-zA-Z0-9]+"))
			return true;
		else
			return false;
	}

	public boolean checkPayeeName(String payeeName){
		if(payeeName.length()<=35 && payeeName.matches("[a-zA-Z0-9]+"))
			return true;
		else
			return false;
	}

	public boolean checkPayeeAccount(String payeeAmount){
		if(payeeAmount.length()==12 && payeeAmount.matches("[a-zA-Z0-9]+"))
			return true;
		else
			return false;
	}

	public boolean checkAmount(double amount){
		if(Double.toString(amount).length()<=12 && amount>=0)
			return true;
		else
			return false;
	}

}

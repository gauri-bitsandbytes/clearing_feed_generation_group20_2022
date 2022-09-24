package com.citi.project.dao;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.citi.project.dto.Transaction;
import com.citi.project.service.cfgService;

@Configuration
public class cfgDao {
	public List<Transaction> tSuccess = new ArrayList<Transaction>();
	public List<Transaction> tFailure = new ArrayList<Transaction>();
	String filename = "sample.txt";

	public void read() throws IOException, NumberFormatException, ParseException {
		
		FileInputStream fstream = new FileInputStream("sample.txt");
		FileWriter fws=new FileWriter("SuccessTestout.txt"); 
		FileWriter fw=new FileWriter("FailureTestout.txt");    
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
		try {
			while ((strLine = br.readLine()) != null) {
				String[] strSplit = strLine.split(" ");
				ArrayList<String> list = new ArrayList<String>();
				for (String string : strSplit) {
					list.add(string);
				}
				cfgService cfgServiceObject = new cfgService(); 
				if(cfgServiceObject.checkTransactionID(list.get(0))  && cfgServiceObject.checkValueDate(list.get(1)) && cfgServiceObject.checkPayeeName(list.get(2)) && cfgServiceObject.checkPayerAccount( list.get(3)) && cfgServiceObject.checkPayeeName(list.get(4)) && cfgServiceObject.checkPayeeAccount(list.get(5)) && cfgServiceObject.checkAmount(Double.parseDouble(list.get(6)))) {
					try{    
				        fws.write(String.join(" ", list)+" feed-generated"+"\n");       
				          }
					catch(Exception e) {
						System.out.println(e);
					}    
				          Transaction tObject = new Transaction(list.get(0),list.get(1),list.get(2),list.get(3),list.get(4),list.get(5),Double.parseDouble(list.get(6)));
				          tSuccess.add(tObject);
			
				     }    
				else {
					try{    
				           fw.write(String.join(" ", list)+"\n");    
				          
				    }
					catch(Exception e){
				        	  System.out.println(e);
				        }     
				          Transaction tObject = new Transaction(list.get(0),list.get(1),list.get(2),list.get(3),list.get(4),list.get(5),Double.parseDouble(list.get(6)));
				          tFailure.add(tObject);
				     } 
					
				}
			fws.close(); 
			fw.close();    
					
			}catch(IOException e)
	{
		e.printStackTrace();
	}in.close();

	//System.out.println(tSuccess);
}


}

/*
 * // TODO Auto-generated method stub FileInputStream fstream = new
 * FileInputStream("sample.txt"); DataInputStream in = new
 * DataInputStream(fstream); BufferedReader br = new BufferedReader(new
 * InputStreamReader(in)); String strLine; try { while ((strLine =
 * br.readLine()) != null) { // strLine.split(" "); // cfgService s= new
 * cfgService(); // boolean t=s.checkTransactionID(strLine); //
 * System.out.print(t); System.out.println(strLine); } } catch (IOException e) {
 * // TODO Auto-generated catch block e.printStackTrace(); } in.close();
 * BufferedReader bufReader = new BufferedReader(new FileReader("sample.txt"));
 * ArrayList<ArrayList<String>> listOfLines = new ArrayList<>(); String line =
 * bufReader.readLine(); while (line != null) { listOfLines.add(line); line =
 * bufReader.readLine(); } bufReader.close();
 * System.out.println("Content of ArrayLiList:");
 * System.out.println(listOfLines);
 */

package com.zheming.powerball;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import java.io.IOException;

public class InputService {
	
	public WhiteBall[] wbs;
	public PowerBall[] pbs;
	
	public InputService() {
		this.wbs=new WhiteBall[70];
		this.pbs=new PowerBall[50];
		for(int i=0;i<wbs.length;i++) {
			wbs[i]=new WhiteBall(String.valueOf(i));
		}
		for(int i=0;i<pbs.length;i++) {
			pbs[i]=new PowerBall(String.valueOf(i));
		}
	}
	
	public void FileDownloadService(String url_str, File file) {
		//File rec=new File("powerball.txt");
		URL url = null;
		try {
			url = new URL(url_str);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			FileUtils.copyURLToFile(url,file,10000,10000);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Read file and calculate the frequency of each number 
	public void FileReadService(String fileName) {
		String line=null;
		try {
			FileReader fileReader=new FileReader(fileName);
			BufferedReader bufferedReader=new BufferedReader(fileReader);
			try {
				//This line only has the title
				line=bufferedReader.readLine();
				while((line=bufferedReader.readLine())!=null) {
					
					String[] strs=line.split("\\s+");
					//only data since 10/08/2015 is valid
					if(YearAfter2015(strs[0])==false) continue;
					
					//Calculate the white ball frequencies
					WhiteBallFrequency(strs);
					
					//convert powerball number from string to int
					PowerBallFrequency(strs[6]);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(FileNotFoundException ex) {
			System.out.println("Unable to open file '"+fileName+"'");
		}
	}
	
	public boolean YearAfter2015(String date) {
		
		try {
			Date change_day=new SimpleDateFormat("MM/dd/yyyy").parse("10/08/2015");
			Date day=new SimpleDateFormat("MM/dd/yyyy").parse(date);
			if(day.before(change_day)) return false;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public void WhiteBallFrequency(String[] strs) {
		for(int i=1;i<=5;i++) {
			int idx=Integer.parseInt(strs[i]);
			wbs[idx].frequency++;
		}
	}
	
	public void PowerBallFrequency(String str) {
		int idx=Integer.parseInt(str);
		pbs[idx].frequency++;
	}
}

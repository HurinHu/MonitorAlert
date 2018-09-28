package com.iceloof;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Data {
	
	private String content = "";
	private String file = "";
	
	public Data(String file) {
		this.file = file;
	}
	
	private String readFile(String path, Charset encoding) {
		byte[] encoded;
		try {
			encoded = Files.readAllBytes(Paths.get(path));
			return new String(encoded, encoding);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public void read() {
		this.content = readFile(this.file, StandardCharsets.UTF_8);
	}
	
	public double[] getList() {
		String[] data = this.content.split("\n");
		double[] result = {0,0};
		for(int i=0; i<data.length; i++){
			if(this.getTradeDay().equals(data[i].split(",")[0])){
				result[0] = Double.parseDouble(data[i].split(",")[1]);
				result[1] = Double.parseDouble(data[i].split(",")[2]);
			}
		}
		return result;
	}
	
	private Date yesterday(){
		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE,-1);
		return cal.getTime();
	}
	
	private String getTradeDay(){
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		return dateformat.format(this.yesterday());
	}
}

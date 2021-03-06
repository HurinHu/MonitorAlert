package com.iceloof;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Monitor {
	
	private String api = "http://localhost/internal/price.php?code=";
	private String ticker = "";
	
	public Monitor(String ticker){
		this.ticker = ticker;
	}
	
	private String getQuote(){
		String content = "";
		try {
			URL url = new URL(this.api+this.ticker);
	        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	        InputStream is = conn.getInputStream();
	        InputStreamReader isr = new InputStreamReader(is);
	        BufferedReader br = new BufferedReader(isr);
	        String line;
		    while ((line = br.readLine()) != null){
		    	content += line;
		    }
		    br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    return content;
	}
	
	public double getPrice(){
		String data = this.getQuote();
		double price = 0;
		if(!data.equals("")){
			price = Double.parseDouble(data);
		}
		return price;
	}
}

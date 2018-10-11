package com.iceloof;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		SimpleDateFormat hour = new SimpleDateFormat("HH");
		String file = "monitor.txt";
		String ticker = "";
		if(args.length == 1){
			ticker = args[0];
		}else if(args.length == 2){
			ticker = args[0];
			file = args[1];
		}
		Data data = new Data(file);
		Monitor monitor = new Monitor(ticker);
		Alert alert = new Alert();
		data.read();
		double[] dataList = data.getList();
		double price = 0;
		while((Integer.parseInt(hour.format(new Date()))>=0) && (Integer.parseInt(hour.format(new Date())) < 9)){
			price = monitor.getPrice();
			if(price >= dataList[0]){
				System.out.println(price+"   "+dataList[0]);
				alert.up();
				try {
					TimeUnit.MINUTES.sleep(60);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(price <= dataList[1]){
				System.out.println(price+"   "+dataList[1]);
				alert.down();
				try {
					TimeUnit.MINUTES.sleep(60);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try{
				TimeUnit.SECONDS.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

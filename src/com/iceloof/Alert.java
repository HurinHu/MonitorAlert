package com.iceloof;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Alert {
	
	private String down = "down.mp3";
	private String up = "up.mp3";
    private Player player; 
    private FileInputStream fis;

    
	public Alert(){
	}
	
	public void down(){
		try {
			fis = new FileInputStream(down);
			BufferedInputStream bis = new BufferedInputStream(fis);
	        player = new Player(bis);
	        player.play();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
	}
	
	public void up(){
		try {
			fis = new FileInputStream(up);
			BufferedInputStream bis = new BufferedInputStream(fis);
	        player = new Player(bis);
	        player.play();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
	}
	
	
}

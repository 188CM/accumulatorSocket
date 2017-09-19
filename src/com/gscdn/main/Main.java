package com.gscdn.main;

import java.io.IOException;

import com.gscdn.model.Config;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub


		Config conf = new Config();
		conf.setPort(7070);
		conf.setFactory("com.gscdn.handler.AccumulatorHandler");
		
		if(!conf.checkParameter()) {
			System.out.println("Config is Null!! ");
			return;
		}
		
		try {
				ServerMain server = new ServerMain(conf);
				server.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}

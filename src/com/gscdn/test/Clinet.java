package com.gscdn.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Clinet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int a=0; a<10; a++){
			
			Thread thread = new Thread(()->{
				ClientTest();
			});
		
			thread.start();			
		}
				
	}

	public static void ClientTest() {
		try {

			Socket sock = new Socket("localhost", 7070);

			OutputStream out = sock.getOutputStream();
			InputStream in = sock.getInputStream();

			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line = null;
			pw.println(line);
			pw.flush();

			String echo = br.readLine();
			System.out.println(echo);


			pw.close();
			br.close();
			sock.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}

package com.gscdn.main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.gscdn.handler.AccumulatorHandler;
import com.gscdn.model.Config;

public class ServerMain extends Thread {
	private Config conf;
	private ServerSocket server;
	private final ExecutorService thpool = Executors.newCachedThreadPool();
	public ServerMain(Config conf) throws IOException {
		// TODO Auto-generated constructor stub
		this.conf = conf;
		server = new ServerSocket(this.conf.getPort());
		System.out.println("Server Start...."+this.conf.getPort());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Socket inSocket = null;
			while ((inSocket = server.accept()) != null) {
				// System.out.println(aint.getAndIncrement());
				AccumulatorHandler handle = new AccumulatorHandler(inSocket);
//				handle.start();
				thpool.submit(handle);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

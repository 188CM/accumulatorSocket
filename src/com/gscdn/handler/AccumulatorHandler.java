package com.gscdn.handler;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

import com.gscdn.common.CountManage;
import com.gscdn.common.GsUtil;

public class AccumulatorHandler extends Thread {

	private Socket reqSocket;

	private AtomicInteger handle;

	public AtomicInteger getHandle() {
		return handle;
	}

	public void setHandle(AtomicInteger handle) {
		this.handle = handle;
	}

	public AccumulatorHandler(Socket reqSocket) {
		this.reqSocket = reqSocket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		// int result = handle.getAndIncrement();		
		int result;
		synchronized (CountManage.class) {
			result = CountManage.getCountManageIns().getAccumulator();
			handleSocket(result);
		}
		
		GsUtil.close(reqSocket);	
	}

	public void handleSocket(int result) {

		OutputStream out = null;
		try {
			out = reqSocket.getOutputStream();
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(out));
			output.write("Received your command!");
			output.flush();
			output.write("COUNT:>");
			output.write(Integer.toString(result));
			output.newLine();
			output.flush();
			System.out.println(result);
		} catch (IOException ex) {
		}
	}

}

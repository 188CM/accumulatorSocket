package com.gscdn.model;

public class Config {
	private int port = 0;
	private Class<?> factory = null;
	
	
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public Object getFactory() {
		return factory;
	}
	public void setFactory(String factory) throws ClassNotFoundException {
		this.factory = Class.forName(factory);
	}

	
	public boolean checkParameter() {
		if(port==0)	return false;
		if(factory==null) return false;			
		
		return true;
	}
	
	
}

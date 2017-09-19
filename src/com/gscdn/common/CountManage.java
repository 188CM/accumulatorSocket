package com.gscdn.common;

public class CountManage {
	
	private int count= 0;	
	private static CountManage countManageIns;

	public static CountManage getCountManageIns() {
		if(countManageIns==null) {
			synchronized (CountManage.class) {
				if (countManageIns == null)
					countManageIns = new CountManage();
			}
		}
		return countManageIns;
	}

	public int getAccumulator() {	
		return countManageIns.count++;
	}
}

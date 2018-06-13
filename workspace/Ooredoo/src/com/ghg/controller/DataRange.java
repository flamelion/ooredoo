package com.ghg.controller;

public class DataRange {
	private Object startRange;
	private Object EndRange;
	public DataRange(Object sr,Object er)
	{
		startRange=sr;
		EndRange=er;
	}
	public Object getStartRange() {
		return startRange;
	}
	public void setStartRange(Object startRange) {
		this.startRange = startRange;
	}
	public Object getEndRange() {
		return EndRange;
	}
	public void setEndRange(Object endRange) {
		EndRange = endRange;
	}
	
}

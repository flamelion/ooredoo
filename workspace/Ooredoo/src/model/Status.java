package model;

import java.time.LocalDate;

import Components.MyTableColumn;
import model.SelectionRow.MyTableRow;

public class Status {

	
	
	
	private LocalDate date;
	private String status="";
	public Status()
	{
		date=LocalDate.now();
		status="";
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date= date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status= status;
	}
	
}

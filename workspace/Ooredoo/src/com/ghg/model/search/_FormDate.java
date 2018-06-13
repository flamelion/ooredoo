package com.ghg.model.search;

import java.time.LocalDate;

import com.ghg.controller.DataRange;
import com.ghg.controller.GETVALUE;

import model.interface_objects.employeeinterface;

public class _FormDate extends GETVALUE {
	@Override
	public boolean checkValue(Object obj) {
		super.checkValue(obj);
		employeeinterface emp = (employeeinterface) obj;
		DataRange searchvalue = (DataRange) this.getSearchvalue();
		LocalDate start =(LocalDate) searchvalue.getStartRange();
		LocalDate end = (LocalDate)searchvalue.getEndRange();
		LocalDate regdate = emp.getReg_date();
		if((regdate.compareTo(start)>-1) && (regdate.compareTo(end)<1))
			return true;
			
		return false;

	}
}

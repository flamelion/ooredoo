package com.ghg.model.search;

import com.ghg.controller.GETVALUE;

import model.interface_objects.employeeinterface;
import test.Employee_Table_Interface_Object;

public class _FormNo extends GETVALUE {

	@Override
	public boolean checkValue(Object obj) {
		 super.checkValue(obj);
		employeeinterface emp=(employeeinterface)obj;
		String searchvalue=(String)this.getSearchvalue();
		 searchvalue=searchvalue.toUpperCase();
		if(emp.getFormno().toUpperCase().contains(searchvalue))
			return true;
		else
			return false;
	}
	
}

package com.ghg.model.search;

import com.ghg.controller.GETVALUE;

import model.interface_objects.employeeinterface;

public class _Name extends GETVALUE{
	@Override
	public boolean checkValue(Object obj) {
		 super.checkValue(obj);
		employeeinterface emp=(employeeinterface)obj;
		String searchvalue=(String)this.getSearchvalue();
		if(emp.getName().toUpperCase().contains(searchvalue.toUpperCase()))
			return true;
		else
			return false;
	}
}

package com.ghg.model.search;

import com.ghg.controller.GETVALUE;

import model.ApplyPost;
import model.interface_objects.employeeinterface;

public class _TravelorNot extends GETVALUE{
	@Override
	public boolean checkValue(Object obj) {
		 super.checkValue(obj);
		employeeinterface emp=(employeeinterface)obj;
		String searchvalue=(String)this.getSearchvalue();
		searchvalue=searchvalue.toUpperCase();
			
			if(emp.getConcernworkfact().getTravelornot().toUpperCase().contains(searchvalue))
				return true;		
		
	
			return false;
	}
}

package com.ghg.model.search;

import com.ghg.controller.GETVALUE;

import model.Education;
import model.Status;
import model.interface_objects.employeeinterface;

public class _Status extends GETVALUE {
	@Override
	public boolean checkValue(Object obj) {
		 super.checkValue(obj);
		employeeinterface emp=(employeeinterface)obj;
		String searchvalue=(String)this.getSearchvalue();
		searchvalue=searchvalue.toUpperCase();
		for(int i=0;i<emp.getStatus().size();i++)
		{
			 Status status=emp.getStatus().get(i);
			if(status.getStatus().toUpperCase().contains(searchvalue))
				return true;		
		}
		if(emp.getStatus().size()==0)
		{
			if(searchvalue.equals(""))
				return true;
		}
	
			return false;
	}
}

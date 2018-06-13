package com.ghg.model.search;

import com.ghg.controller.GETVALUE;

import model.Education;
import model.interface_objects.employeeinterface;

public class _Institude extends GETVALUE{
	@Override
	public boolean checkValue(Object obj) {
		 super.checkValue(obj);
		employeeinterface emp=(employeeinterface)obj;
		String searchvalue=(String)this.getSearchvalue();
		searchvalue=searchvalue.toUpperCase();
		for(int i=0;i<emp.getDegree().size();i++)
		{
			 Education edu=emp.getDegree().get(i);
			if(edu.getInstitution().toUpperCase().contains(searchvalue))
				return true;		
		}
		if(emp.getDegree().size()==0)
		{
			if(searchvalue.equals(""))
				return true;
		}
	
			return false;
	}
}

package com.ghg.model.search;

import com.ghg.controller.GETVALUE;

import model.Deploma;
import model.Education;
import model.interface_objects.employeeinterface;

public class _Deploma extends GETVALUE{
	@Override
	public boolean checkValue(Object obj) {
		 super.checkValue(obj);
		employeeinterface emp=(employeeinterface)obj;
		String searchvalue=(String)this.getSearchvalue();
		searchvalue=searchvalue.toUpperCase();
		for(int i=0;i<emp.getDeploma().size();i++)
		{
			 Deploma edu=emp.getDeploma().get(i);
			if(edu.getDeploma().toUpperCase().contains(searchvalue))
				return true;		
		}
		if(emp.getDeploma().size()==0)
		{
			if(searchvalue.equals(""))
				return true;
		}
			return false;
	}
}

package com.ghg.model.search;

import com.ghg.controller.GETVALUE;

import model.Activities;
import model.Education;
import model.interface_objects.employeeinterface;

public class _Actas extends GETVALUE {
	@Override
	public boolean checkValue(Object obj) {
		 super.checkValue(obj);
		employeeinterface emp=(employeeinterface)obj;
		String searchvalue=(String)this.getSearchvalue();
		searchvalue=searchvalue.toUpperCase();
		for(int i=0;i<emp.getActivties().size();i++)
		{
			 Activities act=emp.getActivties().get(i);
			if(act.getActas().toUpperCase().contains(searchvalue))
				return true;		
		}
		if(emp.getActivties().size()==0)
		{
			if(searchvalue.equals(""))
				return true;
		}
			return false;
	}
}

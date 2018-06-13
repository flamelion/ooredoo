package com.ghg.model.search;

import com.ghg.controller.GETVALUE;

import model.Experience;
import model.interface_objects.employeeinterface;

public class _Comtype extends GETVALUE{
	@Override
	public boolean checkValue(Object obj) {
		 super.checkValue(obj);
		employeeinterface emp=(employeeinterface)obj;
		String searchvalue=(String)this.getSearchvalue();
		searchvalue=searchvalue.toUpperCase();
		for(int i=0;i<emp.getExp().size();i++)
		{
			Experience exp=emp.getExp().get(i);
			if(exp.getCom_type().toUpperCase().contains(searchvalue))
				return true;		
		}
		if(emp.getExp().size()==0)
		{
			if(searchvalue.equals(""))
				return true;
		}
			return false;
	}
}

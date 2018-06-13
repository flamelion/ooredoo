package com.ghg.model.search;

import com.ghg.controller.GETVALUE;

import model.Activities;
import model.Insteresting;
import model.interface_objects.employeeinterface;

public class _Interesting extends GETVALUE {
	@Override
	public boolean checkValue(Object obj) {
		 super.checkValue(obj);
			employeeinterface emp=(employeeinterface)obj;
			String searchvalue=(String)this.getSearchvalue();
			searchvalue=searchvalue.toUpperCase();
			for(int i=0;i<emp.getInterest().size();i++)
			{
				 Insteresting inst=emp.getInterest().get(i);
				if(inst.getInteresting().toUpperCase().contains(searchvalue))
					return true;		
			}
			if(emp.getInterest().size()==0)
			{
				if(searchvalue.equals(""))
					return true;
			}
				return false;
		}
	
}

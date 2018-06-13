package com.ghg.model.search;

import com.ghg.controller.GETVALUE;

import model.Activities;
import model.Insteresting;
import model.Language;
import model.interface_objects.employeeinterface;

public class _Langauge extends GETVALUE {
	@Override
	public boolean checkValue(Object obj) {
		 super.checkValue(obj);
			employeeinterface emp=(employeeinterface)obj;
			String searchvalue=(String)this.getSearchvalue();
			searchvalue=searchvalue.toUpperCase();
			for(int i=0;i<emp.getLanguage().size();i++)
			{
				 Language inst=emp.getLanguage().get(i);
				if(inst.getLanguage().toUpperCase().contains(searchvalue))
					return true;		
			}
			if(emp.getLanguage().size()==0)
			{
				if(searchvalue.equals(""))
					return true;
			}
		
				return false;
		}
	
}

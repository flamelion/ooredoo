package com.ghg.model.search;

import com.ghg.controller.GETVALUE;

import model.ApplyPost;
import model.interface_objects.employeeinterface;

public class _Applypost extends GETVALUE{
	@Override
	public boolean checkValue(Object obj) {
		 super.checkValue(obj);
		employeeinterface emp=(employeeinterface)obj;
		String searchvalue=(String)this.getSearchvalue();
		searchvalue=searchvalue.toUpperCase();
		for(int i=0;i<emp.getApplypostList().size();i++)
		{
			ApplyPost ap=emp.getApplypostList().get(i);
			if(ap.getApplypost().toUpperCase().contains(searchvalue))
				return true;		
		}
		if(emp.getApplypostList().size()==0)
		{
			if(searchvalue.equals(""))
				return true;
		}
			return false;
	}
}

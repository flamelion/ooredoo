package com.ghg.model.search;

import com.ghg.controller.GETVALUE;

import model.ApplyPost;
import model.Skill;
import model.interface_objects.employeeinterface;

public class _Cetificate extends GETVALUE {
	@Override
	public boolean checkValue(Object obj) {
		 super.checkValue(obj);
		employeeinterface emp=(employeeinterface)obj;
		String searchvalue=(String)this.getSearchvalue();
		searchvalue=searchvalue.toUpperCase();
		for(int i=0;i<emp.getSkill().size();i++)
		{
			Skill sk=emp.getSkill().get(i);
			if(sk.getSkill().toUpperCase().contains(searchvalue))
				return true;		
		}
		if(emp.getSkill().size()==0)
		{
			if(searchvalue.equals(""))
				return true;
		}
			return false;
	}
}

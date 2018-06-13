package com.ghg.model.search;

import com.ghg.controller.DataRange;
import com.ghg.controller.GETVALUE;

import model.Experience;
import model.interface_objects.employeeinterface;

public class _Expyr extends GETVALUE{
	@Override
	public boolean checkValue(Object obj) {
		 super.checkValue(obj);
		employeeinterface emp=(employeeinterface)obj;
		DataRange searchvalue=(DataRange)this.getSearchvalue();
		int start=Integer.parseInt(searchvalue.getStartRange().toString());
		int end=Integer.parseInt(searchvalue.getEndRange().toString());
		for(int i=0;i<emp.getExp().size();i++)
		{
			Experience exp=(Experience)emp.getExp().get(i);
			int expyr=(int) Math.floor(exp.getExpyear());
			if(expyr>=start && expyr<=end)
				return true;
		}
		if(emp.getExp().size()==0)
		{
			int expyr=0;
			if(expyr>=start && expyr<=end)
				return true;
		}
		return false;
	
	}
}

package com.ghg.model.search;

import com.ghg.controller.DataRange;
import com.ghg.controller.GETVALUE;

import model.Experience;
import model.interface_objects.employeeinterface;

public class _WorkingExp extends GETVALUE {
	@Override
	public boolean checkValue(Object obj) {
		super.checkValue(obj);
		employeeinterface emp = (employeeinterface) obj;
		DataRange searchvalue = (DataRange) this.getSearchvalue();
		int start = Integer.parseInt(searchvalue.getStartRange().toString());
		int end = Integer.parseInt(searchvalue.getEndRange().toString());
		int expyr = emp.getTotalExperienceYear();
		if (expyr >= start && expyr <= end)
			return true;
	
		return false;

	}
}

package com.ghg.model.search;

import com.ghg.controller.DataRange;
import com.ghg.controller.GETVALUE;

import javafx.scene.chart.PieChart.Data;
import model.interface_objects.employeeinterface;

public class _Age extends GETVALUE{
	@Override
	public boolean checkValue(Object obj) {
		 super.checkValue(obj);
		employeeinterface emp=(employeeinterface)obj;
		DataRange searchvalue=(DataRange)this.getSearchvalue();
		int start=Integer.parseInt(searchvalue.getStartRange().toString());
		int end=Integer.parseInt(searchvalue.getEndRange().toString());
		int age=emp.getAge();
		
		if(age>=start && age<=end)
			return true;
		else
			return false;
	}
}

package com.ghg.controller;

import com.ghg.index.index;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

public class GETVALUE {
	 Object searchvalue;

	public Object getSearchvalue() {
		return searchvalue;
	}

	public void setSearchvalue(Object searchvalue) {
		this.searchvalue = searchvalue;
	}
	public  boolean checkValue(Object obj)
	{
		return true;
	}
	public ObservableList<String> getDistantData()
	{
	
		String func=this.getClass().getName().replace("com.ghg.model.search._", "");

		switch(func)
		{
		case"Address":return index.dbstatement.get_distinct_data("currentaddress","employee");
		case"Age":return index.dbstatement.get_distinct_data("currentaddress","employee");
		case"Applypost":return index.dbstatement.get_distinct_data("aplypost","applyposts");
		case"Cetificate":return index.dbstatement.get_distinct_data("skill","skills");
		case"ComName":return index.dbstatement.get_distinct_data("com_name","experience");
		case"Compost":return index.dbstatement.get_distinct_data("position","experience");
		case"Comtype":return index.dbstatement.get_distinct_data("com_type","experience");
		case"Degree":return index.dbstatement.get_distinct_data("Degree","Education");
		case"Deploma":return index.dbstatement.get_distinct_data("deploma","deplomas");
		case"Fatherjob":return index.dbstatement.get_distinct_data("father_job","familyhistory");
		case"Fathername":return index.dbstatement.get_distinct_data("fathername","familyhistory");
		case"Field":return index.dbstatement.get_distinct_data("field","skills");
		case"FormNo":return index.dbstatement.get_distinct_data("formno","employee");
		case"Gender":return index.dbstatement.get_distinct_data("gender","employee");
		case"HaveMotorbike":return index.dbstatement.get_distinct_data("motorbikeornot","ConcernWorkfact");
		case"Instidue":return index.dbstatement.get_distinct_data("institute","Education");
		case"MotherJob":return index.dbstatement.get_distinct_data("mother_job","familyhistory");
		case"MotherName":return index.dbstatement.get_distinct_data("mothername","familyhistory");
		case"Name":return index.dbstatement.get_distinct_data("name","employee");
		case"NRC":return index.dbstatement.get_distinct_data("nrc","employee");
		case"Ph":return index.dbstatement.get_distinct_data("phonenumber","employee");
		case"Status":return index.dbstatement.get_distinct_data("status","statuses");
		case"TaverlorNot":return index.dbstatement.get_distinct_data("travelornot","ConcernWorkfact");
		case"Activities":return index.dbstatement.get_distinct_data("activity","Activities");
		case"Actas":return index.dbstatement.get_distinct_data("actas","Activities");
		case"Interesting":return index.dbstatement.get_distinct_data("interesting","interestings");
		case"Language":return index.dbstatement.get_distinct_data("Language","Languages");

		}
		
		return FXCollections.observableArrayList();
	}

	
}

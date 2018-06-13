package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Employee {
	
	private String employeeid;
	private LocalDate startdate;
	private String name;
	private int salary;
	private ArrayList<String> position;
	//should be public to visible from Tablecell combobox
	private String selected_position;
	public Employee()
	{
		position=new ArrayList<>();
	}
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	public LocalDate getStartdate() {
		return startdate;
	}
	public void setStartdate(LocalDate localDate) {
		this.startdate = localDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		check();
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
		check();
	}
	public String getPosition() {
		String s="";
		for(int i=0;i<position.size();i++)
		{
			s+=position.get(i);
			if(i+1!=position.size())
					s+=",";
		}
		return s;
	}
	public void setPosition(ArrayList<String> position) {
		this.position = position;
	}
	public String getSelected_position() {
		return selected_position;
	}
	public void setSelected_position(String selected_position) {
		this.selected_position = selected_position;
	
	}
	public void check()
	{
		if(name.equals("Nyan"))
			employeeid="Name Error";
		else if(salary>5000)
			employeeid="Salary Error";
		else
			employeeid="OK";
	}
	
	
	
}

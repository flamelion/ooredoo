package model;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class Experience {
	private String com_name="";
	private String com_type="";
	
	private String position="";
	private String dept="";
	private String basicsalary="";
	private LocalDate joindate;
	private LocalDate resigndate;
	private float expyear=-1.0f;
	private String resonsofresign="";
	private String responsibilities="";
	public Experience()
	{
		expyear=0;
	}
	public String getCom_name() {
		return com_name;
	}
	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getBasicsalary() {
		return basicsalary;
	}
	public void setBasicsalary(String basicsalary) {
		this.basicsalary = basicsalary;
	}


	public LocalDate getJoindate() {
		return joindate;
	}
	public void setJoindate(LocalDate joindate) {
		this.joindate = joindate;
	}
	public LocalDate getResigndate() {
		return resigndate;
	}
	public void setResigndate(LocalDate resigndate) {
		if(resigndate==null)
			resigndate=LocalDate.now();
		this.resigndate = resigndate;
	}
	public float getExpyear() {		
		if(joindate!=null)
		{
			 Period p;
			
			if(resigndate!=null)
			{
				 p=Period.between(joindate, resigndate);
			}
			else
			{
				 p=Period.between(joindate, LocalDate.now());
			

			}
			expyear=(float) (p.getYears()+(p.getMonths()/12.0));

		}
		return expyear;
	}
	public void setExpyear(float expyear) {
		this.expyear = expyear;
	}
	public String getResonsofresign() {
		return resonsofresign;
	}
	public String getCom_type() {
		return com_type;
	}
	public void setCom_type(String com_type) {
		this.com_type = com_type;
	}
	public void setResonsofresign(String resonsofresign) {
		this.resonsofresign = resonsofresign;
	}
	public String getResponsibilities() {
		return responsibilities;
	}
	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}
	
}

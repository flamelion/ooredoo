package model.interface_objects;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;
import model.Activities;
import model.ApplyPost;
import model.Attending_Class;
import model.ConcernWorkfact;
import model.Deploma;
import model.Education;
import model.Employee;
import model.Experience;
import model.FamilyHistory;
import model.File_Class;
import model.Insteresting;
import model.Language;
import model.Skill;
import model.Status;

public class employeeinterface extends Employee {
	private String applypoststring="";
	private String degreeliststring="";
	private String deplomaliststring="";
	private String attendingclasslisttring="";
	private String langaugeliststring="";
	private String skillliststring="";
	private String expliststring="";
	private String attachmentliststring="";
	private String intestringliststring="";


	private String statusliststring="";
	private String activitesliststring="";

	public String getIntestringliststring() {
		intestringliststring = "";
		for (int i = 0; i < getInterest().size(); i++) {
			Insteresting inst = getInterest().get(i);
			intestringliststring += "[ " + inst.getInteresting() + " ]";
			if (i != getInterest().size() - 1)
				intestringliststring += ",";
		}
		return intestringliststring;
	}
	public int getTotalExperienceYear()
	{
		double yr=0;
		for (int i = 0; i < getExp().size(); i++) {
			Experience ex = getExp().get(i);
			
				yr+=(double)ex.getExpyear();
		}
		return (int) Math.floor(yr);
	}
	public String getDeplomaliststring() {
		deplomaliststring="";
		for (int i = 0; i < getDeploma().size(); i++) {
			Deploma p=getDeploma().get(i);
			deplomaliststring=p.getDeploma();
			if (i != getDeploma().size() - 1)
				deplomaliststring += ",";
			
		}
		return deplomaliststring;
	}

	public String getApplypoststring() {
		applypoststring="";
		for (int i = 0; i < getApplypostList().size(); i++) {
			ApplyPost p=getApplypostList().get(i);
			applypoststring=p.getApplypost();
			if (i != getApplypostList().size() - 1)
				applypoststring += ",";
			
		}
		return applypoststring;
	}

	public String getActivitesliststring() {
		activitesliststring = "";
		for (int i = 0; i < getActivties().size(); i++) {
			Activities actvities = getActivties().get(i);
			String temp = "";
			if (actvities.getActivies().length() > 0)
				temp = actvities.getActivies();
			else if (actvities.getActivies().length() > 0)
				temp = "," + actvities.getActas();

			activitesliststring += "[ " + temp + " ]";
			if (i != getActivties().size() - 1)
				activitesliststring += ",";
		}
		return activitesliststring;
	}

	public void setActivitesliststring(String activitesliststring) {
		this.activitesliststring = activitesliststring;
	}

	public String getStatusliststring() {
		statusliststring = "";
		for (int i = 0; i < getStatus().size(); i++) {
			Status status = getStatus().get(i);
			statusliststring += "[ " + status.getStatus() + " ]";
			if (i < getStatus().size() - 1)
				statusliststring += ",";
		}
		return statusliststring;
	}



	public String getDegreeliststring() {
		degreeliststring="";
		for (int i = 0; i < getDegree().size(); i++) {
			Education edu = getDegree().get(i);
			String temp = "";
			if (edu.getDegree().length() > 0)
				temp += edu.getDegree();
			if (edu.getYear().length() > 0)
				temp +="," +edu.getYear();
			if (edu.getInstitution().length() > 0)
				temp += "," + edu.getInstitution();
			degreeliststring += "[ " + temp + " ]";
			if (i < getDegree().size() - 1)
				degreeliststring += ",";
		}
		return degreeliststring;
	}

	public String getAttendingclasslisttring() {
		attendingclasslisttring = "";
		for (int i = 0; i < getAttending_class().size(); i++) {
			Attending_Class ac = getAttending_class().get(i);
			attendingclasslisttring += "[ " + ac.get_class() + " ]";
			if (i < getAttending_class().size() - 1)
				attendingclasslisttring += ",";
		}
		return attendingclasslisttring;
	}

	public String getLangaugeliststring() {
		langaugeliststring = "";
		for (int i = 0; i < getLanguage().size(); i++) {
			Language ac = getLanguage().get(i);
			langaugeliststring += "[ " + ac.getLanguage() + ":Lis(" + ac.getListening() + "),Read(" + ac.getRead()
					+ "),Write(" + ac.getWrite() + "),Speak(" + ac.getSpeak() + ") ]";
			if (i < getLanguage().size() - 1)
				langaugeliststring += ",";
		}
		return langaugeliststring;
	}

	public String getSkillliststring() {
		skillliststring = "";
		for (int i = 0; i < getSkill().size(); i++) {
			Skill sk = getSkill().get(i);
			skillliststring += "[ " + sk.getField() + "(" + sk.getSkill() + ") ]";
			if (i < getSkill().size() - 1)
				skillliststring += ",";
		}
		return skillliststring;
	}
	
	public String getExpliststring() {
		expliststring = "";
		for (int i = 0; i < getExp().size(); i++) {
			Experience ex = getExp().get(i);
			String temp = "";
			if (ex.getCom_name().length() > 0)
				temp += ex.getCom_name();
			if (ex.getCom_name().length() > 0)
				temp +="," +ex.getCom_type();
			if (ex.getPosition().length() > 0)
				temp += "," + ex.getPosition();
			if (ex.getExpyear() > 0)
				temp += "," + ex.getExpyear();
			expliststring += "[ " + temp + " ]";
			if (i < (getExp().size() - 1))
				expliststring += ",";
		}
		return expliststring;
	}

	public String getAttachmentliststring() {
		attachmentliststring = "" + getAttachment().size();
		return attachmentliststring;
	}

}

package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import javafx.scene.control.TableColumn;

public class Employee {

	private String formno="";
	private File_Class profilepic;
	private LocalDate reg_date;
	private String name="";
	private String expected_salary="";
	private ArrayList<ApplyPost> applypostlist;
	private String joinat="";
	private LocalDate dob;
	private int age=0;
	private String placeofbirth="";
	private String gender="";
	private String materialstatus="";
	private String nationality="";
	private String religion="";
	private String nrc="";
	private String drivinglic="";
	private String currentaddress="";
	private String permanentaddress="";
	private String phonenumber="";
	private ArrayList<Education> degree;
	private ArrayList<Deploma> deploma;
	private ArrayList<Attending_Class> attending_class;
	private ArrayList<Language> language;
	private ArrayList<Skill> skill;
	private ArrayList<Experience> exp;
	private ArrayList<Insteresting>interest;
	private ArrayList<Activities> activties;
	private ArrayList<Status> status;
	private FamilyHistory family_history;
	private ConcernWorkfact concernworkfact;
	private ArrayList<File_Class> attachment;
	public Employee()
	{
		reg_date=LocalDate.now();
		dob=LocalDate.now();
		applypostlist=new ArrayList<>();
		degree=new ArrayList<>();
		deploma=new ArrayList<>();
		attending_class=new ArrayList<>();
		language=new ArrayList<>();
		skill=new ArrayList<>();
		exp=new ArrayList<>();
		interest=new ArrayList<>();
		family_history=new  FamilyHistory();
		concernworkfact=new ConcernWorkfact();
		profilepic=new File_Class();
		interest=new ArrayList<>();
		status=new ArrayList<>();
		attachment=new ArrayList<>();
		activties=new ArrayList<>();
	}
	
	public ArrayList<ApplyPost> getApplypostList() {
		return applypostlist;
	}

	public void setApplypost(ArrayList<ApplyPost> applypost) {
		this.applypostlist = applypost;
	}

	public ArrayList<Status> getStatus() {
		return status;
	}

	public void setStatus(ArrayList<Status> status) {
		this.status = status;
	}

	public ArrayList<Insteresting> getInterest() {
		return interest;
	}

	public void setInterest(ArrayList<Insteresting> interest) {
		this.interest = interest;
	}

	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getFormno() {
		return formno;
	}
	public void setFormno(String formno) {
		this.formno = formno;
	}
	public LocalDate getReg_date() {
		return reg_date;
	}
	public void setReg_date(LocalDate reg_date) {
		this.reg_date = reg_date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExpected_salary() {
		return expected_salary;
	}
	public void setExpected_salary(String expected_salary) {
		this.expected_salary = expected_salary;
	}
	public String getJoinat() {
		return joinat;
	}
	public void setJoinat(String joinat) {
		this.joinat = joinat;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public int getAge() {
		if(dob!=null)
		{
			LocalDate today=LocalDate.now();
			Period p=Period.between(dob, today);
			return p.getYears();
		}
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPlaceofbirth() {
		return placeofbirth;
	}
	public void setPlaceofbirth(String placeofbirth) {
		this.placeofbirth = placeofbirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMaterialstatus() {
		return materialstatus;
	}
	public void setMaterialstatus(String materialstatus) {
		this.materialstatus = materialstatus;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getNrc() {
		return nrc;
	}
	public void setNrc(String nrc) {
		this.nrc = nrc;
	}
	public String getDrivinglic() {
		return drivinglic;
	}
	public void setDrivinglic(String drivinglic) {
		this.drivinglic = drivinglic;
	}
	public String getCurrentaddress() {
		return currentaddress;
	}
	public void setCurrentaddress(String currentaddress) {
		this.currentaddress = currentaddress;
	}
	public String getPermanentaddress() {
		return permanentaddress;
	}
	public void setPermanentaddress(String permanentaddress) {
		this.permanentaddress = permanentaddress;
	}
	public ArrayList<Education> getDegree() {
		return degree;
	}
	public void setDegree(ArrayList<Education> degree) {
		this.degree = degree;
	}
	public ArrayList<Deploma> getDeploma() {
		return deploma;
	}
	public void setDeploma(ArrayList<Deploma> deploma) {
		this.deploma = deploma;
	}
	public ArrayList<Attending_Class> getAttending_class() {
		return attending_class;
	}
	public void setAttending_class(ArrayList<Attending_Class> attending_class) {
		this.attending_class = attending_class;
	}
	public ArrayList<Language> getLanguage() {
		return language;
	}
	public void setLanguage(ArrayList<Language> language) {
		this.language = language;
	}
	public ArrayList<Skill> getSkill() {
		return skill;
	}
	public void setSkill(ArrayList<Skill> skill) {
		this.skill = skill;
	}
	public ArrayList<Experience> getExp() {
		return exp;
	}
	public void setExp(ArrayList<Experience> exp) {
		this.exp = exp;
	}
	public FamilyHistory getFamily_history() {
		return family_history;
	}
	public void setFamily_history(FamilyHistory family_history) {
		this.family_history = family_history;
	}
	public ConcernWorkfact getConcernworkfact() {
		return concernworkfact;
	}
	public void setConcernworkfact(ConcernWorkfact concernworkfact) {
		this.concernworkfact = concernworkfact;
	}
	public File_Class getProfilepic() {
		return profilepic;
	}
	public void setProfilepic(File_Class profilepic) {
		this.profilepic = profilepic;
	}
	public ArrayList<File_Class> getAttachment() {
		return attachment;
	}
	public void setAttachment(ArrayList<File_Class> attachment) {
		this.attachment = attachment;
	}
	public ArrayList<Activities> getActivties() {
		return activties;
	}

	public void setActivties(ArrayList<Activities> activties) {
		this.activties = activties;
	}


}

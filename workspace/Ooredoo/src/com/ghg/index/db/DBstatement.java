package com.ghg.index.db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jcifs.smb.SmbFile;
import model.Activities;
import model.ApplyPost;
import model.Attending_Class;
import model.ConcernWorkfact;
import model.Deploma;
import model.Education;
import model.Experience;
import model.FamilyHistory;
import model.File_Class;
import model.Insteresting;
import model.Language;
import model.Skill;
import model.Status;
import model.SelectionRow.MyTableRow;
import model.interface_objects.employeeinterface;

public class DBstatement {
	private Connection connection;

	public DBstatement() throws SQLException, IOException {
		connection = DBInitialize.getConnection();
	}

	public ObservableList<String> get_distinct_data(String f, String t) {
		ObservableList<String> datalist = FXCollections.observableArrayList();
		try {
			connection.setAutoCommit(false);
			CallableStatement mycallable = connection.prepareCall("{call employee.dintinct_Data(?,?)}");
			mycallable.setString(1, f);
			mycallable.setString(2, t);
			mycallable.execute();
			connection.commit();
			ResultSet rs = mycallable.getResultSet();
			while (rs.next()) {
				String data = rs.getString("dinstinctdata");
				datalist.add(data);
			}
		} catch (SQLException e) {
			connection_rollback();
			e.printStackTrace();
		}
		return datalist;
	}

	public ObservableList<MyTableRow> get_loadEmployeedata() throws MalformedURLException, URISyntaxException {
		ObservableList<MyTableRow> employeelist = FXCollections.observableArrayList();
		try {
			connection.setAutoCommit(false);
			CallableStatement mycallable = connection.prepareCall("{call employee.select_all_employee()}");
			mycallable.execute();

			ResultSet rs = mycallable.getResultSet();
			while (rs.next()) {
				employeeinterface emp = new employeeinterface();
				if (rs.getString("formno") != null)
					emp.setFormno(rs.getString("formno"));

				File_Class proc = new File_Class();
				if (rs.getString("profilepic") != null)
					proc = new File_Class(rs.getString("profilepic"));
				emp.setProfilepic(proc);
				if (rs.getTimestamp("reg_date") != null)
					emp.setReg_date(rs.getTimestamp("reg_date").toLocalDateTime().toLocalDate());
				if (rs.getString("name") != null)
					emp.setName(rs.getString("name"));
				if (rs.getString("expected_salary") != null)
					emp.setExpected_salary(rs.getString("expected_salary"));
				if (rs.getString("joinat") != null)
					emp.setJoinat(rs.getString("joinat"));
				if (rs.getTimestamp("dob") != null)
					emp.setDob(rs.getTimestamp("dob").toLocalDateTime().toLocalDate());
				if (rs.getString("placeofbirth") != null)

					emp.setPlaceofbirth(rs.getString("placeofbirth"));
				if (rs.getString("gender") != null)

					emp.setGender(rs.getString("gender"));
				if (rs.getString("materialstatus") != null)
					emp.setMaterialstatus(rs.getString("materialstatus"));
				if (rs.getString("nationality") != null)

					emp.setNationality(rs.getString("nationality"));
				if (rs.getString("religion") != null)

					emp.setReligion(rs.getString("religion"));
				if (rs.getString("nrc") != null)

					emp.setNrc(rs.getString("nrc"));
				if (rs.getString("drivinglic") != null)

					emp.setDrivinglic(rs.getString("drivinglic"));
				if (rs.getString("currentaddress") != null)

					emp.setCurrentaddress(rs.getString("currentaddress"));
				if (rs.getString("permanentaddress") != null)

					emp.setPermanentaddress(rs.getString("permanentaddress"));
				if (rs.getString("phonenumber") != null)
					emp.setPhonenumber(rs.getString("phonenumber"));
				mycallable = connection.prepareCall("{call employee.selec_tableswith_formno(?,?)}");
				mycallable.setString(1, emp.getFormno());
				mycallable.setString(2, "ConcernWorkfact");
				mycallable.execute();
				ResultSet rs1 = mycallable.getResultSet();
				while (rs1.next()) {
					ConcernWorkfact concernWorkfact = new ConcernWorkfact();
					if (rs1.getString("bondornot") != null)
						concernWorkfact.setBondornot(rs1.getString("bondornot"));
					if (rs1.getString("bondyr") != null)
						concernWorkfact.setBondyr(rs1.getString("bondyr"));

					if (rs1.getString("workothercities") != null)
						concernWorkfact.setWortkothercities(rs1.getString("workothercities"));

					if (rs1.getString("motorbikeornot") != null)
						concernWorkfact.setMotorbikeornot(rs1.getString("motorbikeornot"));
					if (rs1.getString("overtime") != null)
						concernWorkfact.setOvertime(rs1.getString("overtime"));
					if (rs1.getString("travelornot") != null)
						concernWorkfact.setTravelornot(rs1.getString("travelornot"));
					if (rs1.getString("workuntil") != null)
						concernWorkfact.setWorkuntail(rs1.getString("workuntil"));
					if (rs1.getString("cititesare") != null)
						concernWorkfact.setCitiesare(rs1.getString("cititesare"));
					emp.setConcernworkfact(concernWorkfact);
				}

				mycallable = connection.prepareCall("{call employee.selec_tableswith_formno(?,?)}");
				mycallable.setString(1, emp.getFormno());
				mycallable.setString(2, "Education");
				mycallable.execute();
				rs1 = mycallable.getResultSet();
				ArrayList<Education> edus = new ArrayList();
				while (rs1.next()) {
					Education edu = new Education();
					if (rs1.getString("Degree") != null)
						edu.setDegree(rs1.getString("Degree"));
					if (rs1.getString("Year") != null)
						edu.setYear(rs1.getString("Year"));
					if (rs1.getString("institute") != null)
						edu.setInstitution(rs1.getString("institute"));
					if (rs1.getString("Country") != null)
						edu.setCountry(rs1.getString("Country"));
					if (rs1.getString("Remark") != null)
						edu.setRemark(rs1.getString("Remark"));
					edus.add(edu);

				}
				emp.setDegree(edus);
				mycallable = connection.prepareCall("{call employee.selec_tableswith_formno(?,?)}");
				mycallable.setString(1, emp.getFormno());
				mycallable.setString(2, "activities");
				mycallable.execute();
				rs1 = mycallable.getResultSet();
				ArrayList<Activities> Activitieslist = new ArrayList<>();
				while (rs1.next()) {
					Activities act = new Activities();

					if (rs1.getString("activity") != null)
						act.setActivies(rs1.getString("activity"));

					if (rs1.getString("duration") != null)
						act.setDuration(rs1.getString("duration"));

					if (rs1.getString("actas") != null)
						act.setActas(rs1.getString("actas"));
					Activitieslist.add(act);
				}
				emp.setActivties(Activitieslist);
				mycallable = connection.prepareCall("{call employee.selec_tableswith_formno(?,?)}");
				mycallable.setString(1, emp.getFormno());
				mycallable.setString(2, "Languages");
				mycallable.execute();
				rs1 = mycallable.getResultSet();
				ArrayList<Language> languagelist = new ArrayList<>();
				while (rs1.next()) {
					Language lan = new Language();
					if (rs1.getString("Language") != null)
						lan.setLanguage("Language");
					if (rs1.getString("read") != null)
						lan.setRead("read");
					if (rs1.getString("write") != null)
						lan.setWrite("write");
					if (rs1.getString("speak") != null)
						lan.setSpeak("speak");
					if (rs1.getString("listern") != null)
						lan.setListening("listern");
					languagelist.add(lan);
				}
				emp.setLanguage(languagelist);
				mycallable = connection.prepareCall("{call employee.selec_tableswith_formno(?,?)}");
				mycallable.setString(1, emp.getFormno());
				mycallable.setString(2, "interestings");
				mycallable.execute();
				rs1 = mycallable.getResultSet();
				rs1 = mycallable.getResultSet();
				ArrayList<Insteresting> interstinglist = new ArrayList<>();
				while (rs1.next()) {
					Insteresting inst = new Insteresting();
					if (rs1.getString("path") != null)
						inst.setInteresting(rs1.getString("interesting"));
					interstinglist.add(inst);
				}
				mycallable = connection.prepareCall("{call employee.selec_tableswith_formno(?,?)}");
				mycallable.setString(1, emp.getFormno());
				mycallable.setString(2, "attachment");
				mycallable.execute();
				rs1 = mycallable.getResultSet();
				ArrayList<File_Class> attachmentlist = new ArrayList<>();

				while (rs1.next()) {
					File_Class path = new File_Class();
					if (rs1.getString("path") != null)
						path = new File_Class(rs.getString("profilepic"));
					attachmentlist.add(path);
				}
				emp.setAttachment(attachmentlist);
				mycallable = connection.prepareCall("{call employee.selec_tableswith_formno(?,?)}");
				mycallable.setString(1, emp.getFormno());
				mycallable.setString(2, "applyposts");
				mycallable.execute();
				rs1 = mycallable.getResultSet();
				ArrayList<ApplyPost> applyPostlist = new ArrayList<>();
				while (rs1.next()) {
					ApplyPost ap = new ApplyPost();
					if (rs1.getString("aplypost") != null)
						ap.setApplypost(rs1.getString("aplypost"));
					applyPostlist.add(ap);
				}
				emp.setApplypost(applyPostlist);

				mycallable = connection.prepareCall("{call employee.selec_tableswith_formno(?,?)}");
				mycallable.setString(1, emp.getFormno());
				mycallable.setString(2, "attending_class");
				mycallable.execute();
				rs1 = mycallable.getResultSet();
				ArrayList<Attending_Class> attending_classlsit = new ArrayList<>();
				while (rs1.next()) {
					Attending_Class ac = new Attending_Class();
					if (rs1.getString("_class") != null)
						ac.set_class(rs1.getString("_class"));
					attending_classlsit.add(ac);
				}
				emp.setAttending_class(attending_classlsit);

				mycallable = connection.prepareCall("{call employee.selec_tableswith_formno(?,?)}");
				mycallable.setString(1, emp.getFormno());
				mycallable.setString(2, "familyhistory");
				mycallable.execute();
				rs1 = mycallable.getResultSet();
				while (rs1.next()) {
					FamilyHistory fmh = new FamilyHistory();
					if (rs1.getString("fathername") != null)
						fmh.setFathername(rs1.getString("fathername"));
					if (rs1.getString("father_job") != null)
						fmh.setFather_job(rs1.getString("father_job"));
					if (rs1.getString("mothername") != null)
						fmh.setMothername(rs1.getString("mothername"));
					if (rs1.getString("mother_job") != null)
						fmh.setMother_job(rs1.getString("mother_job"));
					emp.setFamily_history(fmh);
				}

				mycallable = connection.prepareCall("{call employee.selec_tableswith_formno(?,?)}");
				mycallable.setString(1, emp.getFormno());
				mycallable.setString(2, "deplomas");
				mycallable.execute();
				rs1 = mycallable.getResultSet();
				ArrayList<Deploma> Deplomalist = new ArrayList<>();
				while (rs1.next()) {
					Deploma dep = new Deploma();
					if (rs1.getString("deploma") != null)
						dep.setDeploma(rs1.getString("deploma"));
					Deplomalist.add(dep);
				}
				emp.setDeploma(Deplomalist);

				emp.setInterest(interstinglist);
				mycallable = connection.prepareCall("{call employee.selec_tableswith_formno(?,?)}");
				mycallable.setString(1, emp.getFormno());
				mycallable.setString(2, "skills");
				mycallable.execute();
				rs1 = mycallable.getResultSet();
				ArrayList<Skill> skillist = new ArrayList<>();
				while (rs1.next()) {
					Skill skill = new Skill();
					if (rs1.getString("skill") != null)
						skill.setSkill(rs1.getString("skill"));
					if (rs1.getString("filed") != null)
						skill.setSkill(rs1.getString("field"));
					skillist.add(skill);
				}
				emp.setSkill(skillist);

				mycallable = connection.prepareCall("{call employee.selec_tableswith_formno(?,?)}");
				mycallable.setString(1, emp.getFormno());
				mycallable.setString(2, "statuses");
				mycallable.execute();
				rs1 = mycallable.getResultSet();
				ArrayList<Status> Statuslist = new ArrayList<>();
				while (rs1.next()) {
					Status status = new Status();
					if (rs1.getTimestamp("date") != null)
						emp.setDob(rs.getTimestamp("date").toLocalDateTime().toLocalDate());
					if (rs1.getString("status") != null)
						status.setStatus(rs1.getString("status"));
					Statuslist.add(status);
				}
				emp.setStatus(Statuslist);

				mycallable = connection.prepareCall("{call employee.selec_tableswith_formno(?,?)}");
				mycallable.setString(1, emp.getFormno());
				mycallable.setString(2, "experience");
				mycallable.execute();
				rs1 = mycallable.getResultSet();
				ArrayList<Experience> explist = new ArrayList<>();

				while (rs1.next()) {
					Experience exp = new Experience();

					if (rs1.getString("com_name") != null)
						exp.setCom_name(rs1.getString("com_name"));
					if (rs1.getString("com_type") != null)
						exp.setCom_type(rs1.getString("com_type"));
					if (rs1.getString("position") != null)
						exp.setPosition(rs1.getString("position"));
					if (rs1.getString("dept") != null)
						exp.setDept(rs1.getString("dept"));
					if (rs1.getString("basicsalary") != null)
						exp.setBasicsalary(rs1.getString("basicsalary"));
					if (rs1.getString("resonsofresign") != null)
						exp.setResonsofresign(rs1.getString("resonsofresign"));
					if (rs1.getString("responsibilities") != null)
						exp.setResponsibilities(rs1.getString("responsibilities"));
					
					if( rs1.getString("joindate")!=null)
						exp.setJoindate(rs1.getTimestamp("joindate").toLocalDateTime().toLocalDate());
					if( rs1.getString("resigndate")!=null)
						exp.setJoindate(rs1.getTimestamp("resigndate").toLocalDateTime().toLocalDate());
				
					if( rs1.getString("expyear")!=null)
						exp.setExpyear(rs1.getFloat("expyear"));

					explist.add(exp);
				}
				emp.setExp(explist);
				employeelist.add(new MyTableRow(emp));
			}

			connection.commit();
		} catch (SQLException e) {

			connection_rollback();
			e.printStackTrace();
		}
		return employeelist;

	}

	private void connection_rollback() {
		try {
			connection.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

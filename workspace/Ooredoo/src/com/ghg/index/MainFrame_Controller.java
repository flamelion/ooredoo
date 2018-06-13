package com.ghg.index;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.ghg.controller.DataRange;
import com.ghg.controller.DateSearchController;
import com.ghg.controller.GETVALUE;
import com.ghg.controller.NumberSearchController;
import com.ghg.controller.TextSearchController;
import com.ghg.model.search._Age;
import com.ghg.model.search._FormDate;
import com.ghg.model.search._FormNo;
import com.ghg.model.search._Actas;
import com.ghg.model.search._Activities;
import com.ghg.model.search._Address;
import com.ghg.model.search._Applypost;
import com.ghg.model.search._Cetificate;
import com.ghg.model.search._ComName;
import com.ghg.model.search._Compost;
import com.ghg.model.search._Comtype;
import com.ghg.model.search._Degree;
import com.ghg.model.search._Deploma;
import com.ghg.model.search._Expyr;
import com.ghg.model.search._Fatherjob;
import com.ghg.model.search._Fathername;
import com.ghg.model.search._Field;
import com.ghg.model.search._Gender;
import com.ghg.model.search._HavMotorbike;
import com.ghg.model.search._Institude;
import com.ghg.model.search._Interesting;
import com.ghg.model.search._Langauge;
import com.ghg.model.search._MotherJob;
import com.ghg.model.search._MotherName;
import com.ghg.model.search._NRC;
import com.ghg.model.search._Name;
import com.ghg.model.search._Ph;
import com.ghg.model.search._Status;
import com.ghg.model.search._TravelorNot;
import com.ghg.model.search._WorkingExp;

import Components.MyTableColumn;
import CustomTableFx.MyFXTable;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.Employee;
import model.File_Class;
import model.Status;
import model.SelectionRow.MyTableRow;
import model.TableCell.TableHyperlinkCell;
import model.interface_objects.employeeinterface;
import test.Employee_Table_Interface_Object;

public class MainFrame_Controller {
	public static ArrayList<Object> filtervaluelist;
	@FXML
	private VBox filtervbox;
	@FXML
	private AnchorPane emptablepane;

	private ObservableList<MyTableColumn> columnlist;
	private MyFXTable<MyTableRow> emptable;
	private TableColumn<MyTableRow, Object> selectedcolumn;
	@FXML
	private Button columnchange;
	@FXML
	private CheckBox cbregdate;
	@FXML
	private ScrollPane filterscroll;
	@FXML
	private CheckBox cbformno;

	@FXML
	private CheckBox cbname;

	@FXML
	private CheckBox cbapplypost;

	@FXML
	private CheckBox cbexpecetedsalary;

	@FXML
	private CheckBox cbjointat;

	@FXML
	private CheckBox cbage;

	@FXML
	private CheckBox cbplaceofbirth;

	@FXML
	private CheckBox cbgender;

	@FXML
	private CheckBox cbmaterialstatus;

	@FXML
	private CheckBox cbnationality;

	@FXML
	private CheckBox cbreligion;

	@FXML
	private CheckBox cbnrc;

	@FXML
	private CheckBox cbdrivinglic;

	@FXML
	private CheckBox cbcurrentaddress;

	@FXML
	private CheckBox cbpermanentaddress;

	@FXML
	private CheckBox cbphonenumber;

	@FXML
	private CheckBox cbdegree;

	@FXML
	private CheckBox cbDeploma;

	@FXML
	private CheckBox cbattending_class;

	@FXML
	private CheckBox cbexperience;

	@FXML
	private CheckBox ccbskill;

	@FXML
	private CheckBox cblangauge;

	@FXML
	private CheckBox cbinteresting;

	@FXML
	private CheckBox cbActivities;

	@FXML
	private CheckBox cbfathername;

	@FXML
	private CheckBox cbFatherJob;

	@FXML
	private CheckBox cbbmotherName;

	@FXML
	private CheckBox cbmotherjob;

	@FXML
	private CheckBox cbovetime;

	@FXML
	private CheckBox cbworkuntil;

	@FXML
	private CheckBox cbtravelornot;

	@FXML
	private CheckBox cbworkcities;

	@FXML
	private CheckBox cbworkcitiesare;

	@FXML
	private CheckBox cbbond;

	@FXML
	private CheckBox cbbondyear;

	@FXML
	private CheckBox cbmotorbike;

	@FXML
	private CheckBox cbattachment;

	@FXML
	private CheckBox cbstatus;

	@FXML
	private Button filter_flash;
	@FXML
	private MenuItem mnu_formno;
	@FXML
	private MenuItem mnu_name;

	@FXML
	private MenuItem mnu_age;

	@FXML
	private MenuItem mnu_gender;

	@FXML
	private MenuItem mnu_applypost;

	@FXML
	private MenuItem mnu_nrc;

	@FXML
	private MenuItem mnu_ph;

	@FXML
	private MenuItem mnu_address;

	@FXML
	private MenuItem mnu_comname;

	@FXML
	private MenuItem mnu_company_type;

	@FXML
	private MenuItem mnu_company_position;

	@FXML
	private MenuItem mnu_expyear;

	@FXML
	private MenuItem mnu_degree;

	@FXML
	private MenuItem mnu_institude;

	@FXML
	private MenuItem mnu_deploma;

	@FXML
	private MenuItem mnu_field;

	@FXML
	private MenuItem mnu_certificate;

	@FXML
	private MenuItem mnu_fathername;

	@FXML
	private MenuItem mnu_fatherjob;

	@FXML
	private MenuItem mnu_mothername;

	@FXML
	private MenuItem mnu_motherjob;

	@FXML
	private MenuItem mnu_havemotorbike;

	@FXML
	private MenuItem mnu_travelornot;

	@FXML
	void filter_flash_action(ActionEvent event) {
		ArrayList<ArrayList<GETVALUE>> groupval = new ArrayList<>();
		for (int i = 0; i < filtervaluelist.size(); i++) {
			GETVALUE val = null;

			if (filtervaluelist.get(i) instanceof NumberSearchController<?>)
				val = ((NumberSearchController<?>) filtervaluelist.get(i)).getSearchText();
			else if (filtervaluelist.get(i) instanceof DateSearchController<?>)
				val = ((DateSearchController<?>) filtervaluelist.get(i)).getSearchText();
			else
				val = ((TextSearchController<?>) filtervaluelist.get(i)).getSearchText();
			int size = groupval.size();
			int j;
			for (j = 0; j < size; j++) {
				ArrayList<GETVALUE> vals = groupval.get(j);
				if (vals.get(0).getClass().getName().equals(val.getClass().getName())) {
					vals.add(val);
					break;

				}
			}
			if (groupval.size() == 0) {
				ArrayList<GETVALUE> vals = new ArrayList<>();
				vals.add(val);
				groupval.add(vals);
			} else if (j == size) {

				ArrayList<GETVALUE> cvals = new ArrayList<>();
				cvals.add(val);
				groupval.add(cvals);
			}

			/*
			 * if (val.getSearchvalue() instanceof DataRange) { DataRange d =
			 * (DataRange) val.getSearchvalue();
			 * System.out.println(d.getStartRange() + "-" + d.getEndRange()); }
			 * else System.out.println(val.getSearchvalue());
			 */
		}

		emptable.doFilterObject(groupval);
	}

	private MyTableColumn<MyTableRow, Object> reg_date = new MyTableColumn("Date");
	private MyTableColumn<MyTableRow, Object> formno = new MyTableColumn("Form No");
	private MyTableColumn<MyTableRow, Object> name = new MyTableColumn("Name");
	private MyTableColumn<MyTableRow, Object> expected_salary = new MyTableColumn("Expected Salary");
	private MyTableColumn<MyTableRow, Object> joinat = new MyTableColumn("Join At");
	private MyTableColumn<MyTableRow, Object> apply_postcol = new MyTableColumn("Apply Position");

	private MyTableColumn<MyTableRow, Object> age = new MyTableColumn("Age");
	private MyTableColumn<MyTableRow, Object> placeofbirth = new MyTableColumn("Place of Birth");
	private MyTableColumn<MyTableRow, Object> gender = new MyTableColumn("Gender");
	private MyTableColumn<MyTableRow, Object> materialstatus = new MyTableColumn("Material Status");
	private MyTableColumn<MyTableRow, Object> nationality = new MyTableColumn("Nationality");
	private MyTableColumn<MyTableRow, Object> Religion = new MyTableColumn("Religion");
	private MyTableColumn<MyTableRow, Object> nrc = new MyTableColumn("NRC");
	private MyTableColumn<MyTableRow, Object> drivinglic = new MyTableColumn("Driving lic");
	private MyTableColumn<MyTableRow, Object> currentaddress = new MyTableColumn("Current Address");
	private MyTableColumn<MyTableRow, Object> permanentaddress = new MyTableColumn("Permanent Address");
	private MyTableColumn<MyTableRow, Object> phone = new MyTableColumn("Phone Number");
	private MyTableColumn<MyTableRow, Object> Degree = new MyTableColumn("Degree");
	private MyTableColumn<MyTableRow, Object> exp = new MyTableColumn("Experience");
	private MyTableColumn<MyTableRow, Object> Deploma = new MyTableColumn("Deploma");
	private MyTableColumn<MyTableRow, Object> attending_class = new MyTableColumn("Attending_class");
	private MyTableColumn<MyTableRow, Object> activities = new MyTableColumn("Activities");
	private MyTableColumn<MyTableRow, Object> language = new MyTableColumn("language");
	private MyTableColumn<MyTableRow, Object> skill = new MyTableColumn("Skill");
	private MyTableColumn<MyTableRow, Object> interest = new MyTableColumn("Interesting");
	private MyTableColumn<MyTableRow, Object> FatherName = new MyTableColumn("Father Name");
	private MyTableColumn<MyTableRow, Object> FatherJob = new MyTableColumn("Father Job");
	private MyTableColumn<MyTableRow, Object> MotherName = new MyTableColumn("Mother Name");
	private MyTableColumn<MyTableRow, Object> mother_job = new MyTableColumn("Mother Job");
	private MyTableColumn<MyTableRow, Object> overtime = new MyTableColumn("OverTime");
	private MyTableColumn<MyTableRow, Object> workuntail = new MyTableColumn("Work Until");
	private MyTableColumn<MyTableRow, Object> travelornot = new MyTableColumn("Travel or Not");
	private MyTableColumn<MyTableRow, Object> wortkothercities = new MyTableColumn("Work @ Cities");
	private MyTableColumn<MyTableRow, Object> citiesare = new MyTableColumn("Working Cities");
	private MyTableColumn<MyTableRow, Object> bondornot = new MyTableColumn("Bond");
	private MyTableColumn<MyTableRow, Object> bondyr = new MyTableColumn("Bond Year");
	private MyTableColumn<MyTableRow, Object> motorbikeornot = new MyTableColumn("Motorbike");
	private MyTableColumn<MyTableRow, Object> attachment = new MyTableColumn("Attachment");
	private MyTableColumn<MyTableRow, Object> status = new MyTableColumn("Status");

	public void settingtablecolumnarray() {
		columnlist = FXCollections.observableArrayList();
		columnlist.add(reg_date);
		columnlist.add(formno);
		columnlist.add(name);
		columnlist.add(expected_salary);
		columnlist.add(apply_postcol);
		columnlist.add(joinat);
		columnlist.add(age);
		columnlist.add(placeofbirth);
		columnlist.add(gender);
		columnlist.add(materialstatus);
		columnlist.add(nationality);
		columnlist.add(Religion);
		columnlist.add(nrc);
		columnlist.add(drivinglic);
		columnlist.add(currentaddress);
		columnlist.add(permanentaddress);
		columnlist.add(phone);
		columnlist.add(Degree);
		columnlist.add(exp);
		columnlist.add(Deploma);
		columnlist.add(attending_class);
		columnlist.add(activities);
		columnlist.add(language);
		columnlist.add(skill);
		columnlist.add(interest);
		columnlist.add(FatherName);
		columnlist.add(FatherJob);
		columnlist.add(MotherName);
		columnlist.add(mother_job);
		columnlist.add(overtime);
		columnlist.add(workuntail);
		columnlist.add(travelornot);
		columnlist.add(wortkothercities);
		columnlist.add(citiesare);
		columnlist.add(bondornot);
		columnlist.add(bondyr);
		columnlist.add(motorbikeornot);
		columnlist.add(attachment);
		columnlist.add(status);

	}

	private void displayColumns() {

		emptable.getColumns().clear();
		emptable.getColumns().add(selectedcolumn);
		ArrayList<TableColumn> selestedcolumn = new ArrayList();
		for (int i = 0; i < columnlist.size(); i++) {
			if (columnlist.get(i).isSelect()) {
				selestedcolumn.add(columnlist.get(i));
			}
		}

		TableColumn<MyTableRow, Object>[] slectedcolarrray = selestedcolumn
				.toArray(new TableColumn[selestedcolumn.size()]);

		emptable.addColumnAll(slectedcolarrray);

		emptable.refresh();
	}

	private void defaultcolumnsize() {
		reg_date.setPrefWidth(150.0f);
		formno.setPrefWidth(150.0f);
		name.setPrefWidth(150.0f);
		expected_salary.setPrefWidth(150.0f);
		joinat.setPrefWidth(150.0f);
		apply_postcol.setPrefWidth(200.0f);

		age.setPrefWidth(150.0f);
		placeofbirth.setPrefWidth(150.0f);
		gender.setPrefWidth(150.0f);
		materialstatus.setPrefWidth(150.0f);
		nationality.setPrefWidth(150.0f);
		Religion.setPrefWidth(150.0f);
		nrc.setPrefWidth(150.0f);
		drivinglic.setPrefWidth(150.0f);
		currentaddress.setPrefWidth(300.0f);
		permanentaddress.setPrefWidth(300.0f);
		phone.setPrefWidth(150.0f);
		Degree.setPrefWidth(300.0f);
		exp.setPrefWidth(300.0f);
		Deploma.setPrefWidth(300);
		attending_class.setPrefWidth(300.0f);
		activities.setPrefWidth(300.0f);

		language.setPrefWidth(300.0f);
		skill.setPrefWidth(300.0f);
		interest.setPrefWidth(300.0f);
		FatherName.setPrefWidth(150.0f);
		FatherJob.setPrefWidth(150.0f);
		MotherName.setPrefWidth(150.0f);
		mother_job.setPrefWidth(150.0f);
		overtime.setPrefWidth(150.0f);
		workuntail.setPrefWidth(150.0f);
		travelornot.setPrefWidth(150.0f);
		wortkothercities.setPrefWidth(150.0f);
		citiesare.setPrefWidth(150.0f);
		bondornot.setPrefWidth(150.0f);
		bondyr.setPrefWidth(150.0f);
		motorbikeornot.setPrefWidth(150.0f);
		attachment.setPrefWidth(300.0f);
		status.setPrefWidth(300.0f);
	}

	private void setDefaultcolumndisplay() {

		cbname.setSelected(true);
		cbformno.setSelected(true);
		cbregdate.setSelected(true);
		cbapplypost.setSelected(true);
		cbexpecetedsalary.setSelected(true);
		cbage.setSelected(true);
		cbgender.setSelected(true);
		cbmaterialstatus.setSelected(true);
		cbnrc.setSelected(true);
		cbdrivinglic.setSelected(true);
		cbcurrentaddress.setSelected(true);
		cbphonenumber.setSelected(true);
		cbdegree.setSelected(true);
		cbDeploma.setSelected(true);
		cbexperience.setSelected(true);
		ccbskill.setSelected(true);
		cbstatus.setSelected(true);

		columnchangedActtion(new ActionEvent());

	}

	private void createTable() {
		emptable = new MyFXTable<MyTableRow>() {

			@Override
			public void setColumnCommitAction(TableColumn tablecolumn, int row, int column, Object eachrow,
					javafx.scene.control.TableColumn.CellEditEvent<MyTableRow, Object> t) {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean tablefilterText(String lowerCaseFilter, Object TableDataRow) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean tablefilter(String FilterStringlowerCase, Object TableDataRow) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean tablefilterObject(ArrayList filterObject, Object TableDataRow) {
				employeeinterface emp = (employeeinterface) TableDataRow;

				boolean differenttypeboolean = true;
				for (int i = 0; i < filterObject.size(); i++) {
					boolean sametypeboolean = false;
					ArrayList<GETVALUE> vals = (ArrayList<GETVALUE>) filterObject.get(i);
					for (int j = 0; j < vals.size(); j++) {
						GETVALUE val = vals.get(j);
						boolean b = val.checkValue(emp);

						sametypeboolean |= b;

					}
					differenttypeboolean &= sametypeboolean;
				}
				return differenttypeboolean;
			}

			@Override
			public Object CustomCall(TableColumn<MyTableRow, Object> param) {
				if (param.getText().equals("Form No"))
					return new String("hyperlink");
				return new String("textfield");
			}

			@Override
			public void tablerowselectionchangedListener(ObservableValue observable, Object oldValue, Object newValue) {

			}

			@Override
			public void TableCellUpdateItem(Control c, TableCell<MyTableRow, Object> currentcell,
					TableColumn<MyTableRow, Object> param, Object item, boolean empty) {
				if (param.getText().equals("Form No"))
					if (c instanceof Hyperlink) {
						MyTableRow mtr = (MyTableRow) currentcell.getTableRow().getItem();
						if (mtr == null)
							return;
						employeeinterface emp = (employeeinterface) mtr.getEachrow();
						File_Class pic = emp.getProfilepic();
						Object file;
						if (pic.getFile() == null) {
							file = new File("config" + File.separator + "default.png");
						} else {
							file = pic.getFile();
						}

						try {
							((TableHyperlinkCell) currentcell).setImage(pic.readImage(file));
						} catch (IOException e) {
							file = new File("config" + File.separator + "default.png");
							try {
								((TableHyperlinkCell) currentcell).setImage(pic.readImage(file));
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}

						c.setStyle("-fx-text-fill: blue;");

					}
			}

			@Override
			public void ExtendTableCell(Control C, TableCell<MyTableRow, Object> currentcell, Object item) {
				if (C instanceof Hyperlink) {
					Hyperlink b = (Hyperlink) C;
					((TableHyperlinkCell) currentcell).setImageSize(20, 20);
					((TableHyperlinkCell) currentcell).UIincludedHyperlinkWithImage();
					b.setOnMouseEntered(e -> {
						MyTableRow mtr = (MyTableRow) currentcell.getTableRow().getItem();
						if (mtr == null)
							return;
						employeeinterface emp = (employeeinterface) mtr.getEachrow();
						String tooltip="";
						tooltip+="["+emp.getReg_date()+"]"+emp.getFormno();
						tooltip+="\n"+emp.getName()+","+emp.getAge()+","+emp.getGender();
						tooltip+="\n"+emp.getPhonenumber();
						tooltip+="\n============================";
						tooltip+="\nApply Position";
						tooltip+="\n"+emp.getApplypoststring();
						tooltip+="\n============================";

						tooltip+="\nExperiences";
						ArrayList exps=emp.getExp();
						for(int i=0;i<exps.size();i++)
						{
							model.Experience sta=(model.Experience)exps.get(i);
							tooltip+="\n"+sta.getCom_type()+"\t"+sta.getPosition()+"\t"+sta.getExpyear();
						}
						tooltip+="\n============================";
						tooltip+="\nStatus";
						ArrayList status=emp.getStatus();
						for(int i=0;i<status.size();i++)
						{
							model.Status sta=(Status)status.get(i);
							tooltip+="\n"+"["+sta.getDate()+"]"+" "+sta.getStatus();
						}
						b.setTooltip(new Tooltip(tooltip));
					});

				}

			}

			@Override
			public void IndexcomboboxSelectionAction(CheckBox C, TableColumn<MyTableRow, Object> param, int RowIndex) {
				// TODO Auto-generated method stub

			}

			@Override
			public void select_all_ExtendOnAction(CheckBox Select_All, ActionEvent event) {
				// TODO Auto-generated method stub

			}

		};
		emptable.setOnMousePressed(e -> {
			if (e.isPrimaryButtonDown() && e.getClickCount() == 2) {
				if (emptable.getSelectionModel().getSelectedItem() == null)
					return;
				MyTableRow currentrow = (MyTableRow) emptable.getSelectionModel().getSelectedItem();
				employeeinterface eif = (employeeinterface) currentrow.getEachrow();
				System.out.println(eif.getName());
			}
		});
		emptable.setCustomcellvalueFactory((TableColumn) name, "name", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) formno, "formno", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) expected_salary, "expected_salary", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) reg_date, "reg_date", LocalDate.class);
		emptable.setCustomcellvalueFactory((TableColumn) joinat, "joinat", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) apply_postcol, "applypoststring", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) age, "age", Integer.class);
		emptable.setCustomcellvalueFactory((TableColumn) placeofbirth, "placeofbirth", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) gender, "gender", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) materialstatus, "materialstatus", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) nationality, "nationality", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) Religion, "religion", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) nrc, "nrc", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) drivinglic, "drivinglic", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) currentaddress, "currentaddress", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) permanentaddress, "permanentaddress", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) phone, "phonenumber", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) Degree, "degreeliststring", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) exp, "expliststring", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) Deploma, "deplomaliststring", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) attending_class, "attendingclasslisttring", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) activities, "activitesliststring", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) language, "langaugeliststring", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) skill, "skillliststring", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) interest, "intestringliststring", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) FatherName, "family_history.fathername", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) FatherJob, "family_history.father_job", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) MotherName, "family_history.mothername", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) mother_job, "family_history.mother_job", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) overtime, "concernworkfact.overtime", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) workuntail, "concernworkfact.workuntail", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) travelornot, "concernworkfact.travelornot", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) wortkothercities, "concernworkfact.wortkothercities",
				String.class);
		emptable.setCustomcellvalueFactory((TableColumn) citiesare, "concernworkfact.citiesare", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) bondornot, "concernworkfact.bondornot", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) bondyr, "concernworkfact.bondyr", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) motorbikeornot, "concernworkfact.motorbikeornot",
				String.class);
		emptable.setCustomcellvalueFactory((TableColumn) attachment, "attachmentliststring", String.class);
		emptable.setCustomcellvalueFactory((TableColumn) status, "statusliststring", String.class);
		emptable.setFilterType(MyFXTable.Object_Filter);
		ObservableList items = emptable.getTableData();
		try {
			items.addAll(index.dbstatement.get_loadEmployeedata());
		} catch (MalformedURLException e1) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("File Access Error");
			alert.setContentText(e1.getMessage());
			alert.showAndWait();
		} catch (URISyntaxException e1) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("File Access Error");
			alert.setContentText(e1.getMessage());
			alert.showAndWait();
		}
		selectedcolumn = emptable.getColumn_selected();
		selectedcolumn.setPrefWidth(100.0f);

	}

	@FXML
	void initialize() {
		filtervaluelist = new ArrayList();
		settingtablecolumnarray();
		createTable();
		emptable.setStyle("-fx-font-family: \"Zawgyi-One\"; ");

		defaultcolumnsize();
		AnchorPane.setTopAnchor(emptable, 0.0);
		AnchorPane.setBottomAnchor(emptable, 0.0);
		AnchorPane.setRightAnchor(emptable, 0.0);
		AnchorPane.setLeftAnchor(emptable, 0.0);
		emptable.setEditable(false);
		setDefaultcolumndisplay();
		emptablepane.getChildren().add(emptable);
		filtervbox.heightProperty().addListener(observable -> filterscroll.setVvalue(1D));

	}

	@FXML
	void columnchangedActtion(ActionEvent event) {
		doselectcheckboxandTableColumn(cbregdate, reg_date);
		doselectcheckboxandTableColumn(cbformno, formno);
		doselectcheckboxandTableColumn(cbname, name);
		doselectcheckboxandTableColumn(cbexpecetedsalary, expected_salary);
		doselectcheckboxandTableColumn(cbapplypost, apply_postcol);
		doselectcheckboxandTableColumn(cbjointat, joinat);
		doselectcheckboxandTableColumn(cbage, age);
		doselectcheckboxandTableColumn(cbplaceofbirth, placeofbirth);
		doselectcheckboxandTableColumn(cbgender, gender);
		doselectcheckboxandTableColumn(cbmaterialstatus, materialstatus);
		doselectcheckboxandTableColumn(cbnationality, nationality);
		doselectcheckboxandTableColumn(cbreligion, Religion);
		doselectcheckboxandTableColumn(cbnrc, nrc);
		doselectcheckboxandTableColumn(cbdrivinglic, drivinglic);
		doselectcheckboxandTableColumn(cbcurrentaddress, currentaddress);
		doselectcheckboxandTableColumn(cbpermanentaddress, permanentaddress);
		doselectcheckboxandTableColumn(cbphonenumber, phone);
		doselectcheckboxandTableColumn(cbdegree, Degree);
		doselectcheckboxandTableColumn(cbDeploma, Deploma);
		doselectcheckboxandTableColumn(cbattending_class, attending_class);
		doselectcheckboxandTableColumn(cbexperience, exp);
		doselectcheckboxandTableColumn(ccbskill, skill);
		doselectcheckboxandTableColumn(cblangauge, language);
		doselectcheckboxandTableColumn(cbinteresting, interest);
		doselectcheckboxandTableColumn(cbActivities, activities);
		doselectcheckboxandTableColumn(cbfathername, FatherName);
		doselectcheckboxandTableColumn(cbFatherJob, FatherJob);
		doselectcheckboxandTableColumn(cbbmotherName, MotherName);
		doselectcheckboxandTableColumn(cbmotherjob, mother_job);
		doselectcheckboxandTableColumn(cbovetime, overtime);
		doselectcheckboxandTableColumn(cbworkuntil, workuntail);
		doselectcheckboxandTableColumn(cbtravelornot, travelornot);
		doselectcheckboxandTableColumn(cbworkcities, wortkothercities);
		doselectcheckboxandTableColumn(cbworkcitiesare, citiesare);
		doselectcheckboxandTableColumn(cbbond, bondornot);
		doselectcheckboxandTableColumn(cbbondyear, bondyr);
		doselectcheckboxandTableColumn(cbmotorbike, motorbikeornot);
		doselectcheckboxandTableColumn(cbattachment, attachment);
		doselectcheckboxandTableColumn(cbstatus, status);
		displayColumns();

	}

	@FXML
	void mnu_formno_action(ActionEvent event) throws IOException {
		_FormNo formno = new _FormNo();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ghg/index/textSearch.fxml"));

		TextSearchController textsearch = new TextSearchController<_FormNo>();
		loader.setController(textsearch);
		Parent p = loader.load();
		filtervaluelist.add(textsearch);
		filtervbox.getChildren().add(p);
		textsearch.settingTextSearchController(filtervbox, formno, "Form No", "xxxxxxxxxxxxxxx");
	}

	@FXML
	void mnu_formdate_action(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ghg/index/DateSearch.fxml"));
		DateSearchController datesearch = new DateSearchController<_FormDate>();
		loader.setController(datesearch);
		Parent p = loader.load();
		_FormDate formdate = new _FormDate();
		filtervaluelist.add(datesearch);
		filtervbox.getChildren().add(p);
		datesearch.settingDateSearchController(filtervbox, formdate, " Form's Registeration Date ",
				LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 1), LocalDate.now());

	}

	@FXML
	void mnu_age_action(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ghg/index/NumberSearch.fxml"));
		NumberSearchController numbersearch = new NumberSearchController<_Age>();
		loader.setController(numbersearch);
		Parent p = loader.load();
		_Age age = new _Age();
		filtervaluelist.add(numbersearch);
		filtervbox.getChildren().add(p);
		numbersearch.settingNumberSearchController(filtervbox, age, " Age", 18, 30);
	}

	@FXML
	private MenuItem mnu_formdate;

	@FXML
	void mnu_address_action(ActionEvent event) throws IOException {

		_Address address = new _Address();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ghg/index/textSearch.fxml"));

		TextSearchController textsearch = new TextSearchController<_FormNo>();
		loader.setController(textsearch);
		Parent p = loader.load();
		filtervaluelist.add(textsearch);
		filtervbox.getChildren().add(p);
		textsearch.settingTextSearchController(filtervbox, address, "Address", "xxxxxxxxxxxxxxx");

	}

	@FXML
	void mnu_applypost_action(ActionEvent event) throws IOException {

		_Applypost applypost = new _Applypost();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ghg/index/textSearch.fxml"));

		TextSearchController textsearch = new TextSearchController<_Applypost>();
		loader.setController(textsearch);
		Parent p = loader.load();
		filtervaluelist.add(textsearch);
		filtervbox.getChildren().add(p);
		textsearch.settingTextSearchController(filtervbox, applypost, "Apply Post", "xxxxxxxxxxxxxxx");

	}

	@FXML
	void mnu_certificate_action(ActionEvent event) throws IOException {

		_Cetificate certificate = new _Cetificate();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ghg/index/textSearch.fxml"));
		TextSearchController textsearch = new TextSearchController<_Cetificate>();
		loader.setController(textsearch);
		Parent p = loader.load();
		filtervaluelist.add(textsearch);
		filtervbox.getChildren().add(p);
		textsearch.settingTextSearchController(filtervbox, certificate, "Cetificate", "xxxxxxxxxxxxxxx");

	}

	@FXML
	void mnu_comname_action(ActionEvent event) throws IOException {

		_ComName comname = new _ComName();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ghg/index/textSearch.fxml"));
		TextSearchController textsearch = new TextSearchController<_ComName>();
		loader.setController(textsearch);
		Parent p = loader.load();
		filtervaluelist.add(textsearch);
		filtervbox.getChildren().add(p);
		textsearch.settingTextSearchController(filtervbox, comname, "Company Name", "xxxxxxxxxxxxxxx");

	}

	@FXML
	void mnu_company_position_action(ActionEvent event) throws IOException {

		_Compost company_position = new _Compost();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ghg/index/textSearch.fxml"));
		TextSearchController textsearch = new TextSearchController<_Compost>();
		loader.setController(textsearch);
		Parent p = loader.load();
		filtervaluelist.add(textsearch);
		filtervbox.getChildren().add(p);
		textsearch.settingTextSearchController(filtervbox, company_position, "Position Act as", "xxxxxxxxxxxxxxx");

	}

	@FXML
	void mnu_company_type_action(ActionEvent event) throws IOException {

		_Comtype company_type = new _Comtype();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ghg/index/textSearch.fxml"));
		TextSearchController textsearch = new TextSearchController<_Comtype>();
		loader.setController(textsearch);
		Parent p = loader.load();
		filtervaluelist.add(textsearch);
		filtervbox.getChildren().add(p);
		textsearch.settingTextSearchController(filtervbox, company_type, "Company's Type", "xxxxxxxxxxxxxxx");

	}

	@FXML
	void mnu_degree_action(ActionEvent event) throws IOException {

		_Degree degree = new _Degree();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ghg/index/textSearch.fxml"));
		TextSearchController textsearch = new TextSearchController<_Degree>();
		loader.setController(textsearch);
		Parent p = loader.load();
		filtervaluelist.add(textsearch);
		filtervbox.getChildren().add(p);
		textsearch.settingTextSearchController(filtervbox, degree, "Degree", "xxxxxxxxxxxxxxx");

	}

	@FXML
	void mnu_deploma_action(ActionEvent event) throws IOException {

		_Deploma deploma = new _Deploma();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ghg/index/textSearch.fxml"));
		TextSearchController textsearch = new TextSearchController<_Deploma>();
		loader.setController(textsearch);
		Parent p = loader.load();
		filtervaluelist.add(textsearch);
		filtervbox.getChildren().add(p);
		textsearch.settingTextSearchController(filtervbox, deploma, "Deploma", "xxxxxxxxxxxxxxx");

	}

	@FXML
	void mnu_expyear_action(ActionEvent event) throws IOException {
		_Expyr expyear = new _Expyr();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ghg/index/NumberSearch.fxml"));

		NumberSearchController numbersearch = new NumberSearchController<_Expyr>();
		loader.setController(numbersearch);
		Parent p = loader.load();
		_Age age = new _Age();
		filtervaluelist.add(numbersearch);
		filtervbox.getChildren().add(p);
		numbersearch.settingNumberSearchController(filtervbox, expyear, " Experience Years of the Post", 0, 0);

	}

	@FXML
	private MenuItem mnu_workingexp;

	@FXML
	void mnu_workingexp_action(ActionEvent event) throws IOException {
		_WorkingExp expyear = new _WorkingExp();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ghg/index/NumberSearch.fxml"));

		NumberSearchController numbersearch = new NumberSearchController<_WorkingExp>();
		loader.setController(numbersearch);
		Parent p = loader.load();
		_Age age = new _Age();
		filtervaluelist.add(numbersearch);
		filtervbox.getChildren().add(p);
		numbersearch.settingNumberSearchController(filtervbox, expyear, "Total Working Experience Years", 0, 0);

	}

	@FXML
	void mnu_fatherjob_action(ActionEvent event) throws IOException {

		_Fatherjob fatherjob = new _Fatherjob();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ghg/index/textSearch.fxml"));
		TextSearchController textsearch = new TextSearchController<_Fatherjob>();
		loader.setController(textsearch);
		Parent p = loader.load();
		filtervaluelist.add(textsearch);
		filtervbox.getChildren().add(p);
		textsearch.settingTextSearchController(filtervbox, fatherjob, "Father's Job", "xxxxxxxxxxxxxxx");

	}

	@FXML
	void mnu_fathername_action(ActionEvent event) throws IOException {

		_Fathername fathername = new _Fathername();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ghg/index/textSearch.fxml"));
		TextSearchController textsearch = new TextSearchController<_Fathername>();
		loader.setController(textsearch);
		Parent p = loader.load();
		filtervaluelist.add(textsearch);
		filtervbox.getChildren().add(p);
		textsearch.settingTextSearchController(filtervbox, fathername, "Father Name", "xxxxxxxxxxxxxxx");

	}

	@FXML
	void mnu_field_action(ActionEvent event) throws IOException {

		_Field field = new _Field();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ghg/index/textSearch.fxml"));
		TextSearchController textsearch = new TextSearchController<_Field>();
		loader.setController(textsearch);
		Parent p = loader.load();
		filtervaluelist.add(textsearch);
		filtervbox.getChildren().add(p);
		textsearch.settingTextSearchController(filtervbox, field, "Field", "xxxxxxxxxxxxxxx");

	}

	@FXML
	void mnu_fmotherjob_action(ActionEvent event) throws IOException {

		_MotherJob motherJob = new _MotherJob();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ghg/index/textSearch.fxml"));
		TextSearchController textsearch = new TextSearchController<_MotherJob>();
		loader.setController(textsearch);
		Parent p = loader.load();
		filtervaluelist.add(textsearch);
		filtervbox.getChildren().add(p);
		textsearch.settingTextSearchController(filtervbox, motherJob, "Mother's Job", "xxxxxxxxxxxxxxx");

	}

	@FXML
	void mnu_gender_action(ActionEvent event) throws IOException {

		_Gender gender = new _Gender();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ghg/index/textSearch.fxml"));
		TextSearchController textsearch = new TextSearchController<_Gender>();
		loader.setController(textsearch);
		Parent p = loader.load();
		filtervaluelist.add(textsearch);
		filtervbox.getChildren().add(p);
		textsearch.settingTextSearchController(filtervbox, gender, "Gender", "xxxxxxxxxxxxxxx");

	}

	@FXML
	void mnu_mnu_havemotorbike_action(ActionEvent event) throws IOException {
		_HavMotorbike havemotorbike = new _HavMotorbike();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ghg/index/textSearch.fxml"));
		TextSearchController textsearch = new TextSearchController<_HavMotorbike>();
		loader.setController(textsearch);
		Parent p = loader.load();
		filtervaluelist.add(textsearch);
		filtervbox.getChildren().add(p);
		textsearch.settingTextSearchController(filtervbox, havemotorbike, "Have Motor Bike", "xxxxxxxxxxxxxxx");

	}

	@FXML
	void mnu_mothername_action(ActionEvent event) throws IOException {

		_MotherName mothername = new _MotherName();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ghg/index/textSearch.fxml"));
		TextSearchController textsearch = new TextSearchController<_MotherName>();
		loader.setController(textsearch);
		Parent p = loader.load();
		filtervaluelist.add(textsearch);
		filtervbox.getChildren().add(p);
		textsearch.settingTextSearchController(filtervbox, mothername, "Mother Name", "xxxxxxxxxxxxxxx");

	}

	@FXML
	void mnu_name_action(ActionEvent event) throws IOException {
		_Name name = new _Name();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ghg/index/textSearch.fxml"));
		TextSearchController textsearch = new TextSearchController<_Name>();
		loader.setController(textsearch);
		Parent p = loader.load();
		filtervaluelist.add(textsearch);
		filtervbox.getChildren().add(p);
		textsearch.settingTextSearchController(filtervbox, name, "Applicant's Name", "xxxxxxxxxxxxxxx");

	}

	@FXML
	void mnu_nrc_action(ActionEvent event) throws IOException {

		_NRC nrc = new _NRC();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ghg/index/textSearch.fxml"));
		TextSearchController textsearch = new TextSearchController<_NRC>();
		loader.setController(textsearch);
		Parent p = loader.load();
		filtervaluelist.add(textsearch);
		filtervbox.getChildren().add(p);
		textsearch.settingTextSearchController(filtervbox, nrc, "Applicant's NRC", "xxxxxxxxxxxxxxx");

	}

	@FXML
	void mnu_nstitude_action(ActionEvent event) throws IOException {

		_Institude institude = new _Institude();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ghg/index/textSearch.fxml"));
		TextSearchController textsearch = new TextSearchController<_Institude>();
		loader.setController(textsearch);
		Parent p = loader.load();
		filtervaluelist.add(textsearch);
		filtervbox.getChildren().add(p);
		textsearch.settingTextSearchController(filtervbox, institude, "Institute", "xxxxxxxxxxxxxxx");
	}

	@FXML
	void mnu_ph_action(ActionEvent event) throws IOException {

		_Ph ph = new _Ph();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ghg/index/textSearch.fxml"));
		TextSearchController textsearch = new TextSearchController<_Ph>();
		loader.setController(textsearch);
		Parent p = loader.load();
		filtervaluelist.add(textsearch);
		filtervbox.getChildren().add(p);
		textsearch.settingTextSearchController(filtervbox, ph, "Applicant's Phone Number", "xxxxxxxxxxxxxxx");
	}

	@FXML
	private MenuItem mnu_status;

	@FXML
	void mnu_status_action(ActionEvent event) throws IOException {
		_Status status = new _Status();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ghg/index/textSearch.fxml"));
		TextSearchController textsearch = new TextSearchController<_Ph>();
		loader.setController(textsearch);
		Parent p = loader.load();
		filtervaluelist.add(textsearch);
		filtervbox.getChildren().add(p);
		textsearch.settingTextSearchController(filtervbox, status, "Applicant Status", "xxxxxxxxxxxxxxx");
	}

	@FXML
	void mnu_travelornot_action(ActionEvent event) throws IOException {
		_TravelorNot travelornot = new _TravelorNot();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ghg/index/textSearch.fxml"));
		TextSearchController textsearch = new TextSearchController<_TravelorNot>();
		loader.setController(textsearch);
		Parent p = loader.load();
		filtervaluelist.add(textsearch);
		filtervbox.getChildren().add(p);
		textsearch.settingTextSearchController(filtervbox, travelornot, "Can Travel or Not", "xxxxxxxxxxxxxxx");

	}

	@FXML
	private MenuItem mnu_Interesting;

	@FXML
	void mnu_Interesting_action(ActionEvent event) throws IOException {
		_Interesting interesting = new _Interesting();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ghg/index/textSearch.fxml"));
		TextSearchController textsearch = new TextSearchController<_Interesting>();
		loader.setController(textsearch);
		Parent p = loader.load();
		filtervaluelist.add(textsearch);
		filtervbox.getChildren().add(p);
		textsearch.settingTextSearchController(filtervbox, interesting, "Intersting in ", "xxxxxxxxxxxxxxx");

	}

	@FXML
	private MenuItem mnu_activities;

	@FXML
	void mnu_activities_action(ActionEvent event) throws IOException {
		_Activities act = new _Activities();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ghg/index/textSearch.fxml"));
		TextSearchController textsearch = new TextSearchController<_Activities>();
		loader.setController(textsearch);
		Parent p = loader.load();
		filtervaluelist.add(textsearch);
		filtervbox.getChildren().add(p);
		textsearch.settingTextSearchController(filtervbox, act, "Activites ", "xxxxxxxxxxxxxxx");

	}

	@FXML
	private MenuItem mnu_actas;

	@FXML
	void mnu_atctas_action(ActionEvent event) throws IOException {
		_Actas act = new _Actas();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ghg/index/textSearch.fxml"));
		TextSearchController textsearch = new TextSearchController<_Actas>();
		loader.setController(textsearch);
		Parent p = loader.load();
		filtervaluelist.add(textsearch);
		filtervbox.getChildren().add(p);
		textsearch.settingTextSearchController(filtervbox, act, " Doing Activites Act as ", "xxxxxxxxxxxxxxx");
	}

	@FXML
	private MenuItem mnu_language;

	@FXML
	void mnu_language_action(ActionEvent event) throws IOException {
		_Langauge lan = new _Langauge();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ghg/index/textSearch.fxml"));
		TextSearchController textsearch = new TextSearchController<_Langauge>();
		loader.setController(textsearch);
		Parent p = loader.load();
		filtervaluelist.add(textsearch);
		filtervbox.getChildren().add(p);
		textsearch.settingTextSearchController(filtervbox, lan, " Do Well in Language ", "xxxxxxxxxxxxxxx");

	}

	@FXML
	private Button new_emplyee;

	@FXML
	void new_emplyee_action(ActionEvent event) {

	}

	private void doselectcheckboxandTableColumn(CheckBox c, MyTableColumn tc) {
		if (c.isSelected())
			tc.setSelect(true);
		else
			tc.setSelect(false);
	}
}

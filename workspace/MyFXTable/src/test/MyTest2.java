package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import CustomTableFx.MyFXTable;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.SelectionRow.MyTableRow;
import model.TableCell.TableHyperlinkCell;
import test.model.Vou;

public class MyTest2 extends Application{
	MyFXTable<MyTableRow> mytable;
	public static void main(String[] args) {
	Application.launch(args);
		
	}

	public void start(Stage primaryStage)  {
		initTable(primaryStage);
		primaryStage.show();
	}
	public  void initTable(Stage stage)  {
		mytable=new MyFXTable<MyTableRow>() {
			
			@Override
			public void tablerowselectionchangedListener(ObservableValue observable, Object oldValue, Object newValue) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean tablefilter(String FilterStringlowerCase, Object TableDataObject) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void setColumnCommitAction(TableColumn tc,int row, int column, Object eachrow, CellEditEvent<MyTableRow, Object> t) {
			
				if(column==1)
					((Employee_Table_Interface_Object)eachrow).getEmployee().setEmployeeid(t.getNewValue().toString());
				else if(column==2)
					((Employee_Table_Interface_Object)eachrow).getEmployee().setName(t.getNewValue().toString());
				else if(column==3)
					{ try{
						((Employee_Table_Interface_Object)eachrow).getEmployee().setSalary(Integer.parseInt(t.getNewValue().toString()));
					   }catch(Exception ex)
						{
							((Employee_Table_Interface_Object)eachrow).getEmployee().setSalary(0);
						}
					}
				else if(column==4)
				{
					((Employee_Table_Interface_Object)eachrow).getEmployee().setSelected_position(t.getNewValue().toString());
					
				}
				else if(column==5)
				{
					((Employee_Table_Interface_Object)eachrow).getEmployee().setStartdate((LocalDate)t.getNewValue());
				}
				else if(column==6)
				{
					((Employee_Table_Interface_Object)eachrow).setView_detail(t.getNewValue().toString());
				}
				mytable.refresh();
			}
			
			@Override
			public void select_all_ExtendOnAction(CheckBox Select_All, ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void TableCellUpdateItem(Control c, TableCell<MyTableRow, Object> currentcell,
					TableColumn<MyTableRow, Object> param, Object item, boolean empty) {
				if(param.getText().equals("EmployeeId"))
				{	
					if(c instanceof Hyperlink)
					{
						if(((Hyperlink) c).getText().equals("001"))
						{ 
							File f=new File("/Users/nyannaingtun/Documents/workspace/MyFXTable/src/test/hello.jpg");
							try {
								((TableHyperlinkCell)currentcell).setImage(new FileInputStream(f));
							} catch (FileNotFoundException e) {
																		e.printStackTrace();
							}
						
					
						}
					}
				}
				
			}
			
			@Override
			public void IndexcomboboxSelectionAction(CheckBox C, TableColumn<MyTableRow, Object> param, int RowIndex) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void ExtendTableCell(Control C, TableCell<MyTableRow, Object> currentcell,
					 Object item) {
				if(C instanceof Button)
				{
					((Button)C).setOnAction(e->{
						//System.out.println(currentcell.getTableColumn().getText());
						Employee_Table_Interface_Object v=(Employee_Table_Interface_Object)((MyTableRow)this.getTableData().get(currentcell.getTableRow().getIndex())).getEachrow();
						Employee ee=v.getEmployee();
						System.out.println(ee.getEmployeeid());
						System.out.println(ee.getName());
						System.out.println(ee.getSalary());
						System.out.println(ee.getStartdate());
						System.out.println(ee.getSelected_position());
					});
				}
				
				if(C instanceof Hyperlink)
				{
					Hyperlink b=(Hyperlink)C;
					((TableHyperlinkCell)currentcell).setImageSize(20, 20);
					((TableHyperlinkCell)currentcell).UIincludedHyperlinkWithImage();
			
				}
				if(C instanceof TextField)
				{
					((TextField)C).setOnKeyPressed(value->{
					
						if(value.getCode()==KeyCode.ENTER)
						{
						//	 currentcell.getTableView().getSelectionModel().selectRightCell();
							// value.consume();						
							currentcell.commitEdit(((TextField)C).getText());
								
						}
					});
				}	
			}
			
			@Override
			public Object CustomCall(TableColumn<MyTableRow, Object> param) {

				
				if(param.getText().equals("EmployeeId"))
						return new String("hyperlink");
				else if(param.getText().equals("Name"))
					return new String("textfield");
				else if(param.getText().equals("Salary"))
					return new String("textfield");
				else if(param.getText().equals("Position"))
					return new String("combobox_employee.selected_position");
				else if(param.getText().equals("Start Date"))
					return new String("datepicker");
				else if(param.getText().equals("View Detail"))
					return new String("button");
				return null;
			}

			@Override
			public boolean tablefilterText(String lowerCaseFilter, Object eachrow) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean tablefilterObject(ArrayList filterObject, Object eachrow) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	
		
		TableColumn<MyTableRow, Object> column_id = new TableColumn("EmployeeId");

		TableColumn<MyTableRow, Object> column_name = new TableColumn("Name");
		TableColumn<MyTableRow, Object> column_Salary = new TableColumn("Salary");
		TableColumn<MyTableRow, Object> column_JobTitle = new TableColumn("Position");
		TableColumn<MyTableRow, Object> column_Startdate = new TableColumn("Start Date");
		TableColumn<MyTableRow, Object> column_ViewDetail = new TableColumn("View Detail");
		
		mytable.setCustomcellvalueFactory(column_id, "employee.employeeid", String.class);
		mytable.setCustomcellvalueFactory(column_name, "employee.name", String.class);
		mytable.setCustomcellvalueFactory(column_Salary, "employee.salary", Integer.class);
		mytable.setCustomcellvalueFactory(column_Startdate, "employee.startdate", LocalDate.class);
		mytable.setCustomcellvalueFactory(column_JobTitle, "employee.position", ArrayList.class);
		mytable.setCustomcellvalueFactory(column_ViewDetail, "view_detail", String.class);
		mytable.getSelectionModel().setCellSelectionEnabled(true);
	
		mytable.addColumnAll(column_id,column_name,column_Salary,column_JobTitle,column_Startdate,column_ViewDetail);
		mytable.setEditable(true);
		ObservableList<MyTableRow> myObservableList= mytable.getTableData();

		BorderPane bp=new BorderPane();
		Button btn=new Button("click");
		btn.setOnAction(e->{
			ObservableList<MyTableRow> items= mytable.getTableData();
			Employee_Table_Interface_Object cur=new Employee_Table_Interface_Object();
			cur.setView_detail("View>>");
			Employee emp=new Employee();
			emp.setName("");
			emp.setEmployeeid("323322");
			
			emp.setStartdate(LocalDate.now());
			ArrayList<String> pos=new ArrayList();
			pos.add("Low Level");
			pos.add("Middle Level");
			pos.add("High Level");
			emp.setPosition(pos);
			emp.setSelected_position(pos.get(2));
			cur.setEmployee(emp);
			items.add(new MyTableRow(cur));
			Employee_Table_Interface_Object cur2=new Employee_Table_Interface_Object();
			
			cur2.setView_detail("View>>");
			Employee emp2=new Employee();
			emp2.setName("");
			emp2.setEmployeeid("323322");
			
			emp2.setStartdate(LocalDate.now());
			ArrayList<String> pos2=new ArrayList();
			pos2.add("Rich");
			pos2.add("Poor");
			emp2.setPosition(pos2);
			emp2.setSelected_position(pos2.get(0));
			cur2.setEmployee(emp2);
			items.add(new MyTableRow(cur2));
			mytable.refresh();
		});
	
	
	    bp.setCenter(mytable);
		bp.setBottom(mytable.getSearchField());
		bp.setTop(btn);
		Scene scene = new Scene(bp);
		stage.setScene(scene);
		
		
		
}

}

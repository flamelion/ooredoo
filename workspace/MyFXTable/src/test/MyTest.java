package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


import CustomTableFx.MyFXTable;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableRow;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import model.SelectionRow.ComplexObjectCellValueFactory;
import model.SelectionRow.MyTableRow;
import model.TableCell.TableHyperlinkCell;
import test.model.Vou;

public class MyTest extends Application {
	private MyFXTable mytable;
	private int i=0;
	TableColumn<MyTableRow, Object> column_name ;
	TableColumn<MyTableRow, Object> column_quantity;
	TableColumn<MyTableRow, Object> column_price;
	TableColumn<MyTableRow, Object> column_combo ;
	TableColumn<MyTableRow, Object> column_date ;
	TableColumn<MyTableRow, Object> column_hyperlink;
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
				public boolean tablefilter(String FilterStringlowerCase, Object TableDataObject) {	
			
					
					if (( (Vou)TableDataObject).getName().toLowerCase().indexOf(FilterStringlowerCase) != -1) 
						return true; 
					if(new String( ( (Vou)TableDataObject).getVolume()+"").contains(FilterStringlowerCase))
							return true;
					if(new String( ( (Vou)TableDataObject).getSelected_selection()+"").contains(FilterStringlowerCase))
						{
						  return true;
						}
					
					DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		        	       			
					
					if(  dateTimeFormatter.format((LocalDate)((Vou)TableDataObject).getTime()).contains(FilterStringlowerCase))
					{
					  return true;
					}
					
					return false;
				}

				@Override
				public Object CustomCall(TableColumn<MyTableRow, Object> param) {
					if(param.getText().equals("Name"))
								return new String("textfield");
						else if(param.getText().equals("Quantity"))
							return new String("textfield");
						else if(param.getText().equals("Price"))
							return new String("button");
						else if(param.getText().equals("Price"))
							return new String("button");
						else if(param.getText().equals("Selection"))
							return new String("combobox_selected_selection");
						else if(param.getText().equals("Date"))
							return new String("datepicker");
						else if(param.getText().equals("Hyperlink"))
							return new String("hyperlink");
						return null;
						
				}

			
				@Override
				public void setColumnCommitAction(TableColumn tc,int row, int column, Object eachrow, CellEditEvent<MyTableRow, Object> t)
				{
					
				
					
				if(tc.getText().equals("Name"))
						((Vou)eachrow).setName(t.getNewValue().toString());
				else if(tc.getText().equals("Quantity"))
						((Vou)eachrow).setVolume(Integer.parseInt(t.getNewValue().toString()));
				else if(tc.getText().equals("Price"))
						((Vou)eachrow).setAveragePrice(Double.parseDouble(t.getNewValue().toString()));
				else if(tc.getText().equals("Selection"))
					{
						((Vou)eachrow).setSelected_selection(t.getNewValue().toString());
					}
				else if(tc.getText().equals("Date"))
					{
						((Vou)eachrow).setTime((LocalDate)t.getNewValue());
					}
				else if(tc.getText().equals("Hyperlink"))
					{
						((Vou)eachrow).setHyperlinktest(t.getNewValue().toString());
					}
					
				}

				@Override
				public void tablerowselectionchangedListener(ObservableValue observable, Object oldValue,
						Object newValue) {
					// TODO Auto-generated method stub
					
				}

	

				@Override
				public void IndexcomboboxSelectionAction(CheckBox C, TableColumn<MyTableRow, Object> param,
						int RowIndex) {
						if(C.isSelected())
						{
							Vou v=(Vou)((MyTableRow)mytable.getTableData().get(RowIndex)).getEachrow();
							System.out.println(v.getName());
						
						}
					
				}

				@Override
				public void select_all_ExtendOnAction(CheckBox SelectAll,ActionEvent event) {
					if(SelectAll.isSelected())
						System.out.println("All Items are selected");
					
				}

				@Override
				public void TableCellUpdateItem(Control c, TableCell<MyTableRow, Object> currentcell,
						TableColumn<MyTableRow, Object> param, Object item, boolean empty) {
						if(param.getText().equals("Name"))
						if(c instanceof TextField)
						{
							if(!currentcell.isEditing()&& ((String)item).equals("Pork"))
							{
							
								ImageView imageview = new ImageView();
			                    imageview.setFitHeight(50);
			                    imageview.setFitWidth(50);
			                    File f=new File("/Users/nyannaingtun/Documents/workspace/MyFXTable/src/test/hello.jpg");
			                    try {
									imageview.setImage(new Image(new FileInputStream(f)));
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								currentcell.setGraphic(imageview);
							
							}
						}
						
						if(param.getText().equals("Hyperlink"))
							if(c instanceof Hyperlink)
							{
							
								if(((Hyperlink) c).getText().equals("hello"))
								{ 
									File f=new File("/Users/nyannaingtun/Documents/workspace/MyFXTable/src/test/hello.jpg");
									try {
										((TableHyperlinkCell)currentcell).setImage(new FileInputStream(f));
									} catch (FileNotFoundException e) {
																				e.printStackTrace();
									}
									c.setStyle("-fx-text-fill: red;");
							
								}
							}
					
				}

				@Override
				public void ExtendTableCell(Control C, TableCell<MyTableRow, Object> currentcell,
						 Object item) {
					if(C instanceof TextField)
					{	
				
						TextField tf=(TextField)C;
						tf.setOnKeyTyped(e->{
							System.out.println("type");
						});
					}
					if(C instanceof Button)
					{
						Button b=(Button)C;
				
						b.addEventHandler(MouseEvent.MOUSE_CLICKED,  e->{
							
							System.out.println();
						});
						
					}
					if(C instanceof DatePicker)
					{
						DatePicker b=(DatePicker)C;
						b.valueProperty().addListener(c->{
							System.out.println("date change");
						});
					}
					if(C instanceof ComboBox)
					{
						ComboBox b=(ComboBox)C;
						b.valueProperty().addListener(c->{
							System.out.println("combo change");
						});
					}
					if(C instanceof Hyperlink)
					{
						Hyperlink b=(Hyperlink)C;
						((TableHyperlinkCell)currentcell).setImageSize(20, 20);
						((TableHyperlinkCell)currentcell).UIincludedHyperlinkWithImage();
						//((TableHyperlinkCell)currentcell).UIincludedHyperlinkWithoutImage();
						b.setOnAction(e->{
							Vou v=(Vou)((MyTableRow)this.getTableData().get(currentcell.getTableRow().getIndex())).getEachrow();
							System.out.println(v.getName());
						});
					}
				
					if(C instanceof CheckBox)
					{	       //IndexCheckbox
								CheckBox b=(CheckBox)C;
								/*(b.addEventHandler(MouseEvent.MOUSE_CLICKED,e->{
								if(b.isSelected())
								{	
									TablePosition tc = mytable.getFocusModel().getFocusedCell();
									
									Vou v=(Vou)((MyTableRow)mytable.getTableData().get(tc.getRow())).getEachrow();
									System.out.println(v.getName());
									
								}
								else
								{
									System.out.println("hello2");
								}
							});*/
						
						
						
					}
					
				}

				@Override
				public boolean tablefilterText(String lowerCaseFilter, Object eachrow) {
				
					if (( (Vou)eachrow).getName().toLowerCase().indexOf(lowerCaseFilter) != -1) 
						return true; 
					return false;
				}

				@Override
				public boolean tablefilterObject(ArrayList filterObject, Object eachrow) {
					String a=(String)filterObject.get(0);

						if (( (Vou)eachrow).getName().toLowerCase().indexOf(a.toLowerCase()) != -1) 
							return true; 
					return false;
				}

			

			
				
				
			};
			mytable.setEditable(true);

			column_name = new TableColumn("Name");
			 column_quantity = new TableColumn("Quantity");
		    column_price = new TableColumn("Price");
		      column_combo = new TableColumn("Selection");
	       column_date = new TableColumn("Date");
			 column_hyperlink = new TableColumn("Hyperlink");
			

			

			ObservableList items = mytable.getTableData();
			MyTableRow t1=new MyTableRow(new Vou("Knife",10.0,20,"hello"));
			ArrayList a=new ArrayList();
			a.add("hello");
			a.add("hello2");
			a.add("hello3");
			String[] aa={"hello","hello2","hello3"};
			((Vou)t1.getEachrow()).setSelection(aa);
			((Vou)t1.getEachrow()).setSelected_selection(aa[1]);
			((Vou)t1.getEachrow()).setTime(LocalDate.now());
			MyTableRow t2=new MyTableRow(new Vou("Fork",10.0,25,"click>>"));
			ArrayList b=new ArrayList();
			b.add("h");
			b.add("h2");
			b.add("h3");
			String[] bb={"h","h2","h3"};
			((Vou)t2.getEachrow()).setSelection(bb);
	//		((Vou)t2.getEachrow()).setSelected_selection(bb[1]);
			
		
			MyTableRow t3=new MyTableRow(new Vou("Pork",3.0,100,"hello"));
			ArrayList c=new ArrayList();
			c.add("e");
			c.add("e2");
			c.add("e3");
			String[]  cc={"e","e2","e3"};
			((Vou)t3.getEachrow()).setSelection(cc );
		//	((Vou)t3.getEachrow()).setSelected_selection(cc[1]);
			MyTableRow t4=new MyTableRow(new Vou("Pork",3.0,100,"hello"));
			((Vou)t4.getEachrow()).setSelection(cc );
			MyTableRow t5=new MyTableRow(new Vou("Pork",3.0,100,"hello1"));
			((Vou)t5.getEachrow()).setSelection(cc );
			MyTableRow t6=new MyTableRow(new Vou("Pork",3.0,100,"hello2"));
			((Vou)t6.getEachrow()).setSelection(cc );
			MyTableRow t7=new MyTableRow(new Vou("Pork",3.0,100,"hello3"));
			((Vou)t7.getEachrow()).setSelection(cc );
			MyTableRow t8=new MyTableRow(new Vou("Pork",3.0,100,"hello3"));
			((Vou)t8.getEachrow()).setSelection(cc );
			MyTableRow t9=new MyTableRow(new Vou("Pork",3.0,100,"hell5"));
			((Vou)t9.getEachrow()).setSelection(cc );
			MyTableRow t10=new MyTableRow(new Vou("Pork",3.0,100,"hello"));
			((Vou)t10.getEachrow()).setSelection(cc );
			MyTableRow t11=new MyTableRow(new Vou("Pork",3.0,100,"hello"));
			((Vou)t11.getEachrow()).setSelection(cc );
			MyTableRow t12=new MyTableRow(new Vou("Pork",3.0,100,"hello"));
			((Vou)t12.getEachrow()).setSelection(cc );
			MyTableRow t13=new MyTableRow(new Vou("Pork",3.0,100,"hello"));
			((Vou)t13.getEachrow()).setSelection(cc );
			MyTableRow t14=new MyTableRow(new Vou("Pork",3.0,100,"hello"));
			((Vou)t14.getEachrow()).setSelection(cc );
			MyTableRow t15=new MyTableRow(new Vou("Pork",3.0,100,"hello"));
			((Vou)t15.getEachrow()).setSelection(cc );
			MyTableRow t16=new MyTableRow(new Vou("Pork",3.0,100,"hello"));
			((Vou)t16.getEachrow()).setSelection(cc );



			items.addAll(t1,t2,t3,t4,t5,t6,t7,t9,t10,t11,t12,t13,t14,t15,t16);
			mytable.setCustomcellvalueFactory(column_date, "time", LocalDate.class);
			mytable.setCustomcellvalueFactory(column_price, "averagePrice", Double.class);
			mytable.setCustomcellvalueFactory(column_quantity, "volume", Integer.class);
			mytable.setCustomcellvalueFactory(column_name, "name", String.class);
			mytable.setCustomcellvalueFactory(column_combo, "selection", ArrayList.class);
			mytable.setCustomcellvalueFactory(column_hyperlink, "hyperlinktest", String.class);
			mytable.setFilterType(MyFXTable.Text_Filter);
			mytable.setFilterType(MyFXTable.Object_Filter);
			BorderPane bp=new BorderPane();
			Button aab=new Button("click");
			aab.setOnAction(e->{
			//	mytable.setTableSelectAllTableData(true);
				//mytable.setTableSelectAllFilterData(true);
		//		mytable.doFilterString("Knife");
			//	ArrayList<String> s=new ArrayList<>();
			//	s.add(new String("Pork"));
				//mytable.doFilterObject(s);
				if(i==0)
				{	
					i=1;
					mytable.getColumns().clear();
					mytable.addColumnAll(column_name,column_quantity,column_price,column_combo,column_date,column_hyperlink);

				}
				else
				{
					i=0;
					mytable.getColumns().clear();
					mytable.addColumnAll(column_hyperlink);
				}
				mytable.refresh();
			});
			mytable.getTableData();
			mytable.getItems();
			mytable.getSelectedItems();
			mytable.getNotSelectedItems();
		
			bp.setCenter(mytable);
			bp.setBottom(mytable.getSearchField());
			bp.setTop(aab);
			Scene scene = new Scene(bp);
			stage.setScene(scene);
			
			
			
	}

}

package CustomTableFx;

import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.text.Element;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.SelectionRow.ComplexObjectCellValueFactory;
import model.SelectionRow.MyTableRow;
import model.TableCell.TableButtonCell;
import model.TableCell.TableComboBoxCell;
import model.TableCell.TableDatePickerCell;
import model.TableCell.TableHyperlinkCell;
import model.TableCell.TableSelectionCheckBoxCell;
import model.TableCell.TableTextBoxCell;
import test.model.Vou;

public abstract class MyFXTable<E> extends TableView
		implements Callback<TableColumn<MyTableRow, Object>, TableCell<MyTableRow, Object>> {
	private ObservableList<MyTableRow> items;
	private TextField SearchField;
	private TableColumn<MyTableRow, Object> column_selected;
	private CheckBox select_all;
	private FilteredList<MyTableRow> filteredData;
	private int Filtertype;
	public static int Default_Filter = 1;
	public static int Text_Filter = 2;
	public static int Object_Filter = 3;

	public MyFXTable() {
		super();
		Filtertype = Default_Filter;
		items = FXCollections.observableArrayList();
		SearchField = new TextField();
		configureTableSelectionAndFilterField();
	}

	public void setFilterType(int filtertype) {
		Filtertype = filtertype;
	}

	public int getFilterType() {
		return Filtertype;
	}
	public void doFilterString(String filterString)
	{
		if(Filtertype==Text_Filter)
		{ 
			filteredData.setPredicate(MyTableRow -> {
				refresh();
				if (filterString == null || filterString.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = filterString.toLowerCase();

				return tablefilterText(lowerCaseFilter, MyTableRow.getEachrow());

			});
			doselect();

		}
	}


	public void doFilterObject(ArrayList filterObject)
	{
		if(Filtertype==Object_Filter)
		{
			filteredData.setPredicate(MyTableRow -> {
				refresh();
				if (filterObject == null || filterObject.size()==0) {
					return true;
				}

				return tablefilterObject(filterObject, MyTableRow.getEachrow());

			});
			doselect();

		}
	}
	

	public ObservableList<MyTableRow> getSelectedItems() {
		ObservableList<MyTableRow> temp = FXCollections.observableArrayList();
		for (int i = 0; i < this.getItems().size(); i++) {
			if (((MyTableRow) this.getItems().get(i)).getSelected() == true) {
				temp.add((MyTableRow) this.getItems().get(i));
			}
		}
		return temp;
	}

	public ObservableList<MyTableRow> getNotSelectedItems() {
		ObservableList<MyTableRow> temp = FXCollections.observableArrayList();
		for (int i = 0; i < this.getItems().size(); i++) {
			if (((MyTableRow) this.getItems().get(i)).getSelected() == false) {
				temp.add((MyTableRow) this.getItems().get(i));
			}
		}
		return temp;
	}
	private void doselect()
	{
		int i;// HeaderCheckbox check or not
		for (i = 0; i < this.getItems().size(); i++) {
			MyTableRow ii = ((MyTableRow) this.getItems().get(i));
			if (ii.isSelected() == false)
				break;
		}
		if (i < this.getItems().size())
			select_all.setSelected(false);
		else
			select_all.setSelected(true);
	}

	private void configureTableSelectionAndFilterField() {
		column_selected = new TableColumn("No");
		select_all = new CheckBox();
		column_selected.setGraphic(select_all);
	     filteredData = new FilteredList<>(items, p -> true);
		select_all.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ListIterator<MyTableRow> i = filteredData.listIterator();
				while (i.hasNext())
					i.next().setSelected(((CheckBox) event.getSource()).isSelected());
				select_all_ExtendOnAction(select_all, event);
				refresh();
			}

		});

		column_selected.setCellValueFactory(new PropertyValueFactory("selected"));
		column_selected.setCellFactory(
				new Callback<TableColumn<MyTableRow, Object>, TableCell<MyTableRow, java.lang.Object>>() {
					@Override
					public TableCell<MyTableRow, Object> call(TableColumn<MyTableRow, Object> param) {

						return new TableSelectionCheckBoxCell<MyTableRow, Object>(select_all) {

							@Override
							public void comboboxSelectionAction(CheckBox C, TableColumn<MyTableRow, Object> param,
									int RowIndex) {
								IndexcomboboxSelectionAction(C, param, RowIndex);

							}

							@Override
							public void CustomTableCellUpdateItem(Control c, TableCell<MyTableRow, Object> currentcell,
									TableColumn<MyTableRow, Object> param, Object item, boolean empty) {
								TableCellUpdateItem(c, currentcell, param, item, empty);

							}

							@Override
							public void extendTableCell(Control C, TableCell<MyTableRow, Object> currentcell,
									Object item) {
								ExtendTableCell(C, currentcell, item);
							}

						};

					}
				});

		SearchField.textProperty().addListener((observable, oldValue, newValue) -> {
			if (Filtertype == Default_Filter) {
				filteredData.setPredicate(MyTableRow -> {
					refresh();
					if (newValue == null || newValue.isEmpty()) {
						return true;
					}
					String lowerCaseFilter = newValue.toLowerCase();

					return tablefilter(lowerCaseFilter, MyTableRow.getEachrow());

				});
				doselect();
			
			}
		});
		SortedList<MyTableRow> sortedData = new SortedList<>(filteredData);
		sortedData.comparatorProperty().bind(this.comparatorProperty());
		this.getColumns().add(column_selected);
		this.setItems(sortedData);
		this.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, NewValue) -> {
			tablerowselectionchangedListener(observable, oldValue, NewValue);
			refresh();
		});
	}

	public void addColumnAll(TableColumn... elements) {
	
		TableColumn<MyTableRow, Object>[] tcs = elements.clone();
		for (int i = 0; i < tcs.length; i++) {
			tcs[i].setCellFactory(this);
			tcs[i].setOnEditCommit((CellEditEvent<MyTableRow, Object> t) -> {
				setColumnCommitAction(t.getTableColumn(), t.getTablePosition().getRow(),
						t.getTablePosition().getColumn(),
						((MyTableRow) this.getItems().get(t.getTablePosition().getRow())).getEachrow(), t);
			});

		}
		this.getColumns().addAll(tcs);

	}
	

	public abstract void setColumnCommitAction(TableColumn tablecolumn, int row, int column, Object eachrow,
			CellEditEvent<MyTableRow, Object> t);

	public abstract boolean tablefilterText(String lowerCaseFilter, Object TableDataRow);
	public abstract boolean tablefilter(String FilterStringlowerCase, Object TableDataRow);
	public abstract boolean tablefilterObject(ArrayList filterObject, Object TableDataRow) ;

	public abstract Object CustomCall(TableColumn<MyTableRow, Object> param);

	public abstract void tablerowselectionchangedListener(ObservableValue observable, Object oldValue, Object newValue);

	public abstract void TableCellUpdateItem(Control c, TableCell<MyTableRow, Object> currentcell,
			TableColumn<MyTableRow, Object> param, Object item, boolean empty);

	public abstract void ExtendTableCell(Control C, TableCell<MyTableRow, Object> currentcell, Object item);

	public abstract void IndexcomboboxSelectionAction(CheckBox C, TableColumn<MyTableRow, Object> param, int RowIndex);

	public abstract void select_all_ExtendOnAction(CheckBox Select_All, ActionEvent event);

	public void setCustomcellvalueFactory(TableColumn<MyTableRow, Object> c, String ObjectName, Class ObjectClass) {
		c.setCellValueFactory(new ComplexObjectCellValueFactory("eachrow." + ObjectName, ObjectClass));
	}

	public ObservableList<MyTableRow> getTableData() {
		return items;
	}

	public void setTableData(ObservableList<MyTableRow> items) {
		this.items = items;
	}

	public TextField getSearchField() {
		return SearchField;
	}

	public void setSearchField(TextField searchField) {
		SearchField = searchField;
	}

	public TableColumn<MyTableRow, Object> getColumn_selected() {
		return column_selected;
	}

	public void setColumn_selected(TableColumn<MyTableRow, Object> column_selected) {
		this.column_selected = column_selected;
	}

	@Override
	public TableCell<MyTableRow, Object> call(TableColumn<MyTableRow, Object> param) {
		Object o = CustomCall(param);
		if (o instanceof String) {
			String type = o.toString();
			if (type.equals("textfield")) {
				TableTextBoxCell texboxCell = new TableTextBoxCell() {
					@Override
					public void CustomTableCellUpdateItem(Control c, TableCell<MyTableRow, Object> currentcell,
							TableColumn<MyTableRow, Object> param, Object item, boolean empty) {
						TableCellUpdateItem(c, currentcell, param, item, empty);

					}

					@Override
					public void extendTableCell(Control C, TableCell<MyTableRow, Object> currentcell, Object item) {
						ExtendTableCell(C, currentcell, item);

					}

				};
				return texboxCell;
			} else if (type.equals("button")) {
				TableButtonCell buttoncell = new TableButtonCell() {

					@Override
					public void CustomTableCellUpdateItem(Control c, TableCell<MyTableRow, Object> currentcell,
							TableColumn<MyTableRow, Object> param, Object item, boolean empty) {
						TableCellUpdateItem(c, currentcell, param, item, empty);

					}

					@Override
					public void extendTableCell(Control C, TableCell<MyTableRow, Object> currentcell, Object item) {
						ExtendTableCell(C, currentcell, item);
					}

				};
				return buttoncell;
			} else if (type.equals("hyperlink")) {
				TableHyperlinkCell buttoncell = new TableHyperlinkCell() {

					@Override
					public void CustomTableCellUpdateItem(Control c, TableCell<MyTableRow, Object> currentcell,
							TableColumn<MyTableRow, Object> param, Object item, boolean empty) {
						TableCellUpdateItem(c, currentcell, param, item, empty);

					}

					@Override
					public void extendTableCell(Control C, TableCell<MyTableRow, Object> currentcell, Object item) {
						ExtendTableCell(C, currentcell, item);

					}

				};
				return buttoncell;
			} else if (type.equals("datepicker")) {
				TableDatePickerCell buttoncell = new TableDatePickerCell() {

					@Override
					public void CustomTableCellUpdateItem(Control c, TableCell<MyTableRow, Object> currentcell,
							TableColumn<MyTableRow, Object> param, Object item, boolean empty) {
						TableCellUpdateItem(c, currentcell, param, item, empty);

					}

					@Override
					public void extendTableCell(Control C, TableCell<MyTableRow, Object> currentcell, Object item) {
						ExtendTableCell(C, currentcell, item);

					}

				};
				return buttoncell;
			} else if (type.contains("combobox")) {
				type = type.replace("combobox_", "");
				if (type.length() == 0)
					try {
						throw new Exception(
								"Combobox should be combobox_fieldName. Filed Name is stored for the selected value of combobox.That Field should be public. ");

					} catch (Exception e) {

						e.printStackTrace();
					}
				TableComboBoxCell comboboxcell = new TableComboBoxCell(type) {
					@Override
					public void CustomTableCellUpdateItem(Control c, TableCell<MyTableRow, Object> currentcell,
							TableColumn<MyTableRow, Object> param, Object item, boolean empty) {
						TableCellUpdateItem(c, currentcell, param, item, empty);

					}

					@Override
					public void extendTableCell(Control C, TableCell<MyTableRow, Object> currentcell, Object item) {
						ExtendTableCell(C, currentcell, item);

					}

				};
				return comboboxcell;
			}

		} else if (o instanceof TableCell) {
			return (TableCell) o;
		}
		return new TableCell<MyTableRow, Object>();
	}

	public void setTableSelectAllFilterData(boolean bol) {
		for (int i = 0; i < this.getItems().size(); i++) {
			((MyTableRow) this.getItems().get(i)).setSelected(bol);
		}
		select_all.setSelected(bol);
		this.refresh();
	}

	public void setTableSelectAllTableData(boolean bol) {
		for (int i = 0; i < this.getTableData().size(); i++) {
			((MyTableRow) this.getTableData().get(i)).setSelected(bol);
		}
		select_all.setSelected(bol);
		this.refresh();
	}
}

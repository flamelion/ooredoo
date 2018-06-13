package model.TableCell;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import model.DateFormatter;
import model.SelectionRow.MyTableRow;

public abstract class TableDatePickerCell extends TableCell<MyTableRow, Object>  {
	
	private DatePicker datePicker;
	public abstract void CustomTableCellUpdateItem(Control c,TableCell<MyTableRow, Object> currentcell,TableColumn<MyTableRow, Object> param, Object item, boolean empty);
    public abstract void extendTableCell(Control C,TableCell<MyTableRow, Object> currentcell, Object item);

	public TableDatePickerCell()
	{
        createDatePicker();
        extendTableCell(datePicker,this,this.getItem());
	}
	
    private void createDatePicker() {
    	datePicker = new DatePicker(LocalDate.now());
    	datePicker.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
    	datePicker.setConverter(new DateFormatter());
    	datePicker.valueProperty().addListener(e->{
    		commitEdit(datePicker.getValue());
    	});
    
    	
	    }
    
	
    public void EditingCell() {
    }

    @Override
    public void startEdit() {
      if (!isEmpty()) {
        super.startEdit();
      //  createDatePicker();
        setText(null);
        setGraphic(datePicker);
        
        
      }
    }

    @Override
    public void cancelEdit() {
      super.cancelEdit();
      setText( getItem().toString());
      setGraphic(null);
    }


    public void updateItem(Object item, boolean empty) {
      super.updateItem(item, empty);
      if (empty) {
        setText(null);
        setGraphic(null);
      } else {
    	
    	  if(getIndex()==this.getTableView().getSelectionModel().getSelectedIndex()&& this.getTableView().getItems().get(getIndex()).isSelected()==true) 
   	   {
   		   setStyle("-fx-background-color: #8ce273");
 				setTextFill(Color.WHITE);
   	   }
             
   	   else if(getIndex()==this.getTableView().getSelectionModel().getSelectedIndex())
   	   {
   		   setStyle("-fx-background-color:	#00BFFF");
 				setTextFill(Color.WHITE);
   	   }
   	    else if(this.getTableView().getItems().get(getIndex()).isSelected()==true)
				{
   	    	setStyle("-fx-background-color:Yellow");
   	    	setTextFill(Color.BLUE);
				}
    	    
       		   else
       		   {
       			   if(getIndex()%2==0)
       			   {
       				   setStyle("-fx-background-color:white");
      					   setTextFill(Color.BLACK);
       			   }
       			   else
       			   {
       				   setStyle("-fx-background-color:#F5F5F5");
      					   setTextFill(Color.BLACK);
       			   }
       			   
       		   }
        if (isEditing()) {
        		if (datePicker != null) {
        			datePicker.setValue((LocalDate)item);
        			
        		}
        		setText(null);
        		setGraphic(datePicker);
        }
        else {
        	DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        	
        			setText(dateTimeFormatter.format((LocalDate)item));
        			setGraphic(null);
        }
      
        setAlignment(Pos.CENTER_LEFT);
    	CustomTableCellUpdateItem(datePicker,this,this.getTableColumn(),item,empty);
        
      }
    }
	
}

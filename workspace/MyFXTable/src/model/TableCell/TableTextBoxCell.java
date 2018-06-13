package model.TableCell;

import java.io.File;

import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Control;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import model.SelectionRow.MyTableRow;

public abstract class TableTextBoxCell extends TableCell<MyTableRow, Object> {

	
	private TextField textField;
	public abstract void CustomTableCellUpdateItem(Control c,TableCell<MyTableRow, Object> currentcell,TableColumn<MyTableRow, Object> param, Object item, boolean empty);
    public abstract void extendTableCell(Control C,TableCell<MyTableRow, Object> currentcell, Object item);

    
	@Override
	public void commitEdit(Object newValue) {
		super.commitEdit(newValue);

		this.getTableView().refresh();
	}
	public TableTextBoxCell()
	{
		textField = new TextField();
	}
	
    private void createTextField() {
	      textField.setText(getItem().toString());
	      textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
	     
	      textField.focusedProperty() .addListener( (ObservableValue<? extends Boolean> arg0, Boolean arg1,Boolean arg2) -> {    	
	    	  if (!arg2) {
	                  commitEdit(textField.getText());
	                }   
	              });
	      
	      extendTableCell(textField,this,this.getItem());
	   
	    }
    
	
 
	public void EditingCell() {
    }

    @Override
    public void startEdit() {
      if (!isEmpty()) {
          super.startEdit();
        createTextField();
        setText(null);
        setGraphic(textField);
        textField.requestFocus();
        textField.selectAll();
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
        		if (textField != null) {
        				textField.setText(item.toString());
        		}
        		setText(null);
        		setGraphic(textField);
        }
        else {
        			setText(item.toString());
        			setGraphic(null);
        }
        
        setAlignment(Pos.CENTER_LEFT);
    	CustomTableCellUpdateItem(textField,this,this.getTableColumn(),item,empty);
        
      }
    }
	
}

package model.TableCell;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.beanutils.BeanUtils;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import model.SelectionRow.MyTableRow;

public abstract class TableComboBoxCell extends TableCell<MyTableRow, Object> {
	
		private ComboBox combobox;

		private String FieldName;
		private MyTableRow currentobject;
		public TableComboBoxCell(String FieldName)
		{	
			
			this.FieldName=FieldName;
			 combobox=new ComboBox<>();
			 extendTableCell(combobox,this,this.getItem());
		   
		}
		public abstract void CustomTableCellUpdateItem(Control c,TableCell<MyTableRow, Object> currentcell,TableColumn<MyTableRow, Object> param, Object item, boolean empty);
		 public abstract void extendTableCell(Control C,TableCell<MyTableRow, Object> currentcell, Object item);
		   
	    private void createCombobox() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
	    	 
	    	  currentobject=((MyTableRow)this.getTableRow().getItem());
	    	  if(currentobject !=null)
	    	  {	 
	    		  
	    		  String stringValue = BeanUtils.getNestedProperty(currentobject, "eachrow."+FieldName);    	
	    		  if(this.getItem()!=null)
	    		  {
	    				String items=this.getItem().toString();
	    				String[] iem=items.split(",");
	    				combobox.setItems(FXCollections.observableArrayList(iem));
	    				if(stringValue.equals(""))
	    				{
	    					combobox.setValue(iem[0]);
	    					BeanUtils.copyProperty(currentobject, FieldName, iem[0]);
	    				}
	    				else
	    				{
	    					combobox.setValue(stringValue);
	    				}
	    				
	    		  }
	    	  }
	    	  combobox.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
	    	  combobox.getSelectionModel().selectedItemProperty().addListener( (options, oldValue, newValue) ->{	    		 
	    		if(newValue!=null)
	    		  commitEdit(newValue.toString());
	    	  });
		    }
	    
		
	    public void EditingCell() {
	    }

	    @Override
	    public void startEdit() {
	      if (!isEmpty()) {
	        super.startEdit();
	        try {
				createCombobox();
			} catch (Exception e) {
				e.printStackTrace();
			} 
	        setText(null);
	        setGraphic(combobox);
	      
	      }
	    }

	    @Override
	    public void cancelEdit() {
	      super.cancelEdit();
	      setText( combobox.getValue().toString());
	      
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
	        	  
	        		setText(null);
	        		setGraphic(combobox);
	        }
	        else {
	        	
	        	 
	        		try {
	        			
	        				if(this.getTableRow()!=null)
	        				{
	        					
	        					if(this.getTableRow().getItem()!=null)
	        					 {
	        					  currentobject=((MyTableRow)this.getTableRow().getItem());
	        					  String stringValue = BeanUtils.getNestedProperty(currentobject, "eachrow."+FieldName);
	        				
	        					
	        					
	        			    	
	        			    	  if(!stringValue.equals(""))
	        			    	  {
	        			    		  
	        			    		  setText(stringValue);
	        			    	  }
	        			    	  else
	        			    	  {
	        			    		 
	  	        					if(this.getItem()!=null)
		        					{
		        					String items=this.getItem().toString();
		    	    				String[] iem=items.split(",");
		    	    				setText(iem[0]);
		    	    				BeanUtils.copyProperty(currentobject, "eachrow."+FieldName, iem[0]);
		        					}
	        			    	  }
	        					 }
	        					 else
	        					 {
	        						 setText(""); 
	        					 }
	        			    	
	        				}
	        				else
							{
	        					setText("");
							}
	        					
	    	    				
	        				
	    
						} catch (Exception e) {
							
							e.printStackTrace();
						} 
	        			
	        			setGraphic(null);
	        }
	      
            setAlignment(Pos.CENTER_LEFT);
	    	CustomTableCellUpdateItem(combobox,this,this.getTableColumn(),item,empty);
	        
	      }
	    }

}

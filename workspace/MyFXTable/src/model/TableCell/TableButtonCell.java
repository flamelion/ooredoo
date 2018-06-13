package model.TableCell;

import java.io.File;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import model.SelectionRow.MyTableRow;

public abstract class TableButtonCell  extends TableCell<MyTableRow, Object>{
	


    private Button btn;
    public abstract void CustomTableCellUpdateItem(Control c,TableCell<MyTableRow, Object> currentcell,TableColumn<MyTableRow, Object> param, Object item, boolean empty);
    public abstract void extendTableCell(Control C,TableCell<MyTableRow, Object> currentcell, Object item);
    public TableButtonCell()
    {
    	 btn = new Button();
         extendTableCell(btn,this,this.getItem());
    }
  
    @Override
    public void updateItem( Object item, boolean empty )
    {
    	   super.updateItem(item, empty);
    	   if (empty) {
               setGraphic(null);
               setText(null);
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
        		   
        		 
        	   
        	   if (btn != null) {
        		   btn.setText(item.toString());
        		  
        		   if( this.getTableColumn().isEditable())
        			   btn.setDisable(false);  
        		   else
        			   btn.setDisable(true);
   	  	}
        	   
               setGraphic(btn);
               setText(null);
        
               setAlignment(Pos.CENTER_LEFT);
               CustomTableCellUpdateItem(btn,this,this.getTableColumn(),item,empty);
           }   
    }
	
    
   


}

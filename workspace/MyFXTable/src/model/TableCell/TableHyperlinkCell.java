package model.TableCell;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import model.SelectionRow.MyTableRow;

public abstract class TableHyperlinkCell extends TableCell<MyTableRow, Object> {
		private HBox hpane;
		private ImageView imv;
	    private Hyperlink btn;
	    private InputStream is;
	    public abstract void CustomTableCellUpdateItem(Control c,TableCell<MyTableRow, Object> currentcell,TableColumn<MyTableRow, Object> param, Object item, boolean empty);
	    public abstract void extendTableCell(Control C,TableCell<MyTableRow, Object> currentcell, Object item);
	    public TableHyperlinkCell()
	    {
	    	 hpane=new HBox();
	   
	    	 hpane.setStyle("-fx-background-color:red");
	    	 btn = new Hyperlink();
	  
	    	 imv = new ImageView();
	    	 imv.setFitHeight(30);
		     imv.setFitWidth(30);
		
		  
		     hpane.setAlignment(Pos.CENTER_LEFT);
		     hpane.setStyle("-fx-alignment: CENTER-LEFT;");
	    
	    	 imv.setVisible(false);
	         extendTableCell(btn,this,this.getItem());
	    }
	    public void setImageSize(int Height,int Width)
	    {
	    	imv.setFitHeight(Height);
	    	imv.setFitWidth(Width);
	    }
	    public void UIincludedHyperlinkWithImage()
	    {
	   	   hpane.getChildren().addAll(imv,btn);
	    }
	    public void UIincludedHyperlinkWithoutImage()
	    {
	    	
	   	   hpane.getChildren().addAll(btn);
	    }
	    public void setImage(InputStream imagestream)
	    {
	    	  is=imagestream;
	    	  if(is==null)
	    	  {
	    		  imv.setVisible(false);
	    	  }
	
        
              imv.setImage(new Image(is));
              imv.setVisible(true);
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
	        	 
	               setGraphic(hpane);
	               setText(null);
	             
	               setAlignment(Pos.CENTER_LEFT);
	               
	               CustomTableCellUpdateItem(btn,this,this.getTableColumn(),item,empty);
	           }   
	    }
}

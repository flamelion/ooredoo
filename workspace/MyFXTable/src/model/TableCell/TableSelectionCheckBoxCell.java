package model.TableCell;


import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.paint.Color;
import model.SelectionRow.MyTableRow;


public abstract class TableSelectionCheckBoxCell<MyTableRow, Object> extends TableCell<MyTableRow, Object>{
	
	
		private CheckBox cb;
		private CheckBox Headercombox;
		public abstract void CustomTableCellUpdateItem(Control c,TableCell<MyTableRow, Object> currentcell,TableColumn<MyTableRow, Object> param, Object item, boolean empty);
	    public abstract void extendTableCell(Control C,TableCell<MyTableRow, Object> currentcell,Object item);
	    public abstract void comboboxSelectionAction(CheckBox C,TableColumn<MyTableRow, Object> param, int RowIndex);

	
		public CheckBox getCb() {
			return cb;
		}

		public void setCb(CheckBox cb) {
			this.cb = cb;
		}
		public void checkBoxAction()
		{
			
			  (( model.SelectionRow.MyTableRow ) getTableView().getItems().get( getIndex())).setSelected(cb.isSelected());
			  int i;
			  for(i=0;i<getTableView().getItems().size();i++)
			  {
				  model.SelectionRow.MyTableRow ii=  ((  model.SelectionRow.MyTableRow ) getTableView().getItems().get( i));
				
				if(ii.isSelected()==false)
					break;
			}
			 if(getTableView().getItems().size()==0)
				 Headercombox.setSelected(false);
			if(i<getTableView().getItems().size())
				Headercombox.setSelected(false);
			else
				Headercombox.setSelected(true);
			  getTableView().refresh();

		}
		

		public TableSelectionCheckBoxCell(CheckBox headercombox)
		{
			
			
			Headercombox=headercombox;
			cb=new CheckBox();
			cb.setOnAction(e->{
					checkBoxAction();
					comboboxSelectionAction(cb,this.getTableColumn(),this.getTableRow().getIndex());
				});
		
			 extendTableCell(cb,this,(Object) this.getItem());
			
		}
		
		@Override
		public void startEdit() {
	
			
			  if ( !isEmpty() )
	            {
	                super.startEdit();
	               
	             
	                setText( null );
	                setGraphic( cb );
	             
	            }
		}
		
	
		@Override
        public void updateItem( Object i, boolean empty )
        {
			 super.updateItem(i, empty);
			
			 
			if (i == null || empty) {
				setText(null);
				setStyle("");
				
				 

			} else {
					if(i instanceof java.lang.Boolean)
					{	
						java.lang.Boolean bb=(java.lang.Boolean)i;
						
						  if(getIndex()==this.getTableView().getSelectionModel().getSelectedIndex()&& bb.booleanValue()==true) 
			        	   {
			        		   setStyle("-fx-background-color: #8ce273");
			      				setTextFill(Color.WHITE);
			        	   }
			                  
			        	   else if(getIndex()==this.getTableView().getSelectionModel().getSelectedIndex())
			        	   {
			        		   setStyle("-fx-background-color:	#00BFFF");
			      				setTextFill(Color.WHITE);
			        	   }
			        	    else if(bb.booleanValue()==true)
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
					
						cb.setText(getIndex()+1+"");
						cb.setSelected(bb);
					
						setGraphic(null);
						setGraphic(cb);
					
			
					}
				
		             setAlignment(Pos.CENTER_LEFT);
					CustomTableCellUpdateItem(cb,this,this.getTableColumn(),i,empty);
					CustomTableCellUpdateItem(Headercombox,this,this.getTableColumn(),i,empty);

				
					
			
				
				
			
				
				
			}
        }

	
	}

	

	


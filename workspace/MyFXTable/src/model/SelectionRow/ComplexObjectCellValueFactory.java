package model.SelectionRow;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import org.apache.commons.beanutils.BeanUtils;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class ComplexObjectCellValueFactory implements Callback<CellDataFeatures<MyTableRow, Object>, ObservableValue<Object>> {
  private String property;
  private Class c;
  public ComplexObjectCellValueFactory(String property,Class c) {
      this.property = property;
      this.c=c;
  }

  public ObservableValue<Object> call(CellDataFeatures<MyTableRow, Object> param) {
	  MyTableRow value = param.getValue();
      String stringValue = null;
      
      try {

         stringValue = BeanUtils.getNestedProperty(value, property);
  
  
         if(c.getName().equals("java.lang.Double"))
         {		
        	 return new SimpleObjectProperty<Object>(Double.parseDouble(stringValue));
         }
         else if(c.getName().equals("java.lang.Float"))
         {		
        	 return new SimpleObjectProperty<Object>(Float.parseFloat(stringValue));
         }
         else if(c.getName().equals("java.lang.Integer"))
         {		
        	 return new SimpleObjectProperty<Object>(Integer.parseInt(stringValue));
         }
         else if(c.getName().equals("java.time.LocalDate"))
         {		
        	
        	
       		
      		 LocalDate localDate = LocalDate.parse(stringValue);
        	 return new SimpleObjectProperty<Object>( localDate);
      
        	
         }
         else if(c.getName().equals("java.util.ArrayList"))
         {		
        
        	 return new SimpleObjectProperty<Object>(stringValue);
         }
         
      } catch (Exception e) {
       	e.printStackTrace();
      }
      
      return new SimpleObjectProperty<Object>(stringValue);
  }
}
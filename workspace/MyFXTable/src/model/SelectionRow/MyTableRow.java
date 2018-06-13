package model.SelectionRow;

import test.model.Vou;

public class MyTableRow implements Cloneable {
	private Boolean selected = false;
	private Object eachrow;
	private Class TableDataClass;

	public MyTableRow(Object o) {
			this.eachrow=o;	
	}

	public Class getTableDataClass() {
		return TableDataClass;
	}
	public Boolean getSelected() {
		return selected;
	}



	public void setSelected(Boolean selected) {
		this.selected = selected;
	}



	public Object getEachrow() {
		
		return eachrow;
	}



	public void setEachrow(Object rowlist) {
		this.eachrow = rowlist;
	}



	public void setSelected(boolean selected) {
		this.selected=selected;
	}

	public boolean isSelected() {
		return selected;
	}
	 @Override
	 public Object clone() throws CloneNotSupportedException {
	   return super.clone();
	 }
}

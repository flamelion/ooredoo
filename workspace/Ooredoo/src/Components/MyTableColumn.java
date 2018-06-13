package Components;

import javafx.scene.control.TableColumn;
import model.SelectionRow.MyTableRow;

public class MyTableColumn<T, S> extends TableColumn<S, T> {
	private boolean select=false;
	public MyTableColumn(String title)
	{
		super(title);
		select=false;
	}
	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}
	
}

package com.ghg.controller;

import java.time.LocalDate;

import com.ghg.index.MainFrame_Controller;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.VBox;
import model.DateFormatter;

public class NumberSearchController<T extends GETVALUE> {
	private T searchText;
	private VBox vbox;
    @FXML
    private Label searchlabel;

    @FXML
    private Button close;


 
    @FXML
    private Spinner<Integer> startnum;

    @FXML
    private Spinner<Integer> endnum;
	public void settingNumberSearchController(VBox parent,T value,String LabelText,int startvalue,int endvalue)
	{	
		searchText=value;
		searchlabel.setText(LabelText);
		vbox=parent;
		startnum.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,1000));
		startnum.getValueFactory().setValue(startvalue);
		endnum.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,1000));
		endnum.getValueFactory().setValue(endvalue);
	}
    public T getSearchText() {
		searchText.setSearchvalue(new DataRange(startnum.getValue(), endnum.getValue()));
		return searchText;
	}
    @FXML
    void closeAction(ActionEvent event) {
      	vbox.getChildren().remove(searchlabel.getParent());
    		MainFrame_Controller.filtervaluelist.remove(this);
    }

}

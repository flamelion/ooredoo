package com.ghg.controller;

import com.ghg.index.MainFrame_Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class TextSearchController<T extends GETVALUE> {
	private T searchText;
    @FXML
    private Label searchlabel;
    @FXML
    private ComboBox<String> searchcombo;
    @FXML
    private Button close;
    private VBox vbox;
   

	public void settingTextSearchController(VBox parent,T value,String LabelText,String prompttext)
	{	
		searchText=value;
		searchcombo.setStyle("-fx-font-family: \"Zawgyi-One\"; ");
		searchlabel.setText(LabelText);
		searchcombo.setPromptText(prompttext);
		searchcombo.getItems().addAll(value.getDistantData());
		FilterComboBox<String> filter=new FilterComboBox<>(searchcombo);
		vbox=parent;
	}
	public T getSearchText() {
		if(searchcombo.getValue()==null)
			searchText.setSearchvalue("");
		else
			searchText.setSearchvalue(searchcombo.getValue());
		return searchText;
	}
    @FXML
    void closeAction(ActionEvent event) {
    	vbox.getChildren().remove(searchlabel.getParent());
    	MainFrame_Controller.filtervaluelist.remove(this);
    }

	
}

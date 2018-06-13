package test.ui;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.ghg.controller.FilterComboBox;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.FlowPane;

public class ui_controller {
    @FXML
    private FlowPane flowpane;
	
    private ComboBox<String> fcb;
    
	@FXML
	void initialize() {
		ObservableList<String> s=FXCollections.observableArrayList();
		s.add("aa");
		s.add("aaa");
		s.add("bb");
		s.add("cc");
		s.add("dd");
		s.add("ee");
		s.add("ff");
		fcb=new ComboBox(s);
		FilterComboBox<String> ff=new FilterComboBox<>(fcb);
		fcb.setPrefHeight(20);
		fcb.setPrefWidth(500);
		flowpane.getChildren().add(fcb);
	}
	 @FXML
	    private Button clicked;

	    @FXML
	    void clicked_action(ActionEvent event) {
	    	System.out.println(fcb.getValue());
	    }
}

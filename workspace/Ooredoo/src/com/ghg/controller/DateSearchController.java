package com.ghg.controller;

import java.time.LocalDate;
import java.util.Arrays;

import com.ghg.index.MainFrame_Controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class DateSearchController<T extends GETVALUE> {
	private T searchText;
	private VBox vbox;
	@FXML
	private Label searchlabel;

	@FXML
	private Button close;

	@FXML
	private ComboBox<String> start_d;

	@FXML
	private ComboBox<String> start_m;

	@FXML
	private ComboBox<String> start_year;

	@FXML
	private ComboBox<String> end_d;

	@FXML
	private ComboBox<String> end_m;

	@FXML
	private ComboBox<String> end_y;

	@FXML
	public void initialize() {

		for (int i = 1; i <= 31; i++) {
			start_d.getItems().add(i + "");
			end_d.getItems().add(i + "");
		}

		for (int i = 1950; i <= 2050; i++) {
			start_year.getItems().add(i + "");
			end_y.getItems().add(i + "");
		}
		start_m.getItems().addAll("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
		end_m.getItems().addAll("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
		FilterComboBox<String> filter = new FilterComboBox<>(start_d);
		FilterComboBox<String> filter2 = new FilterComboBox<>(start_m);
		FilterComboBox<String> filter3 = new FilterComboBox<>(start_year);
		FilterComboBox<String> filter4 = new FilterComboBox<>(end_d);
		FilterComboBox<String> filter5 = new FilterComboBox<>(end_m);
		FilterComboBox<String> filter6 = new FilterComboBox<>(end_y);
		start_d.valueProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				if (newValue == null)
					return;
				if (!newValue.toString().equals("")) {
					int val;
					try {

						val = Integer.parseInt(newValue.toString());
						boolean b = Arrays.asList(start_d.getItems().toArray()).contains(val + "");
						if (!b)
							start_d.setValue("");
					} catch (Exception exp) {
						start_d.setValue("");
					}
				}
			}
		});

		start_year.valueProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				boolean setempty = false;
				if (newValue == null)
					return;
				if (!newValue.toString().equals("")) {
					int val;
					try {

						val = Integer.parseInt(newValue.toString());
						boolean b = Arrays.asList(start_year.getItems().toArray()).contains(val + "");
						if (!b)
							setempty = true;
					} catch (Exception exp) {
						setempty = true;
					}
				} else
					setempty = true;
				if (setempty) {
					start_year.setValue(LocalDate.now().getYear() + "");
				}

			}
		});
		end_d.valueProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				if (newValue == null)
					return;
				if (!newValue.toString().equals("")) {
					int val;
					try {
						val = Integer.parseInt(newValue.toString());
						boolean b = Arrays.asList(end_d.getItems().toArray()).contains(val + "");
						if (!b)
							end_d.setValue("");
					} catch (Exception exp) {
						end_d.setValue("");
					}
				}
			}
		});
		end_y.valueProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				boolean setempty = false;
				if (newValue == null)
					return;
				if (!newValue.toString().equals("")) {
					int val;
					try {

						val = Integer.parseInt(newValue.toString());
						boolean b = Arrays.asList(start_year.getItems().toArray()).contains(val + "");
						if (!b)
							setempty = true;
					} catch (Exception exp) {
						setempty = true;
					}
				} else
					setempty = true;
				if (setempty) {
					start_year.setValue(LocalDate.now().getYear() + "");
				}
			}
		});
		start_m.valueProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				if (newValue == null)
					return;
				if (!newValue.toString().equals("")) {
					boolean b = Arrays.asList(start_m.getItems().toArray()).contains(newValue.toString());
					if (!b)
						start_m.setValue("");

				}
			}
		});
		end_m.valueProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				if (newValue == null)
					return;
				if (!newValue.toString().equals("")) {
					boolean b = Arrays.asList(end_m.getItems().toArray()).contains(newValue.toString());
					if (!b)
						end_m.setValue("");

				}
			}
		});

	}

	public void settingDateSearchController(VBox parent, T value, String LabelText, LocalDate std, LocalDate edd) {
		searchText = value;
		searchlabel.setText(LabelText);
		vbox = parent;
		start_d.setValue(std.getDayOfMonth() + "");
		start_m.getSelectionModel().select(std.getMonthValue() - 1);
		start_year.setValue(edd.getYear() + "");
		end_d.setValue(edd.getDayOfMonth() + "");
		end_m.getSelectionModel().select(edd.getMonthValue() - 1);
		end_y.setValue(edd.getYear() + "");

	}

	public T getSearchText() {
		int sd = Integer.parseInt((!start_d.getValue().equals("") ? start_d.getValue() : "1"));
		int sm = Integer.parseInt(
				(!start_m.getValue().equals("") ? start_m.getSelectionModel().getSelectedIndex() + 1 + "" : "1"));
		int sy = Integer.parseInt(start_year.getValue());

		int ed = Integer.parseInt((!end_d.getValue().equals("") ? end_d.getValue() : "1"));
		int em = Integer
				.parseInt((!end_m.getValue().equals("") ? end_m.getSelectionModel().getSelectedIndex() + 1 + "" : "1"));
		int ey = Integer.parseInt(end_y.getValue());
		LocalDate std = LocalDate.of(sy, sm, sd);
		LocalDate etd = LocalDate.of(ey, em, ed);
		searchText.setSearchvalue(new DataRange(std, etd));
		return searchText;
	}

	@FXML
	void closeAction(ActionEvent event) {

		vbox.getChildren().remove(searchlabel.getParent());
		MainFrame_Controller.filtervaluelist.remove(this);
	}

}

package com.jmc.mazebank.Controllers.Admin;

import java.net.URL;
import java.util.ResourceBundle;

import com.jmc.mazebank.Models.Model;

import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

public class AdminController implements Initializable {
	public BorderPane admin_parent;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Model.getInstance().getViewFactory().getAdminSelectedMenuItem().addListener((observableValue, oldVal, newVal) -> {
			switch (newVal) {
			case CREATE_CLIENTS -> admin_parent.setCenter(Model.getInstance().getViewFactory().getCreateClientView());
			case CLIENTS -> admin_parent.setCenter(Model.getInstance().getViewFactory().getClientsView());
			default -> admin_parent.setCenter(Model.getInstance().getViewFactory().getDepositeView());
		}
		});
	}
}

package com.jmc.mazebank.Controllers.Client;

import java.net.URL;
import java.util.ResourceBundle;

import com.jmc.mazebank.Models.Model;

import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

public class ClientController implements Initializable {

	public BorderPane client_parent;
	
	@Override
	public void initialize(URL url, ResourceBundle resurceBundle) {
		// TODO Auto-generated method stub
		Model.getInstance().getViewFactory().getClientSelectedMenuItem().addListener((observableValue, oldVal, newVal) -> {
			switch (newVal) {
				case TRANSACTIONS -> client_parent.setCenter(Model.getInstance().getViewFactory().getTransactionsView());
				case ACCOUNTS -> client_parent.setCenter(Model.getInstance().getViewFactory().getAccountsView());
				default -> client_parent.setCenter(Model.getInstance().getViewFactory().getDashBoardView());
			}
		});
	}

}

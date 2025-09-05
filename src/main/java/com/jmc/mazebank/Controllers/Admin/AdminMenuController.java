package com.jmc.mazebank.Controllers.Admin;

import java.net.URL;
import java.util.ResourceBundle;

import com.jmc.mazebank.Models.Model;
import com.jmc.mazebank.Views.AdminMenuOptions;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdminMenuController implements Initializable {
	public Button create_client_btn;
	public Button clients_btn;
	public Button deposite_btn;
	public Button logout_btn;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		addListeners();
	}
	
	private void addListeners() {
		create_client_btn.setOnAction(event -> onCreateClient());
		clients_btn.setOnAction(event -> onClients());
		deposite_btn.setOnAction(event -> onDeposite());
		logout_btn.setOnAction(event -> onLogout());
	}
	
	private void onCreateClient() {
		Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.CREATE_CLIENTS);
	}
	
	private void onClients() {
		Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.CLIENTS);
	}
	
	private void onDeposite() {
		Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.DEPOSITE);
	}
	
	private void onLogout() {
        // Get Stage
        Stage stage = (Stage) clients_btn.getScene().getWindow();
        // Close the Admin window
        Model.getInstance().getViewFactory().closeStage(stage);
        // Show Login Window
        Model.getInstance().getViewFactory().showLoginWindow();
        // Set Admin Login Success Flag To False
        Model.getInstance().setAdminLoginSuccessFlag(false);
    }
	
}

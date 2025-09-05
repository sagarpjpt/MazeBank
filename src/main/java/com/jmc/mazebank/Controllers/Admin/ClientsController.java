package com.jmc.mazebank.Controllers.Admin;

import java.net.URL;
import java.util.ResourceBundle;

import com.jmc.mazebank.Models.Client;
import com.jmc.mazebank.Models.Model;
import com.jmc.mazebank.Views.ClientCellFactory;

import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class ClientsController implements Initializable {
	public ListView<Client> clients_listview;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
		initClientsList();
        clients_listview.setItems(Model.getInstance().getClients());
        clients_listview.setCellFactory(e -> new ClientCellFactory());
	}
	
	private void initClientsList() {
        if (Model.getInstance().getClients().isEmpty()){
            Model.getInstance().setClients();
        }
    }
	
}

package com.jmc.mazebank.Controllers.Client;

import java.net.URL;
import java.util.ResourceBundle;

import com.jmc.mazebank.Models.Model;
import com.jmc.mazebank.Models.Transaction;
import com.jmc.mazebank.Views.TransactionCellFactory;

import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class TransactionsController implements Initializable{
	public ListView<Transaction> transactions_listview;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		initAllTransactionsList();
        transactions_listview.setItems(Model.getInstance().getAllTransactions());
        transactions_listview.setCellFactory(e -> new TransactionCellFactory());
	}
	
	private void initAllTransactionsList() {
        if (Model.getInstance().getAllTransactions().isEmpty()){
            Model.getInstance().setAllTransactions();
        }
    }
	
}

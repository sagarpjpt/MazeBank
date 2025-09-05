package com.jmc.mazebank.Views;

import com.jmc.mazebank.Controllers.Admin.AdminController;
import com.jmc.mazebank.Controllers.Client.ClientController;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ViewFactory {
	private AccountType loginAccountType;
//	client views
	private final ObjectProperty<ClientMenuOptions> clientSelectedMenuItem;
	private AnchorPane dashboardView;
	private AnchorPane transactionsView;
	private AnchorPane accountsView;
	
//	admin views
	private final ObjectProperty<AdminMenuOptions> adminSelectedMenuItem;
	private AnchorPane createClientView;
	private AnchorPane clientsView;
	private AnchorPane depositeView;
	
	public ViewFactory() {
		this.loginAccountType = AccountType.CLIENT;
		this.clientSelectedMenuItem = new SimpleObjectProperty<>();
		this.adminSelectedMenuItem = new SimpleObjectProperty<>();
	}
	
	public AccountType getLoginAccountType() {
		return loginAccountType;
	}
	
	public void setLoginAccountType(AccountType loginAccountType) {
		this.loginAccountType = loginAccountType;
	}
	
//	client view section
	
	public ObjectProperty<ClientMenuOptions> getClientSelectedMenuItem() {
		return clientSelectedMenuItem;
	}
	
	
	public AnchorPane getDashBoardView() {
		if(dashboardView == null) {
			try {
				dashboardView = new FXMLLoader(getClass().getResource("/Fxml/Client/Dashboard.fxml")).load();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dashboardView;
	}
	
	public AnchorPane getTransactionsView() {
		if(transactionsView == null) {
			try {
				transactionsView = new FXMLLoader(getClass().getResource("/Fxml/Client/Transactions.fxml")).load();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return transactionsView;
	}
	
	public AnchorPane getAccountsView() {
		if(accountsView == null) {
			try {
				accountsView = new FXMLLoader(getClass().getResource("/Fxml/Client/Accounts.fxml")).load();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return accountsView;
	}
	
	
	public void showClientWindow() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Client/Client.fxml"));
		ClientController clientController = new ClientController();
		loader.setController(clientController);
		createStage(loader);
	}
	
//	admin views section
	
	public ObjectProperty<AdminMenuOptions> getAdminSelectedMenuItem() {
		return adminSelectedMenuItem;
	}
	
	public AnchorPane getCreateClientView() {
		if(createClientView == null) {
			try {
				createClientView = new FXMLLoader(getClass().getResource("/Fxml/Admin/CreateClient.fxml")).load();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return createClientView;
	}
	
	public AnchorPane getClientsView() {
		if(clientsView == null) {
			try {
				clientsView = new FXMLLoader(getClass().getResource("/Fxml/Admin/Clients.fxml")).load();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return clientsView;
	}
	
	public AnchorPane getDepositeView() {
		if(depositeView == null) {
			try {
				depositeView = new FXMLLoader(getClass().getResource("/Fxml/Admin/Deposite.fxml")).load();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return depositeView;
	}
	
	public void showAdminWindow() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Admin/Admin.fxml"));
		AdminController adminController = new AdminController();
		loader.setController(adminController);
		createStage(loader);
	}
	
//	------------------------------------------------------------
	
	public void showLoginWindow() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
		createStage(loader);
	}
	
	public void showMessageWindow(String pAddress, String messageText) {
        StackPane pane = new StackPane();
        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);
        Label sender = new Label(pAddress);
        Label message = new Label(messageText);
        hBox.getChildren().addAll(sender, message);
        pane.getChildren().add(hBox);
        Scene scene = new Scene(pane, 300, 100);
        Stage stage = new Stage();
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/icon.png"))));
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Message");
        stage.setScene(scene);
        stage.show();
    }
	
	private void createStage(FXMLLoader loader) {
		Scene scene = null;
		try {
			scene = new Scene(loader.load());
		} catch(Exception e) {
			e.printStackTrace();
		}
		Stage stage = new Stage();
		stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/bank.png"))));
		stage.setResizable(false);
		stage.setScene(scene);
		stage.setTitle("Maze Bank");
		stage.show();
	}
	
	public void closeStage(Stage stage) {
		stage.close();
	}
}

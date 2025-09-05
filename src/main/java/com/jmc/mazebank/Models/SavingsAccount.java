package com.jmc.mazebank.Models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class SavingsAccount extends Account{
	
	private final DoubleProperty widthdrawalLimit;

	public SavingsAccount(String owner, String accountNumber, double balance, double withdrawalLimit) {
		super(owner, accountNumber, balance);
		// TODO Auto-generated constructor stub
		this.widthdrawalLimit = new SimpleDoubleProperty(this, "Withdrawal Limit", withdrawalLimit);
	}

	public DoubleProperty withdrawalLimitProp() {
		return widthdrawalLimit;
	}
	
	@Override
    public String toString() {
        return accountNumberProperty().get();
    }
	
}

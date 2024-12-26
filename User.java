/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.system;

import javax.swing.JOptionPane;

/**
 *
 * @author yuanb
 */
public class User {
   private String name;
    private String userID;
    private String password;
    private double balance;

    public User(String name, String userID, String password) {
        this.name = name;
        this.userID = userID;
        this.password = password;
        this.balance = 0.0;
    }

    public String getName() {
        return name;
    }

    public String getUserID() {
        return userID;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            JOptionPane.showMessageDialog(null, "Deposit successful. New balance: " + balance);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            JOptionPane.showMessageDialog(null, "Withdrawal successful. New balance: " + balance);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid withdrawal amount or insufficient balance.");
        }
    }
}

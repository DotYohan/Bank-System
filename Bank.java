/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.system;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author yuanb
 */
public class Bank {
    private String adminID = "Admin";
    private String adminPassword = "WorldBankUno";
    private double BankReserves = 1000;
    private Map<String, User> users = new HashMap<>();

    public boolean authenticateAdmin(String adminID, String password) {
        return this.adminID.equals(adminID) && this.adminPassword.equals(password);
    }

    public void createUser(String name, String userID, String password) {
        if (!users.containsKey(userID)) {
            users.put(userID, new User(name, userID, password));
            JOptionPane.showMessageDialog(null, "User account created successfully.");
        } else {
            JOptionPane.showMessageDialog(null, "UserID already exists.");
        }
    }

    public User getUser(String userID) {
        return users.get(userID);
    }

    public void displayAllUsers() {
        StringBuilder info = new StringBuilder("User Information:\n");
        for (User user : users.values()) {
            info.append("Name: ").append(user.getName()).append(", UserID: ").append(user.getUserID()).append(", Balance: ").append(user.getBalance()).append("\n");
        }
        JOptionPane.showMessageDialog(null, info.toString());
    }

    public double getTotalMoney() {
        double userMoney = users.values().stream().mapToDouble(User::getBalance).sum();
        return userMoney + BankReserves ;
    }
}

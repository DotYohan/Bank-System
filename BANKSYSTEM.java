/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bank.system;

import javax.swing.JOptionPane;

/**
 *
 * @author yuanb
 */
public class BANKSYSTEM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bank bank = new Bank();

        while (true) {
            String choice = JOptionPane.showInputDialog("Welcome to World Bank"
                    + "\n===ATM==="
                    + "\n1. USER LOG IN"
                    + "\n2. BANK LOG IN");

            switch (choice) {
                case "1":
                    String userID = JOptionPane.showInputDialog("Enter User ID:");
                    String userPassword = JOptionPane.showInputDialog("Enter Password:");
                    User user = bank.getUser(userID);
                    if (user != null && user.authenticate(userPassword)) {
                        while (true) {
                            String userChoice = JOptionPane.showInputDialog("Welcome " + user.getName()
                                    + "\n1. Deposit Money"
                                    + "\n2. Withdraw Money"
                                    + "\n3. Check Balance"
                                    + "\n4. Log Out");
                            if (userChoice == null || userChoice.equals("4")) {
                                break;
                            }
                            switch (userChoice) {
                                case "1":
                                    double depositAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter amount to deposit:"));
                                    user.deposit(depositAmount);
                                    break;
                                case "2":
                                    double withdrawAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter amount to withdraw:"));
                                    user.withdraw(withdrawAmount);
                                    break;
                                case "3":
                                    JOptionPane.showMessageDialog(null, "Your balance: " + user.getBalance());
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Invalid choice.");
                                    break;
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid User ID or Password.");
                    }
                    break;
                case "2":
                    String adminID = JOptionPane.showInputDialog("Enter Admin ID:");
                    String adminPassword = JOptionPane.showInputDialog("Enter Password:");
                    if (bank.authenticateAdmin(adminID, adminPassword)) {
                        while (true) {
                            String adminChoice = JOptionPane.showInputDialog("Welcome Admin"
                                    + "\n1. View All Users"
                                    + "\n2. View Total Bank Money"
                                    + "\n3. Create User Account"
                                    + "\n4. Log Out");
                            if (adminChoice == null || adminChoice.equals("4")) {
                                break;
                            }
                            switch (adminChoice) {
                                case "1":
                                    bank.displayAllUsers();
                                    break;
                                case "2":
                                    JOptionPane.showMessageDialog(null, "Total Bank Money: " + bank.getTotalMoney());
                                    break;
                                case "3":
                                    String name = JOptionPane.showInputDialog("Enter User Name:");
                                    String newUserID = JOptionPane.showInputDialog("Enter User ID:");
                                    String newPassword = JOptionPane.showInputDialog("Enter Password:");
                                    bank.createUser(name, newUserID, newPassword);
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Invalid choice.");
                                    break;
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Admin ID or Password.");
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice.");
                    break;
            }
        }
    }
}

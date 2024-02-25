/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import dal.DBContext;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Tosaka
 */
public class Account extends DBContext {

    String AccountID;
    String Username;
    String Pass;
    String IsAdmin;

    public Account() {
        connectDB();
    }

    public Account(String Username, String Pass) {
        this.Username = Username;
        this.Pass = Pass;
        connectDB();
    }

    public Account(String AccountID, String Username, String Pass, String IsAdmin) {
        this.AccountID = AccountID;
        this.Username = Username;
        this.Pass = Pass;
        this.IsAdmin = IsAdmin;
        connectDB();
    }

    public String getAccountID() {
        return AccountID;
    }

    public void setAccountID(String AccountID) {
        this.AccountID = AccountID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public String getIsAdmin() {
        return IsAdmin;
    }

    public void setIsAdmin(String IsAdmin) {
        this.IsAdmin = IsAdmin;
    }
    Connection cnn;
    PreparedStatement stm;
    ResultSet rs;

    private void connectDB() {
        cnn = connection;
        if (cnn != null) {
            System.out.println("Connect success");
        } else {
            System.out.println("Connect fail");
        }
    }

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom random = new SecureRandom();

    public static String generateRandomPassword(int length) {
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }

        return sb.toString();
    }

    private String hashPassword(String password) {
        // Triển khai mã hóa mật khẩu của bạn tại đây
        return password;
    }

    public void resetPassword(Account account, int passwordLength) {
        String newRandomPassword = generateRandomPassword(passwordLength); 
        String newHashedPassword = hashPassword(newRandomPassword);

        try {
            String sql = "UPDATE accounts SET pass = ? WHERE accountID = ?";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, newHashedPassword);
            stm.setString(2, account.getAccountID());
            stm.executeUpdate();

            account.setPass(newHashedPassword);

            System.out.println("Mật khẩu đã được cập nhật thành công.");
        } catch (Exception e) {
            System.out.println("Lỗi khi cập nhật mật khẩu: " + e.getMessage());
        }
    }

}

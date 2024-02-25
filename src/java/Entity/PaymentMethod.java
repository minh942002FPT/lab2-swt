/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Tosaka
 */
public class PaymentMethod extends DBContext {
    String Method;
    String MethodName;

    public PaymentMethod() {
        connectDB();
    }

    public PaymentMethod(String Method, String MethodName) {
        this.Method = Method;
        this.MethodName = MethodName;
        connectDB();
    }

    public String getMethod() {
        return Method;
    }

    public void setMethod(String Method) {
        this.Method = Method;
    }

    public String getMethodName() {
        return MethodName;
    }

    public void setMethodName(String MethodName) {
        this.MethodName = MethodName;
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
}

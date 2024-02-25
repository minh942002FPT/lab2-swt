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
public class OrderItem extends DBContext {

    String OrderItemID;
    String AccountID;
    String OrderID;
    String FirstName;
    String LastName;
    String Phone;
    String Address;
    String City;
    String TotalPrice;
    String PaymentDate;
    String PaymentID;

    public OrderItem() {
        connectDB();
    }

    public OrderItem(String FirstName, String LastName, String Phone, String Address, String City) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Phone = Phone;
        this.Address = Address;
        this.City = City;
        connectDB();
    }
    

    public OrderItem(String OrderItemID, String AccountID, String OrderID, String FirstName, String LastName, String Phone, String Address, String City, String TotalPrice, String PaymentDate, String PaymentID) {
        this.OrderItemID = OrderItemID;
        this.AccountID = AccountID;
        this.OrderID = OrderID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Phone = Phone;
        this.Address = Address;
        this.City = City;
        this.TotalPrice = TotalPrice;
        this.PaymentDate = PaymentDate;
        this.PaymentID = PaymentID;
        connectDB();
    }

    public String getOrderItemID() {
        return OrderItemID;
    }

    public void setOrderItemID(String OrderItemID) {
        this.OrderItemID = OrderItemID;
    }

    public String getAccountID() {
        return AccountID;
    }

    public void setAccountID(String AccountID) {
        this.AccountID = AccountID;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(String TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    public String getPaymentDate() {
        return PaymentDate;
    }

    public void setPaymentDate(String PaymentDate) {
        this.PaymentDate = PaymentDate;
    }

    public String getPaymentID() {
        return PaymentID;
    }

    public void setPaymentID(String PaymentID) {
        this.PaymentID = PaymentID;
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

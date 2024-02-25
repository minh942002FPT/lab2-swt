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
public class Size extends DBContext {
    String SizeID;
    String SizeName;

    public Size() {
        connectDB();
    }

    public Size(String SizeID, String SizeName) {
        this.SizeID = SizeID;
        this.SizeName = SizeName;
        connectDB();
    }

    public String getSizeID() {
        return SizeID;
    }

    public void setSizeID(String SizeID) {
        this.SizeID = SizeID;
    }

    public String getSizeName() {
        return SizeName;
    }

    public void setSizeName(String SizeName) {
        this.SizeName = SizeName;
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

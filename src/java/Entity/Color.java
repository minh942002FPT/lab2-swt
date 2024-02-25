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
public class Color extends DBContext {

    String ColorID;
    String ColorName;

    public Color() {
        connectDB();
    }

    public Color(String ColorID, String ColorName) {
        this.ColorID = ColorID;
        this.ColorName = ColorName;
        connectDB();
    }

    public String getColorID() {
        return ColorID;
    }

    public void setColorID(String ColorID) {
        this.ColorID = ColorID;
    }

    public String getColorName() {
        return ColorName;
    }

    public void setColorName(String ColorName) {
        this.ColorName = ColorName;
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

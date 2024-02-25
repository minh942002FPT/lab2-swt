/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Tosaka
 */
public class Product extends DBContext {

    String ProductID;
    String ProductName;
    String ProductImage;
    String ProductPrice;
    String Title;
    String SizeID;
    String ColorID;
    String Description;
    String InStock;
    String CreateDate;
    String CategoryID;

    public Product() {
        connectDB();
    }

    public Product(String ProductID, String ProductName, String ProductImage, String ProductPrice, String InStock) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.ProductImage = ProductImage;
        this.ProductPrice = ProductPrice;
        this.InStock = InStock;
        connectDB();
    }
    

    public Product(String ProductID, String ProductName, String ProductImage, String ProductPrice, String Title, String Description) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.ProductImage = ProductImage;
        this.ProductPrice = ProductPrice;
        this.Title = Title;
        this.Description = Description;
        connectDB();
    }

    public Product(String ProductID, String ProductName, String ProductImage, String SizeID, String ColorID, String ProductPrice, String CategoryID) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.ProductImage = ProductImage;
        this.ProductPrice = ProductPrice;
        this.SizeID = SizeID;
        this.ColorID = ColorID;
        this.CategoryID = CategoryID;
        connectDB();
    }

    public Product(String ProductID, String ProductName, String ProductImage, String ProductPrice, String Title, String Description, String InStock, String CreateDate) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.ProductImage = ProductImage;
        this.ProductPrice = ProductPrice;
        this.Title = Title;
        this.Description = Description;
        this.InStock = InStock;
        this.CreateDate = CreateDate;
        connectDB();
    }
    
    public Product(String ProductName, String ProductImage, String ProductPrice, String Title, String SizeID, String ColorID, String Description, String InStock, String CreateDate, String CategoryID) {
        this.ProductName = ProductName;
        this.ProductImage = ProductImage;
        this.ProductPrice = ProductPrice;
        this.Title = Title;
        this.SizeID = SizeID;
        this.ColorID = ColorID;
        this.Description = Description;
        this.InStock = InStock;
        this.CreateDate = CreateDate;
        this.CategoryID = CategoryID;
        connectDB();
    }

    public Product(String ProductID, String ProductName, String ProductImage, String ProductPrice, String Title, String SizeID, String ColorID, String Description, String InStock, String CreateDate, String CategoryID) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.ProductImage = ProductImage;
        this.ProductPrice = ProductPrice;
        this.Title = Title;
        this.SizeID = SizeID;
        this.ColorID = ColorID;
        this.Description = Description;
        this.InStock = InStock;
        this.CreateDate = CreateDate;
        this.CategoryID = CategoryID;
        connectDB();
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getProductImage() {
        return ProductImage;
    }

    public void setProductImage(String ProductImage) {
        this.ProductImage = ProductImage;
    }

    public String getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(String ProductPrice) {
        this.ProductPrice = ProductPrice;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getSizeID() {
        return SizeID;
    }

    public void setSizeID(String SizeID) {
        this.SizeID = SizeID;
    }

    public String getColorID() {
        return ColorID;
    }

    public void setColorID(String ColorID) {
        this.ColorID = ColorID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getInStock() {
        return InStock;
    }

    public void setInStock(String InStock) {
        this.InStock = InStock;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String CreateDate) {
        this.CreateDate = CreateDate;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String CategoryID) {
        this.CategoryID = CategoryID;
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

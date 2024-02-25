/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Entity.Account;
import Entity.Cart;
import Entity.Category;
import Entity.Color;
import Entity.Item;
import Entity.OrderItem;
import Entity.PaymentMethod;
import Entity.Product;
import Entity.Size;
import dal.DBContext;
import java.security.SecureRandom;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Tosaka
 */
public class DAO extends DBContext {

    Connection cnn;
    PreparedStatement stm;
    ResultSet rs;

    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> list = new ArrayList<Product>();
        try {
            String strSQL = "Select * from Product ";
            cnn = connection;
            stm = cnn.prepareStatement(strSQL);
            rs = stm.executeQuery();
            while (rs.next()) {
                String productid = String.valueOf(rs.getInt(1));
                String productname = rs.getString(2);
                String productimage = rs.getString(3);
                String productprice = String.valueOf(rs.getFloat(4));
                String instock = String.valueOf(rs.getString(9));

                Product p = new Product(productid, productname, productimage, productprice, instock);
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println("getAllProduct: " + e.getMessage());
        }
        return list;
    }

    public ArrayList<Category> getAllCategory() {
        ArrayList<Category> list = new ArrayList<Category>();
        try {
            String strSQL = "Select * from Category ";
            cnn = connection;
            stm = cnn.prepareStatement(strSQL);
            rs = stm.executeQuery();
            while (rs.next()) {
                String categoryid = String.valueOf(rs.getInt(1));
                String categoryname = rs.getString(2);

                Category p = new Category(categoryid, categoryname);
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println("getAllCategory: " + e.getMessage());
        }
        return list;
    }

    public ArrayList<Product> getNewestProduct() {
        ArrayList<Product> list = new ArrayList<Product>();
        try {
            String strSQL = "select top 8 * from product order by CreateDate desc ";
            cnn = connection;
            stm = cnn.prepareStatement(strSQL);
            rs = stm.executeQuery();
            while (rs.next()) {
                String productid = String.valueOf(rs.getInt(1));
                String productname = rs.getString(2);
                String productimage = rs.getString(3);
                String productprice = String.valueOf(rs.getFloat(4));
                String title = rs.getString(5);
                String description = rs.getString(8);
                Product p = new Product(productid, productname, productimage, productprice, title, description);
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println("getNewestProduct: " + e.getMessage());
        }
        return list;
    }

    public ArrayList<Product> getTrandyProduct() {
        ArrayList<Product> list = new ArrayList<Product>();
        try {
            String strSQL = "select top 8 p.ProductID,p.ProductName,p.ProductImage,p.ProductPrice,p.Title,p.Description, count(od.ProductID) as c from Product p join OrderDetail od on p.ProductID=od.ProductID group by p.ProductID,p.ProductName,p.ProductImage,p.ProductPrice,p.Title,p.Description order by c desc ";
            cnn = connection;
            stm = cnn.prepareStatement(strSQL);
            rs = stm.executeQuery();
            while (rs.next()) {
                String productid = String.valueOf(rs.getInt(1));
                String productname = rs.getString(2);
                String productimage = rs.getString(3);
                String productprice = String.valueOf(rs.getFloat(4));
                String title = rs.getString(5);
                String description = rs.getString(6);
                Product p = new Product(productid, productname, productimage, productprice, title, description);
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println("getNewestProduct: " + e.getMessage());
        }
        return list;
    }

    public ArrayList<Product> getProductByCategoryID(String CategoryID) {
        ArrayList<Product> list = new ArrayList<Product>();
        try {
            String strSQL = "select * from Product where CategoryID = ? ";
            cnn = connection;
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, CategoryID);
            rs = stm.executeQuery();
            while (rs.next()) {
                String productid = String.valueOf(rs.getInt(1));
                String productname = rs.getString(2);
                String productimage = rs.getString(3);
                String productprice = String.valueOf(rs.getFloat(4));
                String title = rs.getString(5);
                String description = rs.getString(8);
                Product p = new Product(productid, productname, productimage, productprice, title, description);
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println("getProductByCategoryID: " + e.getMessage());
        }
        return list;
    }

    public ArrayList<Product> getNotProductByProductID(String ProductID) {
        ArrayList<Product> list = new ArrayList<Product>();
        try {
            String strSQL = "select * from Product where ProductID not in (?) ";
            cnn = connection;
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, ProductID);
            rs = stm.executeQuery();
            while (rs.next()) {
                String productid = String.valueOf(rs.getInt(1));
                String productname = rs.getString(2);
                String productimage = rs.getString(3);
                String productprice = String.valueOf(rs.getFloat(4));
                String title = rs.getString(5);
                String description = rs.getString(8);
                Product p = new Product(productid, productname, productimage, productprice, title, description);
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println("getNotProductByProductID: " + e.getMessage());
        }
        return list;
    }

    public Product getProductByProductID(String ProductID) {
        try {
            String strSQL = "select * from Product where ProductID = ? ";
            cnn = connection;
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, ProductID);
            rs = stm.executeQuery();
            while (rs.next()) {
                String productid = String.valueOf(rs.getInt(1));
                String productname = rs.getString(2);
                String productimage = rs.getString(3);
                String productprice = String.valueOf(rs.getFloat(4));
                String title = rs.getString(5);
                String description = rs.getString(8);
                Product p = new Product(productid, productname, productimage, productprice, title, description);
                return p;
            }
        } catch (Exception e) {
            System.out.println("getProductByProductID: " + e.getMessage());
        }
        return null;
    }

    public Product getAllProductDetailByProductID(String ProductID) {
        try {
            String strSQL = "select * from Product where ProductID = ? ";
            cnn = connection;
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, ProductID);
            rs = stm.executeQuery();
            while (rs.next()) {
                String productid = String.valueOf(rs.getInt(1));
                String productname = rs.getString(2);
                String productimage = rs.getString(3);
                String productprice = String.valueOf(rs.getFloat(4));
                String title = rs.getString(5);
                String sizeid = String.valueOf(rs.getInt(6));
                String colorid = String.valueOf(rs.getInt(7));
                String description = rs.getString(8);
                String instock = String.valueOf(rs.getInt(9));
                java.sql.Timestamp dateTime = rs.getTimestamp(10);

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                String createdate = dateFormat.format(dateTime);

                String categoryid = String.valueOf(rs.getInt(11));
                Product p = new Product(productid, productname, productimage, productprice, title, sizeid, colorid, description, instock, createdate, categoryid);
                return p;
            }
        } catch (Exception e) {
            System.out.println("getAllProductDetailByProductID: " + e.getMessage());
        }
        return null;
    }

    public ArrayList<Product> searchProductByName(String search) {
        ArrayList<Product> list = new ArrayList<Product>();
        try {
            String strSQL = "select * from Product where ProductName like ? ";
            cnn = connection;
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, "%" + search + "%");
            rs = stm.executeQuery();
            while (rs.next()) {
                String productid = String.valueOf(rs.getInt(1));
                String productname = rs.getString(2);
                String productimage = rs.getString(3);
                String productprice = String.valueOf(rs.getFloat(4));
                String title = rs.getString(5);
                String description = rs.getString(8);
                Product p = new Product(productid, productname, productimage, productprice, title, description);
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println("searchProductByName: " + e.getMessage());
        }
        return list;
    }

    public int getTotalProduct() {
        try {
            String strSQL = "select count(*) from Product ";
            cnn = connection;
            stm = cnn.prepareStatement(strSQL);
            rs = stm.executeQuery();
            while (rs.next()) {
                int totalProduct = rs.getInt(1);
                return totalProduct;
            }
        } catch (Exception e) {
            System.out.println("getTotalProduct: " + e.getMessage());
        }
        return 0;
    }

    public ArrayList<Product> pagingProduct(int page) {
        ArrayList<Product> list = new ArrayList<Product>();
        try {
            String strSQL = "select * from Product order by ProductID offset ? rows fetch next 9 rows only ";
            cnn = connection;
            stm = cnn.prepareStatement(strSQL);
            stm.setInt(1, (page - 1) * 9);
            rs = stm.executeQuery();
            while (rs.next()) {
                String productid = String.valueOf(rs.getInt(1));
                String productname = rs.getString(2);
                String productimage = rs.getString(3);
                String productprice = String.valueOf(rs.getFloat(4));
                String title = rs.getString(5);
                String description = rs.getString(8);
                Product p = new Product(productid, productname, productimage, productprice, title, description);
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println("pagingProduct: " + e.getMessage());
        }
        return list;
    }

    public Account Login(String user, String pass) {
        try {
            String strSQL = "select * from Account where Username = ? and Pass = ? ";
            cnn = connection;
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, user);
            stm.setString(2, pass);
            rs = stm.executeQuery();
            while (rs.next()) {
                String accountid = rs.getString(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String isadmin = rs.getString(4);
                Account p = new Account(accountid, username, password, isadmin);
                return p;
            }
        } catch (Exception e) {
            System.out.println("Login: " + e.getMessage());
        }
        return null;
    }

    public Account checkUser(String user) {
        try {
            String strSQL = "select * from Account where Username = ?";
            cnn = connection;
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, user);
            rs = stm.executeQuery();
            while (rs.next()) {
                String username = rs.getString(2);
                String password = rs.getString(3);

                Account p = new Account(username, password);
                return p;
            }
        } catch (Exception e) {
            System.out.println("checkUser: " + e.getMessage());
        }
        return null;
    }

    public Account signUp(String user, String pass) {
        try {
            String strSQL = "insert into Account values (?,?,0) ";
            cnn = connection;
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, user);
            stm.setString(2, pass);
            stm.executeUpdate();
            while (rs.next()) {
                String username = rs.getString(2);
                String password = rs.getString(3);

                Account p = new Account(username, password);
                return p;
            }
        } catch (Exception e) {
            System.out.println("signUp: " + e.getMessage());
        }
        return null;
    }

    public ArrayList<Product> pagingManageProduct(int page) {
        ArrayList<Product> list = new ArrayList<Product>();
        try {
            String strSQL = "select p.ProductID, p.ProductName, p.ProductImage, s.SizeName, c.ColorName, p.ProductPrice, cate.CategoryName from Product p join Category cate on p.CategoryID = cate.CategoryID join Color c on p.ColorID = c.ColorID join Size s on p.SizeID = s.SizeID order by p.ProductID offset ? rows fetch next 9 rows only ";
            cnn = connection;
            stm = cnn.prepareStatement(strSQL);
            stm.setInt(1, (page - 1) * 9);
            rs = stm.executeQuery();
            while (rs.next()) {
                String productid = String.valueOf(rs.getInt(1));
                String productname = rs.getString(2);
                String productimage = rs.getString(3);
                String sizeid = rs.getString(4);
                String colorid = rs.getString(5);
                String productprice = String.valueOf(rs.getFloat(6));
                String categoryid = rs.getString(7);
                Product p = new Product(productid, productname, productimage, sizeid, colorid, productprice, categoryid);
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println("pagingManageProduct: " + e.getMessage());
        }
        return list;
    }

    public void deleteProduct(String ProductID) {
        try {
            String strSQL = "delete from Product where ProductID = ? ";
            cnn = connection;
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, ProductID);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("deleteProduct: " + e.getMessage());
        }

    }

    public ArrayList<Size> getAllSize() {
        ArrayList<Size> list = new ArrayList<Size>();
        try {
            String strSQL = "Select * from Size ";
            cnn = connection;
            stm = cnn.prepareStatement(strSQL);
            rs = stm.executeQuery();
            while (rs.next()) {
                String sizeid = String.valueOf(rs.getInt(1));
                String sizename = rs.getString(2);

                Size p = new Size(sizeid, sizename);
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println("getAllSize: " + e.getMessage());
        }
        return list;
    }

    public ArrayList<Color> getAllColor() {
        ArrayList<Color> list = new ArrayList<Color>();
        try {
            String strSQL = "Select * from Color ";
            cnn = connection;
            stm = cnn.prepareStatement(strSQL);
            rs = stm.executeQuery();
            while (rs.next()) {
                String colorid = String.valueOf(rs.getInt(1));
                String colorname = rs.getString(2);

                Color p = new Color(colorid, colorname);
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println("getAllColor: " + e.getMessage());
        }
        return list;
    }

    public void addProduct(String ProductName, String ProductImage, String ProductPrice, String Title, String SizeID, String ColorID, String Description, String InStock, String CreateDate, String CategoryID) {
        try {
            String strSQL = "INSERT INTO Product (ProductName, ProductImage, ProductPrice, Title, SizeID, ColorID, [Description], Instock, CreateDate, CategoryID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            cnn = connection;
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, ProductName);
            stm.setString(2, ProductImage);
            stm.setFloat(3, Float.parseFloat(ProductPrice));
            stm.setString(4, Title);
            stm.setInt(5, Integer.parseInt(SizeID));
            stm.setInt(6, Integer.parseInt(ColorID));
            stm.setString(7, Description);
            stm.setInt(8, Integer.parseInt(InStock));

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date parsedDate = dateFormat.parse(CreateDate);
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());

            stm.setDate(9, sqlDate);
            stm.setInt(10, Integer.parseInt(CategoryID));
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("addProduct: " + e.getMessage());
        }
    }

    public void editProduct(String ProductName, String ProductImage, String ProductPrice, String Title, String SizeID, String ColorID, String Description, String InStock, String CreateDate, String CategoryID, String ProductID) {
        try {
            String strSQL = "Update Product set ProductName = ? , ProductImage = ? , ProductPrice = ? , Title = ? , SizeID = ? , ColorID  = ? , [Description] = ? , Instock = ? , CreateDate = ? , CategoryID  = ? where ProductID = ? ";
            cnn = connection;
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, ProductName);
            stm.setString(2, ProductImage);
            stm.setFloat(3, Float.parseFloat(ProductPrice));
            stm.setString(4, Title);
            stm.setInt(5, Integer.parseInt(SizeID));
            stm.setInt(6, Integer.parseInt(ColorID));
            stm.setString(7, Description);
            stm.setInt(8, Integer.parseInt(InStock));

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date parsedDate = dateFormat.parse(CreateDate);
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());

            stm.setDate(9, sqlDate);
            stm.setInt(10, Integer.parseInt(CategoryID));
            stm.setInt(11, Integer.parseInt(ProductID));
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("editProduct: " + e.getMessage());
        }
    }

    public ArrayList<PaymentMethod> getAllPaymentMethod() {
        ArrayList<PaymentMethod> list = new ArrayList<PaymentMethod>();
        try {
            String strSQL = "Select * from PaymentMethod ";
            cnn = connection;
            stm = cnn.prepareStatement(strSQL);
            rs = stm.executeQuery();
            while (rs.next()) {
                String method = String.valueOf(rs.getInt(1));
                String methodname = rs.getString(2);

                PaymentMethod p = new PaymentMethod(method, methodname);
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println("getAllPaymentMethod: " + e.getMessage());
        }
        return list;
    }

    public void addOrder(Account a, Cart cart, String firstname, String lastname, String phone, String address, String city, String paymentmethod) {
        LocalDateTime curDateTime = LocalDateTime.now();
        String paymentdate = curDateTime.toString();
        try {

            String strSQL = "insert into OrderDetail values(?, ?, ?) ";
            cnn = connection;
            stm = cnn.prepareStatement(strSQL);

            for (Item item : cart.getItems()) {
                stm.setInt(1, Integer.parseInt(item.getProduct().getProductID()));
                stm.setInt(2, item.getQuantity());
                stm.setFloat(3, item.getPrice());
                stm.executeUpdate();
            }

            String strSQL2 = "select OrderID from OrderDetail order by OrderID desc ";
            stm = cnn.prepareStatement(strSQL2);
            rs = stm.executeQuery();

            int totalQuantity = cart.getItems().size();
            int count = 0;

            while (rs.next() && count < totalQuantity) {
                int orderid = rs.getInt("OrderID");
                String strSQL3 = "INSERT INTO OrderItem (AccountID, OrderID, FirstName, LastName, Phone, Address, City, TotalPrice, PaymentDate , PaymentMethod) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
                stm = cnn.prepareStatement(strSQL3);
                stm.setInt(1, Integer.parseInt(a.getAccountID()));
                stm.setInt(2, orderid);
                stm.setString(3, firstname);
                stm.setString(4, lastname);
                stm.setString(5, phone);
                stm.setString(6, address);
                stm.setString(7, city);
                stm.setFloat(8, cart.getTotalMoney());
                stm.setString(9, paymentdate);
                stm.setInt(10, Integer.parseInt(paymentmethod));
                stm.executeUpdate();
                count++;

            }

            String strSQL4 = "update Product set Instock = Instock - ? where ProductID = ? ";
            stm = cnn.prepareStatement(strSQL4);
            for (Item item : cart.getItems()) {
                stm.setInt(1, item.getQuantity());
                stm.setInt(2, Integer.parseInt(item.getProduct().getProductID()));
                stm.executeUpdate();
            }

        } catch (Exception e) {
            System.out.println("addOrder: " + e.getMessage());
        }

    }

    public OrderItem getAddress(String AccountID) {
        try {
            String strSQL = "select top 1 * from OrderItem where AccountID = ? order by OrderItemID desc ";
            cnn = connection;
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, AccountID);
            rs = stm.executeQuery();
            while (rs.next()) {
                String firstname = rs.getString(4);
                String lastname = rs.getString(5);
                String phone = rs.getString(6);
                String address = rs.getString(7);
                String city = rs.getString(8);
 
                OrderItem p = new OrderItem(firstname, lastname, phone, address, city);
                return p;
            }
        } catch (Exception e) {
            System.out.println("getAddress: " + e.getMessage());
        }
        return null;

    }

}

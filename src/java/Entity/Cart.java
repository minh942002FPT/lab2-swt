/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.ArrayList;

/**
 *
 * @author Tosaka
 */
public class Cart {

    ArrayList<Item> items;

    public Cart() {
        items = new ArrayList<>();

    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public Item getItemById(int id) {
        for (Item i : items) {
            if (Integer.parseInt(i.getProduct().getProductID()) == id) {
                return i;
            }
        }
        return null;
    }

    public int getQuantityById(int id) {
        return getItemById(id).getQuantity();
    }

    public void addItem(Item t) {
        if (getItemById(Integer.parseInt(t.getProduct().getProductID())) != null) {
            Item m = getItemById(Integer.parseInt(t.getProduct().getProductID()));
            m.setQuantity(m.getQuantity() + t.getQuantity());
        } else {
            items.add(t);
        }
    }

    public void removeItem(int id) {
        if (getItemById(id) != null) {
            items.remove(getItemById(id));
        }
    }

    public float getTotalMoney() {
        float t = 0;
        for (Item i : items) {
            t += (i.getQuantity() * i.getPrice());
        }
        return t;
    }

    public Product getProductById(int id, ArrayList<Product> list) {
        for (Product i : list) {
            if (Integer.parseInt(i.getProductID()) == id) {
                return i;
            }
        }
        return null;
    }

    public Cart(String txt, ArrayList<Product> list) {
        items = new ArrayList<>();
        try {
            if (txt != null && txt.length() != 0) {
                String[] s = txt.split("-");
                for (String i : s) {
                    String[] n = i.split(":");
                    int productid = Integer.parseInt(n[0]);
                    int quantity = Integer.parseInt(n[1]);
                    Product p = getProductById(productid, list);
                    Item t = new Item(p, quantity, Float.parseFloat(p.getProductPrice()));
                    addItem(t);
                }
            }
        } catch (Exception e) {
            System.out.println("Cart: " + e.getMessage());
        }
    }

    public int getTotalQuantity() {
        int totalQuantity = 0;
        for (Item item : items) {
            totalQuantity += item.getQuantity();
        }
        return totalQuantity;
    }

}

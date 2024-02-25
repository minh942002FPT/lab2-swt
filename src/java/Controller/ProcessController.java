/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.DAO;
import Entity.Cart;
import Entity.Item;
import Entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author Tosaka
 */
public class ProcessController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProcessController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProcessController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            DAO dao = new DAO();
            ArrayList<Product> listCart = dao.getAllProduct();
            Cookie[] arr = request.getCookies();
            String txt="";
            if(arr!=null){
                for(Cookie o: arr){
                    if(o.getName().equals("cart")){
                        txt += o.getValue();
                        o.setMaxAge(0);
                        response.addCookie(o);
                    }
                }
            }
            Cart cart= new Cart(txt, listCart);
            
            int num = Integer.parseInt(request.getParameter("num"));
            int productid = Integer.parseInt(request.getParameter("productID"));
            
            try{
                Product p = dao.getAllProductDetailByProductID(String.valueOf(productid));
                int instock = Integer.parseInt(p.getInStock());
                if(num == -1 && (cart.getQuantityById(productid)<= 1) ){
                    cart.removeItem(productid);
                }else{
                    if(num == 1 && (cart.getQuantityById(productid)>=instock) ){
                        num=0;
                    }
                    float price = Float.parseFloat(p.getProductPrice());
                    Item t = new Item(p, num, price);
                    cart.addItem(t);
                }
                
            }catch(Exception e){
                System.out.println("ProcessController: " + e.getMessage());
            }
            ArrayList<Item> items = cart.getItems();
            txt="";
            if(items.size()>0){
                txt=items.get(0).getProduct().getProductID()+":"+items.get(0).getQuantity();
                for(int i =1; i<items.size();i++){
                    txt += "-"+items.get(i).getProduct().getProductID()+":"+items.get(i).getQuantity();
                }
            }
            
            Cookie c= new Cookie("cart", txt);
            c.setMaxAge(2*24*60*60);
            response.addCookie(c);
            request.setAttribute("cart", cart);
            
            request.setAttribute("activePage", "cart");
            request.getRequestDispatcher("cart.jsp").forward(request, response);
            
            
            
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            DAO dao = new DAO();
            ArrayList<Product> listCart = dao.getAllProduct();
            Cookie[] arr = request.getCookies();
            String txt="";
            if(arr!=null){
                for(Cookie o: arr){
                    if(o.getName().equals("cart")){
                        txt += o.getValue();
                        o.setMaxAge(0);
                        response.addCookie(o);
                    }
                }
            }
            
            String productid= request.getParameter("productID");
            String[] ids = txt.split("-");
            String outCookie = "";
            for (int i =0 ; i < ids.length ; i++){
                String[] s =ids[i].split(":");
                if(!s[0].equals(productid)){
                    if(outCookie.isEmpty()){
                        outCookie = ids[i];
                    }
                    else{
                        outCookie +="-"+ids[i];
                    }
                }
            }
            
            if(!outCookie.isEmpty()){
                Cookie c = new Cookie("cart", outCookie);
                c.setMaxAge(2*24*60*60);
                response.addCookie(c);
            }
            
            Cart cart = new Cart(outCookie, listCart);
            request.setAttribute("cart", cart);
            request.setAttribute("activePage", "cart");
            request.getRequestDispatcher("cart.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

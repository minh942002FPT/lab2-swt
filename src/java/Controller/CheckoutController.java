/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.DAO;
import Entity.Account;
import Entity.Cart;
import Entity.Category;
import Entity.Item;
import Entity.OrderItem;
import Entity.PaymentMethod;
import Entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author Tosaka
 */
public class CheckoutController extends HttpServlet {

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
            out.println("<title>Servlet CheckoutController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckoutController at " + request.getContextPath() + "</h1>");
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
            ArrayList<PaymentMethod> listPaymentMethod = dao.getAllPaymentMethod();
            ArrayList<Category> listCategory = dao.getAllCategory();

            ArrayList<Product> listCart = dao.getAllProduct();
            Cookie[] arr = request.getCookies();
            String txt = "";
            if (arr != null) {
                for (Cookie o : arr) {
                    if (o.getName().equals("cart")) {
                        txt += o.getValue();
                    }
                }
            }
            Cart cart = new Cart(txt, listCart);
            HttpSession session = request.getSession();
            Account a = (Account) session.getAttribute("acc");
            if (a != null) {
                OrderItem addressAcc = dao.getAddress(a.getAccountID());
                request.setAttribute("addressAcc", addressAcc);
            }
            int sizeCart = cart.getItems().size();
            if (sizeCart <= 0) {
                response.sendRedirect("showcontroller");
            } else {
                ArrayList<Item> listItem = cart.getItems();
                int n = 0;
                if (listItem != null) {
                    n = listItem.size();
                }

                request.setAttribute("size", n);
                request.setAttribute("cart", cart);

                request.setAttribute("listCategory", listCategory);
                request.setAttribute("listPaymentMethod", listPaymentMethod);
                request.setAttribute("activePage", "checkout");
                request.getRequestDispatcher("checkout.jsp").forward(request, response);
            }

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
            String firstname = request.getParameter("FirstName");
            String lastname = request.getParameter("LastName");
            String phone = request.getParameter("Phone");
            String address = request.getParameter("Address");
            String city = request.getParameter("City");
            String paymentmethod = request.getParameter("PaymentMethod");

            DAO dao = new DAO();
            ArrayList<Product> listCart = dao.getAllProduct();
            Cookie[] arr = request.getCookies();
            String txt = "";
            if (arr != null) {
                for (Cookie o : arr) {
                    if (o.getName().equals("cart")) {
                        txt += o.getValue();
                    }
                }
            }
            Cart cart = new Cart(txt, listCart);

            HttpSession session = request.getSession();
            Account a = (Account) session.getAttribute("acc");
            if (a == null) {
                response.sendRedirect("login.jsp");
            } else {
                OrderItem addressAcc = dao.getAddress(a.getAccountID());
                request.setAttribute("addressAcc", addressAcc);
                dao.addOrder(a, cart, firstname, lastname, phone, address, city, paymentmethod);
                Cookie c = new Cookie("cart", "");
                c.setMaxAge(0);
                response.addCookie(c);
                response.sendRedirect("shopcontroller");
            }

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

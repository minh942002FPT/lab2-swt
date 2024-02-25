/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.DAO;
import Entity.Category;
import Entity.Color;
import Entity.Product;
import Entity.Size;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tosaka
 */
public class EditController extends HttpServlet {

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
            out.println("<title>Servlet EditController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditController at " + request.getContextPath() + "</h1>");
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

            ArrayList<Category> listCategory = dao.getAllCategory();   
            ArrayList<Size> listSize = dao.getAllSize();
            ArrayList<Color> listColor = dao.getAllColor();
            
            String productid = request.getParameter("productID");
            Product p = dao.getAllProductDetailByProductID(productid);
            
            System.out.println(productid);

            request.setAttribute("p", p);
            request.setAttribute("listCategory", listCategory);
            request.setAttribute("listSize", listSize);
            request.setAttribute("listColor", listColor);
                        
            request.getRequestDispatcher("editproduct.jsp").forward(request, response);
            
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
            String productid = request.getParameter("productID");
            String productname = request.getParameter("productName");
            String productimage = request.getParameter("productImage");
            String productprice = request.getParameter("productPrice");
            String title = request.getParameter("Title");
            String sizeid = request.getParameter("sizeID");
            String colorid = request.getParameter("colorID");
            String description = request.getParameter("description");
            String instock = request.getParameter("inStock");
            String createdate = request.getParameter("createDate");
            String categoryid = request.getParameter("categoryID");

            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            Date date = inputFormat.parse(createdate);
            String formattedDate = outputFormat.format(date);

            DAO dao = new DAO();
            dao.editProduct(productname, productimage, productprice, title, sizeid, colorid, description, instock, formattedDate, categoryid, productid);
            response.sendRedirect("managecontroller");
            
        } catch (ParseException ex) {
            Logger.getLogger(EditController.class.getName()).log(Level.SEVERE, null, ex);
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

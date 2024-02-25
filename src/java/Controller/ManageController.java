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
import java.util.ArrayList;

/**
 *
 * @author Tosaka
 */
public class ManageController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ManageController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManageController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
            
            String indexPage = request.getParameter("page");
            
            if (indexPage == null) {
                indexPage = "1";
            }

            int page = Integer.parseInt(indexPage);  
            
            DAO dao = new DAO();
            int count = dao.getTotalProduct();
            int endPage = count / 9;
            if (endPage % 9 != 0) {
                endPage++;
            }
            
            ArrayList<Product> list = dao.pagingManageProduct(page);
            ArrayList<Category> listCategory = dao.getAllCategory();   
            ArrayList<Size> listSize = dao.getAllSize();
            ArrayList<Color> listColor = dao.getAllColor();

            request.setAttribute("listProduct", list);
            request.setAttribute("listCategory", listCategory);
            request.setAttribute("listSize", listSize);
            request.setAttribute("listColor", listColor);
            request.setAttribute("endPage", endPage);
            request.setAttribute("activePage", "manageproduct");
            
            request.getRequestDispatcher("manageproduct.jsp").forward(request, response);
        }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
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
        
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

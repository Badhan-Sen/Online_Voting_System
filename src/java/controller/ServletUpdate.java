/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import votingsys.entity.Voterdatarc;
import votingsys.entity.Voterdetails;

/**
 *
 * @author king
 */
public class ServletUpdate extends HttpServlet {

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
        PrintWriter out=response.getWriter();  
          
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String dofb = request.getParameter("dofb");
        String address = request.getParameter("address");
        int mobile = Integer.parseInt(request.getParameter("mobile"));
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
  
        Voterdetails d=new Voterdetails(); 
        d.setId(id);
        d.setName(name);
        d.setGender(gender);
        d.setDofb(dofb);
        d.setAddress(address);
        d.setMobile(mobile);
        d.setEmail(email);
        d.setPass(pass);
          
        int status=Voterdatarc.update(d);  
        if(status>0){  
            out.println("<p>Records updated</p>");  
            request.getRequestDispatcher("servletlogin").include(request, response);
        }else{  
            out.println("<p>Sorry! Records not updated</p>");  
            request.getRequestDispatcher("servletedit").include(request, response);
        }  
          
        out.close();
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
        processRequest(request, response);
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
        processRequest(request, response);
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

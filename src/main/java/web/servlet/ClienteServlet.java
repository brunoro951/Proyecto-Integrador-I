/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.servlet;

import dao.DaoCliente;
import dao.impl.DaoClienteImpl;
import dto.Cliente;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import web.validator.ClienteValidator;

@WebServlet(name = "ClienteServlet", urlPatterns = {"/Cliente"})
public class ClienteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        accion = (accion == null) ? "" : accion;
        String result = null;
        String target = "clienteSel.jsp";
        Cliente user=null;
        DaoCliente dao=new DaoClienteImpl();
        ClienteValidator validator = new ClienteValidator(request);

        switch (accion) {
            case "login":
                
                String user1=new String(request.getParameter("txtuser").getBytes("ISO-8859-1"),"UTF-8");
                String pass=new String(request.getParameter("txtpass").getBytes("ISO-8859-1"),"UTF-8");
                user=dao.login(user1, pass);
                result=dao.getMensaje();
                if(result==null){
                    request.setAttribute("usuariooo", user);
                    target="menu_cliente.jsp";
                }else{
                    
                    target="login.jsp";
                }
                
                break;
            case "SEL":
                result = validator.clienteSel();
                break;
            case "INS":
                
                result = validator.clienteInsUpd(false);
                target = result == null ? "cliente.jsp" : "clienteIns.jsp";
                break;
            case "DEL":
                result = validator.clienteDel();
                target = "cliente.jsp";
                break;
            case "GET":
                result = validator.clienteGet();
                target = "clienteUpd.jsp";
                break;
            case "UPD":
                result = validator.clienteInsUpd(true);
                target = result == null ? "cliente.jsp" : "clienteUpd.jsp";
                break;
            case "":
                result = "Solicitud requerida";
                break;
            default:
                result = "Solicitud no reconocida";
        }
        if (result != null) {
            request.setAttribute("mensaje", result);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(target);
        dispatcher.forward(request, response);
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

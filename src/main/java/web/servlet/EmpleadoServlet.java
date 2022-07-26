package web.servlet;

import dao.DaoEmpleado;
import dao.impl.DaoEmpleadoImpl;
import dto.Empleado;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.validator.EmpleadoValidator;

@WebServlet(name = "EmpleadoServlet", urlPatterns = {"/Empleado"})
public class EmpleadoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        accion = (accion == null) ? "" : accion;
        String result = null;
        String target = "empleadoSel.jsp";
        EmpleadoValidator validator = new EmpleadoValidator(request);
        Empleado user= null;
        DaoEmpleado dao =new DaoEmpleadoImpl();
        switch (accion) {
            case "SEL":
                result = validator.EmpleadoSel();
                break;
            case "INS":
                
                result = validator.EmpleadoInsUpd(false);
                target = result == null ? "empleado.jsp" : "empleadoIns.jsp";
                break;
            case "DEL":
                result = validator.EmpleadoDel();
                target = "empleado.jsp";
                break;
            case "GET":
                result = validator.EmpleadoGet();
                target = "empleadoUpd.jsp";
                break;
            case "UPD":
                
                result = validator.EmpleadoInsUpd(true);
                target = result == null ? "empleado.jsp" : "empleadoUpd.jsp";
                break;
            case "login":
                
                String user1=new String(request.getParameter("user").getBytes("ISO-8859-1"),"UTF-8");
                String pass=new String(request.getParameter("pass").getBytes("ISO-8859-1"),"UTF-8");
                user=dao.login(user1, pass);
                result=dao.getMensaje();
                
                if(result==null && user.getTipo().equals("empleado")&&user.getEstado().equals("1")){
                    target="Cliente?accion=SEL";
                }
                else if(result==null && user.getTipo().equals("admin")&&user.getEstado().equals("1")){
                    request.setAttribute("empleado",user);
                    target="Principal.jsp";
                }
                else{
                    target="login_intranet.jsp";
                }
                
                
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

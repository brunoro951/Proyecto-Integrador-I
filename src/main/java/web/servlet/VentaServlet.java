/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.servlet;

import dto.Venta;
import dao.impl.VentaDAO;
import dto.Cliente;
import dao.DaoCliente;
import dao.impl.DaoClienteImpl;
import dto.Empleado;
import dto.Producto;
import dao.DaoProducto;
import dao.impl.DaoProductoImpl;
import util.GenerarSerie;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.validator.ClienteValidator;

/**
 *
 * @author marlo
 */
@WebServlet(name = "VentaServlet", urlPatterns = {"/Controlador"})
public class VentaServlet extends HttpServlet {

    //Empleado em = new Empleado();
    //EmpleadoDAO edao = new EmpleadoDAO();
    int ide;

    Empleado empleadoo = new Empleado();

    Cliente cm = new Cliente();
    //daoCliente cdao = new daoCliente();
    DaoCliente daoCliente;

    int cde;

    Producto pm = new Producto();
    //ProductoDAO pdao = new ProductoDAO();
    DaoProducto daoProducto;
    int pde;

    Venta v = new Venta();
    List<Venta> lista = new ArrayList<>();
    int item;
    int cod;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalPagar;
    int mesa=1;
    String mensaje;
    String numeroserie;
    VentaDAO vdao = new VentaDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ClienteValidator validator = new ClienteValidator(request);
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("NuevaVenta")) {
            switch (accion) {
                case "BuscarEmpleado":
                    Integer cod = Integer.valueOf(request.getParameter("codigoempleado"));
                    empleadoo.setId(cod);
                    empleadoo = vdao.empleadoBuscar(cod);//daoCliente.clienteBuscar(dni);
                    if (empleadoo.getNom() == null) {
                        request.setAttribute("mensaje", "Codigo de Empleado no encontrado");
                    }
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("d", empleadoo);
                    request.setAttribute("mesaa", mesa);
                    break;

                case "BuscarCliente":
                    String dni = request.getParameter("codigocliente");
                    cm.setDocumento(dni);
                    cm = vdao.clienteBuscar(dni);//daoCliente.clienteBuscar(dni);
                    if (cm.getNombre() == null) {
                        request.setAttribute("mensaje", "Codigo de Cliente no encontrado");
                    }
                    
                    request.setAttribute("d", empleadoo);
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("c", cm);
                    request.setAttribute("mesaa", mesa);
                    break;
                case "BuscarProducto":
                    int id = Integer.parseInt(request.getParameter("codigoproducto"));
                    pm = vdao.listarrId(id);
                    if (pm.getNombre() == null) {
                        request.setAttribute("mensaje", "Codigo de Producto no encontrado");
                    }
                    mesa = Integer.parseInt(request.getParameter("txtmesa"));
                    request.setAttribute("mesaa", mesa);
                    request.setAttribute("d", empleadoo);
                    request.setAttribute("c", cm);
                    request.setAttribute("producto", pm);
                    request.setAttribute("lista", lista);
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("totalpagar", totalPagar);
                    break;
                case "Agregar":
                    request.setAttribute("d", empleadoo);
                    request.setAttribute("c", cm);
                    totalPagar = 0.0;
                    item = item + 1;
                    cod = pm.getId_producto();
                    descripcion = request.getParameter("nomproducto");
                    mesa = Integer.parseInt(request.getParameter("txtmesa"));
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cant = Integer.parseInt(request.getParameter("cant"));
                    subtotal = precio * cant;
                    v = new Venta();
                    v.setItem(item);
                    v.setIdproducto(cod);
                    v.setMesa_id(mesa);
                    v.setDescripcionP(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cant);
                    v.setSubtotal(subtotal);
                    lista.add(v);
                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar = totalPagar + lista.get(i).getSubtotal();
                    }
                    request.setAttribute("mesaa", mesa);
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("lista", lista);
                    break;
                case "GenerarVenta":

                    for (int i = 0; i < lista.size(); i++) {
                        Producto pr = new Producto();
                        int cantidad = lista.get(i).getCantidad();
                        int idproducto = lista.get(i).getIdproducto();

                        VentaDAO a0 = new VentaDAO();
                        pr = a0.buscarr(idproducto);
                        int sac = pr.getStock() - cantidad;
                        a0.actualizarstock(idproducto, sac);
                    }

                    //generar venta
                    java.util.Date ahora = new java.util.Date();
                    SimpleDateFormat formateador = new SimpleDateFormat("yyyy/MM/dd");
                    v.setIdcliente(cm.getId_cliente());
                    v.setIdempleado(empleadoo.getId());
                    v.setMesa_id(mesa);
                    v.setTipo("Compra Presencial");
                    v.setNumserie(numeroserie);
                    v.setFecha(formateador.format(ahora));
                    v.setMonto(totalPagar);
                    v.setEstado("1");
                    vdao.guardarVenta(v);

                    int idv = Integer.parseInt(vdao.IdVentas());
                    for (int i = 0; i < lista.size(); i++) {
                        v = new Venta();
                        v.setId(idv);
                        v.setIdproducto(lista.get(i).getIdproducto());
                        v.setCantidad(lista.get(i).getCantidad());
                        v.setPrecio(lista.get(i).getPrecio());
                        v.setEstado("1");
                        vdao.GuardarDetalleventas(v);
                    }
                    if (cm.getId_cliente() == null) {
                        request.setAttribute("mensaje", "Se debe introducir el DNI del cliente");
                    }
                    request.getRequestDispatcher("Controlador?menu=NuevaVenta&accion=default&&mesa="+mesa).forward(request, response);
                    break;

                default:
                    v = new Venta();
                    lista = new ArrayList<>();
                    item = 0;
                    totalPagar = 0.0;
                    mesa=1;
                    numeroserie = vdao.GenerarSerie();
                    if (numeroserie == null) {
                        numeroserie = "00000001";
                        request.setAttribute("nserie", numeroserie);
                    } else {
                        int incrementar = Integer.parseInt(numeroserie);
                        GenerarSerie gs = new GenerarSerie();
                        numeroserie = gs.NumeroSerie(incrementar);
                        request.setAttribute("nserie", numeroserie);
                    }
                    request.setAttribute("mesaa", mesa);
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }

            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
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

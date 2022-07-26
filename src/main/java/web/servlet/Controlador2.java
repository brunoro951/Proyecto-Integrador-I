/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web.servlet;

import dao.DaoCliente;
import dao.DaoProducto;
import dao.impl.DaoClienteImpl;
import dao.impl.DaoProductoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dto.Carrito;
import dto.Cliente;
import dto.Compra;
import dto.Producto;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author marlo
 */
@WebServlet(name = "Controlador2", urlPatterns = {"/Controlador2"})
public class Controlador2 extends HttpServlet {

    DaoProducto pdao = new DaoProductoImpl();
    Producto p = new Producto();
    List<Producto> productos = new ArrayList<>();
    Cliente c= new Cliente();
    DaoCliente cdao=new DaoClienteImpl();
    List<Carrito> listaCarrito = new ArrayList<>();
    int item;
    double totalpagar = 0.0;
    int cantidad = 1;

    int idp;
    Carrito car;
    String date="";
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        String id = request.getParameter("id");
        c=cdao.clienteBuscar(id);
        productos = pdao.listar();
        switch (accion) {
            case "Comprar":
                totalpagar = 0.0;
                idp = Integer.parseInt(request.getParameter("id"));
                p = pdao.listarId(idp);
                item = item + 1;
                Carrito car = new Carrito();
                car.setItem(item);
                car.setIdproducto(p.getId_producto());
                car.setNombres(p.getNombre());
                car.setDescripcion(p.getDescripcion());
                car.setPrecioCompra(p.getPrecio());
                car.setCantidad(cantidad);
                car.setSubTotal(cantidad * p.getPrecio());
                listaCarrito.add(car);
                for (int i = 0; i < listaCarrito.size(); i++) {
                    totalpagar = totalpagar + listaCarrito.get(i).getSubTotal();
                }
                request.setAttribute("Totalpagar", totalpagar);
                request.setAttribute("carrito", listaCarrito);
                request.setAttribute("contador", listaCarrito.size());
                request.getRequestDispatcher("carrito.jsp").forward(request, response);
                break;
            case "AgregarCarrito":
                int pos = 0;
                cantidad = 1;
                idp = Integer.parseInt(request.getParameter("id"));
                if (listaCarrito.size() > 0) {
                    for (int i = 0; i < listaCarrito.size(); i++) {
                        if (idp == listaCarrito.get(i).getIdproducto()) {
                            pos = i;
                        }
                    }
                    if (idp == listaCarrito.get(pos).getIdproducto()) {
                        cantidad = listaCarrito.get(pos).getCantidad() + cantidad;
                        double subtotal = listaCarrito.get(pos).getPrecioCompra() * cantidad;
                        listaCarrito.get(pos).setCantidad(cantidad);
                        listaCarrito.get(pos).setSubTotal(subtotal);
                    } else {
                        p = pdao.listarId(idp);
                        item = item + 1;
                        car = new Carrito();
                        car.setItem(item);
                        car.setIdproducto(p.getId_producto());
                        car.setNombres(p.getNombre());
                        car.setDescripcion(p.getDescripcion());
                        car.setPrecioCompra(p.getPrecio());
                        car.setCantidad(cantidad);
                        car.setSubTotal(cantidad * p.getPrecio());
                        listaCarrito.add(car);
                    }
                } else {
                    p = pdao.listarId(idp);
                    item = item + 1;
                    car = new Carrito();
                    car.setItem(item);
                    car.setIdproducto(p.getId_producto());
                    car.setNombres(p.getNombre());
                    car.setDescripcion(p.getDescripcion());
                    car.setPrecioCompra(p.getPrecio());
                    car.setCantidad(cantidad);
                    car.setSubTotal(cantidad * p.getPrecio());
                    listaCarrito.add(car);
                }
                request.setAttribute("contador", listaCarrito.size());
                request.getRequestDispatcher("Controlador2?accion=home").forward(request, response);
                break;
            case "Delete":
                int idproducto = Integer.parseInt(request.getParameter("idp"));
                for (int i = 0; i < listaCarrito.size(); i++) {
                    if (listaCarrito.get(i).getItem() == idproducto) {
                        listaCarrito.remove(i);
                    }
                }

                request.getRequestDispatcher("Controlador2?accion=Carrito").forward(request, response);
                break;
            case "ActualizarCantidad":
                int idpro = Integer.parseInt(request.getParameter("idp"));
                int cant = Integer.parseInt(request.getParameter("Cantidad"));
                for (int i = 0; i < listaCarrito.size(); i++) {
                    if (listaCarrito.get(i).getIdproducto() == idpro) {
                        listaCarrito.get(i).setCantidad(cant);
                        double st = listaCarrito.get(i).getPrecioCompra() * cant;
                        listaCarrito.get(i).setSubTotal(st);
                    }
                }
                break;
            case "GenerarCompra":
                totalpagar=00.00;
                LocalDate todaysDate = LocalDate.now();
                date=""+todaysDate;
                Cliente cliente=new Cliente();
//                cliente.setId(1);
//                CompraDAO dao= new CompraDAO();
                Compra compra=new Compra(cliente,1, "holaaa", 52.0,"Cancelado", listaCarrito);
//                int res=dao.GenerarCompra(compra);
//                if(res!=0){
//                    request.getRequestDispatcher("index.jsp").forward(request, response);
//                }else{
//                    request.getRequestDispatcher("vistas/mensaje.jsp").forward(request, response);
//                }
                break;
            case "Carrito":
                totalpagar = 0.0;
                request.setAttribute("carrito", listaCarrito);
                for (int i = 0; i < listaCarrito.size(); i++) {
                    totalpagar = totalpagar + listaCarrito.get(i).getSubTotal();
                }
                request.setAttribute("Totalpagar", totalpagar);
                request.getRequestDispatcher("carrito.jsp").forward(request, response);
                break;
            default:
                request.setAttribute("usuariooo", c);
                request.setAttribute("productos", productos);
                request.getRequestDispatcher("menu_cliente.jsp").forward(request, response);
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

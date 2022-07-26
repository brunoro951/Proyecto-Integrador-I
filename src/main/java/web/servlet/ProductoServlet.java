package web.servlet;

import dao.DaoProducto;
import dao.impl.DaoProductoImpl;
import dto.Producto;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import web.validator.ProductoValidator;

@MultipartConfig
@WebServlet(name = "ProductoServlet", urlPatterns = {"/Producto"})
public class ProductoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DaoProducto daoProducto = new DaoProductoImpl();
        //Inicializar variables
        //La variable "acción" es lo que debe hacer el servet
        //la accion es la que va indicar que va hacer el servlet y se obtener por un parametro también llamado accion.
        String accion = request.getParameter("accion");
        // si la accion es nula manda comillas y sino a la acción que se envía.

        if ("IMG".equals(accion)) {
            response.setContentType("image/jpg");
            Integer id_proveedor = Integer.parseInt(request.getParameter("id_producto"));
            try {
                byte[] data = daoProducto.Foto(id_proveedor);
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                output.write(data, 0, data.length);
                response.setContentLength(output.size());
                try ( OutputStream out = response.getOutputStream()) {
                    output.writeTo(out);
                    out.flush();
                }
            } catch (IOException ex) {
                System.err.println(String.format("%s - %s", daoProducto.getMensaje(), ex.getMessage()));
            }
        } else {
            accion = (accion == null) ? "" : accion;
            //variable tipo resultado que es nulo que indica que va bien
            String result = null;
            //Tendremos un variable objetivo que se llama "target que va apuntar a la pagina indicada"
            String target = "productoSel.jsp";
            //El parametro que requiere el validator es tipo httpservletrequest.
            ProductoValidator validator = new ProductoValidator(request);

            switch (accion) {
                case "SEL":
                    //se llama al validator productossel
                    result = validator.productoSel();
                    break;
                case "INS":

                    String nombre = new String(request.getParameter("txtNombre").getBytes("ISO-8859-1"), "UTF-8");
                    String categoria = new String(request.getParameter("txtcategoria").getBytes("ISO-8859-1"), "UTF-8");
                    Part foto = request.getPart("foto");
                    InputStream inputStream = foto.getInputStream();

                    Double precio = (request.getParameter("txtPrecio").length() == 0)
                            ? null
                            : Double.valueOf(request.getParameter("txtPrecio"));
                    Integer stock = (request.getParameter("txtStock").length() == 0)
                            ? null
                            : Integer.valueOf(request.getParameter("txtStock"));

                    String estado = request.getParameter("txtestado");

                    Producto producto = new Producto();
                    producto.setNombre(nombre);
                    producto.setDescripcion(categoria);
                    producto.setFoto(inputStream);
                    producto.setPrecio(precio);
                    producto.setStock(stock);
                    producto.setEstado(estado);
                    daoProducto.menuIns(producto);

                    Producto producto2 = new Producto();
                    producto2.setId_producto(daoProducto.productoBuscar());
                    producto2.setNombre(nombre);
                    producto2.setDescripcion(categoria);
                    producto2.setFoto(inputStream);
                    producto2.setPrecio(precio);
                    producto2.setStock(stock);
                    producto2.setEstado(estado);
                    //se llama a productosinsupd pero en false 
                    result = daoProducto.productoIns(producto2);
                    //luego de ejecutarse se van a un target en donde 
                    //si es correcto le manda a producto.jsp y sino se queda en productosel
                    //para mostrar los errores
                    target = result == null ? "producto.jsp" : "productoSel.jsp";
                    break;
                case "DEL":
                    
                    result = validator.productoDel();
                    //En este cas si se va ir si o si a la pagina producto.jsp
                    target = "producto.jsp";
                    break;
                case "GET":

                    result = validator.productoGet();
                    //se va ir a la actualización
                    target = "productoUpd.jsp";
                    break;
                case "UPD":

                    Integer id_producto1 = Integer.valueOf(request.getParameter("txtId_producto"));
                    String nombre1 = new String(request.getParameter("txtNombre").getBytes("ISO-8859-1"), "UTF-8");

                    Part foto1 = request.getPart("foto");
                    InputStream inputStream1 = foto1.getInputStream();

                    Double precio1 = (request.getParameter("txtPrecio").length() == 0)
                            ? null
                            : Double.valueOf(request.getParameter("txtPrecio"));
                    Integer stock1 = (request.getParameter("txtStock").length() == 0)
                            ? null
                            : Integer.valueOf(request.getParameter("txtStock"));

                    String estado1 = request.getParameter("txtestado");

                    Producto producto1 = new Producto();
                    producto1.setId_producto(id_producto1);
                    producto1.setNombre(nombre1);
                    producto1.setFoto(inputStream1);
                    producto1.setPrecio(precio1);
                    producto1.setStock(stock1);
                    producto1.setEstado(estado1);

                    result = validator.productoInsUpd(true);
                    target = result == null ? "producto.jsp" : "productoUpd.jsp";
                    break;
                case "":
                    //se pide una solicitud
                    result = "Solicitud requerida";
                    break;
                default:
                    //por ultimo no se reconoce la solicitud
                    result = "Solicitud no reconocida";
            }
            //si el mensaje es diferente de nulo saldrá error
            if (result != null) {
                request.setAttribute("mensaje", result);
            }
            //sino se llama al dispacher que va devolver el objetivo.
            RequestDispatcher dispatcher = request.getRequestDispatcher(target);
            //enviará la pregunta como respuesta
            dispatcher.forward(request, response);
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

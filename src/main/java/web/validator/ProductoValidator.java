package web.validator;

import dao.DaoProducto;
import dao.impl.DaoProductoImpl;
import dto.Producto;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

@MultipartConfig
public class ProductoValidator {

    private final HttpServletRequest request;
    DaoProducto daoProducto;
    
//<!--Inicio del constructor de productos-->  
    public ProductoValidator(HttpServletRequest request) {
        this.request = request;
        this.daoProducto = new DaoProductoImpl();
    }
//<!--Fin del constructor de productos-->  

    public String productoSel() {
        String result = null;
        List<Producto> list = daoProducto.productoSel();
        if (list != null) {
            request.setAttribute("list", list);
        } else {
            result = daoProducto.getMensaje();
        }
        return result;
    }

//<!--Inicio de las funciones de  productos-->  
    
    public String productoInsUpd(boolean upd) throws IOException, ServletException {
        StringBuilder result = new StringBuilder("<ul>");

        Integer id_producto = (request.getParameter("txtId_producto") == null)
                ? null
                : Integer.valueOf(request.getParameter("txtId_producto"));
        
        
        String nombre = new String(request.getParameter("txtNombre").getBytes("ISO-8859-1"),"UTF-8");
        String categoria = new String(request.getParameter("txtcategoria").getBytes("ISO-8859-1"),"UTF-8");
        
        
        Part foto = request.getPart("foto");
        InputStream inputStream= foto.getInputStream();

        Double precio = (request.getParameter("txtPrecio").length() == 0)
                ? null
                : Double.valueOf(request.getParameter("txtPrecio"));
        Integer stock = (request.getParameter("txtStock").length() == 0)
                ? null
                : Integer.valueOf(request.getParameter("txtStock"));
        
        String estado =request.getParameter("txtestado");

        if (upd && id_producto == null) {
            result.append("<li>Id requerido</li>");
        }
//<!--Inicio de nombres de productos se llenen correctamentamente--> 
        if (nombre == null || nombre.trim().length() == 0) {
            result.append("<li>Nombre requerido</li>");
        } else if (nombre.trim().length() < 3 || nombre.trim().length() > 50) {
            result.append("<li>La dimensión del nombre debe estar entre")
                    .append(" 3 a 50 caracteres</li>");
        }

        if (precio == null) {
            result.append("<li>Precio requerido</li>");
        } else if (precio < 0d) {
            result.append("<li>El precio no puede ser negativo</li>");
        }

        if (stock == null) {
            result.append("<li>Stock requerido</li>");
        } else if (stock < 0) {
            result.append("<li>El stock no puede ser negativo</li>");
        }

        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setDescripcion(categoria);
        producto.setFoto(inputStream);
        producto.setPrecio(precio);
        producto.setStock(stock);
        producto.setEstado(estado);
        daoProducto.menuIns(producto);
        
        Producto producto1 = new Producto();
        producto1.setId_producto(daoProducto.productoBuscar()+1);
        producto1.setNombre(nombre);
        producto1.setDescripcion(categoria);
        producto1.setFoto(inputStream);
        producto1.setPrecio(precio);
        producto1.setStock(stock);
        producto1.setEstado(estado);
        
        if (result.length() == 4) {
            String msg = upd
                    ? daoProducto.productoUpd(producto1)
                    : daoProducto.productoIns(producto1);
            if (msg != null) {
                result.append("<li>").append(msg).append("</li>");
            }
        }
        if (result.length() > 4) {
            request.setAttribute("producto", producto);
        }
        return result.length() == 4 ? null : result.append("</ul>").toString();
    }

//<!--Fin del constructor de productos--> 

//<!--Inicio de captura de ID de productos--> 

    public String productoGet() {
        String result = null;
        Integer id_producto = Integer.valueOf(request.getParameter("id_producto"));
        Producto producto = daoProducto.productoGet(id_producto);
        if (producto != null) {
            request.setAttribute("producto", producto);
        } else {
            result = daoProducto.getMensaje();
        }
        return result;
    }
//<!--Finde captura de ID de productos--> 
   
//<!--Inicio de la biblioteca de listado de productos-->  

    public String productoDel() {

        List<Integer> ids = new ArrayList<>();
        String _ids = request.getParameter("ids");
        if (_ids != null) {
            String[] v_ids = _ids.split(",");
            for (String v_id : v_ids) {
                Integer id = Integer.valueOf(v_id);
                if (id != null) {
                    ids.add(id);
                } else {
                    ids = null;
                    break;
                }
            }
        }
        
        String result = (ids != null)
                ? daoProducto.productoDel(ids)
                : "IDs incorrectos";
        daoProducto.pedidoDel(ids);
        return result;
    }
//<!--Fin de la biblioteca de listado de productos-->  
}

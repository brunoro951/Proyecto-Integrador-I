package dao;

import dto.Producto;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface DaoProducto {

    /*Listado de Producto*/
    List<Producto> productoSel();

    /*Seleccionar de Producto*/
    Producto productoGet(Integer id);

    /* Crear Producto*/
    String productoIns(Producto producto);

    /*Actualizar Producto*/
    String productoUpd(Producto producto);

    /*Eliminar Producto*/
    String productoDel(List<Integer> ids);
    
    /*Listar Producto por ID*/
    Producto listarId(int id);
    
    /*Buscar Producto por ID*/
    Producto buscar(int id);

    //UTILITARIO
    String getMensaje();
    void listarImg(int id, HttpServletResponse response);
    byte[] Foto(Integer id);
    
    String menuIns(Producto producto);
    int productoBuscar();
    void pedidoDel(List<Integer> ids);
    List listar();
}

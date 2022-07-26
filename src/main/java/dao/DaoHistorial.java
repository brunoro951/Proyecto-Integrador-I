package dao;

import dto.Historial;
import dto.Venta;
import java.util.List;


public interface DaoHistorial {
    /*Listado de Ventas*/
    List<Historial> ventaSel();

    /*Seleccionar Venta*/
    Venta ventaGet(Integer id);

    /*Actualizar Venta*/
    String ventaUpd(Venta venta);
    
    /*Eliminar registros de detalle venta*/
    String ventadetalleDel(List<Integer> ids);
    
    /*Eliminar registros de venta*/
    String ventaDel(List<Integer> ids);

    //UTILITARIO
    String getMensaje();
    
}

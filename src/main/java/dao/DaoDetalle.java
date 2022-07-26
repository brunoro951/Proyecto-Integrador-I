package dao;

import dto.Detalle_Venta;
import java.util.List;


public interface DaoDetalle {
    /*Listado de detalle venta */
    List<Detalle_Venta> detalleSel();

    /*Seleccionar  detalle */ 
    Detalle_Venta detalleGet(Integer id);
    
    /*Eliminar Detalle */ 
    String detalleDel(List<Integer> ids);
    
    //UTILITARIO
    String getMensaje();
    
}

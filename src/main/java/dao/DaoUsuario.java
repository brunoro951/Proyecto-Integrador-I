package dao;

import dto.Cliente;
import java.util.List;


public interface DaoUsuario {
    /*Listado de Clientes */ 
    List<Cliente> usuarioSel();

    /*Seleccionar  Clientes */ 
    Cliente usuarioGet(Integer id);

    /*Insertar Clientes */ 
    void usuarioIns(Cliente cliente);

    /*Actualizar Clientes */ 
    String usuarioUpd(Cliente cliente);

    /*Eliminar Clientes */ 
    String usuarioDel(List<Integer> ids);
    
    int clienteBuscar();

    //UTILITARIO
    String getMensaje();
    
}

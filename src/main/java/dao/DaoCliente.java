package dao;

import dto.Cliente;
import java.util.List;


public interface DaoCliente {
    /*Listado de Clientes */ 
    List<Cliente> clienteSel();

    /*Seleccionar  Clientes */ 
    Cliente clienteGet(Integer id);

    /*Insertar Clientes */ 
    String clienteIns(Cliente cliente);

    /*Actualizar Clientes */ 
    String clienteUpd(Cliente cliente);

    /*Eliminar Clientes */ 
    String clienteDel(List<Integer> ids);
    
    Cliente clienteBuscar(String dni);

    //UTILITARIO
    String getMensaje();
    
    Cliente login(String user, String pass);
}

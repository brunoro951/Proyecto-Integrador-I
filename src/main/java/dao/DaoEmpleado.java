
package dao;

import dto.Empleado;
import java.util.List;

/**
 *
 * @author marlo
 */
public interface DaoEmpleado {
    /*Listado Empleados*/ 
    List<Empleado> EmpleadoSel();

    /*Seleccionar Empleados*/
    Empleado EmpleadoGet(Integer id);

    /*Insertar Empleados*/

    String EmpleadoIns(Empleado Empleado);

    /*Actualizar Empleados*/
    String EmpleadoUpd(Empleado Empleado);

    /*Actualizar Empleados*/
    String EmpleadoDel(List<Integer> ids);
    
    /*Inicio de  Empleados*/
    Empleado login(String user, String pass);
    
    //UTILITARIO
    String getMensaje();
}

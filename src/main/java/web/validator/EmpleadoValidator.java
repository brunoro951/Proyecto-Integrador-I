
package web.validator;

import dao.DaoEmpleado;
import dao.impl.DaoEmpleadoImpl;
import dto.Empleado;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;


public class EmpleadoValidator {
    private final HttpServletRequest request;
    private final DaoEmpleado daoEmpleado;
    

    public EmpleadoValidator(HttpServletRequest request) {
        this.request = request;
        this.daoEmpleado = new DaoEmpleadoImpl();
    }
    
    /*Inicio de clase Listado de Empleado*/ 
    public String EmpleadoSel(){
        String result = null;
        List<Empleado> list = daoEmpleado.EmpleadoSel();
        if (list != null) {
            request.setAttribute("list", list);
        } else {
            result = daoEmpleado.getMensaje();
        }
        return result;
    }
     /*Fin de clase Listado de Empleado*/  
    
    /*Inicio de la clase de Actualizar o insertar Empleado*/
    public String EmpleadoInsUpd(boolean upd) throws UnsupportedEncodingException{
        StringBuilder result = new StringBuilder("<ul>");

        Integer id_empleado = (request.getParameter("txtId_empleado") == null)
                ? null
                : Integer.valueOf(request.getParameter("txtId_empleado"));
        String dni = request.getParameter("txtdni");
        String nombre = new String(request.getParameter("txtNombre").getBytes("ISO-8859-1"),"UTF-8");
        String apellido = new String(request.getParameter("txtApellido").getBytes("ISO-8859-1"),"UTF-8");
        String telefono = request.getParameter("txtTelefono");
        int sala=Integer.valueOf (request.getParameter("txtsalario"));
        String estado=request.getParameter("txtestado");
        String user=new String(request.getParameter("txtUser").getBytes("ISO-8859-1"),"UTF-8");
        String contra = new String(request.getParameter("txtContra").getBytes("ISO-8859-1"),"UTF-8");
        String tipo = new String(request.getParameter("txttipo").getBytes("ISO-8859-1"),"UTF-8");

        
        if (upd && id_empleado == null) {
            result.append("<li>Id requerido</li>");
        }
        
        if (dni == null || dni.trim().length() != 8) {
            result.append("<li>Dni requerido debe ser de 8 caracteres</li>");
        }
        
        if (nombre == null || nombre.trim().length() == 0) {
            result.append("<li>Nombre requerido</li>");
        }

        if (apellido == null || apellido.trim().length() == 0) {
            result.append("<li>Apellido requerido</li>");
        } 
        
        if (telefono == null || telefono.trim().length() != 9) {
            result.append("<li>Telefono requerido de 9 caracteres</li>");
        }
        
        if (user == null || user.trim().length() ==0) {
            result.append("<li>User requerido </li>");
        }else if (user.trim().length() < 3 || user.trim().length() > 30) {
            result.append("<li>La dimensión del usuario debe estar entre")
                    .append(" 3 a 30 caracteres</li>");
        }
        
        if (contra == null || contra.trim().length() == 0) {
            result.append("<li>Contraseña requerida</li>");
        }else if (contra.trim().length() < 3 || contra.trim().length() > 50) {
            result.append("<li>La dimensión de contraseña debe estar entre")
                    .append(" 3 a 30 caracteres</li>");
        }
        
        
        nombre=mayus(espacios(nombre));
        apellido=mayus(espacios(apellido));
        
        Empleado empleado = new Empleado();
        empleado.setId(id_empleado);
        empleado.setDni(dni);
        empleado.setNom(nombre);
        empleado.setApellido(apellido);
        empleado.setTelefono(telefono);
        empleado.setUser(user);
        empleado.setContraseña(contra);
        empleado.setTipo(tipo);
        empleado.setSalario(sala);        
        empleado.setEstado(estado);

        if (result.length() == 4) {
            String msg = upd
                    ? daoEmpleado.EmpleadoUpd(empleado)
                    : daoEmpleado.EmpleadoIns(empleado);
            if (msg != null) {
                result.append("<li>").append(msg).append("</li>");
            }
        }
        if (result.length() > 4) {
            request.setAttribute("empleado", empleado);
        }
        return result.length() == 4 ? null : result.append("</ul>").toString();
        
    }
    /*Fin de la clase de Actualizar o insertar Empleado*/
    
    
    
    
    /*Inicio de clase de busqueda Empleado*/  
    public String EmpleadoGet() {
        String result = null;
        Integer id_empleado = Integer.valueOf(request.getParameter("id_empleado"));
        Empleado empleado = daoEmpleado.EmpleadoGet(id_empleado);
        if (empleado != null) {
            request.setAttribute("empleado", empleado);
        } else {
            result = daoEmpleado.getMensaje();
        }
        return result;
    }
    /*Fin de clase de busqueda Empleado*/ 
    
    /*Inicio Eliminar Empleado*/ 
    public String EmpleadoDel(){
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
                ? daoEmpleado.EmpleadoDel(ids)
                : "IDs incorrectos";
        return result;
    }
    /*Fin Eliminar Empleado*/
    
    public String espacios(String texto){
        texto=texto.trim();
        texto=texto.replaceAll("\\s{2,}", " ");
        return texto.substring(0,1).toUpperCase()+texto.substring(1).toLowerCase();
    }
    
    public String mayus(String texto){
        char[] cfr = texto.toCharArray();
        String a="";
       for(int i = 0; i<cfr.length; i++) {

           if(cfr[i] == ' ' || cfr[i] == '.' || cfr[i] == ','){

           cfr[i+1] = Character.toUpperCase(cfr[i+1]);

           }
           a+=Character.toString(cfr[i]);
       }
       return a;
    }
}

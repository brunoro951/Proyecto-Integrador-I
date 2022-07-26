/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.validator;

import dao.DaoCliente;
import dao.DaoUsuario;
import dao.impl.DaoClienteImpl;
import dao.impl.DaoUsuarioImpl;
import dto.Cliente;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;


public class ClienteValidator {
    
    private final HttpServletRequest request;
    DaoCliente daoCliente;
    DaoUsuario daoUsuario;
    
    /*Inicio del Constructor de Cliente*/
    public ClienteValidator(HttpServletRequest request) {
        this.request = request;
        this.daoCliente = new DaoClienteImpl();
        this.daoUsuario= new DaoUsuarioImpl();
    }
    /*Fin del Constructor de Cliente*/
    
    /*Inicio de clase Listado de Cliente*/ 
    public String clienteSel() {
        String result = null;
        List<Cliente> list = daoCliente.clienteSel();
        if (list != null) {
            request.setAttribute("list", list);
        } else {
            result = daoCliente.getMensaje();
        }
        return result;
    }
    /*Fin de clase Listado de Cliente*/ 
    
    /*Inicio de las Funciones de Empleado*/ 
    public String clienteInsUpd(boolean upd) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder("<ul>");

        Integer id_cliente = (request.getParameter("txtId_cliente") == null)
                ? null
                : Integer.valueOf(request.getParameter("txtId_cliente"));
        String nombre = new String(request.getParameter("txtNombre").getBytes("ISO-8859-1"),"UTF-8");

        String apellido = new String(request.getParameter("txtApellido").getBytes("ISO-8859-1"),"UTF-8");
        
        String correo = new String(request.getParameter("txtCorreo").getBytes("ISO-8859-1"),"UTF-8");
        
        String telefono = request.getParameter("txtTelefono");
        String documento = request.getParameter("txtDocumento");
        
        String usu= request.getParameter("txtUsu");
        
        String contra=request.getParameter("txtContra");
        String estado=request.getParameter("txtEstado");
        String dire=request.getParameter("txtdireccion");
        
        
        /*Inicio de llenado de Empleado*/ 
        if (upd && id_cliente == null) {
            result.append("<li>Id requerido</li>");
        }

        if (nombre == null || nombre.trim().length() == 0) {
            result.append("<li>Nombre requerido</li>");
        } else if (nombre.trim().length() < 3 || nombre.trim().length() > 50) {
            result.append("<li>La dimensión del nombre debe estar entre")
                    .append(" 3 a 50 caracteres</li>");
        }

        if (apellido == null || apellido.trim().length() == 0) {
            result.append("<li>Apellido requerida</li>");
        } else if (apellido.trim().length() < 3 || apellido.trim().length() > 50) {
            result.append("<li>La dimensión de la apellido debe estar entre")
                    .append(" 3 a 50 caracteres</li>");
        }

        if (correo == null || correo.trim().length() == 0) {
            result.append("<li>Correo requerida</li>");
        }

        if (telefono == null || telefono.trim().length() == 0) {
            result.append("<li>Telefono requerido</li>");
        }if (telefono == null || telefono.trim().length() != 9) {
            result.append("<li>El telefono requerido debe ser de 9 caracteres</li>");
        }
          
        if (documento == null || documento.trim().length() !=8) {
            result.append("<li>Documento requerido de 8 digitos</li>");
        }else if (documento.trim().length() > 8 || documento.trim().length() < 7) {
            result.append("<li>La dimensión del DNI deben ser")
                    .append(" de 8 caracteres</li>");
        }
        
        
         
        nombre=mayus(espacios(nombre));
        apellido=mayus(espacios(apellido));
        
        
        Cliente cliente = new Cliente();
        cliente.setId_cliente(id_cliente);
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setCorreo(correo);
        cliente.setDocumento(documento);
        cliente.setTelefono(telefono);
        cliente.setUsuario(usu);
        cliente.setPassword(contra);
        cliente.setEstado(estado);
        cliente.setDireccion(dire);
        
        Cliente cliente1 = new Cliente();
        cliente1.setId_cliente(daoUsuario.clienteBuscar()+1);
        cliente1.setNombre(nombre);
        cliente1.setApellido(apellido);
        cliente1.setCorreo(correo);
        cliente1.setDocumento(documento);
        cliente1.setTelefono(telefono);
        cliente1.setUsuario(usu);
        cliente1.setPassword(contra);
        cliente1.setEstado(estado);
        cliente1.setDireccion(dire);
        
        if (result.length() == 4) {
            String msg = upd
                    ? daoCliente.clienteUpd(cliente)
                    : daoCliente.clienteIns(cliente);
            daoUsuario.usuarioIns(cliente1);
            if (msg != null) {
                result.append("<li>").append(msg).append("</li>");
            }
        }
        if (result.length() > 4) {
            request.setAttribute("cliente", cliente);
        }
        
        return result.length() == 4 ? null : result.append("</ul>").toString();
    }
    /*Fin de las Funciones de Empleado*/ 
    
    /*Inicio de clase de Listado cliente*/ 
    public String clienteGet() {
        String result = null;
        Integer id_cliente = Integer.valueOf(request.getParameter("id_cliente"));
        Cliente cliente = daoCliente.clienteGet(id_cliente);
        if (cliente != null) {
            request.setAttribute("cliente", cliente);
        } else {
            result = daoCliente.getMensaje();
        }
        return result;
    }
    /*Fin de clase de Listado cliente*/
    
    /*Incio eliminar clientes*/
    public String clienteDel() {

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
                ? daoCliente.clienteDel(ids)
                : "IDs incorrectos";
        return result;
    }
    /*Fin eliminar clientes*/
    
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

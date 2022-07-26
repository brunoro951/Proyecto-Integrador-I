/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.validator;


import dao.DaoHistorial;
import dao.impl.DaoHistorialImpl;
import dto.Historial;
import dto.Venta;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;


public class HistorialValidator {
    
    private final HttpServletRequest request;
    DaoHistorial daoVenta;

    public HistorialValidator(HttpServletRequest request) {
        this.request = request;
        this.daoVenta = new DaoHistorialImpl();
    }

    public String ventaSel() {
        String result = null;
        List<Historial> list = daoVenta.ventaSel();
        if (list != null) {
            request.setAttribute("list", list);
        } else {
            result = daoVenta.getMensaje();
        }
        return result;
    }

    public String ventaInsUpd(boolean upd) {
        StringBuilder result = new StringBuilder("<ul>");

        Integer id_venta = (request.getParameter("txtId_venta") == null)
                ? null
                : Integer.valueOf(request.getParameter("txtId_venta"));
        Integer id_cliente= Integer.valueOf(request.getParameter("txtIdCliente"));
        Integer id_empleado= Integer.valueOf(request.getParameter("txtIdEmpleado"));
        String numserie = request.getParameter("txtNumSerie");
        String fecha = request.getParameter("txtfecha");
        double monto= Double.parseDouble(request.getParameter("txtMonto"));
        String estado = request.getParameter("txtEstado");

        if (upd && id_venta == null) {
            result.append("<li>Id requerido</li>");
        }

        if (estado == null || estado.trim().length() == 0) {
            result.append("<li>Estado requerido</li>");
        } else if (estado.trim().length() >2 && estado.trim().length() >0) {
            result.append("<li>Solo existe el Estado : ")
                    .append(" 1 y 0 </li>");
        }


        Venta venta = new Venta();
        venta.setId(id_venta);
        venta.setIdcliente(id_cliente);
        venta.setIdempleado(id_empleado);
        venta.setNumserie(numserie);
        venta.setFecha(fecha);
        venta.setMonto(monto);
        venta.setEstado(estado);

        if (result.length() == 4) {
            String msg = upd
                    ? daoVenta.ventaUpd(venta)
                    : null;
            if (msg != null) {
                result.append("<li>").append(msg).append("</li>");
            }
        }
        if (result.length() > 4) {
            request.setAttribute("ventas", venta);
        }
        return result.length() == 4 ? null : result.append("</ul>").toString();
    }

    public String ventasGet() {
        String result = null;
        Integer id_venta = Integer.valueOf(request.getParameter("id_venta"));
        Venta venta = daoVenta.ventaGet(id_venta);
        if (venta != null) {
            request.setAttribute("ventas", venta);
        } else {
            result = daoVenta.getMensaje();
        }
        return result;
    }
    
    public String ventadetalleDel() {

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
                ? daoVenta.ventadetalleDel(ids)
                : "IDs incorrectos";
        return result;
    }
    
    
    public String ventaDel() {

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
                ? daoVenta.ventaDel(ids)
                : "IDs incorrectos";
        return result;
    }
    
}

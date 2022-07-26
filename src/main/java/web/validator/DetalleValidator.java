/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.validator;


import dao.DaoDetalle;
import dao.impl.DaoDetalleImpl;
import dto.Detalle_Venta;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;


public class DetalleValidator {
    
    private final HttpServletRequest request;
    DaoDetalle daoVenta;

    public DetalleValidator(HttpServletRequest request) {
        this.request = request;
        this.daoVenta = new DaoDetalleImpl();
    }

    public String detalleSel() {
        String result = null;
        List<Detalle_Venta> list = daoVenta.detalleSel();
        if (list != null) {
            request.setAttribute("list", list);
        } else {
            result = daoVenta.getMensaje();
        }
        return result;
    }

    public String ventasGet() {
        String result = null;
        Integer id_venta = Integer.valueOf(request.getParameter("id_detalle"));
        Detalle_Venta venta = daoVenta.detalleGet(id_venta);
        if (venta != null) {
            request.setAttribute("ventas", venta);
        } else {
            result = daoVenta.getMensaje();
        }
        return result;
    }
    
    public String detalleDel() {

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
                ? daoVenta.detalleDel(ids)
                : "IDs incorrectos";
        return result;
    }
    
}

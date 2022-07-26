
package dao.impl;

import dao.DaoDetalle;
import dto.Detalle_Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.ConectaBD;


public class DaoDetalleImpl implements DaoDetalle{
    
    private ConectaBD conectaDb;
    private String mensaje;
    
    ConectaBD cn=new ConectaBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public DaoDetalleImpl() {
        this.conectaDb = new ConectaBD();
    }
    
    @Override
    /**
     *@ return List con datos del detalle de venta
     *@ parameter ninguno 
     */
    public List<Detalle_Venta> detalleSel() {
        List<Detalle_Venta> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT pedido_detalle.ped_det_id,"
                + "pedido_detalle.pedido_id,"
                + "menu_detalle.mendet_nombre,"
                + " pedido_detalle.ped_cantidad, "
                + "pedido_detalle.ped_precioventa, "
                + "pedido_detalle.ped_estado "
                + " FROM pedido_detalle "
                + " INNER JOIN menu_detalle on menu_detalle.mendet_id=pedido_detalle.menu_detalle_id"
                + " ORDER BY pedido_detalle.ped_det_id DESC");
        try (Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Detalle_Venta venta = new Detalle_Venta();
                venta.setIddetalle(rs.getInt(1));
                venta.setIdventa(rs.getInt(2));
                venta.setName(rs.getString(3));
                venta.setCantidad(rs.getInt(4));
                venta.setPrecio(rs.getDouble(5));
                venta.setEstado(rs.getString(6));
                list.add(venta);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return list;
    }
    
    /**
     *@ return Entidad de Detalle_venta con datos del detalle de venta seleccionado
     *@ parameter ninguno 
     */
    @Override
    public Detalle_Venta detalleGet(Integer id) {
        Detalle_Venta venta  = new Detalle_Venta();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("IdDetalleVentas,")
                .append("IdVentas,")
                .append("IdProducto,")
                .append("Cantidad,")
                .append("PrecioVenta")
                .append(" FROM detalle_ventas")
                .append(" WHERE IdDetalleVentas = ? ");
        try (Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {  
                venta.setIddetalle(rs.getInt(1));
                venta.setIdventa(rs.getInt(2));
                venta.setName(rs.getString(3));
                venta.setCantidad(rs.getInt(4));
                venta.setPrecio(rs.getInt(5));
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return venta;
    }

    /**
     *@ return String Mensaje
     *@ parameter List con ids de detalles de venta que se quiere eliminar
     */
    @Override
    public String detalleDel(List<Integer> ids) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM cliente WHERE ")
                .append("IdCliente = ? ");
        try (Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            cn.setAutoCommit(false);
            boolean ok = true;
            for (int i = 0; i < ids.size(); i++) {
                ps.setInt(1, ids.get(i));
                int ctos = ps.executeUpdate();
                if (ctos == 0) {
                    ok = false;
                    mensaje = "Cero filas actualizadas";
                }
                if (ok) {
                    cn.commit();
                } else {
                    cn.rollback();
                }
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }
    
    /**
     *@ return String Mensaje
     *@ parameter ninguno 
     */
    @Override
    public String getMensaje() {
        return mensaje;
    }
    
    
}

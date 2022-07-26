
package dao.impl;

import dao.DaoHistorial;
import dto.Historial;
import dto.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.ConectaBD;


public class DaoHistorialImpl implements DaoHistorial{
    
    private ConectaBD conectaDb;
    private String mensaje;
    
    ConectaBD cn=new ConectaBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public DaoHistorialImpl() {
        this.conectaDb = new ConectaBD();
    }
    
    /**
     *@ return List de todas las Ventas con sus datos
     *@ parameter ninguno
     */
    @Override
    public List<Historial> ventaSel() {
        List<Historial> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT pedido.ped_id, cliente.cli_nombres, empleado.emp_nombres,pedido.mesa_id,pedido.ped_tipo, pedido.ped_numeroserie, pedido.ped_fecha, pedido.ped_monto, pedido.ped_estado FROM pedido INNER JOIN cliente on pedido.cliente_id=cliente.cli_id INNER JOIN empleado on pedido.empleado_id=empleado.emp_id ORDER BY pedido.ped_id DESC");
                
        try (Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Historial h = new Historial();
                h.setIdventa(rs.getInt(1));
                h.setNombrec(rs.getString(2));
                h.setNombree(rs.getString(3));
                h.setMesa(rs.getInt(4));
                h.setTipo(rs.getString(5));
                h.setNumserie(rs.getString(6));
                h.setFecha(rs.getString(7));
                h.setMonto(rs.getDouble(8));
                h.setEstado(rs.getString(9));
                list.add(h);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return list;
    }

    /**
     *@ return Entidad Venta seleccionada
     *@ parameter Integer id de la venta
     */
    @Override
    public Venta ventaGet(Integer id) {
        Venta venta  = new Venta();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("ped_id,")
                .append("cliente_id,")
                .append("empleado_id,")
                .append("mesa_id,")
                .append("ped_tipo,")
                .append("ped_numeroserie,")
                .append("ped_fecha,")
                .append("ped_monto,")
                .append("ped_estado")
                .append(" FROM pedido ")
                .append(" WHERE ped_id = ? ");
        try (Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                venta.setId(rs.getInt(1));
                venta.setIdcliente(rs.getInt(2));
                venta.setIdempleado(rs.getInt(3));
                venta.setMesa_id(rs.getInt(4));
                venta.setTipo(rs.getString(5));
                venta.setNumserie(rs.getString(6));
                venta.setFecha(rs.getString(7));
                venta.setMonto(rs.getDouble(8));
                venta.setEstado(rs.getString(9));
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return venta;
    }

    /**
     *@ return String mensaje
     *@ parameter Entidad Venta
     */
    @Override
    public String ventaUpd(Venta venta) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE pedido SET ")
                .append("ped_estado = ?")
                .append("WHERE ped_id = ? ");

        try (Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());            
            ps.setString(1, venta.getEstado());
            ps.setInt(2, venta.getId());
            int ctos = ps.executeUpdate();
            if (ctos == 0) {
                mensaje = "Cero filas actualizadas";
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }
    
    /**
     *@ return String Mensaje
     *@ parameter List con los ids que se desea eliminar del detalle de venta
     */
    @Override
    public String ventadetalleDel(List<Integer> ids) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM detalle_ventas WHERE ")
                .append("IdVentas = ? ");
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
     *@ parameter List con los ids que se desea eliminar de la venta
     */
    @Override
    public String ventaDel(List<Integer> ids) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM ventas WHERE ")
                .append("IdVentas = ? ");
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
     *@ parameter Ninguno
     */
    @Override
    public String getMensaje() {
        return mensaje;
    }
    
    
    
}

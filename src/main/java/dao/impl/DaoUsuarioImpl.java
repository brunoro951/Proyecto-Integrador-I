
package dao.impl;


import dao.DaoUsuario;
import dto.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.ConectaBD;


public class DaoUsuarioImpl implements DaoUsuario{
    
    private ConectaBD conectaDb;
    private String mensaje;
    
    ConectaBD cn=new ConectaBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public DaoUsuarioImpl() {
        this.conectaDb = new ConectaBD();
    }
    
    @Override
    /**
     *@ return List de Clientes con sus datos
     *@ parameter id que ingresa
     */
    public List<Cliente> usuarioSel() {
        List<Cliente> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("usu_id,")
                .append("cli_id,")
                .append("usu_username,")
                .append("usu_password,")
                .append("usu_estado")
                .append(" FROM usuario");
        try (Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId_cliente(rs.getInt(1));
                cliente.setUsuario(rs.getString(3));
                cliente.setPassword(rs.getString(4));
                cliente.setEstado(rs.getString(5));
                list.add(cliente);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return list;
    }
//
    @Override
    /**
     *@ return Cliente datos del cliente seleccionado
     *@ parameter id que ingresa
     */
    public Cliente usuarioGet(Integer id) {
        Cliente cliente  = new Cliente();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("usu_id,")
                .append("cli_id,")
                .append("usu_username,")
                .append("usu_password,")
                .append("usu_estado")
                .append(" FROM usuario")
                .append(" WHERE usu_id= ? ");
        try (Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                cliente.setId_cliente(rs.getInt(1));
                cliente.setUsuario(rs.getString(3));
                cliente.setPassword(rs.getString(4));
                cliente.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return cliente;
    }

    @Override
    /**
     *@ return String Mensaje 
     *@ parameter Cliente con datos insertados
     */
    public void usuarioIns(Cliente cliente) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO usuario( ")
                .append("cliente_id,")
                .append("usu_username,")
                .append("usu_password,")
                .append("usu_estado")
                .append(") VALUES (?,?,?,?) ");
        try (Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, cliente.getId_cliente());
            ps.setString(2, cliente.getUsuario());
            ps.setString(3, cliente.getPassword());
            ps.setString(4, cliente.getEstado());
            int ctos = ps.executeUpdate();
            if (ctos == 0) {
                mensaje = "Cero filas insertadas";
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        
    }

    @Override
    /**
     *@ return String Mensaje
     *@ parameter Cliente que con datos actualizados insertados
     */
    public String usuarioUpd(Cliente cliente) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE usuario SET ")
                .append("usu_username = ?,")
                .append("usu_password = ?,")
                .append("usu_estado = ? ")
                .append("WHERE usu_id = ? ");

        try (Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, cliente.getUsuario());
            ps.setString(2, cliente.getPassword());
            ps.setString(3, cliente.getEstado());
            ps.setInt(4, cliente.getId_cliente());
            int ctos = ps.executeUpdate();
            if (ctos == 0) {
                mensaje = "Cero filas actualizadas";
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    /**
     *@ return String Mensaje
     *@ parameter List de ids que se desean eliminar
     */
    public String usuarioDel(List<Integer> ids) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM usuario WHERE ")
                .append("usu_id = ? ");
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
    

    @Override
    /**
     *@ return String Mensaje
     *@ parameter none
     */
    public String getMensaje() {
        return mensaje;
    }
    
    @Override
    /**
     *@ return Cliente con datos del cliente
     *@ parameter id del cliente que que se requiere buscar
     * No se utiliza xd
     * Recordatorio para eliminarlo xd
     */
    public int clienteBuscar() {
       int n=0;
        String sql="select max(cli_id) from cliente";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                n=rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return n;
    }
    
}

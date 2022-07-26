
package dao.impl;

import dao.DaoCliente;
import dao.DaoUsuario;
import dto.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.ConectaBD;


public class DaoClienteImpl implements DaoCliente{
    
    private ConectaBD conectaDb;
    private String mensaje;
    DaoUsuario daoUsuario;
    
    ConectaBD cn=new ConectaBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public DaoClienteImpl() {
        this.conectaDb = new ConectaBD();
    }
    
    @Override
    /**
     *@ return List de Clientes con sus datos
     *@ parameter id que ingresa
     */
    public List<Cliente> clienteSel() {
        List<Cliente> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("cli_id,")
                .append("cli_nombres,")
                .append("cli_apellidos,")
                .append("cli_email,")
                .append("cli_telefono,")
                .append("cli_documento,")
                .append("cli_direccion")
                .append(" FROM cliente");
        try (Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId_cliente(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setApellido(rs.getString(3));
                cliente.setCorreo(rs.getString(4));
                cliente.setTelefono(rs.getString(5));
                cliente.setDocumento(rs.getString(6));
                cliente.setDireccion(rs.getString(7));
                list.add(cliente);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return list;
    }

    @Override
    /**
     *@ return Cliente datos del cliente seleccionado
     *@ parameter id que ingresa
     */
    public Cliente clienteGet(Integer id) {
        Cliente cliente  = new Cliente();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("cli_id,")
                .append("cli_nombres,")
                .append("cli_apellidos,")
                .append("cli_email,")
                .append("cli_telefono,")
                .append("cli_documento,")
                .append("cli_direccion")
                .append(" FROM cliente")
                .append(" WHERE cli_id = ? ");
        try (Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                cliente.setId_cliente(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setApellido(rs.getString(3));
                cliente.setCorreo(rs.getString(4));
                cliente.setTelefono(rs.getString(5));
                cliente.setDocumento(rs.getString(6));
                cliente.setDireccion(rs.getString(7));
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
    public String clienteIns(Cliente cliente) {
        
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO cliente( ")
                .append("cli_nombres,")
                .append("cli_apellidos,")
                .append("cli_email,")
                .append("cli_telefono,")
                .append("cli_documento,")
                .append("cli_direccion")
                .append(") VALUES (?,?,?,?,?,?) ");
        try (Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getCorreo());
            ps.setString(4, cliente.getTelefono());
            ps.setString(5, cliente.getDocumento());
            ps.setString(6, cliente.getDireccion());
            int ctos = ps.executeUpdate();
            
            if (ctos == 0) {
                mensaje = "Cero filas insertadas";
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    /**
     *@ return String Mensaje
     *@ parameter Cliente que con datos actualizados insertados
     */
    public String clienteUpd(Cliente cliente) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE cliente SET ")
                .append("cli_nombres = ?,")
                .append("cli_apellidos = ?,")
                .append("cli_email = ?,")
                .append("cli_telefono = ?,")
                .append("cli_documento = ?, ")
                .append("cli_direccion = ? ")
                .append("WHERE cli_id = ? ");

        try (Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getCorreo());
            ps.setString(4, cliente.getTelefono());
            ps.setString(5, cliente.getDocumento());
            ps.setString(6, cliente.getDireccion());
            ps.setInt(7, cliente.getId_cliente());
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
    public String clienteDel(List<Integer> ids) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM cliente WHERE ")
                .append("cli_id = ? ");
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
    public Cliente clienteBuscar(String dni) {
       Cliente c=new Cliente();
        String sql="Select * from cliente where NroDocumento="+dni;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                c.setId_cliente(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setCorreo(rs.getString(4));
                c.setTelefono(rs.getString(5));
                c.setDocumento(rs.getString(7));
                
            }
        } catch (Exception e) {
        }
        return c;
    }
    
    
    @Override
    public Cliente login(String user, String pass){
        Cliente cli = new Cliente();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("usu_id, ")
                .append("usu_username, ")
                .append("usu_password, ")
                .append("usu_estado ")
                .append(" FROM usuario WHERE usu_username = ? ")
                .append(" AND usu_password = ? ");
        try (Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, user);
            ps.setString(2, pass);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    cli.setId_cliente(rs.getInt(1));
                    cli.setUsuario(rs.getString(2));
                    cli.setEstado(rs.getString(3));
            }else{
                    cli=null;
                    mensaje="Usuario y/o contraseñas incorrectas";
                }
            } catch (Exception e) {
                mensaje = e.getMessage();
            }
            
            
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return cli;
    }
    
}

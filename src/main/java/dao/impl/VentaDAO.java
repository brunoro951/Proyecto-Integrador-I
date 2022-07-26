/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dto.Cliente;
import dto.Empleado;
import dto.Producto;
import dto.Venta;
import util.ConectaBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class VentaDAO {
    Connection con;
    ConectaBD cn=new ConectaBD();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    /**
     *@ return Entidad Cliente con sus datos correspondientes
     *@ parameter int id del cliente introducido
     */
//    public Cliente listarId(int id){
//        Cliente cli=new Cliente();
//        String sql="select * from cliente where IdCliente="+id;
//        try {
//            con=cn.getConnection();
//            ps=con.prepareStatement(sql);
//            rs=ps.executeQuery();
//            while(rs.next()){
//                cli.setNombre(rs.getString(2));
//                cli.setApellido(rs.getString(3));
//                cli.setCorreo(rs.getString(4));
//                cli.setTelefono(rs.getString(5));
//                cli.setDocumento(rs.getString(6));
//                cli.setDireccion(rs.getString(7));
//            }
//        } catch (Exception e) {
//        }
//        return cli;
//    }
    
    /**
     *@ return Cliente que se busca
     *@ parameter String dni introducido
     */
    public Cliente clienteBuscar(String dni) {
       Cliente c=new Cliente();
        String sql="Select cli_id, cli_nombres,cli_documento from cliente where cli_documento="+dni;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                c.setId_cliente(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setDocumento(rs.getString(3));
                
            }
        } catch (Exception e) {
        }
        return c;
    }
    
    /**
     *@ return Entidad producto buscado
     *@ parameter int id que se busca
     */
    public Producto listarrId(int id){
        Producto pmp=new Producto();
        String sql="select mendet_id, mendet_nombre, mendet_precio,mendet_stock from menu_detalle where mendet_id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                pmp.setId_producto(rs.getInt(1));
                pmp.setNombre(rs.getString(2));
                pmp.setPrecio(rs.getDouble(3));
                pmp.setStock(rs.getInt(4));
                
            }
        } catch (Exception e) {
        }
        return pmp;
    }
    
    /**
     *@ return Entidad Producto que se buscaba
     *@ parameter int id de producto que se busca
     */
    public Producto buscarr(int id){
        Producto p=new Producto();
        String sql="select mendet_id,mendet_nombre,mendet_precio,mendet_stock from menu_detalle where mendet_id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                p.setId_producto(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock(rs.getInt(4));
            }
        } catch (Exception e) {
        }
        return p;
    }
    
    /**
     *@ return int r 
     *@ parameter int id && int stock que quiere actualizar
     */
    public int actualizarstock(int id, int stock){
        String sql="update menu_detalle set mendet_stock=? where mendet_id=?";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    /**
     *@ return String con el numero de serie
     *@ parameter ninguno
     */
    public String GenerarSerie(){
        String numeroserie="";
        String sql="select max(ped_id) from pedido";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                numeroserie=rs.getString(1);
            }
        } catch (Exception e) {
        }
        return numeroserie;
    }
    
    /**
     *@ return String id con el maximo de ids
     *@ parameter ninguno
     */
    public String IdVentas(){
        String idventas="";
        String sql="select max(ped_id) from pedido";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                idventas=rs.getString(1);
            }
        } catch (Exception e) {
        }
        return idventas;
    }
    
    /**
     *@ return int r
     *@ parameter Entidad Venta para insertalo
     */
    public int guardarVenta(Venta ve){
        String sql="insert into pedido(cliente_id, empleado_id,mesa_id,ped_tipo,ped_numeroserie, ped_fecha,ped_monto, ped_estado) values (?,?,?,?,?,?,?,?)";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, ve.getIdcliente());
            ps.setInt(2, ve.getIdempleado());
            ps.setInt(3, ve.getMesa_id());
            ps.setString(4, ve.getTipo());
            ps.setString(5, ve.getNumserie());
            ps.setString(6, ve.getFecha());
            ps.setDouble(7, ve.getMonto());
            ps.setString(8, ve.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    /**
     *@ return int r
     *@ parameter Entidad Venta que se quiere guardar en la base de datos
     */
    public int GuardarDetalleventas(Venta venta){
        String sql="insert into pedido_detalle(pedido_id,ped_cantidad,ped_precioventa,ped_estado,menu_detalle_id)values(?,?,?,?,?)";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1,venta.getId());
            ps.setInt(2, venta.getCantidad());
            ps.setDouble(3, venta.getPrecio());
            ps.setString(4, venta.getEstado());
            ps.setInt(5, venta.getIdproducto());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        
        return r;
    }
   
    public Empleado empleadoBuscar(Integer cod) {
        Empleado c=new Empleado();
        String sql="Select emp_id ,emp_nombres from empleado where emp_id="+cod;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                c.setId(rs.getInt(1));
                c.setNom(rs.getString(2));      
            }
        } catch (Exception e) {
        }
        return c;
    }
    
}

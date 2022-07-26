/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DaoProducto;
import dto.Producto;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import util.ConectaBD;


public class DaoProductoImpl implements DaoProducto{

    
    private ConectaBD conectaDb;
    private String mensaje;
    ConectaBD cn=new ConectaBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public DaoProductoImpl() {
        this.conectaDb = new ConectaBD();
    }
    
    /**
     *@ return List con los productos con sus datos
     *@ parameter ninguno
     */
    @Override
    public List<Producto> productoSel() {
        List<Producto> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("mendet_id,")
                .append("menu_id,")
                .append("mendet_nombre,")
                .append("mendet_imagen,")
                .append("mendet_precio,")
                .append("mendet_stock,")
                .append("mendet_estado")
                .append(" FROM menu_detalle");
        try (Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId_producto(rs.getInt(1));
                producto.setNombre(rs.getString(3));
                producto.setFoto(rs.getBinaryStream(4));
                producto.setPrecio(rs.getDouble(5));
                producto.setStock(rs.getInt(6));
                producto.setEstado(rs.getString(7));
                list.add(producto);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return list;
    }
    
    /**
     *@ return Entidad Producto con sus datos que se seleccionó 
     *@ parameter Integer id del producto seleccionado
     */
    @Override
    public Producto productoGet(Integer id) {
       Producto producto  = new Producto();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("mendet_id,")
                .append("menu_id,")
                .append("mendet_nombre,")
                .append("mendet_imagen,")
                .append("mendet_precio,")
                .append("mendet_stock,")
                .append("mendet_estado")
                .append(" FROM menu_detalle")
                .append(" WHERE mendet_id = ? ");
        try (Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                producto.setId_producto(rs.getInt(1));
                producto.setNombre(rs.getString(3));
                producto.setFoto(rs.getBinaryStream(4));
                producto.setPrecio(rs.getDouble(5));
                producto.setStock(rs.getInt(6));
                producto.setEstado(rs.getString(7));
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return producto;
    }
    
    /**
     *@ return String Mensaje
     *@ parameter Entidad producto que se quiere insertar
     */
    @Override
    public String productoIns(Producto producto) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO menu_detalle( ")
                .append("menu_id,")
                .append("mendet_nombre,")
                .append("mendet_imagen,")
                .append("mendet_precio,")
                .append("mendet_stock,")
                .append("mendet_estado")
                .append(") VALUES (?,?,?,?,?,?) ");
        try (Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, producto.getId_producto());
            ps.setString(2, producto.getNombre());
            ps.setBinaryStream(3, producto.getFoto());
            ps.setDouble(4, producto.getPrecio());
            ps.setInt(5, producto.getStock());
            ps.setString(6, producto.getEstado());
            int ctos = ps.executeUpdate();
            if (ctos == 0) {
                mensaje = "Cero filas insertadas";
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }
    
    /**
     *@ return String mensaje
     *@ parameter Entidad Producto que se quiere actualizar
     */
    @Override
    public String productoUpd(Producto producto) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE menu_detalle SET ")
                .append("mendet_nombre = ?,")
                .append("mendet_imagen = ?,")
                .append("mendet_precio = ?,")
                .append("mendet_stock = ?,")
                .append("mendet_estado = ?")
                .append("WHERE mendet_id = ? ");

        try (Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, producto.getNombre());
            ps.setBinaryStream(2, producto.getFoto());
            ps.setDouble(3, producto.getPrecio());
            ps.setDouble(4, producto.getStock());
            ps.setString(5, producto.getEstado());
            ps.setInt(6, producto.getId_producto());
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
     *@ return STRING mensaje
     *@ parameter List con los ids de los productos que se quiere eliminar
     */
    @Override
    public String productoDel(List<Integer> ids) {
         StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM menu_detalle WHERE ")
                .append("mendet_id = ? ");
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
     *@ return Entidad Producto con su datos
     *@ parameter int id del producto que se requiere sus datos
     * Recordatorio eliminarlo xd
     */
    @Override
    public Producto listarId(int id){
        Producto pmp=new Producto();
        String sql="select * from producto where Id_Producto="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                pmp.setId_producto(rs.getInt(1));
                pmp.setNombre(rs.getString(2));
                pmp.setDescripcion(rs.getString(3));
                pmp.setPrecio(rs.getDouble(4));
                pmp.setStock(rs.getInt(5));
                
            }
        } catch (Exception e) {
        }
        return pmp;
    }
    
    /**
     *@ return Entidad Producto que se busca
     *@ parameter int id que se quiere buscar sus datos del producto
     * Recordar eliminar xd
     */
    @Override
    public Producto buscar(int id){
        Producto p=new Producto();
        String sql="select * from producto where id_producto="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                p.setId_producto(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setDescripcion(rs.getString(3));
                p.setPrecio(rs.getDouble(4));
                p.setStock(rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return p;
    }
    
    /**
     *@ return String datos
     *@ parameter ninguno
     */
    @Override
    public String getMensaje() {
        return mensaje;
    }
    
    @Override
    public void listarImg(int id, HttpServletResponse response){
        String sql="select mendet_imagen from menu_detalle where mendet_id="+id;
        InputStream inputStream=null;
        OutputStream outputStream=null;
        BufferedInputStream bufferedInputStream=null;
        BufferedOutputStream bufferedOutputStream=null;
        try {
            outputStream=response.getOutputStream();
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            if(rs.next()){
                inputStream=rs.getBinaryStream(1);
            }
            bufferedInputStream=new BufferedInputStream(inputStream);
            bufferedOutputStream= new BufferedOutputStream(outputStream);
            int i=0; 
            while((i=bufferedInputStream.read())!=-1){
                bufferedOutputStream.write(i);
            }
        } catch (Exception e) {
        }
    }
    
    @Override
    public byte[] Foto(Integer id) {
        byte[] img = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("mendet_imagen")
                .append(" FROM menu_detalle WHERE mendet_id = ?");
        try (Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Blob blob = rs.getBlob(1);
                    if (blob != null) {
                        byte[] bytes = blob.getBytes(1, (int) blob.length());
                        blob.free();
                        img = bytes;
                    }
                } else {
                    img = null;
                }
            } catch (SQLException e) {
                mensaje = e.getMessage();
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return img;
    }
    
    
    @Override
    public String menuIns(Producto producto) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO menu( ")
                .append("menu_categoria,")
                .append("menu_nombre")
                .append(") VALUES (?,?) ");
        try (Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, producto.getDescripcion());
            ps.setString(2, producto.getNombre());
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
    public int productoBuscar() {
       int n=0;
        String sql="select max(menu_id) from menu";
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
    
    @Override
    public void pedidoDel(List<Integer> ids) {
         StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM menu WHERE ")
                .append("menu_id = ? ");
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
    }
    
    @Override
    public List listar(){
        List<Producto>productos=new ArrayList();
        String sql="select mendet_id,mendet_nombre,mendet_imagen,mendet_precio,mendet_stock from menu_detalle";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Producto p=new Producto();
                p.setId_producto(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setFoto(rs.getBinaryStream(3));
                p.setDescripcion(rs.getString(2));
                p.setPrecio(rs.getDouble(4));
                p.setStock(rs.getInt(5));
                productos.add(p);
            }
        } catch (Exception e) {
        }
        return productos;
    }
    
    
    
}

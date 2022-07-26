
package dao.impl;

import dao.DaoEmpleado;
import dto.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.ConectaBD;


public class DaoEmpleadoImpl implements DaoEmpleado{
    
    private ConectaBD conectaDb;
    private String mensaje;
    DaoEmpleado daoEmpleado = null;
    
    public DaoEmpleadoImpl(){
        this.conectaDb = new ConectaBD();
    }
    
    /**
     *@ return List de Empleados con sus datos
     *@ parameter ninguno
     */
    @Override
    public List<Empleado> EmpleadoSel() {
        List<Empleado>list=null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("emp_id, ")
                .append("emp_dni, ")
                .append("emp_nombres, ")
                .append("emp_apellidos, ")
                .append("emp_telefono, ")
                .append("emp_salario, ")
                .append("emp_usuario, ")
                .append("emp_pasword, ")
                .append("emp_tipo,")
                .append("emp_estado")
                .append(" FROM empleado");
        try (Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setId(rs.getInt(1));
                empleado.setDni(rs.getString(2));
                empleado.setNom(rs.getString(3));
                empleado.setApellido(rs.getString(4));
                empleado.setTelefono(rs.getString(5));
                empleado.setSalario(rs.getInt(6));
                empleado.setUser(rs.getString(7));
                empleado.setContraseña(rs.getString(8));
                empleado.setTipo(rs.getString(9));
                empleado.setEstado(rs.getString(10));
                
                list.add(empleado);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return list;
    }
    
    /**
     *@ return Entidad Empleado con sus datos
     *@ parameter id que ingresa para buscar datos del empleado
     */
    @Override
    public Empleado EmpleadoGet(Integer id) {
        Empleado empleado = new Empleado();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("emp_id, ")
                .append("emp_dni, ")
                .append("emp_nombres, ")
                .append("emp_apellidos, ")
                .append("emp_telefono, ")
                .append("emp_salario, ")
                .append("emp_usuario, ")
                .append("emp_pasword, ")
                .append("emp_tipo,")
                .append("emp_estado")
                .append(" FROM empleado")
                .append(" WHERE emp_id = ? ");
        try (Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                empleado.setId(rs.getInt(1));
                empleado.setDni(rs.getString(2));
                empleado.setNom(rs.getString(3));
                empleado.setApellido(rs.getString(4));
                empleado.setTelefono(rs.getString(5));
                empleado.setSalario(rs.getInt(6));
                empleado.setUser(rs.getString(7));
                empleado.setContraseña(rs.getString(8));
                empleado.setTipo(rs.getString(9));
                empleado.setEstado(rs.getString(10));
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return empleado;
    }
    
    /**
     *@ return String Mensaje
     *@ parameter Entidad Empleado que se ingresaron datos
     */
    @Override
    public String EmpleadoIns(Empleado Empleado) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO empleado( ")
                .append("emp_dni, ")
                .append("emp_nombres, ")
                .append("emp_apellidos, ")
                .append("emp_telefono, ")
                .append("emp_salario, ")
                .append("emp_usuario, ")
                .append("emp_pasword, ")
                .append("emp_tipo,")
                .append("emp_estado")
                .append(" )VALUES (?,?,?,?,?,?,?,?,?)");
        try (Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, Empleado.getDni());
            ps.setString(2, Empleado.getNom());
            ps.setString(3, Empleado.getApellido());
            ps.setString(4, Empleado.getTelefono());
            ps.setInt(5, Empleado.getSalario());
            ps.setString(6, Empleado.getUser());
            ps.setString(7, Empleado.getContraseña());
            ps.setString(8, Empleado.getTipo());
            ps.setString(9, Empleado.getEstado());
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
     *@ return String Mensaje
     *@ parameter Entidad Empleado que se quiere actualizar
     */
    @Override
    public String EmpleadoUpd(Empleado Empleado) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE empleado SET ")
                .append("emp_dni = ?,")
                .append("emp_nombres = ?,")
                .append("emp_apellidos = ?,")
                .append("emp_telefono = ?, ")
                .append("emp_salario = ?, ")
                .append("emp_usuario = ?, ")
                .append("emp_pasword = ?, ")
                .append("emp_estado = ?, ")
                .append("emp_tipo = ? ")
                .append("WHERE emp_id = ? ");

        try (Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, Empleado.getDni());
            ps.setString(2, Empleado.getNom());
            ps.setString(3, Empleado.getApellido());
            ps.setString(4, Empleado.getTelefono());
            ps.setInt(5, Empleado.getSalario());
            ps.setString(6, Empleado.getUser());
            ps.setString(7, Empleado.getContraseña());
            ps.setString(8, Empleado.getEstado());
            ps.setString(9, Empleado.getTipo());
            ps.setInt(10, Empleado.getId());
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
     *@ parameter List de ids de empleados que se quieren eliminar
     */
    @Override
    public String EmpleadoDel(List<Integer> ids) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM empleado WHERE ")
                .append("emp_id = ? ");
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
     *@ return Entidad Empleado para ingresar a la pagina.
     *@ parameter String user && String pass introducidos de la página login.jsp
     */
    @Override
    public Empleado login(String user, String pass){
        Empleado empleado = new Empleado();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("emp_id, ")
                .append("emp_dni, ")
                .append("emp_nombres, ")
                .append("emp_apellidos, ")
                .append("emp_telefono, ")
                .append("emp_usuario, ")
                .append("emp_tipo,")
                .append("emp_estado")
                .append(" FROM empleado WHERE emp_usuario = ? ")
                .append(" AND emp_pasword = ? ");
        try (Connection cn = conectaDb.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, user);
            ps.setString(2, pass);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                empleado.setId(rs.getInt(1));
                empleado.setDni(rs.getString(2));
                empleado.setNom(rs.getString(3));
                empleado.setApellido(rs.getString(4));
                empleado.setTelefono(rs.getString(5));
                empleado.setUser(rs.getString(6));
                empleado.setTipo(rs.getString(7));
                empleado.setEstado(rs.getString(8));
            }else{
                    empleado=null;
                    mensaje="Usuario y/o contraseñas incorrectas";
                }
            } catch (Exception e) {
                mensaje = e.getMessage();
            }
            
            
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return empleado;
    }
    
    
    
    @Override
    public String getMensaje() {
        return mensaje;
    }
    
}

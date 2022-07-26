/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author marlo
 */
public class Detalle_Venta {
    Integer iddetalle;
    Integer idventa;
    String name;
    int cantidad;
    double precio;
    String estado;

    public Detalle_Venta() {
    }

    public Detalle_Venta(Integer iddetalle, Integer idventa, String name, int cantidad, double precio, String estado) {
        this.iddetalle = iddetalle;
        this.idventa = idventa;
        this.name = name;
        this.cantidad = cantidad;
        this.precio = precio;
        this.estado = estado;
    }

    public Integer getIddetalle() {
        return iddetalle;
    }

    public void setIddetalle(Integer iddetalle) {
        this.iddetalle = iddetalle;
    }

    public Integer getIdventa() {
        return idventa;
    }

    public void setIdventa(Integer idventa) {
        this.idventa = idventa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
    
    
    
}

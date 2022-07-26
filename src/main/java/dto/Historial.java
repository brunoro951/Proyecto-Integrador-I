/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author marlo
 */
public class Historial {
    Integer idventa;
    String nombrec;
    String nombree;
    int mesa;
    String tipo;
    String numserie;
    String fecha;
    double monto;
    String estado;

    public Historial() {
    }

    public Historial(Integer idventa, String nombrec, String nombree, int mesa, String tipo, String numserie, String fecha, double monto, String estado) {
        this.idventa = idventa;
        this.nombrec = nombrec;
        this.nombree = nombree;
        this.mesa = mesa;
        this.tipo = tipo;
        this.numserie = numserie;
        this.fecha = fecha;
        this.monto = monto;
        this.estado = estado;
    }

    public Integer getIdventa() {
        return idventa;
    }

    public void setIdventa(Integer idventa) {
        this.idventa = idventa;
    }

    public String getNombrec() {
        return nombrec;
    }

    public void setNombrec(String nombrec) {
        this.nombrec = nombrec;
    }

    public String getNombree() {
        return nombree;
    }

    public void setNombree(String nombree) {
        this.nombree = nombree;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumserie() {
        return numserie;
    }

    public void setNumserie(String numserie) {
        this.numserie = numserie;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
    
}

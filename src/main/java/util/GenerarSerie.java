/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


public class GenerarSerie {
    int dato;
    String numero;
    
    public String NumeroSerie(int dato){
        this.dato = dato + 1;
        numero = String.format("%08d", this.dato);
        return numero;
    }
}

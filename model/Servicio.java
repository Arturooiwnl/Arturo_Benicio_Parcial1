/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author Cristian
 *
 * Primer Parcial Programacion II | Arturo Benicio Perotto | div 122
 *
 */
public abstract class Servicio {

    // ATRIBUTOS
    private String codServicio;
    private double porcentajeDescuento;
    private boolean enPromocion;

    // CONSTRUCCTOR
    public Servicio(String codServicio, double porcentajeDescuento, boolean enPromocion) throws Exception {
        if (codServicio.length() != 6) {
            throw new Exception("El codigo de servicio debe contener 6 digitos!");
        }
        this.codServicio = codServicio;
        this.porcentajeDescuento = porcentajeDescuento;
        this.enPromocion = enPromocion;
    }

    // GETTERS
    public String getCodServicio() {
        return codServicio;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public boolean isEnPromocion() {
        return enPromocion;
    }

    // METODO (abstracto)
    public abstract double calcularPrecioFinal(LocalDate dia);
}

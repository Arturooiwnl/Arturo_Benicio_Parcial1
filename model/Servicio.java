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
    private String codServicio;
    private double porcentajeDescuento;
    private boolean enPromocion;

    // CONSTRUCTOR
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
        return codServicio; // return de el codigo del servicio
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento; // return del porcentaje del descuento
    }

    public boolean isEnPromocion() {
        return enPromocion; // return de los que estan en promocion
    }

    // METODO (abstracto)
    public abstract double calcularPrecioFinal(LocalDate dia); // calculaa el precio final segun la fecha
}

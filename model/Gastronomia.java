package model;

import java.time.LocalDate;

/**
 *
 * @author Cristian
 *
 * Primer Parcial Programacion II | Arturo Benicio Perotto | div 122
 *
 */
public class Gastronomia extends Servicio {

    // ATRIBUTOS
    private String gastronomia;
    private double precio;
    private int diaSemDesc;

    // CONSTRUCTOR
    public Gastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion,
                       String gastronomia, double precio, int diaSemDesc) throws Exception {
        super(codServicio, porcentajeDescuento, enPromocion);
        
        // VALIDAR
        if (porcentajeDescuento < 0 || porcentajeDescuento > 100) {
            throw new Exception("El porcentaje de descuento debe estar entre 0 y 100!");
        }
        if (precio <= 0) {
            throw new Exception("El precio debe ser un valor positivo!");
        }
        if (diaSemDesc < 1 || diaSemDesc > 7) {
            throw new Exception("El dia de la semana debe estar entre 1 y 7!");
        }
        
        this.gastronomia = gastronomia;
        this.precio = precio;
        this.diaSemDesc = diaSemDesc;
    }

    // METODOS
    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        if (isEnPromocion() && dia.getDayOfWeek().getValue() == diaSemDesc) {
            return precio - (precio * (getPorcentajeDescuento() / 100));
        }
        return precio;
    }
}

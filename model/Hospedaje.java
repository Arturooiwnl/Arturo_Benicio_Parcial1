package model;

import java.time.LocalDate;

/**
 *
 * @author Cristian
 *
 * Primer Parcial Programacion II | Arturo Benicio Perotto | div 122
 *
 */
public class Hospedaje extends Servicio {

    // ATRIBUTOS
    private String hospedaje;
    private double precioPorNoche;

    // CONSTRUCTOR
    public Hospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion,
                     String hospedaje, double precioPorNoche) throws Exception {
        super(codServicio, porcentajeDescuento, enPromocion);
        
        // VALIDAR
        if (porcentajeDescuento < 0 || porcentajeDescuento > 100) {
            throw new Exception("El porcentaje de descuento debe estar entre 0 y 100!");
        }
        if (precioPorNoche <= 0) {
            throw new Exception("El precio por noche debe ser un valor positivo!");
        }

        this.hospedaje = hospedaje;
        this.precioPorNoche = precioPorNoche;
    }

    // METODOS 
    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        if (isEnPromocion() && dia.getDayOfWeek().getValue() >= 1 && dia.getDayOfWeek().getValue() <= 5) {
            return precioPorNoche - (precioPorNoche * (getPorcentajeDescuento() / 100));
        }
        return precioPorNoche;
    }
}

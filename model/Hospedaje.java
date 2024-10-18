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
    // calcula el precio final con descuento si esta en promocion
    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        if (isEnPromocion() && dia.getDayOfWeek().getValue() >= 1 && dia.getDayOfWeek().getValue() <= 5) {
            return precioPorNoche - (precioPorNoche * (getPorcentajeDescuento() / 100));
        }
        return precioPorNoche; // return precio final sin descuento
    }

    // representa el objeto como una cadena para facilitar la lectura
    @Override
    public String toString() {
        return "Hospedaje{" + "hospedaje=" + hospedaje + ", precioPorNoche=" + precioPorNoche + '}'; 
    }
}

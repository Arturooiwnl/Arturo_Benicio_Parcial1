package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristian
 *
 * Primer Parcial Programacion II | Arturo Benicio Perotto | div 122
 *
 */
public class Sistema {
    private List<Servicio> lstServicio;

    // CONSTRUCTOR
    public Sistema() {
        this.lstServicio = new ArrayList<>();
    }

    // GETTERS
    public List<Servicio> getLstServicio() {
        return lstServicio;
    }

    // METODOS
    //busca un servicio por su codigo
    public Servicio traerServicio(String codServicio) {
        for (Servicio servicio : lstServicio) {
            if (servicio.getCodServicio().equals(codServicio)) {
                return servicio; // return de lo encontrado
            }
        }
        return null; //return null si no encuentra
    }

    // filtra si estan en promocion o no
    public List<Servicio> traerServicios(boolean enPromocion) {
        List<Servicio> serviciosEnPromocion = new ArrayList<>();
        for (Servicio servicio : lstServicio) {
            if (servicio.isEnPromocion() == enPromocion) {
                serviciosEnPromocion.add(servicio); // Agrega el servicio a la lista
            }
        }
        return serviciosEnPromocion; // Devuelve la lista filtrada
    }

    
    //sobrecarga para filtrar segun feche
     
    public List<Servicio> traerServicios(boolean enPromocion, LocalDate dia) {
        return traerServicios(enPromocion); // call a la funcion anterior
    }

    
    //agrega un servicio gastronomico a la lista.
    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion,
            String gastronomia, double precio, int diaSemDesc) throws Exception {
        if (traerServicio(codServicio) != null) {
            throw new Exception("El servicio con ese codigo ya existe."); // Evita duplicados
        }
        Gastronomia gastronomiaServicio = new Gastronomia(codServicio, porcentajeDescuento, enPromocion, gastronomia, precio, diaSemDesc);
        return lstServicio.add(gastronomiaServicio); // Agrega el nuevo servicio
    }
    //agrega un servicio gastronomico a la lista.
    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion,
            String hospedaje, double precioPorNoche) throws Exception {
        if (traerServicio(codServicio) != null) {
            throw new Exception("El servicio con ese codigo ya existe."); // exception para duplicados
        }
        Hospedaje hospedajeServicio = new Hospedaje(codServicio, porcentajeDescuento, enPromocion, hospedaje, precioPorNoche);
        return lstServicio.add(hospedajeServicio); // add al nuevo servicio
    }

    // Devuelve todos los servicios que están en promocion.
    public List<Servicio> traerServiciosEnPromocion() {
        return traerServicios(true); // call al metodo anterior con true
    }


     // Devuelve los servicios en promocion para un dia establecido
    public List<Servicio> traerServiciosEnPromocion(LocalDate dia) {
        List<Servicio> serviciosEnPromocion = new ArrayList<>();
        for (Servicio servicio : lstServicio) {
            if (servicio.isEnPromocion() && (servicio.calcularPrecioFinal(dia) > 0)) {
                serviciosEnPromocion.add(servicio); // agrega el servicio a la lista
            }
        }
        return serviciosEnPromocion; // return de la lista filtrada
    }
}

package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Servicio> lstServicio;

    public Sistema() {
        this.lstServicio = new ArrayList<>();
    }

    public Servicio traerServicio(String codServicio) {
        for (Servicio servicio : lstServicio) {
            if (servicio.getCodServicio().equals(codServicio)) {
                return servicio;
            }
        }
        return null;
    }

    public List<Servicio> getLstServicio() {
        return lstServicio;
    }
    
    public List<Servicio> traerServicios(boolean enPromocion) {
        List<Servicio> serviciosEnPromocion = new ArrayList<>();
        for (Servicio servicio : lstServicio) {
            if (servicio.isEnPromocion() == enPromocion) {
                serviciosEnPromocion.add(servicio);
            }
        }
        return serviciosEnPromocion;
    }

    public List<Servicio> traerServicios(boolean enPromocion, LocalDate dia) {
        List<Servicio> serviciosEnPromocion = new ArrayList<>();
        for (Servicio servicio : lstServicio) {
            if (servicio.isEnPromocion() == enPromocion) {
                serviciosEnPromocion.add(servicio);
            }
        }
        return serviciosEnPromocion;
    }

    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, 
                                      String gastronomia, double precio, int diaSemDesc) throws Exception {
        if (traerServicio(codServicio) != null) {
            throw new Exception("El servicio con ese código ya existe.");
        }
        Gastronomia gastronomiaServicio = new Gastronomia(codServicio, porcentajeDescuento, enPromocion, gastronomia, precio, diaSemDesc);
        return lstServicio.add(gastronomiaServicio);
    }

    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, 
                                    String hospedaje, double precioPorNoche) throws Exception {
        if (traerServicio(codServicio) != null) {
            throw new Exception("El servicio con ese código ya existe.");
        }
        Hospedaje hospedajeServicio = new Hospedaje(codServicio, porcentajeDescuento, enPromocion, hospedaje, precioPorNoche);
        return lstServicio.add(hospedajeServicio);
    }

    // Método para traer todos los servicios en promoción
    public List<Servicio> traerServiciosEnPromocion() {
        return traerServicios(true);
    }

    // Método para traer servicios en promoción en un día específico
    public List<Servicio> traerServiciosEnPromocion(LocalDate dia) {
        List<Servicio> serviciosEnPromocion = new ArrayList<>();
        for (Servicio servicio : lstServicio) {
            if (servicio.isEnPromocion() && (servicio.calcularPrecioFinal(dia) > 0)) {
                serviciosEnPromocion.add(servicio);
            }
        }
        return serviciosEnPromocion;
    }
}

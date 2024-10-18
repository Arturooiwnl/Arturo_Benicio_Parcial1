package test;

import java.time.LocalDate;
import model.Sistema;
import model.Servicio;

public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();

        try {
            // 1-1) CREAR GASTRONOMIA INVALIDO
            System.out.println("1-1");
            sistema.agregarGastronomia("4892", 15.0, true, "Hamburguesa criolla", 180.0, 4);
        } catch (Exception e) {
            System.out.println("ERROR | " + e.getMessage()); // msg de error
        }

        try {
            // 1-2) CREAR GASTRONOMIA VALIDO
            System.out.println("1-2");
            sistema.agregarGastronomia("489235", 15.0, true, "Hamburguesa criolla", 180.0, 4);
        } catch (Exception e) {
            System.out.println("ERROR | " + e.getMessage());
        }

        try {
            // 1-3) CREAR HOSPEDAJE INVALIDO
            System.out.println("1-3");
            sistema.agregarHospedaje("2872", 10.0, true, "Cabaña 3 personas", 1500.0);
        } catch (Exception e) {
            System.out.println("ERROR | " + e.getMessage()); // msg de error
        }

        try {
            // 1-4) CREAR HOSPEDAJE VALIDO
            System.out.println("1-4");
            sistema.agregarHospedaje("287282", 10.0, true, "Cabaña 3 personas", 1500.0);
        } catch (Exception e) {
            System.out.println("ERROR | " + e.getMessage());
        }

        // 2-1 | 2-2) PRECIOS
        System.out.println("2-1");
        Servicio gastronomia = sistema.traerServicio("489235");
        if (gastronomia != null) {
            System.out.println(gastronomia.calcularPrecioFinal(LocalDate.of(2020, 10, 28))); // precio con descuento
        }

        System.out.println("2-2");
        Servicio hospedaje = sistema.traerServicio("287282");
        if (hospedaje != null) {
            System.out.println(hospedaje.calcularPrecioFinal(LocalDate.of(2020, 10, 27))); // precio con descuento
        }

        // 3) AGREGAR SERVICIOS
        try {
            sistema.agregarGastronomia("858927", 15.0, true, "Milanesa con puré", 350.0, 3);
            sistema.agregarHospedaje("489259", 10.0, true, "Habitación triple", 2200.0);
            sistema.agregarGastronomia("182835", 20.0, false, "Gaseosa", 120.0, 3);
            sistema.agregarHospedaje("758972", 15.0, false, "Habitación simple", 1000.0);
        } catch (Exception e) {
            System.out.println("ERROR al agregar servicios: " + e.getMessage());
        }

        // IMPRIMIR LA LISTA DE SERVICIOS
        System.out.println("Lista de servicios:");
        for (Servicio servicio : sistema.getLstServicio()) {
            System.out.println(servicio);
        }

        // 4-1) TRAER SERVICIOS CON PROMOCION=TRUE
        System.out.println("4-1");
        for (Servicio servicio : sistema.traerServiciosEnPromocion()) {
            System.out.println("Servicio en promoción: " + servicio.getCodServicio());
        }

        // 4-2) TRAER SERVICIOS EN PROMOCION DE LA FECHA 2020-10-28
        System.out.println("4-2");
        for (Servicio servicio : sistema.traerServiciosEnPromocion(LocalDate.of(2020, 10, 28))) {
            System.out.println("Servicio en promoción el 2020-10-28: " + servicio.getCodServicio());
        }
    }
}

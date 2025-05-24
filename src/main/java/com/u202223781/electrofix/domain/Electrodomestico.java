package com.u202223781.electrofix.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Electrodomestico {

    private String numeroSerie;
    private String marca;
    private String modelo;
    private Date fechaCompra;
    private List<Reparacion> reparaciones = new ArrayList<>();

    public Electrodomestico(String numeroSerie, String marca, String modelo, Date fechaCompra) {
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.modelo = modelo;
        this.fechaCompra = fechaCompra;
    }

    /**
     * @param reparacion La reparación a agregar.
     * @autor u202223781, Joan Talizo Balbin
     */
    public void agregarReparacion(Reparacion reparacion) {
        if (reparacion != null) {
            reparaciones.add(reparacion);
            System.out.println("Reparación agregada para el electrodoméstico: " + modelo);
        } else {
            System.out.println("No se puede agregar una reparación nula.");
        }
    }

    public void verHistorial() {
        System.out.println("Historial de reparaciones del electrodoméstico [" + modelo + "]:");
        for (Reparacion r : reparaciones) {
            System.out.println("- Estado: " + r.getEstado() + ", Fecha: " + r.getFechaSolicitud());
        }
    }

}
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
public class Reparacion {

    private Date fechaSolicitud;
    private String estado;
    private List<String> multimedia = new ArrayList<>();
    private List<Repuesto> repuestos = new ArrayList<>();
    private Electrodomestico electrodomestico; // Asociación con el electrodoméstico

    public Reparacion(Date fechaSolicitud, Electrodomestico electrodomestico) {
        this.fechaSolicitud = fechaSolicitud;
        this.electrodomestico = electrodomestico;
        this.estado = "Pendiente";
    }

    /**
     * Asocia un repuesto a la reparación.
     *
     * @param repuesto El repuesto a asociar.
     */
    public void asociarRepuesto(Repuesto repuesto) {
        if (repuesto != null) {
            repuestos.add(repuesto);
            System.out.println("Repuesto asociado: " + repuesto.getNombre());
        } else {
            System.out.println("No se puede asociar un repuesto nulo.");
        }
    }

    /**
     * Agrega un elemento multimedia (foto, video, etc.) al registro de la reparación.
     * @param media La ruta o referencia al archivo multimedia.
     */
    public void agregarMultimedia(String media) {
        if (media != null && !media.isBlank()) {
            multimedia.add(media);
            System.out.println("Multimedia agregada: " + media);
        } else {
            System.out.println("No se puede agregar multimedia nula o vacía.");
        }
    }

    /**
     * Actualiza el estado actual de la reparación.
     * @param nuevoEstado El nuevo estado a establecer.
     */
    public void actualizarEstado(String nuevoEstado) {
        if (nuevoEstado != null && !nuevoEstado.isBlank()) {
            this.estado = nuevoEstado;
            System.out.println("Estado de la reparación actualizado: " + estado);
        } else {
            System.out.println("No se puede actualizar a un estado nulo o vacío.");
        }
    }
}
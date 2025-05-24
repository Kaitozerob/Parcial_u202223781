package com.u202223781.electrofix.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Tecnico extends Usuario {

    private String numeroTecnico;
    private String experiencia;
    private List<Reparacion> reparaciones = new ArrayList<>();

    public Tecnico(String dni, String correo, String direccion, String numeroTecnico, String experiencia) {
        super(dni, correo, direccion);
        this.numeroTecnico = numeroTecnico;
        this.experiencia = experiencia;
    }

    /**
     * Registra el estado de un electrodoméstico recibido.
     * @param electrodomestico El electrodoméstico recibido.
     * @param estado           El estado registrado.
     * @Autor u202223781
     */
    public void registrarEstado(Electrodomestico electrodomestico, String estado) {
        if (electrodomestico != null && estado != null && !estado.isBlank()) {
            System.out.println("Estado registrado para el electrodoméstico: " + electrodomestico.getModelo() +
                    ", Estado: " + estado);
        } else {
            System.out.println("No se puede registrar el estado con datos nulos o vacíos.");
        }
    }

    /**
     * Sube multimedia (foto, video) asociado a la reparación.
     * @param reparacion La reparación a la que se asocia el archivo multimedia.
     * @param media      La referencia al archivo multimedia.
     */
    public void subirMultimedia(Reparacion reparacion, String media) {
        if (reparacion != null && media != null && !media.isBlank()) {
            reparacion.agregarMultimedia(media);
            System.out.println("Multimedia subida para reparación.");
        } else {
            System.out.println("No se puede subir multimedia con datos nulos o vacíos.");
        }
    }

    /**
     * Genera una cotización para la reparación.
     * @param reparacion La reparación para la cual generar la cotización.
     */
    public void generarCotizacion(Reparacion reparacion) {
        if (reparacion != null) {
            System.out.println("Cotización generada para reparación del electrodoméstico: " +
                    reparacion.getElectrodomestico().getModelo());
        } else {
            System.out.println("No se puede generar cotización para una reparación nula.");
        }
    }

    /**
     * Gestiona el stock de repuestos propio del técnico.
     */
    public void gestionarStock() {
        System.out.println("Stock de repuestos gestionado por el técnico: " + numeroTecnico);
    }

    /**
     * Solicita un repuesto específico.
     * @param repuesto El repuesto que se desea solicitar.
     */
    public void solicitarRepuestos(Repuesto repuesto) {
        if (repuesto != null) {
            System.out.println("Repuesto solicitado: " + repuesto.getNombre());
        } else {
            System.out.println("No se puede solicitar un repuesto nulo.");
        }
    }

    /**
     * Actualiza el estado de una reparación.
     * @param reparacion La reparación a actualizar.
     * @param nuevoEstado El nuevo estado de la reparación.
     */
    public void actualizarEstadoReparacion(Reparacion reparacion, String nuevoEstado) {
        if (reparacion != null && nuevoEstado != null && !nuevoEstado.isBlank()) {
            reparacion.actualizarEstado(nuevoEstado);
            System.out.println("Estado de reparación actualizado por el técnico: " + numeroTecnico);
        } else {
            System.out.println("No se puede actualizar el estado de la reparación con datos nulos o vacíos.");
        }
    }
}
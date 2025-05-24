package com.u202223781.electrofix.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class Cliente extends Usuario {

    private List<Electrodomestico> electrodomesticos = new ArrayList<>();

    public Cliente(String dni, String correo, String direccion) {
        super(dni, correo, direccion);
    }

    /**
     * Registra un nuevo electrodoméstico para el cliente.
     * @param electrodomestico El electrodoméstico a registrar.
     */
    public void registrarElectrodomestico(Electrodomestico electrodomestico) {
        if (electrodomestico != null) {
            electrodomesticos.add(electrodomestico);
            System.out.println("Electrodoméstico registrado: " + electrodomestico.getModelo());
        } else {
            System.out.println("No se puede registrar un electrodoméstico nulo.");
        }
    }

    /**
     * Se va a solicitar una reparación para un electrodoméstico.
     * @param reparacion La reparación a solicitar.
     * @Autor u202223781
     */
    public void solicitarReparacion(Reparacion reparacion) {
        if (reparacion != null) {
            if (reparacion.getElectrodomestico() != null) {
                System.out.println("Reparación solicitada para: "
                        + reparacion.getElectrodomestico().getModelo());
            } else {
                System.out.println("Reparación solicitada, pero el electrodoméstico asociado es nulo.");
            }
        } else {
            System.out.println("No se puede solicitar una reparación nula.");
        }
    }

    /**
     * Muestra el historial de reparaciones de todos los electrodomésticos del cliente.
     */
    public void verHistorial() {
        System.out.println("Historial de reparaciones para el cliente con DNI: " + getDni());
        for (Electrodomestico e : electrodomesticos) {
            e.verHistorial();
        }
    }
}
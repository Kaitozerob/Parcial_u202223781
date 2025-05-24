package com.u202223781.electrofix.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Repuesto {

    private String nombre;
    private String marcaCompatible;
    private String modeloCompatible;
    private String garantia;
    private float precio;
    private String estado = "nuevo";
    private Reparacion reparacionAsociada;

    public Repuesto(String nombre, String marcaCompatible, String modeloCompatible,
                    String garantia, float precio) {
        this.nombre = nombre;
        this.marcaCompatible = marcaCompatible;
        this.modeloCompatible = modeloCompatible;
        this.garantia = garantia;
        this.precio = precio;
    }

    /**
     * Asocia el repuesto a una reparación específica.
     * @param reparacion La reparación a la que se asocia.
     */
    public void asignarAReparacion(Reparacion reparacion) {
        if (reparacion != null) {
            this.reparacionAsociada = reparacion;
            System.out.println("Repuesto '" + nombre + "' asignado a reparación del electrodoméstico: "
                    + reparacion.getElectrodomestico().getModelo());
        } else {
            System.out.println("No se puede asociar a una reparación nula.");
        }
    }
}
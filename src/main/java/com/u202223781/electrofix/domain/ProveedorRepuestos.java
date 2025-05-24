package com.u202223781.electrofix.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProveedorRepuestos {

    private String nombreEmpresa;
    private String paisFabricacion;
    private List<Repuesto> repuestos = new ArrayList<>();

    public ProveedorRepuestos(String nombreEmpresa, String paisFabricacion) {
        this.nombreEmpresa = nombreEmpresa;
        this.paisFabricacion = paisFabricacion;
    }

    /**
     * Publica un nuevo repuesto ofrecido por el proveedor.
     * @param repuesto El repuesto a publicar.
     */
    public void publicarRepuesto(Repuesto repuesto) {
        if (repuesto != null) {
            repuestos.add(repuesto);
            System.out.println("Repuesto publicado: " + repuesto.getNombre());
        } else {
            System.out.println("No se puede publicar un repuesto nulo.");
        }
    }

    /**
     * Vende un repuesto al técnico registrado.
     * @param repuesto El repuesto a vender.
     * @param tecnico El técnico que comprará el repuesto.
     */
    public void venderRepuesto(Repuesto repuesto, Tecnico tecnico) {
        if (repuesto != null && tecnico != null) {
            System.out.println("Repuesto vendido: " + repuesto.getNombre() + " al técnico: " + tecnico.getDni());
        } else {
            System.out.println("No se puede completar la venta. Datos nulos.");
        }
    }

    /**
     * Valida la compatibilidad de un repuesto con un electrodoméstico.
     * @param repuesto El repuesto a validar.
     * @param electrodomestico El electrodoméstico a comprobar.
     */
    public void validarCompatibilidad(Repuesto repuesto, Electrodomestico electrodomestico) {
        if (repuesto != null && electrodomestico != null) {
            if (repuesto.getMarcaCompatible().equals(electrodomestico.getMarca())
                    && repuesto.getModeloCompatible().equals(electrodomestico.getModelo())) {
                System.out.println("Repuesto compatible con el electrodoméstico.");
            } else {
                System.out.println("Repuesto NO compatible con el electrodoméstico.");
            }
        } else {
            System.out.println("No se puede validar compatibilidad con datos nulos.");
        }
    }
}
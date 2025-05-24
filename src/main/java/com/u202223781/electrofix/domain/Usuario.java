package com.u202223781.electrofix.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class Usuario {

    private String dni;
    private String correo;
    private String direccion;

    public Usuario(String dni, String correo, String direccion) {
        this.dni = dni;
        this.correo = correo;
        this.direccion = direccion;
    }

    /**
     * Simula el registro de un usuario.
     * @Autor u202223781
     */
    public void registrarse() {
        System.out.println("Usuario registrado con DNI: " + dni);
    }

    /**
     * Actualiza la dirección del usuario.
     * @param nuevaDireccion La nueva dirección a establecer.
     */
    public void actualizarDireccion(String nuevaDireccion) {
        if (nuevaDireccion != null && !nuevaDireccion.isBlank()) {
            this.direccion = nuevaDireccion;
            System.out.println("Dirección actualizada para usuario con DNI: " + dni);
        } else {
            System.out.println("No se puede actualizar a una dirección nula o vacía.");
        }
    }
}
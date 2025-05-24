package com.u202223781.electrofix.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ProveedorRepuestosTest {

    private ProveedorRepuestos proveedor;
    private Repuesto repuesto;
    private Electrodomestico electrodomestico;
    private Tecnico tecnico;

    @BeforeEach
    public void setUp() {
        proveedor = new ProveedorRepuestos("Repuestos S.A.", "Perú");
        repuesto = new Repuesto("Motor", "MarcaA", "ModeloX", "6 meses", 100.0f);
        electrodomestico = new Electrodomestico("SERIE1234", "MarcaA", "ModeloX", new Date());
        tecnico = new Tecnico("87654321", "tecnico@email.com", "Av. Principal 456", "TEC001", "MarcaA, MarcaB");
    }

    @Test
    public void testPublicarRepuesto() {
        proveedor.publicarRepuesto(repuesto);

        assertTrue(proveedor.getRepuestos().contains(repuesto),
                "El repuesto debe haberse publicado correctamente.");
    }

    @Test
    public void testVenderRepuesto() {
        assertDoesNotThrow(() -> proveedor.venderRepuesto(repuesto, tecnico),
                "La venta de repuesto debe ejecutarse sin excepciones.");
    }

    @Test
    public void testValidarCompatibilidadExitosa() {
        assertDoesNotThrow(() -> proveedor.validarCompatibilidad(repuesto, electrodomestico),
                "La validación de compatibilidad debe ejecutarse sin excepciones.");
    }
}
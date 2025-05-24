package com.u202223781.electrofix.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ElectrodomesticoTest {

    private Electrodomestico electrodomestico;
    private Reparacion reparacion;

    @BeforeEach
    public void setUp() {
        electrodomestico = new Electrodomestico("SERIE1234", "MarcaA", "ModeloX", new Date());
        reparacion = new Reparacion(new Date(), electrodomestico);
    }

    @Test
    public void testAgregarReparacion() {
        electrodomestico.agregarReparacion(reparacion);

        assertTrue(electrodomestico.getReparaciones().contains(reparacion),
                "La reparación debe agregarse correctamente al electrodoméstico.");
    }

    @Test
    public void testVerHistorialSinErrores() {
        electrodomestico.agregarReparacion(reparacion);

        assertDoesNotThrow(() -> electrodomestico.verHistorial(),
                "La visualización del historial no debe generar excepciones.");
    }
}
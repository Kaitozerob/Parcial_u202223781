package com.u202223781.electrofix.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ReparacionTest {

    private Reparacion reparacion;
    private Electrodomestico electrodomestico;

    @BeforeEach
    public void setUp() {
        electrodomestico = new Electrodomestico("1234", "MarcaA", "ModeloX", new Date());
        reparacion = new Reparacion(new Date(), electrodomestico);
    }

    @Test
    public void testAsociarRepuestoExitoso() {
        Repuesto repuesto = new Repuesto("Motor", "MarcaA", "ModeloX", "6 meses", 100.0f);

        reparacion.asociarRepuesto(repuesto);

        assertTrue(reparacion.getRepuestos().contains(repuesto), "El repuesto debe haberse agregado correctamente.");
    }

    @Test
    public void testAgregarMultimediaExitosa() {
        String multimedia = "video_diagnostico.mp4";

        reparacion.agregarMultimedia(multimedia);

        assertTrue(reparacion.getMultimedia().contains(multimedia), "La multimedia debe haberse agregado correctamente.");
    }

    @Test
    public void testActualizarEstadoExitoso() {
        String nuevoEstado = "Reparado";

        reparacion.actualizarEstado(nuevoEstado);

        assertEquals("Reparado", reparacion.getEstado(), "El estado debe haberse actualizado correctamente.");
    }

    @Test
    public void testFlujoCompletoReparacion() {
        Repuesto repuesto = new Repuesto("Motor", "MarcaA", "ModeloX", "6 meses", 100.0f);
        String multimedia = "video_diagnostico.mp4";
        String nuevoEstado = "Reparado";

        reparacion.asociarRepuesto(repuesto);
        reparacion.agregarMultimedia(multimedia);
        reparacion.actualizarEstado(nuevoEstado);

        assertTrue(reparacion.getRepuestos().contains(repuesto));
        assertTrue(reparacion.getMultimedia().contains(multimedia));
        assertEquals("Reparado", reparacion.getEstado());
    }
}
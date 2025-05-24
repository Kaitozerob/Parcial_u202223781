package com.u202223781.electrofix.domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TecnicoTest {

    private Tecnico tecnico;
    private Electrodomestico electrodomestico;
    private Reparacion reparacion;
    private Repuesto repuesto;

    @BeforeEach
    public void setUp() {
        tecnico = new Tecnico("87654321", "tecnico@email.com", "Av. Principal 456", "TEC001", "MarcaA, MarcaB");
        electrodomestico = new Electrodomestico("SERIE1234", "MarcaA", "ModeloX", new Date());
        reparacion = new Reparacion(new Date(), electrodomestico);
        repuesto = new Repuesto("Motor", "MarcaA", "ModeloX", "6 meses", 100.0f);
    }

    @Test
    public void testRegistrarEstado() {
        assertDoesNotThrow(() -> tecnico.registrarEstado(electrodomestico, "En diagnóstico"),
                "El estado del electrodoméstico debe registrarse sin excepciones.");
    }

    @Test
    public void testSubirMultimedia() {
        assertDoesNotThrow(() -> tecnico.subirMultimedia(reparacion, "video_diagnostico.mp4"),
                "La subida de multimedia debe ejecutarse sin excepciones.");
    }

    @Test
    public void testGenerarCotizacion() {
        assertDoesNotThrow(() -> tecnico.generarCotizacion(reparacion),
                "La generación de la cotización debe ejecutarse sin excepciones.");
    }

    @Test
    public void testGestionarStock() {
        assertDoesNotThrow(tecnico::gestionarStock,
                "La gestión del stock debe ejecutarse sin excepciones.");
    }

    @Test
    public void testSolicitarRepuestos() {
        assertDoesNotThrow(() -> tecnico.solicitarRepuestos(repuesto),
                "La solicitud de repuestos debe ejecutarse sin excepciones.");
    }

    @Test
    public void testActualizarEstadoReparacion() {
        tecnico.actualizarEstadoReparacion(reparacion, "Reparado");
        assertEquals("Reparado", reparacion.getEstado(),
                "El estado de la reparación debe actualizarse correctamente.");
    }
}
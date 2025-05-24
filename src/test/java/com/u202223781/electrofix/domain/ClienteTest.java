package com.u202223781.electrofix.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    private Cliente cliente;
    private Electrodomestico electrodomestico;
    private Reparacion reparacion;

    @BeforeEach
    public void setUp() {
        cliente = new Cliente("12345678", "cliente@email.com", "Calle 123");
        electrodomestico = new Electrodomestico("SERIE1234", "MarcaA", "ModeloX", new Date());
        reparacion = new Reparacion(new Date(), electrodomestico);
    }

    @Test
    public void testRegistrarElectrodomestico() {
        cliente.registrarElectrodomestico(electrodomestico);

        assertTrue(cliente.getElectrodomesticos().contains(electrodomestico),
                "El electrodoméstico debe haberse registrado correctamente.");
    }

    @Test
    public void testSolicitarReparacion() {
        cliente.solicitarReparacion(reparacion);

        // Aquí no hay un almacenamiento real de la reparación, solo el println.
        // Pero podemos asumir que se ejecutó la acción porque no lanza excepciones.
        assertDoesNotThrow(() -> cliente.solicitarReparacion(reparacion),
                "La solicitud de reparación debe ejecutarse sin excepciones.");
    }

    @Test
    public void testVerHistorial() {
        cliente.registrarElectrodomestico(electrodomestico);
        electrodomestico.agregarReparacion(reparacion);

        assertDoesNotThrow(() -> cliente.verHistorial(),
                "La visualización del historial debe ejecutarse sin excepciones.");
    }
}

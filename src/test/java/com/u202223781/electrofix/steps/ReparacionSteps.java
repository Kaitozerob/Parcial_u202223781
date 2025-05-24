package com.u202223781.electrofix.steps;

import com.u202223781.electrofix.domain.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ReparacionSteps {

    private Cliente cliente;
    private Electrodomestico electrodomestico;
    private Reparacion reparacion;
    private ProveedorRepuestos proveedor;
    private Repuesto repuesto;
    private Tecnico tecnico;

    @Given("el cliente {string} con correo {string} y dirección {string}")
    public void elClienteConDatos(String dni, String correo, String direccion) {
        cliente = new Cliente(dni, correo, direccion);
        System.out.println("Cliente registrado con DNI: " + dni);
    }

    @Given("tiene un electrodoméstico con número de serie {string}, marca {string} y modelo {string}")
    public void tieneUnElectrodomestico(String numeroSerie, String marca, String modelo) {
        electrodomestico = new Electrodomestico(numeroSerie, marca, modelo, new Date());
        cliente.registrarElectrodomestico(electrodomestico);
        System.out.println("Electrodoméstico registrado: " + modelo);
    }

    @When("el cliente solicita una reparación")
    public void elClienteSolicitaUnaReparacion() {
        reparacion = new Reparacion(new Date(), electrodomestico);
        cliente.solicitarReparacion(reparacion);
    }

    @Then("la reparación debe ser registrada correctamente para el electrodoméstico")
    public void laReparacionDebeSerRegistrada() {
        assertTrue(electrodomestico.getReparaciones().contains(reparacion),
                "La reparación debe estar en el historial del electrodoméstico.");
    }

    @When("el cliente visualiza el historial de reparaciones")
    public void elClienteVisualizaHistorial() {
        cliente.verHistorial();
    }

    @Then("debe poder ver todas las reparaciones asociadas a su electrodoméstico")
    public void debeVerHistorial() {
        assertFalse(electrodomestico.getReparaciones().isEmpty(),
                "El historial de reparaciones no debe estar vacío.");
    }

    @Given("que existe una reparación en estado {string}")
    public void existeReparacionEnEstado(String estado) {
        reparacion = new Reparacion(new Date(), electrodomestico);
        reparacion.actualizarEstado(estado);
    }

    @When("el técnico actualiza el estado a {string}")
    public void tecnicoActualizaEstado(String nuevoEstado) {
        tecnico = new Tecnico("87654321", "tecnico@email.com", "Av. Principal 456", "TEC001", "MarcaA, MarcaB");
        tecnico.actualizarEstadoReparacion(reparacion, nuevoEstado);
    }

    @Then("la reparación debe reflejar el nuevo estado {string}")
    public void reparacionReflejaNuevoEstado(String nuevoEstado) {
        assertEquals(nuevoEstado, reparacion.getEstado(),
                "El estado de la reparación debe actualizarse correctamente.");
    }

    @Given("que el proveedor ofrece un repuesto con marca {string} y modelo {string}")
    public void proveedorOfreceRepuesto(String marca, String modelo) {
        proveedor = new ProveedorRepuestos("Repuestos S.A.", "Perú");
        repuesto = new Repuesto("Motor", marca, modelo, "6 meses", 100.0f);
        proveedor.publicarRepuesto(repuesto);
    }

    @When("el técnico solicita la validación de compatibilidad")
    public void tecnicoSolicitaValidacion() {
        proveedor.validarCompatibilidad(repuesto, electrodomestico);
    }

    @Then("el sistema debe confirmar que el repuesto es compatible")
    public void sistemaConfirmaCompatibilidad() {
        assertEquals(repuesto.getMarcaCompatible(), electrodomestico.getMarca(),
                "La marca del repuesto debe coincidir con la del electrodoméstico.");
        assertEquals(repuesto.getModeloCompatible(), electrodomestico.getModelo(),
                "El modelo del repuesto debe coincidir con el del electrodoméstico.");
    }
}
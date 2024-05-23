package com.unac.stepsdefinitions;

import com.unac.apis.GoRestApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

public class GetGoRestStepsdefinitions {

    private String userId;
    private String updatedName;
    private String updatedEmail;

    @Given("un usuario con id {string} necesita ser actualizado")
    public void unUsuarioConIdNecesitaSerActualizado(String id) {
        this.userId = id;
    }

    @When("el usuario con id {string} es actualizado con nombre {string} y correo {string}")
    public void actualizarUsuario(String userId, String nuevoNombre, String nuevoCorreo) {
        GoRestApi.updateUser(userId, nuevoNombre, nuevoCorreo);
    }

    @And("se verifica que el nombre del usuario sea {string} y el email {string}")
    public void seVerificaQueElNombreDelUsuarioSeaYElEmail(String name, String email) {
        GoRestApi.validateUpdatedUser(this.userId, name, email);
    }
    @Then("la respuesta debe tener código de estado {int} y contener el nombre actualizado {string} y correo {string}")
    public void validarActualizacionDeUsuario(int statusCode, String nombreEsperado, String correoEsperado) {
        GoRestApi.validateUpdatedUser(userId, "NombreEsperado", "CorreoEsperado");
    }
}

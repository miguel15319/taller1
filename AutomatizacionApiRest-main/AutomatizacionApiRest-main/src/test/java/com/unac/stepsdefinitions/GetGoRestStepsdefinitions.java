package com.unac.stepsdefinitions;

import com.unac.apis.GoRestApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GetGoRestStepsdefinitions {

    @Given("se establece la base url {string}")
    public void seEstableceLaBaseUrl(String baseUrl) {
        GoRestApi.setBaseUrl(baseUrl);
    }

    @When("se modifica el usuario en el endpoint {string} con id {string} con nombre {string} y email {string}")
    public void seModificaElUsuarioEnElEndpointConIdConNombreYEmail(String endpoint, String userId, String newName, String newEmail) {
        GoRestApi.updateUser(userId, newName, newEmail);
    }

    @Then("se valida que el status code {int} y que el nombre sea {string} y el email sea {string}")
    public void seValidaQueElStatusCodeYQueElNombreSeaYElEmailSea(int statusCode, String expectedName, String expectedEmail) {
        GoRestApi.validateStatusCode(statusCode);
        GoRestApi.validateUpdatedUser(expectedName, expectedEmail);
    }
}

package com.unac.restinteractions;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;

public class RestInteractions {

    private static String baseUrl;
    private static final String TOKEN = "13dcd036efe11c236b649224a20b777de7ce9c80c69a51338c6fe0231b86c00f";

    public static void setBaseUrl(String baseUrl) {
        RestInteractions.baseUrl = baseUrl;
    }

    public static void executionGetToken(String endPoint, String idUser, String token) {
        SerenityRest.given().auth().oauth2(token)
                .contentType(ContentType.JSON).when()
                .get(baseUrl.concat(endPoint).concat(idUser));

        SerenityRest.lastResponse().prettyPeek();
    }

    public static void validatecode(Integer statusCode) {
        Integer statusActual = SerenityRest.lastResponse().statusCode();
        assertEquals(statusActual, statusCode);
    }

    public static void validateDataResponse(String name, String pathName) {
        String nombreActual = SerenityRest.lastResponse()
                .jsonPath().getString(pathName);
        assertEquals(nombreActual, name);
    }

    public static void executeUpdateUser(String userId, String name, String email) {
        JSONObject userDetails = new JSONObject();
        userDetails.put("name", name);
        userDetails.put("email", email);

        SerenityRest.given().auth().oauth2(TOKEN)
                .contentType(ContentType.JSON)
                .body(userDetails.toString())
                .when()
                .put(baseUrl + "public/v1/users/" + userId)
                .then()
                .statusCode(200);  // Ensure the request returns status 200
    }

    public static void validateUserUpdate(String userId, String expectedName, String expectedEmail) {
        Response response = SerenityRest.lastResponse();
        assertEquals(200, response.statusCode());
        assertEquals(expectedName, response.jsonPath().getString("data.name"));
        assertEquals(expectedEmail, response.jsonPath().getString("data.email"));
    }

    public static void validateStatusCode(int statusCode) {
        Integer statusActual = SerenityRest.lastResponse().statusCode();
        assertEquals((int) statusActual, statusCode);
    }
}

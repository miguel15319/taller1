package com.unac.restinteractions;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject; // Import JSONObject
import static org.junit.Assert.assertEquals;

public class RestInteractions {

    private static String baseUrl;
    private static final String TOKEN = "your_api_token_here"; // Ensure this is correctly initialized

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
                .put(baseUrl + "public/v1/users/" + userId);
    }

    public static void validateUserUpdate(String userId, String expectedName, String expectedEmail) {
        Response response = SerenityRest.lastResponse();
        validatecode(200);  // Check the correct status code
        assertEquals(response.jsonPath().getString("name"), expectedName);
        assertEquals(response.jsonPath().getString("email"), expectedEmail);
    }
}

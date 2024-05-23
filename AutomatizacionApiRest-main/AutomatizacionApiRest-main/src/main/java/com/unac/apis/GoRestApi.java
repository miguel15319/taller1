package com.unac.apis;

import com.unac.restinteractions.RestInteractions;

public class GoRestApi {

    private static final String TOKEN = "13dcd036efe11c236b649224a20b777de7ce9c80c69a51338c6fe0231b86c00f";

    public static void setBaseUrl(String baseUrl) {
        RestInteractions.setBaseUrl(baseUrl);
    }

    public static void updateUser(String userId, String name, String email) {
        RestInteractions.executeUpdateUser(userId, name, email);
    }

    public static void validateStatusCode(int statusCode) {
        RestInteractions.validateStatusCode(statusCode);
    }

    public static void validateUpdatedUser(String userId, String expectedName, String expectedEmail) {
        RestInteractions.validateUserUpdate(userId, expectedName, expectedEmail);
    }

    public static void validateUpdatedUser(String expectedName, String expectedEmail) {
    }
}

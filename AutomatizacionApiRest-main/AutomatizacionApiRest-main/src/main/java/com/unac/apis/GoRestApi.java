package com.unac.apis;

import com.unac.restinteractions.RestInteractions;

public class GoRestApi {

    private static final String TOKEN = "e871d08829b6c03f39b4eea4d1e51522ab2cf5b59685c8d082f196db681b6254";
    private static String pathName = "name";

    public static void setBaseUrl(String baseUrl) {
        RestInteractions.setBaseUrl(baseUrl);
    }

    public static void executionGetToken(String endPoint, String idUser){
        RestInteractions.executionGetToken(endPoint, idUser, TOKEN);
    }

    public static void validateResponse(Integer statusCode, String name) {
        RestInteractions.validatecode(statusCode);
        RestInteractions.validateDataResponse(name, pathName);
    }

    public static void updateUser(String userId, String name, String email) {
        RestInteractions.executeUpdateUser(userId, name, email);
    }

    public static void validateUpdatedUser(String userId, String expectedName, String expectedEmail) {
        RestInteractions.validateUserUpdate(userId, expectedName, expectedEmail);
    }
}

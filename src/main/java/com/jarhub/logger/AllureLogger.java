package com.jarhub.logger;

import io.qameta.allure.Allure;

public final class AllureLogger {
    public static void logRequest(String requestBody) {
        Allure.addAttachment("API Request Body", "application/json",
                requestBody != null ? requestBody : "Request body is empty", ".json");
    }

    public static void logResponse(String responseBody) {
        Allure.addAttachment("API Response Body", "application/json",
                responseBody != null ? responseBody : "Response body is empty", ".json");
    }
}

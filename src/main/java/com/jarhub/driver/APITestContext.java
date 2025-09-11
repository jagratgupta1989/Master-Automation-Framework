package com.jarhub.driver;

public class APITestContext {

    private static final ThreadLocal<String> requestBody = new ThreadLocal<>();
    private static final ThreadLocal<String> responseBody = new ThreadLocal<>();

    public static void setRequestBody(String body) {
        requestBody.set(body);
    }

    public static String getRequestBody() {
        return requestBody.get();
    }

    public static void setResponseBody(String body) {
        responseBody.set(body);
    }

    public static String getResponseBody() {
        return responseBody.get();
    }

    public static void clear() {
        requestBody.remove();
        responseBody.remove();
    }
}

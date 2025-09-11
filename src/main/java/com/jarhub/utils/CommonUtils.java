package com.jarhub.utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CommonUtils {

    public static JsonPath rawToJson(Response response)
    {
        String responseBody = response.asString();
        JsonPath js = new JsonPath(responseBody);
        return js;
    }

    public static String generateStringFromResource(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}

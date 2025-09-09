package com.jarhub.utils;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtils {

    private JSONObject jsonObject;

    // Constructor to load JSON file
    public JsonUtils(String filePath) {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(filePath)) {
            Object obj = parser.parse(reader);
            jsonObject = (JSONObject) obj;
        } catch (IOException e) {
            System.err.println("[ERROR] Failed to read JSON file: " + filePath);
            e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("[ERROR] Failed to parse JSON file: " + filePath);
            e.printStackTrace();
        }
    }

    // Get a simple key-value (as String)
    public String getValue(String key) {
        if (jsonObject.containsKey(key)) {
            return jsonObject.get(key).toString();
        } else {
            System.err.println("[WARNING] Key not found: " + key);
            return null;
        }
    }

    // Get nested JSON object by key
    public JSONObject getJSONObject(String key) {
        try {
            return (JSONObject) jsonObject.get(key);
        } catch (ClassCastException e) {
            System.err.println("[ERROR] Value for key '" + key + "' is not a JSONObject");
            return null;
        }
    }

    // Get JSON array by key
    public JSONArray getJSONArray(String key) {
        try {
            return (JSONArray) jsonObject.get(key);
        } catch (ClassCastException e) {
            System.err.println("[ERROR] Value for key '" + key + "' is not a JSONArray");
            return null;
        }
    }

    // Get specific JSONObject from array by index
    public JSONObject getObjectFromArray(String arrayKey, int index) {
        JSONArray array = getJSONArray(arrayKey);
        if (array != null) {
            try {
                return (JSONObject) array.get(index);
            } catch (IndexOutOfBoundsException | ClassCastException e) {
                System.err.println("[ERROR] Cannot get JSONObject at index " + index + " from array '" + arrayKey + "'");
            }
        }
        return null;
    }

    // Get nested value from JSONObject
    public String getNestedValue(String parentKey, String childKey) {
        JSONObject parentObj = getJSONObject(parentKey);
        if (parentObj != null && parentObj.containsKey(childKey)) {
            return parentObj.get(childKey).toString();
        } else {
            System.err.println("[WARNING] Nested key not found: " + parentKey + " -> " + childKey);
            return null;
        }
    }

    // Get value from a nested array inside objects
    public String getValueFromNestedArray(String arrayKey, int index, String arrayItemKey) {
        JSONObject arrayItem = getObjectFromArray(arrayKey, index);
        if (arrayItem != null && arrayItem.containsKey(arrayItemKey)) {
            return arrayItem.get(arrayItemKey).toString();
        } else {
            System.err.println("[WARNING] Key not found in array item: " + arrayItemKey);
            return null;
        }
    }

    // Get element from simple array by index
    public String getElementFromSimpleArray(String arrayKey, int index) {
        JSONArray array = getJSONArray(arrayKey);
        if (array != null) {
            try {
                return array.get(index).toString();
            } catch (IndexOutOfBoundsException e) {
                System.err.println("[ERROR] Index out of bounds: " + index + " for array '" + arrayKey + "'");
            }
        }
        return null;
    }
}
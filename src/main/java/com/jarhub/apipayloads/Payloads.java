package com.jarhub.apipayloads;

public class Payloads {

    public static String updatePlace(String placeId)
    {
        return "{\n" +
                "    \"place_id\": \""+placeId+"\",\n" +
                "    \"address\": \"BHouse\",\n" +
                "    \"key\": \"qaclick123\"\n" +
                "}";
    }

    public static String deletePlace(String placeId)
    {
        return "{\n" +
                "    \"place_id\" : \""+placeId+"\"\n" +
                "}";
    }
}

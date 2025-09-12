package com.jarhub.apipayloads;

import com.jarhub.constants.FrameWorkConstants;
import com.jarhub.pojo.AddPlace;
import com.jarhub.pojo.DeletePlace;
import com.jarhub.pojo.Location;
import com.jarhub.pojo.UpdatePlace;
import com.jarhub.utils.CommonUtils;
import com.jarhub.utils.JsonUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Payloads {

    public static JsonUtils jsonUtils;
    public static UpdatePlace updatePlace;
    public static DeletePlace deletePlace;

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

    public static AddPlace addPlaceRequestPojo()
    {
        AddPlace addPlace=new AddPlace();
        Location location=new Location();
        List<String> types=new ArrayList<>();
        jsonUtils=new JsonUtils(FrameWorkConstants.getResourcePath()+"/jsons/AddPlace.json");
        addPlace.setAccuracy(Integer.parseInt(jsonUtils.getValue("accuracy")));
        addPlace.setName(jsonUtils.getValue("name"));
        addPlace.setPhone_number(jsonUtils.getValue("phone_number"));
        addPlace.setAddress(jsonUtils.getValue("address"));
        location.setLat(jsonUtils.getNestedValue("location","lat"));
        location.setLng(jsonUtils.getNestedValue("location","lng"));
        addPlace.setLocation(location);
        types.add(jsonUtils.getElementFromSimpleArray("types",0));
        types.add(jsonUtils.getElementFromSimpleArray("types",1));
        addPlace.setTypes(types);
        addPlace.setWebsite(jsonUtils.getValue("website"));
        addPlace.setLanguage(jsonUtils.getValue("language"));
        return addPlace;


    }
    public static UpdatePlace updatePlaceRequestPojo(String place_Id) throws IOException {
        jsonUtils=new JsonUtils(FrameWorkConstants.getResourcePath()+"/jsons/UpdatePlace.json");
        // Read the entire JSON as a String
        String jsonTemplate = CommonUtils.generateStringFromResource(FrameWorkConstants.getResourcePath()+"/jsons/UpdatePlace.json");
        // Replace the placeholder with actual runtime value
        String updatedJson = jsonTemplate.replace("${place_id}", place_Id);
        // Now map the updated JSON string to the POJO
        updatePlace = CommonUtils.convertJsonToPojo(updatedJson, UpdatePlace.class);
        return updatePlace;
    }
    public static DeletePlace deletePlaceRequestPojo(String place_Id) throws IOException {
        jsonUtils=new JsonUtils(FrameWorkConstants.getResourcePath()+"/jsons/UpdatePlace.json");
        // Read the entire JSON as a String
        String jsonTemplate = CommonUtils.generateStringFromResource(FrameWorkConstants.getResourcePath()+"/jsons/DeletePlace.json");
        // Replace the placeholder with actual runtime value
        String updatedJson = jsonTemplate.replace("${place_id}", place_Id);
        // Now map the updated JSON string to the POJO
        deletePlace = CommonUtils.convertJsonToPojo(updatedJson, DeletePlace.class);
        return deletePlace;
    }
}

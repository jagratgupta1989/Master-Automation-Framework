package com.jarhub.apiresources;

public enum APIResources {

    ADDPLACE("/maps/api/place/add/json"),
    GETPLACE("/maps/api/place/get/json"),
    UPDATEPLACE("/maps/api/place/update/json"),
    DELETEPLACE("/maps/api/place/delete/json");

    private String resource;

    APIResources(String resource) {
        this.resource=resource;
    }

    public String getResource()
    {
        return resource;
    }
}

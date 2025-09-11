package com.jarhub.specbuilders;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecifications {

    public static ResponseSpecification res;

    public static ResponseSpecification responseSpecificationForPlaceAPI() throws Exception {
            res=new ResponseSpecBuilder().expectContentType(ContentType.JSON)
                    .build();
            return res;
    }
}

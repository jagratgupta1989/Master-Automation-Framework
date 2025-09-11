package com.jarhub.specbuilders;

import com.jarhub.enums.ConfigProperties;
import com.jarhub.utils.PropertyUtils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecifications {

    public static RequestSpecification req;

    public static RequestSpecification requestSpecificationForPlaceAPI() throws Exception {
        if(req==null)
        {
            req=new RequestSpecBuilder().setBaseUri(PropertyUtils.get(ConfigProperties.BASEURI))
                    .addQueryParam("key","qaclick123").setContentType(ContentType.JSON)
                    .build();
            return req;
        }
        return req;
    }
}

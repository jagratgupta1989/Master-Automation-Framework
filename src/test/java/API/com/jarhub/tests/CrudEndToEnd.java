package API.com.jarhub.tests;

import com.jarhub.apipayloads.Payloads;
import com.jarhub.apiresources.APIResources;
import com.jarhub.constants.FrameWorkConstants;
import com.jarhub.driver.APITestContext;
import com.jarhub.specbuilders.RequestSpecifications;
import com.jarhub.specbuilders.ResponseSpecifications;
import com.jarhub.utils.CommonUtils;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CrudEndToEnd {

    private static String requestBody;
    private static String placeId;
    private static APIResources apiResources;

        @Severity(SeverityLevel.CRITICAL)
        @Description("Test Description: Validate Add Place API")
        @Story("User validates Add Place API")
        @Step("Validate Add Place API")
        @Test(description = "Validate Add Place API",priority = 1)
        public void crudOperations_AddPlaceAPI() throws Exception {
        RestAssured.useRelaxedHTTPSValidation();
        requestBody=CommonUtils.generateStringFromResource(FrameWorkConstants.getResourcePath()+"/jsons/AddPlace.json");

        //POST API
        apiResources= APIResources.valueOf("ADDPLACE");
        Response res = given().log().all().
                spec(RequestSpecifications.requestSpecificationForPlaceAPI())
                .body(requestBody)
                .when().post(apiResources.getResource())
                .then().log().all().assertThat().spec(ResponseSpecifications.responseSpecificationForPlaceAPI()).and().statusCode(200)
                .and().body("status",equalTo("OK")).extract().response();
        APITestContext.setRequestBody(requestBody);
        APITestContext.setResponseBody(res.getBody().asPrettyString());
        // Attach right away to Allure
        Allure.addAttachment("API Request Body", "application/json", requestBody, ".json");
        Allure.addAttachment("API Response Body", "application/json", res.getBody().asPrettyString(), ".json");

        // Convert Raw Response into JSON
        JsonPath js = CommonUtils.rawToJson(res);

        //Extract Place_id
        placeId = js.get("place_id");
        }

        //GET API
        @Severity(SeverityLevel.CRITICAL)
        @Description("Test Description: Validate Get Place API")
        @Story("User validates Get Place API")
        @Step("Validate Get Place API")
        @Test(description = "Validate Get Place API",priority = 2)
        public void crudOperations_GETPlaceAPI() throws Exception {
            apiResources= APIResources.valueOf("GETPLACE");
            given().log().all().
                    spec(RequestSpecifications.requestSpecificationForPlaceAPI())
                    .queryParam("place_id", placeId)
                    .when().get(apiResources.getResource())
                    .then().log().all().assertThat().spec(ResponseSpecifications.responseSpecificationForPlaceAPI()).and().statusCode(200);
        }
        //PUT API
        @Severity(SeverityLevel.CRITICAL)
        @Description("Test Description: Validate Update Place API")
        @Story("User validates Update Place API")
        @Step("Validate Update Place API")
        @Test(description = "Validate Update Place API",priority = 3)
        public void crudOperations_PUTPlaceAPI() throws Exception {
            apiResources= APIResources.valueOf("UPDATEPLACE");
            given().log().all()
                    .spec(RequestSpecifications.requestSpecificationForPlaceAPI())
                    .body(Payloads.updatePlace(placeId))
                    .when().put(apiResources.getResource())
                    .then().log().all().assertThat().spec(ResponseSpecifications.responseSpecificationForPlaceAPI()).and().statusCode(200)
                    .and().body("msg", equalTo("Address successfully updated"));

            //GET API to validate Address
            apiResources= APIResources.valueOf("GETPLACE");
            Response updatedResponse = given().log().all()
                    .spec(RequestSpecifications.requestSpecificationForPlaceAPI())
                    .queryParam("place_id", placeId)
                    .when().get(apiResources.getResource())
                    .then().log().all().assertThat().spec(ResponseSpecifications.responseSpecificationForPlaceAPI()).and().statusCode(200).extract().response();
            String updatedAddress = CommonUtils.rawToJson(updatedResponse).get("address");
            Assertions.assertThat(updatedAddress).describedAs("Address Updation Validation")
                    .isEqualTo("BHouse");
            APITestContext.setResponseBody(updatedResponse.getBody().asPrettyString());
        }

        //Delete API
        @Severity(SeverityLevel.CRITICAL)
        @Description("Test Description: Validate Delete Place API")
        @Story("User validates Delete Place API")
        @Step("Validate Delete Place API")
        @Test(description = "Validate Delete Place API",priority = 4)
        public void crudOperations_DELETEPlaceAPI() throws Exception {
            apiResources= APIResources.valueOf("DELETEPLACE");
            given().log().all()
                    .spec(RequestSpecifications.requestSpecificationForPlaceAPI())
                    .body(Payloads.deletePlace(placeId))
                    .when().delete(apiResources.getResource())
                    .then().log().all().assertThat().spec(ResponseSpecifications.responseSpecificationForPlaceAPI()).and().statusCode(200)
                    .and().body("status", equalTo("OK"));

            //GET API to Validate whether entry is deleted
            apiResources= APIResources.valueOf("GETPLACE");
            given().log().all()
                    .spec(RequestSpecifications.requestSpecificationForPlaceAPI())
                    .queryParam("place_id", placeId)
                    .when().get(apiResources.getResource())
                    .then().log().all().assertThat().spec(ResponseSpecifications.responseSpecificationForPlaceAPI()).and().statusCode(404).and()
                    .body("msg", equalTo("Get operation failed, looks like place_id  doesn't exists"));
        }
    }
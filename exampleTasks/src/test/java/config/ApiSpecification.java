package config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiSpecification {

    public static RequestSpecification baseRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io")
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
    }


}

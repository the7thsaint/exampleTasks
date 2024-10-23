package apiTests;

import config.ApiSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.testingisgood.constants.PetStoreApi;

import java.io.File;

import static io.restassured.RestAssured.given;
import static ru.testingisgood.constants.PetStoreApi.POST_CREATE_NEW_PET;

public class PetStoreApiTests {
    private static final String NEW_PET_JSON_PATH = "src/test/resources/newPet.json";

    @Test
    @DisplayName("Проверка создания животного через ручку /v2/pet")
    public void checkIsNewPetCreated() {
        given()
                .spec(ApiSpecification.baseRequestSpec())
                .body(new File(NEW_PET_JSON_PATH))
                .when()
                .post(POST_CREATE_NEW_PET)
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("Проверка поиска животного по id через ручку /v2/pet/{id}")
    public void getPetWithValidId() {
        given()
                .spec(ApiSpecification.baseRequestSpec())
                .when()
                .get(String.format(PetStoreApi.GET_FIND_PET_BY_ID, "12345"))
                .then()
                .statusCode(200);
    }
}

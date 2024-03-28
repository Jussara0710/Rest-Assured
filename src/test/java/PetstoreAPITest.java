import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PetstoreAPITest {
    @Test
    public void testPostOrder() {
        RestAssured.baseURI = "https://petstore.swagger.io";

        // Cadastro um novo pedido//
        int petId = 1220;

        String requestBody = "{\n" +
                "    \"id\": 12635,\n" +
                "    \"petId\": " + petId + ",\n" +
                "    \"quantity\": 5,\n" +
                "    \"shipDate\": \"2024-03-28T12:00:00.000Z\",\n" +
                "    \"status\": \"placed\",\n" +
                "    \"complete\": true\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/v2/store/order")
                .then()
                .statusCode(200) // Espera-se um status de resposta 200 (OK)
                .log().all();


    }
}
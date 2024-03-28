import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class StatusPedido {
    @Test
    public void testPesquisarPetsPorStatusPending() {
        RestAssured.baseURI = "https://petstore.swagger.io";

        given()
                .queryParam("status", "pending") // Parâmetro de query para pesquisar por status "pending"
                .when()
                .get("/v2/pet/findByStatus")
                .then()
                .statusCode(200) // Espera-se um status de resposta 200 (OK)
                .log().all();
    }
}

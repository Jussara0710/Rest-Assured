import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetPedidoOf {
    @Test
    public void testSearchForNonExistentPet() {
        RestAssured.baseURI = "https://petstore.swagger.io";

        // ID de um pet que não existe na Api.
        long petId = 999999;

        given()
                .pathParam("petId", petId)
                .when()
                .get("/pet/{petId}")
                .then()
                .statusCode(404) // Espera-se um status de resposta 404 (Not Found)
                .log().all();
    }
}

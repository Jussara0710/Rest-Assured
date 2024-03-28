import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class AtualizaPedido{
    @Test
    public void testAtualizarPet() {
        RestAssured.baseURI = "https://petstore.swagger.io";

        // ID do pet existente que você deseja atualizar
        long petId = 12630;

        // Novos dados a serem atualizados para o pet
        String requestBody = "{\n" +
                "    \"id\": " + 12630 + ",\n" +
                "    \"name\": \"minhocaT\",\n" +
                "    \"status\": \"sold\"\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("/v2/pet")
                .then()
                .statusCode(200) // Espera-se um status de resposta 200 (OK) se a atualização for bem-sucedida
                .log().all();
    }
}

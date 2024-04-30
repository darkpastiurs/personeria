package sv.com.darkpastiurs;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@QuarkusTest
@Tag("integration")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PersoneriaResourceTest {

    @Test
    @Order(1)
    void testCreatePersonaNatural() {
        JsonObject personaNatural = Json.createObjectBuilder()
                .add("id", 1L)
                .add("descripcion", "Persona Natural de prueba")
                .add("personaNatural", Json.createObjectBuilder().add("nombreCompleto", "Juan Perez").build())
                .build();

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(personaNatural.toString())
                .when().post("/persona")
                .then()
                .statusCode(201);
    }

    @Test
    @Order(2)
    void testCreatePersonaJuridica() {
        JsonObject personaJuridica = Json.createObjectBuilder()
                .add("id", 2L)
                .add("descripcion", "Persona Juridica de prueba")
                .add("personaNatural", Json.createObjectBuilder().add("nombreSociedad", "Empresa Anonima S.A. de C.V.").add("nombreComercial", "Anonima El Salvador").build())
                .build();
        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(personaJuridica.toString())
                .when().post("/persona")
                .then()
                .statusCode(201);
    }

    @Test
    @Order(3)
    void testGetAllPersonas() {
        given()
                .when().get("/persona")
                .then()
                .statusCode(200)
                .body("size()", equalTo(2))
                .body("[0].descripcion", equalTo("Persona Natural de prueba"))
                .body("[1].descripcion", equalTo("Persona Juridica de prueba"));
    }

}
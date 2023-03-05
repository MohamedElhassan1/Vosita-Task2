import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.SwagerPage;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class TestSteps {
    SwagerPage swagerPage;
    @Given("Post API with parameter")
    public void iHaveTheFollowingUserListInput()
    {
        String baseUri = "https://petstore.swagger.io/v2";
        String endpoint = "/store/order";
        String requestBody = "{\n" +
                "  \"id\": 12345,\n" +
                "  \"petId\": 1,\n" +
                "  \"quantity\": 1,\n" +
                "  \"shipDate\": \"2023-03-05T12:00:00.000Z\",\n" +
                "  \"status\": \"placed\",\n" +
                "  \"complete\": true\n" +
                "}";
        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(baseUri + endpoint)
                .then()
                .statusCode(200);

        given()
                .pathParam("orderId", 12345)
                .when()
                .get(baseUri + endpoint + "/{orderId}")
                .then()
                .statusCode(200)
                .body("id", equalTo(12345));


    }

    @Given("get Api")
    public void getApi() {
        String baseUri = "https://petstore.swagger.io/v2";
        String endpoint = "/store/order/{orderId}";
        long orderId = 12345;

        given()
                .pathParam("orderId", orderId)
                .when()
                .get(baseUri + endpoint)
                .then()
                .statusCode(200)
                .body("id", equalTo(orderId));

    }

    @Given("Delete Api")
    public void deleteApi() {
        String baseUri = "https://petstore.swagger.io/v2";
        String endpoint = "/store/order/{orderId}";
        long orderId = 12345;

        given()
                .pathParam("orderId", orderId)
                .when()
                .delete(baseUri + endpoint)
                .then()
                .statusCode(200);

// Verify the order was deleted
        given()
                .pathParam("orderId", orderId)
                .when()
                .get(baseUri + endpoint)
                .then()
                .statusCode(404);
    }
}

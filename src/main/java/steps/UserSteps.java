package steps;

import io.qameta.allure.Step;
import model.UserModel;
import io.restassured.response.Response;
import static data.UserData.CREATE_USER;
import static data.UserData.DELETE_USER;
import static io.restassured.RestAssured.given;

public class UserSteps {


    @Step("Send POST request to /api/auth/register")
    public static Response createUser(UserModel user) {
        return given()
                .log().all()
                .header("Content-Type", "application/json")
                .body(user)
                .when()
                .post(CREATE_USER)
                .then()
                .extract().response();

    }

    @Step("Send DELETE request to /api/auth/user")
    public static Response deleteUser(String token) {
        return given()
                .log().all()
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .when()
                .delete(DELETE_USER)
                .then()
                .extract().response();
    }
}

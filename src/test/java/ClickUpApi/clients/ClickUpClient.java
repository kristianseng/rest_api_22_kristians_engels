package ClickUpApi.clients;

import ClickUpApi.helpers.TestCaseContext;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static ClickUpApi.constants.ProjectConstants.*;

public class ClickUpClient {

    public static Response getSpaceInfo(){
        return RestAssured
                .given().log().all()
                .header("Authorization", API_TOKEN)
                .when()
                .get("https://api.clickup.com/api/v2/space/" + SPACE_ID)
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

    public static Response createFolder(Map<String,String> body){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_TOKEN)
                .body(body)
                .when()
                .post("https://api.clickup.com/api/v2/space/"+ SPACE_ID + "/folder")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

    public static Response deleteFolder(){
        return RestAssured
                .given().log().all()
                .header("Authorization", API_TOKEN)
                .when()
                .delete("https://api.clickup.com/api/v2/folder/" + TestCaseContext.getTestFolder().getId())
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

    public static Response createList(Map<String,String> body){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_TOKEN)
                .body(body)
                .when()
                .post("https://api.clickup.com/api/v2/folder/" + TestCaseContext.getTestFolder().getId() + "/list")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

    public static Response getList(){
        return RestAssured
                .given().log().all()
                .header("Authorization", API_TOKEN)
                .when()
                .get("https://api.clickup.com/api/v2/list/" + TestCaseContext.getTestList().getId())
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

    public static Response createTask(Map<String,String> body){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_TOKEN)
                .body(body)
                .when()
                .post("https://api.clickup.com/api/v2/list/" + TestCaseContext.getTestList().getId() + "/task")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

    public static Response getTask(){
        return RestAssured
                .given().log().all()
                .header("Authorization", API_TOKEN)
                .contentType(ContentType.JSON)
                .when()
                .get("https://api.clickup.com/api/v2/task/" + TestCaseContext.getTestTask().getId())
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

    public static Response deleteTask(){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_TOKEN)
                .when()
                .delete("https://api.clickup.com/api/v2/task/" + TestCaseContext.getTestTask().getId())
                .then().log().all()
                .statusCode(204)
                .extract().response();
    }
}

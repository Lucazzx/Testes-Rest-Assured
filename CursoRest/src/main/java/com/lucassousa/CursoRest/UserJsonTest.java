package com.lucassousa.CursoRest;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UserJsonTest {
	
	@Test
	public void verificaPrimeiroNivel() {
		given()
		.when()
			.get("http://restapi.wcaquino.me/users/1")
		.then()
			.statusCode(200)
			.body("id", is(1))
			.body("name", containsString("Silva"))
			.body("age", greaterThan(18))
			;
	}
	
	@Test
	public void verificaPrimeiroNivel2() {
		
		Response response = RestAssured.request(Method.GET,"http://restapi.wcaquino.me/users/1");
		
		//path
		assertEquals(1, (int) response.path("id"));
		assertEquals(1, (int) response.path("%s" ,"id"));
		
		//json path
		
		JsonPath jpath = new JsonPath (response.asString());
		assertEquals(1, jpath.getInt("id"));
		
		int id = JsonPath.from(response.asString()).getInt("id");
		assertEquals(1, id);
		
	}
}

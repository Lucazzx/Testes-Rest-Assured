package com.lucassousa.CursoRest;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

class OlaMundoTest {

	@Test
	public void testOlaMundoJUnit() {
    	Response response = request(Method.GET, "http://restapi.wcaquino.me/ola");   	
    	ValidatableResponse validacao = response.then();
    	validacao.statusCode(200);
    	assertEquals(200, response.statusCode());
		
	}

	@Test
	public void testOlaMundoRestAssured() {
    	Response response = request(Method.GET, "http://restapi.wcaquino.me/ola");   	
    	ValidatableResponse validacao = response.then();
    	validacao.statusCode(200);
    	
    	get("http://restapi.wcaquino.me/ola").then().statusCode(200);
	}
	
	@Test
	public void testOlaMundoFluent() {	
    	
    	given()
    	.when()
    		.get("http://restapi.wcaquino.me/ola")
    	.then()
    		.statusCode(200);
    	
	}
	
	@Test
	public void testMatchers() {
		assertThat("Maria", is("Maria"));
		assertThat("Maria", not(""));
    	
	}
	
	@Test
	public void testOlaMundoValidarBody() {   	
    	given()
    	.when()
    		.get("http://restapi.wcaquino.me/ola")
    	.then()
    		.statusCode(200)
    		.body(is("Ola Mundo!"))
    		.body(containsString("Mundo"))
    		.body(is(not(nullValue())));	
    	
	}
}

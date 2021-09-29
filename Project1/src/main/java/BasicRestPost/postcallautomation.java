package BasicRestPost;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
public class postcallautomation {
	
	@Test
	public void createpostwithoutbody()
	{
RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
		given().
		header("content-Type","application/json").
		when().
		post("/posts").
		then().
		assertThat().statusCode(201).and().
		contentType(ContentType.JSON).and().
		body("id", equalTo(101));
	}

	@Test
	public void createpostwithoutbody1()
	{
RestAssured.baseURI="https://postman-echo.com";
		
		given().
		header("content-Type","application/json").
		when().
		post("/post").
		then().
		assertThat().statusCode(200).and().
		contentType(ContentType.JSON).and().
		body("url", equalTo("https://postman-echo.com/post"));
	}
	
	
	
}

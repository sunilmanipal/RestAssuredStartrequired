package BasicRestPost;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ExtractrequestResponse {
	
	@Test
	public void Extractresponse()
	{
RestAssured.baseURI="https://ecommerceservice.herokuapp.com";
//i want to copy my request body in a string
String requestbody ="{\r\n" + 
		"	\"email\": \"Nishchith007@gmail.com\",\r\n" + 
		"	\"password\": \"Nishchith007@123\"\r\n" + 
		"}\r\n" + 
		"";
		//response is an object
		Response response = given()
		.header("content-Type","application/json")
		.body(requestbody)
		
		.when()
		.post("/user/signup").
		
		then()
		.assertThat().statusCode(201).and()
		.contentType(ContentType.JSON)
		//to extract the response 
		.extract().response();
	
	//this will print the response in the string format
	System.out.println(response.asString());
		
		
	}


}

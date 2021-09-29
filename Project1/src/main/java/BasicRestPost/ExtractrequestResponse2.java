package BasicRestPost;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ExtractrequestResponse2 {
	
	public String accessToken ;
	public String id;
	
	@Test(priority=1)
	public void Signup()
	{
RestAssured.baseURI="https://ecommerceservice.herokuapp.com";
//i want to copy my request body in a string
String requestbody ="{\r\n" + 
		"	\"email\": \"Nishchith01@gmail.com\",\r\n" + 
		"	\"password\": \"Nishchith01@123\"\r\n" + 
		"}\r\n" + 
		"";
		//response is an object
	Response response =	given()
		.header("content-Type","application/json")
		.body(requestbody)
		
		.when()
		.post("/user/signup").
		
		then()
		//.assertThat().statusCode(201).and()
		.contentType(ContentType.JSON)
		//to extract the response 
		.extract().response();
	String jsonResponse= response.asString();
	JsonPath responsebody = new JsonPath(jsonResponse);
	System.out.println("message : " + responsebody.get("message"));
	//this will print the response in the string format
	//System.out.println(response.asString());
		
		
	}

	@Test(priority=2)
	public void Login()
	{
RestAssured.baseURI="https://ecommerceservice.herokuapp.com";
//i want to copy my request body in a string
String requestbody ="{\r\n" + 
		"	\"email\": \"Nishchith01@gmail.com\",\r\n" + 
		"	\"password\": \"Nishchith01@123\"\r\n" + 
		"}\r\n" + 
		"";
		//response is an object
	Response response =	given()
		.header("content-Type","application/json")
		.body(requestbody)
		
		.when()
		.post("/user/login").
		
		then()
		.assertThat().statusCode(200).and()
		.contentType(ContentType.JSON)
		//to extract the response 
		.extract().response();
	String jsonResponse= response.asString();
	JsonPath responsebody = new JsonPath(jsonResponse);
	System.out.println("accessToken : " + responsebody.get("accessToken"));
	accessToken = responsebody.get("accessToken");
	//this will print the response in the string format
	//System.out.println(response.asString());
		
		
	}

	@Test(priority=3)
	public void GetAllUser()
	{
RestAssured.baseURI="https://ecommerceservice.herokuapp.com";
//i want to copy my request body in a string
//String accessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MDg5YTU4MjcyMjAzMDAwMTdiMjk1MGEiLCJpYXQiOjE2MTk2MzM1NDksImV4cCI6MTYxOTcxOTk0OX0.IctwKacz3pgyP7gv6pv0mTzj4PAt3ycYMpeyC8ENbaI";
		//response is an object
	Response response =given()
		.header("content-Type","application/json")
		.header("Authorization", "bearer " + accessToken)
		
		
		.when()
		.get("/user").
		
		then()
		.assertThat().statusCode(200).and()
		.contentType(ContentType.JSON)
		//to extract the response 
		.extract().response();
	String jsonResponse= response.asString();
	JsonPath responsebody = new JsonPath(jsonResponse);
	System.out.println("id : " + responsebody.get("users[101]._id"));
	id = responsebody.get("users[101]._id");
	//this will print the response in the string format
	//System.out.println(response.asString());
		
		
	}

	@Test(priority=4)
	public void delete()
	{
		RestAssured.baseURI="https://ecommerceservice.herokuapp.com";
		Response response =given()
				.header("content-Type","application/json")
				.header("Authorization", "bearer " + accessToken)
				.when()
				.delete("/user/" + id).
				
				then()
				//.assertThat().statusCode(204).and()
				.contentType(ContentType.JSON)
				//to extract the response 
				.extract().response();
			String jsonResponse= response.asString();
			JsonPath responsebody = new JsonPath(jsonResponse);
			System.out.println("message : " + responsebody.get("message"));
	}
	
	
}

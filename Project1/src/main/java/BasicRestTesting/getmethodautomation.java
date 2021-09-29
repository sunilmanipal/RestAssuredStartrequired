package BasicRestTesting;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import static org.hamcrest.CoreMatchers.equalTo;

import static io.restassured.RestAssured.*;



public class getmethodautomation {
//BaseURI	
	public static String baseUri="https://jsonplaceholder.typicode.com";

	public static void main(String args[])
	{
		RestAssured.baseURI=baseUri;
		
		given().param("postId", "2").
		when().
		get("/comments").
		then().
		assertThat().statusCode(200).contentType(ContentType.JSON).and().
		body("name[0]", equalTo("et fugit eligendi deleniti quidem qui sint nihil autem")).and().
		body("email[0]",equalTo("Presley.Mueller@myrl.com"));
		System.out.println("This is my first get automation call");
		System.out.println("Get call exeuted succesfully");
	}
}

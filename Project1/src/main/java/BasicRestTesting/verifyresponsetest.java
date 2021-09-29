package BasicRestTesting;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class verifyresponsetest {
	
	@Test
	public void verifyresponsebody()
	{
RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
		given().param("postId", "2").
		when().
		get("/comments").
		then().
		assertThat().statusCode(200).contentType(ContentType.JSON).and().
		body("name[0]", equalTo("et fugit eligendi deleniti quidem qui sint nihil autem")).and().
		body("email[0]",equalTo("Presley.Mueller@myrl.com"));
	}
	
	@Test
		public  void verifyresponseheader()
		{
			RestAssured.baseURI="https://jsonplaceholder.typicode.com";
			
			given().param("postId", "2").
			when().
			get("/comments").
			then().
			assertThat().statusCode(200).contentType(ContentType.JSON).and().
			header("Expires", equalTo("-1")).and().
			header("Connection",equalTo("keep-alive"));
			

}
}
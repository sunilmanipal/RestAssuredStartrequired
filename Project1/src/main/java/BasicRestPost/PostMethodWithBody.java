package BasicRestPost;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostMethodWithBody {
	
	@Test
	public void postmethodwithbody()
	{
RestAssured.baseURI="https://ecommerceservice.herokuapp.com";
System.out.println("Started");
		
		given()
		.header("content-Type","application/json")
		.body("{\r\n" + 
				"	\"email\": \"Nishchith122@gmail.com\",\r\n" + 
				"	\"password\": \"Nishchith2@123\"\r\n" + 
				"}\r\n" + 
				"")
		
		.when()
		.post("/user/signup").
		
		then()
		.assertThat().statusCode(201).and()
		.contentType(ContentType.JSON);
		System.out.println("Ended");
		
	}


}

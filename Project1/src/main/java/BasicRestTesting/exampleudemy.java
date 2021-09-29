package BasicRestTesting;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class exampleudemy {
	//BaseURI	
		public static String baseUri="https://api.trello.com";

		public static void main(String args[])
		{
			RestAssured.baseURI=baseUri;
			
			given().param("key", "13e2327dd77e3d5b723935051270bd86").
			param("token","85030c811f6ca828c206e5255044c8659ae09d2fbad681e6c893bc81c929cca4").
			when().
			get("/1/boards/CAQZUH7U").
			then().
			assertThat().statusCode(200).contentType(ContentType.JSON).and().
			body("name", equalTo("sunil")).and().
			body("id",equalTo("608554cea8512d8eba373277"));
			System.out.println("This is my first get automation call");
			System.out.println("Get call exeuted succesfully");
		}

}

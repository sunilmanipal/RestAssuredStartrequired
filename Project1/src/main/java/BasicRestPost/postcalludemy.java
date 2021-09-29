package BasicRestPost;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class postcalludemy {
	
	@Test
	public void createpostwithoutbody()
	{
RestAssured.baseURI="https://api.trello.com";
String board_name="My Board From Api" + (int)(Math.random()*100);
		
		given().
		queryParam("name", board_name).
		queryParam("key", "13e2327dd77e3d5b723935051270bd86").
		queryParam("token", "85030c811f6ca828c206e5255044c8659ae09d2fbad681e6c893bc81c929cca4").
		header("content-Type","application/json").
		when().
		post("/1/boards").
		then().
		assertThat().statusCode(200).and().
		contentType(ContentType.JSON).and().
		body("name", equalTo(board_name));
	}


}

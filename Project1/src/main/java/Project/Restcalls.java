package Project;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import scala.runtime.Static;

public class Restcalls {
	
	
	//The Resturn Type of this method is response 
	public static  Response GetRequest(String uRI)
	{
		RequestSpecification requestspecfication = RestAssured.given();
		requestspecfication.contentType(ContentType.JSON);
		Response response = requestspecfication.get(uRI);
		return response;
	}
	
	
	public static Response PostRequest(String uRI, String strJSON)
	{
		RequestSpecification requestspecfication = RestAssured.given().body(strJSON);
		requestspecfication.contentType(ContentType.JSON);
		Response response = requestspecfication.post(uRI);
		return response;
	}
	
	
	public static Response putRequest(String uRI, String strJSON)
	{
		RequestSpecification requestspecfication = RestAssured.given().body(strJSON);
		requestspecfication.contentType(ContentType.JSON);
		Response response = requestspecfication.put(uRI);
		return response;
	}

	
	public static Response DeleteRequest(String uRI, String strJSON)
	{
		RequestSpecification requestspecfication = RestAssured.given().body(strJSON);
		requestspecfication.contentType(ContentType.JSON);
		Response response = requestspecfication.delete(uRI);
		return response;
	}

}

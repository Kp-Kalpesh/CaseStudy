package org.caseStudy_FIS;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class VerifyAPI {
	public static void main(String[] args) {


		Response response = RestAssured.get("https://api.coindesk.com/v1/bpi/currentprice.json");


//		Get and print the BPIs
		String usd = response.path("bpi.USD.code");
		System.out.println(usd);
		String gbp = response.path("bpi.GBP.code");
		System.out.println(gbp);
		String eur = response.path("bpi.EUR.code");
		System.out.println(eur);

//		Verify the BPIs are not null
		assertNotNull(usd, "'USD' not found in BPIs");
		assertNotNull(gbp, "'GBP' not found in BPIs");
		assertNotNull(eur, "'EUR' not found in BPIs");
		
//		Get and print the GBP Description Value:
		String gbpDescription = response.path("bpi.GBP.description");
        assertEquals("British Pound Sterling", gbpDescription, "Expected GBP description to be 'British Pound Sterling', but got '" + gbpDescription + "'");
        System.out.println("GBP: " +gbpDescription);
	}
}

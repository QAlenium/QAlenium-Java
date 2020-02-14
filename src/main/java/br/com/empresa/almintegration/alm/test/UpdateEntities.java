package br.com.empresa.almintegration.alm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import br.com.empresa.almintegration.alm.infrastructure.Base64Encoder;

public class UpdateEntities {

	static String line = new String();
	// static StringBuffer jsonString = new StringBuffer();
	static String s = new String();
	static BufferedReader rd = null;
	static String encoding;
	static URL url;
	static String urlString = "http://localhost:80/flex/services/rest/latest/execution/8"; //8 is the schedule id 
	static String userPassword = "test.manager:test.manager";
	//static String payload="{\"lastTestResult\":[{ \"executionStatus\": \"2\"}]}";

	public static void main(String[] args){

		try{
			// retrieving data from server
			url = new URL(urlString);
			String payload="{\"lastTestResult\":{ \"executionStatus\": \"2\"}}";           // 2 = fail, 1= pass and 3= WIP 

			encoding = new Base64Encoder().encode (userPassword.getBytes());
			HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

			urlConnection.setConnectTimeout(15000);
			urlConnection.setDoOutput(true);
			urlConnection.setDoInput(true);
			urlConnection.setUseCaches(false);
			urlConnection.setDefaultUseCaches(false);
			urlConnection.setAllowUserInteraction(true);
			urlConnection.setRequestProperty("Content-Type", "application/json");
			urlConnection.setRequestProperty("Accept", "application/json");
			urlConnection.setRequestMethod("PUT");
			urlConnection.setRequestProperty ("Authorization", "Basic " + encoding);
			urlConnection.connect();
			
			OutputStreamWriter writer = new OutputStreamWriter(urlConnection.getOutputStream());
			writer.write(payload);
			writer.close();

			System.out.println("~~~~~~~~~~~~~~~~~~~~");
			rd = new BufferedReader (new InputStreamReader(urlConnection.getInputStream()));

			while ((line = rd.readLine()) != null)
				System.out.println(line);

			System.out.println(s);

			urlConnection.disconnect();
		}catch (Exception e){
			throw new RuntimeException(e.getMessage());
		}

	}


}

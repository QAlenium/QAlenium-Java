package br.com.empresa.almintegration.helper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import br.com.empresa.almintegration.alm.infrastructure.Constants;
import br.com.empresa.almintegration.alm.test.GetEntities;
import br.com.empresa.almintegration.constants.ConstantsServices;
import br.com.empresa.almintegration.constants.ViewConstants;
import br.com.empresa.almintegration.execution.PlayTestCases;
import br.com.empresa.almintegration.helper.imageutils.JSON2Image;
import br.com.empresa.almintegration.model.ServiceResponse;
import br.com.empresa.almintegration.model.WebEvidence;

public class TestesServicos extends PlayTestCases {

	public Map<Integer, String> doHttpRequest(String endpoint, String method, Map<String, String> headers, String data) 
			throws FileNotFoundException, IOException, URISyntaxException{

		Map<Integer, String> responseMap = new HashMap<Integer, String>();

		HttpParams params = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(params, 20 * 1000);
		HttpConnectionParams.setSoTimeout(params, 20 * 1000);

		if(method.equalsIgnoreCase("GET")){

			HttpGet get = new HttpGet(endpoint);
			get.addHeader(ViewConstants.ServicosProperties.CLIENT_ID, enviromentSettings.getEnv().getServicos().getClientID());

			if(headers != null){

				Iterator<Entry<String, String>> headersIterator = headers.entrySet().iterator();

				while (headersIterator.hasNext()) {
					Entry<String, String> header = headersIterator.next();
					get.addHeader(header.getKey(), header.getValue());
				}
			}

			HttpClient dhc = new DefaultHttpClient(params);

			HttpResponse response = null;
			try{
				response = dhc.execute(get);
			}catch (Exception e) {
				responseMap.put(000, e.getMessage());
				return responseMap;
			}

			int statusCode = response.getStatusLine().getStatusCode();
			StringBuilder RESPONSE = new StringBuilder();

			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";

			while ((line = rd.readLine()) != null) {
				RESPONSE.append(line).append("\n");
			}

			responseMap.put(statusCode, RESPONSE.toString());

			return responseMap;

		} else if(method.equalsIgnoreCase("POST")){

			HttpPost post = new HttpPost(endpoint);

			if(data != null){
				post.setEntity(new StringEntity(data));
			}

			post.addHeader(ViewConstants.ServicosProperties.CLIENT_ID, enviromentSettings.getEnv().getServicos().getClientID());

			if(headers != null){

				Iterator<Entry<String, String>> headersIterator = headers.entrySet().iterator();

				while (headersIterator.hasNext()) {
					Entry<String, String> header = headersIterator.next();
					post.addHeader(header.getKey(), header.getValue());
				}
			}

			HttpClient dhc = new DefaultHttpClient(params);

			HttpResponse response = null;
			try{
				response = dhc.execute(post);
			}catch (Exception e) {
				responseMap.put(000, e.getMessage());
				return responseMap;
			}

			int statusCode = response.getStatusLine().getStatusCode();
			StringBuilder RESPONSE = new StringBuilder();

			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";

			while ((line = rd.readLine()) != null) {
				RESPONSE.append(line).append("\n");
			}

			responseMap.put(statusCode, RESPONSE.toString());

			return responseMap;

		} else if(method.equalsIgnoreCase("PATCH")) {

			HttpPatch patch = new HttpPatch(endpoint);

			if(data != null){
				patch.setEntity(new StringEntity(data));
			}

			patch.addHeader(ViewConstants.ServicosProperties.CLIENT_ID, enviromentSettings.getEnv().getServicos().getClientID());

			if(headers != null){

				Iterator<Entry<String, String>> headersIterator = headers.entrySet().iterator();

				while (headersIterator.hasNext()) {
					Entry<String, String> header = headersIterator.next();
					patch.addHeader(header.getKey(), header.getValue());
				}

			}

			HttpClient dhc = new DefaultHttpClient(params);

			HttpResponse response = null;
			try{
				response = dhc.execute(patch);
			}catch (Exception e) {
				responseMap.put(000, e.getMessage());
				return responseMap;
			}

			int statusCode = response.getStatusLine().getStatusCode();
			StringBuilder RESPONSE = new StringBuilder();

			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";

			while ((line = rd.readLine()) != null) {
				RESPONSE.append(line).append("\n");
			}

			responseMap.put(statusCode, RESPONSE.toString());

			return responseMap;

		}

		return null;
	}	

	public void evidenciarTeste(ServiceResponse s) 
			throws Exception {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();

		String prettyJsonString = "";

		try{
			JsonElement je = jp.parse(s.getResposeFromRequest());
			prettyJsonString = gson.toJson(je);
		} catch (Exception e) {
			prettyJsonString = s.getResposeFromRequest();
		}

		String filename = Utils.createEvidenceToPDF(
				new Evidencias().textDataEntrance(s.getEndpoint(), s.getEvidenceContent()),
				prettyJsonString,
				s.getExpectedResult().equals(s.getResult()) 
				? s.getClazz().getSimpleName() + ConstantsServices.SUCCESS 
						: s.getClazz().getSimpleName() + ConstantsServices.FAIL,
						null, s.getResult());

		if(s.getRunId() != null){
			Constants c = new Constants();
			new GetEntities().uploadAttachments(c.USERNAME, c.PASSWORD, s.getRunId(), ViewConstants.ALM.TestLab.RUNS, filename);
		}

	}



	public void evidenciarTeste(WebEvidence we, boolean isWeb) 
			throws Exception {

		//		String filename = Utils.createEvidenceToPDF(
		//				new Evidencias().textDataEntrance(s.getEndpoint(), s.getEvidenceContent()),
		//				prettyJsonString,
		//				new Evidencias().validaSaida(s.getExpectedStatusCode(), s.getStatusCode()) 
		//				? s.getClazz().getSimpleName() + ConstantsServices.SUCCESS 
		//						: s.getClazz().getSimpleName() + ConstantsServices.FAIL,
		//						null, s.getStatusCode());

		if(we.getRunId() != null){
			Constants c = new Constants();
			new GetEntities().uploadAttachments(c.USERNAME, c.PASSWORD, we.getRunId(), ViewConstants.ALM.TestLab.RUNS, "filename");
		}

	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	public String toIndentedString(java.lang.Object o) {

		if (o == null) {
			return "null";
		}

		if(o instanceof java.lang.String){
			if(!((java.lang.String) o).startsWith("\"")){
				return "\""+o.toString()+"\"".replace("\n", "\n    ");
			}
		}

		return o.toString().replace("\n", "\n    ");
	}

	public JSON2Image createImagesFromServiceResponse(ServiceResponse sr, String stepId, String className, int stepOrder) throws Exception {
		return new JSON2Image(sr, stepId, stepOrder, 520, 500);
	}
}

package br.com.empresa.almintegration.alm.test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.joda.time.DateTime;
import org.jsoup.Jsoup;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

import br.com.empresa.almintegration.constants.ViewConstants;
import br.com.empresa.almintegration.alm.infrastructure.Constants;
import br.com.empresa.almintegration.alm.infrastructure.Entity;
import br.com.empresa.almintegration.alm.infrastructure.Response;
import br.com.empresa.almintegration.alm.infrastructure.RestConnector;
import br.com.empresa.almintegration.alm.model.Entities;
import br.com.empresa.almintegration.alm.model.Run;
import br.com.empresa.almintegration.alm.model.RunStep;
import br.com.empresa.almintegration.alm.model.RunSteps;
import br.com.empresa.almintegration.alm.model.TestInstance;

public class GetEntities {

	public String serverUrl;
	public String domain;
	public String project;
	public String param;

	public TestInstance getTestInstance(String username, String password, String id, String formatXMLorJSON) {
		try {
			List<Entity> entityList = getEntityList(
					getEntityById(username, password, id, formatXMLorJSON, ViewConstants.ALM.TestLab.TEST_INSTANCES, null));
			TestInstance testInstance = new TestInstance(entityList, ViewConstants.ALM.TestLab.TEST_INSTANCES);

			return testInstance;
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public RunStep getRunStep(String username, String password, String id, String formatXMLorJSON) {
		try {
			List<Entity> entityList = getEntityList(
					getEntityById(username, password, id, formatXMLorJSON, ViewConstants.ALM.TestLab.RUN_STEPS, null));
			RunStep runStep = new RunStep(entityList.get(0));			
			return runStep;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public RunSteps getRunSteps(String username, 
			String password,
			String parentId) throws Exception {

			StringBuilder query = new StringBuilder().append("query={parent-id[" + parentId + "]}");
			String entities = getEntityById(username, password, null, ViewConstants.MIME.XML, ViewConstants.ALM.TestLab.RUN_STEPS, query);

			JAXBContext jc = JAXBContext.newInstance(Entities.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			InputStream stream = new ByteArrayInputStream(entities.getBytes(StandardCharsets.UTF_8));
			Entities entity = (Entities) unmarshaller.unmarshal(stream);
			RunSteps runSteps = new RunSteps(entity);
			return runSteps;
		}

	/**
	 * 
	 * @param username
	 * @param password
	 * @param entityId
	 * @param formatXMLorJSON
	 * @param param
	 * @return entity returned in json or xml format
	 * @throws Exception
	 */
	public String getEntityById(String username, 
			String password, 
			String id, 
			String formatXMLorJSON, 
			String param,
			StringBuilder query) throws Exception {

		Constants c = new Constants();
		serverUrl = "http://" + c.HOST + ":" + c.PORT + "/qcbin";
		domain = c.DOMAIN;
		project = c.PROJECT;

		RestConnector con =
				RestConnector.getInstance().init(
						new HashMap<String, String>(),
						serverUrl,
						domain,
						project);

		AuthenticateLoginLogout auth = new AuthenticateLoginLogout();

		auth.login(username, password);

		String almUrl = (id == null) ? con.buildUrl("rest/domains/"+domain+"/projects/"+project+"/"+param) 
				: con.buildUrl("rest/domains/"+domain+"/projects/"+project+"/"+param+"/"+id); 

		Map<String, String> requestHeaders = new HashMap<String, String>();
		requestHeaders.put("Accept", "application/"+formatXMLorJSON);

		if(query == null) query = new StringBuilder().append("");
		
		Response serverResponse = con.httpGet(almUrl,
				query.toString(), requestHeaders, false);

		if(formatXMLorJSON.equalsIgnoreCase("json")){
			// return getPrettyJson(serverResponse.toString());
			return serverResponse.toString();
		} else if (formatXMLorJSON.equalsIgnoreCase(ViewConstants.MIME.XML)){
			return getPrettyXml(serverResponse.toString());
		} else {
			return "formato invlido";
		}
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @param entityId
	 * @param formatXMLorJSON
	 * @param param
	 * @return entity returned in json or xml format
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	public String uploadAttachments(String username, 
			String password, 
			String id,
			String param,
			String filename) throws Exception {

		this.param = param;

		Constants c = new Constants();
		serverUrl = "http://" + c.HOST + ":" + c.PORT + "/qcbin";
		domain = c.DOMAIN;
		project = c.PROJECT;

		RestConnector con =
				RestConnector.getInstance().init(
						new HashMap<String, String>(),
						serverUrl,
						domain,
						project);

		AuthenticateLoginLogout auth = new AuthenticateLoginLogout();

		auth.login(username, password);

		String attachmentUrl;

		attachmentUrl = con.buildUrl("rest/domains/"+domain+"/projects/"+project+"/"+param+"/"+id);

		File file;
		file = new File(filename);

		//um diretorio existente apenas para iniciar a variavel
		FileInputStream fis = new FileInputStream(new File("./pom.xml"));
		try{
			fis = new FileInputStream(file);
		}catch (FileNotFoundException e) {
			file = new File(filename);
			fis = new FileInputStream(file);
		}

		byte[] fileContent = new byte[(int)file.length()];
		fis.read(fileContent);
		fis.close();

		con.GetQCSession(false);

		return new Attachments().attachWithOctetStream(attachmentUrl, fileContent, filename);
	}

	public List<Entity> getEntityList(String response) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Entity.class);
		Unmarshaller un = context.createUnmarshaller();
		InputStream stream = new ByteArrayInputStream(response.getBytes(StandardCharsets.UTF_8));
		Entity entity = (Entity) un.unmarshal(stream);
		List<Entity> entityList = new ArrayList<Entity>();
		entityList.add(entity);
		return entityList;
	}

	public void uploadFilesToGoogleDrive(){


	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @param entityId
	 * @param formatXMLorJSON
	 * @return entity returned in json or xml format
	 * @throws Exception
	 */
	public String getJsonTestInstances(String username, 
			String password,
			String formatXMLorJSON,
			String testSetId,
			boolean queryBoolean) throws Exception {

		StringBuilder query = new StringBuilder();
		
		if(queryBoolean){
			query = new StringBuilder()
					.append("query={test-set.id["+testSetId+"]}")
					.append("&fields=test-config.name,assign-rcyc");
		} else {
			query = new StringBuilder()
					.append("query={cycle-id["+testSetId+"]}");
		}
		
		Constants c = new Constants();
		serverUrl = "http://" + c.HOST + ":" + c.PORT + "/qcbin";
		domain = c.DOMAIN;
		project = c.PROJECT;

		RestConnector con =
				RestConnector.getInstance().init(
						new HashMap<String, String>(),
						serverUrl,
						domain,
						project);

		AuthenticateLoginLogout auth = new AuthenticateLoginLogout();

		auth.login(username, password);

		String almUrl = con.buildUrl("rest/domains/"+domain+"/projects/"+project+"/"+ViewConstants.ALM.TestLab.TEST_INSTANCES);

		Map<String, String> requestHeaders = new HashMap<String, String>();
		requestHeaders.put("Accept", "application/"+formatXMLorJSON);

		Response serverResponse = con.httpGet(almUrl,
				query.toString(), requestHeaders, false);
		
		if(formatXMLorJSON.equalsIgnoreCase("json")){
			return getPrettyJson(serverResponse.toString());
		} else if (formatXMLorJSON.equalsIgnoreCase(ViewConstants.MIME.XML)){
			return getPrettyXml(serverResponse.toString());
		} else {
			return "Formato invlido. Formatos vlidos: XML/JSON";
		}
	}
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @param entityId
	 * @param formatXMLorJSON
	 * @return entity returned in json or xml format
	 * @throws Exception
	 */
	public String getJsonUseCase(String username, 
			String password,
			String formatXMLorJSON,
			String testSetId) throws Exception {

		StringBuilder query = new StringBuilder()
				.append("query={id[").append(testSetId).append("]}");

		Constants c = new Constants();
		serverUrl = "http://" + c.HOST + ":" + c.PORT + "/qcbin";
		domain = c.DOMAIN;
		project = c.PROJECT;

		RestConnector con =
				RestConnector.getInstance().init(
						new HashMap<String, String>(),
						serverUrl,
						domain,
						project);

		AuthenticateLoginLogout auth = new AuthenticateLoginLogout();

		auth.login(username, password);

		String almUrl = con.buildUrl("rest/domains/"+domain+"/projects/"+project+"/"+ViewConstants.ALM.TestLab.TEST_SETS);

		Map<String, String> requestHeaders = new HashMap<String, String>();
		requestHeaders.put("Accept", "application/"+formatXMLorJSON);

		Response serverResponse = con.httpGet(almUrl,
				query.toString(), requestHeaders, false);

		if(formatXMLorJSON.equalsIgnoreCase("json")){
			return getPrettyJson(serverResponse.toString());
		} else if (formatXMLorJSON.equalsIgnoreCase(ViewConstants.MIME.XML)){
			return getPrettyXml(serverResponse.toString());
		} else {
			return "Formato invlido. Formatos vlidos: XML/JSON";
		}
	}
	
	

	/**
	 * 
	 * @param username
	 * @param password
	 * @param entityId
	 * @param formatXMLorJSON
	 * @return entity returned in json or xml format
	 * @throws Exception
	 * @deprecated use getRunSteps
	 */
	public String getJsonRunSteps(
			String username, 
			String password,
			String formatXMLorJSON,
			String parentId) throws Exception {

		StringBuilder query = new StringBuilder()
				//.append("fields=id,description,desstep-id,name,step-order,status,test-id,parent-id,expected,execution-time")
				.append("query={parent-id["+parentId+"]}")
				//.append("query={test-id[378];assign-rcyc[1032];cycle-id[531]}")
				//.append("&start-index=1")
				;

		Constants c = new Constants();
		serverUrl = "http://" + c.HOST + ":" + c.PORT + "/qcbin";
		domain = c.DOMAIN;
		project = c.PROJECT;

		RestConnector con =
				RestConnector.getInstance().init(
						new HashMap<String, String>(),
						serverUrl,
						domain,
						project);

		AuthenticateLoginLogout auth = new AuthenticateLoginLogout();

		auth.login(username, password);

		String almUrl = con.buildUrl("rest/domains/"+domain+"/projects/"+project+"/"+ViewConstants.ALM.TestLab.RUN_STEPS);

		Map<String, String> requestHeaders = new HashMap<String, String>();
		requestHeaders.put("Accept", "application/"+formatXMLorJSON);

		Response serverResponse = con.httpGet(almUrl,
				query.toString(), requestHeaders, false);
		if(formatXMLorJSON.equalsIgnoreCase("json")){
			return getPrettyJson(serverResponse.toString());
		} else if (formatXMLorJSON.equalsIgnoreCase(ViewConstants.MIME.XML)){
			return getPrettyXml(serverResponse.toString());
		} else {
			return "Formato invlido. Formatos vlidos: XML/JSON";
		}
	}

	private String getPrettyXml(String serverResponse) throws UnsupportedEncodingException, 
	SAXException, IOException, ParserConfigurationException, XPathExpressionException, TransformerFactoryConfigurationError, 
	TransformerException {

		Document document = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder()
				.parse(new InputSource(new ByteArrayInputStream(serverResponse.toString().getBytes("utf-8"))));

		XPath xPath = XPathFactory.newInstance().newXPath();
		NodeList nodeList = (NodeList) xPath.evaluate("//text()[normalize-space()='']",
				document,
				XPathConstants.NODESET);

		for (int i = 0; i < nodeList.getLength(); ++i) {
			Node node = nodeList.item(i);
			node.getParentNode().removeChild(node);
		}

		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

		StringWriter stringWriter = new StringWriter();
		StreamResult streamResult = new StreamResult(stringWriter);

		transformer.transform(new DOMSource(document), streamResult);

		return stringWriter.toString();

	}

	private String getPrettyJson(String serverResponse) {

		return new GsonBuilder().setPrettyPrinting().create().toJson(new JsonParser()
				.parse(Jsoup
						.parse(serverResponse.toString()
								.replace("&quot;", "\\\""))
						.text()));
	}
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @param formatXMLorJSON
	 * @param param
	 * @return entity returned in json or xml format
	 * @throws Exception
	 */
	public Run createNewRun(String username, String password, String testId) throws Exception {

		Constants c = new Constants();
		serverUrl = "http://" + c.HOST + ":" + c.PORT + "/qcbin";
		domain = c.DOMAIN;
		project = c.PROJECT;

		RestConnector con = RestConnector.getInstance().init(new HashMap<String, String>(), serverUrl, domain, project);

		AuthenticateLoginLogout auth = new AuthenticateLoginLogout();
		auth.login(username, password);

		String requiredFieldsUrl = con
				.buildUrl("rest/domains/" + domain + "/projects/" + project + "/" + ViewConstants.ALM.TestLab.RUNS);

		Map<String, String> requestHeaders = new HashMap<String, String>();
		requestHeaders.put("Content-Type", "application/" + ViewConstants.MIME.XML);
		requestHeaders.put("Accept", "application/" + ViewConstants.MIME.XML);

		con.GetQCSession(false);

		Response serverResponse = con.httpPost(requiredFieldsUrl,
				getRunXmlExample("2289", "531", "378", testId, null).getBytes(), requestHeaders, true);

		Entity entity = getEntityList(serverResponse.toString()).get(0);
		Run run = new Run(entity);
		return run;
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @param formatXMLorJSON
	 * @param param
	 * @return entity returned in json or xml format
	 * @throws Exception
	 * @deprecated use createNewRun
	 */
	public String createNewRun(String username, 
			String password, 
			String formatXMLorJSON,
			String testId) 
					throws Exception {

		Constants c = new Constants();
		serverUrl = "http://" + c.HOST + ":" + c.PORT + "/qcbin";
		domain = c.DOMAIN;
		project = c.PROJECT;

		RestConnector con =
				RestConnector.getInstance().init(
						new HashMap<String, String>(),
						serverUrl,
						domain,
						project);

		AuthenticateLoginLogout auth = new AuthenticateLoginLogout();
		formatXMLorJSON = "xml";
		auth.login(username, password);

		String requiredFieldsUrl = con.buildUrl("rest/domains/"+domain+"/projects/"+project+"/"+ViewConstants.ALM.TestLab.RUNS);

		Map<String, String> requestHeaders = new HashMap<String, String>();
		requestHeaders.put("Content-Type", "application/"+formatXMLorJSON);
		requestHeaders.put("Accept", "application/"+formatXMLorJSON);

		con.GetQCSession(false);

		Response serverResponse = con.httpPost(requiredFieldsUrl,
				getRunXmlExample("2289", "531", "378", testId, null).getBytes(), requestHeaders, true);

		if(formatXMLorJSON.equalsIgnoreCase("json")){
			return getPrettyJson(serverResponse.toString());
		} else if (formatXMLorJSON.equalsIgnoreCase(ViewConstants.MIME.XML)){
			return getPrettyXml(serverResponse.toString());
		} else {
			return "formato invlido";
		}
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @param formatXMLorJSON
	 * @param param
	 * @return entity returned in json or xml format
	 * @throws Exception
	 */
	public String updateEntity(String username, 
			String password, 
			String formatXMLorJSON,
			String runId,
			String entityResource,
			byte[] data) 
					throws Exception {

		Constants c = new Constants();
		serverUrl = "http://" + c.HOST + ":" + c.PORT + "/qcbin";
		domain = c.DOMAIN;
		project = c.PROJECT;

		RestConnector con = RestConnector.getInstance().init( new HashMap<String, String>(), serverUrl, domain, project);

		AuthenticateLoginLogout auth = new AuthenticateLoginLogout();

		auth.login(username, password);

		String requiredFieldsUrl = (runId == null) ? con.buildUrl( "rest/domains/"+domain+"/projects/"+project+"/"+entityResource)
				: con.buildUrl( "rest/domains/"+domain+"/projects/"+project+"/"+entityResource+"/"+runId);


		Map<String, String> requestHeaders = new HashMap<String, String>();
		requestHeaders.put("Content-Type", "application/"+formatXMLorJSON);
		requestHeaders.put("Accept", "application/"+formatXMLorJSON);

		con.GetQCSession(false);

		Response serverResponse = con.httpPut(requiredFieldsUrl,
				data, requestHeaders, true);

		if(formatXMLorJSON.equalsIgnoreCase("json")){
			return getPrettyJson(serverResponse.toString());
		} else if (formatXMLorJSON.equalsIgnoreCase(ViewConstants.MIME.XML)){
			return getPrettyXml(serverResponse.toString());
		} else {
			return "formato invlido";
		}
	}

	public String xmlUpdateStatus(String status, String entity){
		
		StringBuilder sb = new StringBuilder();

		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
		sb.append("<Entity Type=\""+entity+"\">");
		sb.append("<Fields>");
		sb.append("<Field Name=\"status\"><Value>"+(status == null ? "Not Completed" : status)+"</Value></Field>");
		sb.append("</Fields>");
		sb.append("</Entity>");
		
		return sb.toString();
	}
	
	public String getTestXmlExample(){

		StringBuilder sb = new StringBuilder();

		sb.append("<Entity Type=\"test\">");
		sb.append("<Fields>");
		sb.append("<Field Name=\"name\">");
		sb.append("<Value>MY TEST CASE</Value>");
		sb.append("</Field>");
		sb.append("<Field Name=\"description\">");
		sb.append("<Value>Test created from api</Value>");
		sb.append("</Field>");
		sb.append("<Field Name=\"owner\">");
		sb.append("<Value>roglesby</Value>");
		sb.append("</Field>");
		sb.append("<Field Name = \"subtype-id\">");
		sb.append("<Value>VAPI-XP-TEST</Value>");
		sb.append("</Field>");
		sb.append("<Field Name = \"parent-id\">");
		sb.append("<Value>6209</Value>");
		sb.append("</Field>");
		sb.append("</Fields>");
		sb.append("</Entity>");

		return sb.toString();
	}

	public String getRunXmlExample(String test_config_id, String cycle_id, String test_id, String testcycl_id, String status){

		StringBuilder sb = new StringBuilder();
		DateTime d = new DateTime();

		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
		sb.append("<Entity Type=\"run\">");
		sb.append("<Fields>");
		sb.append("<Field Name=\"test-config-id\"><Value>"+test_config_id+"</Value></Field>");
		sb.append("<Field Name=\"cycle-id\"><Value>"+cycle_id+"</Value></Field>");
		sb.append("<Field Name=\"test-id\"><Value>"+test_id+"</Value></Field>");
		sb.append("<Field Name=\"testcycl-id\"><Value>"+testcycl_id+"</Value></Field>");			//2027 from teste instance (field = id)
		sb.append("<Field Name=\"name\"><Value>Run_AUT_"+d.getMonthOfYear()+"-"+d.getDayOfMonth()+"_"+d.getHourOfDay()+"-"+d.getMinuteOfHour()+"-"+d.getSecondOfMinute()+"</Value></Field>");
		sb.append("<Field Name=\"owner\"><Value>glauco.ramalho.yam</Value></Field>");
		sb.append("<Field Name=\"status\"><Value>"+(status == null ? "Not Completed" : status)+"</Value></Field>");
		sb.append("<Field Name=\"subtype-id\"><Value>hp.qc.run.MANUAL</Value></Field>");
		sb.append("<Field Name=\"duration\"><Value>1</Value></Field>");													//TODO
		sb.append("<Field Name=\"execution-date\"><Value>"+new java.sql.Date(new Date().getTime())+"</Value></Field>");
		sb.append("<Field Name=\"execution-time\"><Value>"+d.getHourOfDay()+":"+d.getMinuteOfHour()+":"+d.getSecondOfMinute()+"</Value></Field>");									//TODO
		sb.append("</Fields>");
		sb.append("</Entity>");

		return sb.toString();
	}

	public ArrayList<String> getFieldListFromJson(String json, String pesquisa){

		ArrayList<String> ids = new ArrayList<String>();

		Pattern p = Pattern.compile("\"([^\"]*)\"");
		Matcher m = p.matcher(json);

		while (m.find()) {

			if(pesquisa.equals("assign-rcyc")){
				if(m.group(1).equals(pesquisa)){
					m.find(); m.find(); m.find(); m.find(); m.find();
					ids.add(m.group(1));
				}
			} else {
				if(m.group(1).equals(pesquisa)){
					m.find(); m.find(); m.find();
					ids.add(m.group(1));
				}
			}
			
		}

		return ids;
	}
	
	public String getIdFromCreatedXmlRun(String xml, String pesquisa){

		String[] split = xml.split("<Field Name=\"id\">");
		String[] split2 = split[1].split("</Value>");
		String[] split3 = split2[0].split("<Value>");
		
		return split3[1];
	}

	public String getJsonRuns(
			String username, 
			String password, 
			String formatXMLorJSON, 
			String id) throws Exception {

		Constants c = new Constants();
		serverUrl = "http://" + c.HOST + ":" + c.PORT + "/qcbin";
		domain = c.DOMAIN;
		project = c.PROJECT;

		RestConnector con =
				RestConnector.getInstance().init(
						new HashMap<String, String>(),
						serverUrl,
						domain,
						project);

		StringBuilder query = new StringBuilder()
				//.append("fields=id,description,desstep-id,name,step-order,status,test-id,parent-id,expected,execution-time")
				.append("query={test-config-id["+id+"]}")
				//.append("&start-index=1")
				;

		AuthenticateLoginLogout auth = new AuthenticateLoginLogout();

		auth.login(username, password);

		String requiredFieldsUrl = con.buildUrl("rest/domains/"+domain+"/projects/"+project+"/"+ViewConstants.ALM.TestLab.RUNS);

		Map<String, String> requestHeaders = new HashMap<String, String>();
		requestHeaders.put("Content-Type", "application/"+formatXMLorJSON);
		requestHeaders.put("Accept", "application/"+formatXMLorJSON);

		con.GetQCSession(false);

		Response serverResponse = con.httpGet(requiredFieldsUrl,
				query.toString(), requestHeaders, true);

		if(formatXMLorJSON.equalsIgnoreCase("json")){
			return getPrettyJson(serverResponse.toString());
		} else if (formatXMLorJSON.equalsIgnoreCase(ViewConstants.MIME.XML)){
			return getPrettyXml(serverResponse.toString());
		} else {
			return "formato invlido";
		}
	}

	public String deleteRun(String username, 
			String password, 
			String formatXMLorJSON, 
			String id) throws Exception {

		Constants c = new Constants();
		serverUrl = "http://" + c.HOST + ":" + c.PORT + "/qcbin";
		domain = c.DOMAIN;
		project = c.PROJECT;

		RestConnector con =
				RestConnector.getInstance().init(
						new HashMap<String, String>(),
						serverUrl,
						domain,
						project);

		AuthenticateLoginLogout auth = new AuthenticateLoginLogout();

		auth.login(username, password);

		String requiredFieldsUrl = con.buildUrl("rest/domains/"+domain+"/projects/"+project+"/"+ViewConstants.ALM.TestLab.RUNS+"/"+id);

		Map<String, String> requestHeaders = new HashMap<String, String>();
		requestHeaders.put("Content-Type", "application/"+formatXMLorJSON);
		requestHeaders.put("Accept", "application/"+formatXMLorJSON);

		con.GetQCSession(false);

		Response serverResponse = con.httpDelete(requiredFieldsUrl, requestHeaders, true);

		if(formatXMLorJSON.equalsIgnoreCase("json")){
			return getPrettyJson(serverResponse.toString());
		} else if (formatXMLorJSON.equalsIgnoreCase(ViewConstants.MIME.XML)){
			return getPrettyXml(serverResponse.toString());
		} else {
			return "formato invlido";
		}
	}

	public String getInstanceFields(
		String username, 
		String password, 
		String formatXMLorJSON, 
		String entityType) throws Exception {

			Constants c = new Constants();
			serverUrl = "http://" + c.HOST + ":" + c.PORT + "/qcbin";
			domain = c.DOMAIN;
			project = c.PROJECT;

			RestConnector con = RestConnector.getInstance().init(new HashMap<String, String>(), serverUrl, domain, project);
			
			AuthenticateLoginLogout auth = new AuthenticateLoginLogout();

			auth.login(username, password);

			String requiredFieldsUrl = con.buildUrl("rest/domains/"+domain+"/projects/"+project+"/"+entityType+"/$metadata/fields");

			Map<String, String> requestHeaders = new HashMap<String, String>();
			requestHeaders.put("Content-Type", "application/"+formatXMLorJSON);
			requestHeaders.put("Accept", "application/"+formatXMLorJSON);

			con.GetQCSession(false);

			Response serverResponse = con.httpGet(requiredFieldsUrl, null, requestHeaders, true);

			if(formatXMLorJSON.equalsIgnoreCase("json")){
				return getPrettyJson(serverResponse.toString());
			} else if (formatXMLorJSON.equalsIgnoreCase(ViewConstants.MIME.XML)){
				return getPrettyXml(serverResponse.toString());
			} else {
				return "formato invlido";
			}

		}
	}

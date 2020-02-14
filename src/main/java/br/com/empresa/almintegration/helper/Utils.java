package br.com.empresa.almintegration.helper;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.swing.JFrame;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.exec.ExecuteException;
import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.genium_framework.appium.support.server.AppiumServer;
import com.github.genium_framework.server.ServerArguments;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.empresa.almintegration.alm.configuration.envModel.EnvSettings;
import br.com.empresa.almintegration.alm.configuration.settingsModel.Settings;
import br.com.empresa.almintegration.constants.Constants;
import br.com.empresa.almintegration.constants.ConstantsServices;
import br.com.empresa.almintegration.constants.ViewConstants;
import br.com.empresa.almintegration.execution.PlayTestCases;
import br.com.empresa.almintegration.model.ServiceResponse;
import br.com.empresa.almintegration.testing.tn3270.Mainframe;
import br.com.empresa.almintegration.testing.tn3270.net.sf.f3270.TerminalObserver;
import br.com.empresa.almintegration.testing.tn3270.net.sf.f3270.TerminalWindowObserver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * @author Gabriel Fraga
 * 
 * Essa classe tem como finalidade ser uma classe helper,
 * contendo varios metodos que podem ser usados por diversas classes de forma generica
 * 
 * 
 */
public class Utils extends PlayTestCases {

	private static final String DOT = ".";
	private static final String DASH = "_";
	private static final String BLANK = " ";
	private static final String COMMA = ":";
	private static Logger LOGGER = LoggerFactory.getLogger(Utils.class.getSimpleName());

	/**
	 * @author Gabriel Fraga
	 * 
	 * Metodo responsavel por carregar os linls de configuracoes dentro do arquivo properties
	 * 
	 * 
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	@Deprecated
	public static Properties carregarLinks() throws FileNotFoundException, IOException, URISyntaxException {
		Properties ids = new Properties();

		if(!Inet4Address.getLocalHost().getHostName().toUpperCase().contains("note_pe02b5n5")){ //maquina local
			File file = new File(Constants.configProperties);
			ids.load(new FileInputStream(file));
		} else {
			File file = new File(ViewConstants.Properties.CONFIG_LINKS);
			ids.load(new FileInputStream(file));
		}

		return ids;
	}
	
	/**
	 * @author Gabriel Fraga
	 * 
	 * Metodo responsavel por carregar os linls de configuracoes dentro do arquivo properties
	 * 
	 * 
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	@Deprecated
	public static Properties carregaWebPortal() throws FileNotFoundException, IOException, URISyntaxException {
		Properties ids = new Properties();

		if(!Inet4Address.getLocalHost().getHostName().toUpperCase().contains("note_pe02b5n5")){ //maquina local
			File file = new File(Constants.gtecProperties);
			ids.load(new FileInputStream(file));
		} else {
			File file = new File(ViewConstants.Properties.CONFIG_GTEC);
			ids.load(new FileInputStream(file));
		}

		return ids;
	}
	
	@Deprecated
	public static Properties carregarUrlsServicos() throws FileNotFoundException, IOException, URISyntaxException {

		Properties ids = new Properties();

		if(!Inet4Address.getLocalHost().getHostName().toUpperCase().contains("note_pe02b5n5")){ //maquina local
			File file = new File(Constants.servicosProperties);
			ids.load(new FileInputStream(file));
		} else {
			File file = new File(ViewConstants.Properties.CONFIG_SERVICOS);
			ids.load(new FileInputStream(file));
		}

		return ids;
	}
	
	@Deprecated
	public static Properties carregaAlmProperties() throws FileNotFoundException, IOException, URISyntaxException {

		Properties ids = new Properties();

		if(!Inet4Address.getLocalHost().getHostName().toUpperCase().contains("note_pe02b5n5")){ //maquina local
			File file = new File(Constants.almProperties);
			ids.load(new FileInputStream(file));
		} else {
			File file = new File(ViewConstants.Properties.CONFIG_ALM);
			ids.load(new FileInputStream(file));
		}

		return ids;
	}
	
	@Deprecated
	public static Properties carregaEmailProperties() throws FileNotFoundException, IOException, URISyntaxException {

		Properties ids = new Properties();

		if(!Inet4Address.getLocalHost().getHostName().toUpperCase().contains("note_pe02b5n5")){ //maquina local
			File file = new File(Constants.emailProperties);
			ids.load(new FileInputStream(file));
		} else {
			File file = new File(ViewConstants.Properties.CONFIG_ALM);
			ids.load(new FileInputStream(file));
		}

		return ids;
	}
	
	@Deprecated
	public static Properties carregaDBProperties() throws FileNotFoundException, IOException, URISyntaxException {

		Properties ids = new Properties();

		if(!Inet4Address.getLocalHost().getHostName().toUpperCase().contains("note_pe02b5n5")){ //maquina local
			File file = new File(Constants.dbProperties);
			ids.load(new FileInputStream(file));
		} else {
			File file = new File(ViewConstants.Properties.CONFIG_DB);
			ids.load(new FileInputStream(file));
		}

		return ids;
	}
	
	public static ArrayList<String> translateImageFromJSON(ServiceResponse sr, String className, String stepId, int stepOrder) throws Exception {
		ArrayList<BufferedImage> bufferedImages = new ArrayList<BufferedImage>();
		Font headerFont = new Font("Arial", Font.BOLD, 16);
		Font contentFont = new Font("Courier", Font.PLAIN, 12);
		Color color = Color.BLACK;
		String endPoint = sr.getEndpoint();
		String request = sr.getEvidenceContent();
		String response = sr.getResposeFromRequest();

		if(endPoint != null){
			bufferedImages.add(createImageFromText("ENDPOINT", headerFont, color));
			if (endPoint.length() > 80) {
				for (String split : splitAtCharacterCountForImageTranslation(endPoint)) {
					bufferedImages.add(createImageFromText(split, contentFont, color));
				}
			} else {
				bufferedImages.add(createImageFromText(endPoint, contentFont, color));
			}
		}

		try {
			bufferedImages.add(createImageFromText("REQUEST", headerFont, color));
			request = new StringBuffer().append("{REQUEST:").append(request).append("}").toString();
			JsonObject jsonObjectRequest = new JsonParser().parse(request).getAsJsonObject();
			for (BufferedImage bufferedImage : translateJsonObjectToImage(jsonObjectRequest)) {
				bufferedImages.add(bufferedImage);
			}
			
		} catch (Exception e) {
			String[] split = request.split("\\n");
			request = split[split.length - 1];
			bufferedImages.add(createImageFromText(request, contentFont, color));
		}

		if (!response.equals("")) {
			response = new StringBuffer().append("{RESPONSE:").append(response).append("}").toString();
			try {
				JsonObject jsonObjectResponse = new JsonParser().parse(response).getAsJsonObject();
				bufferedImages.add(createImageFromText("RESPONSE", headerFont, color));
				for (BufferedImage bufferedImage : translateJsonObjectToImage(jsonObjectResponse)) {
					bufferedImages.add(bufferedImage);
				}				
			} catch (Exception e) {
				bufferedImages.add(createImageFromText(response, contentFont, color));
			}
		}
		
		String classPath = Utils.getPath(className);
		String filePath = settings.getConfig().getPaths().getEvidencia() + classPath;

		ArrayList<BufferedImage> joinedImages = new ArrayList<BufferedImage>();
		int bufferedImageListSize = bufferedImages.size();
		if(bufferedImageListSize > 20){
			float ceil =(float) bufferedImageListSize / (float)20;
			int totalCycles = (int) Math.ceil(ceil);
			totalCycles = (totalCycles > 0) ? totalCycles : 1;
			int startList = 0;
			int endList = 20;
			for(int i = 0; i < totalCycles; i++){
				endList = (endList <= bufferedImageListSize) ? endList : bufferedImageListSize;
				joinedImages.add(joinVerticallyBufferedImages(bufferedImages.subList(startList, endList)));
				startList = endList;
				endList += 20;
			}
		}else{
			joinedImages.add(joinVerticallyBufferedImages(bufferedImages));
		}
		
		classPath = Utils.getPath(className);
		filePath = settings.getConfig().getPaths().getEvidencia() + classPath;

		File file = new File(filePath);
		file.mkdirs();
		ArrayList<String> imagesPath = new ArrayList<String>();
		for(int i = 0; i < joinedImages.size(); i++){
			BufferedImage jsonToImage = joinedImages.get(i);
			String fileName = stepId + DASH + i + DOT + ViewConstants.MIME.PNG;
			ImageIO.write(jsonToImage, ViewConstants.MIME.PNG, new File(filePath + fileName));
			imagesPath.add(filePath + fileName);
		}
		return imagesPath;
	}

	private static ArrayList<BufferedImage> translateJsonObjectToImage(JsonObject jsonObject) throws Exception {
		ArrayList<BufferedImage> bufferedImagesList = new ArrayList<BufferedImage>();
		Font font = new Font("Courier", Font.BOLD, 12);
		Color color = Color.BLACK;
		bufferedImagesList.add(createImageFromText("{", font, color));
		ArrayList<BufferedImage> tempImageList = new ArrayList<BufferedImage>();
		for (Entry<String, JsonElement> entry : jsonObject.entrySet()) {
			JsonElement valueElement = entry.getValue();
			if(valueElement.isJsonPrimitive()){
				for (BufferedImage bufferedImage : translateJsonPrimitiveToImage(entry)) {
					tempImageList.add(bufferedImage);
				}
			}else if(valueElement.isJsonArray()){
				tempImageList.add(createImageFromText(entry.getKey(), font, color));
				for (BufferedImage bufferedImage : translateJsonArrayToImage(valueElement.getAsJsonArray())) {
					tempImageList.add(bufferedImage);
				}				
			}else if(valueElement.isJsonObject()){
				for (BufferedImage bufferedImage : translateJsonObjectToImage(valueElement.getAsJsonObject())) {
					tempImageList.add(bufferedImage);
				}
			}
			for(Iterator<BufferedImage> iterator = tempImageList.iterator(); iterator.hasNext();){
				BufferedImage bufferedImage = (BufferedImage) iterator.next();
				bufferedImagesList.add(bufferedImage);
			}
			tempImageList = new ArrayList<BufferedImage>();
		}
		font = new Font("Courier", Font.BOLD, 12);
		color = Color.BLACK;
		bufferedImagesList.add(createImageFromText("},", font, color));
		return bufferedImagesList;
	}
	private static ArrayList<BufferedImage> translateJsonPrimitiveToImage(Entry<String, JsonElement> entry) {
		ArrayList<BufferedImage> bufferedImagesList = new ArrayList<BufferedImage>();
		String field = entry.getKey() + ": ";
		String value = entry.getValue().toString();
		Font contentFont = new Font("Courier", Font.BOLD, 12);
		Color color = Color.BLACK;
		BufferedImage fieldImage = createImageFromText(field, contentFont, color);
		contentFont = new Font("Courier", Font.PLAIN, 12);
		if( (field.length() + value.length()) > 80){
			List<BufferedImage> splittedBufferedImagesList = new ArrayList<BufferedImage>();
			int i = 0;
			for (String splittedValue : splitAtCharacterCountForImageTranslation(value)) {
				color = (isNumeric(splittedValue.toString())) ? Color.BLUE : Color.RED;
				if(i++ == 0){
					ArrayList<BufferedImage> fieldValueImage = new ArrayList<BufferedImage>();
					fieldValueImage.add(fieldImage);
					fieldValueImage.add(createImageFromText(splittedValue, contentFont, color));
					bufferedImagesList.add(joinHorizontallyBufferedImages(fieldValueImage));
				}else{
					splittedBufferedImagesList.add(createImageFromText(splittedValue, contentFont, color));
				}
			}
			bufferedImagesList.addAll(splittedBufferedImagesList);
		} else {
			ArrayList<BufferedImage> fieldValueImage = new ArrayList<BufferedImage>();
			color = (isNumeric(value)) ? Color.BLUE : (value.equals("true") | value.equals("false")) ? Color.GREEN : Color.RED;
			fieldValueImage.add(fieldImage);
			value += " ,";
			fieldValueImage.add(createImageFromText(value, contentFont, color));
			bufferedImagesList.add(joinHorizontallyBufferedImages(fieldValueImage));
		}
		return bufferedImagesList;
	}

	public static boolean isNumeric(String value) {
		return value.matches("[-+]?\\d*\\.?\\d+");	
	}

	private static ArrayList<BufferedImage> translateJsonArrayToImage(JsonArray jsonArray) throws Exception {
		ArrayList<BufferedImage> bufferedImagesList = new ArrayList<BufferedImage>();
		Font font = new Font("Courier", Font.BOLD, 12);
		Color color = Color.BLACK;
		bufferedImagesList.add(createImageFromText("[", font, color));
		for (JsonElement jsonElement : jsonArray) {
			if(jsonElement.isJsonObject()){ 
				for (BufferedImage bufferedImage : translateJsonObjectToImage(jsonElement.getAsJsonObject())) {
					bufferedImagesList.add(bufferedImage);
				}
			}
			if(jsonElement.isJsonPrimitive()) {
				font = new Font("Courier", Font.PLAIN, 12);
				color = (jsonElement.toString().contains("\"")) ? Color.RED : Color.BLUE;
				bufferedImagesList.add(createImageFromText(jsonElement.toString() + ",", font, color));
			}
			if(jsonElement.isJsonArray()) {
				for (BufferedImage bufferedImage : translateJsonArrayToImage(jsonElement.getAsJsonArray())) {
					bufferedImagesList.add(bufferedImage);
				}
			}
		}
		font = new Font("Courier", Font.BOLD, 12);
		color = Color.BLACK;
		bufferedImagesList.add(createImageFromText("]", font, color));

		return bufferedImagesList;		
	}

	public static BufferedImage createImageFromText(String text, Font font, Color color){
		int offset = 25;
		BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = img.createGraphics();		
		FontMetrics fm = g2d.getFontMetrics();
		int width = fm.stringWidth(text) + offset;
		int height = fm.getHeight();

		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		g2d = img.createGraphics();
		g2d.setColor(color);
		g2d.setFont(font);
		g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
		g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
		g2d.drawString(text, 0, fm.getAscent());
		g2d.dispose();
		return img;
	}
	
	public static BufferedImage joinVerticallyBufferedImages(List<BufferedImage> imgs) {
		int width = 0;
		int height = 0;

		for (BufferedImage bufferedImage : imgs) {
			if(bufferedImage != null){
				width = (bufferedImage.getWidth() > width) ? bufferedImage.getWidth() : width;
				height += bufferedImage.getHeight();
			}
		}

		BufferedImage joinedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = joinedImage.createGraphics();
		Color oldColor = g2.getColor();
		//fill background
		g2.setPaint(Color.WHITE);
		g2.fillRect(0, 0, width, height);
		//draw image
		g2.setColor(oldColor);
		
		int x = 0;
		int y = 0;
		for (BufferedImage bufferedImage : imgs) {
			if(bufferedImage != null){
				g2.drawImage(bufferedImage, null, x, y);
				y += bufferedImage.getHeight();
			}
		}		
		g2.dispose();
		return joinedImage;
	}
	
	public static BufferedImage joinHorizontallyBufferedImages(List<BufferedImage> imgs) {
		int offset = 20;
		int width = 0;
		int height = 0;

		for (BufferedImage bufferedImage : imgs) {
			width += bufferedImage.getWidth();
			height = (bufferedImage.getHeight() > height) ? bufferedImage.getHeight() : height;
		}

		BufferedImage joinedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = joinedImage.createGraphics();
		Color oldColor = g2.getColor();
		//fill background
		g2.setPaint(Color.WHITE);
		g2.fillRect(0, 0, width, height);
		//draw image
		g2.setColor(oldColor);
		
		int x = 0;
		int y = 0;
		for (BufferedImage bufferedImage : imgs) {
			g2.drawImage(bufferedImage, null, x, y);
			x += bufferedImage.getWidth() - offset;
		}		
		g2.dispose();
		return joinedImage;
	}
	
	private static String[] splitAtCharacterCountForImageTranslation(String content){
		content = content.replaceAll("(.{80})", "$1|");
		String[] split = content.split("\\|");
	    return split;
	}
	
	public static String createEvidenceToPDF(String request, 
			String response, 
			String className, 
			String message,
			Object result) throws FileNotFoundException, IOException, URISyntaxException{

		Document doc = null;
		OutputStream os = null;
		String path = null;

		try {

			doc = new Document();

			path = getPath(className);

			String pathName = settings.getConfig().getPaths().getEvidencia() + path;

			File file = new File(pathName);
			file.mkdirs();

			String fileName = className + "_" + 
			getDataHora(ViewConstants.XpathProperties.DATA_HORA) + 
			ViewConstants.XpathProperties.PDF_EXTENSION;
			
			os = new FileOutputStream(pathName + fileName);
			
			System.err.println(fileName);
			
			PdfWriter.getInstance(doc, os);

			doc.open();

			Paragraph p1 = new Paragraph("Request:");
			doc.add(p1);

			Paragraph p = new Paragraph(request);
			doc.add(p);

			Paragraph p3 = new Paragraph("<---------------------------------------------------------------------------------------------->");
			doc.add(p3);

			Paragraph p4 = new Paragraph("Response: "+result + "\n\n");
			doc.add(p4);

			p = new Paragraph(response);
			doc.add(p);

			Paragraph p6 = new Paragraph("____________________________________________________________________________");
			doc.add(p6);

			if (StringUtils.isNoneBlank(message)) {

				Paragraph p7 = new Paragraph("Message:");
				doc.add(p7);

				Paragraph p8 = new Paragraph(message);
				doc.add(p8);

				Paragraph p9 = new Paragraph("<---------------------------------------------------------------------------------------------->");
				doc.add(p9);
			}

			doc.close();
			os.close();

			PDDocument document = PDDocument.load(new File(pathName + fileName));
			PDFRenderer pdfRenderer = new PDFRenderer(document);
			String imageFileName = "";
//			for (int page = 0; page < document.getNumberOfPages(); ++page)
//			{ 
//			    imageFileName = pathName + fileName + "-" + (page+1) + ".png";
//				BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 100, ImageType.RGB);			    
//			    ImageIOUtil.writeImage(bim, imageFileName, 100);
//			}
//			document.close();
			return pathName + fileName;
		} catch (Exception e) {
			System.out.println("Erro ao gerar evidencias do servico:" + className);
		}
		
		return null;

	}
	
	public static String getPath(String name) throws Exception{

		String valorFinal = null;
		String barra = "//";

		try {

			if(name.contains(ConstantsServices.PASSED)){
				valorFinal = barra+Constants.SUCCESS+barra;
			}else if (name.contains(ConstantsServices.FAIL)){
				valorFinal = barra+Constants.FAIL+barra;
			}else{
				valorFinal = barra+Constants.UNITTEST+barra;
			}

		} catch (Exception e) {

			throw e;
		}

		return valorFinal;
	}

	public static String getDataHora(String format){

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date hora = Calendar.getInstance().getTime();
		String dataFormatada = sdf.format(hora);

		return dataFormatada;
	}
	
	public static String captureMainframeScreenshot() {
	    Component component = getMainframeJFrame();
		Rectangle rect = component.getBounds();
	    
        String format = "png";
        String path = "utilitarios/screenshots//";
        String timeStamp = getDataHora("yyyy.MM.dd.HH.mm.ss");
        String fileName = path + timeStamp + "." + format;
  		try {
  			BufferedImage captureImage =
  					new BufferedImage(rect.width, rect.height,
  							BufferedImage.TYPE_4BYTE_ABGR);
  			component.paint(captureImage.getGraphics());
  			ImageIO.write(captureImage, format, new File(fileName)); 			
  					
  		} catch (IOException ex) {
			System.err.println(ex);
		} catch (NullPointerException e) {
			
		}
  		return fileName;
	}
	
	private static Component getMainframeJFrame() {
		Mainframe mf = (Mainframe) Mainframe.getInstance();
		Collection<TerminalObserver> terminalObservers = mf.getTerminalObservers();
		TerminalWindowObserver windowObserver = null;
		for (TerminalObserver terminalObserver : terminalObservers) {
			if(terminalObserver.getClass().equals(TerminalWindowObserver.class)){
				windowObserver = (TerminalWindowObserver) terminalObserver;
			}
		}
		JFrame frame = windowObserver.getTerminalWindow().getFrame();
		return frame;
	}

	public static void trustAllHosts() {
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[]{};
            }

            public void checkClientTrusted(X509Certificate[] chain,
                                           String authType) throws CertificateException {
            }

            public void checkServerTrusted(X509Certificate[] chain,
                                           String authType) throws CertificateException {
            }
        }};

        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection
                    .setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public static String formatAttributeValue(String name, String localName) {
		return new StringBuilder().append(name).append('_').append(localName).toString().toUpperCase().replace('-', '_');
	}

    final static HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };

	/**
	 * Fabrica<BR>
	 *
	 * AUT-126 - Relatrio de execuo em Excel<BR>
	 *
	 * @since 8 de jul de 2016 14:55:26
	 * @author Gabriel Aguido Fraga<BR>
	 */
	public static Properties carregarIdentificadoresCTs() throws FileNotFoundException, IOException, URISyntaxException {
		
		Properties ids = new Properties();

		if (!Inet4Address.getLocalHost().getHostName().toUpperCase().contains("VININM701LIV")) { // maquina local
			
			File file = new File(Constants.CTS);
			ids.load(new FileInputStream(file));
		} 
		else {
			
			File file = new File(ViewConstants.Properties.CONFIG_LINKS);
			ids.load(new FileInputStream(file));
		}

		return ids;
	}
	
	public String transformMillisToTime(long millis){

		String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
				TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
				TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));

		return hms;
	}
	
	/**
	 * Fabrica<BR>
	 *
	 * AUT-126 - Relatrio de execuo em Excel<BR>
	 *
	 * @since 29 de jul de 2016 10:51:25
	 * @author Gabriel Aguido Fraga<BR>
	 */
	public static String calculaPercentual(double valor, double total) {
		
		DecimalFormat fmt = new DecimalFormat("0.00");
				
		try {

			return fmt.format((valor * 100) / total);
		} 
		catch (Exception e) {

			return "0,00";
		}
	}
	
	/**
	 * Fabrica<BR>
	 *
	 * AUT-126 - Relatrio de execuo em Excel<BR>
	 *
	 * @since 11 de jul de 2016 10:55:24
	 * @author Gabriel Aguido Fraga<BR>
	 */
	public static String removeQuebraLinha (String s) {
		
		if (StringUtils.isNotBlank(s)) {
			
			s = s.replaceAll("\r", ""); 
			s = s.replaceAll("\t", "");
			s = s.replaceAll("\n", "");
		}
		
		return s;
	}
	
	/**
	 * Metodo responsvel por arquivar as evidencias 
	 * 
	 * @author Gabriel Aguido Fraga
	 * @Fabrica
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static void arquivarEvidencias(String suite) throws FileNotFoundException, IOException, URISyntaxException {
		
		System.out.println("Entrou no metodo arquivarEvidencias");
		
		
		String directoryEvidences = settings.getConfig().getPaths().getEvidencia();
		String directoryConsolidado = settings.getConfig().getPaths().getEvidenciasConsolidadas() + suite + "-" + getDataHora(ViewConstants.XpathProperties.DATA_HORA);

		File diretorioTemporario = new File(directoryEvidences);
		if(diretorioTemporario.isDirectory()){

			File[] files = diretorioTemporario.listFiles();

			for (File file : files) {
				
				Utils.moveArquivo(directoryConsolidado, new File(file.getAbsolutePath()));
			}
		}
		
		System.out.println("Evidencias movidas com sucesso");
	}
	
	/**
	 * 
	 * @author Gabriel Aguido Fraga
	 * @Fabrica
	 * 
	 * Mtodo responsvel por mover evidencias para a pasta 
	 * 
	 * @param sourcePath
	 * @param destPath
	 * @return
	 */
	public static void moveArquivo(final String pastaDestino, final File nomeArquivoOrigem) {
		File diretorioDestino = new File(pastaDestino);

		if (!diretorioDestino.exists()) {
			diretorioDestino.mkdirs();
		}
		boolean ok = nomeArquivoOrigem.renameTo(new File(diretorioDestino, nomeArquivoOrigem.getName()));
		if (ok) {
			System.out.println("Arquivo foi movido com sucesso");
		} else {
			System.out.println("Nao foi possivel mover o arquivo");
		}
	}
	
	/**
	 * Fabrica<BR>
	 *
	 * AUT-190 - Servios - Falha de execuo na suite Servicos_AuthenticationService<BR>
	 *
	 * @since 5 de ago de 2016 08:40:17
	 * @author Gabriel Aguido Fraga<BR>
	 */
	public static File arquivarEvidenciasConsolidadas() throws FileNotFoundException, IOException, URISyntaxException {
		
		System.out.println("Entrou no metodo arquivarEvidenciasConsolidadas");

		File f = null;
		
		String directoryEvidences = settings.getConfig().getPaths().getEvidenciasConsolidadas();
		
		String directoryConsolidado = settings.getConfig().getPaths().getEvidenciasConsolidadas()
				+ File.separator + "Automacao-Consolidado" + "-" + getDataHora(ViewConstants.XpathProperties.DATA_HORA);

		File diretorioTemporario = new File(directoryEvidences);

		if (diretorioTemporario.isDirectory()) {

			File[] files = diretorioTemporario.listFiles();

			for (File file : files) {

				if(file.toString().contains(ViewConstants.XpathProperties.PDF_EXTENSION)){
					f = file;
				}
				
				Utils.moveArquivo(directoryConsolidado, new File(file.getAbsolutePath()));
			}
		}
		

		System.out.println("Evidencias consolidadas movidas com sucesso");

		return f;
	}
	
	public boolean generateSHA1Pass(String pass) throws NoSuchAlgorithmException, FileNotFoundException, IOException, URISyntaxException{
		
		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte messageDigest[] = algorithm.digest(pass.getBytes("UTF-8"));
		 
		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
		  hexString.append(String.format("%02X", 0xFF & b));
		}
		
		if(Utils.carregaEmailProperties().get(ViewConstants.EMAIL.Credentials.EMAIL_PASS).equals(hexString.toString())){
			System.out.println(hexString.toString());
			return true;
		}
		
		return false;
	}
	
	public static WebDriver initializeChromeDriver() throws Exception {
//		WebDriver driver = new ChromeDriver(new DesiredCapabilities().chrome());
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		return driver;
		
		File file = new File(Constants.CHROMEDRIVER_EXE);

		if (!file.exists()) {

			throw new Exception("Erro ao localizar o driver");
		}
		
		ChromeDriverService chromeService = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File(Constants.CHROMEDRIVER_EXE))
				.usingAnyFreePort().build();

		chromeService.start();
		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "about:blank");

		RemoteWebDriver driver = new RemoteWebDriver(chromeService.getUrl(), capabilities);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public Settings getSettings() throws JAXBException{
		JAXBContext jc = JAXBContext.newInstance(Settings.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Settings s = (Settings) unmarshaller.unmarshal(new File("./utilitarios/properties/settings.xml"));

        LOGGER.info("["+new Date()+"] Obtendo arquivos de configuracoes do projeto...");
        return s;
	}
	
	public EnvSettings getEnvSettings(Settings s) throws JAXBException {
		
		JAXBContext jc = JAXBContext.newInstance(EnvSettings.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        EnvSettings envSettings = (EnvSettings) unmarshaller.unmarshal(new File("./utilitarios/properties/"+s.getEnv()+".xml"));

        LOGGER.info("["+new Date()+"] Obtendo arquivos de configuracoes de ambiente...");
        return envSettings;
	}
	
	public br.com.empresa.almintegration.alm.configuration.almModel.Settings getALMConfigs(Settings s) throws JAXBException {
		
		String fileName = "oldALM.xml";
		if(s.getConfig().getALM().getProject().getProject().contains("_OLD")){
			fileName = "oldALM.xml";
		} else {
			fileName = "newALM.xml";
		}
		
		JAXBContext jc = JAXBContext.newInstance(br.com.empresa.almintegration.alm.configuration.almModel.Settings.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        br.com.empresa.almintegration.alm.configuration.almModel.Settings envSettings = (br.com.empresa.almintegration.alm.configuration.almModel.Settings) unmarshaller.unmarshal(new File("./utilitarios/properties/"+fileName));

        LOGGER.info("["+new Date()+"] Obtendo arquivos de configuracoes do do ALM...");
        return envSettings;
	}

	public static String insertBreaklinesInJSON(String finalResponse) {
		return finalResponse;
	}
	
	public static AppiumServer initializeServer() throws ExecuteException, IOException, InterruptedException, URISyntaxException{

		Utils.uninstallAppiumSettingsApp();
		stopServer();
		ServerArguments serverArguments = new ServerArguments();
		serverArguments.setArgument("--port", 4723);
		serverArguments.setArgument("--local-timezone", true);
		serverArguments.setArgument("--address", "127.0.0.1");
		AppiumServer appiumServer = new AppiumServer(new File("C:\\Program Files (x86)\\Appium"), serverArguments);
		appiumServer.startServer(60000);
		return appiumServer;
	}
	
	public static void stopServer() throws IOException{

		StringBuilder command = new StringBuilder();
		command.append("cmd /c echo off")
		.append(" & ")
		.append("FOR /F \"usebackq tokens=5\" %p in (`netstat -nao ^| findstr /R /C:\"4723\"`) ")
		.append("do (FOR /F \"usebackq\" %t in (`TASKLIST /FI \"PID eq %p\" ^| findstr /I node.exe`) ")
		.append("do taskkill /F /PID %p)");

		Runtime.getRuntime().exec(command.toString());

	}
	
	public static void closeEmulator() throws FileNotFoundException, IOException, URISyntaxException{
		Runtime.getRuntime().exec(carregarLinks().getProperty(ViewConstants.Commands.ADB_PATH)+"adb emu kill");
	}
	
	public static WebDriver initializeiOSDriver(String deviceName, String appPath) throws InterruptedException, IOException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"iOS");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
		if (deviceName == null)	caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6 Plus"); else caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);//nome do dispositivo
		caps.setCapability(MobileCapabilityType.APP, appPath);
		//caps.setCapability(MobileCapabilityType.UDID, "8ab872d5a64f6e7fdcc7b5dab6c4914cb4b05ccf");

		Runtime.getRuntime().exec("open -a Simulator --args");

		return new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	}
	
	public static boolean verificarSeHaDispositivosAndroidAtivos() throws IOException, URISyntaxException{

		Process proc = Runtime.getRuntime().exec(carregarLinks().getProperty(ViewConstants.Commands.ADB_PATH)+"adb shell getprop init.svc.bootanim");
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));

		try{
			String s = "";
			if ((s = stdInput.readLine()).contains("stopped")) {
				//Quando encontrar o resultado do comando 'stopped', é porque o
				//dispositivo ja esta aberto e tudo está ok;
				System.out.println("Rodando testes em dispositivo físico");
				return true;
			}
		} catch (NullPointerException npe){
			return false;
		}

		return false;
	}
	
	private static String aguardarDispositivoAndroidLigar() throws IOException, InterruptedException, URISyntaxException{

		Process proc = Runtime.getRuntime().exec(carregarLinks().getProperty(ViewConstants.Commands.ADB_PATH)+"adb shell getprop init.svc.bootanim");

		BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

		try{
			// read the output from the command
			String s = "";
			if (!(s = stdError.readLine()).contains("HUEHUE")) {
				//enquanto não encontrar (nunca irá rs) a palavra 'HUEHUE', 
				//re-executa o comando de verificar se esta ativo o dispositivo;
				aguardarDispositivoAndroidLigar();
			}

		} catch(NullPointerException npe){
			String s = "";
			if (!(s = stdInput.readLine()).contains("stopped")) {
				//Quando encontrar o resultado do comando 'stopped', é porque o
				//dispositivo ja esta aberto e tudo está ok;
				aguardarDispositivoAndroidLigar();
			}
		}

		return "Dispositivo Carregado!";

	}
	
	public static AndroidDriver<AndroidElement> initializeAndroidDriver(String deviceName, String appPath) throws InterruptedException, IOException, URISyntaxException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
		
		if (appPath == null) {
			//caps.setCapability(MobileCapabilityType.APP, "Browser");
			//caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
			caps.setCapability(MobileCapabilityType.APP_PACKAGE, "com.asus.calculator");
			caps.setCapability(MobileCapabilityType.APP_ACTIVITY, ".Calculator");
		} else {
			caps.setCapability(MobileCapabilityType.APP, new File(appPath).getAbsolutePath());
			//caps.setCapability(MobileCapabilityType.APP_PACKAGE, Constants.pacote);
			//caps.setCapability(MobileCapabilityType.APP_ACTIVITY, Constants.classe);
		}

		if (deviceName == null){ 
			caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Emulator"); 
		} else {
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName); 
		}

		if(verificarSeHaDispositivosAndroidAtivos()){
			AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.MINUTES);
			return driver;
		} else {
			Runtime.getRuntime().exec(carregarLinks().getProperty(ViewConstants.Commands.EMULATOR_PATH)+"emulator -netdelay none -netspeed full -no-boot-anim -avd Nexus_5X_API23");
			System.out.println(aguardarDispositivoAndroidLigar());
			AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.MINUTES);
			return driver;
		}

	}
	
	public static void uninstallAppiumSettingsApp() throws FileNotFoundException, IOException, URISyntaxException{
		
		//adb uninstall com.test.app
		Runtime.getRuntime().exec(carregarLinks().getProperty(ViewConstants.Commands.ADB_PATH)+"adb uninstall io.appium.unlock");
		Runtime.getRuntime().exec(carregarLinks().getProperty(ViewConstants.Commands.ADB_PATH)+"adb uninstall io.appium.settings");
		
	}
	
	
	
}
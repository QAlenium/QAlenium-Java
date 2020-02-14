package br.com.empresa.almintegration.evidences;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.util.Properties;

import org.odftoolkit.odfdom.dom.element.OdfStylePropertiesBase;
import org.odftoolkit.odfdom.dom.element.style.StyleMasterPageElement;
import org.odftoolkit.odfdom.pkg.OdfAttribute;
import org.odftoolkit.odfdom.pkg.OdfElement;
import org.odftoolkit.odfdom.pkg.OdfFileDom;
import org.odftoolkit.odfdom.pkg.OdfName;
import org.odftoolkit.odfdom.pkg.OdfXMLFactory;

import br.com.empresa.almintegration.evidences.content.EvidencesContentAutomaticStyles;
import br.com.empresa.almintegration.evidences.styles.EvidencesProperties;
import br.com.empresa.almintegration.evidences.styles.EvidencesStylesOfficeAutomaticStyles;
import br.com.empresa.almintegration.evidences.styles.EvidencesStylesOfficeStyles;
import br.com.empresa.almintegration.evidences.styles.EvidencesStylesOfficeStyles.ParagraphStyleNames;


public class Commons {
	private static Properties properties;
	private static final EvidencesWriter evidencesWriter = EvidencesWriter.getInstance();
	public static String getProperty(String name, String prefix, String localName) {
		return getProperty(new StringBuffer().append(name).append("_").append(prefix).append('_').append(localName).toString().toUpperCase().replace('-', '_'));
	}
	
	public static void main(String[] args) throws Exception {
		
	}

	public static String getProperty(String key){
		try {
			properties = (properties == null) ? getPropertiesFile() : properties;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (String) properties.getProperty(key, key);
	}
	
	private static Properties getPropertiesFile() throws Exception{
		File file = new File("resources\\document.properties");
		FileInputStream fileInput = new FileInputStream(file);
		Properties properties = new Properties();
		properties.load(fileInput);
		fileInput.close();		
		return properties;
	}
	
	public static void insertImage(String imagePath){
		try {
			URI uri = URI.create(imagePath);
			String[] split = imagePath.split("/");
			String imageName = split[split.length - 1];
			evidencesWriter.getTextDocument().getPackage().insert(uri, "./Pictures/" + imageName, "image/png");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	
	/*public static String getDefaultParagraphFontStyle(){
		EvidencesContentAutomaticStyles evidencesOfficeStyles = evidencesWriter.getEvidencesContentAutomaticStyles();
		return evidencesOfficeStyles.getDocumentDefaultParagraphStyle();
	}*/

	public static int getCurrentPageNumber(){
		return evidencesWriter.getEvidencesContentOfficeBodyElement().getCurrentPageNumber();
	}
	
	public static String getBoldParagraphFontStyle(){
		EvidencesStylesOfficeAutomaticStyles evidencesOfficeStyles = evidencesWriter.getEvidencesOfficeAutomaticStyles();
		return evidencesOfficeStyles.getBoldParagraphFontStyle();
	}
	
	public static String getTestCaseColumnAStyleName(){
		return evidencesWriter.getEvidencesOfficeAutomaticStyles().getTestCaseColumnAStyleName();
	}
	
	public static String getTestCaseColumnBStyleName(){
		return evidencesWriter.getEvidencesOfficeAutomaticStyles().getTestCaseColumnBStyleName();
	}
	
	public static String getTestCaseColumnCStyleName(){
		return evidencesWriter.getEvidencesOfficeAutomaticStyles().getTestCaseColumnCStyleName();
	}
	
	public static String getTestCaseColumnDStyleName(){
		return evidencesWriter.getEvidencesOfficeAutomaticStyles().getTestCaseColumnDStyleName();
	}
	
	public static String getTestCaseColumnEStyleName(){
		return evidencesWriter.getEvidencesOfficeAutomaticStyles().getTestCaseColumnEStyleName();
	}
	
	public static String getTestCaseColumnFStyleName(){
		return evidencesWriter.getEvidencesOfficeAutomaticStyles().getTestCaseColumnFStyleName();
	}
	
	public static String getTestCaseRow1StyleName(){
		return evidencesWriter.getEvidencesOfficeAutomaticStyles().getTestCaseRow1StyleName();
	}
	
	public static String getTestCaseRow2StyleName(){
		return evidencesWriter.getEvidencesOfficeAutomaticStyles().getTestCaseRow2StyleName();
	}
	
	public static String getTestCaseRow3StyleName(){
		return evidencesWriter.getEvidencesOfficeAutomaticStyles().getTestCaseRow3StyleName();
	}
	
	public static String getUCLabelStyleName(){
		return evidencesWriter.getEvidencesOfficeAutomaticStyles().getUCLabelStyleName();
	}
	
	public static String getUCValueStyleName(){
		return evidencesWriter.getEvidencesOfficeAutomaticStyles().getUCValueStyleName();
	}
	
	public static String getTCLabelStyleName(){
		return evidencesWriter.getEvidencesOfficeAutomaticStyles().getTCLabelStyleName();
	}
	
	public static String getTCValueStyleName(){
		return evidencesWriter.getEvidencesOfficeAutomaticStyles().getTCValueStyleName();
	}
	
	public static String getDateLabelStyleName(){
		return evidencesWriter.getEvidencesOfficeAutomaticStyles().getDateLabelStyleName();
	}
	
	public static String getDateValueStyleName(){
		return evidencesWriter.getEvidencesOfficeAutomaticStyles().getDateValueStyleName();
	}
	
	public static String getTimeLabelStyleName(){
		return evidencesWriter.getEvidencesOfficeAutomaticStyles().getTimeLabelStyleName();
	}
	
	public static String getTimeValueStyleName(){
		return evidencesWriter.getEvidencesOfficeAutomaticStyles().getTimeValueStyleName();
	}
	
	public static String getLogoColumnAStyleName(){
		return evidencesWriter.getEvidencesOfficeAutomaticStyles().getLogoColumnAStyleName();
	}
	
	public static String getLogoColumnBStyleName(){
		return evidencesWriter.getEvidencesOfficeAutomaticStyles().getLogoColumnBStyleName();
	}
	
	public static String getLogoRow1StyleName(){
		return evidencesWriter.getEvidencesOfficeAutomaticStyles().getLogoRow1StyleName();
	}
	
	public static String getLogoRow2StyleName(){
		return evidencesWriter.getEvidencesOfficeAutomaticStyles().getLogoRow2StyleName();
	}
	
	public static String getLogoRow3StyleName(){
		return evidencesWriter.getEvidencesOfficeAutomaticStyles().getLogoRow3StyleName();
	}
	
	public static String getLogoCellStyleName(){
		return evidencesWriter.getEvidencesOfficeAutomaticStyles().getLogoCellStyleName();
	}
	
	public static String getLogoSecondCellStyleName(){
		return evidencesWriter.getEvidencesOfficeAutomaticStyles().getLogoSecondCellStyleName();
	}

	public static String getNormalParagraphOfficeStyleStyleName(){
		EvidencesStylesOfficeStyles evidencesOfficeStyles = evidencesWriter.getEvidencesOfficeStyles();
		return evidencesOfficeStyles.getNormalParagraphStylename();
	}
	
	public static String getDefaultParagraphOfficeStyleStyleName(){
		EvidencesStylesOfficeStyles evidencesOfficeStyles = evidencesWriter.getEvidencesOfficeStyles();
		return evidencesOfficeStyles.getDefaultParagraphStylename();
	}
	
	public static String getCoverPageGraphicElementStyleName(){
		EvidencesContentAutomaticStyles evidencesContentAutomaticStyles = evidencesWriter.getEvidencesContentAutomaticStyles();
		return evidencesContentAutomaticStyles.getCoverPageGraphicElementStyleName();
	}	

	public static String getCoverPageBottomTableStyleName(){
		EvidencesContentAutomaticStyles evidencesContentAutomaticStyles = evidencesWriter.getEvidencesContentAutomaticStyles();
		return evidencesContentAutomaticStyles.getCoverPageBottomTableStyleName();
	}

	public static String getCoverPageBottomGraphicElementStyleName(){
		EvidencesContentAutomaticStyles evidencesContentAutomaticStyles = evidencesWriter.getEvidencesContentAutomaticStyles();
		return evidencesContentAutomaticStyles.getCoverPageBottomGraphicElementStyleName();
	}
	
	public static String getDocumentDefaultParagraphStyle(){
		EvidencesContentAutomaticStyles evidencesContentAutomaticStyles = evidencesWriter.getEvidencesContentAutomaticStyles();
		return evidencesContentAutomaticStyles.getDocumentDefaultParagraphStyle();
	}

	public static String getTOCParagraphIndexBodyStyleNameAutomaticStyle(){
		EvidencesContentAutomaticStyles evidencesContentAutomaticStyles = evidencesWriter.getEvidencesContentAutomaticStyles();
		return evidencesContentAutomaticStyles.getTOCParagraphIndexBodyStyleName();
	}
	
	public static String getTOCParagraphTextPStyleNameAutomaticStyle(){
		EvidencesContentAutomaticStyles evidencesContentAutomaticStyles = evidencesWriter.getEvidencesContentAutomaticStyles();
		return evidencesContentAutomaticStyles.getTOCParagraphTextPStyleName();
	}
	
	public static String getCoverTitleParagraphStyle(){
		return evidencesWriter.getEvidencesContentAutomaticStyles().getCoverTitleParagraphStyle();
	}
	
	public static String getCoverPageTitleTextStyleName(){
		return evidencesWriter.getEvidencesContentAutomaticStyles().getCoverPageTitleTextStyleName();
	}
	
	public static String getCoverPageSubTitleTextStyleName(){
		return evidencesWriter.getEvidencesContentAutomaticStyles().getCoverPageSubTitleTextStyleName();
	}
	
	public static String getTextHyperlinkOfficeStylesStylesStylename(){
		EvidencesStylesOfficeStyles evidencesOfficeStyles = evidencesWriter.getEvidencesOfficeStyles();
		return evidencesOfficeStyles.getHyperlinkStyleName();
	}
	
	public static String getOfficeStyleParagraphStyle(ParagraphStyleNames currentParagraphStyleNames){
		EvidencesStylesOfficeStyles evidencesOfficeStyles = evidencesWriter.getEvidencesOfficeStyles();
		if (currentParagraphStyleNames.equals(ParagraphStyleNames.DEFAULT_PARAGRAPH_HEADER_STYLE)) return evidencesOfficeStyles.getDefaultParagraphStylename();
		if (currentParagraphStyleNames.equals(ParagraphStyleNames.TOC_PARAGRAPH_HEADER_STYLE)) return evidencesOfficeStyles.getTOCParagraphStylename();
		return null;
	}
	
	public String getOfficeStyleHyperlinkStyle(){
		EvidencesStylesOfficeStyles evidencesOfficeStyles = evidencesWriter.getEvidencesOfficeStyles();
		return evidencesOfficeStyles.getHyperlinkStyleName();
	}

	public static void setAttributes(OdfStylePropertiesBase propertiesElement,
			EvidencesProperties evidencesProperty, String styleName) {
		OdfFileDom odfFileDom = (OdfFileDom) propertiesElement.getOwnerDocument();
		propertiesElement.setOdfAttribute(setOdfAttribute(odfFileDom, evidencesProperty, styleName));
	}

	public static void setAttributes(OdfElement propertiesElement, EvidencesProperties evidencesProperty, String styleName) {
		OdfFileDom odfFileDom = (OdfFileDom) propertiesElement.getOwnerDocument();
		propertiesElement.setOdfAttribute(setOdfAttribute(odfFileDom, evidencesProperty, styleName));
	}
	
	public static String getLogoParagraphStyleName(){
		return evidencesWriter.getEvidencesContentAutomaticStyles().getLogoParagraphStyleName();
	}
	
	public static String getTestCaseParagraphStyleName() {
		return evidencesWriter.getEvidencesContentAutomaticStyles().getTestCaseParagraphStyleName();
	}
	
	public static String getTOCParagraphIndexBodyParagraphStyleName() {
		return evidencesWriter.getEvidencesContentAutomaticStyles().getTOCParagraphIndexBodyParagraphStyleName();
	}
	
	public static String getTOCParagraphTextPParagraphStyleName() {
		return evidencesWriter.getEvidencesContentAutomaticStyles().getTOCParagraphTextPParagraphStyleName();
	}
	
	public static String getTitleParagraphStylename(){
		return evidencesWriter.getEvidencesOfficeStyles().getTitleParagraphStylename();
	}
	
	public static StyleMasterPageElement getLogoMasterPage(){
		return evidencesWriter.getEvidencesOfficeMasterStylesElement().getLogoMasterPage();
	}
	
	public static StyleMasterPageElement getTestStepMasterPage(){
		return evidencesWriter.getEvidencesOfficeMasterStylesElement().getTestStepMasterPage();
	}
	
	public static String getRevisionHistoryTableStyleName() {
		return evidencesWriter.getEvidencesContentAutomaticStyles().getRevisionHistoryTableStyleName();
	}

	public static String getCommentsTableStyleName() {
		return evidencesWriter.getEvidencesContentAutomaticStyles().getCommentsTableStyleName();
	}

	public static String getTestStepTableStyleName() {
		return evidencesWriter.getEvidencesContentAutomaticStyles().getTestStepTableStyleName();
	}
	
	private static OdfAttribute setOdfAttribute(OdfFileDom fileDom, EvidencesProperties evidencesProperty, String styleName) {
		OdfName element = evidencesProperty.getOdfName();
		String value = getProperty(styleName, element.getPrefix(), element.getLocalName());
		OdfAttribute attribute = OdfXMLFactory.newOdfAttribute(fileDom, element);
		attribute.setValue(value);
		return attribute;
	}

	public static int getLastStepCount() {
		// TODO Auto-generated method stub
		return 0;
	}
}

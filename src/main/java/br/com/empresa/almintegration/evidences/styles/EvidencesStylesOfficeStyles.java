package br.com.empresa.almintegration.evidences.styles;

import org.odftoolkit.odfdom.dom.attribute.fo.FoColorAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoFontSizeAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoKeepTogetherAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoKeepWithNextAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoMarginBottomAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoMarginTopAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleFontNameAttribute;
import org.odftoolkit.odfdom.dom.element.style.StyleParagraphPropertiesElement;
import org.odftoolkit.odfdom.dom.element.style.StyleTabStopsElement;
import org.odftoolkit.odfdom.dom.element.style.StyleTextPropertiesElement;
import org.odftoolkit.odfdom.dom.style.OdfStyleFamily;
import org.odftoolkit.odfdom.incubator.doc.office.OdfOfficeStyles;
import org.odftoolkit.odfdom.incubator.doc.style.OdfStyle;
import org.odftoolkit.odfdom.pkg.OdfFileDom;

import br.com.empresa.almintegration.evidences.Commons;
import br.com.empresa.almintegration.evidences.styles.TableOfContentsStyles.ParagraphProperties;
import br.com.empresa.almintegration.evidences.styles.TableOfContentsStyles.Properties;
import br.com.empresa.almintegration.evidences.styles.TableOfContentsStyles.TextProperties;

/**
 * @author glauco.ramalho
 * 
 * Essa classe e responsavel por criar os elementos que estão presentes no Node OdfOfficeStyles do documento styles.xml. 
 *
 */
public class EvidencesStylesOfficeStyles extends OdfOfficeStyles {

	public static enum ParagraphStyleNames {
		DEFAULT_PARAGRAPH_HEADER_STYLE, NORMAL_PARAGRAPH_HEADER_STYLE, TITLE_PARAGRAPH_HEADER_STYLE, TOC_PARAGRAPH_HEADER_STYLE
	};
	
	public static enum HyperlinkStyleNames {
		HYPERLINK
	}

	private static enum EvidencesStyleTabStopElements {
		TEST_CASE_PARAGRAPH_HEADER_STYLE_POSITION_CENTER, TEST_CASE_PARAGRAPH_HEADER_STYLE_TYPE_CENTER, TEST_CASE_PARAGRAPH_HEADER_STYLE_POSITION_RIGHT, TEST_CASE_PARAGRAPH_HEADER_STYLE_TYPE_RIGHT
	};

	public EvidencesStylesOfficeStyles(OdfFileDom ownerDoc) {
		super(ownerDoc);
		createBasicParagraphHeaderStyles(ParagraphStyleNames.NORMAL_PARAGRAPH_HEADER_STYLE.name());
		createDefaultParagraphHeaderStyles(createBasicParagraphHeaderStyles(ParagraphStyleNames.DEFAULT_PARAGRAPH_HEADER_STYLE.name()));
		createTitleParagraphHeaderStyles(createBasicParagraphHeaderStyles(ParagraphStyleNames.TITLE_PARAGRAPH_HEADER_STYLE.name()));
		createTOCParagraphHeaderStyles(createBasicParagraphHeaderStyles(ParagraphStyleNames.TOC_PARAGRAPH_HEADER_STYLE.name()));
		createHyperlinkElements();
	}

	/**
	 * 
	 * Cria o serialVersionUID para essa classe. Isso e importante por algum
	 * motivo.
	 * 
	 */
	private static final long serialVersionUID = -4524187514744011601L;
	
	private OdfStyle createBasicParagraphHeaderStyles(String styleName) {
		OdfStyle basicParagraphHeaderStyles = newStyle(styleName, OdfStyleFamily.Paragraph);
		return basicParagraphHeaderStyles;
	}

	private void createDefaultParagraphHeaderStyles(OdfStyle basicParagraphHeaderStyles) {
		createStyleTabStopElements(basicParagraphHeaderStyles.newStyleParagraphPropertiesElement());
	}
	
	private void createTitleParagraphHeaderStyles(OdfStyle basicParagraphHeaderStyles) {
		basicParagraphHeaderStyles.setStyleParentStyleNameAttribute(ParagraphStyleNames.NORMAL_PARAGRAPH_HEADER_STYLE.name());
		basicParagraphHeaderStyles.setStyleNextStyleNameAttribute(ParagraphStyleNames.NORMAL_PARAGRAPH_HEADER_STYLE.name());
		basicParagraphHeaderStyles.setStyleDefaultOutlineLevelAttribute(1);
		
		StyleParagraphPropertiesElement paragraphPropertiesElement = basicParagraphHeaderStyles.newStyleParagraphPropertiesElement();
		paragraphPropertiesElement.setFoKeepWithNextAttribute(Commons.getProperty(
				basicParagraphHeaderStyles.getStyleNameAttribute(), FoKeepWithNextAttribute.ATTRIBUTE_NAME.getPrefix(),
				FoKeepWithNextAttribute.ATTRIBUTE_NAME.getLocalName()));
		
		paragraphPropertiesElement.setFoKeepTogetherAttribute(Commons.getProperty(
				basicParagraphHeaderStyles.getStyleNameAttribute(), FoKeepTogetherAttribute.ATTRIBUTE_NAME.getPrefix(),
				FoKeepTogetherAttribute.ATTRIBUTE_NAME.getLocalName()));
		
		paragraphPropertiesElement.setFoMarginTopAttribute(Commons.getProperty(
				basicParagraphHeaderStyles.getStyleNameAttribute(), FoMarginTopAttribute.ATTRIBUTE_NAME.getPrefix(),
				FoMarginTopAttribute.ATTRIBUTE_NAME.getLocalName()));
		
		paragraphPropertiesElement.setFoMarginBottomAttribute(Commons.getProperty(
				basicParagraphHeaderStyles.getStyleNameAttribute(), FoMarginBottomAttribute.ATTRIBUTE_NAME.getPrefix(),
				FoMarginBottomAttribute.ATTRIBUTE_NAME.getLocalName()));
		
		String textDisplayValue = null;
		StyleTextPropertiesElement textPropertiesElement = basicParagraphHeaderStyles.newStyleTextPropertiesElement(textDisplayValue);
		textPropertiesElement.setStyleFontNameAttribute(Commons.getProperty(
				basicParagraphHeaderStyles.getStyleNameAttribute(), StyleFontNameAttribute.ATTRIBUTE_NAME.getPrefix(),
				StyleFontNameAttribute.ATTRIBUTE_NAME.getLocalName()));		
		textPropertiesElement.setFoColorAttribute(Commons.getProperty(
				basicParagraphHeaderStyles.getStyleNameAttribute(), FoColorAttribute.ATTRIBUTE_NAME.getPrefix(),
				FoColorAttribute.ATTRIBUTE_NAME.getLocalName()));
		textPropertiesElement.setFoFontSizeAttribute(Commons.getProperty(
				basicParagraphHeaderStyles.getStyleNameAttribute(), FoFontSizeAttribute.ATTRIBUTE_NAME.getPrefix(),
				FoFontSizeAttribute.ATTRIBUTE_NAME.getLocalName()));
		
	}
	
	private void createTOCParagraphHeaderStyles(OdfStyle basicParagraphHeaderStyles) {
		String styleName = basicParagraphHeaderStyles.getStyleNameAttribute();
		for (Properties properties : Properties.values()) {
			Commons.setAttributes(basicParagraphHeaderStyles, properties, styleName);
		}
		StyleParagraphPropertiesElement paragraphPropertiesElement = basicParagraphHeaderStyles.newStyleParagraphPropertiesElement();
		for (ParagraphProperties properties : ParagraphProperties.values()) {
			Commons.setAttributes(paragraphPropertiesElement, properties, styleName);
		}
		String textDisplayValue = "";
		StyleTextPropertiesElement textPropertiesElement = basicParagraphHeaderStyles.newStyleTextPropertiesElement(textDisplayValue);
		for (TextProperties properties : TextProperties.values()) {
			Commons.setAttributes(textPropertiesElement, properties, styleName);
		}
	}
	
	private void createHyperlinkElements(){
		String styleName = HyperlinkStyleNames.HYPERLINK.name();
		OdfStyle hyperLink = newStyle(styleName, OdfStyleFamily.Text);
		for(Hyperlink.Properties properties : Hyperlink.Properties.values()){
			Commons.setAttributes(hyperLink, properties, styleName);
		}
		String textDisplayValue = null;
		StyleTextPropertiesElement textPropertiesElement = hyperLink.newStyleTextPropertiesElement(textDisplayValue);
		for(Hyperlink.TextProperties properties : Hyperlink.TextProperties.values()){
			Commons.setAttributes(textPropertiesElement, properties, styleName);
		}		
	}

	private void createStyleTabStopElements(StyleParagraphPropertiesElement paragraphPropertiesElement) {
		StyleTabStopsElement tabStopsElement = paragraphPropertiesElement.newStyleTabStopsElement();
		tabStopsElement.newStyleTabStopElement(Commons.getProperty(EvidencesStyleTabStopElements.TEST_CASE_PARAGRAPH_HEADER_STYLE_POSITION_CENTER.name()),
				Commons.getProperty(EvidencesStyleTabStopElements.TEST_CASE_PARAGRAPH_HEADER_STYLE_TYPE_CENTER.name()));

		tabStopsElement.newStyleTabStopElement(Commons.getProperty(EvidencesStyleTabStopElements.TEST_CASE_PARAGRAPH_HEADER_STYLE_POSITION_RIGHT.name()),
				Commons.getProperty(EvidencesStyleTabStopElements.TEST_CASE_PARAGRAPH_HEADER_STYLE_TYPE_RIGHT.name()));
	}
	
	public static ParagraphStyleNames[] getParagraphStyleNames(){
		return ParagraphStyleNames.values();
	}
	
	public String getDefaultParagraphStylename(){
		return getElementStyleName(ParagraphStyleNames.DEFAULT_PARAGRAPH_HEADER_STYLE.name(), OdfStyleFamily.Paragraph);
	}
	
	public String getNormalParagraphStylename(){
		return getElementStyleName(ParagraphStyleNames.NORMAL_PARAGRAPH_HEADER_STYLE.name(), OdfStyleFamily.Paragraph);
	}

	public String getTOCParagraphStylename(){
		return getElementStyleName(ParagraphStyleNames.TOC_PARAGRAPH_HEADER_STYLE.name(), OdfStyleFamily.Paragraph);
	}
	
	public String getTitleParagraphStylename(){
		return getElementStyleName(ParagraphStyleNames.TITLE_PARAGRAPH_HEADER_STYLE.name(), OdfStyleFamily.Paragraph);
	}
	
	public String getHyperlinkStyleName(){
		return getElementStyleName(HyperlinkStyleNames.HYPERLINK.name(), OdfStyleFamily.Text);	
	}

	private String getElementStyleName(String styleName, OdfStyleFamily styleFamily){
		for (OdfStyle odfStyle : getStylesForFamily(styleFamily))
			if(odfStyle.getStyleNameAttribute().equals(styleName)) return odfStyle.getStyleNameAttribute();		
		return null;
	}
}

package br.com.empresa.almintegration.evidences.content;

import org.odftoolkit.odfdom.dom.attribute.draw.DrawAutoGrowHeightAttribute;
import org.odftoolkit.odfdom.dom.attribute.draw.DrawAutoGrowWidthAttribute;
import org.odftoolkit.odfdom.dom.attribute.draw.DrawTextareaHorizontalAlignAttribute;
import org.odftoolkit.odfdom.dom.attribute.draw.DrawTextareaVerticalAlignAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoBackgroundColorAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoBorderAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoBreakBeforeAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoColorAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoFontSizeAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoFontWeightAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoLineHeightAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoMarginBottomAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoMarginLeftAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoMarginTopAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoPaddingBottomAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoPaddingLeftAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoPaddingRightAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoPaddingTopAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoTextAlignAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoWrapOptionAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleColumnWidthAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleFontIndependentLineSpacingAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleFontNameAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleHorizontalPosAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleHorizontalRelAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleUseOptimalRowHeightAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleVerticalPosAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleVerticalRelAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleWidthAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleWrapAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleWrapContourAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleWritingModeAttribute;
import org.odftoolkit.odfdom.dom.attribute.table.TableAlignAttribute;
import org.odftoolkit.odfdom.dom.element.style.StyleGraphicPropertiesElement;
import org.odftoolkit.odfdom.dom.element.style.StyleParagraphPropertiesElement;
import org.odftoolkit.odfdom.dom.element.style.StyleStyleElement;
import org.odftoolkit.odfdom.dom.element.style.StyleTabStopElement;
import org.odftoolkit.odfdom.dom.element.style.StyleTableCellPropertiesElement;
import org.odftoolkit.odfdom.dom.element.style.StyleTableColumnPropertiesElement;
import org.odftoolkit.odfdom.dom.element.style.StyleTablePropertiesElement;
import org.odftoolkit.odfdom.dom.element.style.StyleTableRowPropertiesElement;
import org.odftoolkit.odfdom.dom.element.style.StyleTextPropertiesElement;
import org.odftoolkit.odfdom.dom.style.OdfStyleFamily;
import org.odftoolkit.odfdom.incubator.doc.office.OdfOfficeAutomaticStyles;
import org.odftoolkit.odfdom.incubator.doc.style.OdfStyle;
import org.odftoolkit.odfdom.pkg.OdfFileDom;

import br.com.empresa.almintegration.evidences.Commons;
import br.com.empresa.almintegration.evidences.EvidencesWriter;
import br.com.empresa.almintegration.evidences.content.EvidencesContentOfficeBodyElement.COMMENTS_COLUMNS_STYLES;
import br.com.empresa.almintegration.evidences.content.EvidencesContentOfficeBodyElement.COMMENTS_TABLE_CELLS_STYLES;
import br.com.empresa.almintegration.evidences.content.EvidencesContentOfficeBodyElement.COMMENTS_TABLE_ROWS_STYLES;
import br.com.empresa.almintegration.evidences.styles.MainPageLayout;
import br.com.empresa.almintegration.evidences.styles.TableOfContents;
import br.com.empresa.almintegration.evidences.styles.TableOfContents.TableOfContentTabStopProperties;
import br.com.empresa.almintegration.evidences.styles.TableOfContents.TableOfContentsParagraphProperties;

public class EvidencesContentAutomaticStyles extends OdfOfficeAutomaticStyles {

	enum TEXT_TITLE_ELEMENTS{COVER_PAGE_TITLE_TEXT_ELEMENT, COVER_PAGE_SUBTITLE_TEXT_ELEMENT};
	
	enum TABLE_STYLES {COVER_PAGE_TABLE, TEST_STEP_TABLE_STYLE, COMMONS_TABLE_STYLE, REVISION_HISTORY_TABLE_STYLE};
	
	enum COVER_PAGE_TABLE_COLUMNS_STYLES {
		COVER_PAGE_TABLE_COLUMN_A_STYLES,
		COVER_PAGE_TABLE_COLUMN_B_STYLES,
		COVER_PAGE_TABLE_COLUMN_C_STYLES
	}
	
	enum TEST_STEP_TABLE_COLUMNS_STYLES {
		TEST_STEP_TABLE_COLUMN_A_STYLE,
		TEST_STEP_TABLE_COLUMN_B_STYLE,
		TEST_STEP_TABLE_COLUMN_C_STYLE,
		TEST_STEP_TABLE_COLUMN_D_STYLE,
		TEST_STEP_TABLE_COLUMN_E_STYLE,
		TEST_STEP_TABLE_COLUMN_F_STYLE,
		TEST_STEP_TABLE_COLUMN_G_STYLE,
		TEST_STEP_TABLE_COLUMN_H_STYLE,
		TEST_STEP_TABLE_COLUMN_I_STYLE,
		TEST_STEP_TABLE_COLUMN_J_STYLE,
		TEST_STEP_TABLE_COLUMN_K_STYLE;
	}
	
	enum REVISION_HISTORY_TABLE_COLUMNS_STYLES {
		REVISION_HISTORY_TABLE_COLUMN_A_STYLE,
		REVISION_HISTORY_TABLE_COLUMN_B_STYLE,
		REVISION_HISTORY_TABLE_COLUMN_C_STYLE,
		REVISION_HISTORY_TABLE_COLUMN_D_STYLE;
	}
	
	enum REVISION_HISTORY_TEXT_STYLES{
		REVISION_HISTORY_HEADER_TEXT_STYLE;
	}
	
	enum COVER_PAGE_TABLE_ROWS_STYLES {
		COVER_PAGE_TABLE_ROW_1_STYLES,
		COVER_PAGE_TABLE_ROW_2_STYLES,
		COVER_PAGE_TABLE_ROW_3_STYLES
	}

	static enum TEST_STEP_TABLE_ROWS_STYLES {
		TEST_STEP_TABLE_ROW_1, TEST_STEP_TABLE_ROW_2, TEST_STEP_TABLE_ROW_3, TEST_STEP_TABLE_ROW_4, TEST_STEP_TABLE_ROW_5, TEST_STEP_TABLE_ROW_6, TEST_STEP_TABLE_ROW_7, TEST_STEP_TABLE_ROW_8
	};
	enum REVISION_HISTORY_TABLE_ROWS_STYLES {REVISION_HISTORY_TABLE_ROW_1_STYLES,REVISION_HISTORY_TABLE_ROW_2_STYLES};

	enum COVER_PAGE_TABLE_CELLS_STYLES {
		COMMON_CELLS_STYLES_NO_BORDERS
	}
	
	enum TEST_STEP_TABLE_CELLS_STYLES {
		COMMON_CELLS_STYLES_ALL_BORDERS,
		COMMON_CELLS_STYLES_RIGHT_TOP_BORDERS,
		COMMON_CELLS_STYLES_LEFT_TOP_BORDERS,
		COMMON_CELLS_STYLES_ONLY_TOP_BORDERS,
		COMMON_CELLS_STYLES_NO_TOP_BORDERS;
	}
	
	enum REVISION_HISTORY_TABLE_CELLS_STYLES {
		COMMON_CELLS_STYLES_ALL_BORDERS,
		COMMON_CELLS_STYLES_RIGHT_TOP_BORDERS,
		COMMON_CELLS_STYLES_LEFT_TOP_BORDERS,
		COMMON_CELLS_STYLES_RIGHT_BOTTOM_BORDERS,
		HEADER_CELLS_STYLES_ALL_BORDERS,
		HEADER_CELLS_STYLES_RIGHT_TOP_BORDERS,
		HEADER_CELLS_STYLES_LEFT_TOP_BORDERS;		
	}
	
	enum TEST_STEP_TEXT_STYLES { TEST_STEP_BOLD_TEXT, TEST_STEP_CENTER_BOLD_TEXT, TEST_STEP_DEFAULT_TEXT };
	
	enum PARAGRAPH_STYLES{DEFAULT_PARAGRAPH_STYLE, COVER_TITLE_PARAGRAPH_STYLE, LOGO_PARAGRAPH_HEADER_STYLE, TEST_CASE_PARAGRAPH_HEADER_STYLE, TOC_PARAGRAPH_INDEX_BODY_STYLE, TOC_PARAGRAPH_TEXTP_STYLE};
	
	private static final String TEST_EVIDENCES_TITLE_STYLES = "TEST_EVIDENCES_TITLE_STYLES";
	static enum COVER_PAGE_GRAPHIC_ELEMENTS{ COVER_PAGE_GRAPHIC_ELEMENT, COVER_PAGE_BOTTOM_GRAPHIC_ELEMENT };

	public EvidencesContentAutomaticStyles(OdfFileDom ownerDoc) {
		super(ownerDoc);
		createStyleGraphicProperties();
		createStyleStyleParagraphElements();
		createTextStyles();
		createCoverPageTableStyles();
		createRevisionHistoryTableStyles();
		createCommentsTableStyles();
		createTestStepTableStyles();
	}

	private void createStyleGraphicProperties() {
		for (COVER_PAGE_GRAPHIC_ELEMENTS style : COVER_PAGE_GRAPHIC_ELEMENTS.values()) {
			createCoverPageGraphicPropertiesElement(style.name());
		}
	}

	private void createCoverPageGraphicPropertiesElement(String styleName) {		
		StyleStyleElement graphicStyleElement = newStyleStyleElement(OdfStyleFamily.Graphic.getName(), styleName);
		StyleGraphicPropertiesElement graphicPropertiesElement = graphicStyleElement.newStyleGraphicPropertiesElement();
		graphicPropertiesElement.setFoWrapOptionAttribute(Commons.getProperty(styleName,
				FoWrapOptionAttribute.ATTRIBUTE_NAME.getPrefix(), FoWrapOptionAttribute.ATTRIBUTE_NAME.getLocalName()));
		graphicPropertiesElement.setFoBorderAttribute(Commons.getProperty(styleName,
				FoBorderAttribute.ATTRIBUTE_NAME.getPrefix(), FoBorderAttribute.ATTRIBUTE_NAME.getLocalName()));
		graphicPropertiesElement.setFoPaddingTopAttribute(Commons.getProperty(styleName,
				FoPaddingTopAttribute.ATTRIBUTE_NAME.getPrefix(), FoPaddingTopAttribute.ATTRIBUTE_NAME.getLocalName()));
		graphicPropertiesElement.setFoPaddingBottomAttribute(
				Commons.getProperty(styleName, FoPaddingBottomAttribute.ATTRIBUTE_NAME.getPrefix(),
						FoPaddingBottomAttribute.ATTRIBUTE_NAME.getLocalName()));
		graphicPropertiesElement.setFoPaddingLeftAttribute(
				Commons.getProperty(styleName, FoPaddingLeftAttribute.ATTRIBUTE_NAME.getPrefix(),
						FoPaddingLeftAttribute.ATTRIBUTE_NAME.getLocalName()));
		graphicPropertiesElement.setFoPaddingRightAttribute(
				Commons.getProperty(styleName, FoPaddingRightAttribute.ATTRIBUTE_NAME.getPrefix(),
						FoPaddingRightAttribute.ATTRIBUTE_NAME.getLocalName()));
		graphicPropertiesElement.setFoBackgroundColorAttribute(
				Commons.getProperty(styleName, FoBackgroundColorAttribute.ATTRIBUTE_NAME.getPrefix(),
						FoBackgroundColorAttribute.ATTRIBUTE_NAME.getLocalName()));
		graphicPropertiesElement.setDrawTextareaVerticalAlignAttribute(
				Commons.getProperty(styleName, DrawTextareaVerticalAlignAttribute.ATTRIBUTE_NAME.getPrefix(),
						DrawTextareaVerticalAlignAttribute.ATTRIBUTE_NAME.getLocalName()));
		graphicPropertiesElement.setDrawTextareaHorizontalAlignAttribute(
				Commons.getProperty(styleName, DrawTextareaHorizontalAlignAttribute.ATTRIBUTE_NAME.getPrefix(),
						DrawTextareaHorizontalAlignAttribute.ATTRIBUTE_NAME.getLocalName()));
		graphicPropertiesElement.setStyleWrapAttribute(Commons.getProperty(styleName,
				StyleWrapAttribute.ATTRIBUTE_NAME.getPrefix(), StyleWrapAttribute.ATTRIBUTE_NAME.getLocalName()));
		graphicPropertiesElement.setStyleWrapContourAttribute(Boolean
				.parseBoolean(Commons.getProperty(styleName, StyleWrapContourAttribute.ATTRIBUTE_NAME.getPrefix(),
						StyleWrapContourAttribute.ATTRIBUTE_NAME.getLocalName())));
		graphicPropertiesElement.setStyleHorizontalRelAttribute(
				Commons.getProperty(styleName, StyleHorizontalRelAttribute.ATTRIBUTE_NAME.getPrefix(),
						StyleHorizontalRelAttribute.ATTRIBUTE_NAME.getLocalName()));
		graphicPropertiesElement.setStyleVerticalRelAttribute(
				Commons.getProperty(styleName, StyleVerticalRelAttribute.ATTRIBUTE_NAME.getPrefix(),
						StyleVerticalRelAttribute.ATTRIBUTE_NAME.getLocalName()));
		graphicPropertiesElement.setStyleHorizontalPosAttribute(
				Commons.getProperty(styleName, StyleHorizontalPosAttribute.ATTRIBUTE_NAME.getPrefix(),
						StyleHorizontalPosAttribute.ATTRIBUTE_NAME.getLocalName()));
		graphicPropertiesElement.setStyleVerticalPosAttribute(
				Commons.getProperty(styleName, StyleVerticalPosAttribute.ATTRIBUTE_NAME.getPrefix(),
						StyleVerticalPosAttribute.ATTRIBUTE_NAME.getLocalName()));
		graphicPropertiesElement.setDrawAutoGrowWidthAttribute(Boolean
				.parseBoolean(Commons.getProperty(styleName, DrawAutoGrowWidthAttribute.ATTRIBUTE_NAME.getPrefix(),
						DrawAutoGrowWidthAttribute.ATTRIBUTE_NAME.getLocalName())));
		graphicPropertiesElement.setDrawAutoGrowHeightAttribute(Boolean
				.parseBoolean(Commons.getProperty(styleName, DrawAutoGrowHeightAttribute.ATTRIBUTE_NAME.getPrefix(),
						DrawAutoGrowHeightAttribute.ATTRIBUTE_NAME.getLocalName())));

		StyleParagraphPropertiesElement paragraphPropertiesElement = graphicStyleElement
				.newStyleParagraphPropertiesElement();
		paragraphPropertiesElement.setStyleFontIndependentLineSpacingAttribute(Boolean.parseBoolean(
				Commons.getProperty(styleName, StyleFontIndependentLineSpacingAttribute.ATTRIBUTE_NAME.getPrefix(),
						StyleFontIndependentLineSpacingAttribute.ATTRIBUTE_NAME.getLocalName())));
		paragraphPropertiesElement.setStyleWritingModeAttribute(
				Commons.getProperty(styleName, StyleWritingModeAttribute.ATTRIBUTE_NAME.getPrefix(),
						StyleWritingModeAttribute.ATTRIBUTE_NAME.getLocalName()));
	}
	
	public String getCoverPageGraphicElementStyleName(){
		return COVER_PAGE_GRAPHIC_ELEMENTS.COVER_PAGE_GRAPHIC_ELEMENT.name();
	}
	
	public String getCoverPageBottomGraphicElementStyleName(){
		return COVER_PAGE_GRAPHIC_ELEMENTS.COVER_PAGE_BOTTOM_GRAPHIC_ELEMENT.name();
	}

	public String getCoverPageBottomTableStyleName() {
		return TABLE_STYLES.COVER_PAGE_TABLE.name();		
	}

	public String getRevisionHistoryTableStyleName() {
		return TABLE_STYLES.REVISION_HISTORY_TABLE_STYLE.name();		
	}

	public String getCommentsTableStyleName() {
		return TABLE_STYLES.COMMONS_TABLE_STYLE.name();		
	}

	public String getTestStepTableStyleName() {
		return TABLE_STYLES.TEST_STEP_TABLE_STYLE.name();
	}

	public String getLogoParagraphStyleName() {
		return PARAGRAPH_STYLES.LOGO_PARAGRAPH_HEADER_STYLE.name();
	}
	
	public String getTestCaseParagraphStyleName() {
		return PARAGRAPH_STYLES.TEST_CASE_PARAGRAPH_HEADER_STYLE.name();
	}
	
	public String getDocumentDefaultParagraphStyle(){
		return PARAGRAPH_STYLES.DEFAULT_PARAGRAPH_STYLE.name();
	}
	
	public String getTOCParagraphIndexBodyParagraphStyleName() {
		return PARAGRAPH_STYLES.TOC_PARAGRAPH_INDEX_BODY_STYLE.name();
	}

	public String getTOCParagraphTextPParagraphStyleName() {
		return PARAGRAPH_STYLES.TOC_PARAGRAPH_TEXTP_STYLE.name();
	}
	
	private void createCoverPageTableStyles() {
		createTableStyles(TABLE_STYLES.COVER_PAGE_TABLE);
		createCoverPageTableColumnsStyles();
		createCoverPageTableRowsStyles();
		createCoverPageTableCellsStyles();
	}

	private void createCoverPageTableCellsStyles() {
		createTableCellsStyles(COVER_PAGE_TABLE_CELLS_STYLES.values());
	}

	private void createCoverPageTableRowsStyles() {
		createTableRowsStyles(COVER_PAGE_TABLE_ROWS_STYLES.values());
	}

	private void createCoverPageTableColumnsStyles() {
		createTableColumnsStyles(COVER_PAGE_TABLE_COLUMNS_STYLES.values());
	}

	private void createRevisionHistoryTableStyles() {
		createTableStyles(TABLE_STYLES.REVISION_HISTORY_TABLE_STYLE);
		createRevisionHistoryTableColumnsStyles();
		createRevisionHistoryTableRowsStyles();
		createRevisionHistoryTableCellsStyles();
	}

	private void createRevisionHistoryTableColumnsStyles() {
		createTableColumnsStyles(REVISION_HISTORY_TABLE_COLUMNS_STYLES.values());
		
	}

	private void createRevisionHistoryTableRowsStyles() {
		createTableRowsStyles(REVISION_HISTORY_TABLE_ROWS_STYLES.values());
	}

	private void createRevisionHistoryTableCellsStyles() {
		createTableCellsStyles(REVISION_HISTORY_TABLE_CELLS_STYLES.values());
	}

	private void createCommentsTableStyles() {
		createTableStyles(TABLE_STYLES.COMMONS_TABLE_STYLE);
		createCommentsTableColumnsStyles();
		createCommentsTableRowsStyles();
		createCommentsTableCellsStyles();
	}
	
	private void createStyleStyleParagraphElements() {
		for (PARAGRAPH_STYLES styles : PARAGRAPH_STYLES.values()) {
			String styleName = styles.name();
			StyleStyleElement paragraphElement = newStyleStyleElement(OdfStyleFamily.Paragraph.getName(), styleName);
			if(styles.equals(PARAGRAPH_STYLES.COVER_TITLE_PARAGRAPH_STYLE)){
				StyleParagraphPropertiesElement paragraphProperties = paragraphElement.newStyleParagraphPropertiesElement();
				paragraphProperties.setFoBreakBeforeAttribute(Commons.getProperty(styleName, FoBreakBeforeAttribute.ATTRIBUTE_NAME.getPrefix(), FoBreakBeforeAttribute.ATTRIBUTE_NAME.getLocalName()));
				paragraphProperties.setFoTextAlignAttribute(Commons.getProperty(styleName, FoTextAlignAttribute.ATTRIBUTE_NAME.getPrefix(), FoTextAlignAttribute.ATTRIBUTE_NAME.getLocalName()));
				paragraphProperties.setFoMarginTopAttribute(Commons.getProperty(styleName, FoMarginTopAttribute.ATTRIBUTE_NAME.getPrefix(), FoMarginTopAttribute.ATTRIBUTE_NAME.getLocalName()));
				paragraphProperties.setFoMarginBottomAttribute(Commons.getProperty(styleName,FoMarginBottomAttribute.ATTRIBUTE_NAME.getPrefix(), FoMarginBottomAttribute.ATTRIBUTE_NAME.getLocalName()));
				paragraphProperties.setFoLineHeightAttribute(Commons.getProperty(styleName, FoLineHeightAttribute.ATTRIBUTE_NAME.getPrefix(), FoLineHeightAttribute.ATTRIBUTE_NAME.getLocalName()));
			}
			
			if(styles.equals(PARAGRAPH_STYLES.DEFAULT_PARAGRAPH_STYLE)){
				StyleParagraphPropertiesElement paragraphProperties = paragraphElement.newStyleParagraphPropertiesElement();
				paragraphProperties.setFoTextAlignAttribute(Commons.getProperty(styleName, FoTextAlignAttribute.ATTRIBUTE_NAME.getPrefix(), FoTextAlignAttribute.ATTRIBUTE_NAME.getLocalName()));
				paragraphProperties.setFoMarginBottomAttribute(Commons.getProperty(styleName, FoMarginBottomAttribute.ATTRIBUTE_NAME.getPrefix(), FoMarginBottomAttribute.ATTRIBUTE_NAME.getLocalName()));
				paragraphProperties.setFoLineHeightAttribute(Commons.getProperty(styleName, FoLineHeightAttribute.ATTRIBUTE_NAME.getPrefix(), FoLineHeightAttribute.ATTRIBUTE_NAME.getLocalName()));
			}		
			
			if(styles.equals(PARAGRAPH_STYLES.LOGO_PARAGRAPH_HEADER_STYLE)) {
				paragraphElement.setStyleParentStyleNameAttribute(Commons.getTitleParagraphStylename());
				paragraphElement.setStyleMasterPageNameAttribute(Commons.getLogoMasterPage().getStyleNameAttribute());
				paragraphElement.newStyleParagraphPropertiesElement()
						.setFoBreakBeforeAttribute(Commons.getProperty(styles.toString(),
								FoBreakBeforeAttribute.ATTRIBUTE_NAME.getPrefix(),
								FoBreakBeforeAttribute.ATTRIBUTE_NAME.getLocalName()));
			}

			if(styles.equals(PARAGRAPH_STYLES.TEST_CASE_PARAGRAPH_HEADER_STYLE)) {
				paragraphElement.setStyleParentStyleNameAttribute(Commons.getTitleParagraphStylename());
				paragraphElement.setStyleMasterPageNameAttribute(
						Commons.getTestStepMasterPage().getStyleNameAttribute());
				paragraphElement.newStyleParagraphPropertiesElement()
				.setFoBreakBeforeAttribute(Commons.getProperty(styles.toString(),
						FoBreakBeforeAttribute.ATTRIBUTE_NAME.getPrefix(),
						FoBreakBeforeAttribute.ATTRIBUTE_NAME.getLocalName()));
			}

			if(styles.equals(PARAGRAPH_STYLES.TOC_PARAGRAPH_INDEX_BODY_STYLE)) {
				paragraphElement.setStyleParentStyleNameAttribute(EvidencesWriter.getInstance().getTOCParagraphStyleName());
				String stylePositionValue = "0";
				String styleTypeValue = "0";
				StyleTabStopElement tabStopElement = paragraphElement.newStyleParagraphPropertiesElement()
						.newStyleTabStopsElement().newStyleTabStopElement(stylePositionValue, styleTypeValue);
				tabStopElement.removeAttribute("style:type");
				styleName = PARAGRAPH_STYLES.TOC_PARAGRAPH_INDEX_BODY_STYLE.name();
				for (TableOfContentTabStopProperties properties : TableOfContents.TableOfContentTabStopProperties.values()) {
					Commons.setAttributes(tabStopElement, properties, styleName);
				}
			}

			if(styles.equals(PARAGRAPH_STYLES.TOC_PARAGRAPH_TEXTP_STYLE)) {
				styleName = EvidencesWriter.getInstance().getTOCParagraphStyleName();
				StyleParagraphPropertiesElement paragraphPropertiesElement = paragraphElement.newStyleParagraphPropertiesElement();
				for (TableOfContentsParagraphProperties properties : TableOfContentsParagraphProperties.values()) {
					Commons.setAttributes(paragraphPropertiesElement, properties, styleName);
				}
			}
		}
	}

	private void createTextStyles() {
		createCoverPageTitleTextElements();
		createRevisionHistoryHeaderTextStyle();
		createBoldTextStyle();
		createCenterBoldTextStyle();
		createDefaultTextStyle();
		createDocumentTitles();
	}

	private void createDocumentTitles() {
		StyleStyleElement testEvidencesTitleElement = newStyleStyleElement(OdfStyleFamily.Text.getName(), TEST_EVIDENCES_TITLE_STYLES);
		StyleTextPropertiesElement testEvidencesTextPropertiesElement = testEvidencesTitleElement.newStyleTextPropertiesElement("");
		testEvidencesTextPropertiesElement
				.setFoFontWeightAttribute(Commons.getProperty(TEST_EVIDENCES_TITLE_STYLES,
						FoFontWeightAttribute.ATTRIBUTE_NAME.getPrefix(),
						FoFontWeightAttribute.ATTRIBUTE_NAME.getLocalName()));
		
		testEvidencesTextPropertiesElement
		.setFoColorAttribute(Commons.getProperty(TEST_EVIDENCES_TITLE_STYLES,
				FoColorAttribute.ATTRIBUTE_NAME.getPrefix(),
				FoColorAttribute.ATTRIBUTE_NAME.getLocalName()));
		
		testEvidencesTextPropertiesElement
		.setFoFontSizeAttribute(Commons.getProperty(TEST_EVIDENCES_TITLE_STYLES,
				FoFontSizeAttribute.ATTRIBUTE_NAME.getPrefix(),
				FoFontSizeAttribute.ATTRIBUTE_NAME.getLocalName()));
	}
	
	private void createCoverPageTitleTextElements() {
		for (TEXT_TITLE_ELEMENTS textTitleElement : TEXT_TITLE_ELEMENTS.values()) {
			String styleName = textTitleElement.name();
			StyleStyleElement textElement = newStyleStyleElement(OdfStyleFamily.Text.toString(), styleName);
			String textDisplayValue = "";
			StyleTextPropertiesElement textPropertiesElement = textElement
					.newStyleTextPropertiesElement(textDisplayValue);
			textPropertiesElement.setStyleFontNameAttribute(
					Commons.getProperty(styleName, StyleFontNameAttribute.ATTRIBUTE_NAME.getPrefix(),
							StyleFontNameAttribute.ATTRIBUTE_NAME.getLocalName()));
			textPropertiesElement.setFoFontWeightAttribute(
					Commons.getProperty(styleName, FoFontWeightAttribute.ATTRIBUTE_NAME.getPrefix(),
							FoFontWeightAttribute.ATTRIBUTE_NAME.getLocalName()));
			textPropertiesElement.setFoFontSizeAttribute(Commons.getProperty(styleName,
					FoFontSizeAttribute.ATTRIBUTE_NAME.getPrefix(), FoFontSizeAttribute.ATTRIBUTE_NAME.getLocalName()));
		}
	}
	
	private void createRevisionHistoryHeaderTextStyle() {
		for (REVISION_HISTORY_TEXT_STYLES style : REVISION_HISTORY_TEXT_STYLES.values()) {
			String styleName = style.name();
			StyleStyleElement textElement = newStyleStyleElement(OdfStyleFamily.Text.toString(), styleName);
			String textDisplayValue = "";
			StyleTextPropertiesElement textPropertiesElement = textElement
					.newStyleTextPropertiesElement(textDisplayValue);
			textPropertiesElement.setStyleFontNameAttribute(
					Commons.getProperty(styleName, StyleFontNameAttribute.ATTRIBUTE_NAME.getPrefix(),
							StyleFontNameAttribute.ATTRIBUTE_NAME.getLocalName()));
			textPropertiesElement.setFoFontWeightAttribute(
					Commons.getProperty(styleName, FoFontWeightAttribute.ATTRIBUTE_NAME.getPrefix(),
							FoFontWeightAttribute.ATTRIBUTE_NAME.getLocalName()));
			textPropertiesElement.setFoFontSizeAttribute(Commons.getProperty(styleName,
					FoFontSizeAttribute.ATTRIBUTE_NAME.getPrefix(), FoFontSizeAttribute.ATTRIBUTE_NAME.getLocalName()));
			textPropertiesElement.setFoColorAttribute(Commons.getProperty(styleName,
					FoColorAttribute.ATTRIBUTE_NAME.getPrefix(), FoColorAttribute.ATTRIBUTE_NAME.getLocalName()));
		}		
	}

	private void createDefaultTextStyle() {
		StyleStyleElement defaultTextParagraphElement = newStyleStyleElement(OdfStyleFamily.Text.getName(),
				TEST_STEP_TEXT_STYLES.TEST_STEP_DEFAULT_TEXT.name());
		defaultTextParagraphElement.newStyleParagraphPropertiesElement()
				.setFoMarginBottomAttribute(Commons.getProperty(
						TEST_STEP_TEXT_STYLES.TEST_STEP_DEFAULT_TEXT.name(), FoMarginBottomAttribute.ATTRIBUTE_NAME.getPrefix(),
						FoMarginBottomAttribute.ATTRIBUTE_NAME.getLocalName()));
	}

	private void createBoldTextStyle() {
		StyleStyleElement boldTextParagraphElement = newStyleStyleElement(OdfStyleFamily.Text.getName(),
				TEST_STEP_TEXT_STYLES.TEST_STEP_BOLD_TEXT.name());

		boldTextParagraphElement.newStyleParagraphPropertiesElement()
				.setFoMarginBottomAttribute(Commons.getProperty(TEST_STEP_TEXT_STYLES.TEST_STEP_BOLD_TEXT.name(),
						FoMarginBottomAttribute.ATTRIBUTE_NAME.getPrefix(),
						FoMarginBottomAttribute.ATTRIBUTE_NAME.getLocalName()));

		boldTextParagraphElement.newStyleTextPropertiesElement("")
				.setFoFontWeightAttribute(Commons.getProperty(TEST_STEP_TEXT_STYLES.TEST_STEP_BOLD_TEXT.name(),
						FoFontWeightAttribute.ATTRIBUTE_NAME.getPrefix(),
						FoFontWeightAttribute.ATTRIBUTE_NAME.getLocalName()));
	}
	
	private void createCenterBoldTextStyle() {
		StyleStyleElement boldTextParagraphElement = newStyleStyleElement(OdfStyleFamily.Text.getName(),
				TEST_STEP_TEXT_STYLES.TEST_STEP_CENTER_BOLD_TEXT.name());

		StyleParagraphPropertiesElement paragraphPropertiesElement = boldTextParagraphElement.newStyleParagraphPropertiesElement();
		paragraphPropertiesElement.setFoMarginBottomAttribute(Commons.getProperty(TEST_STEP_TEXT_STYLES.TEST_STEP_CENTER_BOLD_TEXT.name(),
						FoMarginBottomAttribute.ATTRIBUTE_NAME.getPrefix(),
						FoMarginBottomAttribute.ATTRIBUTE_NAME.getLocalName()));
		paragraphPropertiesElement.setFoTextAlignAttribute(Commons.getProperty(TEST_STEP_TEXT_STYLES.TEST_STEP_CENTER_BOLD_TEXT.name(),
				FoTextAlignAttribute.ATTRIBUTE_NAME.getPrefix(),
				FoTextAlignAttribute.ATTRIBUTE_NAME.getLocalName()));

		boldTextParagraphElement.newStyleTextPropertiesElement("")
				.setFoFontWeightAttribute(Commons.getProperty(TEST_STEP_TEXT_STYLES.TEST_STEP_CENTER_BOLD_TEXT.name(),
						FoFontWeightAttribute.ATTRIBUTE_NAME.getPrefix(),
						FoFontWeightAttribute.ATTRIBUTE_NAME.getLocalName()));
	}
	
	private void createTestStepTableStyles() {
		createTableStyles(TABLE_STYLES.TEST_STEP_TABLE_STYLE);
		createTestStepTableColumnsStyles();
		createTestStepTableRowsStyles();
		createTestStepTableCellsStyles();
	}

	private void createCommentsTableColumnsStyles() {
		createTableColumnsStyles(COMMENTS_COLUMNS_STYLES.values());
	}

	private void createCommentsTableRowsStyles() {
		createTableRowsStyles(COMMENTS_TABLE_ROWS_STYLES.values());
	}

	private void createCommentsTableCellsStyles() {
		createTableCellsStyles(COMMENTS_TABLE_CELLS_STYLES.values());		
	}
	
	private void createTestStepTableColumnsStyles() {
		createTableColumnsStyles(TEST_STEP_TABLE_COLUMNS_STYLES.values());
	}

	private void createTestStepTableRowsStyles() {
		createTableRowsStyles(TEST_STEP_TABLE_ROWS_STYLES.values());
	}
	
	private void createTestStepTableCellsStyles() {
		createTableCellsStyles(TEST_STEP_TABLE_CELLS_STYLES.values());
	}

	private void createTableStyles(TABLE_STYLES commonsTableStyle) {

		StyleStyleElement tableStyle = newStyleStyleElement(OdfStyleFamily.Table.getName(), commonsTableStyle.name());
		StyleTablePropertiesElement tablePropertiesElement = tableStyle.newStyleTablePropertiesElement();

		tablePropertiesElement.setStyleWidthAttribute(Commons.getProperty(commonsTableStyle.name(),
				StyleWidthAttribute.ATTRIBUTE_NAME.getPrefix(), StyleWidthAttribute.ATTRIBUTE_NAME.getLocalName()));

		tablePropertiesElement.setFoMarginLeftAttribute(Commons.getProperty(commonsTableStyle.name(),
				FoMarginLeftAttribute.ATTRIBUTE_NAME.getPrefix(), FoMarginLeftAttribute.ATTRIBUTE_NAME.getLocalName()));

		tablePropertiesElement.setTableAlignAttribute(Commons.getProperty(commonsTableStyle.name(),
				TableAlignAttribute.ATTRIBUTE_NAME.getPrefix(), TableAlignAttribute.ATTRIBUTE_NAME.getLocalName()));
		
		if (commonsTableStyle.equals(TABLE_STYLES.COVER_PAGE_TABLE))
			tablePropertiesElement.setFoMarginTopAttribute(
					Commons.getProperty(commonsTableStyle.name(), FoMarginTopAttribute.ATTRIBUTE_NAME.getPrefix(),
							FoMarginTopAttribute.ATTRIBUTE_NAME.getLocalName()));
	}

	private void createTableColumnsStyles(Object[] COLUMNS) {
		for (int i = 0; i < COLUMNS.length; i++)
			newTableColumnStyleStyleElement(COLUMNS[i].toString());
	}

	private void createTableRowsStyles(Object[] ROWS) {
		for (int i = 0; i < ROWS.length; i++)
			newTableRowStyleStyleElement(ROWS[i].toString());
	}

	private void createTableCellsStyles(Object[] CELLS) {
		for (int i = 0; i < CELLS.length; i++)
			newTableCellStyleStyleElement(CELLS[i].toString());
	}

	private StyleStyleElement newTableCellStyleStyleElement(String styleName) {
		StyleStyleElement tableCellStyle = newStyleStyleElement(OdfStyleFamily.TableCell.getName(), styleName);
		StyleTableCellPropertiesElement tableCellPropertiesElement = tableCellStyle
				.newStyleTableCellPropertiesElement();
		for (MainPageLayout.TableCellPropertiesElement property : MainPageLayout.getTableCellPropertiesElement()) {
			Commons.setAttributes(tableCellPropertiesElement, property, styleName);
		}
		return tableCellStyle;
	}

	private StyleStyleElement newTableColumnStyleStyleElement(String styleName) {
		StyleStyleElement tableColumnStyle = newStyleStyleElement(OdfStyleFamily.TableColumn.getName(), styleName);
		StyleTableColumnPropertiesElement tableColumnAPropertiesElement = tableColumnStyle
				.newStyleTableColumnPropertiesElement();
		tableColumnAPropertiesElement.setStyleColumnWidthAttribute(Commons.getProperty(styleName, StyleColumnWidthAttribute.ATTRIBUTE_NAME.getPrefix(),
						StyleColumnWidthAttribute.ATTRIBUTE_NAME.getLocalName()));
		return tableColumnStyle;
	}
	
	private StyleStyleElement newTableRowStyleStyleElement(String styleName) {
		StyleStyleElement tableRowStyle = newStyleStyleElement(OdfStyleFamily.TableRow.getName(), styleName);
		StyleTableRowPropertiesElement tableRowPropertiesElement = tableRowStyle.newStyleTableRowPropertiesElement();
		tableRowPropertiesElement.setStyleUseOptimalRowHeightAttribute(Boolean.parseBoolean(Commons.getProperty(styleName, StyleUseOptimalRowHeightAttribute.ATTRIBUTE_NAME.getPrefix(),
						StyleUseOptimalRowHeightAttribute.ATTRIBUTE_NAME.getLocalName())));
		return tableRowStyle;
	}
	
	public String getCoverPageTitleTextStyleName(){
		String styleName = null;
		for (OdfStyle odfStyle : getStylesForFamily(OdfStyleFamily.Text)) {
			styleName = odfStyle.getStyleNameAttribute();
			if(styleName.equals(TEXT_TITLE_ELEMENTS.COVER_PAGE_TITLE_TEXT_ELEMENT.name())) return styleName;
		}
		return styleName;
	}
	
	public String getCoverPageSubTitleTextStyleName(){
		String styleName = null;
		for (OdfStyle odfStyle : getStylesForFamily(OdfStyleFamily.Text)) {
			styleName = odfStyle.getStyleNameAttribute();
			if(styleName.equals(TEXT_TITLE_ELEMENTS.COVER_PAGE_SUBTITLE_TEXT_ELEMENT.name())) return styleName;
		}
		return styleName;
	}

	public String getTestEvidencesTitleElement() {
		for (OdfStyle titleStyleElement : getStylesForFamily(OdfStyleFamily.Text)) {
			if(titleStyleElement.getStyleNameAttribute().equals(TEST_EVIDENCES_TITLE_STYLES)) return titleStyleElement.getStyleNameAttribute();
		}
		return null;
	}
	
	public String getCoverTitleParagraphStyle(){
		for (OdfStyle style : getStylesForFamily(OdfStyleFamily.Paragraph)) {
			if (style.getStyleNameAttribute().equals(PARAGRAPH_STYLES.COVER_TITLE_PARAGRAPH_STYLE.name())) return style.getStyleNameAttribute();
		}
		return null;		
	}
	
	public String getLogoParagraph() {
		for (OdfStyle style : getStylesForFamily(OdfStyleFamily.Paragraph)) {
			if (style.getStyleNameAttribute().equals(PARAGRAPH_STYLES.LOGO_PARAGRAPH_HEADER_STYLE.name())) return style.getStyleNameAttribute();
		}
		return null;		
	}
	
	public String getTestStepParagraph() {
		for (OdfStyle style : getStylesForFamily(OdfStyleFamily.Paragraph)) {
			if (style.getStyleNameAttribute().equals(PARAGRAPH_STYLES.TEST_CASE_PARAGRAPH_HEADER_STYLE.name())) return style.getStyleNameAttribute();
		}
		return null;		
	}

	public String getTOCParagraphIndexBodyStyleName(){
		return getElementStyleName(OdfStyleFamily.Paragraph, PARAGRAPH_STYLES.TOC_PARAGRAPH_INDEX_BODY_STYLE.name());
	}
	
	public String getTOCParagraphTextPStyleName(){
		return getElementStyleName(OdfStyleFamily.Paragraph, PARAGRAPH_STYLES.TOC_PARAGRAPH_TEXTP_STYLE.name());
	}
	
	private String getElementStyleName(OdfStyleFamily family, String styleName){
		for (OdfStyle style : getStylesForFamily(family)) {
			if (style.getStyleNameAttribute().equals(styleName)) return style.getStyleNameAttribute();
		}
		return null;
	}
	public static REVISION_HISTORY_TABLE_COLUMNS_STYLES[] getRevisionHistoryTableColumnsStyles(){
		return REVISION_HISTORY_TABLE_COLUMNS_STYLES.values();
	}

	public static REVISION_HISTORY_TABLE_ROWS_STYLES[] getRevisionHistoryTableRowsStyles(){
		return REVISION_HISTORY_TABLE_ROWS_STYLES.values();
	}

	public static REVISION_HISTORY_TABLE_CELLS_STYLES[] getRevisionHistoryTableCellsStyles(){
		return REVISION_HISTORY_TABLE_CELLS_STYLES.values();
	}
	
	public static REVISION_HISTORY_TABLE_ROWS_STYLES getRevisionHistoryTableRow1Styles() {
		return REVISION_HISTORY_TABLE_ROWS_STYLES.REVISION_HISTORY_TABLE_ROW_1_STYLES;
	}

	public static REVISION_HISTORY_TABLE_ROWS_STYLES getRevisionHistoryTableRow2Styles() {
		return REVISION_HISTORY_TABLE_ROWS_STYLES.REVISION_HISTORY_TABLE_ROW_2_STYLES;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -40078627155043811L;

	

}

package br.com.empresa.almintegration.evidences.styles;

import org.odftoolkit.odfdom.dom.attribute.fo.FoFontWeightAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleColumnWidthAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleFontNameAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleMinRowHeightAttribute;
import org.odftoolkit.odfdom.dom.element.style.StyleFooterStyleElement;
import org.odftoolkit.odfdom.dom.element.style.StyleFootnoteSepElement;
import org.odftoolkit.odfdom.dom.element.style.StyleHeaderFooterPropertiesElement;
import org.odftoolkit.odfdom.dom.element.style.StyleHeaderStyleElement;
import org.odftoolkit.odfdom.dom.element.style.StylePageLayoutElement;
import org.odftoolkit.odfdom.dom.element.style.StylePageLayoutPropertiesElement;
import org.odftoolkit.odfdom.dom.element.style.StyleStyleElement;
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

public class EvidencesStylesOfficeAutomaticStyles extends OdfOfficeAutomaticStyles {
	private StylePageLayoutElement mainPageLayoutStyles;

	public static final String MAIN_PAGE_LAYOUT_ELEMENT_NAME = "MAIN_PAGE_LAYOUT_ELEMENT";

	static enum PARAGRAPH_FONT_STYLES {DEFAULT_PARAGRAPH_FONT_STYLE, BOLD_PARAGRAPH_FONT_STYLE};

	enum TABLE_STYLES implements EvidencesStyles{
		TEST_CASE_TABLE_STYLE, LOGO_TABLE_STYLE
	}

	enum TEST_CASE_COLUMNS_STYLES implements EvidencesStyles{
		TEST_CASE_COLUMN_A_STYLE, TEST_CASE_COLUMN_B_STYLE, TEST_CASE_COLUMN_C_STYLE, TEST_CASE_COLUMN_D_STYLE, TEST_CASE_COLUMN_E_STYLE, TEST_CASE_COLUMN_F_STYLE
	};

	enum TEST_CASE_ROW_STYLES implements EvidencesStyles{
		TEST_CASE_ROW_1_STYLE, TEST_CASE_ROW_2_STYLE, TEST_CASE_ROW_3_STYLE
	}

	enum TEST_CASE_CELLS_STYLES implements EvidencesStyles{
		TEST_CASE_CELL_UC_LABEL_STYLE, TEST_CASE_CELL_UC_VALUE_STYLE, TEST_CASE_CELL_TC_LABEL_STYLE, TEST_CASE_CELL_TC_VALUE_STYLE, TEST_CASE_CELL_DATE_LABEL_STYLE, TEST_CASE_CELL_DATE_VALUE_STYLE, TEST_CASE_CELL_TIME_LABEL_STYLE, TEST_CASE_CELL_TIME_VALUE_STYLE
	};

	enum LOGO_COLUMN_STYLES implements EvidencesStyles{
		LOGO_COLUMN_A_STYLE, LOGO_COLUMN_B_STYLE
	};

	enum LOGO_TABLE_CELLS_STYLES implements EvidencesStyles{
		LOGO_CELL_STYLE, SECOND_CELL_STYLE
	};

	enum LOGO_ROW_STYLES implements EvidencesStyles{
		LOGO_ROW_1_STYLE, LOGO_ROW_2_STYLE, LOGO_ROW_3_STYLE
	};

	public EvidencesStylesOfficeAutomaticStyles(OdfFileDom ownerDoc) {
		super(ownerDoc);
		setMainPageLayoutStyles(createMainPageLayoutStyles());
		createPageParagraphTextStyles();
		createLogoTableStyles();
		createTestCaseTableStyles();
	}

	private void setMainPageLayoutStyles(StylePageLayoutElement mainPageLayoutStyles) {
		this.mainPageLayoutStyles = mainPageLayoutStyles;
	}
	
	private void createPageParagraphTextStyles() {
		createDefaultParagraphTextElement();
		createBoldParagraphTextElement();
	}

	private StylePageLayoutElement createMainPageLayoutStyles() {
		StylePageLayoutElement pageLayoutElement = newStylePageLayoutElement(MAIN_PAGE_LAYOUT_ELEMENT_NAME);
		StylePageLayoutPropertiesElement layoutPropertiesElement = createStylePageLayoutElement(pageLayoutElement);

		createStyleFootnoteSepElement(layoutPropertiesElement, pageLayoutElement);
		createStyleHeaderStyleElement(pageLayoutElement);
		createStyleFooterStyleElement(pageLayoutElement);

		return pageLayoutElement;
	}

	private StylePageLayoutPropertiesElement createStylePageLayoutElement(StylePageLayoutElement pageLayoutElement) {
		StylePageLayoutPropertiesElement layoutPropertiesElement = pageLayoutElement
				.newStylePageLayoutPropertiesElement("");
		String parentStyleName = pageLayoutElement.getStyleNameAttribute();
		for (MainPageLayout.Properties property : MainPageLayout.Properties.values()) {
			Commons.setAttributes(layoutPropertiesElement, property, parentStyleName);
		}
		return layoutPropertiesElement;
	}

	private void createStyleFooterStyleElement(StylePageLayoutElement pageLayoutElement) {
		StyleFooterStyleElement footerStyleElement = pageLayoutElement.newStyleFooterStyleElement();
		StyleHeaderFooterPropertiesElement headerFooterPropertiesElement = footerStyleElement
				.newStyleHeaderFooterPropertiesElement();
		String parentStyleName = pageLayoutElement.getStyleNameAttribute() + "_"
				+ footerStyleElement.getLocalName().toUpperCase();
		for (MainPageLayout.HeaderFooterPropertiesElement property : MainPageLayout.HeaderFooterPropertiesElement
				.values()) {
			Commons.setAttributes(headerFooterPropertiesElement, property, parentStyleName);
		}
	}

	private void createStyleHeaderStyleElement(StylePageLayoutElement pageLayoutElement) {
		StyleHeaderStyleElement headerStyleElement = pageLayoutElement.newStyleHeaderStyleElement();
		StyleHeaderFooterPropertiesElement headerFooterPropertiesElement = headerStyleElement
				.newStyleHeaderFooterPropertiesElement();
		String parentStyleName = pageLayoutElement.getStyleNameAttribute() + "_"
				+ headerStyleElement.getLocalName().toUpperCase();
		for (MainPageLayout.HeaderFooterPropertiesElement property : MainPageLayout.HeaderFooterPropertiesElement
				.values()) {
			Commons.setAttributes(headerFooterPropertiesElement, property, parentStyleName);
		}
	}

	private void createStyleFootnoteSepElement(StylePageLayoutPropertiesElement layoutPropertiesElement,
			StylePageLayoutElement pageLayoutElement) {
		StyleFootnoteSepElement footnoteSepElement = layoutPropertiesElement.newStyleFootnoteSepElement();
		String parentStyleName = pageLayoutElement.getStyleNameAttribute();
		for (MainPageLayout.FootnoteSepElement property : MainPageLayout.FootnoteSepElement.values()) {
			Commons.setAttributes(footnoteSepElement, property, parentStyleName);
		}
	}

	private StyleStyleElement createDefaultParagraphTextElement() {		
		return createBasicParagraphElement(PARAGRAPH_FONT_STYLES.DEFAULT_PARAGRAPH_FONT_STYLE.name());
	}

	private void createBoldParagraphTextElement() {
		StyleStyleElement boldParagraphTextElement = createBasicParagraphElement(PARAGRAPH_FONT_STYLES.BOLD_PARAGRAPH_FONT_STYLE.name());
		boldParagraphTextElement.setStyleParentStyleNameAttribute(boldParagraphTextElement.getStyleNameAttribute());
		StyleTextPropertiesElement textPropertiesElement = (StyleTextPropertiesElement) boldParagraphTextElement.getChildNodes().item(0);
		textPropertiesElement.setFoFontWeightAttribute(Commons.getProperty(
				boldParagraphTextElement.getStyleNameAttribute(), FoFontWeightAttribute.ATTRIBUTE_NAME.getPrefix(),
				FoFontWeightAttribute.ATTRIBUTE_NAME.getLocalName()));
	}
	
	private StyleStyleElement createBasicParagraphElement(String styleName){
		StyleStyleElement basicParagraphTextElement = newStyleStyleElement(OdfStyleFamily.Paragraph.getName(),styleName);
		StyleTextPropertiesElement textPropertiesElement = basicParagraphTextElement
				.newStyleTextPropertiesElement("");
		textPropertiesElement.setStyleFontNameAttribute(
				Commons.getProperty(styleName, StyleFontNameAttribute.ATTRIBUTE_NAME.getPrefix(),
						StyleFontNameAttribute.ATTRIBUTE_NAME.getLocalName()));
		return basicParagraphTextElement;
	}

	private void createLogoTableStyles() {
		createTableStyles(TABLE_STYLES.LOGO_TABLE_STYLE.name());
		createLogoTableColumnsStyles();
		createLogoTableRowsStyles();
		createLogoTableCellsStyles();
	}

	private void createTestCaseTableStyles() {
		createTableStyles(TABLE_STYLES.TEST_CASE_TABLE_STYLE.name());
		createTestCaseTableColumnsStyles();
		createTestCaseTableRowsStyles();
		createTestCaseTableCellsStyles();
	}

	private void createLogoTableColumnsStyles() {
		createTableColumnsStyles(LOGO_COLUMN_STYLES.values());
	}

	private void createLogoTableRowsStyles() {
		createTableRowsStyles(LOGO_ROW_STYLES.values());
	}

	private void createLogoTableCellsStyles() {
		createTableCellsStyles(LOGO_TABLE_CELLS_STYLES.values());
	}

	private void createTestCaseTableColumnsStyles() {
		createTableColumnsStyles(TEST_CASE_COLUMNS_STYLES.values());
	}

	private void createTestCaseTableRowsStyles() {
		createTableRowsStyles(TEST_CASE_ROW_STYLES.values());
	}

	private void createTestCaseTableCellsStyles() {
		createTableCellsStyles(TEST_CASE_CELLS_STYLES.values());
	}

	private void createTableStyles(String styleName) {

		StyleStyleElement tableStyle = newStyleStyleElement(OdfStyleFamily.Table.getName(), styleName);
		StyleTablePropertiesElement tablePropertiesElement = tableStyle.newStyleTablePropertiesElement();
		for (MainPageLayout.TablePropertiesElement property : MainPageLayout.TablePropertiesElement.values()) {
			Commons.setAttributes(tablePropertiesElement, property, styleName);
		}
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

	private void newTableCellStyleStyleElement(String styleName) {

		StyleStyleElement tableCellStyle = newStyleStyleElement(OdfStyleFamily.TableCell.getName(), styleName);
		StyleTableCellPropertiesElement tableCellPropertiesElement = tableCellStyle
				.newStyleTableCellPropertiesElement();
		for (MainPageLayout.TableCellPropertiesElement property : MainPageLayout.TableCellPropertiesElement.values()) {
			Commons.setAttributes(tableCellPropertiesElement, property, styleName);
		}
	}

	private void newTableColumnStyleStyleElement(String styleName) {
		StyleStyleElement tableColumnStyle = newStyleStyleElement(OdfStyleFamily.TableColumn.getName(), styleName);
		StyleTableColumnPropertiesElement tableColumnAPropertiesElement = tableColumnStyle
				.newStyleTableColumnPropertiesElement();
		tableColumnAPropertiesElement.setStyleColumnWidthAttribute(
				Commons.getProperty(styleName, StyleColumnWidthAttribute.ATTRIBUTE_NAME.getPrefix(),
						StyleColumnWidthAttribute.ATTRIBUTE_NAME.getLocalName()));
	}

	private void newTableRowStyleStyleElement(String styleName) {
		StyleStyleElement tableRowStyle = newStyleStyleElement(OdfStyleFamily.TableRow.getName(), styleName);
		StyleTableRowPropertiesElement tableRowPropertiesElement = tableRowStyle.newStyleTableRowPropertiesElement();
		tableRowPropertiesElement.setStyleMinRowHeightAttribute(
				Commons.getProperty(styleName, StyleMinRowHeightAttribute.ATTRIBUTE_NAME.getPrefix(),
						StyleMinRowHeightAttribute.ATTRIBUTE_NAME.getLocalName()));
	}

	public StylePageLayoutElement getMainPageLayoutStyles() {
		return mainPageLayoutStyles;
	}
	
	public String getDefaultParagraphFontStyle(){
		return getParagraphFontStyle(PARAGRAPH_FONT_STYLES.DEFAULT_PARAGRAPH_FONT_STYLE.name());
	}
	
	public String getBoldParagraphFontStyle(){
		return getParagraphFontStyle(PARAGRAPH_FONT_STYLES.BOLD_PARAGRAPH_FONT_STYLE.name());
	}
	
	private String getParagraphFontStyle(String paragraphType){
		for (OdfStyle odfStyle : getStylesForFamily(OdfStyleFamily.Paragraph)) {
			if(odfStyle.getStyleNameAttribute().equals(PARAGRAPH_FONT_STYLES.DEFAULT_PARAGRAPH_FONT_STYLE.name())) return odfStyle.getStyleNameAttribute();
		}
		return null;
	}
	
	public String getTestCaseColumnAStyleName(){
		return getStylesOfficeAutomaticStyle(OdfStyleFamily.TableColumn, TEST_CASE_COLUMNS_STYLES.TEST_CASE_COLUMN_A_STYLE);
	}
	
	public String getTestCaseColumnBStyleName(){
		return getStylesOfficeAutomaticStyle(OdfStyleFamily.TableColumn, TEST_CASE_COLUMNS_STYLES.TEST_CASE_COLUMN_B_STYLE);
	}
	
	public String getTestCaseColumnCStyleName(){
		return getStylesOfficeAutomaticStyle(OdfStyleFamily.TableColumn, TEST_CASE_COLUMNS_STYLES.TEST_CASE_COLUMN_C_STYLE);
	}
	
	public String getTestCaseColumnDStyleName(){
		return getStylesOfficeAutomaticStyle(OdfStyleFamily.TableColumn, TEST_CASE_COLUMNS_STYLES.TEST_CASE_COLUMN_D_STYLE);
	}
	
	public String getTestCaseColumnEStyleName(){
		return getStylesOfficeAutomaticStyle(OdfStyleFamily.TableColumn, TEST_CASE_COLUMNS_STYLES.TEST_CASE_COLUMN_E_STYLE);
	}
	
	public String getTestCaseColumnFStyleName(){
		return getStylesOfficeAutomaticStyle(OdfStyleFamily.TableColumn, TEST_CASE_COLUMNS_STYLES.TEST_CASE_COLUMN_F_STYLE);
	}
	
	public String getTestCaseRow1StyleName(){
		return getStylesOfficeAutomaticStyle(OdfStyleFamily.TableRow, TEST_CASE_ROW_STYLES.TEST_CASE_ROW_1_STYLE);
	}
	
	public String getTestCaseRow2StyleName(){
		return getStylesOfficeAutomaticStyle(OdfStyleFamily.TableRow, TEST_CASE_ROW_STYLES.TEST_CASE_ROW_2_STYLE);
	}
	
	public String getTestCaseRow3StyleName(){
		return getStylesOfficeAutomaticStyle(OdfStyleFamily.TableRow, TEST_CASE_ROW_STYLES.TEST_CASE_ROW_3_STYLE);
	}
	
	public String getUCLabelStyleName(){
		return getStylesOfficeAutomaticStyle(OdfStyleFamily.TableCell, TEST_CASE_CELLS_STYLES.TEST_CASE_CELL_UC_LABEL_STYLE);
	}
	public String getUCValueStyleName(){
		return getStylesOfficeAutomaticStyle(OdfStyleFamily.TableCell, TEST_CASE_CELLS_STYLES.TEST_CASE_CELL_UC_VALUE_STYLE);
	}
	public String getTCLabelStyleName(){
		return getStylesOfficeAutomaticStyle(OdfStyleFamily.TableCell, TEST_CASE_CELLS_STYLES.TEST_CASE_CELL_TC_LABEL_STYLE);
	}
	public String getTCValueStyleName(){
		return getStylesOfficeAutomaticStyle(OdfStyleFamily.TableCell, TEST_CASE_CELLS_STYLES.TEST_CASE_CELL_TC_VALUE_STYLE);
	}
	public String getDateLabelStyleName(){
		return getStylesOfficeAutomaticStyle(OdfStyleFamily.TableCell, TEST_CASE_CELLS_STYLES.TEST_CASE_CELL_DATE_LABEL_STYLE);
	}
	public String getDateValueStyleName(){
		return getStylesOfficeAutomaticStyle(OdfStyleFamily.TableCell, TEST_CASE_CELLS_STYLES.TEST_CASE_CELL_DATE_VALUE_STYLE);
	}
	public String getTimeLabelStyleName(){
		return getStylesOfficeAutomaticStyle(OdfStyleFamily.TableCell, TEST_CASE_CELLS_STYLES.TEST_CASE_CELL_TIME_LABEL_STYLE);
	}
	public String getTimeValueStyleName(){
		return getStylesOfficeAutomaticStyle(OdfStyleFamily.TableCell, TEST_CASE_CELLS_STYLES.TEST_CASE_CELL_TIME_VALUE_STYLE);
	}
	
	public String getLogoColumnAStyleName(){
		return getStylesOfficeAutomaticStyle(OdfStyleFamily.TableColumn, LOGO_COLUMN_STYLES.LOGO_COLUMN_A_STYLE);
	}
	
	public String getLogoColumnBStyleName(){
		return getStylesOfficeAutomaticStyle(OdfStyleFamily.TableColumn, LOGO_COLUMN_STYLES.LOGO_COLUMN_B_STYLE);
	}
	
	public String getLogoRow1StyleName(){
		return getStylesOfficeAutomaticStyle(OdfStyleFamily.TableRow, LOGO_ROW_STYLES.LOGO_ROW_1_STYLE);
	}
	
	public String getLogoRow2StyleName(){
		return getStylesOfficeAutomaticStyle(OdfStyleFamily.TableRow, LOGO_ROW_STYLES.LOGO_ROW_2_STYLE);
	}
	
	public String getLogoRow3StyleName(){
		return getStylesOfficeAutomaticStyle(OdfStyleFamily.TableRow, LOGO_ROW_STYLES.LOGO_ROW_3_STYLE);
	}
	
	public String getLogoCellStyleName(){
		return getStylesOfficeAutomaticStyle(OdfStyleFamily.TableCell, LOGO_TABLE_CELLS_STYLES.LOGO_CELL_STYLE);
	}
	
	public String getLogoSecondCellStyleName(){
		return getStylesOfficeAutomaticStyle(OdfStyleFamily.TableCell, LOGO_TABLE_CELLS_STYLES.SECOND_CELL_STYLE);
	}
	
	private String getStylesOfficeAutomaticStyle(OdfStyleFamily styleFamily, EvidencesStyles style){
		for (OdfStyle odfStyle : getStylesForFamily(styleFamily)) {
			if(odfStyle.getStyleNameAttribute().equals(style.toString())) return odfStyle.getStyleNameAttribute();
		}
		return null;
	}	

	/**
	 * 
	 */
	private static final long serialVersionUID = 984707267015641392L;

}

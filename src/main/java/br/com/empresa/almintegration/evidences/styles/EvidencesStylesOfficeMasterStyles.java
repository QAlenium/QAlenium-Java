package br.com.empresa.almintegration.evidences.styles;

import org.odftoolkit.odfdom.dom.attribute.table.TableNumberColumnsSpannedAttribute;
import org.odftoolkit.odfdom.dom.element.draw.DrawFrameElement;
import org.odftoolkit.odfdom.dom.element.draw.DrawImageElement;
import org.odftoolkit.odfdom.dom.element.style.StyleHeaderElement;
import org.odftoolkit.odfdom.dom.element.style.StyleMasterPageElement;
import org.odftoolkit.odfdom.dom.element.table.TableCoveredTableCellElement;
import org.odftoolkit.odfdom.dom.element.table.TableTableCellElement;
import org.odftoolkit.odfdom.dom.element.table.TableTableCellElementBase;
import org.odftoolkit.odfdom.dom.element.table.TableTableColumnsElement;
import org.odftoolkit.odfdom.dom.element.table.TableTableElement;
import org.odftoolkit.odfdom.dom.element.table.TableTableRowElement;
import org.odftoolkit.odfdom.dom.element.text.TextPElement;
import org.odftoolkit.odfdom.incubator.doc.office.OdfOfficeMasterStyles;
import org.odftoolkit.odfdom.pkg.OdfFileDom;
import org.odftoolkit.odfdom.pkg.OdfName;
import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.Table;

import br.com.empresa.almintegration.evidences.Commons;
import br.com.empresa.almintegration.evidences.EvidencesWriter;
import br.com.empresa.almintegration.evidences.styles.EvidencesStylesOfficeAutomaticStyles.TEST_CASE_COLUMNS_STYLES;

public class EvidencesStylesOfficeMasterStyles extends OdfOfficeMasterStyles {
	public static enum MASTER_PAGES {LOGO_MASTER_PAGE_ELEMENT, TEST_STEP_MASTER_PAGE_ELEMENT};

	private static enum LABELS implements EvidencesStyles{
		UC_LABEL_NODE_VALUE("UC: "),
		TC_LABEL_NODE_VALUE("TC: "),
		DATE_LABEL_NODE_VALUE("Date: "),
		TIME_LABEL_NODE_VALUE("Time: ");
		private String label;
		LABELS(String label){
			this.label = label;
		}

		public String getLabel(){
			return label;
		}
	}
	TableTableElement testCaseTableElement;
	EvidencesWriter evidencesWriter;
	
	public EvidencesStylesOfficeMasterStyles(OdfFileDom ownerDoc) {
		super(ownerDoc);
		evidencesWriter = EvidencesWriter.getInstance();
		createMasterPageStyles();
	}

	public StyleMasterPageElement getLogoMasterPage() {
		return getMasterPage(MASTER_PAGES.LOGO_MASTER_PAGE_ELEMENT.name());
	}

	public StyleMasterPageElement getTestStepMasterPage() {
		return getMasterPage(MASTER_PAGES.TEST_STEP_MASTER_PAGE_ELEMENT.name());
	}

	private void createMasterPageStyles() {
		createLogoMasterPageStyle();
		createTestStepMasterPageStyle();
	}

	private void createLogoMasterPageStyle() {

		StyleMasterPageElement masterPageElement = newStyleMasterPageElement(MASTER_PAGES.LOGO_MASTER_PAGE_ELEMENT.name(),
				evidencesWriter.getMainPageLayoutStyles().getStyleNameAttribute());
		TableTableElement logoTableElement = masterPageElement.newStyleHeaderElement().newTableTableElement();
		logoTableElement.setTableNameAttribute(MASTER_PAGES.LOGO_MASTER_PAGE_ELEMENT.name());

		TableTableColumnsElement tableColumnsElement = logoTableElement.newTableTableColumnsElement();
		tableColumnsElement.newTableTableColumnElement().setStyleName(Commons.getLogoColumnAStyleName());
		tableColumnsElement.newTableTableColumnElement().setStyleName(Commons.getLogoColumnAStyleName());

		TableTableRowElement row1Element = logoTableElement.newTableTableRowElement();
		row1Element.setStyleName(Commons.getLogoRow1StyleName());

		TableTableCellElement logoCellElement = (TableTableCellElement) newTableTableCellElementBase(row1Element,
				TableTableCellElement.ELEMENT_NAME);
		logoCellElement.setStyleName(Commons.getLogoCellStyleName());

		newDrawFrameElement(logoCellElement, MASTER_PAGES.LOGO_MASTER_PAGE_ELEMENT.name());

		newTableTableCellElementBase(row1Element, TableTableCellElement.ELEMENT_NAME);

	}

	private StyleMasterPageElement createTestStepMasterPageStyle() {
		StyleMasterPageElement masterPageElement = newStyleMasterPageElement(MASTER_PAGES.TEST_STEP_MASTER_PAGE_ELEMENT.name(),
				evidencesWriter.getMainPageLayoutStyles().getStyleNameAttribute());
		StyleHeaderElement headerElement = masterPageElement.newStyleHeaderElement();

		testCaseTableElement = headerElement.newTableTableElement();
		testCaseTableElement.setTableNameAttribute(MASTER_PAGES.TEST_STEP_MASTER_PAGE_ELEMENT.name());

		createTestStepTableColumnMasterPageStyles(testCaseTableElement);

		createTestCaseRowsElements(testCaseTableElement); // Celulas tb são criadas la dentro. Coisa de design.

		return masterPageElement;
	}
	
	private void createTestStepTableColumnMasterPageStyles(TableTableElement tableElement) {
		TableTableColumnsElement tableColumnsElement = tableElement.newTableTableColumnsElement();
		for (TEST_CASE_COLUMNS_STYLES testCaseColumnStyle : EvidencesStylesOfficeAutomaticStyles.TEST_CASE_COLUMNS_STYLES.values()) {
			tableColumnsElement.newTableTableColumnElement()
			.setStyleName(evidencesWriter
					.getColumnStyle(testCaseColumnStyle.name())
					.getStyleNameAttribute());
		}
	}

	private void createTestCaseRowsElements(TableTableElement tableElement) {
		TableTableRowElement row1Element = tableElement.newTableTableRowElement();
		row1Element.setStyleName(Commons.getTestCaseRow1StyleName());

		TableTableCellElement logoCellElement = (TableTableCellElement) newTableTableCellElementBase(row1Element,
				TableTableCellElement.ELEMENT_NAME);
		logoCellElement.setStyleName(Commons.getLogoCellStyleName());
		logoCellElement.setTableNumberRowsSpannedAttribute(3);

		newDrawFrameElement(logoCellElement, MASTER_PAGES.TEST_STEP_MASTER_PAGE_ELEMENT.name());

		newTableTableCellElement(row1Element, Commons.getUCLabelStyleName(), Commons.getBoldParagraphFontStyle(), LABELS.UC_LABEL_NODE_VALUE, false);

		newTableTableCellElement(row1Element, Commons.getUCValueStyleName(), Commons.getDefaultParagraphOfficeStyleStyleName(), null, true);

		TableTableRowElement row2Element = tableElement.newTableTableRowElement();
		row2Element.setStyleName(Commons.getTestCaseRow2StyleName());
		
		newTableTableCellElementBase(row2Element, TableCoveredTableCellElement.ELEMENT_NAME);
		
		newTableTableCellElement(row2Element, Commons.getTCLabelStyleName(), Commons.getBoldParagraphFontStyle(), LABELS.TC_LABEL_NODE_VALUE, false);

		newTableTableCellElement(row2Element, Commons.getTCValueStyleName(), Commons.getDefaultParagraphOfficeStyleStyleName(), null, true);

		TableTableRowElement row3Element = tableElement.newTableTableRowElement();
		row3Element.setStyleName(Commons.getTestCaseRow2StyleName());
		newTableTableCellElementBase(row3Element, TableCoveredTableCellElement.ELEMENT_NAME);

		newTableTableCellElement(row3Element, Commons.getDateLabelStyleName(), Commons.getBoldParagraphFontStyle(), LABELS.DATE_LABEL_NODE_VALUE, true);

		newTableTableCellElement(row3Element, Commons.getDateValueStyleName(), Commons.getDefaultParagraphOfficeStyleStyleName(), null, false);

		newTableTableCellElement(row3Element, Commons.getTimeLabelStyleName(), Commons.getBoldParagraphFontStyle(), LABELS.TIME_LABEL_NODE_VALUE, false);

		newTableTableCellElement(row3Element, Commons.getTimeValueStyleName(), Commons.getDefaultParagraphOfficeStyleStyleName(), null, false);
	}

	private void newTableTableCellElement(TableTableRowElement rowElement, String styleName, String paragraphStyleName,
			LABELS label, boolean columnsSpanned) {

		TableTableCellElement tableTableCellElement = (TableTableCellElement) newTableTableCellElementBase(rowElement,
				TableTableCellElement.ELEMENT_NAME);
		tableTableCellElement
				.setTableStyleNameAttribute(evidencesWriter.getCellStyles(styleName).getStyleNameAttribute());
		if (columnsSpanned) {
			int columnsSpannedValue = Integer.parseInt(Commons.getProperty(styleName, TableNumberColumnsSpannedAttribute.ATTRIBUTE_NAME.getPrefix(),
							TableNumberColumnsSpannedAttribute.ATTRIBUTE_NAME.getLocalName()));

			tableTableCellElement.setOdfAttributeValue(TableNumberColumnsSpannedAttribute.ATTRIBUTE_NAME,
					String.valueOf(columnsSpannedValue));

			for (int i = 1; i < columnsSpannedValue; i++) {
				newTableTableCellElementBase(rowElement, TableCoveredTableCellElement.ELEMENT_NAME);
			}

		}

		TextPElement tcLabelTextPElement = tableTableCellElement.newTextPElement();
		tcLabelTextPElement.setTextStyleNameAttribute(Commons.getDefaultParagraphOfficeStyleStyleName());
		if(label != null) tcLabelTextPElement.setTextContent(label.getLabel());
	}

	private TableTableCellElementBase newTableTableCellElementBase(TableTableRowElement rowElement,
			OdfName elementName) {
		double officeValueValue = 0;
		String officeValueTypeValue = null;
		TableTableCellElementBase tableTableCellElementBase = (elementName.equals(TableTableCellElement.ELEMENT_NAME))
				? rowElement.newTableTableCellElement(officeValueValue, officeValueTypeValue)
				: rowElement.newTableCoveredTableCellElement(officeValueValue, officeValueTypeValue);
		tableTableCellElementBase.removeAttribute("office:value");
		tableTableCellElementBase.removeAttribute("office:value-type");
		return tableTableCellElementBase;
	}

	private void newDrawFrameElement(TableTableCellElement cellElement, String tableName) {
		DrawFrameElement drawFrameElement = cellElement.newTextPElement().newTextSpanElement().newDrawFrameElement();
		final String styleName = tableName + "_DRAW_FRAME";

		for (MasterPages.DrawFrameElementProperties property : MasterPages.DrawFrameElementProperties.values()) {
			Commons.setAttributes(drawFrameElement, property, styleName);
		}

		DrawImageElement imageElement = drawFrameElement.newDrawImageElement();
		for (MasterPages.ImageElementProperties property : MasterPages.ImageElementProperties.values()) {
			Commons.setAttributes(imageElement, property, styleName);
		}
	}
	
	public void setHeaderUC(String ucName) {
		Cell cell = Table.getInstance(testCaseTableElement).getCellByPosition("C1");
		cell.getParagraphByIndex(0, false).setTextContent(ucName);
	}

	public void setHeaderTC(String testInstanceName) {
		Cell cell = Table.getInstance(testCaseTableElement).getCellByPosition("C2");
		cell.getParagraphByIndex(0, false).setTextContent(testInstanceName);
	}

	public void setHeaderDate(String execDate) {
		Cell cell = Table.getInstance(testCaseTableElement).getCellByPosition("D3");
		cell.getParagraphByIndex(0, false).setTextContent(execDate);
	}

	public void setHeaderTime(String execTime) {
		Cell cell = Table.getInstance(testCaseTableElement).getCellByPosition("F3");
		cell.getParagraphByIndex(0, false).setTextContent(execTime);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2652983590318036943L;
}

package br.com.empresa.almintegration.evidences.content;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import org.jsoup.Jsoup;
import org.odftoolkit.odfdom.dom.element.office.OfficeBodyElement;
import org.odftoolkit.odfdom.dom.element.office.OfficeTextElement;
import org.odftoolkit.odfdom.dom.element.table.TableCoveredTableCellElement;
import org.odftoolkit.odfdom.dom.element.table.TableTableCellElement;
import org.odftoolkit.odfdom.dom.element.table.TableTableCellElementBase;
import org.odftoolkit.odfdom.dom.element.table.TableTableColumnElement;
import org.odftoolkit.odfdom.dom.element.table.TableTableColumnsElement;
import org.odftoolkit.odfdom.dom.element.table.TableTableElement;
import org.odftoolkit.odfdom.dom.element.table.TableTableRowElement;
import org.odftoolkit.odfdom.dom.element.text.TextAElement;
import org.odftoolkit.odfdom.dom.element.text.TextIndexBodyElement;
import org.odftoolkit.odfdom.dom.element.text.TextIndexEntryTabStopElement;
import org.odftoolkit.odfdom.dom.element.text.TextPElement;
import org.odftoolkit.odfdom.dom.element.text.TextSoftPageBreakElement;
import org.odftoolkit.odfdom.dom.element.text.TextSpanElement;
import org.odftoolkit.odfdom.dom.element.text.TextTableOfContentElement;
import org.odftoolkit.odfdom.dom.element.text.TextTableOfContentEntryTemplateElement;
import org.odftoolkit.odfdom.dom.element.text.TextTableOfContentSourceElement;
import org.odftoolkit.odfdom.pkg.OdfFileDom;
import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.Table;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import br.com.empresa.almintegration.alm.model.RunStep;
import br.com.empresa.almintegration.evidences.Commons;
import br.com.empresa.almintegration.evidences.EvidencesWriter;
import br.com.empresa.almintegration.evidences.TestStepTable;
import br.com.empresa.almintegration.evidences.content.EvidencesContentAutomaticStyles.COVER_PAGE_TABLE_CELLS_STYLES;
import br.com.empresa.almintegration.evidences.content.EvidencesContentAutomaticStyles.COVER_PAGE_TABLE_COLUMNS_STYLES;
import br.com.empresa.almintegration.evidences.content.EvidencesContentAutomaticStyles.COVER_PAGE_TABLE_ROWS_STYLES;
import br.com.empresa.almintegration.evidences.content.EvidencesContentAutomaticStyles.TEST_STEP_TEXT_STYLES;

public class EvidencesContentOfficeBodyElement extends OfficeBodyElement {

	enum COMMENTS_COLUMNS_STYLES {
		COMMENTS_TABLE_COLUMN_A_STYLE
	}

	enum COMMENTS_TABLE_CELLS_STYLES {
		COMMON_CELLS_STYLES_ALL_BORDERS, COMMON_CELLS_STYLES_RIGHT_TOP_BORDERS, COMMON_CELLS_STYLES_LEFT_TOP_BORDERS;
	};

	static enum COMMENTS_TABLE_ROWS_STYLES {
		COMMENTS_TABLE_ROW_1
	}

	enum REVISION_HISTORY_TABLE_CELLS_STYLES {
		COMMON_CELLS_STYLES_ALL_BORDERS, COMMON_CELLS_STYLES_RIGHT_TOP_BORDERS, COMMON_CELLS_STYLES_RIGHT_BOTTOM_BORDERS, COMMON_CELLS_STYLES_LEFT_TOP_BORDERS, HEADER_CELLS_STYLES_ALL_BORDERS, HEADER_CELLS_STYLES_RIGHT_TOP_BORDERS, HEADER_CELLS_STYLES_LEFT_TOP_BORDERS;
	};

	enum TEST_STEP_COLUMNS_STYLES {
		TEST_STEP_TABLE_COLUMN_A_STYLE, TEST_STEP_TABLE_COLUMN_B_STYLE, TEST_STEP_TABLE_COLUMN_C_STYLE, TEST_STEP_TABLE_COLUMN_D_STYLE, TEST_STEP_TABLE_COLUMN_E_STYLE, TEST_STEP_TABLE_COLUMN_F_STYLE, TEST_STEP_TABLE_COLUMN_G_STYLE, TEST_STEP_TABLE_COLUMN_H_STYLE, TEST_STEP_TABLE_COLUMN_I_STYLE, TEST_STEP_TABLE_COLUMN_J_STYLE, TEST_STEP_TABLE_COLUMN_K_STYLE;
	};

	enum TEST_STEP_TABLE_CELLS_STYLES {
		COMMON_CELLS_STYLES_ALL_BORDERS, COMMON_CELLS_STYLES_RIGHT_TOP_BORDERS, COMMON_CELLS_STYLES_LEFT_TOP_BORDERS, COMMON_CELLS_STYLES_NO_BORDERS, COMMON_CELLS_STYLES_ONLY_TOP_BORDERS, COMMON_CELLS_STYLES_NO_TOP_BORDERS;
	}
	static enum TEST_STEP_TABLE_ROWS_STYLES {
		TEST_STEP_TABLE_ROW_1, TEST_STEP_TABLE_ROW_2, TEST_STEP_TABLE_ROW_3, TEST_STEP_TABLE_ROW_4, TEST_STEP_TABLE_ROW_5, TEST_STEP_TABLE_ROW_6, TEST_STEP_TABLE_ROW_7, TEST_STEP_TABLE_ROW_8
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 8619854932867547787L;
	private static final String TEST_STEP_BOLD_TEXT = "TEST_STEP_BOLD_TEXT";
	private static final String TEST_STEP_DEFAULT_TEXT = "TEST_STEP_DEFAULT_TEXT";
	private static final String TEST_STEP_TABLE_STEP_CELL_LABEL = "Passo:";
	private static final String TEST_STEP_TABLE_START_TIME_CELL_LABEL = "Data:";
	private static final String TEST_STEP_TABLE_START_DATE_CELL_LABEL = "Hora:";
	private static final String TEST_STEP_TABLE_STEP_NAME_CELL_LABEL = "Nome:";
	private static final String TEST_STEP_TABLE_STEP_ACTION_CELL_LABEL = "Acao:";
	private static final String TEST_STEP_TABLE_STEP_EXPECTED_RESULT_CELL_LABEL = "Resultado Esperado:";
	private static final String TEST_STEP_TABLE_ACTUAL_RESULT_CELL_LABEL = "Resultado Atual:";
	private static final String TEST_STEP_TABLE_STEP_STATUS_CELL_LABEL = "Status:";

	private static final String TEST_STEP_TABLE_END_DATE_CELL_LABEL = "Data:";

	private static final String TEST_STEP_TABLE_END_TIME_CELL_LABEL = "Hora:";

	private static final String TEST_STEP_TABLE_STEP_EVIDENCES_LABEL = "Evidências";
	
	private static final String REVISION_HISTORY_HEADER_TEXT_STYLE = "REVISION_HISTORY_HEADER_TEXT_STYLE";

	private static final String TOC_TITLE = "Sumário";
	private static final String REVISION_HISTORY_TITLE = "Histórico de revisões";
	private static final String COMMENTS_TITLE = "Comentários";
	private static final String TEST_EVIDENCES_TITLE = "Evidências de Teste";
	private static final String COVER_PAGE_TITLE = "Evidências de Teste";

	TextIndexBodyElement textIndexBodyElement;
	TableTableElement coverPageTableElement;
	int stepCounter;
	private TextPElement tocPElement;
	OfficeTextElement mainTextElement;

	public EvidencesContentOfficeBodyElement(OdfFileDom ownerDoc) {
		super(ownerDoc);
		createOfficeBodyElements();
	}

	private void cleanCellElement(TableTableCellElementBase cellElement) {
		final String OFFICE_VALUE_ATTRIBUTE = "office:value";
		final String OFFICE_VALUE_TYPE_ATTRIBUTE = "office:value-type";
		cellElement.removeAttribute(OFFICE_VALUE_ATTRIBUTE);				
		cellElement.removeAttribute(OFFICE_VALUE_TYPE_ATTRIBUTE);
	}

	private void createCommentsTable(OfficeTextElement textElement) {
		TextPElement commentsPElement = textElement.newTextPElement();
		commentsPElement.setTextStyleNameAttribute(Commons.getLogoParagraphStyleName());
		TextSpanElement spanElement = commentsPElement.newTextSpanElement();
		spanElement.setTextStyleNameAttribute(Commons.getTitleParagraphStylename());

		TableTableElement commentsTable = textElement.newTableTableElement();
		commentsTable.setTableStyleNameAttribute(Commons.getCommentsTableStyleName());
		TableTableColumnsElement columnsElement = commentsTable.newTableTableColumnsElement();
		createTableColumnElement(columnsElement, COMMENTS_COLUMNS_STYLES.values());
		createTableRowElement(commentsTable, COMMENTS_TABLE_ROWS_STYLES.values(), null);

		String currentPageNumber = String.valueOf(getCurrentPageNumber());
		int randomNumber = new Random().nextInt(1000);
		String textNameValue = new StringBuffer().append("_Toc").append(randomNumber).toString().toString();
		commentsPElement.newTextBookmarkStartElement(textNameValue);
		Text textNode = commentsPElement.getOwnerDocument().createTextNode(COMMENTS_TITLE);
		commentsPElement.appendChild(textNode);
		commentsPElement.newTextBookmarkEndElement(textNameValue);
		
		TextPElement indexBodyPElement = textIndexBodyElement.newTextPElement();
		indexBodyPElement.setTextStyleNameAttribute(Commons.getTOCParagraphIndexBodyParagraphStyleName());
		String xlinkTypeValue = null;
		String xlinkHrefValue = new StringBuffer().append("#_Toc").append(randomNumber).toString();
		TextAElement textAElement = indexBodyPElement.newTextAElement(xlinkHrefValue, xlinkTypeValue);
		textAElement.setOfficeTargetFrameNameAttribute("_top");
		textAElement.setXlinkShowAttribute("replace");
		TextSpanElement indexSpanElement = textAElement.newTextSpanElement();
		indexSpanElement.setTextStyleNameAttribute(Commons.getTextHyperlinkOfficeStylesStylesStylename());
		indexSpanElement.setTextContent(COMMENTS_TITLE);
		textAElement.newTextTabElement();
		textNode = textAElement.getOwnerDocument().createTextNode(currentPageNumber);
		textAElement.appendChild(textNode);
		textAElement.setNodeValue(currentPageNumber);
	}

	private void createCoverPage(OfficeTextElement textElement) {
		TextPElement coverPageTitlePElement = textElement.newTextPElement();
		coverPageTitlePElement.setTextStyleNameAttribute(Commons.getCoverTitleParagraphStyle());

		TextSpanElement coverPageTitleSpanElement = coverPageTitlePElement.newTextSpanElement();
		coverPageTitleSpanElement.setTextStyleNameAttribute(Commons.getCoverPageTitleTextStyleName());
		coverPageTitleSpanElement.setTextContent(COVER_PAGE_TITLE);

		TextPElement coverPageSubTitlePElement = textElement.newTextPElement();
		coverPageSubTitlePElement.setTextStyleNameAttribute(Commons.getDocumentDefaultParagraphStyle());
		TextSpanElement coverPageSubTitleSpanElement = coverPageSubTitlePElement.newTextSpanElement();
		coverPageSubTitleSpanElement.setTextStyleNameAttribute(Commons.getCoverPageSubTitleTextStyleName());
		coverPageSubTitleSpanElement.setTextStyleNameAttribute(Commons.getCoverPageSubTitleTextStyleName());

		TextSpanElement coverPageBottomSpanElement = coverPageSubTitlePElement.newTextSpanElement();
		coverPageBottomSpanElement.setTextStyleNameAttribute(Commons.getCoverPageSubTitleTextStyleName());		
		for (int i = 0; i < 15; i++) {
			textElement.newTextPElement();
		}

		coverPageTableElement = textElement.newTableTableElement();
		coverPageTableElement.setTableStyleNameAttribute(Commons.getCoverPageBottomTableStyleName());
		TableTableColumnsElement columnsElement = coverPageTableElement.newTableTableColumnsElement();
		createCoverPageTableColumnsElement(columnsElement);
		createCoverPageTableRowsElements(coverPageTableElement);

		textElement.newTextPElement();
		textElement.newTextSoftPageBreakElement();		
	}

	private void createCoverPageTableColumnsElement(TableTableColumnsElement columnsElement) {
		createTableColumnElement(columnsElement, COVER_PAGE_TABLE_COLUMNS_STYLES.values());
	}

	private void createCoverPageTableRowsElements(TableTableElement coverPageTableElement) {
		createTableRowElement(coverPageTableElement, COVER_PAGE_TABLE_ROWS_STYLES.values(), null);
	}

	private void createOfficeBodyElements() {
		mainTextElement = newOfficeTextElement();
		mainTextElement.setTextUseSoftPageBreaksAttribute(true);

		createCoverPage(mainTextElement);

		createTOC(mainTextElement);

		createRevisionHistoryTable(mainTextElement);
		mainTextElement.newTextSoftPageBreakElement();

		createCommentsTable(mainTextElement);
		mainTextElement.newTextSoftPageBreakElement();

		createTestStepTitle(mainTextElement);		
	}

	private void createRevisionHistoryTable(OfficeTextElement textElement) {
		TextPElement revisionHistoryPElement = textElement.newTextPElement();
		revisionHistoryPElement.setTextStyleNameAttribute(Commons.getLogoParagraphStyleName());
		TextSpanElement revisionHistorySpanElement = revisionHistoryPElement.newTextSpanElement();
		revisionHistorySpanElement.setTextStyleNameAttribute(Commons.getTitleParagraphStylename());
		
		int randomNumber = new Random().nextInt(1000);
		String textNameValue = new StringBuffer().append("_Toc").append(randomNumber).toString().toString();
		revisionHistoryPElement.newTextBookmarkStartElement(textNameValue);
		Text textNode = revisionHistoryPElement.getOwnerDocument().createTextNode(REVISION_HISTORY_TITLE);
		revisionHistoryPElement.appendChild(textNode);
		revisionHistoryPElement.newTextBookmarkEndElement(textNameValue);		

		TableTableElement revisionHistoryTable = textElement.newTableTableElement();
		revisionHistoryTable.setTableStyleNameAttribute(Commons.getRevisionHistoryTableStyleName());
		TableTableColumnsElement columnsElement = revisionHistoryTable.newTableTableColumnsElement();
		createTableColumnElement(columnsElement,
				EvidencesContentAutomaticStyles.getRevisionHistoryTableColumnsStyles());
		createTableRowElement(revisionHistoryTable,
				EvidencesContentAutomaticStyles.getRevisionHistoryTableRowsStyles(), null);
		
		String currentPageNumber = String.valueOf(getCurrentPageNumber());
		TextPElement indexBodyPElement = textIndexBodyElement.newTextPElement();
		indexBodyPElement.setTextStyleNameAttribute(Commons.getTOCParagraphIndexBodyParagraphStyleName());
		String xlinkTypeValue = null;
		String xlinkHrefValue = new StringBuffer().append("#_Toc").append(randomNumber).toString();
		TextAElement textAElement = indexBodyPElement.newTextAElement(xlinkHrefValue, xlinkTypeValue);
		textAElement.setOfficeTargetFrameNameAttribute("_top");
		textAElement.setXlinkShowAttribute("replace");
		TextSpanElement indexSpanElement = textAElement.newTextSpanElement();
		indexSpanElement.setTextStyleNameAttribute(Commons.getTextHyperlinkOfficeStylesStylesStylename());
		indexSpanElement.setTextContent(REVISION_HISTORY_TITLE);
		textAElement.newTextTabElement();
		textNode = textAElement.getOwnerDocument().createTextNode(currentPageNumber);
		textAElement.appendChild(textNode);
		textAElement.setNodeValue(currentPageNumber);
	}

	private void createTableCellElements(TableTableRowElement rowElement, RunStep runStep) {
		if (rowElement.getStyleName().equals(COVER_PAGE_TABLE_ROWS_STYLES.COVER_PAGE_TABLE_ROW_1_STYLES.name())) {
			createTableCellElement(rowElement, COVER_PAGE_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_NO_BORDERS.name(), 2,
					"Projeto: ", true, false);
			createTableCellElement(rowElement, COVER_PAGE_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_NO_BORDERS.name(), 0,
					"", false, false);
		}

		if (rowElement.getStyleName().equals(COVER_PAGE_TABLE_ROWS_STYLES.COVER_PAGE_TABLE_ROW_2_STYLES.name())) {
			createTableCellElement(rowElement, COVER_PAGE_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_NO_BORDERS.name(), 0,
					"Ciclo: ", true, false);
			createTableCellElement(rowElement, COVER_PAGE_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_NO_BORDERS.name(), 2,
					"", false, false);
		}

		if (rowElement.getStyleName().equals(COVER_PAGE_TABLE_ROWS_STYLES.COVER_PAGE_TABLE_ROW_3_STYLES.name())) {
			createTableCellElement(rowElement, COVER_PAGE_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_NO_BORDERS.name(), 0,
					"Data: ", true, false);
			createTableCellElement(rowElement, COVER_PAGE_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_NO_BORDERS.name(), 2,
					"", false, false);
		}

		if (rowElement.getStyleName().equals(COMMENTS_TABLE_ROWS_STYLES.COMMENTS_TABLE_ROW_1.name())) {
			createTableCellElement(rowElement, COMMENTS_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_ALL_BORDERS.name(), 0,
					"", true, false);
		}

		if (rowElement.getStyleName()
				.equals(EvidencesContentAutomaticStyles.getRevisionHistoryTableRow1Styles().name())) {
			createTableCellElement(rowElement,
					REVISION_HISTORY_TABLE_CELLS_STYLES.HEADER_CELLS_STYLES_LEFT_TOP_BORDERS.name(), 0, "Data", true, false);
			createTableCellElement(rowElement,
					REVISION_HISTORY_TABLE_CELLS_STYLES.HEADER_CELLS_STYLES_RIGHT_TOP_BORDERS.name(), 0, "Versão",
					true, false);
			createTableCellElement(rowElement,
					REVISION_HISTORY_TABLE_CELLS_STYLES.HEADER_CELLS_STYLES_RIGHT_TOP_BORDERS.name(), 0, "Descrição",
					true, false);
			createTableCellElement(rowElement,
					REVISION_HISTORY_TABLE_CELLS_STYLES.HEADER_CELLS_STYLES_RIGHT_TOP_BORDERS.name(), 0, "Autor", true, false);
		}

		if (rowElement.getStyleName()
				.equals(EvidencesContentAutomaticStyles.getRevisionHistoryTableRow2Styles().name())) {
			createTableCellElement(rowElement,
					REVISION_HISTORY_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_ALL_BORDERS.name(), 0,
					new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTimeInMillis()), false, false);
			createTableCellElement(rowElement,
					REVISION_HISTORY_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_ALL_BORDERS.name(), 0, "1.0", false, false);
			createTableCellElement(rowElement,
					REVISION_HISTORY_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_ALL_BORDERS.name(), 0, "Teste executado automaticamente.", false, false);
			try {
				createTableCellElement(rowElement,
						REVISION_HISTORY_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_ALL_BORDERS.name(), 0,
						"Jenkins instance @" + InetAddress.getLocalHost().getHostAddress(), false, false);
			} catch (UnknownHostException e) {
				createTableCellElement(rowElement,
						REVISION_HISTORY_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_ALL_BORDERS.name(), 0, "", false, false);
			}
		}

		if (rowElement.getStyleName().equals(TEST_STEP_TABLE_ROWS_STYLES.TEST_STEP_TABLE_ROW_1.name())) {
			String stepOrder = runStep.getField(RunStep.FIELDS.STEP_ORDER);
			String executionDate = (runStep.currentStepId != null) ? runStep.getField(RunStep.FIELDS.EXECUTION_DATE) : "xx/xx/xx";
			String executionTime = (runStep.currentStepId != null) ? runStep.getField(RunStep.FIELDS.EXECUTION_TIME) : "00:00:00";

			createTableCellElement(rowElement, TEST_STEP_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_LEFT_TOP_BORDERS.name(),
					0, TEST_STEP_TABLE_STEP_CELL_LABEL, true, false);
			createTableCellElement(rowElement,
					TEST_STEP_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_RIGHT_TOP_BORDERS.name(), 2, stepOrder, false, false);

			createTableCellElement(rowElement,
					TEST_STEP_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_ONLY_TOP_BORDERS.name(), 2,
					TEST_STEP_TABLE_START_DATE_CELL_LABEL, true, false);
			createTableCellElement(rowElement,
					TEST_STEP_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_RIGHT_TOP_BORDERS.name(), 2, executionDate, false, false);

			createTableCellElement(rowElement,
					TEST_STEP_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_ONLY_TOP_BORDERS.name(), 0,
					TEST_STEP_TABLE_START_TIME_CELL_LABEL, true, false);
			createTableCellElement(rowElement, TEST_STEP_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_RIGHT_TOP_BORDERS.name(),
					3, executionTime, false, false);
		}

		if (rowElement.getStyleName().equals(TEST_STEP_TABLE_ROWS_STYLES.TEST_STEP_TABLE_ROW_2.name())) {
			String name = (runStep.currentStepId != null) ? runStep.getField(RunStep.FIELDS.NAME) : "NONONONONONONONONONONONO";
			createTableCellElement(rowElement,
					TEST_STEP_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_LEFT_TOP_BORDERS.name(), 2,
					TEST_STEP_TABLE_STEP_NAME_CELL_LABEL, true, false);
			createTableCellElement(rowElement,
					TEST_STEP_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_RIGHT_TOP_BORDERS.name(), 9, name, false, true);
		}

		if (rowElement.getStyleName().equals(TEST_STEP_TABLE_ROWS_STYLES.TEST_STEP_TABLE_ROW_3.name())) {
			String description = (runStep.currentStepId != null) ? Jsoup.parse(runStep.getField(RunStep.FIELDS.DESCRIPTION)).text() : "NONONONONONONONONONONONO";
			createTableCellElement(rowElement, TEST_STEP_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_LEFT_TOP_BORDERS.name(),
					2, TEST_STEP_TABLE_STEP_ACTION_CELL_LABEL, true, false);
			createTableCellElement(rowElement,
					TEST_STEP_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_RIGHT_TOP_BORDERS.name(), 9, description, false, false);
		}

		if (rowElement.getStyleName().equals(TEST_STEP_TABLE_ROWS_STYLES.TEST_STEP_TABLE_ROW_4.name())) {			
			String expected = (runStep.currentStepId != null) ? Jsoup.parse(runStep.getField(RunStep.FIELDS.EXPECTED)).text() : "NONONONONONONONONONONONO";

			createTableCellElement(rowElement, TEST_STEP_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_LEFT_TOP_BORDERS.name(),
					4, TEST_STEP_TABLE_STEP_EXPECTED_RESULT_CELL_LABEL, true, false);
			createTableCellElement(rowElement,
					TEST_STEP_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_RIGHT_TOP_BORDERS.name(), 7, expected, false, false);
		}

		if (rowElement.getStyleName().equals(TEST_STEP_TABLE_ROWS_STYLES.TEST_STEP_TABLE_ROW_5.name())) {
			String actual = (runStep.currentStepId != null) ? runStep.getField(RunStep.FIELDS.ACTUAL) : "NONONONONONONONONONONONO";
			createTableCellElement(rowElement, TEST_STEP_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_LEFT_TOP_BORDERS.name(),
					3, TEST_STEP_TABLE_ACTUAL_RESULT_CELL_LABEL, true, false);
			createTableCellElement(rowElement,
					TEST_STEP_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_RIGHT_TOP_BORDERS.name(), 8, actual, false, false);
		}

		if (rowElement.getStyleName().equals(TEST_STEP_TABLE_ROWS_STYLES.TEST_STEP_TABLE_ROW_6.name())) {
			String status = runStep.getField(RunStep.FIELDS.STATUS);
			createTableCellElement(rowElement, TEST_STEP_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_LEFT_TOP_BORDERS.name(),
					2, TEST_STEP_TABLE_STEP_STATUS_CELL_LABEL, true, false);
			createTableCellElement(rowElement,
					TEST_STEP_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_RIGHT_TOP_BORDERS.name(), 4, status, false, false);

			createTableCellElement(rowElement, TEST_STEP_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_LEFT_TOP_BORDERS.name(),
					0, TEST_STEP_TABLE_END_DATE_CELL_LABEL, true, false);
			createTableCellElement(rowElement,
					TEST_STEP_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_RIGHT_TOP_BORDERS.name(), 2, "", false, false);

			createTableCellElement(rowElement, TEST_STEP_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_LEFT_TOP_BORDERS.name(),
					0, TEST_STEP_TABLE_END_TIME_CELL_LABEL, true, false);
			createTableCellElement(rowElement,
					TEST_STEP_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_RIGHT_TOP_BORDERS.name(), 0, "", false, false);
		}

		if (rowElement.getStyleName().equals(TEST_STEP_TABLE_ROWS_STYLES.TEST_STEP_TABLE_ROW_7.name())) {
			createTableCellElement(rowElement, TEST_STEP_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_ALL_BORDERS.name(), 11,
					TEST_STEP_TABLE_STEP_EVIDENCES_LABEL, true, false);
		}

		if (rowElement.getStyleName().equals(TEST_STEP_TABLE_ROWS_STYLES.TEST_STEP_TABLE_ROW_8.name())) {
			createTableCellElement(rowElement, TEST_STEP_TABLE_CELLS_STYLES.COMMON_CELLS_STYLES_NO_TOP_BORDERS.name(), 11,
					"", false, false);
		}
	}
	
	private void createTableCellElement(TableTableRowElement rowElement, String styleName, int columnsSpannedAttribute,
			String nodeValue, boolean bold, boolean indexBookmark) {
		String officeValueTypeValue = null;
		double officeValueValue = 0;
		TableTableCellElement cellElement = rowElement.newTableTableCellElement(officeValueValue, officeValueTypeValue);
		cellElement.setStyleName(styleName);
		TextPElement textPElement = cellElement.newTextPElement();

		if(indexBookmark){
			String currentPageNumber = String.valueOf(getCurrentPageNumber());
			textPElement.setTextStyleNameAttribute(TEST_STEP_DEFAULT_TEXT);
			int randomNumber = new Random().nextInt(1000);
			String textNameValue = new StringBuffer().append("_Toc").append(randomNumber).toString().toString();
			textPElement.newTextBookmarkStartElement(textNameValue);
			Text textNode = textPElement.getOwnerDocument().createTextNode(nodeValue);
			textPElement.appendChild(textNode);
			textPElement.newTextBookmarkEndElement(textNameValue);

			TextPElement indexBodyPElement = textIndexBodyElement.newTextPElement();
			indexBodyPElement.setTextStyleNameAttribute(Commons.getTOCParagraphIndexBodyParagraphStyleName());
			String xlinkTypeValue = null;
			String xlinkHrefValue = new StringBuffer().append("#_Toc").append(randomNumber).toString();
			TextAElement textAElement = indexBodyPElement.newTextAElement(xlinkHrefValue, xlinkTypeValue);
			textAElement.setOfficeTargetFrameNameAttribute("_top");
			textAElement.setXlinkShowAttribute("replace");
			TextSpanElement indexSpanElement = textAElement.newTextSpanElement();
			indexSpanElement.setTextStyleNameAttribute(Commons.getTextHyperlinkOfficeStylesStylesStylename());
			indexSpanElement.setTextContent(nodeValue);
			textAElement.newTextTabElement();
			textNode = textAElement.getOwnerDocument().createTextNode(currentPageNumber);
			textAElement.appendChild(textNode);
			textAElement.setNodeValue(currentPageNumber);
				
		} else if (bold) {
			if (styleName.equals(REVISION_HISTORY_TABLE_CELLS_STYLES.HEADER_CELLS_STYLES_RIGHT_TOP_BORDERS.name())
					|| styleName.equals(REVISION_HISTORY_TABLE_CELLS_STYLES.HEADER_CELLS_STYLES_LEFT_TOP_BORDERS.name()))
				textPElement.setTextStyleNameAttribute(REVISION_HISTORY_HEADER_TEXT_STYLE);
			else textPElement.setTextStyleNameAttribute(TEST_STEP_BOLD_TEXT);
			textPElement.setTextContent(nodeValue);
		} else if(nodeValue.equals(TEST_STEP_TABLE_STEP_EVIDENCES_LABEL)){
			textPElement.setTextStyleNameAttribute(TEST_STEP_TEXT_STYLES.TEST_STEP_CENTER_BOLD_TEXT.name());
			textPElement.setTextContent(nodeValue);
		} else {
			textPElement.setTextContent(nodeValue);
		}

		setColumnsSpannedAttribute(columnsSpannedAttribute, rowElement, cellElement);
		cleanCellElement(cellElement);
	}

	private void createTableColumnElement(TableTableColumnsElement columnsElement, Object[] COLUMNS) {
		for (int i = 0; i < COLUMNS.length; i++) {
			String columnStyle = COLUMNS[i].toString();
			TableTableColumnElement column = columnsElement.newTableTableColumnElement();
			column.setStyleName(columnStyle);
		}
	}

	private void createTableRowElement(TableTableElement table, Object[] ROWS, RunStep runStep) {
		for (int i = 0; i < ROWS.length; i++) {
			String styleName = ROWS[i].toString();
			TableTableRowElement rowElement = table.newTableTableRowElement();
			rowElement.setStyleName(styleName);
			createTableCellElements(rowElement, runStep);
		}
	}

	private void createTableRowsElements(TableTableElement table, RunStep runStep) {
		createTableRowElement(table, TEST_STEP_TABLE_ROWS_STYLES.values(), runStep);
	}

	public TestStepTable createTestStepTable(RunStep runStep) {
		int field = Integer.parseInt(runStep.getField(RunStep.FIELDS.STEP_ORDER));
		Table table = EvidencesWriter.getInstance()
				.getTestStepTable("TestStepTable_" + field);
		if (table == null) {
			OfficeTextElement testStepOfficeTextElement = (OfficeTextElement) getFirstElementChild();

			TestStepTable testStepTable;
			if (runStep.getField(RunStep.FIELDS.STEP_ORDER).equals("1")) {
				testStepTable = new TestStepTable((OdfFileDom) testStepOfficeTextElement.getOwnerDocument());
			} else {
				TextPElement testStepPElement = testStepOfficeTextElement.newTextPElement();
				testStepPElement.setTextStyleNameAttribute(Commons.getTestCaseParagraphStyleName());
				testStepTable = new TestStepTable((OdfFileDom) testStepPElement.getOwnerDocument());
			}
			testStepTable.setTableStyleNameAttribute("TEST_STEP_TABLE_STYLE");
			testStepTable.setTableNameAttribute("TestStepTable_" + runStep.getField(RunStep.FIELDS.STEP_ORDER));
			TableTableColumnsElement columnsElement = testStepTable.newTableTableColumnsElement();
			createTestStepTableColumnsElement(columnsElement);
			createTableRowsElements(testStepTable, runStep);
			testStepOfficeTextElement.appendChild(testStepTable);

			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat sdd = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat sdt = new SimpleDateFormat("hh:mm:ss");
			testStepTable.setEndDate(sdd.format(calendar.getTimeInMillis()));
			testStepTable.setEndTime(sdt.format(calendar.getTimeInMillis()));

			testStepTable.addImagesToEvidences(runStep.getField(RunStep.FIELDS.ATTACHMENT), runStep.currentStepId);

			testStepOfficeTextElement.newTextSoftPageBreakElement();

			return testStepTable;
		} else {
			return null;
		}
	}

	private void createTestStepTableColumnsElement(TableTableColumnsElement columnsElement) {
		createTableColumnElement(columnsElement, TEST_STEP_COLUMNS_STYLES.values());
	}

	private void createTestStepTitle(OfficeTextElement textElement) {
		TextPElement testStepPElement = textElement.newTextPElement();
		testStepPElement.setTextStyleNameAttribute(Commons.getTestCaseParagraphStyleName());
		TextSpanElement testStepSpanElement = testStepPElement.newTextSpanElement();
		testStepSpanElement.setTextStyleNameAttribute(Commons.getTitleParagraphStylename());
		testStepSpanElement.setTextContent(TEST_EVIDENCES_TITLE);
	}

	private void createTOC(OfficeTextElement textElement) {
		String textNameValue = null;
		tocPElement = textElement.newTextPElement();
		tocPElement.setTextStyleNameAttribute(Commons.getLogoParagraphStyleName());
		TextSpanElement spanElement = tocPElement.newTextSpanElement();
		spanElement.setTextStyleNameAttribute(Commons.getTitleParagraphStylename());
		spanElement.setTextContent(TOC_TITLE);
		TextTableOfContentElement tableOfContentElement = textElement.newTextTableOfContentElement(textNameValue);
		TextTableOfContentSourceElement tableOfContentSourceElement = tableOfContentElement.newTextTableOfContentSourceElement();
		tableOfContentSourceElement.setTextOutlineLevelAttribute(3);
		tableOfContentSourceElement.setTextUseOutlineLevelAttribute(true);
		tableOfContentSourceElement.setTextUseIndexMarksAttribute(false);
		tableOfContentSourceElement.setTextUseIndexSourceStylesAttribute(false);
		tableOfContentSourceElement.setTextIndexScopeAttribute("document");

		TextTableOfContentEntryTemplateElement firstLevelEntryTemplateElement = tableOfContentSourceElement.newTextTableOfContentEntryTemplateElement(1, Commons.getTOCParagraphTextPParagraphStyleName());
		setTableOfContentEntryTemplateProperties(firstLevelEntryTemplateElement);

		TextTableOfContentEntryTemplateElement secondLevelEntryTemplateElement = tableOfContentSourceElement.newTextTableOfContentEntryTemplateElement(2, Commons.getNormalParagraphOfficeStyleStyleName());
		setTableOfContentEntryTemplateProperties(secondLevelEntryTemplateElement);

		TextTableOfContentEntryTemplateElement thirdLevelEntryTemplateElement = tableOfContentSourceElement.newTextTableOfContentEntryTemplateElement(3, Commons.getNormalParagraphOfficeStyleStyleName());
		setTableOfContentEntryTemplateProperties(thirdLevelEntryTemplateElement);

		textIndexBodyElement = tableOfContentElement.newTextIndexBodyElement();
		textElement.newTextSoftPageBreakElement();
	}

	private void setColumnsSpannedAttribute(int columnsSpannedAttribute, TableTableRowElement rowElement,
			TableTableCellElement cellElement) {		
		final double officeValueValue = 0;
		final String officeValueTypeValue = "";

		if (columnsSpannedAttribute > 0) {
			cellElement.setTableNumberColumnsSpannedAttribute(columnsSpannedAttribute);
			for (int i = 1; i < columnsSpannedAttribute; i++) {				
				TableCoveredTableCellElement coveredTableCellElement = rowElement
						.newTableCoveredTableCellElement(officeValueValue, officeValueTypeValue);
				cleanCellElement(coveredTableCellElement);
			}
		}		
	}

	public void setCoverCycleName(String cycleName){
		Cell cell = Table.getInstance(coverPageTableElement).getCellByPosition("B2");
		cell.getParagraphByIndex(0, false).setTextContent(cycleName);
	}


	public void setCoverDate(String date){
		Cell cell = Table.getInstance(coverPageTableElement).getCellByPosition("B3");
		cell.getParagraphByIndex(0, false).setTextContent(date);
	}

	public void setCoverProjectName(String projectName){
		Cell cell = Table.getInstance(coverPageTableElement).getCellByPosition("C1");
		cell.getParagraphByIndex(0, false).setTextContent(projectName);
	}

	private void setTableOfContentEntryTemplateProperties(TextTableOfContentEntryTemplateElement entryTemplateElement) {
		entryTemplateElement.newTextIndexEntryLinkStartElement();
		entryTemplateElement.newTextIndexEntryTextElement();
		TextIndexEntryTabStopElement tabStopElement = entryTemplateElement.newTextIndexEntryTabStopElement("right");
		tabStopElement.setStyleLeaderCharAttribute(".");
		entryTemplateElement.newTextIndexEntryPageNumberElement();
		entryTemplateElement.newTextIndexEntryLinkEndElement();

	}


	public void setTestCaseNameCoverPage(String testCaseName) {
		TextSpanElement testCaseNameCoverPage = (TextSpanElement) getFirstChild().getFirstChild().getNextSibling().getFirstChild()
				.getNextSibling();
		testCaseNameCoverPage.setTextContent(testCaseName);
	}

	public TextPElement getTocPElement() {
		return tocPElement;
	}

	public TableTableElement getCoverPageTableElement() {
		return coverPageTableElement;
	}

	public int getCurrentPageNumber() {
		NodeList childNodes = mainTextElement.getChildNodes();
		int j = 0;
		for(int i = 0; i < childNodes.getLength(); i++){
			if (childNodes.item(i).getClass().equals(TextSoftPageBreakElement.class)) j++;
		}
		return ++j;
	}

	public OfficeTextElement getMainTextElement() {
		return mainTextElement;
	}
}

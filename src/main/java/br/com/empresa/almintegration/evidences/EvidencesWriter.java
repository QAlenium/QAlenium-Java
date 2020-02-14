package br.com.empresa.almintegration.evidences;

import java.net.URI;
import java.util.Properties;

import org.odftoolkit.odfdom.dom.OdfContentDom;
import org.odftoolkit.odfdom.dom.OdfStylesDom;
import org.odftoolkit.odfdom.dom.element.office.OfficeBodyElement;
import org.odftoolkit.odfdom.dom.element.office.OfficeDocumentContentElement;
import org.odftoolkit.odfdom.dom.element.office.OfficeDocumentStylesElement;
import org.odftoolkit.odfdom.dom.element.office.OfficeMasterStylesElement;
import org.odftoolkit.odfdom.dom.element.style.StyleStyleElement;
import org.odftoolkit.odfdom.dom.element.table.TableTableElement;
import org.odftoolkit.odfdom.dom.element.text.TextPElement;
import org.odftoolkit.odfdom.dom.style.OdfStyleFamily;
import org.odftoolkit.odfdom.incubator.doc.office.OdfOfficeAutomaticStyles;
import org.odftoolkit.odfdom.incubator.doc.office.OdfOfficeStyles;
import org.odftoolkit.odfdom.incubator.doc.style.OdfStyle;
import org.odftoolkit.odfdom.incubator.doc.style.OdfStylePageLayout;
import org.odftoolkit.simple.TextDocument;
import org.odftoolkit.simple.table.Table;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import br.com.empresa.almintegration.alm.model.RunStep;
import br.com.empresa.almintegration.alm.model.TestInstance;
import br.com.empresa.almintegration.evidences.content.EvidencesContentAutomaticStyles;
import br.com.empresa.almintegration.evidences.content.EvidencesContentOfficeBodyElement;
import br.com.empresa.almintegration.evidences.styles.EvidencesStylesOfficeAutomaticStyles;
import br.com.empresa.almintegration.evidences.styles.EvidencesStylesOfficeMasterStyles;
import br.com.empresa.almintegration.evidences.styles.EvidencesStylesOfficeStyles;

/**
 * @author glauco.ramalho
 *  Essa classe e a responsavel por montar o arquivo de evidências automaticas.
 *  O arquivo de evidências e um arquivo texto do tipo Open Document Text.
 *  Esse tipo de arquivo possui a extensão '.odt' e nada mais e do que um pacote
 *  de arquivos xml zipados. Os arquivos que nos interessam são o styles.xml e o content.xml.
 * 
 *  O arquivo styles.xml possui configuracoes de estilos comuns ao documento. Nosso codigo
 *  ira criar os seguintes estilos:
 *  Office Styles:
 *  Paragrafo do cabecalho;
 *  Estilos de grafico.
 *  
 *  Automatic Styles:
 *  Page Layout com o logotipo Cliente e com o logotipo + tabela de caso de teste;
 *  Estilos de grafico.
 *  
 *  Master Styles:
 *  Master Pages para os dois Page Layout de Automatic Styles.
 *  
 *  Repare que os objetos responsaveis por essas tarefas estão espalhados nesse pacote com
 *  nomes sugestivos.
 *  
 *
 */
public class EvidencesWriter {
	
	Properties propertiesFile;
	TextDocument textDocument;	
	EvidencesStylesOfficeStyles evidencesOfficeStyles;
	EvidencesStylesOfficeAutomaticStyles evidencesOfficeAutomaticStyles;
	EvidencesStylesOfficeMasterStyles evidencesOfficeMasterStylesElement;
	
	EvidencesContentAutomaticStyles evidencesContentAutomaticStyles;
	EvidencesContentOfficeBodyElement evidencesContentOfficeBodyElement;

	private static final EvidencesWriter _instance = new EvidencesWriter();

	// Runtime initialization
	// By default ThreadSafe
	public static EvidencesWriter getInstance() {		
		return _instance;
	}
	
	protected EvidencesWriter() {
			
	}
	
	public void createEvidencesDocument(TestInstance currentTestInstance) {
		
		try {
			
			textDocument = TextDocument.newTextDocument();
			textDocument.getPackage().insert(URI.create("Cliente_Logo.png"), "Pictures/Cliente_Logo.png", "image/png");
			createEvidencesStyles();
			createEvidencesContent();
			setTestCaseNameCoverPage(currentTestInstance.getTestInstanceName());
			setCoverCycleName(currentTestInstance.getAssignRcyc());
			setCoverDate(currentTestInstance.getExecDate());
			setHeaderUC(currentTestInstance.getCycle());
			setHeaderTC(currentTestInstance.getTestInstanceName());
			setHeaderDate(currentTestInstance.getExecDate());
			setHeaderTime(currentTestInstance.getExecTime());
			
		} catch (NullPointerException npe) {
			
			try {
				textDocument = TextDocument.newTextDocument();
				textDocument.getPackage().insert(URI.create("Cliente_Logo.png"), "Pictures/Cliente_Logo.png", "image/png");
				createEvidencesStyles();
				createEvidencesContent();
				setTestCaseNameCoverPage("TEST CASE NAME");
				setCoverCycleName("ASSIGN RCYCL");
				setCoverDate("EXEC DATE");
				setHeaderUC("CYCLE");
				setHeaderTC("TEST INTANCE NAME");
				setHeaderDate("EXEC DATE");
				setHeaderTime("EXEC TIME");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}	

	public void finishDocument(String classe){
		try {
			textDocument.save(classe + ".odt");
			textDocument.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void save(String name) throws Exception{
		textDocument.save(name);
	}
	
	private void createEvidencesStyles() throws Exception {
		OdfStylesDom stylesDom = textDocument.getStylesDom();

		OfficeDocumentStylesElement rootElement = stylesDom.getRootElement();
		OdfOfficeStyles officeStyles = stylesDom.getOfficeStyles();
		OdfOfficeAutomaticStyles automaticStyles = stylesDom.getAutomaticStyles();
		OfficeMasterStylesElement officeMasterStylesElement = (OfficeMasterStylesElement)rootElement.getLastElementChild();
		
		rootElement.removeChild(officeStyles);
		rootElement.removeChild(automaticStyles);
		rootElement.removeChild(officeMasterStylesElement);
		
		evidencesOfficeStyles = new EvidencesStylesOfficeStyles(stylesDom);
		evidencesOfficeAutomaticStyles = new EvidencesStylesOfficeAutomaticStyles(stylesDom);			
		evidencesOfficeMasterStylesElement = new EvidencesStylesOfficeMasterStyles(stylesDom);

		rootElement.appendChild(evidencesOfficeStyles);
		rootElement.appendChild(evidencesOfficeAutomaticStyles);
		rootElement.appendChild(evidencesOfficeMasterStylesElement);		
	}

	private void createEvidencesContent() throws Exception {
		OdfContentDom contentDom = textDocument.getContentDom();
		OfficeDocumentContentElement contentRootElement = contentDom.getRootElement();
		OdfOfficeAutomaticStyles automaticStyles = contentDom.getAutomaticStyles();
		OfficeBodyElement bodyElement = (OfficeBodyElement)contentRootElement.getLastElementChild();
		
		evidencesContentAutomaticStyles = new EvidencesContentAutomaticStyles(contentDom);
		contentRootElement.removeChild(automaticStyles);
		contentRootElement.appendChild(evidencesContentAutomaticStyles);
		
		evidencesContentOfficeBodyElement = new EvidencesContentOfficeBodyElement(contentDom);		
		contentRootElement.removeChild(bodyElement);
		contentRootElement.appendChild(evidencesContentOfficeBodyElement);		
	}
	
	public Table getTestStepTable(String tableName){
		NodeList childNodes = evidencesContentOfficeBodyElement.getMainTextElement().getChildNodes();
		Table table = null;
		for(int i = 0; i < childNodes.getLength(); i++){
			Node node = childNodes.item(i);
			if(node.getClass().equals(TestStepTable.class)){
				TestStepTable tableTableElement = (TestStepTable)node;
				String currentTableName = tableTableElement.getTableNameAttribute();
				if(tableName.equals(currentTableName)) table = Table.getInstance(tableTableElement);
			}
		}
		return table;
	}
	
	public void setTestCaseNameCoverPage(String testCaseName){
		evidencesContentOfficeBodyElement.setTestCaseNameCoverPage(testCaseName);
	}
	
	public TableTableElement getCoverPageTableElement(){
		return evidencesContentOfficeBodyElement.getCoverPageTableElement();
	}
	
	public TestStepTable newTestStepTableElement(RunStep runStep){
		return evidencesContentOfficeBodyElement.createTestStepTable(runStep);
	}

	public String getTestEvidencesTitleElement(){
		return evidencesContentAutomaticStyles.getTestEvidencesTitleElement();
	}

	public OdfStylePageLayout getMainPageLayoutStyles() {
		return evidencesOfficeAutomaticStyles.getPageLayout(EvidencesStylesOfficeAutomaticStyles.MAIN_PAGE_LAYOUT_ELEMENT_NAME);
	}
	
	public String getLogoParagraphStyleName(){
		return evidencesContentAutomaticStyles.getLogoParagraph();
	}	

	public String getTOCParagraphStyleName(){
		return evidencesOfficeStyles.getTOCParagraphStylename();
	}
	
	public String getDefaultParagraphStyleName(){
		return evidencesOfficeStyles.getDefaultParagraphStylename();
	}

	public StyleStyleElement getColumnStyle(String testCaseColumnStyle) {		
		return getStyles(OdfStyleFamily.TableColumn, testCaseColumnStyle);
	}	

	public StyleStyleElement getRowStyles(String testCaseRowStyle) {
		return getStyles(OdfStyleFamily.TableRow, testCaseRowStyle);
	}

	public StyleStyleElement getCellStyles(String testCaseCellStyle) {
		return getStyles(OdfStyleFamily.TableCell, testCaseCellStyle);
	}
	
	public StyleStyleElement getAutomaticParagraphStyles(String paragraphStyle) {
		return getStyles(OdfStyleFamily.Paragraph, paragraphStyle);
	}
	
	private StyleStyleElement getStyles(OdfStyleFamily styleFamily, String testCaseColumnStyle) {
		StyleStyleElement styleStyleElement = null;
		for (OdfStyle odfStyle : evidencesOfficeAutomaticStyles.getStylesForFamily(styleFamily)) {
			styleStyleElement = (odfStyle.getStyleNameAttribute().equals(testCaseColumnStyle)) ? odfStyle : styleStyleElement;
		}
		return styleStyleElement;
	}

	public EvidencesStylesOfficeAutomaticStyles getEvidencesOfficeAutomaticStyles() {
		return evidencesOfficeAutomaticStyles;
	}

	public EvidencesStylesOfficeMasterStyles getEvidencesOfficeMasterStylesElement() {
		return evidencesOfficeMasterStylesElement;
	}

	public EvidencesContentAutomaticStyles getEvidencesContentAutomaticStyles() {
		return evidencesContentAutomaticStyles;
	}

	public EvidencesContentOfficeBodyElement getEvidencesContentOfficeBodyElement() {
		return evidencesContentOfficeBodyElement;
	}

	public EvidencesStylesOfficeStyles getEvidencesOfficeStyles() {
		return evidencesOfficeStyles;
	}

	public TextDocument getTextDocument() {
		return textDocument;
	}
	
	public void setCoverProjectName(String projectName) {
		evidencesContentOfficeBodyElement.setCoverProjectName(projectName);
	}

	public void setCoverCycleName(String assignRcyc) {
		evidencesContentOfficeBodyElement.setCoverCycleName(assignRcyc);
	}

	public void setCoverDate(String execDate) {
		evidencesContentOfficeBodyElement.setCoverDate(execDate);
	}

	public void setHeaderUC(String ucName) {
		evidencesOfficeMasterStylesElement.setHeaderUC(ucName);		
	}

	public void setHeaderTC(String testInstanceName) {
		evidencesOfficeMasterStylesElement.setHeaderTC(testInstanceName);		
	}

	public void setHeaderDate(String execDate) {
		evidencesOfficeMasterStylesElement.setHeaderDate(execDate);		
	}

	public void setHeaderTime(String execTime) {
		evidencesOfficeMasterStylesElement.setHeaderTime(execTime);
	}

	public TextPElement getTOCPElement() {
		return evidencesContentOfficeBodyElement.getTocPElement();
	}
}

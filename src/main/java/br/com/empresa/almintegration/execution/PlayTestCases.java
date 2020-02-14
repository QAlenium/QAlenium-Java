package br.com.empresa.almintegration.execution;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runners.Suite.SuiteClasses;
//import org.odftoolkit.odfdom.converter.pdf.PdfConverter; --DESCOMENTAR A LINHA PARA CONVERTER PARA PDF
//import org.odftoolkit.odfdom.converter.pdf.PdfOptions; --DESCOMENTAR A LINHA PARA CONVERTER PARA PDF
import org.odftoolkit.odfdom.doc.OdfDocument;
import org.odftoolkit.odfdom.dom.element.office.OfficeTextElement;
import org.odftoolkit.odfdom.dom.element.table.TableTableElement;
import org.odftoolkit.odfdom.dom.element.text.TextPElement;
import org.odftoolkit.odfdom.pkg.OdfFileDom;
import org.odftoolkit.odfdom.pkg.OdfXMLFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.empresa.almintegration.alm.configuration.envModel.EnvSettings;
import br.com.empresa.almintegration.alm.configuration.settingsModel.Settings;
import br.com.empresa.almintegration.alm.infrastructure.Constants;
import br.com.empresa.almintegration.alm.model.RunStep;
import br.com.empresa.almintegration.alm.model.RunSteps;
import br.com.empresa.almintegration.alm.model.TestInstance;
import br.com.empresa.almintegration.alm.test.GetEntities;
import br.com.empresa.almintegration.constants.ConstantsServices;
import br.com.empresa.almintegration.constants.ViewConstants;
import br.com.empresa.almintegration.evidences.EvidencesWriter;
import br.com.empresa.almintegration.evidences.PDFConverter;
import br.com.empresa.almintegration.helper.CT;
import br.com.empresa.almintegration.helper.GeneralParser;
import br.com.empresa.almintegration.helper.LerArquivo;
import br.com.empresa.almintegration.helper.ReportMain;
import br.com.empresa.almintegration.helper.SendEmail;
import br.com.empresa.almintegration.helper.TestesServicos;
import br.com.empresa.almintegration.helper.Utils;
import br.com.empresa.almintegration.helper.imageutils.JSON2Image;
import br.com.empresa.almintegration.model.ServiceResponse;
import br.com.empresa.almintegration.suits.SUITdatabase_SPRINTxx_ESTORIAxx;
import br.com.empresa.almintegration.suits.SUITmainframe_SPRINTxx_ESTORIAxx;
import br.com.empresa.almintegration.suits.SUITmobile_SPRINTxx_ESTORIAxx;
import br.com.empresa.almintegration.suits.SUITweb_SPRINTxx_ESTORIAxx;
import br.com.empresa.almintegration.suits.SUITwebservice_SPRINTxx_ESTORIAxx;

public class PlayTestCases extends ReportMain {

	protected static String runId, targetCycle, currentUseCase, stepNumber;
	protected String evidencesPath;
	private static String testSetId;
	public String currentRunStepid;
	protected static ArrayList<TestInstance> til;
	private static ArrayList<String> testInstanceName, testInstancesId;
	protected static Constants c;
	protected static GetEntities g;
	public static HashMap<String, Result> result = new HashMap<String, Result>();
	public static Map<String, CT> ctsSuite = new HashMap<String, CT>();
	protected static List<RunStep> runStep = new ArrayList<RunStep>();
	protected RunStep currentRunStep;
	protected RunSteps runSteps;
	public static Settings settings;
	public static EnvSettings enviromentSettings;
	protected static int stepOrder;
	protected EvidencesWriter evidencesWriter;
	public ServiceResponse sr;
	public static br.com.empresa.almintegration.alm.configuration.almModel.Settings almSettings;
	private static Logger LOGGER = LoggerFactory.getLogger(PlayTestCases.class.getSimpleName());
	public String[] args = new String[]{"HMLEnv", "OLD"};

	public static void main(String[] args) throws Exception {

		LOGGER.info("[" + new Date() + "] Iniciando a automacao...");
		validateArgs(args);

		try {

			playSuit("testSetId from ALM", SUITweb_SPRINTxx_ESTORIAxx.class);
			playSuit("testSetId from ALM", SUITwebservice_SPRINTxx_ESTORIAxx.class);
			playSuit("testSetId from ALM", SUITmobile_SPRINTxx_ESTORIAxx.class);
			playSuit("testSetId from ALM", SUITmainframe_SPRINTxx_ESTORIAxx.class);
			playSuit("testSetId from ALM", SUITdatabase_SPRINTxx_ESTORIAxx.class);

		} finally {
			gerarRelatorio();
		}

	}

	private static void gerarRelatorio() throws Exception {

		String pathName = settings.getConfig().getPaths().getOutputDirBaseEvidences();

		if (!new File(pathName).exists()) {
			new File(pathName).mkdirs();
		}
		
		sendReportEmail(gerarRelatorioXls(PlayTestCases.class.getSimpleName()));

		Thread.sleep(10000);
		Utils.arquivarEvidencias(PlayTestCases.class.getSimpleName());

		Thread.sleep(6000);
		Utils.arquivarEvidenciasConsolidadas();
		
	}

	private static void sendReportEmail(String filePathAndName) throws AddressException, FileNotFoundException, MessagingException, IOException, URISyntaxException {
		new SendEmail().generateAndSendEmail(new File(filePathAndName), result);
		
	}

	private static void validateArgs(String[] args) {

		if(!args[0].equals(br.com.empresa.almintegration.constants.Constants.ENV_TI) && 
				!args[0].equals(br.com.empresa.almintegration.constants.Constants.ENV_HML) && 
					!args[0].equals(br.com.empresa.almintegration.constants.Constants.ENV_PRD)){
			LOGGER.error("Ambiente de execução não encontrado. Tente um dos ambientes válidos: TIEnv | HMLEnv | PRDEnv");
			throw new NullPointerException();
		}
		
		if(!args[1].equals(br.com.empresa.almintegration.constants.Constants.NEW) && 
				!args[1].equals(br.com.empresa.almintegration.constants.Constants.OLD)){
			LOGGER.error("Versão do ALM não encontrada. "
					+ "Tente uma das versões do ALM válidas: NEW | OLD."
					+ "\nAtenção: ao selecionar a opção NEW, todos os uploads serão realizados "
					+ "no projeto PJ07329_Cred_Release1.");
			throw new NullPointerException();
		}
		
		try{
			
			initSettings(args);
			
		} catch (JAXBException e) {
			LOGGER.error("Erro no XML: "+e.getMessage());
			throw new NullPointerException();
		}

	}

	public static void initSettings(String[] args) throws JAXBException {
		
		settings = new Utils().getSettings();
		settings.setEnv(args[0]);
		
		settings.getConfig().getALM().getProject()
		.setProject(args[1] == br.com.empresa.almintegration.constants.Constants.NEW
		? br.com.empresa.almintegration.constants.Constants.PROJECT_NEW
				: br.com.empresa.almintegration.constants.Constants.PROJECT_OLD);
		
		enviromentSettings = new Utils().getEnvSettings(settings);
		almSettings = new Utils().getALMConfigs(settings);
		
	}

	private static void init(String testSetId) throws Exception {

		PlayTestCases.testSetId = testSetId;
		c = new Constants();
		g = new GetEntities();
		String queryedJsonInstances = g.getJsonTestInstances(c.USERNAME, c.PASSWORD, "json", testSetId, true);
		String nonQueryedJsonInstances = g.getJsonTestInstances(c.USERNAME, c.PASSWORD, "json", testSetId, false);
		currentUseCase = g.getFieldListFromJson(g.getJsonUseCase(c.USERNAME, c.PASSWORD, "json", testSetId), "name")
				.get(0);

		LOGGER.info("[" + new Date() + "] Obtendo casos de teste do ALM referente ao caso de uso/estoria " + currentUseCase);

		targetCycle = g.getFieldListFromJson(queryedJsonInstances, "assign-rcyc").get(0);
		testInstancesId = g.getFieldListFromJson(nonQueryedJsonInstances, "id");
		testInstanceName = g.getFieldListFromJson(queryedJsonInstances, "name");
		til = new ArrayList<TestInstance>();

		// ------------------------------Add Test instances to the
		// list-------------------------------
		for (int i = 0; i < testInstancesId.size(); i++) {
			TestInstance testInstance = g.getTestInstance(c.USERNAME, c.PASSWORD, testInstancesId.get(i),
					ViewConstants.MIME.XML);
			testInstance.setTestInstanceName(testInstanceName.get(i));
			testInstance.setAssignRcyc(targetCycle);
			til.add(testInstance);
			LOGGER.info("[" + new Date() + "] Caso de teste ALM: " + testInstance.getTestInstanceName());
		}
	}

	public TestInstance getTestInstanceByTestCaseNumber(String testInstanceName) {

		try {
			for (TestInstance ti : PlayTestCases.til) {
				if (ti.getTestInstanceName().contains(testInstanceName)) {
					return ti;
				}
			}
		} catch (NullPointerException npe) {
			return null; // retorna null, pois a execucao esta sendo feita via
							// teste unitario
		}

		return null;
	}

	public ArrayList<String> getRunIdsList() {

		try {
			ArrayList<String> runStepsIdsList = new ArrayList<String>();

			for (RunStep runStep : runSteps.getRunStepsList()) {
				currentRunStepid = runStep.currentStepId;
				runStepsIdsList.add(currentRunStepid);
			}

			if (runStepsIdsList.size() < 1) {
				return null;
			}

			return runStepsIdsList;

		} catch (NullPointerException npe) {
			ArrayList<String> a = new ArrayList<String>();
			for(int i = 0; i<100; i++){
				a.add("retorno null "+ i);
			}
			return a; // retorna null, pois a execucao esta sendo feita via teste unitario
		} catch (Exception e) {
			// erro no g.getJsonRunSteps
		}

		return null;
	}

	public void updateRunStepStatus(String runStepId) throws Exception {

		String status = (currentRunStep.getField(RunStep.FIELDS.STATUS).equals(ConstantsServices.STATUS_PASSED))
				? "Passed" : "Failed";

		LOGGER.info("[" + new Date() + "] Atualizando status do STEP para " + status);

		if (status.contains("Failed"))
			CustomerTestCase.testFailed = true;

		try {
			g.updateEntity(c.USERNAME, c.PASSWORD, ViewConstants.MIME.XML, currentRunStep.currentStepId,
					ViewConstants.ALM.TestLab.RUN_STEPS, g.xmlUpdateStatus(status, "run-step").getBytes());

			LOGGER.info("[" + new Date() + "] STEP atualizado com sucesso");

		} catch (NullPointerException npe) {
			try {
				currentRunStep = new RunStep();
				currentRunStep.setField(RunStep.FIELDS.STEP_ORDER, String.valueOf(stepOrder));
				currentRunStep.setField(RunStep.FIELDS.STATUS, status);
				updateEvidencesDocument(CustomerTestCase.testFailed);
			} catch (NullPointerException npee) {
				// Nao encontrou o proximo passo. Isso nao e um problema, visto
				// que estamos recuperando o proximo passo antes de saber se ele
				// existe ou nao.
			}
			return;
		}

		try {
			currentRunStep = runSteps.getRunStepsList().get(stepOrder);
			currentRunStep.setField(RunStep.FIELDS.STEP_ORDER, String.valueOf(stepOrder));
			currentRunStep.setField(RunStep.FIELDS.STATUS, status);
			updateEvidencesDocument(CustomerTestCase.testFailed);
		} catch (NullPointerException npe) {
			// Nao encontrou o proximo passo. Isso nao e um problema, visto que
			// estamos recuperando o proximo passo antes de saber se ele existe
			// ou nao.
		}
	}

	public void updateRunStatus(boolean testFailed) throws Exception {
		String status = (testFailed) ? "Failed" : "Passed";

		LOGGER.info("[" + new Date() + "] Atualizando o status da RUN para " + status);

		try {
			g.updateEntity(c.USERNAME, c.PASSWORD, ViewConstants.MIME.XML, runId, ViewConstants.ALM.TestLab.RUNS,
					g.xmlUpdateStatus(status, "run").getBytes());

			LOGGER.info("[" + new Date() + "] Status da RUN atualizado com sucesso");

		} catch (NullPointerException npe) {
			return; // execucao de testes unitario
		}
	}

	protected void updateEvidencesDocument(boolean testFailed) throws Exception {
		try {
			String classe = this.getClass().getSimpleName();
			classe += (testFailed) ? ConstantsServices.FAIL : ConstantsServices.PASSED;
			
			//validaTipoDeTeste()
			
			JSON2Image json2Image = null;
			if (sr != null) {
				json2Image = new TestesServicos().createImagesFromServiceResponse(sr, currentRunStep.currentStepId,
						classe, stepOrder);
			}

			
			ArrayList<String> imagePath = json2Image.getImagesPath();

			currentRunStep.setField(RunStep.FIELDS.ATTACHMENT, imagePath.toString());
			currentRunStep.setField(RunStep.FIELDS.STEP_ORDER, String.valueOf(stepOrder));
			evidencesWriter.newTestStepTableElement(currentRunStep);

		} catch (NullPointerException npe) {
			String classe = this.getClass().getSimpleName();
			classe += (testFailed) ? ConstantsServices.FAIL : ConstantsServices.PASSED;
			JSON2Image json2Image = null;

			if (sr != null) {
				json2Image = new TestesServicos().createImagesFromServiceResponse(sr, currentRunStep.currentStepId,
						classe, stepOrder);
			}

			ArrayList<String> imagePath = json2Image.getImagesPath();
			evidencesWriter.newTestStepTableElement(currentRunStep);
			String classPath = Utils.getPath(classe);
			String filePath = settings.getConfig().getPaths().getEvidencia() + classPath;
			File file = new File(filePath);
			file.mkdir();
			String odtFilename = filePath + classe + ".odt";
			evidencesWriter.getTextDocument().save(odtFilename);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void finishEvidencesDocument(boolean testFailed) throws Exception {
		OutputStream out;

		try {
			if (testFailed)
				updateEvidencesDocument(testFailed);
			String classe = this.getClass().getSimpleName();

			classe += (testFailed) ? ConstantsServices.FAIL : ConstantsServices.PASSED;

			String classPath = Utils.getPath(classe);
			String filePath = settings.getConfig().getPaths().getEvidencia() + classPath;
			new File(filePath).mkdirs();
			String odtFilename = filePath + classe + ".odt";
			String pdfFilename = filePath + classe + ".pdf";
			evidencesWriter.save(odtFilename);

			PDFConverter pdfConverter = new PDFConverter(odtFilename, pdfFilename);

			Thread pdfConverterThread = new Thread(pdfConverter);
			pdfConverterThread.start();
			pdfConverterThread.join();

			OfficeTextElement officeTextElement = evidencesWriter.getTextDocument().getContentRoot();
			TextPElement tocPElement = evidencesWriter.getTOCPElement();
			TextPElement paragraph = (TextPElement) OdfXMLFactory
					.newOdfElement((OdfFileDom) officeTextElement.getOwnerDocument(), TextPElement.ELEMENT_NAME);
			paragraph.setStyleName(evidencesWriter.getLogoParagraphStyleName());
			officeTextElement.insertBefore(paragraph, tocPElement);

			TableTableElement coverPageTableElement = evidencesWriter.getCoverPageTableElement();
			for (int i = 0; i < 6; i++) {
				officeTextElement.insertBefore(officeTextElement.newTextPElement(), coverPageTableElement);
			}

			evidencesWriter.save(odtFilename);
			evidencesWriter.getTextDocument().close();

			LOGGER.info("[" + new Date() + "] Evidencias geradas.");

		} catch (NullPointerException npe) {

			// Testes unitarios
			updateEvidencesDocument(testFailed);
			String classe = this.getClass().getSimpleName();

			classe += ConstantsServices.UNIT_TEST;

			String classPath = Utils.getPath(classe);
			String filePath = settings.getConfig().getPaths().getEvidencia() + classPath;

			String odtFilename = filePath + classe + ".odt";
			String pdfFilename = filePath + classe + ".pdf";

			evidencesWriter.save(odtFilename);

			out = new FileOutputStream(pdfFilename);
			//PdfOptions options = PdfOptions.create(); --DESCOMENTAR A LINHA PARA CONVERTER PARA PDF
			OdfDocument odfDocument = OdfDocument.loadDocument(odtFilename);
			//PdfConverter.getInstance().convert(odfDocument, out, options); --DESCOMENTAR A LINHA PARA CONVERTER PARA PDF

			OfficeTextElement officeTextElement = evidencesWriter.getTextDocument().getContentRoot();
			TextPElement tocPElement = evidencesWriter.getTOCPElement();
			TextPElement paragraph = (TextPElement) OdfXMLFactory
					.newOdfElement((OdfFileDom) officeTextElement.getOwnerDocument(), TextPElement.ELEMENT_NAME);
			paragraph.setStyleName(evidencesWriter.getLogoParagraphStyleName());
			officeTextElement.insertBefore(paragraph, tocPElement);

			TableTableElement coverPageTableElement = evidencesWriter.getCoverPageTableElement();
			for (int i = 0; i < 6; i++) {
				officeTextElement.insertBefore(officeTextElement.newTextPElement(), coverPageTableElement);
			}

			evidencesWriter.save(odtFilename);
			evidencesWriter.getTextDocument().close();

			LOGGER.info("[" + new Date() + "] Evidencias geradas.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ServiceResponse getServiceResponse(String responseFromRequest, String endpoint,
			String evidenceContent, Object expectedResult, Object result, Class<?> clazz, String runId) {

		ServiceResponse sr = new ServiceResponse();
		sr.setResposeFromRequest(responseFromRequest);
		sr.setEndpoint(endpoint);
		sr.setEvidenceContent(evidenceContent);
		sr.setExpectedResult(expectedResult);
		sr.setResult(result);
		sr.setClazz(clazz);
		sr.setRunId(runId);

		return sr;
	}

	public static ServiceResponse getServiceResponse(String responseFromRequest, String endpoint,
			String evidenceContent, Object expectedResult, Object result, String message, Class<?> clazz,
			String runId) {

		ServiceResponse serviceResponse = getServiceResponse(responseFromRequest, endpoint, evidenceContent,
				expectedResult, result, clazz, runId);
		serviceResponse.setMessage(message);
		return serviceResponse;
	}

	public static ServiceResponse getServiceResponseWeb() {

		ServiceResponse sr = new ServiceResponse();
		sr.setRunId(runId);

		return sr;
	}

	/**
	 * Fabrica<BR>
	 *
	 * Relatorio de execucao em Excel<BR>
	 *
	 * @since 8 de jul de 2016 10:11:07
	 * @author Gabriel Aguido Fraga<BR>
	 * @throws Exception
	 */
	public static void putCTs(Class<?> classe) throws Exception {

		Annotation[] annotations = classe.getAnnotations();

		try {
			for (Annotation annotation : annotations) {
				if (annotation instanceof SuiteClasses) {
					SuiteClasses suiteClasses = (SuiteClasses) annotation;
					for (Class<?> bean : suiteClasses.value()) {
						String pathClasse = bean.getName();
						String nomeClasse = pathClasse.substring(pathClasse.lastIndexOf('.') + 1)
								.replaceAll("[^a-zA-Z0-9_]", "");
						ctsSuite.put(nomeClasse, obterCTProperties(nomeClasse, classe.getSimpleName()));
						LOGGER.info("[" + new Date() + "] Caso de teste FRAMEWORK: " + nomeClasse);
					}
				}
			}
		} catch (Exception e) {

			LOGGER.info("[" + new Date() + "] Erro ao executar putCTs: \n" + e);
			throw new Exception("Erro ao executar putCTs: ", e);
		}
	}

	/**
	 * Fabrica<BR>
	 *
	 * Relatorio de execucao em Excel<BR>
	 *
	 * @since 8 de jul de 2016 15:01:16
	 * @author Gabriel Aguido Fraga<BR>
	 * @throws Exception
	 */
	private static CT obterCTProperties(String classe, String modulo) throws Exception {

		String property = Utils.carregarIdentificadoresCTs().getProperty(classe);

		// // Caso tenha classe com mesmo nome em pacote diferente, faz o
		// mapeamento
		// if (StringUtils.isNotEmpty(property)) {
		//
		// if (! property.split(";")[3].equalsIgnoreCase(modulo)) {
		//
		// property = "";
		// }
		// }

		// Faz o mapeamento pela primeira vez
		if (StringUtils.isBlank(property)) {

			property = classe + "=ID;" + classe + ";TIPO;" + modulo + ";CT;ADICIONADO AUTOMATICAMENTE";

			LerArquivo.adicionarLinhaNoArquivo(property, br.com.empresa.almintegration.constants.Constants.CTS);
		}
		return GeneralParser.parseToCT(property);
	}

	/**
	 * Fabrica<BR>
	 *
	 * Relatorio de execucao em Excel<BR>
	 *
	 * @since 8 de jul de 2016 10:11:07
	 * @author Gabriel Aguido Fraga<BR>
	 * @throws Exception
	 */
	public ArrayList<String> getTBNames(HashMap<String, Result> result) throws Exception {

		ArrayList<String> tbs = new ArrayList<String>();

		for (String classe : result.keySet()) {
			String[] split = classe.split("_");
			;
			tbs.add(split[0] + "_" + split[1]);
		}
		HashSet<String> hs = new HashSet<String>();
		hs.addAll(tbs);
		tbs.clear();
		tbs.addAll(hs);

		Collections.sort(tbs.subList(1, tbs.size()));

		return tbs;
	}

	private static void playSuit(String testSetId, Class<?> suitClass) throws Exception{
		
		init(testSetId);
		putCTs(suitClass);
		Result suitWeb = JUnitCore.runClasses(suitClass);
		result.put(suitClass.getSimpleName(), suitWeb);
		
	}
	
}
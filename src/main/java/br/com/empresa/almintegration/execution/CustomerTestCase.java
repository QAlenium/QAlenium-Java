package br.com.empresa.almintegration.execution;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.empresa.almintegration.alm.model.Run;
import br.com.empresa.almintegration.alm.model.RunStep;
import br.com.empresa.almintegration.alm.model.TestInstance;
import br.com.empresa.almintegration.constants.ConstantsServices;
import br.com.empresa.almintegration.constants.ViewConstants;
import br.com.empresa.almintegration.evidences.EvidencesWriter;
import br.com.empresa.almintegration.helper.Utils;

public class CustomerTestCase extends PlayTestCases {

	protected static final Object BREAKLINE = "\r\n";
	protected static final Object TAB = "\t";
	TestInstance currentTestInstance = null;	
	Run currentTestRun = null;
	protected static boolean testFailed;
	private static Logger LOGGER = LoggerFactory.getLogger(CustomerTestCase.class.getSimpleName());

	@Before
	public void antesTeste() throws Exception{
		
		initSettings(args);
		stepOrder = 0;
		String classe = this.getClass().getSimpleName();

		LOGGER.info("["+new Date()+"] Executando: " + classe);
		
		try{
			TestInstance testInstance = getTestInstanceByTestCaseNumber("CT"+this.getClass().getSimpleName().split("_CT")[1]);
			currentTestRun = g.createNewRun(c.USERNAME, c.PASSWORD, testInstance.getId());
			runId = currentTestRun.getField(Run.FIELDS.ID);
			runSteps = g.getRunSteps(c.USERNAME, c.PASSWORD, runId);
			/*TestParameters testParameters = g.getTestParameters(c.USERNAME, c.PASSWORD, "xml", testInstance.getTestID());
			for (TestParameter testParameter : testParameters.getRunStepsList()) {
				System.out.println(testParameter.toString());
			}*/
			for (TestInstance ti : CustomerTestCase.til) {
				int length = classe.length();
				if(ti.getTestInstanceName().contains(classe.substring(length - 5, length))){
					currentTestInstance =  ti;
					break;
				}
			}

			try{
				currentRunStep = runSteps.getRunStepsList().get(stepOrder);
				currentRunStep.setField(RunStep.FIELDS.STEP_ORDER, String.valueOf(1));
			} catch (NullPointerException npe) {
				// Nao encontrou o proximo passo. Isso nao e um problema, visto que estamos recuperando o proximo passo antes de saber se ele existe ou nao.
			}

			evidencesWriter = EvidencesWriter.getInstance();
			evidencesWriter.createEvidencesDocument(currentTestInstance);
			evidencesWriter.setHeaderUC(currentUseCase);
			evidencesWriter.setCoverProjectName(g.project);

		} catch (Exception npe) {
			//ignora para ser executada de forma unitária. variável 'g' está nula
			currentRunStep = new RunStep();
			evidencesWriter = EvidencesWriter.getInstance();
			evidencesWriter.createEvidencesDocument(currentTestInstance);
			evidencesWriter.setHeaderUC("CURRENT USE CASE");
			evidencesWriter.setCoverProjectName("PROJECT");
		}
	}

	@After
	public void depoisTeste() throws Exception {

		LOGGER.info("["+new Date()+"] Teste finalizado. Gerando evidencias...");
		
		finishEvidencesDocument(testFailed);
		try {

			updateRunStatus(testFailed);
			String classe = this.getClass().getSimpleName();

			classe += (testFailed) ? ConstantsServices.FAIL : ConstantsServices.PASSED;

			try {
				String classPath = Utils.getPath(classe);
				String filePath = settings.getConfig().getPaths().getEvidencia() + classPath;
				String odtFilename = filePath + classe + ".odt";
				//String pdfFilename = filePath + classe + ".pdf";
				g.uploadAttachments(c.USERNAME, c.PASSWORD, runId, ViewConstants.ALM.TestLab.RUNS, odtFilename);
				//g.uploadAttachments(c.USERNAME, c.PASSWORD, runId, ViewConstants.ALM.TestLab.RUNS, pdfFilename);
				
				LOGGER.info("["+new Date()+"] Upload de evidencias realizado para o ALM.");
				
			} catch (NullPointerException npe) {
				// nao sobe evidencias via teste unitario
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
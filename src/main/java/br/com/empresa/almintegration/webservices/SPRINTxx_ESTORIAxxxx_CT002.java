package br.com.empresa.almintegration.webservices;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.empresa.almintegration.alm.model.RunStep;
import br.com.empresa.almintegration.execution.CustomerTestCase;
import net.thucydides.core.annotations.Step;

public class SPRINTxx_ESTORIAxxxx_CT002 extends CustomerTestCase {

	private String endpoint;
	private String cep = "06408200";
	private StringBuilder RESPONSE = new StringBuilder();
	private HttpResponse response;

	@Before
	public void beforeTest() throws Exception {
		endpoint = "http://correiosapi.apphb.com/cep/" + cep;
	}

	@Test
	public void testExample() throws Exception {
		step1();
		updateRunStepStatus(getRunIdsList().get(stepOrder++));
		step2();
		updateRunStepStatus(getRunIdsList().get(stepOrder++));
	}

	@Step("Realizar request no serviço dos correios (cep)")
	public void step1() {
		try {
			HttpGet get = new HttpGet(endpoint);
			HttpClient dhc = new DefaultHttpClient();

			response = null;
			try {
				response = dhc.execute(get);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";

			while ((line = rd.readLine()) != null) {
				RESPONSE.append(line).append("\n");
			}

			sr = getServiceResponse(null, endpoint, cep, 200, null,
					getClass(), runId);
			currentRunStep.setField(RunStep.FIELDS.STATUS, "Passed");
		} catch (Exception e) {
			currentRunStep.setField(RunStep.FIELDS.STATUS, "Failed");
		}
	}

	@Step("Receber response do serviço dos correios")
	public void step2() {
		try {

			sr = getServiceResponse(RESPONSE.toString(), endpoint, cep, 200, response.getStatusLine().getStatusCode(),
					getClass(), runId);
			currentRunStep.setField(RunStep.FIELDS.STATUS, "Passed");
		} catch (Exception e) {
			currentRunStep.setField(RunStep.FIELDS.STATUS, "Failed");
		}
	}

	@After
	public void afterTest() {
		sr = getServiceResponse(RESPONSE.toString(), endpoint, cep, 200, response.getStatusLine().getStatusCode(),
				getClass(), runId);
	}

}

package br.com.empresa.almintegration.mainframe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.empresa.almintegration.alm.model.RunStep;
import br.com.empresa.almintegration.execution.CustomerTestCase;
import br.com.empresa.almintegration.testing.mainframe.net.sf.f3270.FieldIdentifier;
import br.com.empresa.almintegration.testing.mainframe.net.sf.f3270.Terminal;
import net.thucydides.core.annotations.Step;

public class SPRINTxx_ESTORIAxxxx_CT004 extends CustomerTestCase {

	@Before
	public void antes(){
		connect();
	}

	@Test
	public void testIpAustralia() throws Exception {
		step1();
		updateRunStepStatus(getRunIdsList().get(stepOrder++));
		step2();
		updateRunStepStatus(getRunIdsList().get(stepOrder++));
		step3();
		updateRunStepStatus(getRunIdsList().get(stepOrder++));
		step4();
		updateRunStepStatus(getRunIdsList().get(stepOrder++));
		step5();
		updateRunStepStatus(getRunIdsList().get(stepOrder++));
		step6();
		updateRunStepStatus(getRunIdsList().get(stepOrder++));
		step7();
		updateRunStepStatus(getRunIdsList().get(stepOrder++));
	}

	@After
	public void depois(){
		disconnect();
	}

	@Step("Acessar a janela principal do mainframe")
	public void step1(){
		try{
			assertText(terminal, "A U S T R A L I A");
			
			currentRunStep.setField(RunStep.FIELDS.STATUS, "Passed");
		} catch (Exception e) {
			currentRunStep.setField(RunStep.FIELDS.STATUS, "Failed");
		}
	}

	@Step("Acessar a janela do disclaimer")
	public void step2(){

		try{
			terminal.enter();
			assertText(terminal, "DISCLAIMER");

			currentRunStep.setField(RunStep.FIELDS.STATUS, "Passed");
		} catch (Exception e) {
			currentRunStep.setField(RunStep.FIELDS.STATUS, "Failed");
		}

	}

	@Step("Acessar a janela do Menu")
	public void step3(){

		try{
			terminal.enter();
			assertText(terminal, "Menu"); //Logon in progress...
			sleep(100);
			
			currentRunStep.setField(RunStep.FIELDS.STATUS, "Passed");
		} catch (Exception e) {
			currentRunStep.setField(RunStep.FIELDS.STATUS, "Failed");
		}

	}

	@Step("Digitar em 'command' o valor '1' e pressionar 'enter'")
	public void step4(){

		try{
			terminal.enter();
			assertEquals(Boolean.TRUE, (Boolean)terminal.screenHasLabel(new FieldIdentifier("command")));
			assertEquals(Boolean.FALSE, (Boolean)terminal.screenHasLabel(new FieldIdentifier("rubbish_label")));
			terminal.write(new FieldIdentifier("command"), "1");
			terminal.read(new FieldIdentifier("command"));
			terminal.enter();
			
			currentRunStep.setField(RunStep.FIELDS.STATUS, "Passed");
		} catch (Exception e) {
			currentRunStep.setField(RunStep.FIELDS.STATUS, "Failed");
		}

	}

	@Step("Acessar a proxima página pressionando 'enter' novamente")
	public void step5(){

		try{
			terminal.enter();

			currentRunStep.setField(RunStep.FIELDS.STATUS, "Passed");
		} catch (Exception e) {
			currentRunStep.setField(RunStep.FIELDS.STATUS, "Failed");
		}

	}

	@Step("Digitar em 'command' o valor '2' e pressionar 'enter'")
	public void step6(){

		try{
			terminal.write(new FieldIdentifier("command"), "2");
			terminal.enter();

			currentRunStep.setField(RunStep.FIELDS.STATUS, "Passed");
		} catch (Exception e) {
			currentRunStep.setField(RunStep.FIELDS.STATUS, "Failed");
		}

	}

	@Step("Digitar no campo de trade mark number o valor '123'")
	public void step7(){

		try{
			terminal.write(new FieldIdentifier("trade mark number"), "123");
			terminal.read(new FieldIdentifier("trade mark number"));

			currentRunStep.setField(RunStep.FIELDS.STATUS, "Passed");
		} catch (Exception e) {
			currentRunStep.setField(RunStep.FIELDS.STATUS, "Failed");
		}

	}


//========================================================================================


	public String getHostname() {
		return "pericles.ipaustralia.gov.au";
	}

	public Mode getMode() {
		return Mode.REPLAY;
	}

	private void assertText(Terminal terminal, String text) {
		assertTrue("screen doesn't contain " + text, terminal.getScreenText().contains(text));
	}

}

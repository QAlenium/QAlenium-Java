package br.com.empresa.almintegration.testing.tn3270.applications.tiv25e01;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.empresa.almintegration.testing.tn3270.Mainframe;
import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.Field;
import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.InputField;


public class TIV25E01MN01 {
	
	public static enum Transactions {		
		AE50("MANUTENCAO STATUS CRD"), AE51("CONSULTA HISTORICO STATUS CRD"), ANMN, AT00, AT45, 
		ATP0, BMS0, MN00, MN01, RJ00, 
		SG23, TB00, TB30, TB31, TB32;
		private String description;
		Transactions(){}
		Transactions(String description){
			this.description = description;
		}
		public String getDescription(){
			return this.description;
		}
	}

	public TIV25E01MN01() {
		
	}
	
	public static Boolean goToTransaction(Transactions transaction){
		Mainframe mainframe = Mainframe.getInstance();
		List<Field> transactions = mainframe.getS3270().getScreen().getFields();
		int transactionInputFieldIndex = 0;
		for (int i = 0; i < transactions.size(); i++)
			if (transactions.get(i).getText().trim().equals(transaction.name()))
				transactionInputFieldIndex = i - 2;
		((InputField) transactions.get(transactionInputFieldIndex)).setValue("X");
		mainframe.enter();
		Field title = mainframe.getS3270().getScreen().getFields().get(6);
		String titleText = title.getText().trim();
		String description = transaction.getDescription();
		return titleText.equals(description);
	}
}

package br.com.empresa.almintegration.testing.tn3270.applications.tiv25e01.atp9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.empresa.almintegration.testing.tn3270.applications.IMainframeScreenFields;
import br.com.empresa.almintegration.testing.tn3270.applications.MainframeFormScreens;

public class DetalhesProduto extends MainframeFormScreens {
	
	public enum DETALHES_PRODUTO_FIELDS implements IMainframeScreenFields {
		PRAZO, TIPO_DE_COBRANCA, TAXA_DE_COMISSAO, TARIFA_POR_ITEM, PRAZO_FLEXIVEL, TAXA_PRAZO_FLEXIVEL, // FATOR_1,
																											// FATOR_2,
		QUANTIDADE_DE_PARCELAS, TRANSAÇAO_DIGITADA, DATA_MANUTENCAO, HORA_MANUTENCAO, USUARIO, MARKUP_CLIENTE, PERCENTUAL_REDUTOR_MDR;

		private String fieldValue;
		private String fieldLabel;

		DETALHES_PRODUTO_FIELDS() {
			
		}

		@Override
		public String getFieldLabel() {
			return fieldLabel;
		}

		@Override
		public String getFieldValue() {
			return fieldValue;
		}

		@Override
		public void setFieldValue(String fieldValue) {
			this.fieldValue = fieldValue;
		}
	}
	
	private void populateFields(){
		int startLine = 8;
		for (DETALHES_PRODUTO_FIELDS field : DETALHES_PRODUTO_FIELDS.values()) {
			
			String line = mf.getLine(startLine++);
			String regex = "[A-Z .]*:\\s*(.*)";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(line);
			if (matcher.find()){
				String value = matcher.group(1).trim();
				setFieldValue(field, value);
				System.out.println(field.name() + ": " + field.fieldValue);
			}
		}
	}
	
	public DetalhesProduto() {
		populateFields();
	}

}

package br.com.empresa.almintegration.testing.tn3270.applications.k100.g110;

import br.com.empresa.almintegration.testing.tn3270.applications.MainframeFormScreens;
import br.com.empresa.almintegration.testing.tn3270.net.sf.f3270.FieldIdentifier;

public class G110 extends MainframeFormScreens{
	
	public enum G110_OPTIONS{
		Inclusao(I),Atualizacao(A),Edicao(E),Consulta(C);
		String opcao;
		G110_OPTIONS(String opcao){
			this.opcao = opcao;
		}
	};
	
	public enum G110_MESSAGES{
		CONSULTA_EFETUADA("OK. CONSULTA EFETUADA.");
		private String message;

		G110_MESSAGES(String message) {
			this.message = message;
		}

		public String getMessage() {
			return this.message;
		}
	}

	public static enum G110_FIELDS{
		OPCAO,          TERMINAL,       TIPO_TERMINAL,  DATA_INCLUSAO,  ALTERACAO, 
		SITUACAO,       DT_INICIACAO,   HR_INIC,        INS,            AG_INI, 
		COD_ESTABELEC,  ENDERECO,       GRP_IMG,        CODIGO_NO,      SERV, 
		TELCG,          ATZ_PAG,        NO_MOBILE,      IND_SOL,        DT_SOL, 
		HR,             VERSAO_APLIC,   TIPO_IMP,       MULTI_EC,       CONTEXTO_GPRS, 
		BLOQUEADO,      SOL_PSW_CANCEL, SEM_CONTATO,    EXIBE_MENU,     HAB_FONTE_DUPL, 
		SO_SERVICO_EXT, CAIXA_RAPIDO,   TEM_TECLADO,    ENV_1A6_NO_B47, EXIBE_CNPJ_CPF, 
		TRILHA,         ENV_7_NO_B47,   INVERSAO_FLUXO, CHIP,           ENV_DESFAZ_ONL;
		private String fieldLabel;
		private String fieldValue;

		G110_FIELDS() {
			String propertyName = this.getClass().getSimpleName() + UNDERSCORE + this.name();
			this.fieldLabel = properties.getProperty(propertyName, propertyName);
		}

		public String getFieldLabel() {
			return fieldLabel;
		}

		public String getFieldValue() {
			fieldValue = (successfulQuery()) ? mf.getFieldValues(new FieldIdentifier(getFieldLabel())) : null;
			return fieldValue;
		}

		public void setFieldValue(String fieldValue) {
			this.fieldValue = fieldValue;
		}
	}
	
	public static boolean successfulQuery(){
		return mf.getScreenText().contains(G110_MESSAGES.CONSULTA_EFETUADA.getMessage());
	}

	public static void populateFields() {
		for (G110_FIELDS field : G110_FIELDS.values()) {
			field.setFieldValue(
			mf.getFieldValues(new FieldIdentifier(field.getFieldLabel())));
		}
	}

	public static void setTerminalField(String terminal){
		setFieldValue(new FieldIdentifier(G110_FIELDS.TERMINAL.getFieldLabel()), terminal);
	}

	public static void setOptionField(G110_OPTIONS option) {
		setFieldValue(new FieldIdentifier(G110_FIELDS.OPCAO.getFieldLabel()), option.opcao);
	}

	public static void setTipoTerminalField(String terminalType){
		setFieldValue(new FieldIdentifier(G110_FIELDS.TIPO_TERMINAL.getFieldLabel()), terminalType);
	}
}

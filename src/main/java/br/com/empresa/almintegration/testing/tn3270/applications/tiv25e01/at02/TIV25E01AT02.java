package br.com.empresa.almintegration.testing.tn3270.applications.tiv25e01.at02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.empresa.almintegration.testing.tn3270.ScreenFields;
import br.com.empresa.almintegration.testing.tn3270.applications.IMainframeScreenFields;
import br.com.empresa.almintegration.testing.tn3270.applications.MainframeFormScreens;
import br.com.empresa.almintegration.testing.tn3270.applications.tiv25e01.MainframeMessages;
import br.com.empresa.almintegration.testing.tn3270.net.sf.f3270.FieldIdentifier;
import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.InputField;

public class TIV25E01AT02 extends MainframeFormScreens{
	
	private ScreenFields screenFields;
	private Pagamento pagamento;
	private HashMap<String, ArrayList<TipoPagamento>> pagamentos;
	ArrayList<Produto> produtos = new ArrayList<Produto>();

	public enum AT02_MESSAGES implements MainframeMessages {
		CONSULTA_EFETUADA("44-SELECIONE O PRODUTO OU POSICIONE O CURSOR E TECLE <ENTER>"),
		SISTEMA_INDISPONIVEL("46-ARQUIVO MMIDXKS INDISPONIVEL");
		private String message;
		private AT02_MESSAGES(String message) {
			this.message = message;
		}
		public String getMessage(){
			return message;
		}
	}

	public enum AT02_FIELDS implements IMainframeScreenFields{
		PAG_ATUAL, TOTAL_PAG,   MATRIZ, PRIN,    ASS, 
		CADEIA,    STATUS_EC,   ESTAB,  NOME,    CIA;
		private String fieldLabel;
		private String fieldValue;
		private AT02_FIELDS() {
			String propertyName = this.getClass().getSimpleName() + UNDERSCORE + this.name();
			this.fieldLabel = properties.getProperty(propertyName, propertyName);
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
	
	public TIV25E01AT02() {
		populateFields();
	}

	public void populateFields()
	{
		System.out.println("=============== Campos da Tela ================");
		screenFields = new ScreenFields();
		
		System.out.println("=============== Campos do componente ================");
		for (AT02_FIELDS field : AT02_FIELDS.values()) {
			field.setFieldValue(mf.getFieldValues(new FieldIdentifier(field.getFieldLabel())));
			System.out.println(field.fieldLabel + ": " + field.fieldValue);
		}
		
		pagamentos = new HashMap<String, ArrayList<TipoPagamento>>();

		System.out.println("=============== Tipos de Pagamento ================");
		int i = 30;
		String screenText = mf.getS3270().getScreen().getFields().get(i).getValue();
		while (!(screenText.startsWith("EC"))) {
			String tipoPagamento = null;
			String regex = "PAGTO\\.:\\s(.[^\\s]*)\\s";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(screenText);
			if(matcher.find())
				tipoPagamento = matcher.group(1);
			ArrayList<TipoPagamento> tiposPagamentos = new ArrayList<TipoPagamento>();
			do {
				TipoPagamento tp = new TipoPagamento(screenText);
				tiposPagamentos.add(tp);
			} while (startWithSpace((screenText = mf.getS3270().getScreen().getFields().get(++i).getValue())));
			pagamentos.put(tipoPagamento, tiposPagamentos);
		}
		int y = 0;
		System.out.println("=============== Pagamento ================");
		pagamento = new Pagamento();
		System.out.println("=============== Produtos ================");
		produtos = new ArrayList<Produto>();
		while(!mf.getLine(y++).trim().substring(0, 3).equals("COD")) mf.getLine(y).trim().substring(0, 3);
		int currentPage = Integer.parseInt(screenFields.getFieldValue(ScreenFields.FIELDS.CURRENT_PAGE));
		int lastPage = Integer.parseInt(screenFields.getFieldValue(ScreenFields.FIELDS.LAST_PAGE));
		int previousY = y;
		while(currentPage <= lastPage){
			while(!mf.getLine(y).trim().equals("")) {
				String line = mf.getLine(y);
				Produto produto = new Produto(line, y++, currentPage);
				produtos.add(produto);
			}
			mf.pf(8);
			currentPage++;
			screenFields.setFieldValue(ScreenFields.FIELDS.CURRENT_PAGE, String.valueOf(currentPage));

			y = previousY;
		}
	}

	public static boolean successfulQuery(){
		return mf.getScreenText().contains(AT02_MESSAGES.CONSULTA_EFETUADA.getMessage());
	}

	public static void setEstabValue(String estabComercial){
		setFieldValue(new FieldIdentifier(AT02_FIELDS.ESTAB.getFieldLabel()), estabComercial);
	}

	public Pagamento getPagamento() {
		return pagamento;
	}
	
	public void gotoATP9(Produto produto){
		String regex = "PAG\\.:\\s([0-9]{3})\\s\\/\\s([0-9]{3})";
		String line = mf.getLine(2);
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(line);
		if (matcher.find()) {
			int currentPage = Integer.parseInt(matcher.group(1));
			int page = produto.getPage();
			int pf = (page > currentPage) ? 8 : 7;
			while (currentPage != page) {
				mf.pf(pf);
				line = mf.getLine(2);
				matcher = pattern.matcher(line);
				if (matcher.find()) currentPage = Integer.parseInt(matcher.group(1));
			}
			
			InputField controle = mf.getS3270().getScreen().getInputFieldAt(1, produto.getY());
			controle.setFocused(true);
			mf.enter();
		}
	}

	public ScreenFields getScreenFields() {
		return screenFields;
	}

	public HashMap<String, ArrayList<TipoPagamento>> getPagamentos() {
		return pagamentos;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
}


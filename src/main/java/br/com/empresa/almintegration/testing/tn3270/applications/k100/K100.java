package br.com.empresa.almintegration.testing.tn3270.applications.k100;

import java.util.ArrayList;
import java.util.List;

import br.com.empresa.almintegration.testing.tn3270.Mainframe;
import br.com.empresa.almintegration.testing.tn3270.Mensagem;
import br.com.empresa.almintegration.testing.tn3270.net.sf.f3270.FieldIdentifier;
import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.Field;
import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.InputField;
import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.S3270Screen;

public class K100 {
	
	private static Mainframe mainFrame = Mainframe.getInstance();
	private static String servicoLabel = "SERVICO";
	private static FieldIdentifier servicoIdentifier = new FieldIdentifier(servicoLabel);
	
	private static String tamLabel = "TAM";
	private static FieldIdentifier tamIdentifier = new FieldIdentifier(tamLabel);
	
	private static String comandoLabel = "COMANDO";
	private static FieldIdentifier comandoIdentifier = new FieldIdentifier(comandoLabel);
	
	private static String converteLabel = "CONVERTE";
	private static FieldIdentifier converteIdentifier = new FieldIdentifier(converteLabel);
	
	/**
	 * @return servico.
	 */
	public static Field getServico() {
		return mainFrame.getField(servicoIdentifier);
	}
	/**
	 * @param servicoIdentifier the servicoIdentifier to set
	 */
	public static void setServicoIdentifier(String servico) {
		mainFrame.write(servicoIdentifier, servico);
	}
	
	/**
	 * @return Tamanho
	 */
	public static Field getTamIdentifier() {
		return mainFrame.getField(tamIdentifier);
	}
	/**
	 * @param tamIdentifier the tamIdentifier to set
	 */
	public static void setTamIdentifier(int tam) {
		mainFrame.write(tamIdentifier, Integer.toString(tam));
	}

	/**
	 * @return the comandoIdentifier
	 */
	public static Field getComandoIdentifier() {
		return mainFrame.getField(comandoIdentifier);
	}
	/**
	 * @param comandoIdentifier the comandoIdentifier to set
	 */
	public static void setComandoIdentifier(String comando) {
		mainFrame.write(comandoIdentifier, comando);
	}
	/**
	 * @return the converteIdentifier
	 */
	public static Field getConverteIdentifier() {
		return mainFrame.getField(converteIdentifier);
	}
	/**
	 * @param converteIdentifier the converteIdentifier to set
	 */
	public static void setConverteIdentifier(String converte) {
		mainFrame.write(converteIdentifier, converte);
	}


	public static boolean entraMensagem(String servico, String comando, Mensagem mensagem){
		setServicoIdentifier(servico);
		setTamIdentifier(mensagem.toString().length());
		setComandoIdentifier(comando);
		List<String> mensagemRepartida = repartirMensagem(mensagem.toString());
		List<Field> messageFields = mainFrame.getS3270().getScreen().getFields().subList(13, 27);
		int i = 0;
		for (Field field : messageFields) {
			InputField inputField = (InputField) field;
			if (i < mensagemRepartida.size()){
				String inputMessage = mensagemRepartida.get(i++);
				inputField.setValue(inputMessage);
			}
		}
		setComandoIdentifier(comando); // pq isso? de outra forma ele no mostra a mensagem de entrada. Bug??
		mainFrame.enter();
		Mensagem mensagemRetorno = recuperaMensagem();
		return (mensagem.toString().length() == mensagemRetorno.toString().length()) ? true : false;
	}
	
	public static Mensagem recuperaMensagem(){
		Mensagem mensagem;
		String output="";
		S3270Screen screen = (S3270Screen)mainFrame.getS3270().getScreen();
		List<Field> fields = screen.getFields();
		List<Field> messageFields = fields.subList(13, 27);
		for (Field field : messageFields) {
			InputField inputField = (InputField) field;
			output = output.concat(inputField.getValue());
		}
		output = output.trim();
		mensagem = new Mensagem(output);
		return mensagem;
	}
	
	public static List<String> repartirMensagem(String mensagem) {
	    List<String> ret = new ArrayList<String>((mensagem.length() + 79 - 1) / 79);
	    for (int start = 0; start < mensagem.length(); start += 79) {
	        ret.add(mensagem.substring(start, Math.min(mensagem.length(), start + 79)));
	    }
	    return ret;
	}
}

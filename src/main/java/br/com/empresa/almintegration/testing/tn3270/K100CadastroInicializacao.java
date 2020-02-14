package br.com.empresa.almintegration.testing.tn3270;
import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.InputField;
public class K100CadastroInicializacao {

	public static enum K100_SCREENS {G110, G120};
	
	public static boolean goToScreen(K100_SCREENS screen){
		Mainframe mf = Mainframe.getInstance();
		((InputField)mf.getS3270().getScreen().getFields().get(1)).setValue(screen.name());
		mf.enter();
		return mf.getS3270().getScreen().getFields().get(1).getValue().equals(screen.name());
	}
}

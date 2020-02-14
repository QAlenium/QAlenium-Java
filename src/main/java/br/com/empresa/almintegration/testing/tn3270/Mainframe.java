package br.com.empresa.almintegration.testing.tn3270;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import org.imgscalr.Scalr;

import br.com.empresa.almintegration.constants.ViewConstants;
import br.com.empresa.almintegration.helper.Utils;
import br.com.empresa.almintegration.testing.tn3270.net.sf.f3270.FieldIdentifier;
import br.com.empresa.almintegration.testing.tn3270.net.sf.f3270.Terminal;
import br.com.empresa.almintegration.testing.tn3270.net.sf.f3270.TerminalObserver;
import br.com.empresa.almintegration.testing.tn3270.net.sf.f3270.TerminalWindowObserver;
import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.Field;
import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.S3270.TerminalMode;
import br.com.empresa.almintegration.testing.tn3270.org.h3270.host.S3270.TerminalType;

public class Mainframe extends Terminal {
	 
	private static boolean showTerminalWindow = true;
	private static int port = 992;
	private static TerminalType type = TerminalType.TYPE_3278;
	// private static String hostname =  "192.168.130.29"; // redes;
	// private static String hostname =  "10.90.7.46";// inte;
	private static String hostname =  "10.90.7.122"; // redes;			
	private static String s3270Path = "s3270/cygwin/s3270.exe";
	private static TerminalMode mode = TerminalMode.MODE_80_24;

	protected Mainframe(String s3270Path, String hostname, int port, TerminalType type, TerminalMode mode,
			boolean showTerminalWindow) {
		super(s3270Path, hostname, port, type, mode, showTerminalWindow);
	}
	
	private static final Mainframe instance = new Mainframe(s3270Path, hostname, port, type, mode, showTerminalWindow);
	private static final String DOT = ".";
	
	// Runtime initialization
		// By default ThreadSafe
	public static Mainframe getInstance() {
		return instance;
	}
	
	public String getFieldValues(FieldIdentifier fieldIdentifier) {
		final String SPACE = " ";
		Field field = this.getField(fieldIdentifier);
		List<Field> allFields = this.getS3270().getScreen().getFields();
		List<Field> subList = allFields.subList(allFields.indexOf(field) + 1, allFields.size());
		StringBuffer value = new StringBuffer().append(field.getValue());
		if(subList.size() > 0) {
			int i = 0;
			Field nextField = subList.get(i++);
			for(;nextField.getDisplayMode() == 1;nextField = subList.get(i++)) value.append(nextField.getValue() + SPACE);
		}
		return value.toString().trim();
    }

	public String getMainframeScreenshot(String stepId) {
	    Component component = getMainframeJFrame();
		Rectangle rect = component.getBounds();
		String fileName = null;
  		try {
  			BufferedImage captureImage =
  					new BufferedImage(rect.width, rect.height,
  							BufferedImage.TYPE_4BYTE_ABGR);
  			component.paint(captureImage.getGraphics());
  			
			BufferedImage scalledImage = Scalr.resize(captureImage, 600, 565);

			Properties links = Utils.carregarLinks();
  			String filePath = links.getProperty(ViewConstants.Properties.EVIDENCIA_PATH);
  	        fileName = filePath + stepId + DOT + ViewConstants.MIME.PNG;
  			
  			ImageIO.write(scalledImage, ViewConstants.MIME.PNG, new File(fileName)); 			
  					
  		} catch (IOException ex) {
			System.err.println(ex);
		} catch (NullPointerException e) {
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		return fileName;
	}
	
	private Component getMainframeJFrame() {
		Collection<TerminalObserver> terminalObservers = this.getTerminalObservers();
		TerminalWindowObserver windowObserver = null;
		for (TerminalObserver terminalObserver : terminalObservers) {
			if(terminalObserver.getClass().equals(TerminalWindowObserver.class)){
				windowObserver = (TerminalWindowObserver) terminalObserver;
			}
		}
		JFrame frame = windowObserver.getTerminalWindow().getFrame();
		return frame;
	}
}

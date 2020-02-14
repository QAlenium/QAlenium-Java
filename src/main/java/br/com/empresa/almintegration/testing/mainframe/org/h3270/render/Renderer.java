package br.com.empresa.almintegration.testing.mainframe.org.h3270.render;

import br.com.empresa.almintegration.testing.mainframe.org.h3270.host.Screen;

/**
 * @author Andre Spiegel spiegel@gnu.org
 * @version $Id: Renderer.java,v 1.7 2006/12/13 11:50:55 spiegel Exp $
 */
public interface Renderer {

    boolean canRender(Screen s);

    boolean canRender(String screenText);

    String render(Screen s);

    String render(Screen s, String actionURL);

    String render(Screen s, String actionURL, String id);

}

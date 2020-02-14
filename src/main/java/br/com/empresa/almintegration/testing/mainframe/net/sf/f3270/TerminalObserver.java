package br.com.empresa.almintegration.testing.mainframe.net.sf.f3270;

import br.com.empresa.almintegration.testing.mainframe.org.h3270.host.S3270;

public abstract class TerminalObserver {

    public void screenUpdated() {
    }

    public void commandIssued(String command, String returned, Parameter... parameters) {
    }

    public void connect(S3270 s3270) {
    }

    public void disconnect() {
    }

}

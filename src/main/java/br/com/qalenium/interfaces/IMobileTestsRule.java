package br.com.qalenium.interfaces;

public interface IMobileTestsRule {

    void closeEmulator();
    void startEmulator();
    void closeSimulator();
    void startSimulator();
    void startServer();
    void stopServer();

}

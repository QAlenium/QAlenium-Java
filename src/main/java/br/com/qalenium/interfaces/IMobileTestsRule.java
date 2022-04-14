package br.com.qalenium.interfaces;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;

public interface IMobileTestsRule {

    void closeEmulator() throws IOException;
    AndroidDriver startEmulator() throws MalformedURLException;
    void closeSimulator() throws IOException;
    RemoteWebDriver startSimulator() throws IOException;
    void startServer();
    void stopServer() throws IOException;

}

package br.com.qalenium.interfaces;

import io.appium.java_client.android.AndroidDriver;

public interface IMobileTestsRule {

    void closeEmulator();
    void startEmulator();
    void closeSimulator();
    void startSimulator();
    void startServer();
    void stopServer();
    AndroidDriver setupAndroidCapabilities();

}

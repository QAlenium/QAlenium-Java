package br.com.qalenium.rules;

import br.com.qalenium.interfaces.IMobileTestsRule;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileTestsRule extends GenericTestsRule implements IMobileTestsRule {

    @Override
    protected void before() {
    }

    @Override
    protected void after() {
    }

    @Override
    public void closeEmulator() {
    }

    @Override
    public void startEmulator() {
    }

    @Override
    public void closeSimulator() {
    }

    @Override
    public void startSimulator() {
    }

    @Override
    public void startServer() {
    }

    @Override
    public void stopServer() {
    }

    @Override
    public AndroidDriver setupAndroidCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appPackage", "com.qalenium.qalenium_mobile");
        caps.setCapability("appActivity", ".MainActivity");
        AndroidDriver androidDriver = null;
        try {
            androidDriver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        androidDriver.startActivity(new Activity("com.qalenium.qalenium_mobile", ".MainActivity"));
        return androidDriver;
    }
}
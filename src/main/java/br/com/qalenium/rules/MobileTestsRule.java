package br.com.qalenium.rules;

import br.com.qalenium.interfaces.IMobileTestsRule;
import com.github.genium_framework.appium.support.server.AppiumServer;
import com.github.genium_framework.server.ServerArguments;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
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
    public void closeEmulator() throws IOException {
        Runtime.getRuntime().exec("adb emu kill");
    }

    @Override
    public AndroidDriver startEmulator() throws IOException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2_API_R");
        caps.setCapability(MobileCapabilityType.APP, "./resources/ApiDemos-debug.apk");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }

    @Override
    public void closeSimulator() throws IOException {
        Runtime.getRuntime().exec("close -a Simulator --args");
    }

    @Override
    public RemoteWebDriver startSimulator() throws IOException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"iOS");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6 Plus");
        Runtime.getRuntime().exec("open -a Simulator --args");
        return new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }

    @Override
    public void startServer() {
        ServerArguments serverArguments = new ServerArguments();
        serverArguments.setArgument("--port", 4723);
        serverArguments.setArgument("--local-timezone", true);
        serverArguments.setArgument("--address", "127.0.0.1");
        AppiumServer appiumServer = new AppiumServer(new File("path_to_appium_installation"), serverArguments);
        appiumServer.startServer(60000);
    }

    @Override
    public void stopServer() throws IOException {
        String command = "cmd /c echo off" +
                " & " +
                "FOR /F \"usebackq tokens=5\" %p in (`netstat -nao ^| findstr /R /C:\"4723\"`) " +
                "do (FOR /F \"usebackq\" %t in (`TASKLIST /FI \"PID eq %p\" ^| findstr /I node.exe`) " +
                "do taskkill /F /PID %p)";
        Runtime.getRuntime().exec(command);
    }
}
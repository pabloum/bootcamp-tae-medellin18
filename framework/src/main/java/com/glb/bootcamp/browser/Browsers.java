package com.glb.bootcamp.browser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.glb.bootcamp.driver.capabilities.CapabilitiesReader.CAPABILITIES_READER;
import static io.github.bonigarcia.wdm.WebDriverManager.*;
import static java.util.Collections.synchronizedList;
import static org.openqa.selenium.remote.DesiredCapabilities.*;

/**
 * Browsers supports getting the capabilities per platform.
 * It uses {@link io.github.bonigarcia.wdm.WebDriverManager} to download the version of the driver binary.
 */
public enum Browsers implements GetCapabilities {

    CHROME {
        public Capabilities getCapabilities() {
            if (!BINARY_DOWNLOADED.contains(CHROME)) {
                chromedriver().setup();
                BINARY_DOWNLOADED.add(CHROME);
            }
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.merge(chrome());
            chromeOptions.addArguments("--incognito").addArguments("--disable-notifications");
            return chromeOptions;
        }
    },
    FIREFOX {
        @Override
        public Capabilities getCapabilities() {
            if (!BINARY_DOWNLOADED.contains(FIREFOX)) {
                firefoxdriver().setup();
                BINARY_DOWNLOADED.add(FIREFOX);
            }
            return firefox();
        }
    },
    IEXPLORER {
        @Override
        public Capabilities getCapabilities() {
            if (!BINARY_DOWNLOADED.contains(IEXPLORER)) {
                iedriver().setup();
                BINARY_DOWNLOADED.add(IEXPLORER);
            }
            InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
            internetExplorerOptions.merge(internetExplorer());
            internetExplorerOptions.setCapability("nativeEvents", false);
            internetExplorerOptions.setCapability("unexpectedAlertBehaviour", "accept");
            internetExplorerOptions.setCapability("disable-popup-blocking", true);
            internetExplorerOptions.setCapability("enablePersistentHover", true);
            return internetExplorerOptions;
        }
    },
    ANDROID {
        @Override
        public Capabilities getCapabilities() {
            DesiredCapabilities capabilities = android();
            Map<String, Object> extraCapabilities = CAPABILITIES_READER.readCapabilities("android.capabilities.properties");
            extraCapabilities.forEach((key, value) -> capabilities.setCapability(key, value));
            return capabilities;
        }
    },
    IPHONE {
        @Override
        public Capabilities getCapabilities() {
            return iphone();
        }
    };

    // More capabilities can be added based on the platform requirements

    private static final List<Browsers> BINARY_DOWNLOADED = synchronizedList(new ArrayList());

}

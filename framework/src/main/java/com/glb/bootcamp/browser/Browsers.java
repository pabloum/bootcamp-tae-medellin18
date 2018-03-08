package com.glb.bootcamp.browser;

import com.glb.bootcamp.logger.Loggeable;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

import static io.github.bonigarcia.wdm.WebDriverManager.*;
import static java.util.Collections.synchronizedList;
import static org.openqa.selenium.remote.DesiredCapabilities.*;

/**
 * Browsers supports getting the capabilities per browser.
 * It uses {@link io.github.bonigarcia.wdm.WebDriverManager} to download the version of the driver binary.
 */
public enum Browsers implements GetCapabilities, Loggeable {

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
            return internetExplorer();
        }
    };

    // More capabilities can be added based on the browser requirements

    private static final List<Browsers> BINARY_DOWNLOADED = synchronizedList(new ArrayList());

}

package ru.dnsShop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.Properties;

public class WebdriverSettings {

    public WebDriver setUp() throws IOException {
        WebDriver driver;
        //TODO: later need to change to params
        java.io.InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("my.properties");
        java.util.Properties properties = new Properties();
        properties.load(inputStream);
        String browser = properties.getProperty("browser");
        //String loadstrategy = properties.getProperty("loadstrategy");

        if(browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else {
            System.setProperty("webdriver.firefox.driver", "src/main/resources/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }
}

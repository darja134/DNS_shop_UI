package ru.dnsShop.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DnsStartPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//*[@id=\"homepage-desktop-menu-wrap\"]/div/div[3]/div/a")
    private WebElement menuFragment;

    @FindBy(xpath = "//*[@id=\"homepage-desktop-menu-wrap\"]/div/div[3]/div[2]/div[1]/a[1]")
    private WebElement smartphoneSection;

    public DnsStartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://www.dns-shop.ru");
    }

    public void selectSmartphoneSection()  {
        wait.until(ExpectedConditions.visibilityOf(menuFragment));
        // imitation of hover action
        Actions action = new Actions(driver);
        action.moveToElement(menuFragment).perform();

        wait.until(ExpectedConditions.visibilityOf(smartphoneSection));
        smartphoneSection.click();
    }
}

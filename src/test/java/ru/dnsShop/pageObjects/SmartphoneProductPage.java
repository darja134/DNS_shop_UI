package ru.dnsShop.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SmartphoneProductPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(className = "product-card-top__buy")
    private WebElement productInfo;

    @FindBy(xpath = "//*[contains(text(),'Модель')]//following-sibling::div")
    private WebElement manufacturer;

    @FindBy(xpath = "//*[contains(text(),'встроенной')]//following-sibling::div")
    private WebElement samsungBuiltInMemory;

    @FindBy(xpath = "//*[contains(text(),'оперативной')]//following-sibling::div")
    private WebElement appleRamMemory;

    public SmartphoneProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForProductInfoAppearance() {
        wait.until(ExpectedConditions.visibilityOf(productInfo));
    }

    public void verifyManufacturer(String expectedValue) {
        String actualValue = manufacturer.getText();
        Assert.assertTrue("Manufacturer should be the same", actualValue.contains(expectedValue));
    }

    public void verifyBuiltInMemory (String expectedValue) {
        WebElement expandCharacteristicsButton = driver.findElement(By.xpath("//button[contains(@class, 'product-characteristics__expand')]"));
        wait.until(ExpectedConditions.visibilityOf(expandCharacteristicsButton));

        Actions action = new Actions(driver);
        action.scrollToElement(expandCharacteristicsButton).perform();
        action.moveToElement(expandCharacteristicsButton).perform();

        expandCharacteristicsButton.click();

        wait.until(ExpectedConditions.visibilityOf(samsungBuiltInMemory));
        String actualValue = samsungBuiltInMemory.getText();
        Assert.assertTrue("Built-in memory should be the same", actualValue.contains(expectedValue));
    }

    public void verifyRamMemory (String expectedValue) {
        WebElement expandCharacteristicsButton = driver.findElement(By.xpath("//button[contains(@class, 'product-characteristics__expand')]"));
        wait.until(ExpectedConditions.visibilityOf(expandCharacteristicsButton));

        Actions action = new Actions(driver);
        action.scrollToElement(expandCharacteristicsButton).perform();
        action.moveToElement(expandCharacteristicsButton).perform();

        expandCharacteristicsButton.click();

        wait.until(ExpectedConditions.visibilityOf(appleRamMemory));
        String actualValue = appleRamMemory.getText();
        Assert.assertTrue("RAM memory should be the same", actualValue.contains(expectedValue));
    }
}

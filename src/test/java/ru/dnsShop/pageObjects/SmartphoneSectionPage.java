package ru.dnsShop.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SmartphoneSectionPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;

    @FindBy(xpath = "//div[@class = 'ui-list-controls__content ui-list-controls__content_custom left-filters__radio-list']")
    private WebElement presenceInShopsBlock;

    @FindBy(xpath = "//div[@data-id='brand']")
    private WebElement brandSection;

    @FindBy(xpath = "//span[contains(text(), 'Samsung')]")
    private WebElement samsungManufacturer;

    @FindBy(xpath = "//span[contains(text(), 'Apple')]")
    private WebElement appleManufacturer;

    @FindBy(xpath = "//span[contains(text(), 'Объем встроенной памяти (ГБ)')]")
    private WebElement builtInMemorySectionExpand;

    @FindBy(xpath = "//*[contains(text(), '256 ГБ')]//following-sibling::input//following-sibling::span")
    private WebElement builtInMemoryCheckbox;

    @FindBy(xpath = "//div[@data-id='f[9a8]']")
    private WebElement ramMemorySection;

    @FindBy(xpath = "//span[contains(text(), 'Объем оперативной памяти')]")
    private WebElement ramMemorySectionExpand;

    @FindBy(xpath = "//*[contains(text(), '4 Гб')]//following-sibling::input//following-sibling::span")
    private WebElement ramMemoryCheckbox;

    @FindBy(xpath = "//*[contains(text(),'Применить')]")
    private WebElement applyFiltersButton;

    @FindBy(xpath = "//div[@data-id='order']//child::a")
    private WebElement expandSortingOptions;

    @FindBy(xpath = "//span[contains(text(), 'Сначала дорогие')]")
    private WebElement filterFromExpensiveToCheapest;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[3]/div/div[2]/div[1]/div[1]")
    private WebElement firstSmartphoneSection;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[3]/div/div[2]/div[1]/a/span")
    private WebElement firstSmartphoneFromFilteredList;

    public SmartphoneSectionPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForSectionPresence() {
        wait.until(ExpectedConditions.visibilityOf(presenceInShopsBlock));
    }

    public void selectSamsungManufacturer() {
        wait.until(ExpectedConditions.visibilityOf(brandSection));
        action = new Actions(driver);
        action.scrollToElement(brandSection).perform();
        wait.until(ExpectedConditions.visibilityOf(samsungManufacturer));
        samsungManufacturer.click();
    }

    public void selectSamsungBuiltInMemory() {
        action = new Actions(driver);
        action.scrollToElement(builtInMemorySectionExpand).perform();
        builtInMemorySectionExpand.click();
        wait.until(ExpectedConditions.visibilityOf(builtInMemoryCheckbox));
        builtInMemoryCheckbox.click();
    }

    public void selectAppleManufacturer() {
        wait.until(ExpectedConditions.visibilityOf(brandSection));
        action = new Actions(driver);
        action.scrollToElement(brandSection).perform();
        wait.until(ExpectedConditions.visibilityOf(appleManufacturer));
        appleManufacturer.click();
    }

    public void selectAppleRamMemory() {
        wait.until(ExpectedConditions.visibilityOf(ramMemorySection));
        action = new Actions(driver);
        action.scrollToElement(ramMemorySection).perform();
        ramMemorySectionExpand.click();
        wait.until(ExpectedConditions.visibilityOf(ramMemoryCheckbox));
        ramMemoryCheckbox.click();
    }

    public void pressApplyFilterButton() {
        action = new Actions(driver);
        action.scrollToElement(applyFiltersButton).perform();
        applyFiltersButton.click();
    }

    public void sortFromExpensiveToCheapestSmartphones() {
        action = new Actions(driver);
        action.scrollToElement(expandSortingOptions).perform();
        expandSortingOptions.click();
        wait.until(ExpectedConditions.visibilityOf(filterFromExpensiveToCheapest));
        filterFromExpensiveToCheapest.click();
    }

    public void selectFirstSmartphoneFromList() {
        driver.navigate().refresh();
        WebElement firstSmartphoneFromFilteredList = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[3]/div/div[2]/div[1]/a/span"));
        action = new Actions(driver);
        action.moveToElement(firstSmartphoneSection).perform();
        wait.until(ExpectedConditions.elementToBeClickable(firstSmartphoneFromFilteredList));
        firstSmartphoneFromFilteredList.click();
    }
}

package ru.dnsShop;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.apache.commons.io.FileUtils;
import ru.dnsShop.pageObjects.DnsStartPage;
import ru.dnsShop.pageObjects.SmartphoneProductPage;
import ru.dnsShop.pageObjects.SmartphoneSectionPage;

import java.io.File;
import java.io.IOException;

public class StepDefinitions extends WebdriverSettings{

    WebDriver driver = setUp();

    DnsStartPage dnsStartPage = PageFactory.initElements(driver, DnsStartPage.class);;
    SmartphoneSectionPage smartphoneSectionPage = PageFactory.initElements(driver, SmartphoneSectionPage.class);;
    SmartphoneProductPage smartphoneProductPage = PageFactory.initElements(driver, SmartphoneProductPage.class);;

    public StepDefinitions() throws IOException {
    }

    @Given("I go to dns-shop website")
    public void iGoToDnsShopWebsite() {
        dnsStartPage.open();
    }

    @When("^I take a screenshot with filepath (.+) and filename (.+)$")
    public void iTakeAScreenshotWithFilePathAndFilename(String filepath, String filename) throws IOException {
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File SrcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(filepath + filename + ".png");
        FileUtils.copyFile(SrcFile, DestFile);
    }

    @When("I go to smartphone section")
    public void iGoToSmartphoneSection() {
        dnsStartPage.selectSmartphoneSection();
        smartphoneSectionPage.waitForSectionPresence();
    }

    @When("^I apply smartphone filters for (.+)$")
    public void iApplySmartphoneFiltersFor(String brand) {
        if(brand.equals("Samsung")) {
            smartphoneSectionPage.selectSamsungManufacturer();
            smartphoneSectionPage.selectSamsungBuiltInMemory();
        } else {
            smartphoneSectionPage.selectAppleManufacturer();
            smartphoneSectionPage.selectAppleRamMemory();
        }
        smartphoneSectionPage.pressApplyFilterButton();
    }

    @When("I sort list of smartphones from expensive to cheapest")
    public void iSortListOfSmartphonesFromExpensiveToCheapest() {
        smartphoneSectionPage.sortFromExpensiveToCheapestSmartphones();
    }

    @When("I choose the first smartphone from the list")
    public void iChooseTheFirstSmartphoneFromTheList() {
        smartphoneSectionPage.selectFirstSmartphoneFromList();
        smartphoneProductPage.waitForProductInfoAppearance();
    }

    @Then("^I verify smartphone (.+) memory specification for (.+)$")
    public void iVerifySmartphoneMemorySpecificationFor(String memory, String smartphoneBrand) {
        smartphoneProductPage.verifyManufacturer(smartphoneBrand);
        if(smartphoneBrand.equals("Samsung")) {
            smartphoneProductPage.verifyBuiltInMemory(memory);
        } else {
            smartphoneProductPage.verifyRamMemory(memory);
        }
    }

    @Then("I close browser")
    public void iCloseBrowser() {
        driver.close();
        driver.quit();
    }
}

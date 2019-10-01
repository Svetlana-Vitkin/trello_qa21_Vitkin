package com.trello.qa.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {
    WebDriver driver;

    public HelperBase(WebDriver driver){

        this.driver=driver;
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
       if(text != null){
           driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
       }
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void clickOnPlusButtonOnHeader() {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
    }

    public void returnToHomePage() throws InterruptedException {
        Thread.sleep(3000);
        click(By.cssSelector("[class='_1q-xxtNvcdFBca']"));
        click(By.cssSelector("[class='_1q-xxtNvcdFBca']"));
    }

    public void clickOnPlusButtonFromLeftNavMenu() {
        click(By.cssSelector("[data-test-id='home-navigation-create-team-button']"));
    }

    public void waitForElementAndClick(By locator, int time) {
        new WebDriverWait(driver,time).until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void waitForElementAndType(By locator, int time, String string) {
        waitForElementAndClick(locator,time);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(string);
    }
}

package com.trello.qa.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoardHelper extends HelperBase {
    public BoardHelper(WebDriver driver) {
        super(driver);
    }

    public void clickXButton() {
        click(By.cssSelector("button.qb90FI2uVIybRy._2b_HpRl1Tyl1YK"));
    }

    public void submitBoardCreation() {
        click(By.xpath("//*[@type='submit']"));
    }

    public void typeNewBoardsName(String boardName) {

        type(By.cssSelector("div.form-container input.subtle-input"), boardName);
        if (isElementPresent(By.cssSelector(".subtle-chooser-trigger.unstyled-button.org-chooser-trigger"))) {
            click(By.cssSelector(".subtle-chooser-trigger.unstyled-button.org-chooser-trigger"));
            click(By.xpath("//ul[@class='pop-over-list org-chooser']/li[1]"));//no team
        }
    }

    public void clickByCreateBoardButtonOfBoardsSection() {click(By.cssSelector(".board-tile.mod-add"));
    }

    public void confirmBoardCreation() {click(By.cssSelector("[data-test-id='header-create-board-submit-button']"));
    }

    public void fillBoardCreationForm(String boardName) {
        type(By.cssSelector("[data-test-id='header-create-board-title-input']"), boardName);
        if (isElementPresent(By.cssSelector(".W6rMLOx8U0MrPx"))) {
            click(By.cssSelector(".W6rMLOx8U0MrPx"));
            click(By.xpath("//nav[@class='SdlcRrTVPA8Y3K']//li[1]"));//no team
        }
    }

    public void selectCreateBoardFromDropDown() {
        click(By.cssSelector("[data-test-id='header-create-board-button']"));
    }

    public void clickByClosePopUpButton() {
        click(By.cssSelector(".no-back input"));
    }

    public void choseCloseBoard() {
        click(By.cssSelector(".js-close-board"));
    }

    public void expandMenu() {
        click(By.cssSelector(".js-open-more"));
    }

    public void openThirdBoard()
    {new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='boards-page-board-section-list']/li[3]")));
        click(By.xpath("//*[@class='boards-page-board-section-list']/li[3]"));
    }

    public void confirmBoardDeletion() {
    }

    public int getBoardsCount() {
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")));
        return driver.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size();
    }

    public void clickOnMenu() {
        WebElement menuButton = driver.findElement(By.cssSelector(".board-header-btn.mod-show-menu"));
        if(menuButton.getCssValue("visibility").equals("visible")){
            click(By.cssSelector(".mod-show-menu"));
        }
        return;
    }

    public boolean isTherePersonalBoardsPresent() {
        return isElementPresent(By.xpath("//*[@class='icon-lg icon-member']/../../.."));
    }

    public String getBoardNameFromBoardPage() {
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".js-board-editing-target.board-header-btn-text")));
        return driver.findElement(By.cssSelector(".js-board-editing-target.board-header-btn-text")).getText();
    }

    public void clickOnFirstPrivateBoard() {
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='boards-page-board-section-list']/li[3]")));
        click(By.xpath("//*[@class='boards-page-board-section-list']/li[1]"));
    }

    public void changeBoardName(String newName) throws InterruptedException {
        driver.findElement(By.cssSelector(".js-rename-board")).click();
        driver.findElement(By.cssSelector("input.js-board-name-input")).sendKeys(newName);
        returnToHomePage();
    }

    public boolean findBoardByName(String name) {
        return driver.findElement(By.xpath("//*[@class='icon-lg icon-member']/../../..")).getText().equals(name);
    }
}

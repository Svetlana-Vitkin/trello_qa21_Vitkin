package com.trello.qa.manager;

import com.trello.qa.model.BoardData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoardHelper extends  HelperBase{
    public BoardHelper(WebDriver driver) {
        super(driver);
    }

    public void fillBoardCreationForm(BoardData board) {
        type(By.cssSelector("[data-test-id='header-create-board-title-input']"), board.getBoardName());

        if (isElementPresent(By.cssSelector(".W6rMLOx8U0MrPx"))) {
            click(By.cssSelector(".W6rMLOx8U0MrPx"));
            click(By.xpath("//nav[@class='SdlcRrTVPA8Y3K']//li[1]"));//no team
        }
    }

    public void selectCreateBoardFromDropDown() {
        click(By.cssSelector("[data-test-id='header-create-board-button']"));
    }

    public void confirmBoardCreation() throws InterruptedException {

        click(By.cssSelector("[data-test-id='header-create-board-submit-button']"));
        //waitForElementAndClick(By.cssSelector("[data-test-id='header-create-board-submit-button']"), 20);
    }

    public int getPersnalBoardsCount() throws InterruptedException {
        Thread.sleep(10000);

        return driver.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 1;
    }



    public void clickOnMoreButtonInBoardMenu() {
        WebElement menuButton = driver.findElement(By.cssSelector(".board-header-btn.mod-show-menu"));
        System.out.println(menuButton.getCssValue("visibility"));
        if (menuButton.getCssValue("visibility").equals("visible")) {
            click(By.cssSelector(".mod-show-menu"));
            click(By.cssSelector(".js-open-more"));
        } else {
            click(By.cssSelector(".js-open-more"));
        }
    }

    public void clickOnFirstPrivateBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
    }

    public void initBoardDeletion() {
        clickCloseBoardButton();
        confirmCloseButton();
    }
    public void confirmCloseButton() {
        click(By.cssSelector(".js-confirm.full.negate"));
    }

    private void clickCloseBoardButton() {
        click(By.cssSelector(".board-menu-navigation-item-link.js-close-board"));
    }

    public void confirmBoardDeletion() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".js-delete")));
        click(By.cssSelector(".js-delete"));
    }

    public void confirmFinishBoardDeletion() {
        click(By.cssSelector(".js-confirm.full"));
    }

    public void createBoard() throws InterruptedException {
        clickOnPlusButtonOnHeader();
        selectCreateBoardFromDropDown();
        fillBoardCreationForm(new BoardData().setBoardName("qa21"));
        confirmBoardCreation();
        returnToHomePage();
    }

    public void changeBoardName(String newName) {
        driver.findElement(By.cssSelector(".js-rename-board")).click();
        driver.findElement(By.cssSelector("input.js-board-name-input")).sendKeys(newName);
        returnToHomePage();
    }

    public String getPersonalBoardName() {
        return driver.findElement(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).getText();
    }

    public String getNameAfterChange() {
        return driver.findElement(By.cssSelector("js-rename-board")).getText();
    }

    public boolean findBoardByName(String name) {

        return driver.findElement(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).getText().equals(name);
    }
}

package com.trello.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
  /*  @BeforeClass
    public void ensurePreconditions() {
        if (!app.getSessionHelper().isUserLoggedIn()) {
            app.getSessionHelper().login("sveta.vitkina@yandex.ua", "dasha2004");
        }
    }

    @BeforeMethod
    public void isOnHomePage() throws InterruptedException {
        if (!app.getBoardHelper().isTherePersonalBoardsPresent()) {
            app.getSessionHelper().returnToHomePage();
        }
    }*/

    @Test
    public void testBoardCreationFromPlusButtonOnHeader() throws InterruptedException {
        int before = app.getBoardHelper().getBoardsCount();
        app.getSessionHelper().clickOnPlusButtonOnHeader();
        app.getBoardHelper().selectCreateBoardFromDropDown();
        String boardName = "QA21";
        app.getBoardHelper().fillBoardCreationForm(boardName);
        app.getBoardHelper().confirmBoardCreation();
        String createdBoardName = app.getBoardHelper().getBoardNameFromBoardPage();
        app.getSessionHelper().returnToHomePage();
        int after = app.getBoardHelper().getBoardsCount();
      //  Assert.assertEquals(after, before + 1);
        Assert.assertEquals(createdBoardName.toLowerCase(), boardName.toLowerCase());
    }


    @Test(enabled = false)
    public void testBoardCreationFromPersonalBoardsSection() throws InterruptedException {
        int before = app.getBoardHelper().getBoardsCount();
        app.getBoardHelper().clickByCreateBoardButtonOfBoardsSection();
        String boardName = "QA21" + System.currentTimeMillis();
        app.getBoardHelper().typeNewBoardsName(boardName);
        app.getBoardHelper().submitBoardCreation();
        String createdBoardName = app.getBoardHelper().getBoardNameFromBoardPage();
        app.getSessionHelper().returnToHomePage();
        int after = app.getBoardHelper().getBoardsCount();
        Assert.assertEquals(after, before + 1);
        Assert.assertEquals(createdBoardName.toLowerCase(), boardName.toLowerCase());
    }

    @AfterClass (enabled=false)
    public void cleanBoards() throws InterruptedException {
        while (app.getBoardHelper().getBoardsCount() > 2) {
            Thread.sleep(5000);
            app.getBoardHelper().openThirdBoard();
            app.getBoardHelper().clickOnMenu();
            app.getBoardHelper().expandMenu();
            app.getBoardHelper().choseCloseBoard();
            app.getBoardHelper().clickByClosePopUpButton();
            app.getBoardHelper().confirmBoardDeletion();
            app.getSessionHelper().returnToHomePage();
        }
    }
}

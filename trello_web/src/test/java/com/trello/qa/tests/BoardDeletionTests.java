package com.trello.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {
    @BeforeClass
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
    }

    @Test
    public void testBoardDeletion() throws InterruptedException {
        int before = app.getBoardHelper().getBoardsCount();
        app.getBoardHelper().openThirdBoard();
        app.getBoardHelper().clickOnMenu();
        app.getBoardHelper().expandMenu();
        app.getBoardHelper().choseCloseBoard();
        app.getBoardHelper().clickByClosePopUpButton();
        app.getBoardHelper().confirmBoardDeletion();
        app.getSessionHelper().returnToHomePage();
        int after = app.getBoardHelper().getBoardsCount();
        Assert.assertEquals(after, before - 1);
    }
}

package com.trello.qa;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {
    @BeforeClass
    public void ensurePreconditions() {
        if (!app.isUserLoggedIn()) {
            app.login("sveta.vitkina@yandex.ua", "dasha2004");
        }
    }

    @BeforeMethod
    public void isOnHomePage() throws InterruptedException {
        if (!app.isTherePersonalBoardsPresent()) {
            app.returnToHomePage();
        }
    }

    @Test
    public void testBoardDeletion() throws InterruptedException {
        int before = app.getBoardsCount();
        app.openThirdBoard();
        app.clickOnMenu();
        app.expandMenu();
        app.choseCloseBoard();
        app.clickByClosePopUpButton();
        app.confirmBoardDeletion();
        app.returnToHomePage();
        int after = app.getBoardsCount();
        Assert.assertEquals(after, before - 1);
    }
}

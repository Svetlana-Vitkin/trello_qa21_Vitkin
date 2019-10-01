package com.trello.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardModificationTests extends TestBase {
    @BeforeMethod
    public void isOnHomePage() throws InterruptedException {
        if (!app.getBoardHelper().isTherePersonalBoardsPresent()) {
            app.getSessionHelper().returnToHomePage();
        }
    }
    @Test
    public void changeBoardName() throws InterruptedException {
        app.getBoardHelper().clickOnFirstPrivateBoard();
        String bName = "BB";
        app.getBoardHelper().changeBoardName(bName);
       // Assert.assertTrue(app.getBoardHelper().findBoardByName(bName));
    }

}

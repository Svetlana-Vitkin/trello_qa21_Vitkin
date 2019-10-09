package com.trello.qa.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardModificationTests extends  TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!app.getBoardHelper().isTherePersonalBoards()){
            app.getBoardHelper().createBoard();
        }
    }
    @Test
    public void changeBoardName(){
        app.getBoardHelper().clickOnFirstPrivateBoard();
        String bName = "BB";
        app.getBoardHelper().changeBoardName(bName);

        // Assert.assertTrue(app.getBoardHelper().findBoardByName(bName));
    }
}

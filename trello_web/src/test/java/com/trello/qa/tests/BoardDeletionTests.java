package com.trello.qa.tests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase{

    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!app.getBoardHelper().isTherePersonalBoards()){
            app.getBoardHelper().createBoard();
        }
    }
    @Test
    public void deletionBoardTest() throws InterruptedException {
        int before = app.getBoardHelper().getPersnalBoardsCount();
        app.getBoardHelper().clickOnFirstPrivateBoard();
        Thread.sleep(10000);
        app.getBoardHelper().clickOnMoreButtonInBoardMenu();
        app.getBoardHelper().initBoardDeletion();
        app.getBoardHelper().confirmBoardDeletion();//.js-delete
        app.getBoardHelper().confirmFinishBoardDeletion();//.js-confirm.full
        app.getBoardHelper().returnToHomePage();

        int after = app.getBoardHelper().getPersnalBoardsCount();
    }

    @Test
    public void cleanBoards() throws InterruptedException {
        while (app.getBoardHelper().getPersnalBoardsCount() > 2) {
            Thread.sleep(5000);
            app.getBoardHelper().clickOnFirstPrivateBoard();
            app.getBoardHelper().clickOnMoreButtonInBoardMenu();
            app.getBoardHelper().initBoardDeletion();
            app.getBoardHelper().confirmBoardDeletion();
            app.getBoardHelper().confirmFinishBoardDeletion();
            app.getBoardHelper().confirmBoardDeletion();
            app.getSessionHelper().returnToHomePage();
        }
    }
}

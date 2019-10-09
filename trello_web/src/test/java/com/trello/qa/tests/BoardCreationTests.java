package com.trello.qa.tests;

import com.trello.qa.model.BoardData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoardCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validBoards(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[] {"name 1"});
        list.add(new Object[] {"1"});
        list.add(new Object[] {"прпрпр"});

        return  list.iterator();
    }

    @Test(dataProvider = "validBoards")
    public void testBoardCreationDP(String boardName) throws InterruptedException {

        BoardData board = new BoardData().setBoardName(boardName);
        int beforeCreation = app.getBoardHelper().getPersnalBoardsCount();
        app.getBoardHelper().clickOnPlusButtonOnHeader();
        app.getBoardHelper().selectCreateBoardFromDropDown();

        app.getBoardHelper().fillBoardCreationForm(board);
        app.getBoardHelper().confirmBoardCreation();
        app.getBoardHelper().returnToHomePage();

        int afterCreation = app.getBoardHelper().getPersnalBoardsCount();

        Assert.assertEquals(afterCreation, beforeCreation + 1);
    }

    @Test
    public void testBoardCreation() throws InterruptedException {
        int beforeCreation = app.getBoardHelper().getPersnalBoardsCount();
        app.getBoardHelper().clickOnPlusButtonOnHeader();
        app.getBoardHelper().selectCreateBoardFromDropDown();
        app.getBoardHelper().fillBoardCreationForm(new BoardData().setBoardName("qa21"));
        app.getBoardHelper().confirmBoardCreation();
        app.getBoardHelper().returnToHomePage();

        int afterCreation = app.getBoardHelper().getPersnalBoardsCount();

        Assert.assertEquals(afterCreation, beforeCreation + 1);
    }
}

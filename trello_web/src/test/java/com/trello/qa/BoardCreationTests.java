package com.trello.qa;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase{
    @Test
    public void testBoardCreation() {
        click(By.cssSelector("[name='add']"));
        click(By.cssSelector("[data-test-id='header-create-board-button']"));
        type(By.cssSelector("[data-test-id='header-create-board-title-input']"),"First board");
        click(By.cssSelector("[data-test-id='header-create-board-submit-button']"));
    }
}

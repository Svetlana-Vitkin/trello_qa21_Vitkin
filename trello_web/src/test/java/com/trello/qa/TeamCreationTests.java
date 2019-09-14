package com.trello.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {
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
    public void testTeamCreationFromPlusButtonOnHeader() throws InterruptedException {
        int before = app.getTeamsCount();
        app.clickOnPlusButtonOnHeader();
        app.selectCreateTeamFromDropDown();
        app.fillTeamCreationForm("h", "g");
        app.clickContinueButton();
        app.click(By.cssSelector("[class='qb90FI2uVIybRy _2b_HpRl1Tyl1YK']"));
        Thread.sleep(3000);
        int after = app.getTeamsCount();
        Assert.assertEquals(after, before + 1);
    }

    @Test (enabled = false)
    public void testTeamCreationCansellationFromPlusButtonOnHeader() throws InterruptedException {
        int before = app.getTeamsCount();
        app.clickOnPlusButtonOnHeader();
        app.selectCreateTeamFromDropDown();
        app.fillTeamCreationForm("h", "g");
        app.clickXButton();
        app.returnToHomePage();
        Thread.sleep(3000);
        int after = app.getTeamsCount();
        Assert.assertEquals(after, before);
    }

    @Test (enabled = false)
    public void testTeamCreationFromPlusButtonOnLeftNavMenu() throws InterruptedException {
        int before = app.getTeamsCount();
        app.clickOnPlusButtonFromLeftNavMenu();
        Thread.sleep(3000);
        String teamName = "QA21" + System.currentTimeMillis();
        app.fillTeamCreationForm(teamName, "descriptionQA21");
        app.clickContinueButton();
        String createdTeamName = app.getTeamNameFromTeamPage();
        app.returnToHomePage();
        int after = app.getTeamsCount();
        Assert.assertEquals(after, before + 1);
        Assert.assertEquals(createdTeamName.toLowerCase(), teamName.toLowerCase());
    }

    @AfterClass
    public void cleanTeams() {
        int i = 0;
        while (i < 2) {
            app.clickByFirstTeam();
            app.clickByTeamSettings();
            app.clickByDeleteTeam();
            app.confirmTeamDeletion();
            i++;
        }
    }
}

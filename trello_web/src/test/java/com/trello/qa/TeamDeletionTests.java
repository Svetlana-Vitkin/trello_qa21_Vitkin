package com.trello.qa;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTests extends TestBase {
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
    public void testTeamDeletionFromLeftNavMenu() throws InterruptedException {
        int before = app.getTeamsCount();
        app.clickByFirstTeam();
        app.clickByTeamSettings();
        app.clickByDeleteTeam();
        app.confirmTeamDeletion();
        Thread.sleep(3000);
        int after = app.getTeamsCount();
        Thread.sleep(10000);
        Assert.assertEquals(after, before - 1);
    }
}

package com.trello.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTests extends TestBase {
    @BeforeClass
    public void ensurePreconditions() {
        if (!app.getSessionHelper().isUserLoggedIn()) {
            app.getSessionHelper().login("sveta.vitkina@yandex.ua", "dasha2004");
        }
    }

    @BeforeMethod
    public void precondition() throws InterruptedException {
        if(!app.getTeamHelper().isTeamsPresent()){
            app.getTeamHelper().createTeam();
        }
    }

    @Test
    public void testTeamDeletionFromLeftNavMenu() throws InterruptedException {
        while (app.getTeamHelper().getTeamsCount() > 2) {
            app.getTeamHelper().clickByFirstTeam();
            app.getTeamHelper().clickByTeamSettings();
            app.getTeamHelper().clickByDeleteTeam();
            app.getTeamHelper().confirmTeamDeletion();
        }





       /* int before = app.getTeamHelper().getTeamsCount();
        app.getTeamHelper().clickByFirstTeam();
        app.getTeamHelper().clickByTeamSettings();
        app.getTeamHelper().clickByDeleteTeam();
        app.getTeamHelper().confirmTeamDeletion();
        Thread.sleep(3000);
        int after = app.getTeamHelper().getTeamsCount();
        Thread.sleep(10000);
        Assert.assertEquals(after, before - 1);*/
    }
}

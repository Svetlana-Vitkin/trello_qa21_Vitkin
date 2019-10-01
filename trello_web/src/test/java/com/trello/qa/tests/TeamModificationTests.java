package com.trello.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamModificationTests extends TestBase {
    @BeforeMethod
    public void precondition() throws InterruptedException {
        if(!app.getTeamHelper().isTeamsPresent()){
            app.getTeamHelper().createTeam();
        }
    }

    @Test
    public void testRenameTeam() throws InterruptedException {
        app.getTeamHelper().clickByFirstTeam();
        app.getTeamHelper().clickByTeamSettings();
        app.getTeamHelper().initEditTeamProfile();
        app.getTeamHelper().changeTeamProfile("hh","hah");
        app.getTeamHelper().confirmEditTeam();
        Thread.sleep(5000);

      //  Assert.assertEquals(app.getTeamHelper().getTeamNameFromTeamPage(),"hh");
    }
}

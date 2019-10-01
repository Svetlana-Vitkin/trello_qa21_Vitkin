package com.trello.qa.tests;

import com.trello.qa.manager.TeamData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TeamCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validTeams(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"name","discription"});
        list.add(new Object[]{"name",""});
        list.add(new Object[]{"NAME","DESCR"});
        list.add(new Object[]{"1234","456789"});
        list.add(new Object[]{"&^#$","*$%&"});

        return list.iterator();
    }

    @Test(dataProvider = "validTeams")
    public void testTeamCreationFromPlusButtonOnHeaderWithDataProvider(String teamName, String discription) throws InterruptedException {
        TeamData team = new TeamData().withTeamName(teamName).withDescription(discription);
        int before = app.getTeamHelper().getTeamsCount();
        app.getTeamHelper().clickOnPlusButtonOnHeader();
        app.getTeamHelper().selectCreateTeamFromDropDown();
        app.getTeamHelper().fillTeamCreationForm(team);
        app.getTeamHelper().clickContinueButton();
        app.getSessionHelper().click(By.cssSelector("[class='qb90FI2uVIybRy _2b_HpRl1Tyl1YK']"));
        app.getSessionHelper().returnToHomePage();
        Thread.sleep(3000);
        int after = app.getTeamHelper().getTeamsCount();
        Assert.assertEquals(after, before + 1);
    }

    @DataProvider
    public Iterator<Object[]> validTeamsfromcsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/Team - Sheet4.csv")));
        String line = reader.readLine();
        while(line != null) {
            line = reader.readLine();
            String[] split = line.split(",");
            list.add(new Object[]{new TeamData().withTeamName(split[0]).withDescription(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "validTeamsfromcsv")
    public void testTeamCreationFromPlusButtonOnHeaderWithDataProviderfromcsv(TeamData team) throws InterruptedException {
        int before = app.getTeamHelper().getTeamsCount();
        app.getTeamHelper().clickOnPlusButtonOnHeader();
        app.getTeamHelper().selectCreateTeamFromDropDown();
        app.getTeamHelper().fillTeamCreationForm(team);
        app.getTeamHelper().clickContinueButton();
        app.getSessionHelper().click(By.cssSelector("[class='qb90FI2uVIybRy _2b_HpRl1Tyl1YK']"));
        app.getSessionHelper().returnToHomePage();
        Thread.sleep(3000);
        int after = app.getTeamHelper().getTeamsCount();
        Assert.assertEquals(after, before + 1);
    }


    @BeforeClass
    public void ensurePreconditions() {
        if (!app.getSessionHelper().isUserLoggedIn()) {
            app.getSessionHelper().login("sveta.vitkina@yandex.ua", "dasha2004");
        }
    }

    @BeforeMethod
    public void isOnHomePage() throws InterruptedException {
        if (!app.getBoardHelper().isTherePersonalBoardsPresent()) {
            app.getSessionHelper().returnToHomePage();
        }
    }










   /* @Test(enabled = false)
    public void testTeamCreationFromPlusButtonOnHeader() throws InterruptedException {
        int before = app.getTeamHelper().getTeamsCount();
        app.getTeamHelper().clickOnPlusButtonOnHeader();
        app.getTeamHelper().selectCreateTeamFromDropDown();
        app.getTeamHelper().fillTeamCreationForm(new TeamData().withTeamName("h").withDescription("g"));
        app.getTeamHelper().clickContinueButton();
        app.getSessionHelper().click(By.cssSelector("[class='qb90FI2uVIybRy _2b_HpRl1Tyl1YK']"));
        Thread.sleep(3000);
        int after = app.getTeamHelper().getTeamsCount();
        Assert.assertEquals(after, before + 1);
    }

    @Test (enabled = false)
    public void testTeamCreationCansellationFromPlusButtonOnHeader() throws InterruptedException {
        int before = app.getTeamHelper().getTeamsCount();
        app.getTeamHelper().clickOnPlusButtonOnHeader();
        app.getTeamHelper().selectCreateTeamFromDropDown();
        app.getTeamHelper().fillTeamCreationForm(new TeamData().withTeamName("h"));
        app.getBoardHelper().clickXButton();
        app.getSessionHelper().returnToHomePage();
        Thread.sleep(3000);
        int after = app.getTeamHelper().getTeamsCount();
        Assert.assertEquals(after, before);
    }

    @Test (enabled = false)
    public void testTeamCreationFromPlusButtonOnLeftNavMenu() throws InterruptedException {
        int before = app.getTeamHelper().getTeamsCount();
        app.getSessionHelper().clickOnPlusButtonFromLeftNavMenu();
        Thread.sleep(3000);
        String teamName = "QA21" + System.currentTimeMillis();
        app.getTeamHelper().fillTeamCreationForm(new TeamData().withTeamName("h").withDescription("g"));
        app.getTeamHelper().clickContinueButton();
        String createdTeamName = app.getTeamHelper().getTeamNameFromTeamPage();
        app.getSessionHelper().returnToHomePage();
        int after = app.getTeamHelper().getTeamsCount();
        Assert.assertEquals(after, before + 1);
        Assert.assertEquals(createdTeamName.toLowerCase(), teamName.toLowerCase());
    }

    @AfterClass(enabled = false)
    public void cleanTeams() throws InterruptedException {
        while (app.getTeamHelper().getTeamsCount() > 2) {
            app.getTeamHelper().clickByFirstTeam();
            app.getTeamHelper().clickByTeamSettings();
            app.getTeamHelper().clickByDeleteTeam();
            app.getTeamHelper().confirmTeamDeletion();
        }
    }*/
}

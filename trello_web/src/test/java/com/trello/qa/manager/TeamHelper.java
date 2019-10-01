package com.trello.qa.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeamHelper extends HelperBase{
    public TeamHelper(WebDriver driver){
        super(driver);
    }

    public void clickContinueButton() {
        click(By.cssSelector("[type='submit']"));
    }

    public void fillTeamCreationForm(TeamData team) {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"), team.getTeamName());
        type(By.cssSelector("textarea"), team.getDescription());
    }

    public void selectCreateTeamFromDropDown() {
        click(By.cssSelector("[data-test-id='header-create-team-button']"));
    }

    public String getTeamNameFromTeamPage() {
        return driver.findElement(By.cssSelector("h")).getText();
    }

    public int getTeamsCount() throws InterruptedException {
       // Thread.sleep(3000);
        //new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li")));
        return driver.findElements(By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li")).size();
    }

    public void confirmTeamDeletion() {
        click(By.cssSelector(".pop-over.is-shown input[type='submit']"));
    }

    public void clickByDeleteTeam() {
        click(By.cssSelector(".quiet-button"));
    }

    public void clickByFirstTeam() {
        click(By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li[1]"));
    }

   public void clickByTeamSettings() throws InterruptedException {
       Thread.sleep(3000);
       // new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='_3AG-Gnm-Fqx-I3']//li[4]")));
       click(By.cssSelector("[class='icon-gear icon-sm _2aV_KY1gTq1qWc']"));
    }



    public void initEditTeamProfile() {
        click(By.cssSelector(".js-edit-profile"));
    }

    public void changeTeamProfile(String name, String discription) {
        type(By.name("displayName"),name);
        type(By.name("desc"),discription);
    }

    public void confirmEditTeam() {
        click(By.cssSelector(".js-submit-profile"));
    }

    public boolean isTeamsPresent() throws InterruptedException {
        return getTeamsCount()>0;
    }

    public void createTeam() throws InterruptedException {
        clickOnPlusButtonOnHeader();
        selectCreateTeamFromDropDown();
        fillTeamCreationForm(new TeamData().withTeamName("qa21").withDescription("descr qa21"));
        clickContinueButton();
        returnToHomePage();
    }
}

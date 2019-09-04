package com.trello.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase{
    @Test
    public void testTeamCreation(){
        Assert.assertTrue(isUserLoggedIn());
        click(By.cssSelector("[class='icon-add icon-sm OiX3P2i2J92Xat']"));
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"),"QA");
        click(By.cssSelector("[class='_3UeOvlU6B5KUnS X1P6DVryq8CYGC _2MgouXHqRQDP_5']"));
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.cssSelector("[name='house']"));
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size()>0;
    }
}

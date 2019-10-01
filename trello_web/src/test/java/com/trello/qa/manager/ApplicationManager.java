package com.trello.qa.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager{
    WebDriver driver;
    TeamHelper teamHelper;
    BoardHelper boardHelper;
    SessionHelper sessionHelper;
    private String browser;

    public ApplicationManager(String browser) {

        this.browser = browser;
    }

    public void init() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        sessionHelper = new SessionHelper(driver);
        sessionHelper.openSite("https://trello.com");
        sessionHelper.login("sveta.vitkina@yandex.ua", "dasha2004");
        teamHelper = new TeamHelper(driver);
        boardHelper = new BoardHelper(driver);
      /*  String browser = null;
        if(browser.equals(BrowserType.CHROME)){
            driver = new ChromeDriver();
        }
        if(browser.equals(BrowserType.EDGE)){
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        sessionHelper = new SessionHelper(driver);
        sessionHelper.openSite("https://trello.com/");
        sessionHelper.login("sveta.vitkina@yandex.ua", "dasha2004");
        teamHelper = new TeamHelper(driver);
        boardHelper = new BoardHelper(driver);*/
    }

    public void stop() {
        driver.quit();
    }

    public TeamHelper getTeamHelper() {
        return teamHelper;
    }

    public BoardHelper getBoardHelper() {
        return boardHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}

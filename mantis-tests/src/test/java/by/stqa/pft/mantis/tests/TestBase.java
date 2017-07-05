package by.stqa.pft.mantis.tests;


import by.stqa.pft.mantis.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;

import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;


/**
 * Created by User on 4/20/2017.
 */
public class TestBase {
    protected static final ApplicationManager app =
            new ApplicationManager(System.getProperty("browser",BrowserType.CHROME));  // система принимает системное свойство и при его
    // отсутствии - берёт дефалтовое значение

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite (alwaysRun = true)

    public void tearDown() {
        app.stop();
    }
    }



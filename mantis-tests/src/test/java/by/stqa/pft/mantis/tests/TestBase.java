package by.stqa.pft.mantis.tests;


import by.stqa.pft.mantis.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;

import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;


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
        app.ftp().upload(new File("src/test/resources/config_inc.php"),"config/config_inc.php","config/config_inc.php.back");
    }

    @AfterSuite (alwaysRun = true)

    public void tearDown() throws IOException {
        app.stop();
        app.ftp().restore("config/config_inc.php.back","config/config_inc.php");
    }
    }



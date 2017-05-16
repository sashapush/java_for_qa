package by.mmjava.addressbook.tests;


import by.mmjava.addressbook.appmanager.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.BeforeSuite;

/**
 * Created by User on 4/20/2017.
 */
public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite

    public void tearDown() {
        app.stop();
    }


}


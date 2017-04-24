package by.mmjava.addressbook.tests;


import by.mmjava.addressbook.appmanager.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import sun.plugin2.util.BrowserType;
import org.openqa.selenium.remote.BrowserType;

/**
 * Created by User on 4/20/2017.
 */
public class TestBase {

    protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

}


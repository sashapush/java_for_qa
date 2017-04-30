package by.mmjava.addressbook.tests;


import by.mmjava.addressbook.appmanager.ApplicationManager;
import by.mmjava.addressbook.model.ContactData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.remote.BrowserType;

/**
 * Created by User on 4/20/2017.
 */
public class TestBase {

    protected final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }


}


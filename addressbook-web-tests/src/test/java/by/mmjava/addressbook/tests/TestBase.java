package by.mmjava.addressbook.tests;


import by.mmjava.addressbook.appmanager.ApplicationManager;
import by.mmjava.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


/**
 * Created by User on 4/20/2017.
 */
public class TestBase extends  ApplicationManager{

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

}


package by.mmjava.addressbook.tests;


import by.mmjava.addressbook.appmanager.ApplicationManager;
import by.mmjava.addressbook.model.GroupData;
import by.mmjava.addressbook.model.Groups;
import org.apache.xpath.operations.Bool;
import org.hamcrest.CoreMatchers;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by User on 4/20/2017.
 */
public class TestBase {
    org.slf4j.Logger logger = LoggerFactory.getLogger(TestBase.class);
    protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser",BrowserType.CHROME));  // система принимает системное свойство и при его
    // отсутствии - берёт дефалтовое значение

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite (alwaysRun = true)

    public void tearDown() {
        app.stop();
    }


    @BeforeMethod
    public void logTestStart(Method m, Object[] p) {
        logger.info("Start test " + m.getName() + "with parameters" + Arrays.asList(p));

    }
    @AfterMethod (alwaysRun = true)
    public void logTestStop(Method m){
        logger.info("Stop test " + m.getName());
}
    public void verifyGroupListInUI() {
        if (Boolean.getBoolean("verifyUI")) {
        Groups dbGroups = app.db().groups();
        Groups uiGroups = app.group().all();
        assertThat(uiGroups, equalTo(dbGroups.stream().
                map((g)-> new GroupData().withId(g.getId()).withName(g.getName())).collect(Collectors.toSet())));
    }
    }


}


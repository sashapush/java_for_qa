package by.mmjava.addressbook;

<<<<<<< HEAD:addressbook-web-tests/src/test/java/by/mmjava/addressbook/appmanager/ApplicationManager.java
import by.mmjava.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by User on 4/20/2017.
 */
public class ApplicationManager {
    FirefoxDriver wd;
    private SessionHelper sessionHelper;
    private  NavigationHelper navigationHelper;
    private  GroupHelper groupHelper;
=======
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class GroupCreationTests {
    FirefoxDriver wd;
>>>>>>> parent of aa8fb1c... Created applicationManager and delegation:addressbook-web-tests/src/test/java/by/mmjava/addressbook/GroupCreationTests.java

    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
<<<<<<< HEAD:addressbook-web-tests/src/test/java/by/mmjava/addressbook/appmanager/ApplicationManager.java
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");
=======
        login("admin", "secret");
    }

    private void login(String username, String password) {
        wd.findElement(By.cssSelector("html")).click();
        wd.findElement(By.cssSelector("html")).click();
        wd.findElement(By.cssSelector("html")).click();
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    @Test
    public void testGroupCreation() {
        gotoGroupsPage();
        initGroupCreation();
        fillGroupForm(new GroupData("test1", "test2", "test3"));
        submitGroupCreation();
        returntoGroupPage();
    }

    private void returntoGroupPage() {
        wd.findElement(By.cssSelector("html")).click();
        wd.findElement(By.linkText("group page")).click();
    }

    private void submitGroupCreation() {
        wd.findElement(By.name("submit")).click();
    }

    private void fillGroupForm(GroupData groupData) { //метод принимает параметр типа GroupData, параметр с 3мя аттрибутами
        wd.findElement(By.cssSelector("body")).click();
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
        wd.findElement(By.cssSelector("body")).click();
        wd.findElement(By.id("content")).click();
    }

    private void initGroupCreation() {
        wd.findElement(By.cssSelector("body")).click();
        wd.findElement(By.name("new")).click();
    }

    private void gotoGroupsPage() {
        wd.findElement(By.cssSelector("html")).click();
        wd.findElement(By.cssSelector("body")).click();
        wd.findElement(By.cssSelector("body")).click();
        wd.findElement(By.linkText("groups")).click();
>>>>>>> parent of aa8fb1c... Created applicationManager and delegation:addressbook-web-tests/src/test/java/by/mmjava/addressbook/GroupCreationTests.java
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }

<<<<<<< HEAD:addressbook-web-tests/src/test/java/by/mmjava/addressbook/appmanager/ApplicationManager.java
    public void deleteSelectedGroups() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[5]")).click();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
=======
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
>>>>>>> parent of aa8fb1c... Created applicationManager and delegation:addressbook-web-tests/src/test/java/by/mmjava/addressbook/GroupCreationTests.java
    }

}

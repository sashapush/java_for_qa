package by.mmjava.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
/**
 * Created by User on 4/20/2017.
 */
public class ApplicationManager {
    WebDriver wd;
    private ContactHelper contactHelper;
    private SessionHelper sessionHelper;
    private  NavigationHelper navigationHelper;
    private  GroupHelper groupHelper;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (Objects.equals(browser, BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        }
        else if (Objects.equals(browser, BrowserType.CHROME)){
            wd = new ChromeDriver();
        }else if (Objects.equals(browser, BrowserType.IE)){
            wd = new InternetExplorerDriver();
        }
        //wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); //ф.е. проверка отсутствия элемента - таймаут;
        wd.get("http://localhost/addressbook/");
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        contactHelper = new ContactHelper(wd);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        wd.quit();
    }


    public GroupHelper group() {
        return groupHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() {       return contactHelper;    }
}

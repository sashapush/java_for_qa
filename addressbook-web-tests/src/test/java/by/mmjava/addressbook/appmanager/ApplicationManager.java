package by.mmjava.addressbook.appmanager;

import by.mmjava.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by User on 4/20/2017.
 */
public class ApplicationManager {
    FirefoxDriver wd;

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
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

    public void returntoGroupPage() {
        wd.findElement(By.cssSelector("html")).click();
        wd.findElement(By.linkText("group page")).click();
    }

    public void submitGroupCreation() {
        wd.findElement(By.name("submit")).click();
    }

    public void fillGroupForm(GroupData groupData) { //метод принимает параметр типа GroupData, параметр с 3мя аттрибутами
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

    public void initGroupCreation() {
        wd.findElement(By.cssSelector("body")).click();
        wd.findElement(By.name("new")).click();
    }

    public void gotoGroupsPage() {
        wd.findElement(By.cssSelector("html")).click();
        wd.findElement(By.cssSelector("body")).click();
        wd.findElement(By.cssSelector("body")).click();
        wd.findElement(By.linkText("groups")).click();
    }

    public void stop() {
        wd.quit();
    }

    public void deleteSelectedGroups() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[5]")).click();
    }

    public void selectGroup() {
        if (!wd.findElement(By.xpath("//div[@id='content']/form/span[5]/input")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/span[5]/input")).click();
        }
    }
}

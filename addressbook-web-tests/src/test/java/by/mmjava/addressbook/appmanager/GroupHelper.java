package by.mmjava.addressbook.appmanager;

import by.mmjava.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by User on 4/22/2017.
 */
public class GroupHelper extends HelperBase {


    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returntoGroupPage() {
        //click(By.cssSelector("html")); for Chromiun compatibility
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) { //метод принимает параметр типа GroupData, параметр с 3мя аттрибутами
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
            }

    public void initGroupCreation() {
        click(By.cssSelector("body"));
        click(By.name("new"));
    }

    public void selectGroup() {
        if (! isElementPresent((By.name("selected[]")))) {
            click(By.name("selected[]"));
        }
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupUpdate() {
        click(By.name("update"));
    }

    public void createGroup(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returntoGroupPage();

    }
    public void deleteSelectedGroups() {
        click(By.name("selected[]"));
        click(By.name("delete"));
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }
}

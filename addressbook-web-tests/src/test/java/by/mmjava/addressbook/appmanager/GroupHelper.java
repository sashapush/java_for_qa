package by.mmjava.addressbook.appmanager;

import by.mmjava.addressbook.model.GroupData;
import by.mmjava.addressbook.model.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.HashSet;
import java.util.List;

/**
 * Created by User on 4/22/2017.
 */
public class GroupHelper extends HelperBase {


    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
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

    public void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value='"+ id +"']")).click();
}

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupUpdate() {
        click(By.name("update"));
    }

    public void modify(GroupData group) {
        selectGroupById(group.getId());
        initGroupModification();
        fillGroupForm(group);
        submitGroupUpdate();
        groupsCache = null;
        returnToGroupPage();
    }
    public void create(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        groupsCache = null;
        returnToGroupPage();
}

    public void deleteSelectedGroups() {
        //click(By.name("selected[]")); prevent selecting 2 elements
        click(By.name("delete"));
    }
    public void delete(GroupData group) {
        selectGroupById(group.getId());
        deleteSelectedGroups();
        groupsCache = null;
        returnToGroupPage();
    }


    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    private Groups groupsCache = null;

    public Groups all() {
        if (groupsCache != null)
        {
            return new Groups(groupsCache);
        }
        groupsCache = new Groups();
        List <WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements){
            String name = element.getText();
            int id =  Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groupsCache.add(new GroupData().withId(id).withName(name));
        }
        return  new Groups(groupsCache);
    }


}

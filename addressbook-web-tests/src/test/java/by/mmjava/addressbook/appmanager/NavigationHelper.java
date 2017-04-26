package by.mmjava.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by User on 4/22/2017.
 */
public class NavigationHelper extends HelperBase {
    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoGroupsPage() {
        if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new")) )  //проверяем наличие тэга h1, + ищем элемент с тэгом h1 и текстом "Group" + ищем наличие кнопки
        {return;}
        click(By.linkText("groups"));
    }


    public void gotoAddNewContact() {
        click(By.linkText("add new"));
    }
    public void gotoHome () {
        if (isElementPresent(By.id("maintable"))){
            return;
        }
        click(By.linkText("home"));
    }

}

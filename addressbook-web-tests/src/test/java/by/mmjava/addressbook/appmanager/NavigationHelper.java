package by.mmjava.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by User on 4/22/2017.
 */
public class NavigationHelper extends HelperBase {
    public NavigationHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void gotoGroupsPage() {
          click(By.linkText("groups"));
    }

    public void gotoAddNewContact() {
        wd.findElement(By.linkText("add new")).click();
    }
}

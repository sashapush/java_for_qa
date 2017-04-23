package by.mmjava.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by User on 4/22/2017.
 */
public class NavigationHelper extends HelperBase {
    private FirefoxDriver wd;

    public NavigationHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void gotoGroupsPage() {
          click(By.linkText("groups"));
    }
}

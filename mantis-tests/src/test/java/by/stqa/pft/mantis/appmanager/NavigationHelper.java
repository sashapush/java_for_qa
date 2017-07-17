package by.stqa.pft.mantis.appmanager;

import by.stqa.pft.mantis.tests.TestBase;
import org.eclipse.jetty.io.ClientConnectionFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by User on 4/22/2017.
 */
public class NavigationHelper extends HelperBase {
    private WebDriver wd;

    public NavigationHelper(ApplicationManager app) {
        super(app);
        wd = app.getDriver();
    }


    public void homePage() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        click(By.linkText("home page"));
    }

    public void manage() {
        click(By.xpath("//li[6]/a/span"));
    }


    public void usersTab() {
        click(By.linkText("Manage Users"));

    }
}

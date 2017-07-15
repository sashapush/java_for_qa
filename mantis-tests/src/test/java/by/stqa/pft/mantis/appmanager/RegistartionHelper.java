package by.stqa.pft.mantis.appmanager;

import org.openqa.selenium.WebDriver;

/**
 * Created by User on 7/12/2017.
 */
public class RegistartionHelper {
    private final ApplicationManager app;
    private WebDriver wd;

    public RegistartionHelper(ApplicationManager app) {
        this.app=app;
        wd=app.getDriver();
    }

    public void start(String username, String email) {
        wd.get(app.getProperty("web.baseUrl")+ "/signup_page.php");
    }
}

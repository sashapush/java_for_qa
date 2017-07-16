package by.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;


/**
 * Created by User on 7/12/2017.
 */
public class RegistrationHelper extends HelperBase {
    public RegistrationHelper(ApplicationManager app) {
        super(app);
        }


    public void start(String username, String email) {
        wd.get(app.getProperty("web.baseUrl")+ "/signup_page.php");
        type(By.name("username"),username);
        type(By.name("email"),email);
        click(By.cssSelector("input[value='Signup]"));
    }
}

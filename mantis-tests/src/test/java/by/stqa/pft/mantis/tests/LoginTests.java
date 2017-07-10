package by.stqa.pft.mantis.tests;

import by.stqa.pft.mantis.appmanager.HttpSession;

import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

/**
 * Created by User on 7/10/2017.
 */
public class LoginTests extends TestBase{

    @Test
    public void testLogin() throws IOException {
        HttpSession session =app.newSession();
        assertTrue(session.login("administrator","root"));
        assertTrue(session.isLoggedInAs("administrator"));
    }
}

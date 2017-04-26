package by.mmjava.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by User on 4/24/2017.
 */
public class ContactDeletionTest extends TestBase {
    @Test
    public void testContactDeletion()
    {
        app.getNavigationHelper().gotoHome();
        app.getContactHelper().selectContact();
        app.getContactHelper().clickEditContact();
        app.getContactHelper().deleteContact();
        app.getNavigationHelper().gotoHome();
    }
}

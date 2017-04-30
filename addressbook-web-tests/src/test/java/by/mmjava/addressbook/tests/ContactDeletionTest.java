package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.ContactData;
import org.testng.annotations.Test;

/**
 * Created by User on 4/24/2017.
 */
public class ContactDeletionTest extends TestBase {
    @Test
    public void testContactDeletion()
    {
        app.getNavigationHelper().gotoHome();
        if (!app.getContactHelper().isThereAContact()){
            app.getContactHelper().contactCreation();
        }
        app.getNavigationHelper().gotoHome();
        app.getContactHelper().selectContact();
        app.getContactHelper().clickEditContact();
        app.getContactHelper().deleteContact();
        app.getNavigationHelper().gotoHome();
    }
}

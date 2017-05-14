package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by User on 4/24/2017.
 */
public class ContactDeletionTest extends TestBase {
    @Test(enabled = false)
    public void testContactDeletion()
    {
        app.goTo().Home();
        if (!app.getContactHelper().isThereAContact()){
            app.getContactHelper().contactCreation();
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.goTo().Home();
        app.getContactHelper().selectContact(before.size()-1);
        app.getContactHelper().clickEditContact(before.size()-1);
        app.getContactHelper().deleteContact();
        app.goTo().Home();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size() -1);
        before.remove(before.size()-1);
        Assert.assertEquals(before,after);

    }
}

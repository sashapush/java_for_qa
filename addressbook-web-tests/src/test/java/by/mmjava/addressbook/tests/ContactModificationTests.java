package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by User on 4/24/2017.
 */
public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification()
    {
        app.getNavigationHelper().gotoHome();
        if (!app.getContactHelper().isThereAContact()){
            app.getContactHelper().contactCreation();
        }
        app.getNavigationHelper().gotoHome();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size()-1);
        app.getContactHelper().clickEditContact(before.size()-1);
        ContactData contact = new ContactData(before.get(before.size()-1).getId(),"lalal","modified","alex",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
        app.getContactHelper().addContactData(contact,false);
        app.getContactHelper().submitUpdatedContactData();
        app.getNavigationHelper().gotoHome();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size());
        before.remove(before.size()-1);
        before.add(contact);
        Comparator<? super  ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
        }

}

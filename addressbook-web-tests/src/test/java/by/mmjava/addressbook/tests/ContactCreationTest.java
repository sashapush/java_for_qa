package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase{

    @Test //(enabled = false)
    public void testContactCreation() {
        app.goTo().Home();
        List<ContactData> before = app.contact().list();
        //to do - send photo
        ContactData contact = new ContactData()
                .withFirstname("test2").withLastname("test last name").withEmail("email@test.com").withGroup("new").withBirthYear("1992").withAnniversaryYear("2200");
        app.contact().create(contact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() + 1);
        before.add(contact);
        Comparator<? super  ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }

}

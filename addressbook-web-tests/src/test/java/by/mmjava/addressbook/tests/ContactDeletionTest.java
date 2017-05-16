package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by User on 4/24/2017.
 */
public class ContactDeletionTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().Home();
        if (app.contact().list().size()==0){
            app.contact().create(new ContactData().withFirstname("test2").withLastname("test last name").withEmail("email@test.com"));
        }
        app.goTo().Home();
    }
    @Test
    public void testContactDeletion()
    {
        List<ContactData> before = app.contact().list();
        int index = before.size()-1;
        app.goTo().Home();
        app.contact().delete(index);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(),before.size() -1);
        before.remove(index);
        Assert.assertEquals(before,after);

    }


}

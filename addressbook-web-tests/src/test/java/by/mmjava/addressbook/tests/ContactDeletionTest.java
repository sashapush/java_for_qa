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
            app.contact().create(new ContactData("pre", null, "pre", "nick", "title", "company name", "address 1", "12345", "67894", "54577", "11", "tests@tests.com", "test2@tests.com", "test3@tests.com", "http://tests.com", "address 1\naddress 2", "1992", "2222", "test22","secondary address", "secondary home", "secondary notes"));
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

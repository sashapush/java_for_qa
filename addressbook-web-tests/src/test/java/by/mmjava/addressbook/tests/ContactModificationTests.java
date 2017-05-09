package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.ContactData;
import org.testng.annotations.Test;

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
        app.getContactHelper().selectContact(1);
        app.getContactHelper().clickEditContact();
        app.getContactHelper().addContactData(new ContactData("modified","modified","alex",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null),false);
        //app.getContactHelper().addContactData(new ContactData("changed", "changed", "changed", "nick", "title", "company name", "address 1", "12345", "67894", "54577", "11", "tests@tests.com", "test2@tests.com", "test3@tests.com", "http://tests.com", "address 1\naddress 2", "1992", "2222", null,"secondary address", "secondary home", "secondary notes"),false);
        app.getContactHelper().submitUpdatedContactData();
    }

}

package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.appmanager.HelperBase;
import org.testng.annotations.Test;

/**
 * Created by User on 4/24/2017.
 */
public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification()
    {
        app.getNavigationHelper().gotoAddNewContact();
    }

}

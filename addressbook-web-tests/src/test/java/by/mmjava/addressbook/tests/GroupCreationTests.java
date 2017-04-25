package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupsPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("test1", null,null));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returntoGroupPage();
    }

}

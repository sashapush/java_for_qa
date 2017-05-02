package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        for (int i = 1; i < 9; i++) {
            app.getNavigationHelper().gotoGroupsPage();
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
    }
}

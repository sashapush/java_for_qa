package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        for (int i=0;i<15;i++) {
            app.getNavigationHelper().gotoGroupsPage();
            int before = app.getGroupHelper().getGroupCount();
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
            int after = app.getGroupHelper().getGroupCount();
            Assert.assertEquals(after, before + 1);
        }
    }
}

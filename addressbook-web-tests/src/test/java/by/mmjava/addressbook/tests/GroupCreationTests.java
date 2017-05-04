package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        //for (int i=0;i<15;i++) {
            app.getNavigationHelper().gotoGroupsPage();
            List<GroupData> before = app.getGroupHelper().getGroupList();
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
            List<GroupData> after = app.getGroupHelper().getGroupList();
            Assert.assertEquals(after.size(), before.size() + 1);
        //}
    }
}

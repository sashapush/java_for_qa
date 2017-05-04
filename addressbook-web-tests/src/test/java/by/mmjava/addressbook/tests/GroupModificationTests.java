package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by User on 4/24/2017.
 */
public class GroupModificationTests extends TestBase{

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupsPage();
        if (!app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("pre", "condition",null));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size()-1);
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("modification", "88", "77"));
        app.getGroupHelper().submitGroupUpdate();
        app.getGroupHelper().returntoGroupPage();
        List<GroupData> after  = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(),before.size());
        Assert.assertEquals(before,after);
    }
}

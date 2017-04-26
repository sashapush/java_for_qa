package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.GroupData;
import org.testng.annotations.Test;

/**
 * Created by User on 4/24/2017.
 */
public class GroupModificationTests extends TestBase{

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupsPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("test1", "88", "77"));
        app.getGroupHelper().submitGroupUpdate();
        app.getGroupHelper().returntoGroupPage();
    }
}

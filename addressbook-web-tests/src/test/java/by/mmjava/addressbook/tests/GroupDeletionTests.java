package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().gotoGroupsPage();
        if (!app.getGroupHelper().isThereAGroup()){
app.getGroupHelper().createGroup(new GroupData("test1", "header",null));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
//        app.getGroupHelper().returntoGroupPage();
    }

}

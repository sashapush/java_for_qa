package by.mmjava.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().gotoGroupsPage();
        app.getGroupHelper().selectGroup();
        app.deleteSelectedGroups();
        app.getGroupHelper().returntoGroupPage();
    }

}

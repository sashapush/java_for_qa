package by.mmjava.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.gotoGroupsPage();
        app.selectGroup();
        app.deleteSelectedGroups();
        app.returntoGroupPage();
    }

}

package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions ()
    {
        app.goTo().GroupsPage();
        if ( app.group().list().size()==0){
            app.group().create(new GroupData("pre", "condition",null));
        }
    }
    @Test
    public void testGroupDeletion() {
        app.goTo().GroupsPage();
        if (!app.group().isThereAGroup()){
            app.group().create(new GroupData("test1", "header",null));
        }
        List<GroupData> before = app.group().list();
        int index = before.size()-1;
        app.group().delete(index);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(),before.size() -1);
        before.remove(index);
        Assert.assertEquals(before,after);
}


}

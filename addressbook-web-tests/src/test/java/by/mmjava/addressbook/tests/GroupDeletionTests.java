package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions ()
    {
        app.goTo().GroupsPage();
        if ( app.group().all().size()==0){
            app.group().create(new GroupData().withName("pre").withHeader("condition"));
        }
    }
    @Test
    public void testGroupDeletion() {
        Set<GroupData> before = app.group().all();
        GroupData deletedGroup = before.iterator().next();  //выбор из множества случайного элемента
        app.group().delete(deletedGroup);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(),before.size() -1);
        before.remove(deletedGroup);
        Assert.assertEquals(before,after);
}


}

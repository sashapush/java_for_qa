package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * Created by User on 4/24/2017.
 */
public class GroupModificationTests extends TestBase{


    @BeforeMethod
    public void ensurePreconditions ()
    {
        app.goTo().GroupsPage();
        if ( app.group().all().size()==0){
            app.group().create(new GroupData().withName("pre").withHeader("condition"));
        }
    }
    @Test
    public void testGroupModification() {
        Set<GroupData> before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();  //выбор из множества случайного элемента
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("new").withHeader("group").withFooter("footer");
        app.group().modify(group);
        Set<GroupData> after  = app.group().all();
        Assert.assertEquals(after.size(),before.size());
//contact comparison after edition
        before.remove(modifiedGroup);

        before.add(group);
        //сортировка списка
       Assert.assertEquals(before,after);
    }


}

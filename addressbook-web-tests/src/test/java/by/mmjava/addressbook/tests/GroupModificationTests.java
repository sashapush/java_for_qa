package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

/**
 * Created by User on 4/24/2017.
 */
public class GroupModificationTests extends TestBase{


    @BeforeMethod
    public void ensurePreconditions ()
    {
        app.goTo().GroupsPage();
        if ( app.group().list().size()==0){
            app.group().create(new GroupData("pre", "condition",null));
        }
    }
    @Test
    public void testGroupModification() {
        List<GroupData> before = app.group().list();
        int index = before.size()-1;
        GroupData group = new GroupData(before.get(index).getId(),"test1", "88", "77");
        app.group().modify(index, group);
        List<GroupData> after  = app.group().list();
        Assert.assertEquals(after.size(),before.size());
//contact comparison after edition
        before.remove(index);

        before.add(group);
        //сортировка списка
        Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }


}

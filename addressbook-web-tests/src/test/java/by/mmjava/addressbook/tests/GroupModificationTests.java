package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
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
        GroupData group = new GroupData(before.get((before.size()-1)).getId(),"test1", "88", "77");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupUpdate();
        app.getGroupHelper().returntoGroupPage();
        List<GroupData> after  = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(),before.size());
//contact comparison after edition
        before.remove(before.size()-1);
        before.add(group);
        //сортировка списка
        Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }
}

package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        //for (int i=0;i<15;i++) {
        app.goTo().GroupsPage();
        Set<GroupData> before = app.group().all();
        GroupData group = new GroupData().withName("test22");
        app.group().create(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size() + 1);
        /*int max=0;
        for (GroupData g : after){
            if (g.getId()>max) {
                max = g.getId();
            }
        }*/
        group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()); //поток объектов GroupData превращаем в поток идентификаторов, получаем поток целых чисел, getAsInt;
        before.add(group);
    Assert.assertEquals(before,after);
    }
}

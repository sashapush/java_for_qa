package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.GroupData;
import by.mmjava.addressbook.model.Groups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.equalToObject;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {
@DataProvider
public Iterator<Object[]>  validGroups() { // итератор массивов объектов
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new GroupData().withName("test1").withHeader("header 1").withFooter("footer 1")}); //массив из одного объекта GroupData
    list.add(new Object[] {new GroupData().withName("test2").withHeader("header 2").withFooter("footer 2")});
    list.add(new Object[] {new GroupData().withName("test3").withHeader("header 3").withFooter("footer 3")});
    return list.iterator();

}



    @Test(dataProvider = "validGroups" )
    public void testGroupCreation(GroupData group) {
             app.goTo().GroupsPage();
            Groups before = app.group().all();
            app.group().create(group);
            assertThat(app.group().count(),equalTo(before.size() + 1));
            Groups after = app.group().all();
       /*int max=0;
        for (GroupData g : after){
            if (g.getId()>max) {
                max = g.getId();
            }
        }*/
            //поток объектов GroupData превращаем в поток идентификаторов, получаем поток целых чисел, getAsInt;
            assertThat(after, equalToObject(
                    before.withAdded(group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
        }
@Test
    public void testBadGroupCreation() {
        app.goTo().GroupsPage();
            Groups before = app.group().all();
            GroupData group = new GroupData().withName("test'");
            app.group().create(group);
        assertThat(app.group().count(),equalTo(before.size()));
            Groups after = app.group().all();
            assertThat(after, equalTo(before));
                    }}


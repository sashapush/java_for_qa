package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.GroupData;
import by.mmjava.addressbook.model.Groups;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.equalToObject;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        //for (int i=0;i<55;i++) {
        app.goTo().GroupsPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test22");
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
//    }
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


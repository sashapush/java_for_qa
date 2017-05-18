package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.GroupData;
import by.mmjava.addressbook.model.Groups;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalToObject;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        //for (int i=0;i<15;i++) {
        app.goTo().GroupsPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test22");
        app.group().create(group);
        Groups after = app.group().all();
        assertThat(after.size(),equalToObject(before.size() + 1));
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
}

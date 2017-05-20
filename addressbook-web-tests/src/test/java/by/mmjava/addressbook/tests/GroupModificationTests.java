package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.GroupData;
import by.mmjava.addressbook.model.Groups;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.equalToObject;
import static org.hamcrest.MatcherAssert.assertThat;

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
        Groups before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();  //выбор из множества случайного элемента
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("new").withHeader("group").withFooter("footer");
        app.group().modify(group);
        assertThat(app.group().count(),equalTo(before.size() ));
        Groups after  = app.group().all();
        Assert.assertEquals(after.size(),before.size());
        MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.withModified(modifiedGroup,group)));
        //MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.without(modifiedGroup).withAdded(group)));
    }


}

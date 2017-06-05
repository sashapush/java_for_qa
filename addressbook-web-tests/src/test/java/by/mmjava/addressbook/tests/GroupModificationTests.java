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

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.equalToObject;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.*;

/**
 * Created by User on 4/24/2017.
 */
public class GroupModificationTests extends TestBase{


    @BeforeMethod
    public void ensurePreconditions ()
    { int a=app.db().groups().size();
        if (app.db().groups().size()==0){
        app.group().create(new GroupData().withName("pre").withHeader("condition"));}
       }

    @Test
    public void testGroupModification() {
        Groups before = app.db().groups();
        GroupData modifiedGroup = before.iterator().next();  //выбор из множества случайного элемента
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("modified").withHeader("group").withFooter("footer");
        app.goTo().GroupsPage();
        app.group().modify(group);
        assertThat(app.group().count(),equalTo(before.size() ));
        Groups after  = app.db().groups();
        assertEquals(after.size(),before.size());
        assertThat(after, equalTo(before.withModified(modifiedGroup,group)));
        verifyGroupListInUI();
        //MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.without(modifiedGroup).withAdded(group)));
    }



}

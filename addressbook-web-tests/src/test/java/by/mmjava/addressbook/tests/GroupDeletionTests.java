package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.GroupData;
import by.mmjava.addressbook.model.Groups;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.equalToObject;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions ()
    {
        app.goTo().GroupsPage();
        if ( app.db().groups().size()==0){
            app.group().create(new GroupData().withName("pre").withHeader("condition"));
        }
    }
    @Test
    public void testGroupDeletion() {
        Groups before = app.db().groups();
        GroupData deletedGroup = before.iterator().next();  //выбор из множества случайного элемента
        app.group().delete(deletedGroup);
        assertThat(app.group().count(),equalTo(before.size() -1));
        Groups after = app.db().groups();
        assertThat(after, equalTo(before.without(deletedGroup)));
        }


}

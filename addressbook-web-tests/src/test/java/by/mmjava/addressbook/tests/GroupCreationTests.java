package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.GroupData;
import by.mmjava.addressbook.model.Groups;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.equalToObject;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {
@DataProvider
public Iterator<Object[]> validGroupsFromXML() throws IOException { // итератор массивов объектов
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml"))); // завернули обычный ридер вБуферед ридер
    String xml = "";
    String line = reader.readLine();
    while (line != null){
        xml +=line;
        line = reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(GroupData.class);
    List<GroupData> groups = (List<GroupData>)xstream.fromXML(xml);
    return groups.stream().map((g -> new Object[] {g} )).collect(Collectors.toList()).iterator();
    }
    @DataProvider
    public Iterator<Object[]> validGroupsFromJSON() throws IOException { // итератор массивов объектов
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.json"))); // завернули обычный ридер вБуферед ридер
        String json = "";
        String line = reader.readLine();
        while (line != null){
            json +=line;
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>(){}.getType());  //List <GroupData>.class
        return groups.stream().map((g -> new Object[] {g} )).collect(Collectors.toList()).iterator();
    }
    @Test(dataProvider = "validGroupsFromJSON")
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
@Test (enabled = false)
    public void testBadGroupCreation() {
        app.goTo().GroupsPage();
            Groups before = app.group().all();
            GroupData group = new GroupData().withName("test'");
            app.group().create(group);
        assertThat(app.group().count(),equalTo(before.size()));
            Groups after = app.group().all();
            assertThat(after, equalTo(before));
                    }}


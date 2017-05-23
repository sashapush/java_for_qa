package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.GroupData;
import by.mmjava.addressbook.model.Groups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.equalToObject;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {
@DataProvider
public Iterator<Object[]>  validGroups() throws IOException { // итератор массивов объектов
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv"))); // завернули обычный ридер вБуферед ридер
    String line = reader.readLine();
    while (line != null){
        String[] split = line.split(";");//обработка прочитанных строк. Деление на части
        list.add(new Object[]{new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])});     //из полученных кусочков строим массив, состоящий из одного объекта и добавляем его в список;
        line = reader.readLine();
    }
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


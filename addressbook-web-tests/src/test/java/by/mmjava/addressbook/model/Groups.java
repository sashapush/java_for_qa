package by.mmjava.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 5/18/2017.
 */
public class Groups extends ForwardingSet <GroupData> {

    private Set<GroupData> delegate;

    public Groups(Groups groups) {
        this.delegate =new HashSet<GroupData>(groups.delegate()); //берём множество из существующего объекта который передан в качестве параметра, строим новое множество, содержащее те же самые элементы
        // и присваиваем это d новое множество в качестве аттрибута в новый, создаваемый этим контруктором объект
    }

    public Groups() {
        this.delegate = new HashSet<GroupData>();
    }


    @Override
    protected Set<GroupData> delegate() {
        return delegate;
    }

    public Groups withAdded(GroupData group){  //метод делает копию
        Groups groups = new Groups(this);
        groups.add(group);
        return groups;
    }

    public Groups without(GroupData group){
        Groups groups = new Groups(this);
        groups.remove(group);
        return groups;
    }

    public Groups withModified(GroupData group, GroupData modifiedGroup){
        Groups groups = new Groups(this);
        groups.remove(group);
        groups.add(modifiedGroup);
        return groups;
    }
}

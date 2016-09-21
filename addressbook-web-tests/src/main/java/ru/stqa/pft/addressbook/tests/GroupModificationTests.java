package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.*;

/**
 * Created by goga on 27.07.2016.
 */
public class GroupModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if ( app.group().list().size() == 0){
            app.group().create(new GroupDate("test1", null, null));
        }
    }

    @Test
    public void testGroupModification(){
        List<GroupDate> before = app.group().list();
        int index = before.size() - 1;
        GroupDate group = new GroupDate(before.get(index).getId(),"test1", "test2", "test3");
        app.group().modify(index, group);
        List<GroupDate> after = app.group().list();
        Assert.assertEquals(after.size(),before.size());
        before.remove(index);
        before.add(group);
        // можно сортировать коллекции с тем порядком который нужен
        // до Java8
        //Collections.sort(list, Comporator);
        // в java8
        Comparator<? super GroupDate> ById = (g1,g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(ById);
        after.sort(ById);
        Assert.assertEquals( before , after);
    }
}

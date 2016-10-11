package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

/**
 * Created by goga on 27.07.2016.
 */
public class GroupModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if ( app.group().all().size() == 0){
            app.group().create(new GroupDate().withName("test1"));
        }
    }

    @Test
    public void testGroupModification(){
        Groups before = app.group().all();
        GroupDate modifiedGroup = before.iterator().next();
        GroupDate group = new GroupDate()
                .withId(modifiedGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");
        app.group().modify(group);
        assertThat(app.group().Count(),equalTo(before.size()));
        Groups after = app.group().all();
        // можно сортировать коллекции с тем порядком который нужен
        // до Java8
        //Collections.sort(list, Comporator);
        // в java8
        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
    }
}

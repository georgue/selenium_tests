package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.List;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (! app.group().isThereAGroup()){
            app.group().create(new GroupDate("test1", null, null));
        }
    }

    @Test
    public void testGroupDeletion() {
        List<GroupDate> before = app.group().list();
        app.group().selectGroup(before.size() - 1);
        app.group().deleteSelectedGroups();
        app.group().returnToGroupPage();
        List<GroupDate> after = app.group().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

    }

}

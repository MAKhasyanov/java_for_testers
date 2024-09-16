package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class GroupRemovalTests extends TestBase{

    @Test
    public void test() {
        if (app.groups().getCount()==0){
            app.groups().CreateGroup(new GroupData("name", "header", "footer"));
        }
        int groupCount=app.groups().getCount();
        app.groups().removeGroup();
        int newGroupCount=app.groups().getCount();
        Assertions.assertEquals(groupCount-1,newGroupCount);
    }
    @Test
    void canRemoveAllGroupsAtOnce(){
        if (app.groups().getCount()==0){
            app.groups().CreateGroup(new GroupData("name", "header", "footer"));
        }
        app.groups().removeAllGroups();
        Assertions.assertEquals(0,app.groups().getCount());
    }
}

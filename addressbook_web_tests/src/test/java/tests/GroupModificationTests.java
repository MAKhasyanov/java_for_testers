package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class GroupModificationTests extends TestBase{

    @Test
    void canModifyGroup(){
        if (app.groups().getCount()==0){
            app.groups().CreateGroup(new GroupData("name", "header", "footer"));
        }
        app.groups().modifyGroup(new GroupData().withName("modify name"));
    }
}

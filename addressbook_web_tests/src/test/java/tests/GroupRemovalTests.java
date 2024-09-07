package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class GroupRemovalTests extends TestBase{

    @Test
    public void test() {
        if (!app.groups().isGroupPresent()){
            app.groups().CreateGroup(new GroupData("name", "header", "footer"));
        }
        app.groups().removeGroup();
    }
}

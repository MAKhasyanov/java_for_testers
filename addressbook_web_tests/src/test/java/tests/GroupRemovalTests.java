package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TestBase{

    @Test
    public void test() {
        if (!app.groups().isGroupPresent()){
            app.groups().CreateGroup(new GroupData("name", "header", "footer"));
        }
        app.groups().removeGroup();
    }

}

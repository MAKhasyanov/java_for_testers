package manager;

import model.ContactData;
import model.GroupData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcHelper extends HelperBase{
    public JdbcHelper(ApplicationManager manager) {
        super(manager);
    }

    public List<GroupData> getGroupList() {
        var groups=new ArrayList<GroupData>();
        try (var conn= DriverManager.getConnection("jdbc:mysql://localhost/addressbook","root","");
             var statement=conn.createStatement();
             var result=statement.executeQuery("SELECT group_id,group_name,group_header,group_footer FROM group_list"))
        {
            while (result.next()){
                groups.add(new GroupData()
                        .withId(result.getString("group_id"))
                        .withName(result.getString("group_name"))
                        .withHeader(result.getString("group_header"))
                        .withFooter(result.getString("group_footer")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return groups;
    }

    public void checkConsistency() {
        try (var conn= DriverManager.getConnection("jdbc:mysql://localhost/addressbook","root","");
             var statement=conn.createStatement();
             var result=statement.executeQuery("SELECT * FROM address_in_groups ag LEFT JOIN addressbook ab ON ab.id=ag.id WHERE ab.id IS NULL"))
        {
            if (result.next()){
                throw new IllegalStateException("DB is corrupted");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeContactInGroup(int group_id) throws SQLException {
        var conn=DriverManager.getConnection("jdbc:mysql://localhost/addressbook","root","");
        PreparedStatement st = conn.prepareStatement(String.format("DELETE FROM address_in_groups WHERE group_id=%s limit 1", group_id));
        st.executeUpdate();
        st.close();
        conn.close();
    }
    public ContactData checkContactHaveGroup(List<ContactData> contacts) throws SQLException {
        var conn=DriverManager.getConnection("jdbc:mysql://localhost/addressbook","root","");
        for (var contact:contacts){
            PreparedStatement st = conn.prepareStatement(String.format("SELECT* FROM address_in_groups WHERE id=%s", contact.id()));
            var result=st.executeQuery();
            if (!result.next()){
                result.close();
                st.close();
                conn.close();
                return contact;
            }
            result.close();
            st.close();
        }
        conn.close();
        return null;
    }

    public GroupData checkGroupHaveContact(List<GroupData> groups) throws SQLException {
        var conn=DriverManager.getConnection("jdbc:mysql://localhost/addressbook","root","");
        for (var group:groups){
            PreparedStatement st = conn.prepareStatement(String.format("SELECT* FROM address_in_groups WHERE group_id=%s", group.id()));
            var result=st.executeQuery();
            if (!result.next()){
                result.close();
                st.close();
                conn.close();
                return group;
            }
            result.close();
            st.close();
        }
        conn.close();
        return null;

    }

}

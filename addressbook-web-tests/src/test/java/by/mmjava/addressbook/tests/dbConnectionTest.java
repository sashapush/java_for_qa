package by.mmjava.addressbook.tests;

import by.mmjava.addressbook.model.GroupData;
import by.mmjava.addressbook.model.Groups;
import org.testng.annotations.Test;

import java.sql.*;

/**
 * Created by User on 5/29/2017.
 */
public class DbConnectionTest {
    @Test
    public void testDbConnection (){
        Connection conn = null;
        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?serverTimezone=UTC&user=root&password=");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select group_id,group_name,group_header,group_footer from group_list");
            Groups groups = new Groups();
            while (rs.next()) {
                groups.add(new GroupData().withId(rs.getInt("group_id")).withName(rs.getString("group_name")).withHeader(rs.getString("group_header"))
                        .withFooter(rs.getString("group_footer")));
            }
            System.out.println(groups);
            rs.close();
            st.close();
            conn.close();
            // Do something with the Connection
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }


    }

}

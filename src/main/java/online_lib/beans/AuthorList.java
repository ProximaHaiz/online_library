package online_lib.beans;

import online_lib.db.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Proxima on 14.03.2016.
 */
public class AuthorList {
    private List<Author> authorList = new ArrayList<>();

    public List<Author> getAuthorList() {
        return authorList;
    }

    public AuthorList() {
        getData();
    }

    private void getData() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DbConnection.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT a.fio FROM author a ORDER BY a.fio");

            while (rs.next()) {
                authorList.add(new Author(rs.getString("fio"), rs.getLong("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();

            } catch (SQLException e) {
                Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE, null, e);
                e.printStackTrace();
            }
        }
    }

    public void addAuthor(Author author) {
        authorList.add(author);
    }

}

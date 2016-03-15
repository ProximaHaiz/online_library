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
public class GenreList {
    private List<Genre> genreList;


    private void getData() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        genreList = new ArrayList<Genre>();
        try {
            conn = DbConnection.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT g.name FROM genre g ORDER BY g.name ");
            while (rs.next()) {
                genreList.add(new Genre(rs.getString("name"), rs.getLong("id")));
            }
        } catch (SQLException e) {
            Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();

            } catch (SQLException e) {
                Logger.getLogger(GenreList.class.getName()).log(Level.SEVERE, null, e);
                e.printStackTrace();
            }
        }
    }

    public List<Genre> getGenreList() {
        if (!genreList.isEmpty()){
            return genreList;
        }else {

        }
    }
}

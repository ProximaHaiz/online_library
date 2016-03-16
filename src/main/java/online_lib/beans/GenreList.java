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
    private List<Genre> genreList = new ArrayList<>();


    private List<Genre> getGenres() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DbConnection.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM genre  ORDER BY name ");
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
        return genreList;
    }

    public List<Genre> getGenreList() {
        if (!genreList.isEmpty()) {
            return genreList;
        } else {
            return getGenres();
        }
    }
}

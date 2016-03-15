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
import java.util.stream.Collectors;

/**
 * Created by Proxima on 14.03.2016.
 */
public class BookList  {
    private List<Book> bookList = new ArrayList<>();

    public BookList() {
    }

    private List<Book> getBooks(String query) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DbConnection.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getLong("id"));
                book.setName(rs.getString("name"));
                book.setGenre(rs.getString("genre"));
                book.setIsbn(rs.getString("isbn"));
                book.setAuthor(rs.getString("author"));
                book.setPageCount(rs.getInt("page_count"));
                book.setPublich_Date(rs.getInt("publish_year"));
                book.setPublisher(rs.getString("publisher"));
                book.setImage(rs.getBytes("image"));
                bookList.add(book);
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
                e.printStackTrace();
            }
        }
        return bookList;
    }


    public List<Book> getAllBook() {
        if (!bookList.isEmpty()) {
            return bookList;
        } else {
            return getBooks("Select * from book order by name");
        }
    }

    public List<Book> getBooksByGenre(long id) {
     return getBooks(""+
             "select b.id,b.name," +
             "b.isbn,b.page_count," +
             "b.publish_year, p.name as publisher," +
             " a.fio as author, g.name as genre," +
             " b.image from book b "
             + "inner join author a on b.author_id=a.id "
             + "inner join genre g on b.genre_id=g.id "
             + "inner join publisher p on b.publisher_id=p.id "
             + "where genre_id=" + id + " order by b.name "
             + "limit 0,5");
    }
}

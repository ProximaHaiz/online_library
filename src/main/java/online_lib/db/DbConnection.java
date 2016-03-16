package online_lib.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Proxima on 14.03.2016.
 */
public class DbConnection {


    public static Connection getConnection() {
        Connection conn = null;
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/library");
            conn = ds.getConnection();

        } catch (SQLException | NamingException e) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
        return conn;
    }
}

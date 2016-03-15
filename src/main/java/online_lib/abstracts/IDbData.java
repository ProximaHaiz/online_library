package online_lib.abstracts;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Proxima on 14.03.2016.
 */
public interface IDbData {

    void getData();

    default Connection getConnection() {
        Connection conn = null;

        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/library");
            conn = ds.getConnection();

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return conn;
    }


}

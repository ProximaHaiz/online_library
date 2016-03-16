package online_lib.servlets;

import online_lib.beans.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Proxima on 15.03.2016.
 */
public class ShowImage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("image/jpeg");
        try (OutputStream outputStream = response.getOutputStream()) {
            int index = Integer.valueOf(request.getParameter("index"));

            List<Book> bookList = (ArrayList<Book>) request
                    .getSession(false).getAttribute("currentBookList");
            Book book = bookList.get(index);
            response.setContentLength(book.getImage().length);
            outputStream.write(book.getImage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }//
}

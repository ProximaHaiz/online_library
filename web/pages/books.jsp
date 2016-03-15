<%@ page import="online_lib.beans.Book" %><%--
  Created by IntelliJ IDEA.
  User: Proxima
  Date: 14.03.2016
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../WEB-INF/jspf/left_menu.jspf" %>
<%
    request.setCharacterEncoding("UTF-8");

    long genreId = 0L;

    try {
        genreId = Long.valueOf(request.getParameter("genre"));
    } catch (Exception ex) {
        ex.printStackTrace();
    }
%>

<jsp:useBean id="bookList" class="online_lib.beans.BookList" scope="page"/>

<div class="book_list">
    <h3>${param.name}</h3>

    <table cellpadding="30" style="font-size: 12px">

        <%
            for (Book book : bookList.getBookByGenre(genreId)) {
        %>

        <tr>
            <td style="width: 400px;height:100px;">
                <p style="color: #378de5; font-weight: bold; font-size: 15px;"><%=book.getName()%>
                </p>
                <br><strong>ISBN:</strong><%=book.getIsbn()%>
                <br><strong>Издательство</strong><%=book.getPublisher()%>
                <p style="margin: 10px;"><a href="#">Читать</a></p>
            </td>
            <td style="width: 150px; height: 100px">
                Картинка
            </td>
        </tr>
        <%}%>
    </table>
</div>

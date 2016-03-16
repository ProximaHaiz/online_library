<%@ page import="java.util.AbstractList" %>
<%@ page import="online_lib.beans.AuthorList" %>
<%@ page import="online_lib.beans.Author" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Онлайн библиотека</title>
    <link href="web/css/style_main.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="container">


    <div class="header">
        <div class="logo">
            <img src="web/images/library.png" alt="Логотип" name="logo"/>

        </div>
        <div class="descr">
            <h3>Онлайн библиотека </h3>
        </div>
        <div class="search_form">
            <form name="search_form" method="POST">

                <label>
                    <input type="text" name="search_String" value="" size="110"/>
                </label>

                <input class="search_button" type="submit" value="Поиск" name="search_button"/>

                <label>
                    <select name="search_option">
                        <option>Название</option>
                        <option>Автор</option>
                    </select>
                </label>

            </form>
        </div>
    </div>

    <div class="sidebar1">
        <h4>Список авторов:</h4>
     <%--   <ul class="nav">
            <%
                AuthorList list = new AuthorList();
                for (Author author : list.getAuthorList()) { %>
            <li><a href="#"><%=author.getName()%>
            </a></li>

            <%}%>--%>

             <jsp:useBean id="authorList" class="online_lib.beans.AuthorList" scope="application"/>
             <c:forEach var="author" items="${authorList.authorList}">

                 <li><a href="#">${author.name}</a></li>

             </c:forEach>
        </ul>
        <p>&nbsp;</p>
    </div>


    <div class="content">
        <h1>&nbsp;</h1>

        <p>&nbsp;</p>
    </div>


</div><!-- end .container -->

</body>
</html>

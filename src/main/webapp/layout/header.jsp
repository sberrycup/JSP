<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-05-18
  Time: 오전 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String pageName = request.getParameter("pageName");
    String result = "";

    if (pageName.equals("listPage")) {
        result = "게시물 목록 페이지";
    }
    else if (pageName.equals("writePage")) {
        result = "게시물 글쓰기 페이지";
    }
    else if (pageName.equals("viewPage")) {
        result = "게시물 상세보기 페이지";
    }
    else if (pageName.equals("editPage")) {
        result = "게시물 글수정 페이지";
    }
    else {
        result = "게시물 비밀번호확인 페이지";
    }
%>

<header class="py-5">
    <div class="container">
        <h1 class="display-2 text-center">MVC2 방식 게시판</h1>
        <h3 class="text-center">${param.pageName}</h3>

<%--        <h3 class="text-center"><%= result %></h3>--%>

<%--        <%--%>
<%--            String pageName = request.getParameter("pageName");--%>
<%--        %>--%>
<%--        <h3><%= pageName %></h3>--%>
    </div>
</header>
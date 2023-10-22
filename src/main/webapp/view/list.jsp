<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-05-18
  Time: 오전 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>

    <title>MVC2</title>
</head>
<body>
<%--액션태그로 페이지 불러오기--%>
<c:import url="/layout/header.jsp">
    <c:param name="pageName" value="게시판 목록 페이지" />
</c:import>

<%--jstl 페이지 불러오기--%>
<%--<c:import url="/layout/header.jsp" />--%>

<main class="container">
    <div class="my-3">
        <table class="table table-hover table-striped text-center">
            <colgroup>
                <col style="width: 6%;">
                <col style="width: 50%;">
                <col style="width: 15%;">
                <col style="width: 6%;">
                <col style="width: 15%;">
                <col style="width: 8%;">
            </colgroup>
            <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>조회수</th>
                    <th>작성일</th>
                    <th>첨부</th>
                </tr>
            </thead>
            <tbody>
                <c:choose>
                    <c:when test="${empty boardList}">
                        <tr>
                            <td colspan="6">등록된 게시물이 없습니다</td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${boardList}" var="item" varStatus="loop">
                            <tr>
                                <td>${item.getPostIdx()}</td>
                                <td class="text-start"><a href="/mvcBoard/View.do?idx=${item.postIdx}" class="text-decoration-none">${item.getPostTitle()}</a></td>
                                <td>${item.getPostWriter()}</td>
                                <td>${item.getPostVisit()}</td>
                                <td>${item.getPostDate()}</td>
                                <td>
                                    <c:if test="${not empty item.postOfile}">
                                        <a href="/mvcBoard/Download.do?ofile=${item.postOfile}&sfile=${item.postSfile}&idx=${item.postIdx}" class="text-decoration-none">[Download]</a>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </tbody>
        </table>
    </div>
    <div class="my-3">

    </div>
    <div class="my-3 d-flex justify-content-end">
        <a href="/mvcBoard/Write.do" class="text-white btn btn-secondary">글쓰기</a>
    </div>
</main>
<%@ include file="/layout/footer.jsp" %>
</body>
</html>

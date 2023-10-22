<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-05-18
  Time: 오후 2:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>

    <title>View MVC</title>

    <script>
        $(document).ready(function () {
            $("#btn-list").on("click", function () {
                location.href = "/mvcBoard/List.do"
            });
            $("#btn-edit").on("click", function () {
                const postIdx = $("#post_idx").val();
                location.href = "/mvcBoard/Pass.do?mode=edit&idx=" + postIdx;
            });
            $("#btn-delete").on("click", function () {
                const postIdx = $("#post_idx").val();
                location.href = "/mvcBoard/Pass.do?mode=delete&idx=" + postIdx;
            });
            $("#post_ofile").on("click", function () {
                const postIdx = $("#post_idx").val();
                const postOfile = $("#post_ofile").val();
                const postSfile = $("#post_sfile").val();

                location.href = "/mvcBoard/Download.do?ofile=" + postOfile + "&sfile=" + postSfile + "&idx=" + postIdx;
            });
        });
    </script>
</head>
<body>
<c:import url="/layout/header.jsp">
    <c:param name="pageName" value="게시판 상세보기 페이지" />
</c:import>

<main class="container my-4 py-4">
    <div class="my-3 row">
        <div class="col-sm">
            <label for="post_idx" class="form-label">번호 : </label>
            <input type="text" class="form-control" id="post_idx" name="postIdx" value="${board.postIdx}" readonly>
        </div>
        <div class="col-sm">
            <label for="post_writer" class="form-label">작성자 : </label>
            <input type="text" class="form-control" id="post_writer" name="postWriter" value="${board.postWriter}" readonly>
        </div>
    </div>
    <div class="my-3 row">
        <div class="col-sm">
            <label for="post_date" class="form-label">작성일 : </label>
            <input type="text" class="form-control" id="post_date" name="postDate" value="${board.postDate}" readonly>
        </div>
        <div class="col-sm">
            <label for="post_visit" class="form-label">조회수 : </label>
            <input type="text" class="form-control" id="post_visit" name="postVisit" value="${board.postVisit}" readonly>
        </div>
    </div>
    <div class="my-3 row">
        <div class="col-sm">
            <label for="post_title" class="form-label">글제목</label>
            <input class="form-control" id="post_title" name="postTitle" value="${board.postTitle}" readonly >
        </div>
    </div>
    <div class="my-3 row">
        <div class="col-sm">
            <label for="post_content" class="form-label">내용</label>
            <textarea class="form-control" id="post_content" name="postContent" rows="5">${board.postContent}</textarea>
        </div>
    </div>
    <div class="my-3 row">
        <div class="col-sm">
            <label for="post_ofile" class="form-label">첨부파일</label>
            <input type="text" class="form-control" id="post_ofile" name="postOfile" value="${board.postOfile}" readonly>
            <input type="hidden" id="post_sfile" value="${board.postSfile}">
        </div>
        <div class="col-sm">
            <label for="post_dn_count" class="form-label">[다운로드]</label>
            <input type="text" class="form-control" id="post_dn_count" name="postDnCount" value="${board.postDnCount}" readonly>
        </div>
    </div>
    <div class="my-3 row">
        <div class="col-sm">
            <button type="button" class="btn" id="btn-list">목록</button>
        </div>
        <div class="col-sm d-flex justify-content-end">
            <button type="button" class="btn" id="btn-edit">수정</button>
            <button type="button" class="btn" id="btn-delete">삭제</button>
        </div>
    </div>
</main>

<%@ include file="/layout/footer.jsp" %>
</body>
</html>

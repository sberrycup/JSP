<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-05-18
  Time: 오후 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>

    <title>Title</title>
</head>
<body>
<jsp:include page="/layout/header.jsp">
    <jsp:param name="pageName" value="게시판 글쓰기 페이지"/>
</jsp:include>

<main class="container my-4 py-4">
    <div class="my-3 row">
        <div class="col-sm-4 mx-auto">
            <form action="/mvcBoard/Write.do" method="post" enctype="multipart/form-data">
                <div class="my-3">
                    <label for="title" class="form-label">제목 : </label>
                    <input type="text" class="form-control" id="title" name="title">
                </div>
                <div class="my-3">
                    <label for="writer" class="form-label">작성자 : </label>
                    <input type="text" class="form-control" id="writer" name="writer">
                </div>
                <div class="my-3">
                    <label for="pass" class="form-label">비밀번호 : </label>
                    <input type="text" class="form-control" id="pass" name="pass">
                </div>
                <div class="my-3">
                    <label for="content" class="form-label">내용 : </label>
                    <input type="text" class="form-control" id="content" name="content">
                </div>
                <div class="my-3">
                    <label for="file" class="form-label">첨부파일 : </label>
                    <input type="file" class="form-control" id="file" name="file">
                </div>
                <div class="my-3">
                    <div class="row">
                        <div class="col-sm d-grid">
                            <button type="submit" class="btn btn-primary">글등록</button>
                        </div>
                        <div class="col-sm d-grid">
                            <button type="reset" class="btn btn-waring">취소</button>
                        </div>
                    </div>
                </div>

            </form>
        </div>
    </div>
</main>

<%@ include file="/layout/footer.jsp" %>
</body>
</html>

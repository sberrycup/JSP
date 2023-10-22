package com.bitc.mvc_board.Controller;

import com.bitc.mvc_board.Util.FileUtils;
import com.bitc.mvc_board.Util.JSFunc;
import com.bitc.mvc_board.model.MVCBoardDAO;
import com.bitc.mvc_board.model.MVCBoardDTO;
import com.oreilly.servlet.MultipartRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/mvcBoard/Write.do")
public class WriterController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        req.getRequestDispatcher("/view/write.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        // 클라이언트 전송된 내용 가져오기
//        String title = req.getParameter("title");
//        String writer = req.getParameter("writer");
//        String pass = req.getParameter("pass");
//        String content = req.getParameter("content");

        //현재 파일 정보에 대한 내용
//        String saveDir = req.getServletContext().getRealPath("/upload");
        String saveDir = "C:\\upload";
        int maxSize = 10 * 1024 * 1024;
        MultipartRequest mr = FileUtils.uploadFile(req, saveDir, maxSize);

        if (mr == null) {
            JSFunc.alertLocation(resp, "업로드 파일크기가 초과", "/mvcBoard/write.do");
            return;
        }

        MVCBoardDTO board = new MVCBoardDTO();

        board.setPostTitle(mr.getParameter("title"));
        board.setPostWriter(mr.getParameter("writer"));
        board.setPostPass(mr.getParameter("pass"));
        board.setPostContent(mr.getParameter("content"));

        String fileName = mr.getFilesystemName("file");

        if (fileName != null) {
            String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
            String ext = fileName.substring(fileName.lastIndexOf("."));
            String newFileName = now + ext;

            File oldFile = new File(saveDir + File.separator + fileName);
            File newFile = new File(saveDir + File.separator + newFileName);
            oldFile.renameTo(newFile);

            board.setPostOfile(fileName);
            board.setPostSfile(newFileName);
        }

        // 데이터베이스 연결
        MVCBoardDAO dao = new MVCBoardDAO();

        // 데이터 베이스 전송된 내용 등록
        int result = dao.insertBoard(board);
        dao.dbClose();

        // 리스트페이지로 이동
        if (result == 1) {
            resp.sendRedirect("/mvcBoard/List.do");
        }
        else {
            resp.sendRedirect("/mvcBoard/Writer.do");
        }

    }
}

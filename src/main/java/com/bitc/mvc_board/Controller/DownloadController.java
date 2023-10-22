package com.bitc.mvc_board.Controller;

import com.bitc.mvc_board.Util.FileUtils;
import com.bitc.mvc_board.model.MVCBoardDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mvcBoard/Download.do")
public class DownloadController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        String ofile = req.getParameter("ofile");
        String sfile = req.getParameter("sfile");
        int postIdx = Integer.parseInt(req.getParameter("idx"));

        // 파일 다운로드
        FileUtils.download(req, resp, "c:\\upload", sfile, ofile);

        // 데이터 베이스 연결 및 다운로드 수 업데이트
        MVCBoardDAO dao = new MVCBoardDAO();
        dao.updateBoardDownCount(postIdx);
        dao.dbClose();
    }
}

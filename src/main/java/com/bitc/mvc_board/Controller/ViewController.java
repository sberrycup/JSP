package com.bitc.mvc_board.Controller;

import com.bitc.mvc_board.model.MVCBoardDAO;
import com.bitc.mvc_board.model.MVCBoardDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mvcBoard/View.do")
public class ViewController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        // 게시물 번호 받아오기
        int idx = Integer.parseInt(req.getParameter("idx"));

        MVCBoardDAO dao = new MVCBoardDAO();
        dao.updateBoardVisit(idx);

        // 데이터 베이스 연결해서 게시물 정보 가져오기
        MVCBoardDTO board = dao.selectBoardDetail(idx);
        dao.dbClose();

        // 페이지에 데이터 전달
        req.setAttribute("board", board);

        req.getRequestDispatcher("/view/view.jsp").forward(req, resp);
    }
}

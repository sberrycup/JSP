package com.bitc.mvc_board.Controller;

import com.bitc.mvc_board.model.MVCBoardDAO;
import com.bitc.mvc_board.model.MVCBoardDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mvcBoard/Edit.do")
public class EditController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        int postIdx = Integer.parseInt(req.getParameter("idx"));
        MVCBoardDAO dao = new MVCBoardDAO();
        MVCBoardDTO board = dao.selectBoardDetail(postIdx);
        dao.dbClose();

        req.setAttribute("board", board);

        req.getRequestDispatcher("/view/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        // 수정 페이지에서 데이터 가져오기
        MVCBoardDTO board = new MVCBoardDTO();
        board.setPostIdx(Integer.parseInt(req.getParameter("postIdx")));
        board.setPostTitle(req.getParameter("postTitle"));
        board.setPostWriter(req.getParameter("postWriter"));
        board.setPostPass(req.getParameter("postPass"));
        board.setPostContent(req.getParameter("postContent"));

        // 데이터 베이스로 전송
        MVCBoardDAO dao = new MVCBoardDAO();
        int result = dao.updateBoard(board);
        dao.dbClose();

        // 페이지 이동
        if (result == 1) {
            resp.sendRedirect("/mvcBoard/List.do");
        }
        else {
            resp.sendRedirect("/mvcBoard/Edit.do?idx=" + board.getPostIdx());
        }
    }
}

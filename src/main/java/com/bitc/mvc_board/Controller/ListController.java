package com.bitc.mvc_board.Controller;

import com.bitc.mvc_board.model.MVCBoardDAO;
import com.bitc.mvc_board.model.MVCBoardDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/mvcBoard/List.do")
public class ListController extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        MVCBoardDAO dao = new MVCBoardDAO();
        List<MVCBoardDTO> boardList = dao.selectBoardList();
        dao.dbClose();

        req.setAttribute("boardList", boardList);

        req.getRequestDispatcher("/view/list.jsp").forward(req, resp);
    }
}

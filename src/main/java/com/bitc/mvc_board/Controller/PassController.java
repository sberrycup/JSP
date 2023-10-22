package com.bitc.mvc_board.Controller;

import com.bitc.mvc_board.Util.JSFunc;
import com.bitc.mvc_board.model.MVCBoardDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.event.HyperlinkEvent;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/mvcBoard/Pass.do")
public class PassController extends HttpServlet {

    // 삭제 및 수정을 위해 비밀번호 입력을 받는 view
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        req.setAttribute("idx", req.getParameter("idx"));
        req.setAttribute("mode", req.getParameter("mode"));
        req.getRequestDispatcher("/view/pass.jsp").forward(req, resp);
    }

    // 입력받은 비밀번호 확인 및 삭제와 수정을 실행

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        // 전달된 비밀번호, 모드 그리고 글번호 가져오기
        String pass = req.getParameter("postPass");
        int idx = Integer.parseInt(req.getParameter("postIdx"));
        String mode = req.getParameter("postMode");

        // 데이터 베이스 연결
        MVCBoardDAO dao = new MVCBoardDAO();

        // 글번호를 기준으로 해당 게시물 비밀번호와 사용자가 입력한 비밀번호가 같은지 확인
        boolean confirm = dao.equalsPassword(idx, pass);
        dao.dbClose();

        // 삭제 및 수정
        if (confirm) {
            if (mode.equals("edit")) {
//                HttpSession session = req.getSession();
//                session.setAttribute("sessionPass", pass);

                resp.sendRedirect("/mvcBoard/Edit.do?idx=" + idx);
            }
            else if (mode.equals("delete")){
                dao = new MVCBoardDAO();

                int result = dao.deleteBoard(idx);
                dao.dbClose();

                if (result == 1) {
                    resp.sendRedirect("/mvcBoard/List.do");
                }
                else {
                    resp.sendRedirect("mvcBoard/Pass.do");
                }
            }
        }
        else {
            JSFunc.alertBack("비밀번호가 틀렸습니다", resp);
        }
    }
}

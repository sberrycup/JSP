package com.bitc.mvc_board.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MVCBoardDAO extends JDBConnect {
    public MVCBoardDAO() {
        super();
    }

    //전체 게시물 목록 가져오기
    public List<MVCBoardDTO> selectBoardList() {
        List<MVCBoardDTO> boardList = new ArrayList<>();
        String sql = "select post_idx, post_title, post_writer, post_visit, post_date, post_ofile, post_sfile from mvcboard order by post_idx desc ";
        try {
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();

            while (rs.next()) {
                MVCBoardDTO board = new MVCBoardDTO();

                board.setPostIdx(rs.getInt("post_idx"));
                board.setPostTitle(rs.getString("post_title"));
                board.setPostWriter(rs.getString("post_writer"));
                board.setPostVisit(rs.getInt("post_visit"));
                board.setPostDate(rs.getString("post_date"));
                board.setPostOfile(rs.getString("post_ofile"));
                board.setPostSfile(rs.getString("post_sfile"));

                boardList.add(board);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("***Select Err***");
            System.out.println("***Err : " + e.getMessage() + "***");
        }
        return boardList;
    }

    // 데이터 베이스에 글등록
    public int insertBoard(MVCBoardDTO board) {
        int result = 0;

        String sql = "insert into mvcboard(post_writer, post_title, post_content, post_pass, post_date, post_ofile, post_sfile) values(?, ?, ?, ?, now(), ?, ?) ";

        try {
            psmt = conn.prepareStatement(sql);

            psmt.setString(1, board.getPostWriter());
            psmt.setString(2, board.getPostTitle());
            psmt.setString(3, board.getPostContent());
            psmt.setString(4, board.getPostPass());
            psmt.setString(5, board.getPostOfile());
            psmt.setString(6, board.getPostSfile());

            result = psmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("***Insert Err***");
            System.out.println("***Err : " + e.getMessage() + "***");
            e.printStackTrace();
        }
        return result;
    }

    public MVCBoardDTO selectBoardDetail(int boardIdx) {
        MVCBoardDTO board = new MVCBoardDTO();

        String sql = "select post_idx, post_title, post_writer, post_visit, post_date, post_ofile, post_sfile, post_dn_count from mvcboard where post_idx = ? ";

        try {
            psmt = conn.prepareStatement(sql);

            psmt.setInt(1, boardIdx);
            rs = psmt.executeQuery();

            while (rs.next()) {
                board.setPostIdx(rs.getInt("post_idx"));
                board.setPostTitle(rs.getString("post_title"));
                board.setPostWriter(rs.getString("post_writer"));
                board.setPostVisit(rs.getInt("post_visit"));
                board.setPostDate(rs.getString("post_date"));
                board.setPostOfile(rs.getString("post_ofile"));
                board.setPostSfile(rs.getString("post_sfile"));
                board.setPostDnCount(rs.getString("post_dn_count"));
            }
        }
        catch (SQLException e) {
            System.out.println("***Data read Insert Err***");
            System.out.println("***Err : " + e.getMessage() + "***");
            e.printStackTrace();
        }
        return board;
    }

    public boolean equalsPassword(int idx, String pass) {
        boolean result = false;

        String sql = "select count(*) as cnt from mvcboard where post_idx = ? and post_pass = ? ";

        try {
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, idx);
            psmt.setString(2, pass);

            rs = psmt.executeQuery();

            while (rs.next()) {
                if (rs.getInt("cnt") == 1) {
                    result = true;
                }
            }
        }
        catch (SQLException e) {
            System.out.println("***Delete Err***");
            System.out.println("***Err : " + e.getMessage() + "***");
            e.printStackTrace();
        }

        return result;
    }

    public int deleteBoard(int idx) {
        int result = 0;
        String sql = "delete from mvcboard where post_idx = ? ";

        try {
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, idx);

            result = psmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("***Delete2 Err***");
            System.out.println("***Err : " + e.getMessage() + "***");
            e.printStackTrace();
        }

        return result;
    }

    public int updateBoard(MVCBoardDTO board) {
        int result = 0;
        String sql = "update mvcboard set post_title = ?, post_writer = ?, post_pass = ?, post_content = ?, post_date = now() where post_idx = ? ";

        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, board.getPostTitle());
            psmt.setString(2, board.getPostWriter());
            psmt.setString(3, board.getPostPass());
            psmt.setString(4, board.getPostContent());
            psmt.setInt(5, board.getPostIdx());

            result = psmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("***Update Err***");
            System.out.println("***Err : " + e.getMessage() + "***");
            e.printStackTrace();
        }
        return  result;
    }

    public void updateBoardVisit(int idx) {
        String sql = "update mvcboard set post_visit = post_visit + 1 where post_idx = ? ";

        try {
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, idx);
            psmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("***Visit Update Err***");
            System.out.println("***Err : " + e.getMessage() + "***");
            e.printStackTrace();
        }
    }

    public void updateBoardDownCount(int postIdx) {
        String sql = "update mvcboard set post_dn_count = post_dn_count + 1 where post_idx = ? ";

        try {
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, postIdx);
            psmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("***Download Err***");
            System.out.println("***Err : " + e.getMessage() + "***");
            e.printStackTrace();
        }
    }
}

package com.bitc.mvc_board.Util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class JSFunc {
    public static void alertBack(String msg, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        String js = "<script>";
        js += "alert('" + msg + "'); ";
        js += "history.back(); ";
        js += "</script>";

        writer.println(js);
    }

    public static void alertLocation(HttpServletResponse resp, String msg, String url) {
        try {
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter writer = resp.getWriter();

            String js = "<script>";
            js += "alert('" + msg + "'); ";
            js += "location.href = '" + url + "' ";
            js += "</script>";

            writer.println(js);
        }
        catch (IOException e) {

        }
    }
}

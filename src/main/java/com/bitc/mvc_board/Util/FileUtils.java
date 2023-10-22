package com.bitc.mvc_board.Util;

import com.oreilly.servlet.MultipartRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class FileUtils {
    public static MultipartRequest uploadFile(HttpServletRequest req, String saveDir, int maxSize)
        throws ServletException, IOException {
        try {
            return new MultipartRequest(req, saveDir, maxSize, "utf-8");
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void download(HttpServletRequest req, HttpServletResponse resp, String saveDir, String sfileName, String ofileName) {
        try {
            File file = new File(saveDir, sfileName);
            InputStream iStream = new FileInputStream(file);

            String client = req.getHeader("User-Agent");
            if (client.indexOf("WOW64") == -1) {
                ofileName = new String(ofileName.getBytes("utf-8"), "ISO-8859-1");
            }
            else {
                ofileName = new String(ofileName.getBytes("KSC5601"), "ISO-8859-1");
            }

            resp.reset();
            resp.setContentType("application/octet-stream");
            resp.setHeader("Content-Disposition", "attachment; filename=\"" + ofileName + "\"");
            resp.setHeader("Content-Length", "" + file.length());

            OutputStream oStream = resp.getOutputStream();

            byte[] b = new byte[(int)file.length()];
            int readBuffer = 0;

            while ((readBuffer = iStream.read(b)) > 0) {
                oStream.write(b, 0, readBuffer);
            }

            iStream.close();
            oStream.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("***다운로드 할 파일을 찾을 수 없습니다***");
            e.printStackTrace();
        }
        catch (Exception e) {
            System.out.println("***다운로드 오류 발생***");
            e.printStackTrace();
        }
    }
}

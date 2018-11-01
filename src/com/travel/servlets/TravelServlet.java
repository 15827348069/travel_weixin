package com.travel.servlets;

import com.travel.utils.CheckUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TravelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

        //在doGet方法中获取检验参数
        String signature = req.getParameter("signature");
        String timestamp = req.getParameter("timestamp");
        String nonce = req.getParameter("nonce");
        String echostr = req.getParameter("echostr");

        //校验参数，如果相等就将 echostr  参数原路返回给微信
        PrintWriter writer = resp.getWriter();
        if (CheckUtil.checkTravelParameter(signature,timestamp,nonce)){
            //如果校验成功，将得到的字符串返回给微信
            writer.print(echostr);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

    }
}

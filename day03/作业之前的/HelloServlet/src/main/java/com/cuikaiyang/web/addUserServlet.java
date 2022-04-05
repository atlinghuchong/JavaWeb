package com.cuikaiyang.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class addUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        String mail = req.getParameter("mail");

        //2.响应客户端

        // 设置数据响应类型
        resp.setContentType("text/html; charset=UTF-8");

        // 构建输出流
        // 获取连接
        PrintWriter pw = resp.getWriter();
        // 写出数据
        pw.println("您的用户名是" + username + "，密码是" + pwd + "，邮箱是" + mail + "。感谢您的使用！");
        //3.关闭资源
        pw.close();
    }
}

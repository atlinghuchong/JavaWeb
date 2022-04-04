package com.cuikaiyang.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet开发步骤：
 * 1.创建类，并继承HttpServlet类
 * 2.重写父类中的service方法，用于处理请求和响应
 * 3.在service方法中，编写自己的业务逻辑（核心的4个步骤）
 * 4.在web.xml文件中配置servlet类
 * 5.修改项目的访问名称。-------workspace.xml文件中修改项目的访问名称。
 * 6.启动tomcat，并在浏览器端通过规定的url地址访问项目(编译、打包、部署)
 */
public class DateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 业务需求：返回当前系统时间给前端浏览器：2022-04-03 23:48:51
        // 规定url地址：localhost:8080/water/date

        // 写了一个当前系统时间的逻辑
        Date date = new Date();
        SimpleDateFormat sdf = new
                SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = sdf.format(date);

        System.out.println("现在的时间是" + now);

        // (1) 设置数据的响应类型
        resp.setContentType("text/html");
        // (2) 获取连接
        PrintWriter pw = resp.getWriter();
        // (3) 写出数据
        pw.println("<h3>" + now + "</h3>");
        // (4) 关闭资源
        pw.close();
    }
}

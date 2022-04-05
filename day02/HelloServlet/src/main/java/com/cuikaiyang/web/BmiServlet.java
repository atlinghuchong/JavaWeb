package com.cuikaiyang.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class BmiServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收客户端提交的数据
        // 客户端提交的数据存放在requset对象中,通过参数的名称获取值，实际上就是对应元素中name属性的值。

        // 接收单个参数的值
        String height = req.getParameter("height");
        String weight = req.getParameter("weight");

        String gender = req.getParameter("gender");


        // 接收多个参数的值
        String[] hobbies = req.getParameterValues("hobby");
        String hobby = Arrays.toString(hobbies);


        System.out.println(hobby);
        // 计算BMI
        double bmi = Double.parseDouble(weight)/Double.parseDouble(height)/Double.parseDouble(height);

        // 对BMI进行判断
        String status = null;
        if(gender.equals('M')){
            // 男性
            if(bmi > 25){
                status = "过重";
            }else if(bmi > 20){
                status = "正常";
            }else {
                status = "过瘦";
            }
        }else {
            // 女性
            if(bmi > 24){
                status = "过重";
            }else if(bmi > 19){
                status = "正常";
            }else {
                status = "过瘦";
            }
        }

        // 2.响应客户端
        resp.setContentType("text/html; charset=UTF-8");
        //构建输出流
        PrintWriter pw = resp.getWriter();
        pw.println("您的性别是:"+ gender + "，您的BMI指数是" + bmi + "，您的身体状况是" + status + "。" + "您选择了" + hobby + "。");
        // 3.关闭资源

        pw.close();
    }
}

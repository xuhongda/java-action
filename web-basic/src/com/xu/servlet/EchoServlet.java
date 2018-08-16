package com.xu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author xuhongda on 2018/8/16
 * com.xu.servlet
 * javase-practice
 */
@WebServlet("/echo")
public class EchoServlet extends HttpServlet {
    private static final long serialVersionUID = -7240062468810631096L;

    @Override
    protected void
    doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取当前线程
        Thread currentThread = Thread.currentThread();
        // 获取当前线程的线程名称
        String currentThreadName = currentThread.getName();
        response.setContentType("text/plain");
        try (PrintWriter pwr = response.getWriter()) {
            // 输出处理当前请求的线程的名称
            pwr.printf("This request was handled by thread:%s%n", currentThreadName);
            pwr.flush();
        }
    }
}
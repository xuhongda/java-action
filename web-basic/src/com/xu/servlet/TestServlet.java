package com.xu.servlet;

import lombok.extern.slf4j.Slf4j;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xuhongda on 2019/4/15
 * com.xu.servlet
 * java-action
 */
@Slf4j
@WebServlet("/testS")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("hello", "hello");
        log.info("req = {}",req);
        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }
}

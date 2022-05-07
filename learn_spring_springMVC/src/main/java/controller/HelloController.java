package controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  纯springMVC需要tomcat的支持
 */

public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("hello controller 跳转到 success");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("data", "恭喜您，测试成功了");
        modelAndView.setViewName("success");//跳转到/WEB-INF/views/success.jsp
        return modelAndView;
    }
}

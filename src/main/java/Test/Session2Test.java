package Test;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/arequest1")
public class Session2Test extends GenericServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //1.开启会话，获取会话对象
        HttpServletRequest servletRequest1 = (HttpServletRequest)servletRequest;
        HttpSession session = servletRequest1.getSession();
        String  name = (String) session.getAttribute("name");
        Integer age = (Integer) session.getAttribute("age");
        System.out.println("name = " + name);
        System.out.println("age = " + age);

    }
}

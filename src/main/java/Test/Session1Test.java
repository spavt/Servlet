package Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/arequest")
public class Session1Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.开启会话，获取会话对象
        HttpSession session = req.getSession();
        //2.设置会话数据 键值对
        session.setAttribute("name", "张三");
        session.setAttribute("age", 18);
        //3.获取会话数据
        System.out.println("session.getAttribute(\"name\") = " + session.getAttribute("name"));
        System.out.println("session.getAttribute(\"age\") = " + session.getAttribute("age"));

    }
}

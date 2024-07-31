package Test;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/arequest2")
public class Session3Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.开启会话，获取会话对象
        HttpSession session = req.getSession();
        String name = (String) session.getAttribute("name");
        Integer age = (Integer) session.getAttribute("age");
        System.out.println("name = " + name);
        System.out.println("age = " + age);
    }
}

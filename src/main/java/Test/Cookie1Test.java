package Test;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Cookie1")
public class Cookie1Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        //1.创建Cookie对象
        Cookie cookie = new Cookie("name", "zhangsan");
        //2.设置Cookie的有效期
        cookie.setMaxAge(10);
        //3.设置Cookie的携带路径
        //4.将Cookie写回到浏览器
        resp.addCookie(cookie);
    }

}

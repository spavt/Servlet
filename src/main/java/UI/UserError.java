package UI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/userError")
public class UserError extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");//响应用户请求时，告知用户服务器的编码
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter user = resp.getWriter();
        user.write("<!Doctype html>");
        user.write("<html>");
        user.write("<head>");
        user.write("<meta charset='utf-8>'");
        user.write("</head>");
        user.write("<body>");
        user.write("<h2 style='color:red;font-weight:bold;'>" +
                "用户名或密码有错误，请重新登陆" +
                "</h2>" +
                "<p>请重新登陆<p>");
        user.write("</body>");
        user.write("</html>");
    }
}

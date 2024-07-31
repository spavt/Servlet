package UI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/insertData")
public class InsertData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        writer.write("<!DOCTYPE html>");
        writer.write("<head>");
        writer.write("<meta charset='UTF-8'>");
        writer.write("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        writer.write("<title>添加学生信息</title>");
        writer.write("<style>");
        writer.write("body { font-family:'微软雅黑'; background-color:#e0f7fa; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }");
        writer.write(".container { background-color: #fff; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); width: 35%; text-align: center;height:60%; }");
        writer.write("h1 { color: #00796b;margin-bottom: 50px; }");
        writer.write("label { display: block; margin-bottom: 5px; font-weight: bold; }");
        writer.write("input[type='text'] { padding: 14px; font-size: large; border: 1px solid #ccc; border-radius: 5px;margin-bottom: 30px;}");
        writer.write(".btn { display: inline-block; width: 100px; padding: 10px; margin-top: 40px; margin-left: 40px; font-size: 16px; color: #fff; background-color: #4CAF50; border: none; border-radius: 5px; cursor: pointer; text-decoration: none; }");
        writer.write(".btn:hover { background-color: #45a049; }");
        writer.write(".btn-reset { background-color: #f44336; }");
        writer.write(".btn-reset:hover { background-color: #e53935; }");
        writer.write("span { width: 100px; text-align:center; margin-right: 10px;font-size: large; }");
        writer.write("</style>");
        writer.write("</head>");

        writer.write("<body>");
        writer.write("<div class='container'>");
        writer.write("<h1>添加学生信息</h1>");
        writer.write("<form action='insertok' method='post'>");
        writer.write("<span>姓名：</span><input type='text' name='sname'><br>"+
                "<span>性别：</span><input type='text' name='ssex'><br>"+
                "<span>班级：</span><input type='text' name='sclass'><br>");
        writer.write("<button type='submit' class='btn'>提交</button>");
        writer.write("<button type='reset' class='btn btn-reset'>重置</button>");
        writer.write("</form>");
        writer.write("</div>");
        writer.write("</body>");
        writer.write("</html>");
    }
}

package UI;

import Model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/showList")
public class ShowList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter user = resp.getWriter();

        // 获取数据库中的学生信息
        List<Student> students = (List<Student>) req.getAttribute("students");
        if (students == null) {
            user.write("目前没有学生信息");
            return;
        }

        user.write("<!DOCTYPE html>");
        user.write("<html lang='en'>");
        user.write("<head>");
        user.write("<meta charset='UTF-8'>");
        user.write("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        user.write("<title>学生信息管理</title>");
        user.write("<style>");
        user.write("body { font-family: '微软雅黑'; background-color: #e0f7fa; margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; }");
        user.write(".container { background-color: #ffffff; padding: 30px; border-radius: 12px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); width: 90%; max-width: 800px; text-align: center; margin-top: 20px; }");
        user.write("h1 { color: #00796b; margin-bottom: 20px; }");
        user.write(".btn { display: block; width: 100%; padding: 12px; margin: 10px 0; font-size: 18px; color: #ffffff; background-color: #00796b; border: none; border-radius: 6px; cursor: pointer; text-decoration: none; }");
        user.write(".btn:hover { background-color: #004d40; }");
        user.write(".btn:active { background-color: #00251a; }");
        user.write("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
        user.write("th, td { border: 1px solid #ddd; padding: 12px; text-align: center; }");
        user.write("th { background-color: #e0f7fa; color: black; }");
        user.write("tr:nth-child(even) { background-color: lightyellow; }");
        user.write("tr:hover { background-color: #e0f7fa; }");
        user.write("</style>");
        user.write("</head>");
        user.write("<body>");
        user.write("<div class='container'>");
        user.write("<h1>学生信息管理</h1>");
        user.write("<h2><a href='insertData'>添加信息</a></h2>");

        // 显示学生信息表格
        user.write("<table>");

        user.write("<tr><th>学号</th><th>姓名</th><th>性别</th><th>班级</th><th>删除</th><th>更新</th></tr>");
        for (Student student : students) {
            user.write("<tr>");
            user.write("<td>" + student.getsno() + "</td>");
            user.write("<td>" + student.getsname() + "</td>");
            user.write("<td>" + student.getssex() + "</td>");
            user.write("<td>" + student.getsclass() + "</td>");
            user.write("<td><a onclick=\"if(confirm('确认删除吗?'))return true;return false;\" href=delStu?sno="+student.getsno()+">删除</a></td>");
            user.write("<td><a href=updateUi?sno="+student.getsno()+">更新</a></td>");
            user.write("</tr>");
        }
        user.write("</table>");
        user.write("</div>");
        user.write("</body>");
        user.write("</html>");

        user.close();
    }
}

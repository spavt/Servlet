package server;

import Dao.OrderMapper;
import Model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet("/updateok")
public class UpdateOk extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String sno = req.getParameter("sno");
        String sname = req.getParameter("sname");
        String ssex = req.getParameter("ssex");
        String sclass = req.getParameter("sclass");
        Student student = new Student();
        student.setsno(Integer.valueOf(sno));
        student.setsname(sname);
        student.setssex(ssex);
        student.setsclass(sclass);
        //根据学号获取学生信息
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);//构建工厂
        SqlSession sqlSession = build.openSession();//参数为true时，自动提交事务
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);//获取接口的实现类
        int i = orderMapper.updateStu(student);
        Commit(req, resp, sqlSession, orderMapper, i);
    }

    static void Commit(HttpServletRequest req, HttpServletResponse resp, SqlSession sqlSession, OrderMapper orderMapper, int i) throws ServletException, IOException {
        sqlSession.commit();
        if (i > 0) {
            List<Student> students = orderMapper.showStuDAO();
            req.setAttribute("students", students);
            req.getRequestDispatcher("/showList").forward(req, resp);
        } else {
            req.getRequestDispatcher("/userError").forward(req, resp);
        }
    }
}

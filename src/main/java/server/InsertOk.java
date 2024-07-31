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

@WebServlet("/insertok")
public class InsertOk extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);//构建工厂
        SqlSession sqlSession = build.openSession();//参数为true时，自动提交事务
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);//获取接口的实现类
        String sname = req.getParameter("sname");
        String ssex = req.getParameter("ssex");
        String sclass = req.getParameter("sclass");
        Student student = new Student();
        student.setsname(sname);
        student.setssex(ssex);
        student.setsclass(sclass);
        int i = orderMapper.addStuDAO(student);
        UpdateOk.Commit(req, resp, sqlSession, orderMapper, i);
    }
}

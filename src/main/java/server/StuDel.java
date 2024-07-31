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

@WebServlet("/delStu")
public class StuDel extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);//构建工厂
        SqlSession sqlSession = build.openSession();//参数为true时，自动提交事务
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);//获取接口的实现类
        String sno = req.getParameter("sno");
        System.out.println("sno = " + sno);
        int i = orderMapper.delStuDAO(sno);
        UpdateOk.Commit(req, resp, sqlSession, orderMapper, i);

    }
}

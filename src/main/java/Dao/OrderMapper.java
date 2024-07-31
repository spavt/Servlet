package Dao;

import Model.Student;
import Model.admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

// mybatis的接口
public interface OrderMapper {

    @Select("SELECT * FROM admin WHERE username = #{username} AND password = #{password}")
    admin findAdmin(@Param("username") String username, @Param("password") String password);

    @Select("SELECT * FROM students")
    List<Student> showStuDAO();

    @Delete("DELETE FROM students WHERE sno = #{sno}")
    int delStuDAO(String sno);

    @Insert("INSERT INTO students(sno, sname, ssex, sclass) VALUES(#{sno}, #{sname}, #{ssex}, #{sclass})")
    int addStuDAO(Student student);

    @Select("SELECT * FROM students WHERE sno = #{sno}")
    Student findStu(String sno);

    @Update("UPDATE students SET sname = #{sname}, ssex = #{ssex}, sclass = #{sclass} WHERE sno = #{sno}")
    int updateStu(Student student);

}

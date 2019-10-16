package com.sheva.studentdemo.mapper;

import com.sheva.studentdemo.entity.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    @Select("select * from student")
    List<Student> getAllStudent();
    @Insert("insert into student(name, sex, tel) values(#{name}, #{sex}, #{tel})")
    void insertStudent(Student student);
    @Delete("delete from student where id = #{id}")
    void deleteStudent(Integer id);
    @Select("select * from student where id = #{id}")
    Student getOneById(Integer id);
    @Update("update student set name = #{name}, sex = #{sex}, tel = #{tel} where id = #{id}")
    void updateStudent(Student student);

}
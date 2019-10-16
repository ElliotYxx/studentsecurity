package com.sheva.studentdemo.service;

import com.sheva.studentdemo.entity.Student;
import com.sheva.studentdemo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentMapper studentMapper;


    public List<Student> listAllStudent(){
        return studentMapper.getAllStudent();
    }
    public void saveStudent(Student student){studentMapper.insertStudent(student);}
    public void deleteStudent(Integer id){studentMapper.deleteStudent(id);}
    public Student getStudentById(Integer id){return studentMapper.getOneById(id);}
    public void editStudent(Student student){studentMapper.updateStudent(student);}
}

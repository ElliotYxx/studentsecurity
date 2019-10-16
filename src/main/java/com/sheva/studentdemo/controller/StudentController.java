package com.sheva.studentdemo.controller;

import com.sheva.studentdemo.entity.Student;
import com.sheva.studentdemo.service.StudentService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/")
    public String index(){
        return "user/login";
    }

    @RequestMapping("/list")
    public String list(Model model){
        List<Student> students = studentService.listAllStudent();
        model.addAttribute("students", students);
        return "student/studentList";
    }

    @RequestMapping("/adminlist")
    public String alllist(Model model){
        List<Student> students = studentService.listAllStudent();
        model.addAttribute("students", students);
        return "student/allStudentList";

    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "student/studentAdd";
    }

    @RequestMapping("/Add")
    public String add(Student student){
        studentService.saveStudent(student);
        return "redirect:/adminlist";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model, Integer id){
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "student/studentEdit";
    }

    @RequestMapping("/edit")
    public String edit(Student student){
        studentService.editStudent(student);
        return "redirect:/adminlist";
    }

    @RequestMapping("/delete")
    public String delete(Integer id){
        studentService.deleteStudent(id);
        return "redirect:/adminlist";
    }

}

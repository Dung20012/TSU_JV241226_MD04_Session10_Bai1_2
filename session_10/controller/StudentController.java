package com.data.session_10.controller;

import com.data.session_10.model.entity.Student;
import com.data.session_10.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping
    private String listStudents(Model model,
                                @RequestParam(required = false)String message) {
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("message", message);
        return "studentList";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id, Model model) {
        boolean delete = studentService.deleteById(id);
        String message = delete ? "Xóa thành công !" : "Không thể xóa những học sinh đang học !";
        return "redirect:/students?message=" + message;
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("action", "/students/save");
        model.addAttribute("formTitle", "Thêm mới sinh viên");
        return "studentForm";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:/students?message=Đã lưu thành công!";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Student student = studentService.findById(id);
        if (student == null) {
            return "redirect:/students?message=Không tìm thấy sinh viên!";
        }
        model.addAttribute("student", student);
        model.addAttribute("action", "/students/save");
        model.addAttribute("formTitle", "Chỉnh sửa sinh viên");
        return "studentForm";
    }
}

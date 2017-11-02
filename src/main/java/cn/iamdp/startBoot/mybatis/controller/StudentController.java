package cn.iamdp.startBoot.mybatis.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.iamdp.startBoot.mybatis.pojo.Student;
import cn.iamdp.startBoot.mybatis.service.StudentService;

@Controller
public class StudentController {
	
	@Resource
	private StudentService sService;
	
	@GetMapping(path="/mybatis/list")
	public String studentList(Model model) {
		List<Student> studentList=sService.getStudentList();
		model.addAttribute("Students", studentList);
		return "student/list";
	}

	
	
    @RequestMapping("/mybatis/toAdd")
    public String toAdd() {
        return "student/studentAdd";
    }

    @RequestMapping("/mybatis/add")
    public String add(Student student) {
        sService.save(student);
        return "redirect:/mybatis/list";
    }

    @RequestMapping("/mybatis/toEdit")
    public String toEdit(Model model,Integer id) {
    	Student student=sService.findStudentById(id);
        model.addAttribute("student", student);
        return "student/studentEdit";
    }

    @RequestMapping("/mybatis/edit")
    public String edit(Student student,Model model) {
    	sService.edit(student);
        return "redirect:/mybatis/list";
    }


    @RequestMapping("/mybatis/delete")
    public String delete(Integer id) {
    	sService.delete(id);
        return "redirect:/mybatis/list";
    }
	
	
	
}

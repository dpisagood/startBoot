package cn.iamdp.startBoot.mybatis.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.iamdp.startBoot.mybatis.pojo.Student;
import cn.iamdp.startBoot.mybatis.service.StudentService;

@Controller
public class StudentController {
	
	@Resource
	private StudentService sService;
	
	
	
   
	@GetMapping(path="/mybatis/list")
	public String studentList(Model model, 
			@RequestParam(value = "pageNum", required = false, defaultValue="1") Integer pageNum ,
			@RequestParam(value = "pageSize", required = false, defaultValue="2") Integer pageSize
			) {
		PageHelper.startPage(pageNum, pageSize);
		List<Student> studentList=sService.getStudentList();
		PageInfo<Student> pageInfo=new PageInfo<Student>(studentList);
		model.addAttribute("students", studentList);
		model.addAttribute("pageInfo",pageInfo);
		return "student/list";
	}

	
	
    @RequestMapping("/mybatis/toAdd")
    public String toAdd() {
        return "student/studentAdd";
    }

    @PostMapping("/mybatis/add")
    public String add(Student student) {
    	int key=sService.save(student);
        System.out.println("+++++++++++++++++++++++++"+key+"++++++++++++++++++++++++++++");
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

package cn.iamdp.startBoot.mybatis.service;

import java.util.List;

import cn.iamdp.startBoot.mybatis.pojo.Student;

public interface StudentService {
	
    public List<Student> getStudentList();

    public Student findStudentById(Integer id);

    public int save(Student user);

    public int edit(Student user);

    public int delete(Integer id);
}

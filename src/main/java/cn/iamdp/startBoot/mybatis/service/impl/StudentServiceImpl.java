package cn.iamdp.startBoot.mybatis.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.iamdp.startBoot.mybatis.dao.StudentDao;
import cn.iamdp.startBoot.mybatis.pojo.Student;
import cn.iamdp.startBoot.mybatis.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Resource
	private StudentDao sdao;

	@Override
	public List<Student> getStudentList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findStudentById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(Student user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int edit(Student user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

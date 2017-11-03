package cn.iamdp.startBoot.mybatis.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.iamdp.startBoot.mybatis.dao.StudentDao;
import cn.iamdp.startBoot.mybatis.pojo.Student;
import cn.iamdp.startBoot.mybatis.service.StudentService;

/**
 * 服务层
 * @author DP
 *
 */
@Service
public class StudentServiceImpl implements StudentService{

	@Resource
	private StudentDao sdao;

	@Override
	public List<Student> getStudentList() {
		return sdao.studentList();
	}

	@Override
	public Student findStudentById(Integer id) {
		return sdao.selectByPrimaryKey(id);
	}

	@Override
	public int save(Student student) {
		return sdao.save(student);//返回自增长的主键
	}

	@Override
	public int edit(Student student) {
		return sdao.updateByPrimaryKey(student);
	}

	@Override
	public int delete(Integer id) {
		return sdao.deleteByPrimaryKey(id);
	}
	
}

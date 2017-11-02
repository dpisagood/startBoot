package cn.iamdp.startBoot.mybatis.dao;

import cn.iamdp.startBoot.mybatis.pojo.Student;
import java.util.List;

public interface StudentDao {
	

    int deleteByPrimaryKey(Integer id);

    int save(Student record);

    List<Student> studentList();

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Student record);
}
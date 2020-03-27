package com.cognizant.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Student;

@Repository
//@Component
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate; 
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public List<Student> findAll() {
		String query = "select * from student1";
		return jdbcTemplate.query(query, (rs, rowNum) -> new Student(rs.getInt(1), rs.getString(2), rs.getString(3)));

	}

	@Override
	public List<Student> findByName(String name) {
		
		//int result = jdbcTemplate.query(sqlName);
		Map<String,Object> map = new HashMap<>();
		map.put("name", name);
		String sqlName = "select * from student1 where name = :name";
		List<Student> list = namedParameterJdbcTemplate.query(sqlName, map,
				(rs, rowNum) -> new Student(rs.getInt(1), rs.getString(2), rs.getString(3)));
		return list;
	}

	@Override
	public int create(Student student) {
		String sqlInsert = "insert into student1 values(?,?,?)";
		int result = jdbcTemplate.update(sqlInsert, student.getId(), student.getName(), student.getCourse());
		if(result == 1) {
			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public int update(Student student) {

		String sqlUpdate = "update student1 set name = ?, course = ? where id = ?";
		int result = jdbcTemplate.update(sqlUpdate, student.getName(), student.getCourse(), student.getId());
		if(result == 1) {
			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public int delete(int id) {
		String sqlDelete = "delete from student1 where id = ?";
		int result = jdbcTemplate.update(sqlDelete, id);
		if(result == 1) {
			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public int countStudent() {
		return findAll().size();
	}

}

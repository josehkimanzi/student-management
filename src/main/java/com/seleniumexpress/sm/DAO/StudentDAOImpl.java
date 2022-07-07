package com.seleniumexpress.sm.DAO;

import java.util.ArrayList;
import java.util.List;
import com.seleniumexpress.sm.rowmapper.StudentRowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.seleniumexpress.sm.api.Student;
@Repository
public class StudentDAOImpl implements StudentDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Student> loadStudents() {
			
		
		//I will write some logic to get me the student data
				//from the DB
		String sql="SELECT * from students";
		
		List<Student> theListOfStudents=jdbcTemplate.query(sql, new StudentRowMapper());
		
		return theListOfStudents;
	}

	@Override
	public void saveStudent(Student student) {
		// write the logic to store the student object into the database
	Object[] sqlParameters=	{student.getName(),student.getMobile(),student.getCountry(),student.getIdno()};
	String sql="insert into students(name,mobile,country,idno) values(?,?,?,?)";
	jdbcTemplate.update(sql, sqlParameters);
	System.out.println("1 record inserted...");
		
	}

	@Override
	public Student getStudent(int id) {
		String sql="SELECT * FROM students WHERE id = ?";
		Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
		return student;
	}

	@Override
	public void update(Student student) {
		
		String sql="UPDATE students set name =?, mobile=?, country=?, idno=? WHERE id =?";
		jdbcTemplate.update(sql, student.getName(),student.getMobile(),student.getCountry(),student.getIdno(),student.getId());
		System.out.println("1 record updated...");
		
		
		
	}

	@Override
	public void deleteStudent(int id) {
		//sql statements are not case sensitive
		String sql="DELETE from students where id=?";
		jdbcTemplate.update(sql, id);
		System.out.println("1 record deleted...");
		
	}

}

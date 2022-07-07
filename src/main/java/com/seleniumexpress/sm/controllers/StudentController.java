package com.seleniumexpress.sm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seleniumexpress.sm.DAO.StudentDAO;
import com.seleniumexpress.sm.api.Student;
import com.seleniumexpress.sm.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;

	@GetMapping("/showStudent")
	public String showStudentList(Model model) {
		// call the service to get the data
		List<Student> studentList = studentService.loadStudents();

//		for (Student tempStudent : studentList) {
//			System.out.println(tempStudent);
//
//		}

		model.addAttribute("students", studentList);
		return "student-list";

	}
	@GetMapping("/showAddStudentPage")
	public String addStudent(Model model) {
		Student student= new Student();
		model.addAttribute("student",student);
		
		return "add-student";

	}
	//@ResponseBody
	@PostMapping("/save-student")
	public String saveStudent(Student student) {
		
		//write the logic to save the data to the database
		
		System.out.println(student);
		//do a condition check
		//if the user does not have an id do an insert
		//if the user has an id do an update
		
		if(student.getId()== 0) 
		{
			//insert a new record
			studentService.saveStudent(student);
		}
		else {
			//update an existing record
			studentService.update(student);
			
		}
		
		//do a service call to save the student
		
		//return "redirect:/thankyou";
		return "redirect:/showStudent";

	}
	@ResponseBody
	@GetMapping("/thankyou")
	public String thankYou() {
		return "Thank you.. Your record has been added to the database";
	}
	@GetMapping("/updateStudent")
	//public String updateStudent(@RequestParam("userId") int id,@ModelAttribute("student") Student student) {
	public String updateStudent(@RequestParam("userId") int id,Model model) {
		//we should give a user object of who clicked on the update button
		System.out.println("Looking for the data of student having id : "+id);
		Student theStudent = studentService.getStudent(id);
		model.addAttribute("student", theStudent);
		return "add-student";

	}
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("userId") int id) {
		//capture the id of the student whom you are trying to delete
		//once captured the id do a service call to dlete the student
		studentService.deteleStudent(id);
		return "redirect:/showStudent";

	}
	
	
	

}

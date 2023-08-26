package com.kamibytes.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kamibytes.main.entity.Student;
import com.kamibytes.main.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository sRepo;
	
	public void addStudent(Student std)
	{
		sRepo.save(std);
	}
	

	public List<Student> listAllStudent() {
		// TODO Auto-generated method stub
	   return sRepo.findAll();
	}
	
	public Student updateStudentInfo(long id)
	{
		return sRepo.findById(id).get();
	}
	
	public void deleteStudent(long id)
	{
		sRepo.deleteById(id);
	}
	
	
}

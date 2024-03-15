package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentService  //CRUD
{
	@Autowired
	private StudentRepository repo;

	public List<Student> listAll()//Retrieve operation
	{
		return repo.findAll();
	}

	public void save(Student student) //Create or Insert
	{
		repo.save(student);
	}

	public Student get(Integer id)//Retrieve on base of id
	{
		return repo.findById(id).get();
	}
	public void delete(Integer id) //Delete operation
	{
		repo.deleteById(id);
	}



}

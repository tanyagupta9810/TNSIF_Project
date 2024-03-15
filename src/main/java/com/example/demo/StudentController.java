package com.example.demo;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.exceptions.StudentNotFound;
@RestController
public class StudentController {
	@Autowired
	private StudentRepository repo;
	@Autowired
	private StudentService service;//reference variable


	//Restful API methods for CRUD operation

	//for retrieval operation
	@GetMapping("/student")
	public List<Student>list()
	{
		return service.listAll();
	}

	//Retrieval on base of id
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> get(@PathVariable Integer id)
	{
		try
		{
			Student student= service.get(id);
			return new ResponseEntity<>(student , HttpStatus.OK);
		}
		catch(StudentNotFound ex)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	//Create or insert
	@PostMapping("/student")
	public void add(@RequestBody Student student)
	{
		service.save(student);
	}

	//update
	@PutMapping("/student/{id}")
	public ResponseEntity<?>update(@RequestBody Student student ,@PathVariable Integer id)
	{
		try {
			Student existstudent=service.get(id);
			service.save(student);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	@DeleteMapping("/student/{id}")
	public void delete(@PathVariable Integer id)
	{
		service.delete(id);
	}
}

package com.example.h2.controller;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.h2.dao.Repository;
import com.example.h2.dto.RequestDto;
import com.example.h2.dto.ResponseDto;

@CrossOrigin(allowedHeaders = "*", origins = "*",methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
@RestController
public class EmployeeController {

	@Autowired
	Repository repository;

	@PostMapping("/Employee")
	public ResponseEntity<ResponseDto> saveEmployee(@RequestBody RequestDto dto) {

		RequestDto requestDto = null;
		requestDto = repository.save(dto);
		ResponseDto responseDto = new ResponseDto("Get call Success", requestDto);
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/get")
	public ResponseEntity<ResponseDto> getEmployee() {
		List<RequestDto> requestDto = null;
		requestDto = repository.findAll();
		ResponseDto responseDto = new ResponseDto("Get call Success", requestDto);
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);

	}

	@GetMapping("/getbydept/{dept}")
	public List<RequestDto> findByDept(@PathVariable String dept) {
		return repository.findBydept(dept);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<ResponseDto> deleteEmployeeById(@PathVariable int id) {
		repository.deleteById(id);
		ResponseDto responseDto = new ResponseDto("Delete id Successfully : ", "Deleted id is" + id);
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);

	}

	@GetMapping("/login")
	public String login(HttpSession session) {
		String trackerId = UUID.randomUUID().toString().replaceAll("-", "");
		session.setAttribute(trackerId, "Sunny");
		String user = (String) session.getAttribute("trackerId");
		return "Welcome, " + user + " " + trackerId;

	}
}

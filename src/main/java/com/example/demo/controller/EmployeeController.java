package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	// accept - xml
	// content-type
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/employees")
	public ResponseEntity<List<EmployeeEntity>> getEmployeeDetails(
			@RequestParam(name = "dob", required = false) @DateTimeFormat(iso = ISO.DATE, pattern = "") LocalDate dob,
			@RequestParam(name = "startdate", required = false) @DateTimeFormat(iso = ISO.DATE) LocalDate startDate,
			@RequestParam(name = "enddate", required = false) @DateTimeFormat(iso = ISO.DATE) LocalDate endDate) {
		List<EmployeeEntity> empModel = empService.getEmployeeDetails(dob);

		// method name
		System.out.println("Method Name Result");
		List<EmployeeEntity> empModel1 = empService.getEmployeesByStartEndDate(startDate, endDate);
		printDetails(empModel1);

		// query method
		// JPQL query method
		System.out.println("Query Method Result");
		List<EmployeeEntity> empModel2 = empService.getEmployeesByStartEndDateQueryMethod(startDate, endDate);
		printDetails(empModel2);

		// native query method
		System.out.println("NATIVE Query Method Result");
		List<EmployeeEntity> empModel3 = empService.getEmployeesByStartEndDateNative(startDate, endDate);
		printDetails(empModel3);

		// named query method
		System.out.println("Named Query Method Result");
		List<EmployeeEntity> empModel4 = empService.getEmployeesByStartEndDateNamedQuery();
		printDetails(empModel4);

		// named native query method
		System.out.println("Named Native Query Method Result");
		List<EmployeeEntity> empModel5 = empService.getEmployeesByStartEndDateNamedNativeQuery();
		printDetails(empModel5);

		// Query DSL method
		System.out.println("Query DSL Method Result");
		long count = empService.getEmployeesBySQueryDsl();

		System.out.println(count);
		
		return ResponseEntity.ok(empModel);
	}

	public void printDetails(List<EmployeeEntity> list) {
		for (EmployeeEntity e : list) {
			System.out.println("ID: " + e.getEmpId());
		}
	}
}

package com.example.demo.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.entity.QEmployeeEntity;
import com.example.demo.predicate.EmployeePredicate;
import com.example.demo.repository.EmployeeRepository;
import com.querydsl.core.types.Predicate;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	@Autowired
	private EmployeePredicate employeePredicate;

	public List<EmployeeEntity> getEmployeeDetails(LocalDate dob) {
		List<EmployeeEntity> empEntityList = empRepo.findByDob(dob);

		return empEntityList;
	}

	public List<EmployeeEntity> getEmployeesByStartEndDate(LocalDate startDate, LocalDate endDate) {
		List<EmployeeEntity> empEntityList = empRepo.findByStartDateAndEndDate(startDate, endDate);

		return empEntityList;
	}

	public List<EmployeeEntity> getEmployeesByStartEndDateQueryMethod(LocalDate startDate, LocalDate endDate) {
		List<EmployeeEntity> empEntityList = empRepo.findByStartDateAndEndDateQueryMethod(startDate, endDate);

		return empEntityList;
	}

	public List<EmployeeEntity> getEmployeesByStartEndDateNative(LocalDate startDate, LocalDate endDate) {
		List<EmployeeEntity> empEntityList = empRepo.findByStartDateAndEndDateNative(startDate, endDate);

		return empEntityList;
	}

	public List<EmployeeEntity> getEmployeesByStartEndDateNamedQuery() {
		List<EmployeeEntity> empEntityList = empRepo.find();

		return empEntityList;
	}

	public List<EmployeeEntity> getEmployeesByStartEndDateNamedNativeQuery() {
		List<EmployeeEntity> empEntityList = empRepo.findByNameNativeExample();

		return empEntityList;
	}

	public long getEmployeesBySQueryDsl() {

		Predicate pred = hasSalary(20000.00);
		long count = empRepo.count(pred);

		return count;
	}

	static Predicate hasSalary(Double salary) {
		return (Predicate) QEmployeeEntity.employeeEntity.salary.gt(salary);
	}

	public List<EmployeeEntity> getEmployeeQueryDSL(HashMap<String, String> map) {

		Predicate predicate = employeePredicate.buildEmployeePredicate(map);
		Iterable<EmployeeEntity> employees = empRepo.findAll(predicate);
		return (List<EmployeeEntity>) employees;
	}

	public void save(EmployeeEntity empData) {
		empRepo.save(empData);
	}

}
